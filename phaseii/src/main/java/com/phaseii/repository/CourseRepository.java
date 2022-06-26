package com.phaseii.repository;

import com.phaseii.domain.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepository {

    private static List<Course> courses = new ArrayList<>();

    private static long counter =0;
    static {
        courses.add(new Course(++counter,"WAA","CS-543"));
        courses.add(new Course(++counter,"MWA","CS-546"));
    }

    public List<Course> findAll(){
        return courses.stream().filter(course -> course.isDeleted()==false).toList();
    }

    public Course save(Course course){
        course.setId(++counter);
        courses.add(course);
        return course;
    }

    public Course update(Course course, Long id){
        var mayBeCourse = courses.stream().filter(c -> c.getId().equals(id)).findFirst();
        if(mayBeCourse.isPresent()){
            courses.remove(mayBeCourse.get());
            course.setId(id);
            courses.add(course);
        }
        return course;
    }

    public void delete(Long id){
        var mayBeCourse = courses.stream().filter(stu -> stu.getId().equals(id)).findFirst();
        if(mayBeCourse.isPresent()){
            courses.remove(mayBeCourse.get());
            var course = mayBeCourse.get();
            course.setDeleted(true);
            courses.add(course);
        }
    }

    public Course findById(Long id){
        return courses.stream().filter(stu -> stu.getId().equals(id)).findFirst().get();
    }
}
