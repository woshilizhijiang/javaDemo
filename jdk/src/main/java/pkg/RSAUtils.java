/*
package pkg;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import java.io.ByteArrayOutputStream;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

public class RSAUtils {


    */
/**
     * 加密算法RSA
     *//*

    public static final String KEY_ALGORITHM = "RSA";


    public static final String RSA_ALGORITHM = "RSA/None/PKCS1Padding";

    */
/**
     * 签名算法
     *//*

    public static final String SIGNATURE_ALGORITHM = "MD5withRSA";

    */
/**
     * 获取公钥的key
     *//*

    private static final String PUBLIC_KEY = "RSAPublicKey";

    */
/**
     * 获取私钥的key
     *//*

    private static final String PRIVATE_KEY = "RSAPrivateKey";

    */
/**
     * RSA最大加密明文大小
     *//*

    private static final int MAX_ENCRYPT_BLOCK = 64;

    */
/**
     * RSA最大解密密文大小
     *//*

    private static final int MAX_DECRYPT_BLOCK = 75;

    */
/**
     * RSA密钥长度
     *//*

    private static final int INITIAL_KEY_SIZE = 600;

    static{
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
    }

    */
/**
     * <p>
     * 生成密钥对(公钥和私钥)
     * </p>
     *
     * @return
     * @throws Exception
     *//*

    public static Map<String, Object> genKeyPair()  {
        KeyPairGenerator keyPairGen=null;
        try {
             keyPairGen = KeyPairGenerator.getInstance(KEY_ALGORITHM, new BouncyCastleProvider());
        }catch(Exception e){
            return null;
        }
        keyPairGen.initialize(INITIAL_KEY_SIZE);
        KeyPair keyPair = keyPairGen.generateKeyPair();
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        Map<String, Object> keyMap = new HashMap<String, Object>(2);
        keyMap.put(PUBLIC_KEY, publicKey);
        keyMap.put(PRIVATE_KEY, privateKey);
        return keyMap;
    }

    */
/**
     * <p>
     * 用私钥对信息生成数字签名
     * </p>
     *
     * @param data 已加密数据
     * @param privateKey 私钥(BASE64编码)
     *
     * @return
     * @throws Exception
     *//*

    public static String sign(byte[] data, String privateKey)  {
        try{
            byte[] keyBytes = Base64Utils.decode(privateKey);
            PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
            PrivateKey privateK = keyFactory.generatePrivate(pkcs8KeySpec);
            Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
            signature.initSign(privateK);
            signature.update(data);
            return Base64Utils.encode(signature.sign());
        }catch(Exception e){
            return null;
        }
    }

    */
/**
     * <p>
     * 校验数字签名
     * </p>
     *
     * @param data 已加密数据
     * @param publicKey 公钥(BASE64编码)
     * @param sign 数字签名
     *
     * @return
     * @throws Exception
     *
     *//*

    public static boolean verify(byte[] data, String publicKey, String sign)
    {
        try{
            byte[] keyBytes = Base64Utils.decode(publicKey);
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
            PublicKey publicK = keyFactory.generatePublic(keySpec);
            Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
            signature.initVerify(publicK);
            signature.update(data);
            return signature.verify(Base64Utils.decode(sign));

        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    */
/**
     * <P>
     * 私钥解密
     * </p>
     *
     * @param
     * @param privateKey 私钥(BASE64编码)
     * @return
     * @throws Exception
     *//*

    public static String decryptByPrivateKey(String encrypted, String privateKey)
             {
        try
        {
            byte[] encryptedData = Base64Utils.decode(encrypted);
            byte[] keyBytes = Base64Utils.decode(privateKey);
            PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM, "BC");
            Key privateK = keyFactory.generatePrivate(pkcs8KeySpec);
            Cipher cipher = Cipher.getInstance(RSA_ALGORITHM, "BC");
            cipher.init(Cipher.DECRYPT_MODE, privateK);
            // int blockSize = cipher.getBlockSize();
            int inputLen = encryptedData.length;
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            int offSet = 0;
            byte[] cache;
            int i = 0;
            // 对数据分段解密
            while (inputLen - offSet > 0) {
                if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
                    cache = cipher.doFinal(encryptedData, offSet, MAX_DECRYPT_BLOCK);
                } else {
                    cache = cipher.doFinal(encryptedData, offSet, inputLen - offSet);
                }
                out.write(cache, 0, cache.length);
                i++;
                offSet = i * MAX_DECRYPT_BLOCK;
            }
            byte[] decryptedData = out.toByteArray();
            out.close();
            return new String(decryptedData);
        }catch(Exception e){
            return null;
        }
    }

    */
