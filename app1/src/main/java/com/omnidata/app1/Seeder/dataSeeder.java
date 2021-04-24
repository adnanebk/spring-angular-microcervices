package com.omnidata.app1.Seeder;

import com.omnidata.app1.Model.Employee;
import com.omnidata.app1.repositories.EmployeeRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class dataSeeder implements CommandLineRunner {

    private EmployeeRepo employeeRepo;

    public dataSeeder(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }


    @Override
    public void run(String... args) throws Exception {
        employeeRepo.save(
                new Employee("adnane benkouider","adress xxxxx","0682834843",LocalDate.parse("1991-02-14"),1,1));
    }
}
