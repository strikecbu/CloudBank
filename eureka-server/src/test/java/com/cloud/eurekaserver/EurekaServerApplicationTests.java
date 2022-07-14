package com.cloud.eurekaserver;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.charset.Charset;
import java.util.Base64;


class EurekaServerApplicationTests {

	@Test
	void contextLoads() {
		byte[] decode = Base64.getDecoder()
				.decode("Z2hwXzNiUVl4VUZCNGw1NWczdFhaSzNDYklhWE1QVUx0dTJGbVFKbQ==");
		System.out.println(new String(decode, Charset.defaultCharset()));
	}

}
