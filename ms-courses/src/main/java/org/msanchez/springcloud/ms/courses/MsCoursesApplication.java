package org.msanchez.springcloud.ms.courses;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsCoursesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsCoursesApplication.class, args);
	}

}
