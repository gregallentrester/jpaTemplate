package net.greg.jpa.exceptions;


public class DepartmentNotFound extends java.lang.RuntimeException {

  public DepartmentNotFound(Long id) {
    super("Department id not found : " + id);
  }
}
