package demo.dao;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public class MD5 {
	public String EncoderMyMd5(String str)throws NoSuchAlgorithmException,UnsupportedEncodingException{
		MessageDigest md5 = MessageDigest.getInstance("MD5");//�ؼ��ּ��ܷ�
		BASE64Encoder base64en = new BASE64Encoder();//ʹ��BASE64��ʽ���б���
		String newstr = base64en.encode(md5.digest(str.getBytes("utf-8")));
	
		return newstr;
	}
}
