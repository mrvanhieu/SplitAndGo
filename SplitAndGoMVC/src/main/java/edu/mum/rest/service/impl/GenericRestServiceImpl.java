package edu.mum.rest.service.impl;

import edu.mum.rest.RestHttpHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.Resource;
import java.util.Properties;

/**
 * Created by hieuho on 5/22/17.
 */
@PropertySource("classpath:application.properties")
public class GenericRestServiceImpl {
    @Autowired
    RestHttpHeader remoteApi;

    @Value("${rest.host}")
    String host;
}
