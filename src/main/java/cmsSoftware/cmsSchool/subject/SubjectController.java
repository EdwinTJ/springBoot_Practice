package cmsSoftware.cmsSchool.subject;

import cmsSoftware.cmsSchool.student.StudentModel;
import cmsSoftware.cmsSchool.student.StudentRepository;
import cmsSoftware.cmsSchool.teacher.TeacherModel;
import cmsSoftware.cmsSchool.teacher.TeacherRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubjectController {

    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    TeacherRepository teacherRepository;

    @GetMapping("/subjects")
    public List<SubjectModel> getSubjects() {
        return subjectRepository.findAll();
    }

    @PostMapping("/subjects")
    public SubjectModel createSubject(@RequestBody SubjectModel subject) {
        return subjectRepository.save(subject);
    }

    @PutMapping("/subjects/{subjectId}/students/{studentId}")
    public SubjectModel addStudentToSubject(
            @PathVariable Long subjectId,
            @PathVariable Long studentId
    ) {
        SubjectModel subject = subjectRepository.findById(subjectId).get();
        StudentModel student = studentRepository.findById(studentId).get();
        subject.enrolledStudents.add(student);
        return subjectRepository.save(subject);
    }

    @PutMapping("subjects/{subjectId}/teacher/{teacherId}")
    public SubjectModel assignTeacherToSubject(
            @PathVariable Long subjectId,
            @PathVariable Long teacherId
    ) {
        SubjectModel subject = subjectRepository.findById(subjectId).get();
        TeacherModel teacher = teacherRepository.findById(teacherId).get();
        subject.setTeacher(teacher);
        return subjectRepository.save(subject);
    }
}
