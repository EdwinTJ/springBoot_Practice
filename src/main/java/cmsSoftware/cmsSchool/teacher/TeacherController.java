package cmsSoftware.cmsSchool.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeacherController {
    @Autowired
    TeacherRepository teacherRepository;

    @GetMapping("/teachers")
    List<TeacherModel> getTeachers() {
        return teacherRepository.findAll();
    }

    @PostMapping("/teachers")
    TeacherModel createTeacher(@RequestBody TeacherModel teacher) {
        return teacherRepository.save(teacher);
    }
}
