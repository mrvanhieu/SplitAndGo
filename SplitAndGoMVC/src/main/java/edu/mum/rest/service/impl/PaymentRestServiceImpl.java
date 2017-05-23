package edu.mum.rest.service.impl;

import edu.mum.dao.PaymentDao;
import edu.mum.domain.Payment;
import edu.mum.rest.RestHttpHeader;
import edu.mum.rest.service.PaymentRestService;
import edu.mum.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class PaymentRestServiceImpl extends GenericRestServiceImpl implements PaymentRestService {
	public List<Payment> findAll() {
		RestTemplate restTemplate = remoteApi.getRestTemplate();
		return Arrays.asList(restTemplate.exchange(host + "/payments/", HttpMethod.GET, remoteApi.getHttpEntity(), Payment[].class).getBody());
	}

	public void save(Payment payment) {
		RestTemplate restTemplate = remoteApi.getRestTemplate();
		HttpEntity<Payment> httpEntity = new HttpEntity<Payment>(payment, remoteApi.getHttpHeaders());
		restTemplate.postForObject(host + "/payments/add", httpEntity, Payment.class);
	}
	public Payment findOne(Long id) {
		RestTemplate restTemplate = remoteApi.getRestTemplate();
		Payment payment =  (restTemplate.exchange(host + "/payments/"+ id, HttpMethod.GET, remoteApi.getHttpEntity(), Payment.class).getBody());
		return payment;
	}

}
