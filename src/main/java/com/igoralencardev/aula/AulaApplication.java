package com.igoralencardev.aula;

import com.igoralencardev.entities.Employee;
import com.igoralencardev.services.BrazilTaxService;
import com.igoralencardev.services.PensionService;
import com.igoralencardev.services.SalaryService;
import com.igoralencardev.services.TaxService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class AulaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AulaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);


		System.out.print("Nome: ");
		String name = sc.nextLine();
		System.out.print("Salário Bruto: ");
		double grossSalary = sc.nextDouble();

		Employee employee = new Employee(name, grossSalary);
		BrazilTaxService brazilTaxService = new BrazilTaxService();
		PensionService pensionService = new PensionService();
		SalaryService salaryService = new SalaryService(brazilTaxService, pensionService);

		double netSalary = salaryService.netSalary(employee);
		System.out.printf("Salario liquido = %.2f%n",netSalary);

		sc.close();

	}
}
