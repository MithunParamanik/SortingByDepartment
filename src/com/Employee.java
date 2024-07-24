package com;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Employee {
	private String id;
	private String name;
	private String dept;
	private double salary;

	public Employee(String id, String name, String dept, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.dept = dept;
		this.salary = salary;
	}

	public Employee() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", dept=" + dept + ", salary=" + salary + "]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Employee> list=Stream.of(
				new Employee("EMP1","MANISH","DEV",5000),
				new Employee("EMP2","SANTOSH","DEV",8000),
				new Employee("EMP3","PRATIK","QA",6000),
				new Employee("EMP4","DIPAK","QA",9000),
				new Employee("EMP5","BIKASH","DEVOPPS",40000))
				.collect(Collectors.toList());
		Comparator<Employee> comparingBySalary = Comparator.comparing(Employee::getSalary);
		
		/*//grop by dept.....................
		 * Map<String, List<Employee>> employeeMap = list.stream()
		 * .collect(Collectors.groupingBy(Employee::getDept));
		 */
		
		Map<String, Optional<Employee>> employeemap = list.stream().collect(Collectors.groupingBy(Employee::getDept,
				Collectors.reducing(BinaryOperator.maxBy(comparingBySalary))));
		System.out.println(employeemap);
		
		
		
		//Another Approach...
		list.stream().collect(Collectors.groupingBy(Employee:getdept,colle))
		
		
		
		
		
		

	}

}
