package edu.mum.rest.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import edu.mum.domain.Payment;
import edu.mum.rest.service.PaymentRestService;

@Component
public class PaymentRestServiceImpl extends GenericRestServiceImpl implements PaymentRestService {

	public List<Payment> findAll() {
		RestTemplate restTemplate = remoteApi.getRestTemplate();
		return Arrays.asList(restTemplate.exchange(host + "/payments/", HttpMethod.GET, remoteApi.getHttpEntity(), Payment[].class).getBody());
	}

	public void save(Payment payment) {
		RestTemplate restTemplate = remoteApi.getRestTemplate();
		HttpEntity<Payment> httpEntity = new HttpEntity<Payment>(payment, remoteApi.getHttpHeaders());
		restTemplate.put(host + "/payments/", httpEntity, Payment.class);
	}
	
	public Payment update(Payment payment) {
		RestTemplate restTemplate = remoteApi.getRestTemplate();
		HttpEntity<Payment> httpEntity = new HttpEntity<Payment>(payment, remoteApi.getHttpHeaders());
		return restTemplate.postForObject(host + "/payments/", httpEntity, Payment.class);
	}
	
	public Payment findOne(Long id) {
		RestTemplate restTemplate = remoteApi.getRestTemplate();
		Payment payment =  (restTemplate.exchange(host + "/payments/"+ id, HttpMethod.GET, remoteApi.getHttpEntity(), Payment.class).getBody());
		return payment;
	}

}
