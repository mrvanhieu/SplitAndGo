package edu.mum.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

import edu.mum.domain.TripPayment;

public class CustomItemWriter implements ItemWriter<TripPayment> {

	@Override
	public void write(List<? extends TripPayment> arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
