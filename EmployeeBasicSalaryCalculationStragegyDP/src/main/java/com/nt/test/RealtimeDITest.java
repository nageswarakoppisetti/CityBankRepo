package com.nt.test;


import java.util.Scanner;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.controller.MainController;
import com.nt.vo.EmployeeVO;


public class RealtimeDITest {
	
	public static void main(String[] args) {
		//Read inputs from enduser as string values
		Scanner sc=new Scanner(System.in);
		System.out.println("enter Employee name::");
		String ename=sc.next();
		System.out.println("enter Employee addrs::");
		String eaddrs=sc.next();
		System.out.println("enter Employee Basic Salary ::");
		String esal=sc.next();
		
		//create CustomerVO clas obj
			EmployeeVO vo=new EmployeeVO();
		vo.setEname(ename);vo.setEadrrs(eaddrs); vo.setBasicSalary(esal);
		
		//create IOC container
		 DefaultListableBeanFactory factory=new DefaultListableBeanFactory();
		 XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(factory);
		 reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		 //get Controller class obj 
		 MainController controller=factory.getBean("controller",MainController.class);
		 //invoke the methods
		 try {
			 String result=controller.processEmployee(vo);
			 System.out.println(result);
		 }
		 catch(Exception e) {
			 //e.printStackTrace();
			 System.out.println("Internal Problem --Try Again:::"+e.getMessage());
		 }

}
}
