package cmsSoftware.cmsSchool.teacher;

import cmsSoftware.cmsSchool.teacher.exception.TeacherNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeacherController {
    @Autowired
    TeacherRepository teacherRepository;

    @GetMapping("/teachers")
    public List<TeacherModel> getTeachers() {
        return teacherRepository.findAll();
    }

    @PostMapping("/teachers")
    public TeacherModel createTeacher(@RequestBody TeacherModel teacher) {
        return teacherRepository.save(teacher);
    }

    @GetMapping("/teachers/{id}")
    public TeacherModel getTeacher(@PathVariable Long id) {
        return teacherRepository.findById(id).orElseThrow(() -> new TeacherNotFoundException(id));
    }

    @DeleteMapping("/teachers/{id}")
    public String deleteTeacher(@PathVariable Long id) {
        if (!teacherRepository.existsById(id)) {
            throw new TeacherNotFoundException(id);
        }
        teacherRepository.deleteById(id);
        return "Teacher with id " + id + " has been deleted.";
    }

    @PutMapping("/teachers/{id}")
    public TeacherModel updateTeacher(@RequestBody TeacherModel newTeacher, @PathVariable Long id) {
        return teacherRepository.findById(id).map(teacher -> {
            teacher.setName(newTeacher.getName());
            return teacherRepository.save(teacher);
        }).orElseThrow(() -> new TeacherNotFoundException(id));
    }
}
