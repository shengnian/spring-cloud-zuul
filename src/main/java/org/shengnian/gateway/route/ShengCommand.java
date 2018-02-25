package org.shengnian.gateway.route;

import com.netflix.hystrix.HystrixExecutable;
import org.springframework.http.client.ClientHttpResponse;

/**
 * Created by c on 2018/2/25
 */
public interface ShengCommand extends HystrixExecutable<ClientHttpResponse> {

}
