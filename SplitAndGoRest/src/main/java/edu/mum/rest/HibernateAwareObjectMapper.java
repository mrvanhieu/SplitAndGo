package edu.mum.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;
 
/*
 * Avoid Jackson serialization on non fetched lazy objects
 */

public class HibernateAwareObjectMapper extends ObjectMapper {
 
    public HibernateAwareObjectMapper() {
        Hibernate4Module hibernate4Module = new Hibernate4Module();
        registerModule(hibernate4Module);
    }
}