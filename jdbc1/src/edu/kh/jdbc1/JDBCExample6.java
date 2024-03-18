package edu.kh.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.kh.jdbc1.model.vo.Employee2;

public class JDBCExample6 {
//사번,사원명,전화번호,고용일,부서명
	
	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		Scanner sc = new Scanner(System.in);
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String user = "kh_psc"; // 사용자계정 			
			String pw = "kh1234"; // 비밀번호 
			
			conn = DriverManager.getConnection(url,user,pw);
			
			System.out.print("이름 : ");
			String input = sc.nextLine();
			
			String sql = "SELECT EMP_ID, EMP_NAME, PHONE, HIRE_DATE, DEPT_TITLE"
					+ " FROM EMPLOYEE"
					+ " LEFT JOIN DEPARTMENT ON(DEPT_ID = DEPT_CODE)"
					+ " WHERE DEPT_CODE = (SELECT DEPT_CODE"
					+ " FROM EMPLOYEE "
					+ " WHERE EMP_NAME = '"+input+"')";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			List<Employee2> list = new ArrayList<Employee2>();
			
			while(rs.next()) {
				//사번,사원명,전화번호,고용일,부서명
				int empId = rs.getInt("EMP_ID");
				String empName = rs.getString("EMP_NAME");
				String phone = rs.getString("PHONE");
				String hireDate = rs.getString("HIRE_DATE");
				String deptTitle = rs.getString("DEPT_TITLE");
				
			
			}
			
			if(list.isEmpty()) {
				System.out.println("조회결과 없음");
			
			} else {
				for (Employee2 emp : list) {
					System.out.println(emp);
				}
				
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
			
		} finally {
			
			try {
				
				if(rs != null)rs.close();
				if(stmt != null)stmt.close();
				if(conn != null)conn.close();
				
			} catch(Exception e) {
				
				e.printStackTrace();
			}
		} 
	}
}
