package pkg;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.Locale;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.apache.geronimo.mail.util.Hex;

public class SecurityUtils {

  private SecurityUtils() {}

  public static final String ENCODE = "UTF-8";
  public static final String CIPHER_ALGORITHM = "AES/ECB/PKCS7Padding";

  static {
    Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
  }

  /**
   * 初始化HmacSHA256的密钥
   *
   * @return byte[] 密钥
   */
  public static byte[] initAES256Key() throws NoSuchAlgorithmException {

    // 初始化KeyGenerator
    KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
    // 192 and 256 bits also available，这一步是否有安装jce unlimited strength jurisdiction policy files 都不会出现异常
    keyGenerator.init(256);
    // 产生密钥
    SecretKey secretKey = keyGenerator.generateKey();
    // 获取密钥
    return secretKey.getEncoded();
  }
  public static String initAES256KeyString() throws NoSuchAlgorithmException {
      byte[] keyBytes = initAES256Key();
      return byteToHexString(keyBytes);
  }

  public static String byteToHexString(byte[] bytes) {
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < bytes.length; i++) {
      String strHex=Integer.toHexString(bytes[i]);
      if(strHex.length() > 3) {
        sb.append(strHex.substring(6));
      } else {
        if(strHex.length() < 2) {
          sb.append("0" + strHex);
        } else {
          sb.append(strHex);
        }
      }
    }
    return sb.toString();
  }

  /**
   * 初始化HmacSHA256的密钥
   *
   * @return byte[] 密钥
   */
  public static byte[] initHmacSHA256Key() throws NoSuchAlgorithmException {

    // 初始化KeyGenerator
    KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA256");
    keyGenerator.init(256);
    // 产生密钥
    SecretKey secretKey = keyGenerator.generateKey();
    // 获取密钥
    return secretKey.getEncoded();
  }

  /**
   * HmacSHA256消息摘要
   *
   * @param data 待做摘要处理的数据
   * @param key 密钥
   * @return byte[] 消息摘要
   */
  public static byte[] encodeHmacSHA256(byte[] data, byte[] key) {
    // 还原密钥，因为密钥是以byte形式为消息传递算法所拥有
    SecretKey secretKey = new SecretKeySpec(key, "HmacSHA256");
    // 实例化Mac
    Mac mac = null;
    try {
      mac = Mac.getInstance(secretKey.getAlgorithm());
    } catch (NoSuchAlgorithmException e) {
      return null;
    }
    // 初始化Mac
    try {
      mac.init(secretKey);
    } catch (InvalidKeyException e) {
      return null;
    }
    // 执行消息摘要处理
    return mac.doFinal(data);
  }

  /**
   * @param data
   * @param key
   * @return 为Hex大写字符
   * @throws Exception
   */
  public static String encodeHmacSHA256HexUpper(String data, byte[] key) {
    try {
      return AESUtil.bytesToHexString(encodeHmacSHA256(data.getBytes(ENCODE), key)).toUpperCase(Locale.US);
    } catch (Exception e) {
      return null;
    }
  }

  /**
   * @param data to be encrypted
   * @param key password for encryption
   * @return encrypted data
   */
  public static byte[] encrypt(byte[] data, byte[] key) {

    // Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
    try {

      // MessageDigest sha = MessageDigest.getInstance("SHA-256");
      // key = sha.digest(key);
      // key = Arrays.copyOf(key, 32);
      SecretKeySpec secretKey = new SecretKeySpec(key, "AES");

      Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
      cipher.init(Cipher.ENCRYPT_MODE, secretKey);
      // cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key, "AES"));
      return cipher.doFinal(data);
    } catch (Exception e) {
      return null;
    }
  }

  /**
   * @param data to be decrypted
   * @param key password for decryption
   * @return decrypted data
   */
  public static byte[] decrypt(byte[] data, byte[] key) {
    // Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
    try {
      // MessageDigest sha = MessageDigest.getInstance("SHA-256");
      // key = sha.digest(key);
      // key = Arrays.copyOf(key, 32);
      SecretKeySpec secretKey = new SecretKeySpec(key, "AES");

      Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
      cipher.init(Cipher.DECRYPT_MODE, secretKey);
      // cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key, "AES"));
      return cipher.doFinal(data);
    } catch (Exception e) {
      return null;
    }
  }

  /**
   * @param @return 为Hex大写字符 @throws
   */
  public static String encodeHexUpper(byte[] data) {
    return AESUtil.bytesToHexString(data).toUpperCase(Locale.US);
  }

  /**
   * @param str 为Hex大写字符 @return 正常字符 @throws
   */
  public static byte[] decodeHexUpper(String str) {

    return Hex.decode(str.toLowerCase(Locale.US));
  }

  /**
   * @param str 为Hex大写字符 @return 正常字符 @throws
   */
  public static String decodeHexUpper(String str, String charsetName) {
    try {
      return new String(Hex.decode(str.toLowerCase(Locale.US)), charsetName);
    } catch (Exception e) {
      return null;
    }

  }

  /**
   * @param data 普通字符
   * @param key
   * @return 为Hex大写字符
   * @throws Exception
   */
  public static String encodeAES256HexUpper(String data, byte[] key) {
    try {
      return encodeHexUpper(encrypt(data.getBytes(ENCODE), key));
    } catch (Exception e) {
      return null;
    }
  }

  /**
   * @param data 为Hex大写字符
   * @param key
   * @return 普通字符
   * @throws Exception
   */
  public static String decodeAES256HexUpper(String data, byte[] key) {
    try {
      return new String(decrypt(Hex.decode(data.toLowerCase(Locale.US)), key), ENCODE);
    } catch (Exception e) {
      return null;
    }
  }

}
