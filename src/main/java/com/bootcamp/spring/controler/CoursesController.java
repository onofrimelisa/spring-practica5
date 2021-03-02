package com.bootcamp.spring.controler;

import com.bootcamp.spring.dto.CourseDTO;
import com.bootcamp.spring.dto.DegreeDTO;
import com.bootcamp.spring.dto.StudentDTO;
import com.bootcamp.spring.model.Course;
import com.bootcamp.spring.model.Student;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class CoursesController {
    
    @PostMapping("/calculate")
    public DegreeDTO calculateAverageScore(@RequestBody StudentDTO studentDTO) {
        Student student = new Student(studentDTO.getName());

        for (CourseDTO courseDTO :
                studentDTO.getCourses()) {
            Course course = new Course(courseDTO.getName(), courseDTO.getScore());
            student.addCourse(course);
        }

        DegreeDTO response = new DegreeDTO();
        Double averageScore = student.calculateAverageScore();
        response.setAverageScore(averageScore);
        response.setStudent(studentDTO);
        if (averageScore > 9) {
            response.setMessage("¡Congratulations for your outstanding performance!");
        }else{
            response.setMessage("Well done! It was a plesure to see you growing the way you did this year.");
        }

        return response;
    }
    
}
