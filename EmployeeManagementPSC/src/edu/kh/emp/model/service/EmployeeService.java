package edu.kh.emp.model.service;

import java.sql.Connection;

import static edu.kh.emp.common.JDBCTemplate.*;
import edu.kh.emp.model.dao.EmployeeDAO;
import edu.kh.emp.model.vo.Employee;


public class EmployeeService {

	private EmployeeDAO empDAO = new EmployeeDAO();



	public int employeeAdd(Employee emp) throws Exception{
		Connection conn = getConnection();
		
		int result = empDAO.employeeAdd(conn,emp);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		return result;
	}

}
