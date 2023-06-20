package com.student.manage;

public class Student {
		private int studentId;
		private String studentName;
		private String studentCity;
		private int studentSalary;
		public Student(int studentId, String studentName, String studentCity, int studentSalary) {
			super();
			this.studentId = studentId;
			this.studentName = studentName;
			this.studentCity = studentCity;
			this.studentSalary = studentSalary;
		}
		public Student(String studentName, String studentCity, int studentSalary) {
			super();
			this.studentName = studentName;
			this.studentCity = studentCity;
			this.studentSalary = studentSalary;
		}
		public Student() {
			super();
			// TODO Auto-generated constructor stub
		}
		public int getStudentId() {
			return studentId;
		}
		public void setStudentId(int studentId) {
			this.studentId = studentId;
		}
		public String getStudentName() {
			return studentName;
		}
		public void setStudentName(String studentName) {
			this.studentName = studentName;
		}
		public String getStudentCity() {
			return studentCity;
		}
		public void setStudentCity(String studentCity) {
			this.studentCity = studentCity;
		}
		public int getStudentSalary() {
			return studentSalary;
		}
		public void setStudentSalary(int studentSalary) {
			this.studentSalary = studentSalary;
		}
		@Override
		public String toString() {
			return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentCity=" + studentCity
					+ ", studentSalary=" + studentSalary + "]";
		}
		
	}
