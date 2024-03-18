package edu.kh.jdbc1.model.vo;

public class Employee2 {

	private String name;
	private double point;
	
	public Employee2() {}

	public Employee2(String name, double point) {
		super();
		this.name = name;
		this.point = point;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPoint() {
		return point;
	}

	public void setPoint(double point) {
		this.point = point;
	}

	@Override
	public String toString() {
		return "학과 : "+name+"/ 전공평점 : "+point;
	}
	
	
	
}
