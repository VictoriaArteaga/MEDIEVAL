package com.medieval.clinicalCases.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    private String id;
    private String name;
    private String description;
    private Permission permission;
    private boolean state;
}
