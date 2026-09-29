package com.medieval.clinicalCases.domain.model;

import com.medieval.clinicalCases.domain.enums.ParameterType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Parameter {

    private String id;
    private String name;
    private String value;
    private ParameterType type;
    private boolean obligatory;
}
