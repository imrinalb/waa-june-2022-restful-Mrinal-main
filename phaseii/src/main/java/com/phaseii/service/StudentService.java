package com.phaseii.service;

import com.phaseii.dto.CourseDto;
import com.phaseii.dto.StudentDto;
import com.phaseii.dto.StudentV2Dto;

import java.util.List;

public interface StudentService {

    List<StudentDto> findAll();

    StudentDto findById(Long id);

    StudentDto save(StudentDto student);

    StudentDto update(StudentDto student, Long id);

    void remove(Long id);

    List<StudentV2Dto> getStudentsByMajor(String major);

    List<CourseDto> getCoursesByStudentId(Long studentId);
}
