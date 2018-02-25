package org.shengnian.gateway.route.support;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.shengnian.gateway.route.FallbackProvider;
import org.shengnian.gateway.route.ShengCommandFactory;

/**
 * Created by c on 2018/2/25
 */
public abstract class AbstractShengnianCommandFactory implements ShengCommandFactory {

  private Map<String, FallbackProvider> fallbackProviderCache;
  private FallbackProvider defaultFallbackProvider = null;

  public AbstractShengnianCommandFactory(Set<FallbackProvider> fallbackProviders) {
    this.fallbackProviderCache = new HashMap<>();
    for (FallbackProvider fallbackProvider : fallbackProviders) {
      String route = fallbackProvider.getRoute();
      if("*".equals(route) || route == null) {
        defaultFallbackProvider = fallbackProvider;
      } else {
        fallbackProviderCache.put(route, fallbackProvider);
      }
    }
  }

  protected FallbackProvider getFallbackProvider(String route) {
    FallbackProvider provider = fallbackProviderCache.get(route);
    if(provider == null) {
      provider = defaultFallbackProvider;
    }
    return provider;
  }

}
