package com.DINESH.commonManagement.services.serviceimplements;

import com.DINESH.commonManagement.services.CommonService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CommonServiceImplement implements CommonService {

    @Value("${server.port}")
    private String serverPort;

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${eureka.instance.hostname}")
    private String hostName;

    @Value("${cdn.service-url}")
    private String cdnHost;
    @Override
    public Object goToSwagger() throws Exception {
        return "<link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap\">\n" +
                "\n" +
                "<h1 style=\"text-align: center; position: relative; font-size: 2em; font-family: 'Roboto', sans-serif; font-style: italic;\">\n" +
                "    Welcome To\n" +
                "    <img src=\""+cdnHost+"/images/shopspark-logo.png\" \n" +
                "         alt=\"PrimaryLogo\" \n" +
                "         style=\"vertical-align: middle; height: 60px; margin-left: 10px;\" />\n" +
                "    <br />\n" +
                "    <span style=\"font-size: 0.3em; position: absolute; top: 0; right: 0; display: flex; align-items: center; margin: 10px;\">\n" +
                "      Common Management ( Service ) "+
                "        <a href=\"./swagger-ui.html\" style=\"margin-left: 10px; display: inline-block;\">\n" +
                "            <img src=\""+cdnHost+"/images/swagger-logo.png\" \n" +
                "                 alt=\"Swagger-UI\" \n" +
                "                 style=\"height: 30px;\" />\n" +
                "        </a>\n" +
                "    </span>\n" +
                "</h1>\n";
    }

    @Override
    public Object sayHello() {
        return String.format("Hello From %s:%s as %s",hostName, serverPort, applicationName);
    }
}
