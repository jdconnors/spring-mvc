package com.example.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by jconnors on 6/10/16.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan("com.example")
public class JpaIntegrationConfig {
}
