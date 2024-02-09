package cmsSoftware.cmsSchool.classroom;

import cmsSoftware.cmsSchool.student.StudentModel;
import cmsSoftware.cmsSchool.student.StudentRepository;
import cmsSoftware.cmsSchool.teacher.TeacherModel;
import cmsSoftware.cmsSchool.teacher.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClassRoomController {

    @Autowired
    ClassRoomRepository classRoomRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    TeacherRepository teacherRepository;

    @GetMapping("/classrooms")
    List<ClassRoomModel> getClassRooms() {
        return classRoomRepository.findAll();
    }

    @PostMapping("/classrooms")
    ClassRoomModel createClassRoom(@RequestBody ClassRoomModel classRoom) {
        return classRoomRepository.save(classRoom);
    }

    @PutMapping("/classrooms/{classRoomId}/students/{studentId}")
    ClassRoomModel addStudentToClassRoom(
            @PathVariable Long classRoomId,
            @PathVariable Long studentId
    ) {
        ClassRoomModel classRoom = classRoomRepository.findById(classRoomId).get();
        StudentModel student = studentRepository.findById(studentId).get();
        classRoom.classRoomStudents.add(student);
        return classRoomRepository.save(classRoom);
    }

    @PutMapping("/classrooms/{classRoomId}/teacher/{teacherId}")
    ClassRoomModel assignTeacherToClassRoom(
            @PathVariable Long classRoomId,
            @PathVariable Long teacherId
    ) {
        ClassRoomModel classRoom = classRoomRepository.findById(classRoomId).get();
        TeacherModel teacher = teacherRepository.findById(teacherId).get();
        classRoom.setTeacher(teacher);
        return classRoomRepository.save(classRoom);
    }
}
