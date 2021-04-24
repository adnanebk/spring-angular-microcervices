package com.omnidata.app1.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "you must choose an organisation")
    private Integer organisationId;
    @NotBlank(message = "Full name is required")
    private String fullName;
    @Past(message = "Date of birth must be in the past")
    private LocalDate dateOfBirth;
    @Min(value = 1, message = "experience should not be less than {value}")
    @Max(value = 20, message = "experience should not be greater than {value}")
    private int  experience;
    @NotBlank(message = "adress  is required")
    private String adress;
    @NotBlank(message = "phone is required")
    @Pattern(regexp = "^\\d{10}$",message = "the phone number is not valid")
    private String phone;

    @Transient
    private Organisation organisation;
    private LocalDate employmentDate=LocalDate.now();

    public Employee(String fullName ,String adress, String phone,LocalDate dateOfBirth,int experience,int organisationId) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.adress = adress;
        this.phone = phone;
        this.experience=experience;
        this.organisationId=organisationId;
    }
}