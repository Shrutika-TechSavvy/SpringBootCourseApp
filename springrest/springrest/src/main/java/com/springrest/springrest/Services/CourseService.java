package com.springrest.springrest.Services;

import java.util.List;
import com.springrest.springrest.Entities.Course;

public interface CourseService {
    public List<Course> getCourses();
    public Course getCourse(String courseId);
    public Course addCourse(Course course);
    public Course updateCourse(Course course);
    public void deleteCourse(String courseId);
}