/**
     * <p>
     * 公钥解密
     * </p>
     *
     * @param encrypted 已加密数据
     * @param publicKey 公钥(BASE64编码)
     * @return
     * @throws Exception
     *//*

    public static String decryptByPublicKey(String encrypted, String publicKey)
           {
         try{
                byte[] encryptedData = Base64Utils.decode(encrypted);
                byte[] keyBytes = Base64Utils.decode(publicKey);
                X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
                KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM, "BC");
                Key publicK = keyFactory.generatePublic(x509KeySpec);
                Cipher cipher = Cipher.getInstance(RSA_ALGORITHM, "BC");
                cipher.init(Cipher.DECRYPT_MODE, publicK);
                //int blockSize = cipher.getBlockSize();
                int inputLen = encryptedData.length;
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                int offSet = 0;
                byte[] cache;
                int i = 0;
                // 对数据分段解密
                while (inputLen - offSet > 0) {
                    if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
                        cache = cipher.doFinal(encryptedData, offSet, MAX_DECRYPT_BLOCK);
                    } else {
                        cache = cipher.doFinal(encryptedData, offSet, inputLen - offSet);
                    }
                    out.write(cache, 0, cache.length);
                    i++;
                    offSet = i * MAX_DECRYPT_BLOCK;
                }
                byte[] decryptedData = out.toByteArray();
                out.close();
                return new String(decryptedData);
         }catch(Exception e){
             return null;
         }
    }

    */
/**
     * <p>
     * 公钥加密
     * </p>
     *
     * @param source 源数据
     * @param publicKey 公钥(BASE64编码)
     * @return
     * @throws Exception
     *//*

    public static String encryptByPublicKey(String source, String publicKey)
          {
         try{
                byte[] data = source.getBytes();
                byte[] keyBytes = Base64Utils.decode(publicKey);
                X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
                KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM, "BC");
                Key publicK = keyFactory.generatePublic(x509KeySpec);
                // 对数据加密
                Cipher cipher = Cipher.getInstance(RSA_ALGORITHM,  "BC");
                cipher.init(Cipher.ENCRYPT_MODE, publicK);
                int inputLen = data.length;
                //int blockSize = cipher.getBlockSize();
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                int offSet = 0;
                byte[] cache;
                int i = 0;
                // 对数据分段加密
                while (inputLen - offSet > 0) {
                    if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
                        cache = cipher.doFinal(data, offSet, MAX_ENCRYPT_BLOCK);
                    } else {
                        cache = cipher.doFinal(data, offSet, inputLen - offSet);
                    }
                    out.write(cache, 0, cache.length);
                    i++;
                    offSet = i * MAX_ENCRYPT_BLOCK;
                }
                byte[] encryptedData = out.toByteArray();
                out.close();
                return Base64Utils.encode(encryptedData);
         }catch(Exception e){
             return null;
         }
    }

    */
/**
     * <p>
     * 私钥加密
     * </p>
     *
     * @param source 源数据
     * @param privateKey 私钥(BASE64编码)
     * @return
     * @throws Exception
     *//*

    public static String encryptByPrivateKey(String source, String privateKey)
    {
        try{
            byte[] data = source.getBytes();
            byte[] keyBytes = Base64Utils.decode(privateKey);
            PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM, "BC");
            Key privateK = keyFactory.generatePrivate(pkcs8KeySpec);
            Cipher cipher = Cipher.getInstance(RSA_ALGORITHM,  "BC");
            cipher.init(Cipher.ENCRYPT_MODE, privateK);
            int inputLen = data.length;
            //int blockSize = cipher.getBlockSize();
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            int offSet = 0;
            byte[] cache;
            int i = 0;
            // 对数据分段加密
            while (inputLen - offSet > 0) {
                if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
                    cache = cipher.doFinal(data, offSet, MAX_ENCRYPT_BLOCK);
                } else {
                    cache = cipher.doFinal(data, offSet, inputLen - offSet);
                }
                out.write(cache, 0, cache.length);
                i++;
                offSet = i * MAX_ENCRYPT_BLOCK;
            }
            byte[] encryptedData = out.toByteArray();
            out.close();
            return Base64Utils.encode(encryptedData);
        }catch(Exception e){
            return null;
        }
    }

    */
