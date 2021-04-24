package com.omnidata.app1.Services;

import com.omnidata.app1.Feign.OrganisationServiceFeign;
import com.omnidata.app1.Model.Employee;
import com.omnidata.app1.Model.Organisation;
import com.omnidata.app1.repositories.EmployeeRepo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import  static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImpTest {

    @InjectMocks
    private EmployeeServiceImp employeeService;
    @Mock
    private EmployeeRepo employeeRepo;
    @Mock
    private OrganisationServiceFeign organisationServiceFeign;

    @Test
    @DisplayName("should return created user")
    void createEmployee() {
        Employee expectedEmployee=Employee.builder().id(1)
                                                    .fullName("adnane benkouider")
                                                    .adress("adress1")
                                                    .dateOfBirth(LocalDate.of(1991,02,14))
                                                    .organisationId(1)
                                                    .build();
        when(employeeRepo.save(any(Employee.class))).thenReturn(expectedEmployee);
        when(organisationServiceFeign.getOrganisationById(1))
                .thenReturn(new Organisation(1,"org","spec"));
         Employee employee= employeeService.createEmployee(expectedEmployee);
                   verify(employeeRepo).save(expectedEmployee);
                   verify(organisationServiceFeign).getOrganisationById(1);
                   assertEquals(employee.getId(),1);
                   assertEquals(employee,expectedEmployee);
                   assertEquals(employee.getFullName(),"adnane benkouider");
                   assertEquals(employee.getOrganisationId(),1);
    }

    @Test
    void saveAllEmployees() {
    }

    @Test
    void getEmployees() {
    }

    @Test
    void getEmployeeById() {
    }

    @Test
    void getEmployeeByFullName() {
    }

    @Test
    void removeEmployee() {
    }

    @Test
    void updateEmployee() {
    }
}