/**
 * 
 */
package org.mfp.poc.dealerlist.service;

import java.util.List;
import org.mfp.poc.dealerlist.bean.DealerListResponse;
import org.mfp.poc.dealerlist.model.Dealer;

/**
 * @author Sangeeta
 *
 */
public interface DealerListService {
	
	public DealerListResponse getAllDealerList(String region,String zone,String district, String dealer_name,
			List<String> sortBy);
	
	//public Optional<Dealer> findDealerById(String dealerCode);
	
	public Dealer addDealer(Dealer dealer) ;
	
}
