/**
 * 
 */
package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author aditya
 *
 */
@Entity
@Table(name = "PROGRAM_DETAILS", schema = "dev_schema")
public class Program {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PROGRAM_ID")
	@JsonProperty("programId")
	private int programId;
	@Column(name = "PROGRAM_CODE")
	@JsonProperty("programCode")
	private String programCode;
	@Column(name = "PROGRAM_NAME")
	@JsonProperty("programName")
	private String programName;
	@Column(name = "PROGRAM_DESCRIPTION")
	@JsonProperty("programDesc")
	private String programDescription;
	@ManyToOne
	@JoinColumn(name = "BUY_TERM_ID")
	@JsonProperty("buyTerm")
	private BuyTerm buyTerm;

	public Program() {
	}

	public Program(int programId, String programCode, String programName, String programDescription) {
		super();
		this.programId = programId;
		this.programCode = programCode;
		this.programName = programName;
		this.programDescription = programDescription;
	}

	public int getProgramId() {
		return programId;
	}

	public void setProgramId(int programId) {
		this.programId = programId;
	}

	public String getProgramCode() {
		return programCode;
	}

	public void setProgramCode(String programCode) {
		this.programCode = programCode;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public String getProgramDescription() {
		return programDescription;
	}

	public void setProgramDescription(String programDescription) {
		this.programDescription = programDescription;
	}

	public BuyTerm getBuyTerm() {
		return buyTerm;
	}

	public void setBuyTerm(BuyTerm buyTerm) {
		this.buyTerm = buyTerm;
	}

}
