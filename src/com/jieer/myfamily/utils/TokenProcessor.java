package com.jieer.myfamily.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import sun.misc.BASE64Encoder;

public class TokenProcessor// 令牌
{
	private static class SingleInstanceHolder {
		private static final TokenProcessor instance = new TokenProcessor();
	}

	private TokenProcessor() {
	}

	public static TokenProcessor getInstance() {
		return SingleInstanceHolder.instance;
	}

	public String generateToken() {
		String token = System.currentTimeMillis() + new Random().nextInt() + "";

		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("md5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] md5 = md.digest(token.getBytes());

		return new BASE64Encoder().encode(md5);
	}
}