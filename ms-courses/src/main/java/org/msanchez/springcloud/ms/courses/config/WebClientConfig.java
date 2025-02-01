package org.msanchez.springcloud.ms.courses.config;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.util.concurrent.TimeUnit;

@Configuration
public class WebClientConfig {

  @Value("${config.baseurl.endpoint.ms-users}")
  private String url;

  @Bean
  @LoadBalanced
  WebClient.Builder webClient() {
    System.out.println(url);
    HttpClient httpClient =
        HttpClient.create()
            .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
            .doOnConnected(
                conn ->
                    conn.addHandlerLast(
                            new ReadTimeoutHandler(5, TimeUnit.SECONDS)) // Timeout de lectura
                        .addHandlerLast(
                            new WriteTimeoutHandler(5, TimeUnit.SECONDS)) // Timeout de escritura
                );

    return WebClient.builder()
        .baseUrl(url)
        .clientConnector(new ReactorClientHttpConnector(httpClient));
  }
}
