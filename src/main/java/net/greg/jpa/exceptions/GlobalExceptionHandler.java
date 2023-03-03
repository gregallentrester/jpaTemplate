package net.greg.jpa.exceptions;

import java.io.IOException;

import javax.servlet.http.*;


import org.springframework.http.*;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.*;


/*
  Spring handles the exceptions, we just override the status code
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(EmployeeNotFound.class)
  public void employeeNotFound(HttpServletResponse resp) throws IOException {
    resp.sendError(HttpStatus.NOT_FOUND.value());
  }

  @ExceptionHandler(DepartmentNotFound.class)
  public void departmentNotFound(HttpServletResponse resp) throws IOException {
    resp.sendError(HttpStatus.NOT_FOUND.value());
  }
}
