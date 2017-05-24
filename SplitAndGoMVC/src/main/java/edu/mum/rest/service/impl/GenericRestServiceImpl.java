package edu.mum.rest.service.impl;

import edu.mum.rest.RestHttpHeader;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by hieuho on 5/22/17.
 */
public class GenericRestServiceImpl {
    @Autowired
    RestHttpHeader remoteApi;
    String host = "http://localhost:8080/SplitAndGoRest/rest";
}
