import { Injectable } from '@angular/core';
import {environment} from '../../environments/environment';
import {Observable} from 'rxjs';
import {Employee} from '../models/employee';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
 private  employeeUrl = environment.apiUrl + 'employees';

  constructor(private  httpClient: HttpClient) { }

  getEmployees(): Observable<Employee[]>{
  return this.httpClient.get<Employee[]>(this.employeeUrl);
  }

  removeEmployee(emp: Employee): Observable<any> {
    return this.httpClient.delete<any>(this.employeeUrl + '/' + emp.id);
  }

  updateEmployee(emp: Employee): Observable<Employee> {
    console.log('update emp', emp);

    return this.httpClient.put<Employee>(this.employeeUrl + '/' + emp.id, emp);
  }

  addEmployee(employee: Employee): Observable<Employee> {
    return this.httpClient.post<Employee>(this.employeeUrl, employee);

  }
}
