package edu.mum.rest.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import edu.mum.annotation.Notification;
import edu.mum.domain.Payment;
import edu.mum.domain.dto.PaymentDto;
import edu.mum.rest.service.PaymentRestService;

@Component
public class PaymentRestServiceImpl extends GenericRestServiceImpl implements PaymentRestService {

	public List<Payment> findAll() {
		RestTemplate restTemplate = remoteApi.getRestTemplate();
		return Arrays.asList(restTemplate.exchange(host + "/payments/", HttpMethod.GET, remoteApi.getHttpEntity(), Payment[].class).getBody());
	}

	@Notification
	public void save(PaymentDto payment) {
		RestTemplate restTemplate = remoteApi.getRestTemplate();
		HttpEntity<PaymentDto> httpEntity = new HttpEntity<PaymentDto>(payment, remoteApi.getHttpHeaders());
		restTemplate.put(host + "/payments/", httpEntity, PaymentDto.class);
	}
	@Notification
	public PaymentDto update(PaymentDto payment) {
		RestTemplate restTemplate = remoteApi.getRestTemplate();
		HttpEntity<PaymentDto> httpEntity = new HttpEntity<PaymentDto>(payment, remoteApi.getHttpHeaders());
		return restTemplate.postForObject(host + "/payments/", httpEntity, PaymentDto.class);
	}
	
	public void delete(Long id) {
		RestTemplate restTemplate = remoteApi.getRestTemplate();
		HttpEntity<?> httpEntity = new HttpEntity<Object>(remoteApi.getHttpHeaders());
		restTemplate.exchange(host + "/payments/" + id, HttpMethod.DELETE, httpEntity, Void.class);
	}
	
	public PaymentDto findOne(Long id) {
		RestTemplate restTemplate = remoteApi.getRestTemplate();
		return restTemplate.exchange(host + "/payments/" + id, HttpMethod.GET, remoteApi.getHttpEntity(), PaymentDto.class).getBody();
	}
	
	public List<PaymentDto> findByTripId(Long tripId) {
		RestTemplate restTemplate = remoteApi.getRestTemplate();
		return Arrays.asList(restTemplate.exchange(host + "/payments/trip/" + tripId, HttpMethod.GET, remoteApi.getHttpEntity(), PaymentDto[].class).getBody());
	}

}
