package net.greg.jpa;

import java.math.BigDecimal;

import org.slf4j.*;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;

import org.springframework.context.annotation.*;

import net.greg.jpa.models.*;
import net.greg.jpa.repositories.*;


@SpringBootApplication
public class App {

	public static void main(String any []) {
		SpringApplication.run(App.class, any);
	}


	@Bean
	CommandLineRunner initEmployee(EmployeeRepository repo) {

		Department dept1 = new Department();
		Department dept2 = new Department();

		Salary salary1 = new Salary();
		Salary salary2 = new Salary();

		return args -> {
			repo.save(new Employee("bobo", salary1, dept1, 3L));
			repo.save(new Employee("bono", salary2, dept2, 4L));
		};
	}


	@Bean
  CommandLineRunner initDepartment(DepartmentRepository repo) {

    return args -> {
      repo.save(new Department("abbot", 1L));
			repo.save(new Department("costello", 2L));
    };
  }

	static {

		LoggerFactory.getLogger(App.class).
			debug("\n\n\n\nENTER App @SpringBootApplication class' { static block } \n\n");
	}
}
