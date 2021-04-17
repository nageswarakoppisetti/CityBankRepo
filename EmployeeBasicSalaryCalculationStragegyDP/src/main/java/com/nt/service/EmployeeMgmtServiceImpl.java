package com.nt.service;

import com.nt.bo.EmployeeBO;
import com.nt.dao.IEmployeeDAO;
import com.nt.dto.EmployeeDTO;

public final class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	
 private  IEmployeeDAO  dao;  //HAS-A property
	 
	 public EmployeeMgmtServiceImpl(IEmployeeDAO dao) {
		 System.out.println("CustomerMgmtServiceImpl.1-param constructor");
		 this.dao=dao;
	}


	@Override
	public String calculateGrossAndNetSalary(EmployeeDTO dto) throws Exception {
		//calculate simple intrest amount  (b.logic)
				float grossAmt=(dto.getBasicSalary()*40/100);
				float netAmt=(grossAmt-(grossAmt*20/100));
				
				//create BO class obj having persistable data
				
				EmployeeBO bo=new EmployeeBO();
				bo.setEname(dto.getEname());
				bo.setEadrrs(dto.getEadrrs());
				bo.setBasicSalary(dto.getBasicSalary());
				bo.setGrossSalary(grossAmt);
				bo.setNetSalary(netAmt);
				//use DAO
				int count=dao.insert(bo);
				  // terinary operator   <condition>?<sucess>:<failure>
				return  count==1?"Employee registered sucessfully---> gross amount::"+grossAmt:"--->net amount::"+netAmt+"Customer registration failed";   
			}

	}


