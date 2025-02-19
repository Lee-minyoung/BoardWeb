package com.yedam.vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


/*
 * 사원번호(1001, 1002)
 * 사원이름(홍길동, 김민수)
 * 전화번호(654-1123, 654-3434)
 * 입사일자(2020-02-04)
 * 급여(300, 350)
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Employee { // tbl_employees
	private int empNo; // emp_no 컬럼
	private String empName; // emp_name 컬럼
	private String telNo; // tel_no 컬럼
	private Date hireDate; // hire_date 컬럼
	private int salary; // salary 컬럼

	// 생성자
	public Employee(int empNo, String empName, String telNo) {
		this.empNo = empNo;
		this.empName = empName;
		this.hireDate = new Date();
		this.telNo = telNo;
	}
	
//	public Employee(int empNo, String empName, String telNo, Date hireDate, int salary) {
//		this.empNo = empNo;
//		this.empName = empName;
//		this.telNo = telNo;
//		this.hireDate = new Date();
//		this.salary = salary;
//	}


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

	

	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", empName=" + empName + ", telNo=" + telNo + ", hireDate=" + hireDate
				+ ", salary=" + salary + "]";
	}

}