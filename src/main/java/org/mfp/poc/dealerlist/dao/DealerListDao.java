/**
 * 
 */
package org.mfp.poc.dealerlist.dao;

import java.util.List;
import org.mfp.poc.dealerlist.model.Dealer;

/**
 * @author Sangeeta
 *
 */
public interface DealerListDao {
	
	public Iterable<Dealer> getAllDealerList(String region, String zone, String district, String dealer_name,
			List<String> sortBy);
	
	public Dealer saveDealer(Dealer dealer);
	
	//public Optional<Dealer> findDealerById(String dealerCode);

}
