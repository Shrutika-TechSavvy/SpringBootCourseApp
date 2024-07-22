package com.springrest.springrest.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.springrest.springrest.Entities.Course;

@Service
public class CourseServiceImpl implements com.springrest.springrest.Services.CourseService {

    List<Course> list;

    public CourseServiceImpl() {
        list = new ArrayList<>();
        list.add(new Course(1, "Java Course", "Basics of Java"));
        list.add(new Course(2, "Spring Boot Course", "Introduction to Spring Boot"));
    }

    @Override
    public List<Course> getCourses() {
        return list;
    }

    @Override
    public Course getCourse(String courseId) {
        return list.stream().filter(course -> course.getId() == Integer.parseInt(courseId)).findFirst().orElse(null);
    }

    @Override
    public Course addCourse(Course course) {
        list.add(course);
        return course;
    }

    @Override
    public Course updateCourse(Course course) {
        list = list.stream().map(c -> {
            if (c.getId() == course.getId()) {
                c.setName(course.getName());
                c.setDescription(course.getDescription());
            }
            return c;
        }).collect(Collectors.toList());
        return course;
    }

    @Override
    public void deleteCourse(String courseId) {
        list = list.stream().filter(course -> course.getId() != Integer.parseInt(courseId)).collect(Collectors.toList());
    }
}
