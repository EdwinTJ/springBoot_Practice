package cmsSoftware.cmsSchool.subject;

import cmsSoftware.cmsSchool.student.StudentModel;
import cmsSoftware.cmsSchool.teacher.TeacherModel;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class SubjectModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(
            name = "student_enrolled",
            joinColumns = @JoinColumn(name = "subject_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    protected Set<StudentModel> enrolledStudents = new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    private TeacherModel teacher;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<StudentModel> getEnrolledStudents() {
        return enrolledStudents;
    }

    public TeacherModel getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherModel teacher) {
        this.teacher = teacher;
    }
}
