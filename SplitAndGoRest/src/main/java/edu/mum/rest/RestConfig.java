package edu.mum.rest;

import edu.mum.rest.service.PaymentRestService;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

/*
 * ResourceConfig - convenience methods to make registering resources and providers more friendly
 */
 	public class RestConfig extends ResourceConfig {
		
		public RestConfig() {
  
			// Filter to provide a bridge between JAX-RS and Spring request attributes.
 		    register(RequestContextFilter.class);   
 		    // Register Product provider -  REST endpoints...
 		    register(PaymentRestService.class);
		}
	}

