package com.atguigu.myRule;

import java.util.List;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
/**
 * Ribbon轮询策略，每个轮询五次
 * @author Administrator
 *
 */
public class RoundRobinRuleFive extends AbstractLoadBalancerRule {

	// 总共被调用的次数，目前要求每台被调用5次
	private int total = 0;
	// 当前提供服务的机器号
	private int currentIndex = 0;
	public Server choose(ILoadBalancer lb, Object key) {
		if (lb == null) {
			return null;
		}
		Server server = null;
		int count = 0;
		while (server == null && count++ < 10) {
			List<Server> upList = lb.getReachableServers();
			List<Server> allServers = lb.getAllServers();
			int upCount = upList.size();
			int serverCount = allServers.size();
			if ((upCount == 0) || (serverCount == 0)) {
				return null;
			}
			
		//=========================================================
			if (total < 5) {
				server = upList.get(currentIndex);
				total++;
			} else {
				total = 0;
				currentIndex++;
				if (currentIndex >= upList.size()) {
					currentIndex = 0;
				}
			}
		//===========================================================
			if (server == null) {
				/* Transient. */
				Thread.yield();
				continue;
			}
 
			if (server.isAlive() && (server.isReadyToServe())) {
				return (server);
			}
			server = null;
		}
		return server;
	}
	@Override
	public Server choose(Object key) {
		return choose(getLoadBalancer(), key);
	}
 
	@Override
	public void initWithNiwsConfig(IClientConfig arg0) {
 
	}

}
