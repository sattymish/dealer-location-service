/**
 * 
 */
package org.mfp.poc.dealerlist.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Sangeeta
 *
 */
@Entity
@Table(name = "dealer_details")
public class Dealer implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "dealer_name")
	private String dname;
	
	@Column(name = "status")
	private String status;

	/*
	 * @Column(name = "code") private Integer code;
	 */
	
	@Column(name = "dealer_code")
	private String dlrCode;
	
	
	@Column(name = "region")
	private String region;
	
	@Column(name = "zone")
	private String zone;
	
	@Column(name = "district")
	private String district;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the dname
	 */
	public String getDname() {
		return dname;
	}

	/**
	 * @param dname the dname to set
	 */
	public void setDname(String dname) {
		this.dname = dname;
	}

	
	/*
	 * public Integer getCode() { return code; }
	 * 
	 * 
	 * public void setCode(Integer code) { this.code = code; }
	 */

	/**
	 * @return the dlrCode
	 */
	public String getDlrCode() {
		return dlrCode;
	}

	/**
	 * @param dlrCode the dlrCode to set
	 */
	public void setDlrCode(String dlrCode) {
		this.dlrCode = dlrCode;
	}

	/**
	 * @return the region
	 */
	public String getRegion() {
		return region;
	}

	/**
	 * @param region the region to set
	 */
	public void setRegion(String region) {
		this.region = region;
	}

	/**
	 * @return the zone
	 */
	public String getZone() {
		return zone;
	}

	/**
	 * @param zone the zone to set
	 */
	public void setZone(String zone) {
		this.zone = zone;
	}

	/**
	 * @return the district
	 */
	public String getDistrict() {
		return district;
	}

	/**
	 * @param district the district to set
	 */
	public void setDistrict(String district) {
		this.district = district;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}