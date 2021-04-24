package com.omnidata.app1.Controllers;
import com.omnidata.app1.Model.Employee;
import com.omnidata.app1.Services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;


    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getAllEmployees(){
        System.out.printf("organization service called");
        return  employeeService.getEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id){
        return  employeeService.getEmployeeById(id);
                   }

    @GetMapping("/fullName/{fullName}")
    public Employee getEmployeeBYFullName(@PathVariable String fullName){
        return  employeeService.getEmployeeByFullName(fullName).
                orElseThrow(()->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,"employee not found with full name "+fullName));
    }

    @PostMapping
    public ResponseEntity<Employee> saveNewUser(@Valid @RequestBody Employee employee){
        Employee createdEmployee=employeeService.createEmployee(employee);
       if(createdEmployee==null)
        return ResponseEntity.noContent().build();
        return  getEmployeeEntity(createdEmployee,"/{id}");
    }
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id,@Valid  @RequestBody Employee employee){
      return  getEmployeeEntity(employeeService.updateEmployee(id,employee),"");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> removeEmployeeById(@PathVariable int id){
        employeeService.removeEmployee(id);

         return  ResponseEntity.noContent().build();
           }


    private ResponseEntity<Employee> getEmployeeEntity(Employee editedEmployee, String path){
           var uri = ServletUriComponentsBuilder.fromCurrentRequest().
           path(path).buildAndExpand(editedEmployee.getId()).toUri();
        return ResponseEntity.created(uri).body(editedEmployee);
    }
}
