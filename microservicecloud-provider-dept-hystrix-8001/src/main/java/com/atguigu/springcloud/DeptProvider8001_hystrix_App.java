package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient   //本服务启动后会自动注册进eureka服务中
@EnableCircuitBreaker //对hystrix熔断的开启支持
public class DeptProvider8001_hystrix_App {
	
	public static void main(String[] args) {
		SpringApplication.run(DeptProvider8001_hystrix_App.class, args);
	}

}