/**
     * <p>
     * 获取私钥
     * </p>
     *
     * @param keyMap 密钥对
     * @return
     * @throws Exception
     *//*

    public static String getPrivateKey(Map<String, Object> keyMap)
          {
         try {
             Key key = (Key) keyMap.get(PRIVATE_KEY);
             return Base64Utils.encode(key.getEncoded());
         }catch (Exception e){
             return null;
         }
    }

    */
/**
     * <p>
     * 获取公钥
     * </p>
     *
     * @param keyMap 密钥对
     * @return
     * @throws Exception
     *//*

    public static String getPublicKey(Map<String, Object> keyMap) {
        try {
        Key key = (Key) keyMap.get(PUBLIC_KEY);
        return Base64Utils.encode(key.getEncoded());
        }catch (Exception e){
            return null;
        }
    }


    public static void main(String[] args) throws Exception {
//		Map<String, Object> keyMap = genKeyPair();
//		String privateKey = getPrivateKey(keyMap);
//		String publicKey = getPublicKey(keyMap);
//		System.out.println("privateKey=" + privateKey);
//		System.out.println("publicKey=" + publicKey);
//
//		String md5String = "亚信科技能力开放平台V1.0";
//		md5String = MD5Util.MD5(MD5_String);
//		System.out.println("MD5加密后：" + md5String);
//
//		String encrypt = RSAUtils.encryptByPrivateKey(md5String, privateKey);
//		System.out.println("RSA加密后：" + encrypt);
//		String decrypt = RSAUtils.decryptByPublicKey(encrypt, publicKey);
//		System.out.println("RSA解密后：" + decrypt);

        //String md5 = "da479c917895dda79d52ea6a94d374d8";
        //String privateKey = "MIIBhQIBADANBgkqhkiG9w0BAQEFAASCAW8wggFrAgEAAkwArZB09ZnrnuXSQHhYLyRlMtML5P8W63PzhUnl13KlOs/2Ipzhx4qUXyckvRSBX+772uU4H6hD9gIxhCUcKfib9UP4tTAZDsTi02xDAgMBAAECS0ut0VHF65c9Xo/96XWkyPuASo9vKu8/f89+iVmIA8PBKfGttkTgB5f9jZ+L69OpdAy9pJnbIr3JKUcqTT7zp9qIt5Z2luWywU06AQImDdAjGDKBO7O6D3cvMI40aSmWYJ/OBYVbv3ibsUXqt3Kx5EnGRcsCJgyQtGpYUNT5g0gV0NCaOl70Ty8feAbAk7vM7xGIXtdrV1gUCORpAiYGlnWmXK/14Umjhpwi9C9a2FK30n9XcrrHHqZibY3739+nmOfO8QImAmie3R/u5tSp0OC1tbdK5zboEv1yUcEK0N5ZGcBNhfgCt1Sn27kCJgnpEN5eEMl3vp7pK8USs7Yu2r1KYHYx+drkztrPJOc2kEp8fPhV";
        //System.out.println(RSAUtils.encryptByPrivateKey(md5, privateKey));
        //               GC0ZUSvvIESKS+VZTlM7bOxfhamHH28AY98lZUrl+ytVRGLCTKnDcEYiuoR4kZ4p4gQUaKslo9emIESbd6d6iO48/oVsje0pb8Qo
        //System.out.println(RSAUtils.encryptByPublicKey(md5, "MGcwDQYJKoZIhvcNAQEBBQADVgAwUwJMAI03vjlUCmW+J8PwlvA/DnmKs0CtCeMeHvcNF2NiQK3/PEQ7DDehE/PR7W/ax5QknZzsEoMVWgMpqZWNcQSpSypUz95/Yvd+2phdGwIDAQAB"));
        //String sign = "GC0ZUSvvIESKS+VZTlM7bOxfhamHH28AY98lZUrl+ytVRGLCTKnDcEYiuoR4kZ4p4gQUaKslo9emIESbd6d6iO48/oVsje0pb8Qo";
        //System.out.println(RSAUtils.decryptByPublicKey(sign, "MGcwDQYJKoZIhvcNAQEBBQADVgAwUwJMAI03vjlUCmW+J8PwlvA/DnmKs0CtCeMeHvcNF2NiQK3/PEQ7DDehE/PR7W/ax5QknZzsEoMVWgMpqZWNcQSpSypUz95/Yvd+2phdGwIDAQAB"));
        //String privateKey = "MIIBhQIBADANBgkqhkiG9w0BAQEFAASCAW8wggFrAgEAAkwAjTe+OVQKZb4nw/CW8D8OeYqzQK0J4x4e9w0XY2JArf88RDsMN6ET89Htb9rHlCSdnOwSgxVaAymplY1xBKlLKlTP3n9i937amF0bAgMBAAECS3uNiM3pnIs12t7Q0Y5y7PwkAP8WJi9ivB7UgmD+pq5VQGpF60NvymwFqD6ZqGHG123hvn5w06ddrKe1v79OqBCM6NBLyRjr/7w6uQImDDj5od1mGqCpnP2tMYyXs+1PlK2X3cpDSMvPsO+StYUNce6WezcCJguNydJSNlywJRitOXv4qk1R2+fLh5f7azPTpW2TPUMkvkBn1Yc9AiYLncKy8cZunC9Xg0kthF9Ro8M0nN9u7SKRdxLHKIoYdoHWvFjMdQImAqA8IXgb8N7732rnaLywgBg9waXpcGptB/9vVsMjJlKAhwTSbAUCJgvcAmxAgsorx8qXakuMGpqwcNvqJX29Vy4VGoUG4NiLIbMBV0hr";
        //System.out.println(RSAUtils.encryptByPrivateKey(sign, privateKey));

    	*/
