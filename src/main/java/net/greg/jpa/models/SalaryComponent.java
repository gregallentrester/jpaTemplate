package net.greg.jpa.models;

import javax.persistence.*;


@Entity
public class SalaryComponent {

	@Id
  @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	public Long getId() { return id; }
	public void setId(Long value) { id = value; }

	private String name;
	public String getName() {	return name; }
	public void setName(String value) { name = name; }

	private double factor;
	public double getFactor() { return factor; }
	public void setFactor(double value) { factor = value; }
}
