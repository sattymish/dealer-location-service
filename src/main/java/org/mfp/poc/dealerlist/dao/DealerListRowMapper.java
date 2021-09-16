/**
 * 
 */
package org.mfp.poc.dealerlist.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.mfp.poc.dealerlist.model.Dealer;
import org.springframework.jdbc.core.RowMapper;

/**
 * @author Indrajit Sen
 *
 */
public class DealerListRowMapper implements RowMapper<Dealer> {

	@Override
	public Dealer mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		Dealer dealer = new Dealer();
		dealer.setId(rs.getLong("id"));
		dealer.setDname(rs.getString("dealer_name"));
		dealer.setDlrCode(rs.getString("dealer_code"));
		dealer.setRegion(rs.getString("region"));
		dealer.setZone(rs.getString("zone"));
		dealer.setDistrict(rs.getString("district"));
		
		return dealer;
	}

}
