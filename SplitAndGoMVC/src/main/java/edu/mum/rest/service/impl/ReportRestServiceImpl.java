package edu.mum.rest.service.impl;

import edu.mum.domain.Payment;
import edu.mum.rest.service.ReportRestService;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class ReportRestServiceImpl extends GenericRestServiceImpl implements ReportRestService {
    @Override
    public List<Payment> findPaymentsForReport(String date) {
        RestTemplate restTemplate = remoteApi.getRestTemplate();
        return Arrays.asList(restTemplate.exchange(host + "/reports/", HttpMethod.GET, remoteApi.getHttpEntity(), Payment[].class).getBody());
    }
}
