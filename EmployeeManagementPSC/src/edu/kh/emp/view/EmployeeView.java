package edu.kh.emp.view;

import java.util.Scanner;

import edu.kh.emp.model.service.EmployeeService;
import edu.kh.emp.model.vo.Employee;

public class EmployeeView {
	
	private EmployeeService empService = new EmployeeService();
	Employee emp = new Employee();
	Scanner sc = new Scanner(System.in);
	
	public void startView() {
		
		int input = 0;
		
		do {
			
			try {
				
				input = selectMenu();
				
				switch(input) {
				case 1 : employeeAdd(); break;
				case 2 : break;
				case 3 : break;
				case 0 : System.out.println("프로그램 종료.."); break;
				default : System.out.println("메뉴에 있는 번호만 입력해주세요");
				}
				
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			
		} while(input != 0);
		
	}

	public int selectMenu() {
		
		System.out.println("\n==========[Employee]==========\n");
		System.out.println("1. 사원 등록 ");
		System.out.println("2. 사원 수정 ");
		System.out.println("3. 사원 삭제");
		System.out.println("0. 프로그램 종료 ");
		
		System.out.print("메뉴 선택 : ");
		
		int input = sc.nextInt();
		
		return input;
	}

	public void employeeAdd() {
		System.out.println("\n==========[1. 사원 등록]==========\n");
		
		System.out.print("사원 번호 : ");
	    emp.setEmpId(sc.nextInt());
	    
	    sc.nextLine(); // 버퍼 비우기
	    
	    System.out.print("이름 : ");
	    emp.setEmpName(sc.nextLine());
	    
	    System.out.print("주민등록번호 : ");
	    emp.setEmpNo(sc.nextLine());
	    
	    System.out.print("이메일 : ");
	    emp.setEmail(sc.nextLine());
	    
	    System.out.print("전화번호 : ");
	    emp.setPhone(sc.nextLine());
	    
	    System.out.print("부서명 : ");
	    emp.setDepartmentTitle(sc.nextLine());
	    
	    System.out.print("직급명 : ");      
	    emp.setJobName(sc.nextLine());
	  
	    
	    System.out.print("급여 : ");
	    emp.setSalary(sc.nextInt());
	   
	    
	    System.out.print("부서코드 : ");
	    emp.setDeptCode(sc.next());
	    
	    System.out.print("직급코드 : ");
	    emp.setJobCode(sc.next());
	    
	    System.out.print("급여등급 : ");
	    emp.setSalLevel(sc.next());
	    
	    System.out.print("보너스 : ");
	    emp.setBonus(sc.nextDouble());
	    
	    System.out.print("사수번호 : ");
	    emp.setManagerId(sc.nextInt());
		
		try {
			
			int result = empService.employeeAdd(emp);
			
			if(result > 0)System.out.println("등록 완료");
			else System.out.println("등록실패");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
