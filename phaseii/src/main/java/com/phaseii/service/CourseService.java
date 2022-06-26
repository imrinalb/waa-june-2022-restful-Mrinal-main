package com.phaseii.service;

import com.phaseii.domain.Course;
import com.phaseii.domain.Student;
import com.phaseii.dto.CourseDto;

import java.util.List;

public interface CourseService {

    List<CourseDto> findAll();

    CourseDto findById(Long id);

    CourseDto save(CourseDto course);

    CourseDto update(CourseDto course, Long id);

    void remove(Long id);
}
