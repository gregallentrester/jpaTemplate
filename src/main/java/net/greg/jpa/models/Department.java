package net.greg.jpa.models;

import java.util.*;
import javax.persistence.*;


@Entity
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	public Long getId() { return id; }
	public void setId(Long value) { id = value; }

	private String name;
	public String getName() { return name; }
	public void setName(String value) { name = value; }

  @ManyToMany
	private List<Employee> employees;
	public List<Employee> getEmployees() { return employees; }
	public void setEmployees(List<Employee> value) { employees = value; }


  public Department(String nameVal, Long idVal) {
    name = nameVal;
		id = idVal;
		employees = new ArrayList();  // <diamond> is unnecessary in a RH part of a Generics definition
	}


	// avoids "No default constructor for entity"
  public Department() {  }
}