/*String s = "{\"User\":{\"CertId\":\"12223\",\"UserName\":\"wusir\"},\"BillId\":\"13912975757\",\"RegionId\":\"1\",\"OfferList\":[{\"OfferCode\":\"1\",\"OfferValue\":\"1\"},{\"OfferCode\":\"2\",\"OfferValue\":\"2\"}]}";
    	String publicKey = "MGcwDQYJKoZIhvcNAQEBBQADVgAwUwJMAKV8zS3MIrJKbPMyFer9G6AgygPoeDWSdzKAikFK5ipoXeFXyXfQ5Fh6Zpo3Qz382dzyHYWR64mfPqRVIItBSbuWcwt2a8qsXT2bZwIDAQAB";
    	System.out.println(encryptByPublicKey(s, publicKey));

    	s = "IkFk1AJkJiqXSReyTpIX+cNh652+dVdnEUoeFPxKvOGVOv+sYRgBvujMqmX+6JdJXZuLgVzm/x8RrAX1faLlHhyVZ9s7ygsPS86w";
		String key = "MGcwDQYJKoZIhvcNAQEBBQADVgAwUwJMAJHCBuhFPRbwimst6n3OrisXvKz+RqcCI5pMuzyxOqbAxkO2F4DLFpw50L3Zv13kjIx4EZzNjO9yQ71U2v54h8Gmdd0as+3+BUh4gQIDAQAB";
		System.out.println(decryptByPublicKey(s, key));*//*

        String publicKey = "MGcwDQYJKoZIhvcNAQEBBQADVgAwUwJMAPDd8+uXERCPzaQHox1NXv/hts8USnUY5VMKUJoWBhzXb/XapNXJlvwnQ3HGUP/RAKiwIxMjFQotYhBlNY9Lt01kkfe6FD0eU/cmmQIDAQAB";
        String privateKey = "MIIBbAIBAAJMAPDd8+uXERCPzaQHox1NXv/hts8USnUY5VMKUJoWBhzXb/XapNXJlvwnQ3HGUP/RAKiwIxMjFQotYhBlNY9Lt01kkfe6FD0eU/cmmQIDAQABAkwAgEZT3sWHCwDqjU6b6cEItNEqIEI4HQBzMLQvlL/h5X4+W/pjCn9XjsoeD3+ovM7Cprm3ghllZLxWofKdZbxNIZZ6cY3EAsi85+x5AiYPlkow+YZQeJx/OKafXMhq+F949HwYuiRroPtLKtuap6IdQ5HzdwImD3P34UaMbrMM3/pm7mqjJCSaJQ0ylvq31aLTz6TAYJNJChLPmm8CJgWsAsNfiWiu+wOwcbF76dJDHzq8fIvi8G3Z3pezuMXGSk+rzuhxAiYKUG5QF8WeEbZzPPA9DEIt2pxkRKXSri/L0W2s95tMGqKyrZGR0wImATP6rJW3AJu0+09uX7W264brI//o5vO4+IONFDHpCAKI7YJBJ5Y=";
        String encrypted = RSAUtils.encryptByPublicKey("", publicKey);
        System.out.println(encrypted);
        System.out.println(RSAUtils.decryptByPrivateKey(encrypted, privateKey));
    }

}
*/
