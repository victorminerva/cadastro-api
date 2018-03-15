package br.com.minervait.spring.utils;

import java.security.Key;

import javax.crypto.spec.SecretKeySpec;

public class KeyGenerator {

	public Key generateKey() {
		String key = "Y2FkYXN0cm9hcGk=";
		Key keySecret = new SecretKeySpec(key.getBytes(), 0, key.getBytes().length, "HmacSHA256");
		return keySecret;
	}

}
