package com.omnidata.app1.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND,reason = "employee not found with this id")
public class EmployeeByIdNotFoundException extends RuntimeException {

}
