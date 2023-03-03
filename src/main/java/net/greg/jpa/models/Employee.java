package net.greg.jpa.models;

import javax.persistence.*;


@Entity
@Table(name="employees")
public class Employee {

	@Id
  @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	public Long getId() { return id; }
	public void setId(Long value) { id = value; }

	private String name;
  public String getName() { return name; }
	public void setName(String value) { name = value; }

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "salary_id", referencedColumnName = "id")
	private Salary salary;
	public Salary getSalary() { return salary; }
	public void setSalary(Salary value) { salary = value; }

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "department_id", referencedColumnName = "id")
	private Department department;
	public Department getDepartment() { return department; }
	public void setDepartment(Department value) { department = value; }

	public Employee(
			String nameVal, Salary salaryVal,
			Department departmentVal, Long idVal) {
    name = nameVal;
		salary = salaryVal;
		department = departmentVal;
		id = idVal;
	}

	// avoids "No default constructor for entity"
  public Employee() { }
}
