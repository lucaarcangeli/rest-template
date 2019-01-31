package com.example.rest.config;

import org.apache.catalina.connector.Connector;
import org.apache.catalina.valves.RemoteIpValve;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author OITECH develop team - 15/01/2019
 */
@Configuration
public class TomcatConf {

    @Value("${server.ajp.port:8009}")
    private Integer ajpPort;


    /**
     * @author Luca Arcangeli - 04/09/2018
     */
    @Bean
    public ServletWebServerFactory servletContainer() {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        tomcat.addAdditionalTomcatConnectors(createConnector());
        tomcat.addContextValves(createRemoteIpValves());
        return tomcat;
    }


    /**
     * @author Luca Arcangeli - 04/09/2018
     */
    private RemoteIpValve createRemoteIpValves() {
        RemoteIpValve remoteIpValve = new RemoteIpValve();
        remoteIpValve.setRemoteIpHeader("x-forwarded-for");
        remoteIpValve.setProtocolHeader("x-forwarded-proto");
        return remoteIpValve;
    }


    /**
     * @author Luca Arcangeli - 04/09/2018
     */
    private Connector createConnector() {
        Connector connector = new Connector("AJP/1.3");
        connector.setPort(ajpPort);
        return connector;
    }
}

