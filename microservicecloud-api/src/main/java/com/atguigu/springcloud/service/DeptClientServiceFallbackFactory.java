package com.atguigu.springcloud.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.atguigu.springcloud.entitys.Dept;

import feign.hystrix.FallbackFactory;

@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService>{

	@Override
	public DeptClientService create(Throwable cause) {
		
		return new DeptClientService() {
			
			@Override
			public List<Dept> list() {
				return null;
			}
			
			@Override
			public Dept get(long id) {
				return new Dept().setDeptno(id).setDname("没有该ID相关内容")
						.setDb_source("没有数据库信息");
			}
			
			@Override
			public boolean add(Dept dept) {
				return false;
			}
		};
	}

}
