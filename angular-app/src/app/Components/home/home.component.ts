import {Component, OnInit, ViewChild} from '@angular/core';
import {EmployeeService} from '../../Services/employee.service';
import {Employee} from '../../models/employee';
import {EditEmployeeComponent} from '../edit-employee/edit-employee.component';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
 employees: Employee[] = [];
 errors = [];
  @ViewChild('modal') private employeeModel: EditEmployeeComponent ;

  constructor(private employeeService: EmployeeService) { }

  ngOnInit(): void {
    this.employeeService.getEmployees().subscribe(resp => {
      this.employees = resp;
      console.log('employees', this.employees);
    }, error => this.errors = error);
  }

  onEmployeeRemoved = (emp: Employee) => {
    this.employeeService.removeEmployee(emp).subscribe(resp => {
     this.employees = this.employees.filter(e => e.id !== emp.id);
    });
  }

  onUpdate = async (emp: Employee) => {
   await this.employeeModel.open('update employee', {...emp});
   await this.employeeService.updateEmployee(emp).subscribe(resp => {

    });
  }

  onEmployeeSaved($employee: Employee) {
    const index = this.employees.findIndex(emp => emp.id === $employee.id);
    this.employees[index] = $employee;
  }
  onEmployeeAdded($emp: Employee) {
   this.employees.unshift($emp);
  }

  onAdd = async () => {
    await this.employeeModel.open('Add new  employee', new Employee());
  }


}
