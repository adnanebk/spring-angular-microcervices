import {Component, OnInit, Output, TemplateRef, ViewChild} from '@angular/core';
import { NgbModal, NgbModalRef} from '@ng-bootstrap/ng-bootstrap';
import {Employee} from '../../models/employee';
import {EmployeeService} from '../../Services/employee.service';
import { EventEmitter } from '@angular/core';
@Component({
  selector: 'app-edit-employee',
  templateUrl: './edit-employee.component.html',
  styleUrls: ['./edit-employee.component.css']
})

export class EditEmployeeComponent implements OnInit {


  employee: Employee ;
  error: any;
  title: string;

  constructor(private modalService: NgbModal, private  employeeService: EmployeeService) { }

  @Output() employeeUpdate = new EventEmitter<Employee>();
  @Output() employeeAdd = new EventEmitter<Employee>();

  private modalRef: NgbModalRef;
  @ViewChild('modal') private modalContent: TemplateRef<EditEmployeeComponent>;

  ngOnInit(): void {
  }

  open(title: string, employee: Employee): Promise<boolean> {
    this.title = title;
    this.employee = employee;
    this.error = {};
    console.log('open employee ', this.employee);
    return new Promise<boolean>(resolve => {
      this.modalRef = this.modalService.open(this.modalContent);
    });
  }

  close =  () => {
    this.error = {};
    this.modalRef.close();
  }

  dismiss = () => {
    this.modalRef.dismiss();
  }

  saveEmployee =  () => {
    console.log('emp id is ', this.employee);
    if (this.employee.id !== 0)
    this.employeeService.updateEmployee(this.employee).subscribe(resp => {
      this.employeeUpdate.emit(resp);
      this.modalRef.close();
    }, (err) => {
      this.error = err.error;
      console.log(this.error);
    });
    else
      this.employeeService.addEmployee(this.employee).subscribe(resp => {
        this.employeeAdd.emit(resp);
        this.modalRef.close();
      }, (err) => {
        this.error = err.error;
        console.log(this.error);
      });
  }

  addEmployee =  () => {
    this.employeeService.addEmployee(this.employee).subscribe(resp => {
      this.employeeAdd.emit(resp);
      this.modalRef.close();
    }, (err) => {
      this.error = err.error;
      console.log(this.error);
    });

  }



  setDate(value: any): any {
    this.employee.dateOfBirth = value;
    console.log('date is ', value);
  }
}
