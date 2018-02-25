package org.shengnian.gateway.route;

import org.springframework.cloud.netflix.zuul.filters.route.RibbonCommand;
import org.springframework.cloud.netflix.zuul.filters.route.RibbonCommandContext;

/**
 * Created by c on 2018/2/25
 */
public interface ShengCommandFactory <T extends RibbonCommand> {

  T create(RibbonCommandContext context);
}
