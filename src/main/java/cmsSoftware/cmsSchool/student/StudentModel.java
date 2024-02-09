package cmsSoftware.cmsSchool.student;

import cmsSoftware.cmsSchool.classroom.ClassRoomModel;
import cmsSoftware.cmsSchool.subject.SubjectModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class StudentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy ="enrolledStudents", cascade = CascadeType.ALL)
    private Set<SubjectModel> subjects = new HashSet<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "classRoomStudents", cascade = CascadeType.ALL)
    private Set<ClassRoomModel> classRooms = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<SubjectModel> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<SubjectModel> subjects) {
        this.subjects = subjects;
    }
}
