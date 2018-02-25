package org.shengnian.gateway.route;

import org.springframework.http.client.ClientHttpResponse;

/**
 * Created by c on 2018/2/25
 */
public interface FallbackProvider {

  /**
   * The route this fallback will be used for.
   * @return The route the fallback will be used for.
   */
  public String getRoute();

  /**
   * Provides a fallback response.
   * @return The fallback response.
   */
  public ClientHttpResponse fallbackResponse();

  /**
   * Provides a fallback response based on the cause of the failed execution.
   *
   * @param cause cause of the main method failure
   * @return the fallback response
   */
  ClientHttpResponse fallbackResponse(Throwable cause);
}
