package demo.dao;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public class MD5 {
	public String EncoderMyMd5(String str)throws NoSuchAlgorithmException,UnsupportedEncodingException{
		MessageDigest md5 = MessageDigest.getInstance("MD5");//关键字加密法
		BASE64Encoder base64en = new BASE64Encoder();//使用BASE64格式进行编码
		String newstr = base64en.encode(md5.digest(str.getBytes("utf-8")));
	
		return newstr;
	}
}
