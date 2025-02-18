package com.yedam.vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * 사원번호(1001, 1002)
 * 사원이름(홍길동, 김민수)
 * 전화번호(654-1123, 654-3434)
 * 입사일자(2020-02-04)
 * 급여(300, 350)
 */
public class Employee { // tbl_employees
	private int empNo; // emp_no 컬럼
	private String empName; // emp_name 컬럼
	private String telNo; // tel_no 컬럼
	private Date hireDate; // hire_date 컬럼
	private int salary; // salary 컬럼

	// 생성자
	public Employee() {
	}

	public Employee(int empNo, String empName, String telNo, Date hireDate, int salary) {
		this.empNo = empNo;
		this.empName = empName;
		this.telNo = telNo;
		this.hireDate = new Date();
		this.salary = salary;
	}

	public Employee(int empNo, String empName, String telNo) {
		this.empNo = empNo;
		this.empName = empName;
		this.hireDate = new Date();
		this.telNo = telNo;
	}

	public Employee(int empNo, String empName, String telNo, String hireDate, int salary) {
		this();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			this.hireDate = sdf.parse(hireDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.salary = salary;
	}

	// 사번, 이름, 연락처, 급여
	public String empInfo() {
		// 사번 이름 연락처 급여
		// -----------------------
		// 1001 홍길동 234-1234 250

		return empNo + "  " + empName + "  " + telNo + "  " + salary;
	}

	// getter, setter
	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getTelNo() {
		return telNo;
	}

	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}

	public java.util.Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(java.util.Date hireDate) {
		this.hireDate = hireDate;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", empName=" + empName + ", telNo=" + telNo + ", hireDate=" + hireDate
				+ ", salary=" + salary + "]";
	}

}