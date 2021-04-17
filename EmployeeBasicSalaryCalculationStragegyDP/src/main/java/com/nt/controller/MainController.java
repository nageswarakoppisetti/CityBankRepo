package com.nt.controller;

import com.nt.dto.EmployeeDTO;
import com.nt.service.IEmployeeMgmtService;
import com.nt.vo.EmployeeVO;

public class MainController {
	
private IEmployeeMgmtService service;
	
	public MainController(IEmployeeMgmtService service) {
		System.out.println("MainController: 1-param constructor");
		  this.service=service;
	}
	
	public  String  processEmployee(EmployeeVO vo)throws Exception {
		//convert  VO class obj data to DTO class object data
		EmployeeDTO dto=new EmployeeDTO();
		dto.setEname(vo.getEname());
		dto.setEadrrs(vo.getEadrrs());
		dto.setBasicSalary(Float.parseFloat(vo.getBasicSalary()));
		

		String result=service.calculateGrossAndNetSalary(dto);
		return result;
	}

}
