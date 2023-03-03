package net.greg.jpa.models;

import java.util.*;
import javax.persistence.*;


@Entity
@Table(name="salary")
public class Salary {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	public Long getId() { return id; }
	public void setId(Long value) { id = value; }

	private double baseSalary;
	public double getBaseSalary() { return baseSalary; }
	public void setBaseSalary(double value) { baseSalary = value; }

  @ManyToMany
	private List<SalaryComponent> salaryComponents;
	public List<SalaryComponent> getSalaryComponents() { return salaryComponents; }
	public void setSalaryComponents(List<SalaryComponent> value) { salaryComponents = value; }


  public Salary(double value, SalaryComponent component, Long idVal) {

    baseSalary = value;

    List<SalaryComponent> list = new ArrayList();  // <diamond> is unnecessary in a RH part of a Generics definition
    list.add(new SalaryComponent());
    salaryComponents = list;

    id = idVal;
  }

  // avoids "No default constructor for entity"
  public Salary() { }
}
