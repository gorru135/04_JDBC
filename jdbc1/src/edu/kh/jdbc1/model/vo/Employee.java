package edu.kh.jdbc1.model.vo;

public class Employee {

	private String empName; //이름
	private String jobName; // 
	private int salary;
	private int annualIncom; // 연간수입
	
	private String hireDate;// 입사일
	private char gender; // 남 M, 여자 F
	
	
	public Employee() {}

	public Employee(String empName, String jobName, int salary, int annualIncom) {
		super();
		this.empName = empName;
		this.jobName = jobName;
		this.salary = salary;
		this.annualIncom = annualIncom;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getAnnualIncom() {
		return annualIncom;
	}

	public void setAnnualIncom(int annualIncom) {
		this.annualIncom = annualIncom;
	}

	
	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return empName+ " / "+jobName+" / "+salary+"원"+ " / " +annualIncom+"원";
	}
	
	
}
