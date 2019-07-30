package org.cts.pojo;

import java.util.List;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Trainer implements InitializingBean, DisposableBean, BeanNameAware {
	private String name;
	private long employeeID;
	private String designation;
	private List<String> skillsets;

	public Trainer() {
		super();
	}

	public Trainer(String name, long employeeID, String designation) {
		super();
		this.name = name;
		this.employeeID = employeeID;
		this.designation = designation;
	}

	public Trainer(String name, long employeeID, String designation, List<String> skillsets) {
		super();
		this.name = name;
		this.employeeID = employeeID;
		this.designation = designation;
		this.skillsets = skillsets;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(long employeeID) {
		this.employeeID = employeeID;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public List<String> getSkillsets() {
		return skillsets;
	}

	public void setSkillsets(List<String> skillsets) {
		this.skillsets = skillsets;
	}

	@Override
	public String toString() {
		return "Trainer [name=" + name + ", employeeID=" + employeeID + ", designation=" + designation + ", skillsets="
				+ skillsets + "]";
	}

	public void destroy() throws Exception {
		System.out.println("destoryed .............");

	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("Training afterPropertiesSet  .............");

	}

	public void setBeanName(String name) {
		System.out.println(name + " is being initialized");

	}

}
