package com.bootcamp.spring.model;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private List<Course> courses;

    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getCourses() { return courses; }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public void addCourse(Course course){
        this.courses.add(course);
    }

    public Double calculateAverageScore(){
        Double sum = this.courses
                .stream()
                .mapToDouble(course ->(course.getScore()))
                .reduce(Double::sum)
                .orElse(0);
        System.out.println(sum);
        return sum / this.courses.size();
    }
}
