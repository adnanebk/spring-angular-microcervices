package com.omnidata.app1.repositories;


import com.omnidata.app1.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer> {

    Optional<Employee> findByFullName(String fullName);


}
