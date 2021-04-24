package com.omnidata.app1.Services;

import com.omnidata.app1.Exceptions.EmployeeByIdNotFoundException;
import com.omnidata.app1.Feign.OrganisationServiceFeign;
import com.omnidata.app1.Model.Employee;
import com.omnidata.app1.Model.Organisation;
import com.omnidata.app1.repositories.EmployeeRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImp implements EmployeeService {

    //@Value("${services.organisation.url}")
    //private   String ORG_URL;
    private final EmployeeRepo employeeRepo;
    //private RestTemplate restTemplate;
    private OrganisationServiceFeign organisationServiceFeign;

    public EmployeeServiceImp(EmployeeRepo employeeRepo, OrganisationServiceFeign organisationServiceFeign) {
        this.employeeRepo = employeeRepo;

        this.organisationServiceFeign = organisationServiceFeign;
    }

    @Override
    public Employee createEmployee(Employee employee) {

        return setEmployeeOrganisation(employeeRepo.save(employee));
    }

    @Override
    public List<Employee> saveAllEmployees(List<Employee> employees) {
     return employeeRepo.saveAll(employees);
    }

    @Override
    public List<Employee> getEmployees() {

        return employeeRepo.findAll()
                .stream().peek(this::setEmployeeOrganisation).collect(Collectors.toList());
    }
    @Override
    public Employee getEmployeeById(int id) {
        Employee employee= employeeRepo.findById(id).orElseThrow(EmployeeByIdNotFoundException::new);
        setEmployeeOrganisation(employee);
        return employee;
    }

    @Override
    public Optional<Employee> getEmployeeByFullName(String fullName){

        return employeeRepo.findByFullName(fullName);
    }



    @Override
    public void removeEmployee(int id) {
        if(!employeeRepo.existsById(id))
            throw new EmployeeByIdNotFoundException();
        employeeRepo.deleteById(id);
    }

    @Override
    public Employee updateEmployee(int id,Employee employee) {
        var updatedEmployee =employeeRepo.findById(id).orElseThrow((EmployeeByIdNotFoundException::new));
        BeanUtils.copyProperties(employee,updatedEmployee);
        return setEmployeeOrganisation(employeeRepo.save(updatedEmployee));
    }


    private Employee setEmployeeOrganisation(Employee employee) {
        //employee.setOrganisation(restTemplate.getForObject(ORG_URL+ employee.getOrganisationId(), Organisation.class));
       employee.setOrganisation(organisationServiceFeign.getOrganisationById(employee.getOrganisationId()));
        return employee;
    }
}
