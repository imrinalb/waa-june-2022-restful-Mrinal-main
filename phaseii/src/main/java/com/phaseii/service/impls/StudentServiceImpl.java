package com.phaseii.service.impls;

import com.phaseii.domain.Course;
import com.phaseii.domain.Student;
import com.phaseii.dto.CourseDto;
import com.phaseii.dto.StudentDto;
import com.phaseii.dto.StudentV2Dto;
import com.phaseii.repository.StudentRepository;
import com.phaseii.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentDto> findAll() {
        var students =  studentRepository.findAll();
        return students.stream().map(student -> new StudentDto(student.getId(),student.getFirstName(),student.getLastName(),student.getEmail(),student.getMajor(),student.getCoursesTaken().stream().map(course -> new CourseDto(course.getId(),course.getName(),course.getCode())).collect(Collectors.toList()))).toList();
    }

    @Override
    public StudentDto findById(Long id) {
        var student =  studentRepository.findById(id);
        return new StudentDto(student.getId(),student.getFirstName(),student.getLastName(),student.getEmail(),student.getMajor(),student.getCoursesTaken().stream().map(course -> new CourseDto(course.getId(),course.getName(),course.getCode())).collect(Collectors.toList()));
    }

    @Override
    public StudentDto save(StudentDto studentDto) {
        var student =  studentRepository.save(new Student(studentDto.getId(), studentDto.getFirstName(),studentDto.getLastName(),studentDto.getEmail(),studentDto.getMajor(),studentDto.getCoursesTaken().stream().map(course -> new Course(course.getId(),course.getName(),course.getCode())).collect(Collectors.toList())));
        return new StudentDto(student.getId(),student.getFirstName(),student.getLastName(),student.getEmail(),student.getMajor(),student.getCoursesTaken().stream().map(course -> new CourseDto(course.getId(),course.getName(),course.getCode())).collect(Collectors.toList()));
    }

    @Override
    public StudentDto update(StudentDto studentDto, Long id) {
        var student =  studentRepository.update(new Student(studentDto.getId(), studentDto.getFirstName(),studentDto.getLastName(),studentDto.getEmail(),studentDto.getMajor(),studentDto.getCoursesTaken().stream().map(course -> new Course(course.getId(),course.getName(),course.getCode())).collect(Collectors.toList())),id);
        return new StudentDto(student.getId(),student.getFirstName(),student.getLastName(),student.getEmail(),student.getMajor(),student.getCoursesTaken().stream().map(course -> new CourseDto(course.getId(),course.getName(),course.getCode())).collect(Collectors.toList()));
    }

    @Override
    public void remove(Long id) {
        studentRepository.delete(id);
    }

    @Override
    public List<StudentV2Dto> getStudentsByMajor(String major) {
        return studentRepository.findAll().stream()
                .filter(student -> student.getMajor().equals(major))
                .map(student -> new StudentV2Dto(student.getId(),student.getFirstName(),student.getLastName(),student.getEmail(),student.getMajor(),student.getGpa(),student.getCoursesTaken().stream().map(course -> new CourseDto(course.getId(),course.getName(),course.getCode())).collect(Collectors.toList())))
                .collect(Collectors.toList());
    }

    @Override
    public List<CourseDto> getCoursesByStudentId(Long studentId) {
        var courses =  studentRepository.findById(studentId).getCoursesTaken();
        return courses.stream().map(course -> new CourseDto(course.getId(),course.getName(),course.getCode())).collect(Collectors.toList());
    }
}
