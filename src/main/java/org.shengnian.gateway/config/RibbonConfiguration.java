package org.shengnian.gateway.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ServerList;
import org.springframework.cloud.netflix.ribbon.StaticServerList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by C.C on 2018/2/11
 */
//@Configuration
//public class RibbonConfiguration {

//  @Bean
//  public ServerList<Server> ribbonServerList(IClientConfig config) {
//    Server[] servers = discoveryClient.getInstances(config.getClientName()).stream()
//        .map(i -> new Server(i.getHost(), i.getPort()))
//        .toArray(Server[]::new);
//    config.getClientName();
//    Server [] servers = {
//
//    };

//    return new StaticServerList(servers);
//  }

//}
