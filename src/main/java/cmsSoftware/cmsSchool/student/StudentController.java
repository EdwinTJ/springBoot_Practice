package cmsSoftware.cmsSchool.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/students")
    List<StudentModel> getAllStudents() {
        return studentRepository.findAll();
    }
    @PostMapping("/students")
    StudentModel createStudent(@RequestBody StudentModel student) {
        return studentRepository.save(student);
    }

}
