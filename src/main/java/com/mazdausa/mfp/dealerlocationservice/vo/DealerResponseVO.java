package com.mazdausa.mfp.dealerlocationservice.vo;

import java.util.List;

public class DealerResponseVO {
	
	private List<DealerVO> dealers;
	private String environment;
	public List<DealerVO> getDealers() {
		return dealers;
	}
	public void setDealers(List<DealerVO> dealers) {
		this.dealers = dealers;
	}
	public String getEnvironment() {
		return environment;
	}
	public void setEnvironment(String environment) {
		this.environment = environment;
	}
	
	

}
