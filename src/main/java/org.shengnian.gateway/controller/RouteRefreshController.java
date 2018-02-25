package org.shengnian.gateway.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.RoutesRefreshedEvent;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties.ZuulRoute;
import org.springframework.cloud.netflix.zuul.web.ZuulHandlerMapping;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Supported refresh and watch route api
 * https://ip:port/refresh-routes to reload gateway-node zuul properties
 * https://ip:port/watch-routes to get the zuul route active patterns.
 *
 * Created by C.C on 2018/1/23
 */
@RestController
@RequestMapping("/route")
public class RouteRefreshController {

//  @Autowired
//  RefreshRouteService refreshRouteService;
  @Autowired
  ZuulHandlerMapping zuulHandlerMapping;

  @Autowired
  private ZuulProperties zuulProperties;

  @Autowired
  ApplicationEventPublisher publisher;

  @Autowired
  RouteLocator routeLocator;

  /**
   * Refresh routes api
   *
   * @return Responsedata.ok();
   */
  @GetMapping("/refresh")
  public ResponseEntity refresh() {
    RoutesRefreshedEvent routesRefreshedEvent = new RoutesRefreshedEvent(routeLocator);
    publisher.publishEvent(routesRefreshedEvent);

    return new ResponseEntity(HttpStatus.OK);
  }
}
