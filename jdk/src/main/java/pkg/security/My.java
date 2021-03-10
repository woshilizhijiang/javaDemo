package pkg.security;

import org.apache.commons.codec.binary.Hex;
import org.junit.Test;
import org.springframework.util.DigestUtils;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class My {

    @Test
    public void  getMD5Str() {
        //JDK自带MessageDigest
//        String str = "123456";
//        byte[] digest = null;
//        try {
//            MessageDigest md5 = MessageDigest.getInstance("md5");
//            digest = md5.digest(str.getBytes("utf-8"));
//            //16进制 32
//            String md5Str = new BigInteger(1,digest).toString(16);
//            System.out.println(md5Str);
//        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }

        //Spring封装 JDK MessageDigest
//        String salt = getMD5StrSalt();
//        System.out.println(salt);
//        String md5Spring = DigestUtils.md5DigestAsHex(("123456" + salt).getBytes());
//        String md5Spring = DigestUtils.md5DigestAsHex("123456".getBytes());
//        System.out.println(md5Spring);
        byte[] md5Bytes = DigestUtils.md5Digest("123456".getBytes());
        System.out.println(new BigInteger(1,md5Bytes).toString(16));
        String aa = new String(new Hex().encode(md5Bytes));
        System.out.println(aa);

    }
    public String  getMD5StrSalt() {
        Random r = new Random();
        StringBuilder sb = new StringBuilder(16);
        sb.append(r.nextInt(99999999)).append(r.nextInt(99999999));
        int len = sb.length();
        if (len < 16) {
            for (int i = 0; i < 16 - len; i++) {
                sb.append("0");
            }
        }
        String salt = sb.toString();
        return salt;
    }



    @Test
    public void apacheCommonsLang3Md5(){
        String str = "123456";
        String salt = getMD5StrSalt();
        //security + salt
        String encodeStr = org.apache.commons.codec.digest.DigestUtils.md5Hex(str + salt);
        System.out.println(encodeStr);
    }


    @Test
    public void SHASalt(){
        String str = "LIYUANXIN";
        String salt = "";
        byte[] encrypt = org.apache.commons.codec.digest.DigestUtils.sha256(str);
        System.out.println(encrypt);
    }

}
