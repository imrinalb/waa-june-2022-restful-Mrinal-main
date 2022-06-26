package com.phaseii.dto;

import com.phaseii.domain.Course;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class StudentDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String major;

    private List<CourseDto> coursesTaken;


}
