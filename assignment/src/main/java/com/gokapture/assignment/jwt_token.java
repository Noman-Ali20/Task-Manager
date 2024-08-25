package com.gokapture.assignment;

import java.security.SecureRandom;
import java.util.Base64;

public class jwt_token {

	public static void main(String[] args) {
		SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[64]; // 64 bytes = 512 bits
        random.nextBytes(bytes);
        String secretKey = Base64.getEncoder().encodeToString(bytes);
        System.out.println("JWT Secret Key: " + secretKey);
	}
}
