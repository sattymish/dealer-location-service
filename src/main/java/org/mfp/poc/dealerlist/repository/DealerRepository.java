/**
 * 
 */
package org.mfp.poc.dealerlist.repository;

import org.mfp.poc.dealerlist.model.Dealer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 * @author Sangeeta
 *
 */

@Repository
public interface  DealerRepository  extends CrudRepository<Dealer, Long>{
	
	//@Query("from Auction a join a.category c where c.name=:categoryName")
 //   public Iterable<Auction> findByCategory(String categoryName);
	
	

}