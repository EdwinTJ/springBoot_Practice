package cmsSoftware.cmsSchool.classroom;

import cmsSoftware.cmsSchool.student.StudentModel;
import cmsSoftware.cmsSchool.teacher.TeacherModel;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class ClassRoomModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String grade;
    private String level;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    private TeacherModel teacher;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "classroom_student",
            joinColumns = @JoinColumn(name = "classroom_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    protected Set<StudentModel> classRoomStudents = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public TeacherModel getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherModel teacher) {
        this.teacher = teacher;
    }

    public Set<StudentModel> getClassRoomStudents() {
        return classRoomStudents;
    }

    public void setClassRoomStudents(Set<StudentModel> classRoomStudents) {
        this.classRoomStudents = classRoomStudents;
    }
}
