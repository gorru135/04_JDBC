package edu.kh.emp.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import static edu.kh.emp.common.JDBCTemplate.*;
import edu.kh.emp.model.vo.Employee;

public class EmployeeDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	public EmployeeDAO() {
		
		try {
			
			prop = new Properties();
			prop.loadFromXML(new FileInputStream("query.xml"));
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public int employeeAdd(Connection conn, Employee emp) throws Exception{

		int result = 0;
		
		try {
			
			String sql = prop.getProperty("insert");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, emp.getEmpId());
			pstmt.setString(2, emp.getEmpName());
			pstmt.setString(3, emp.getEmpNo());
			pstmt.setString(4, emp.getEmail());
			pstmt.setString(5, emp.getPhone());
			pstmt.setString(6, emp.getDepartmentTitle());
			pstmt.setString(7, emp.getJobName());
			pstmt.setInt(8, emp.getSalary());
			pstmt.setString(9, emp.getDeptCode());
			pstmt.setString(10, emp.getJobCode());
			pstmt.setString(11, emp.getSalLevel());
			pstmt.setDouble(12, emp.getBonus());
			pstmt.setInt(13, emp.getManagerId());
			result = pstmt.executeUpdate();
			
		} finally {
			
			close(pstmt);
			
		}
		
		
		
		return result;
	}

	




	
	
}
