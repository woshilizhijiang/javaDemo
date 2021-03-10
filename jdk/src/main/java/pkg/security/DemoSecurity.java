package pkg.security;


import org.junit.Test;
import pkg.*;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class DemoSecurity {

    @Test
    public void SHA(){
        Map<String, Object> keyPair = RSAUtils.genKeyPair();
        String publicKey = RSAUtils.getPublicKey(keyPair); //加密
        String privateKey = RSAUtils.getPrivateKey(keyPair);//解密

        String accessKeyId = "LTAI4GACDMcjaYhTc9jthznd";
        String accessKeySecret = "jTE3qVdkWYsOdbBctOBQseJFWPJPkM";
        String encryptStr = RSAUtils.encryptByPublicKey(accessKeySecret, publicKey);
        System.out.println(encryptStr);
        String decryptStr = RSAUtils.decryptByPrivateKey(encryptStr, privateKey);
        System.out.println("解密是否成功 ： " + accessKeySecret.equals(decryptStr));
    }

    @Test
    public void AES() throws NoSuchAlgorithmException {
        String accessKeyId = "LTAI4GACDMcjaYhTc9jthznd";
        String accessKeySecret = "jTE3qVdkWYsOdbBctOBQseJFWPJPkM";
        String keyString = SecurityUtils.initAES256KeyString();
        System.out.println(keyString);
        //1eac181dd8da0babc647ebdbaac2b90b8d99bdb970b7deb25979c6c40bd891a8
        //42de4c866a35242542eb1d8993c5effea3b646c1d7ad342bf65d3dcf16c95e18
        //0749e1c085239bc16650267a9160c9b09a42175a72c65a9805fdd331cef50e27
        String encrypt =  AES.encrypt(accessKeySecret,keyString);
        System.out.println(encrypt);
        //b7508ad3b6f85f8360783d7e97b8053abd5a26a996e3a31504e11047bb29bb81
        //a6f7e16f094fe68944c134d874d02a112b60cd4c4ec7b3e44de8058fc9324c65
        //23bc3beb7fd70cc111043a1c3b1f5c1a0ab2686f2ad368e1efea5f61c6050949
        String decrypt = AES.decrypt(encrypt, keyString);
        System.out.println(decrypt); //jTE3qVdkWYsOdbBctOBQseJFWPJPkM
        System.out.println(decrypt.equals(accessKeySecret));
    }
}
