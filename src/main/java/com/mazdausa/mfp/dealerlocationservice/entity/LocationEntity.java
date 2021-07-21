package com.mazdausa.mfp.dealerlocationservice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Table(name="location", uniqueConstraints = { @UniqueConstraint(columnNames = { "regionCode", "districtCode" }) })
@Entity
public class LocationEntity {

	@Id
	private Long id;
	
	private String regionCode;
	
	private String districtCode;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRegionCode() {
		return regionCode;
	}

	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}

	public String getDistrictCode() {
		return districtCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}
	
	
}
