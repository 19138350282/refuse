//package com.example.refuse;
//
//import org.apache.catalina.Context;
//import org.apache.catalina.connector.Connector;
//import org.apache.tomcat.util.descriptor.web.SecurityCollection;
//import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
//import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import sun.security.util.SecurityConstants;
//
///**
// * @Description: TODO
// * @author: scott
// * @date: 2022年03月17日 23:15
// */
//@Configuration
//public class HttpsConfiguration {
//    @Value("${http-port}")
//    private int port;
//    @Value("${server.port}")
//    private int sslPort;
//    @Bean
//    public ServletWebServerFactory servletContainer(){
//        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory(){
//            @Override
//            protected void postProcessContext(Context context) {
//                SecurityConstraint securityConstraint = new SecurityConstraint();
//                securityConstraint.setUserConstraint("CONFIDENTIAL");
//                SecurityCollection collection = new SecurityCollection();
//                collection.addPattern("/*");
//                securityConstraint.addCollection(collection);
//                context.addConstraint(securityConstraint);
//            }
//        };
//        tomcat.addAdditionalTomcatConnectors(redirectConnector());
//        return tomcat;
//    }
//    private Connector redirectConnector(){
//        Connector conneector = new Connector(TomcatServletWebServerFactory.DEFAULT_PROTOCOL) ;
//        conneector.setScheme("http");
//        conneector.setPort(port);
//        conneector.setSecure(false);
//        conneector.setRedirectPort(sslPort);
//        return conneector;
//    }
//}
