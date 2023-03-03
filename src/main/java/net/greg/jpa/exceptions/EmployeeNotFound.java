package net.greg.jpa.exceptions;


public class EmployeeNotFound extends java.lang.RuntimeException {

  public EmployeeNotFound(Long id) {
    super("Employee id not found : " + id);
  }
}
