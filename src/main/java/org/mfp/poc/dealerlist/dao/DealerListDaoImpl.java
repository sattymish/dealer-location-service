/**
 * 
 */
package org.mfp.poc.dealerlist.dao;

import java.util.List;
import org.mfp.poc.dealerlist.model.Dealer;
import org.mfp.poc.dealerlist.repository.DealerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * @author Sangeeta
 *
 */

@Component
public class DealerListDaoImpl implements DealerListDao {

	private static final Logger log =LoggerFactory.getLogger(DealerListDaoImpl.class);
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public DealerListDaoImpl(JdbcTemplate jdbcTemplate) {
		// TODO Auto-generated constructor stub
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Autowired
	private DealerRepository dealerRepo;

	/*@Override
	public Iterable<Dealer> getAllDealerList(String region, String zone, String district) {
		// TODO Auto-generated method stub

		return dealerRepo.findAll();

		
		  DealerListBean response1 = new DealerListBean();
		  response1.setRegion("All R1"); response1.setZone("All Z1");
		  response1.setDistrict("All Dis1"); response1.setCode("1");
		  response1.setDname("All Dealer1"); DealerListBean response2 = new
		  DealerListBean(); response2.setRegion("All R2"); response2.setZone("All Z2");
		  response2.setDistrict("All Dis2"); response2.setCode("2");
		  response2.setDname("All Dealer2"); List<DealerListBean> lst = new
		  ArrayList<DealerListBean>(); lst.add(response1); lst.add(response2); return
		  lst;
		 
	}*/
	
	@Override
	public Dealer saveDealer(Dealer dealer) {
		return dealerRepo.save(dealer);
	}

	@Override
	public Iterable<Dealer> getAllDealerList(String region, String zone, String district, String dealer_name,
			List<String> sortBy) {
		// TODO Auto-generated method stub
		

		StringBuilder query = new StringBuilder("select * from dealer_details");
		StringBuilder queryCondition = new StringBuilder();
		StringBuilder orderBy = new StringBuilder();
		
		if (region!=null && !region.trim().isEmpty()) {
			if (queryCondition.length() == 0) {
				queryCondition.append(" where ");
				queryCondition.append("region=" + "'" + region.trim() + "'");
			} else {
				queryCondition.append(" and region=" + "'" + region.trim() + "'");
			}			
		}
		if (zone!=null && !zone.trim().isEmpty()) {
			if (queryCondition.length() == 0) {
				queryCondition.append(" where ");
				queryCondition.append("zone=" + "'" + zone.trim() + "'");
			} else {
				queryCondition.append(" and zone=" + "'" + zone.trim() + "'");
			}			
		}
		if (district!=null && !district.trim().isEmpty()) {
			if (queryCondition.length() == 0) {
				queryCondition.append(" where ");
				queryCondition.append("district=" + "'" + district.trim() + "'");
			} else {
				queryCondition.append(" and district=" + "'" + district.trim() + "'");
			}			
		}
		if (dealer_name!=null && !dealer_name.trim().isEmpty()) {
			if (queryCondition.length() == 0) {
				queryCondition.append(" where ");
				queryCondition.append("dealer_name=" + "'" + dealer_name.trim() + "'");
			} else {
				queryCondition.append(" and dealer_name=" + "'" + dealer_name.trim() + "'");
			}			
		}
		
		/*if (sortBy != null && !sortBy.isEmpty()) {
			Set<String> keyset = sortBy.keySet();
			for (String columnName : keyset) {
				if (columnName.trim().contains("region") ||
						columnName.trim().contains("zone") || 
						columnName.trim().contains("district") || 
						columnName.trim().contains("dealer_name")) {
					if (orderBy.length() == 0) {
						orderBy.append(" ORDER BY " + columnName.trim() + " " + sortBy.get(columnName));
					} else {
						orderBy.append(", " + columnName.trim() + " " + sortBy.get(columnName));
					}
				}
			}
		}*/
		
		if (sortBy!=null && !sortBy.isEmpty()) {
			for (String sort : sortBy) {
				String sortby[] = sort.split("-");
				if (sortby[0].trim().contains("region") ||
						sortby[0].trim().contains("zone") || 
						sortby[0].trim().contains("district") || 
						sortby[0].trim().contains("dealer_name")) {
					if (orderBy.length() == 0) {
						orderBy.append(" ORDER BY " + sortby[0] + " " + sortby[1]);
					} else {
						orderBy.append(", " + sortby[0] + " " + sortby[1]);
					}								
				}			
			}
		}	
				
		
		if (!(queryCondition.length() == 0)) {
			query.append(queryCondition);			
		}
		
		if (!(orderBy.length() == 0)) {
			query.append(orderBy);
		}	
		
		log.info(query.toString());
		
		List<Dealer> dealers = jdbcTemplate.query(query.toString(), new DealerListRowMapper());
		
		return dealers;
	}
	
	/*
	 * @Override public Optional<Dealer> findDealerById(String dealerCode) { // TODO
	 * Auto-generated method stub return dealerRepo.findByDealerCode(dealerCode); }
	 */
}
