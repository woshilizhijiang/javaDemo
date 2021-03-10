package pkg;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.NoSuchPaddingException;

import pkg.AESUtil.CipherMode;
import pkg.AESUtil.PaddingMode;

public class AES {


	public static String encrypt(final String source,String key) {
		if (source==null)return null;
		AESUtil a;
		String encryptStr = null;
		try {
			a = AESFactory.createAesGenerator(CipherMode.CBC, PaddingMode.Nopadding, key, key);
			encryptStr = a.encrypt(source);
		} catch (NoSuchAlgorithmException e) {
		} catch (NoSuchPaddingException e) {
		} catch (UnsupportedEncodingException e) {
		}
		return encryptStr;
	}


	public static String decrypt(final String source,String key) {
		if(source==null)return null;
		AESUtil a;
		String decryptStr = null;
		try {
			a = AESFactory.createAesGenerator(CipherMode.CBC, PaddingMode.Nopadding, key, key);
			decryptStr = a.decrypt(source);
		} catch (NoSuchAlgorithmException e) {
		} catch (NoSuchPaddingException e) {
		} catch (UnsupportedEncodingException e) {
		}

		return decryptStr==null?null:decryptStr.trim();
	}

}
