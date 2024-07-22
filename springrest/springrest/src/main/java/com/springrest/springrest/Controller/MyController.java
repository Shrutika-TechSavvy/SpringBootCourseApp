package com.springrest.springrest.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.springrest.springrest.Entities.Course;
import com.springrest.springrest.Services.CourseService;

@Controller
public class MyController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello, World!";
    }

    @GetMapping("/courses")
    public String getCourses(Model model) {
        List<Course> courses = courseService.getCourses();
        model.addAttribute("courses", courses);
        return "index";
    }

    @GetMapping("/courses/{courseId}")
    @ResponseBody
    public Course getCourse(@PathVariable String courseId) {
        return courseService.getCourse(courseId);
    }

    @GetMapping("/add-course")
    public String addCourseForm(Model model) {
        model.addAttribute("course", new Course());
        return "add-course";
    }

    @PostMapping("/courses")
    public String addCourse(@ModelAttribute Course course) {
        courseService.addCourse(course);
        return "redirect:/courses";
    }

    @GetMapping("/update-course/{courseId}")
    public String updateCourseForm(@PathVariable String courseId, Model model) {
        Course course = courseService.getCourse(courseId);
        model.addAttribute("course", course);
        return "update-course";
    }

    @PostMapping("/courses/update")
    public String updateCourse(@ModelAttribute Course course) {
        courseService.updateCourse(course);
        return "redirect:/courses";
    }

    @PostMapping("/courses/{courseId}")
    public String deleteCourse(@PathVariable String courseId) {
        courseService.deleteCourse(courseId);
        return "redirect:/courses";
    }
}
