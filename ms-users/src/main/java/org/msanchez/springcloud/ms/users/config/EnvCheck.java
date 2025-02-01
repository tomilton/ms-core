package org.msanchez.springcloud.ms.users.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EnvCheck {

  @Value("${DB_HOST:mysql8:3306}")
  private String dbHost;

  @Value("${DB_DATABASE:user_db}")
  private String dbDatabase;

  public EnvCheck() {
    System.out.println("DB_HOST: " + dbHost);
    System.out.println("DB_DATABASE: " + dbDatabase);
    System.out.println("Desde System.getenv: " + System.getenv("DB_HOST"));
  }
}
