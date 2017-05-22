package edu.mum.batch.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.mum.domain.ReportInformation;

public class ReportInfoRowMapper implements RowMapper<ReportInformation> {

	@Override
	public ReportInformation mapRow(ResultSet rs, int rowNum) throws SQLException {

		ReportInformation report = new ReportInformation();

		report.setId(rs.getInt("id"));
		report.setNickName(rs.getString("nickName"));
		report.setEmail(rs.getString("email"));
		return report;
	}

}