package org.shengnian.gateway;

import org.shengnian.gateway.route.ShengRoutingFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.ProxyRequestHelper;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;

@EnableHystrix
@EnableCircuitBreaker
@EnableHystrixDashboard
@RibbonClients
@EnableZuulProxy
@SpringBootApplication
public class ZuulMain {

  public static void main(String[] args) {
    SpringApplication.run(ZuulMain.class, args);
  }

  @Bean
  public ShengRoutingFilter shengRoutingFilter(ProxyRequestHelper helper, ZuulProperties zuulProperties) {
    return new ShengRoutingFilter(helper, zuulProperties);
  }
}
