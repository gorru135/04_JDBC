package edu.kh.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.kh.jdbc1.model.vo.Employee;
import edu.kh.jdbc1.model.vo.Employee2;

public class JDBCExample4 {

	public static void main(String[] args) {
		
		
		// 직급명, 급여를 입력받아 
		// 해당 직급에서 입력 받은 급여보다 많이 받는 사원의
		// 이름, 직급명, 급여, 연봉을 조회하여 출력 
		
		// 단, 조회 결과가 없으면 "조회 결과 없음" 출력 
		// 조회 결과가 있으면 아래와 같이 출력 
	
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null; 
		
		Scanner sc = new Scanner(System.in);
		
		try {
			
			System.out.print("직급명 : ");
			String inputjob = sc.nextLine();
			
			System.out.print("급여 : ");
			int inputsalay = sc.nextInt();
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String user = "kh_psc"; // 사용자계정 			
			String pw = "kh1234"; // 비밀번호 
			
			conn = DriverManager.getConnection(url,user,pw);
			
			String sql = "SELECT EMP_NAME, JOB_NAME, SALARY, SALARY *12 연봉"
					+ " FROM EMPLOYEE"
					+ " JOIN JOB USING (JOB_CODE)"
					+ " WHERE JOB_NAME = '"+inputjob+"'"
					+ " AND SALARY > "+inputsalay;
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			List<Employee> list = new ArrayList<Employee>();
			
			while(rs.next()) {
				
				String empName = rs.getString("EMP_NAME");
				String jobName = rs.getString("JOB_NAME");
				int salary = rs.getInt("SALARY");
				int annualIncom = rs.getInt("연봉");
				
				list.add(new Employee(empName,jobName,salary,annualIncom));
				
			}
			
			if(list.isEmpty()) {
				System.out.println("조회 결과 없음");
				
			} else {
				
				for(Employee emp : list) {
					
					System.out.println(emp);
				}
			}
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
			
		} finally {
				
			try {
				if(rs!=null)rs.close();
				if(stmt != null)stmt.close();
				if(conn != null)conn.close();
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}
