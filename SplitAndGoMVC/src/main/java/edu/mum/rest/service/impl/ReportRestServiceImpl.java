package edu.mum.rest.service.impl;

import edu.mum.rest.service.ReportRestService;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ReportRestServiceImpl extends GenericRestServiceImpl implements ReportRestService {
    @Override
    public byte[] findPaymentsForReport(Long id, String date) {
        RestTemplate restTemplate = remoteApi.getRestTemplate();
        String url = host + "/reports/"+id+"/"+date;
        byte[] content = restTemplate.exchange(url, HttpMethod.GET, remoteApi.getHttpEntityStream(), byte[].class).getBody();
        return content;
    }
}
