package com.example.refuse.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.connector.Connector;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2022年03月25日 18:54
 */
@Configuration
public class TomcatConfiguration {
    @Bean
    public TomcatServletWebServerFactory webServerFactory(){
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        factory.addConnectorCustomizers((Connector connector)->{
            connector.setProperty("relaxedPathChars","\"#<>[\\]^`{|}");
            connector.setProperty("relaxedQueryChars","\"#<>[\\]^`{|}");
        });
        return factory;
    }
}