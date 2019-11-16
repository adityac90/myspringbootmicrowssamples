/**
 * 
 */
package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author aditya
 *
 */
@Entity
@Table(name = "MFG", schema = "dev_schema")
@ApiModel("Manufacturer Entity")
public class Manufacturer extends RepresentationModel<Manufacturer> {

	public Manufacturer() {
	}

	public Manufacturer(int manufacturerID, String manufacturerCode, String manufacturerName, String manufacturerDesc) {
		this.manufacturerID = manufacturerID;
		this.manufacturerCode = manufacturerCode;
		this.manufacturerName = manufacturerName;
		this.manufacturerDesc = manufacturerDesc;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MFG_ID")
	@JsonProperty("mfgID")
	@ApiModelProperty("manufacturer ID")
	private int manufacturerID;
	@Column(name = "MFD_CODE")
	@JsonProperty("mfgCode")
	@ApiModelProperty("manufacturer code")
	private String manufacturerCode;
	@Column(name = "MFG_NAME")
	@JsonProperty("mfgName")
	@ApiModelProperty("manufacturer name")
	private String manufacturerName;
	@Column(name = "MFG_DESC")
	@JsonProperty("mfgDesc")
	@ApiModelProperty("manufacturer description")
	private String manufacturerDesc;

	public int getManufacturerID() {
		return manufacturerID;
	}

	public void setManufacturerID(int manufacturerID) {
		this.manufacturerID = manufacturerID;
	}

	public String getManufacturerCode() {
		return manufacturerCode;
	}

	public void setManufacturerCode(String manufacturerCode) {
		this.manufacturerCode = manufacturerCode;
	}

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	public String getManufacturerDesc() {
		return manufacturerDesc;
	}

	public void setManufacturerDesc(String manufacturerDesc) {
		this.manufacturerDesc = manufacturerDesc;
	}

}
