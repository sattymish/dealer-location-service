/**
 * 
 */
package org.mfp.poc.dealerlist.service;

import java.util.List;
import java.util.Map;
import org.mfp.poc.dealerlist.bean.DealerListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.mfp.poc.dealerlist.model.Dealer;

import org.mfp.poc.dealerlist.dao.DealerListDao;

/**
 * @author Sangeeta
 *
 */

@Service
public class DealerListServiceImpl implements DealerListService {

	@Autowired
	DealerListDao dealerListDao;

	@Override
	public DealerListResponse getAllDealerList(String region, String zone, String district, String dealer_name,
			List<String> sortBy) {
		// TODO Auto-generated method stub
		return new DealerListResponse(dealerListDao.getAllDealerList(region, zone, district, dealer_name, sortBy));

	}
	
	@Override
	public Dealer addDealer(Dealer dealer) {
			return dealerListDao.saveDealer(dealer);
	}
	
	

}
