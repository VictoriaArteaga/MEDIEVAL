package com.medieval.clinicalCases.domain.model;

import com.medieval.clinicalCases.domain.enums.DifficultyType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClinicalCase {

    private String id;
    private String title;
    private String description;
    private Speciality speciality;
    private User Author;
    private DifficultyType difficulty;
    private int estimatedTime;
    private Date creationDate;
}
