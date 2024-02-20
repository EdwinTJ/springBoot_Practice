package cmsSoftware.cmsSchool.student;

import cmsSoftware.cmsSchool.student.exceptions.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
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

    @GetMapping("/students/{id}")
    StudentModel getStudentById(@PathVariable Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
    }

    @DeleteMapping("/students/{id}")
    String deleteStudent(@PathVariable Long id) {
        if (!studentRepository.existsById(id)) {
            throw new StudentNotFoundException(id);
        }
        studentRepository.deleteById(id);
        return "Student with id " + id + " has been deleted.";
    }

    @PutMapping("/students/{id}")
    StudentModel updateStudent(@RequestBody StudentModel newStudent, @PathVariable Long id) {
        return studentRepository.findById(id)
                .map(student -> {
                    student.setName(newStudent.getName());
                    return studentRepository.save(student);
                })
                .orElseThrow(() -> new StudentNotFoundException(id));
    }
}
