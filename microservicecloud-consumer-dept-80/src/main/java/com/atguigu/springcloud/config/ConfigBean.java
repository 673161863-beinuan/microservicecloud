package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
@Configuration
public class ConfigBean {

	/**
	 * 将RestTemplate添加到容器中
	 * @return
	 */
	@Bean
	@LoadBalanced
	public RestTemplate geRestTemplate(){
		return new RestTemplate();
	}
	
	//@Bean
	public IRule myRule(){
		//return new RandomRule();      //随机
		return new RoundRobinRule();	//轮训(默认)
		//return new RetryRule();		//尝试宕机的服务几次后就不再会再去访问宕机的服务
		//return new BestAvailableRule(); //过滤掉犹豫访问次数太多而跳闸的服务，选择一个并发量最小的服务
		//return new MyselfRule();		//每个服务轮训五次
	}
	
}
