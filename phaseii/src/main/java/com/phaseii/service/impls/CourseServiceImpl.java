package com.phaseii.service.impls;

import com.phaseii.domain.Course;
import com.phaseii.dto.CourseDto;
import com.phaseii.repository.CourseRepository;
import com.phaseii.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    @Override
    public List<CourseDto> findAll() {
        var courses = courseRepository.findAll();
        return courses.stream().map(course -> new CourseDto(course.getId(),course.getName(),course.getCode())).collect(Collectors.toList());
    }

    @Override
    public CourseDto findById(Long id) {
        var course =  courseRepository.findById(id);
        return new CourseDto(course.getId(),  course.getName(), course.getCode());
    }

    @Override
    public CourseDto save(CourseDto courseDto) {
        var course = courseRepository.save(new Course(courseDto.getId(), courseDto.getName(),courseDto.getCode()));
        return new CourseDto(courseDto.getId(), courseDto.getCode(), course.getName());
    }

    @Override
    public CourseDto update(CourseDto courseDto, Long id) {
        var course = courseRepository.update(new Course(courseDto.getId(), courseDto.getName(),courseDto.getCode()),id);
        return new CourseDto(courseDto.getId(), courseDto.getCode(), course.getName());
    }

    @Override
    public void remove(Long id) {
        courseRepository.delete(id);
    }
}
