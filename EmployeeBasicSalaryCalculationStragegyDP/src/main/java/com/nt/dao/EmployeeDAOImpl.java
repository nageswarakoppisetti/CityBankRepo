package com.nt.dao;

import com.nt.bo.EmployeeBO;

import java.sql.SQLException;
import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class EmployeeDAOImpl implements IEmployeeDAO {

	private  static final String  REALTIMEDI_EMPLOYEE_INSERT_QUERY="INSERT INTO Employee VALUES(sequence_eno.NEXTVAL,?,?,?,?,?)";
	
	private DataSource ds;

	 // alt+shift+s ,o
	public EmployeeDAOImpl(DataSource ds) {
		System.out.println("CustomerDAOImpl:: 1 -param constructor");
		this.ds = ds;
	}
	
	@Override
	public int insert(EmployeeBO bo) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		int count=0;
		try {
			//get pooled jdbc con object
			con=ds.getConnection();
			//create PreparedStaement object having pre-compiled SQL query
			ps=con.prepareStatement(REALTIMEDI_EMPLOYEE_INSERT_QUERY);
			//set query param values
			ps.setString(1, bo.getEname());
			ps.setString(2, bo.getEadrrs());
			ps.setFloat(3, bo.getBasicSalary());
			ps.setFloat(4,bo.getGrossSalary());
			ps.setFloat(5,bo.getNetSalary());
						
			//execute the Query
			count=ps.executeUpdate();
		}
		catch(SQLException se) {
			se.printStackTrace();
			throw se;  // Exception rethrowing
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e;  //  Exception rethrowing
		}
		finally {
			//close jdbc objs
			try {
				if(ps!=null)
					ps.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
				throw se;
			}
			try {
				if(con!=null)
					con.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
				throw se;
			}
		}//finally
	
		return count;

	}

}
