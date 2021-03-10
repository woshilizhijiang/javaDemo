package pkg;

import java.io.UnsupportedEncodingException;
import pkg.AESUtil.CipherMode;
import pkg.AESUtil.PaddingMode;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.NoSuchPaddingException;


public class AESFactory {
	private static Map<String, AESUtil> tools = new HashMap<String, AESUtil>();
	
	private AESFactory(){}
	
	public static AESUtil createAesGenerator(CipherMode cipherMode, PaddingMode paddingMode, String key, String iv, boolean simple)
			throws NoSuchAlgorithmException, NoSuchPaddingException, UnsupportedEncodingException {
		String toolKey = AESUtil.getAlogrithm() + "/" + (cipherMode == null ? "" : cipherMode.getCode()) + 
        		"/" + (paddingMode == null ? "" : paddingMode.getPadding()) + "/" + key + "/" + iv;
		
		if (tools.containsKey(toolKey)) {
			return tools.get(toolKey);
		}
		
		AESUtil generator = new AESUtil(cipherMode, paddingMode, key, iv, simple);
		tools.put(toolKey, generator);
		
		return generator;
	}
	
	public static AESUtil createAesGenerator(CipherMode cipherMode, PaddingMode paddingMode, String key, String iv) 
			throws NoSuchAlgorithmException, NoSuchPaddingException, UnsupportedEncodingException {
		return createAesGenerator(cipherMode, paddingMode, key, iv, false);
	}
	
	public static AESUtil createXxxAesGenerator(String key, String iv) 
			throws NoSuchAlgorithmException, NoSuchPaddingException, UnsupportedEncodingException {
		return createAesGenerator(CipherMode.CBC, PaddingMode.Nopadding, key, iv);
	}
	
	public static AESUtil createSimpleAesGenerator(String key) 
			throws NoSuchAlgorithmException, NoSuchPaddingException, UnsupportedEncodingException {
		return createAesGenerator(null, null, key, null, true);
	}
}