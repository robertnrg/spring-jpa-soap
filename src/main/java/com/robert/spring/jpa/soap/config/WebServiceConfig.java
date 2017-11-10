package com.robert.spring.jpa.soap.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.server.endpoint.interceptor.PayloadLoggingInterceptor;
import org.springframework.ws.soap.server.endpoint.interceptor.PayloadValidatingInterceptor;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import java.util.List;

/**
 * @author Roberto Noriega
 * @version 1.0.0
 * @since 24/10/17
 **/
@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);

        return new ServletRegistrationBean(servlet, "/endpoints/*");
    }

    @Bean(name = "spring-jpa-soap")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema getSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("SpringJpaSoapPort");
        wsdl11Definition.setLocationUri("/endpoints");
        wsdl11Definition.setTargetNamespace("http://spring-jpa-soap.com/web-service");
        wsdl11Definition.setSchema(this.getSchema());

        return wsdl11Definition;
    }

    @Bean
    public XsdSchema getSchema() {
        return new SimpleXsdSchema(new ClassPathResource("/xsd/spring-jpa-soap.xsd"));
    }

    @Override
    public void addInterceptors(List<EndpointInterceptor> interceptors) {
        PayloadValidatingInterceptor validatingInterceptor = new PayloadValidatingInterceptor();
        validatingInterceptor.setXsdSchema(this.getSchema());
        validatingInterceptor.setValidateRequest(true);
        validatingInterceptor.setValidateResponse(true);
        interceptors.add(validatingInterceptor);

        interceptors.add(new PayloadLoggingInterceptor());
    }

}