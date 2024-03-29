package cmsSoftware.cmsSchool.teacher;

import cmsSoftware.cmsSchool.classroom.ClassRoomModel;
import cmsSoftware.cmsSchool.subject.SubjectModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import javax.security.auth.Subject;
import java.util.Set;

@Entity
public class TeacherModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @OneToMany(mappedBy = "teacher")
    private Set<SubjectModel> subjects;

    @JsonIgnore
    @OneToMany(mappedBy = "teacher")
    private Set<ClassRoomModel> classRooms;
    private String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<SubjectModel> getSubjects() {
        return this.subjects;
    }

    public Set<ClassRoomModel> getClassRooms() {
        return classRooms;
    }

    public void setClassRooms(Set<ClassRoomModel> classRooms) {
        this.classRooms = classRooms;
    }

}
