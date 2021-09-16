/**
 * 
 */
package org.mfp.poc.dealerlist.bean;

import java.util.ArrayList;
import java.util.List;

import org.mfp.poc.dealerlist.model.Dealer;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Sangeeta
 *
 */


public class DealerListResponse {
	
	private Iterable<Dealer> dealerBeanList = new ArrayList<Dealer>();
	
	public DealerListResponse(Iterable<Dealer> dealerBeanList) {
		this.dealerBeanList = dealerBeanList;
	}
	
		
	/**
	 * @return the dealerBeanList
	 */
	public Iterable<Dealer> getDealerBeanList() {
		return dealerBeanList;
	}



	/**
	 * @param dealerBeanList the dealerBeanList to set
	 */
	public void setDealerBeanList(Iterable<Dealer> dealerBeanList) {
		this.dealerBeanList = dealerBeanList;
	}



	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
