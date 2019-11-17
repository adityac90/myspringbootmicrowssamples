/**
 * 
 */
package com.example.demo.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * @author aditya
 *
 */
@Entity
@Table(name = "BUY_TERM", schema = "dev_schema")
@JsonRootName("buyTerms")
public class BuyTerm extends RepresentationModel<BuyTerm> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BUY_TERM_ID")
	@JsonProperty("buyTermId")
	private int buyTermId;
	@Column(name = "CAR_BUY_ID")
	@JsonProperty("carBuyId")
	private String carBuyId;
	@Column(name = "COUNTRY")
	@JsonProperty("country")
	private String country;
	@Column(name = "ALLOCATION_DATE")
	@Temporal(TemporalType.DATE)
	@JsonProperty("allocationDate")
	private Date allocationDate;

	public BuyTerm() {
		super();
	}

	public BuyTerm(int buyTermId, String carBuyId, String country, Date allocationDate) {
		super();
		this.buyTermId = buyTermId;
		this.carBuyId = carBuyId;
		this.country = country;
		this.allocationDate = allocationDate;
	}

	public int getBuyTermId() {
		return buyTermId;
	}

	public void setBuyTermId(int buyTermId) {
		this.buyTermId = buyTermId;
	}

	public String getCarBuyId() {
		return carBuyId;
	}

	public void setCarBuyId(String carBuyId) {
		this.carBuyId = carBuyId;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getAllocationDate() {
		return allocationDate;
	}

	public void setAllocationDate(Date allocationDate) {
		this.allocationDate = allocationDate;
	}

}
