package com.nt.dto;


import java.io.Serializable;

public class EmployeeDTO implements Serializable{

	
	  
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ename; 
	private String eadrrs;
	private Float basicSalary ;	
	
	private Float grossSalary;
	private Float netSalary;
	
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEadrrs() {
		return eadrrs;
	}
	public void setEadrrs(String eadrrs) {
		this.eadrrs = eadrrs;
	}
	public Float getBasicSalary() {
		return basicSalary;
	}
	public void setBasicSalary(Float basicSalary) {
		this.basicSalary = basicSalary;
	}
	public Float getGrossSalary() {
		return grossSalary;
	}
	public void setGrossSalary(Float grossSalary) {
		this.grossSalary = grossSalary;
	}
	public Float getNetSalary() {
		return netSalary;
	}
	public void setNetSalary(Float netSalary) {
		this.netSalary = netSalary;
	}
	@Override
	public String toString() {
		return "EmployeeDTO [ename=" + ename + ", eadrrs=" + eadrrs + ", basicSalary=" + basicSalary + ", grossSalary="
				+ grossSalary + ", netSalary=" + netSalary + "]";
	}

}
