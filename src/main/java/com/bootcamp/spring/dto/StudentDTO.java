package com.bootcamp.spring.dto;

import java.util.List;

public class StudentDTO {
    private String name;
    private List<CourseDTO> courses;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CourseDTO> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseDTO> courses) {
        this.courses = courses;
    }
}
