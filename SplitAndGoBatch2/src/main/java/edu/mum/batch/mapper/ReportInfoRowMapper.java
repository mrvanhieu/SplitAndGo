package edu.mum.batch.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.mum.domain.TripPayment;

public class ReportInfoRowMapper implements RowMapper<TripPayment> {

	@Override
	public TripPayment mapRow(ResultSet rs, int rowNum) throws SQLException {

		TripPayment report = new TripPayment();

		report.setId(rs.getInt("id"));
		report.setAmount(rs.getDouble("amount"));
		report.setDate(rs.getDate("date"));
		report.setTripId(rs.getString("trip_id"));
		report.setDescription(rs.getString("description"));
		
		return report;
	}

}