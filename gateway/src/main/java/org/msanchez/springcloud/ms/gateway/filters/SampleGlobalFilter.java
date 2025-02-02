package org.msanchez.springcloud.ms.gateway.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class SampleGlobalFilter implements GlobalFilter {

  private final Logger logger = LoggerFactory.getLogger(SampleGlobalFilter.class);

  @Override
  public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

    logger.info(
        "ejecutando el filtro antes del request PRE {}", exchange.getRequest().getHeaders());

    exchange.getRequest().mutate().headers(h -> h.add("token", "saslkjflsdjfs89234ksldlka"));

    return chain
        .filter(exchange)
        .then(
            Mono.fromRunnable(
                () -> {
                  logger.info("ejecutando filtro POST response");
                  logger.info("X-Token: {}", exchange.getRequest().getHeaders().get("token"));

                  exchange
                      .getResponse()
                      .getCookies()
                      .add("color", ResponseCookie.from("color", "verde").build());

                  exchange.getResponse().getHeaders().setContentType(MediaType.TEXT_PLAIN);
                }));
  }
}
