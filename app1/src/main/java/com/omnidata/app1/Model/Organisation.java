package com.omnidata.app1.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Organisation implements Serializable {

    private Integer id;
    private String name;
    private String specialty;
}
