package br.com.test.vreal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableCaching
@CacheConfig(cacheNames="property")
public class VRealApplication {

	public static void main(String[] args) {
		SpringApplication.run(VRealApplication.class, args);
	}
}
