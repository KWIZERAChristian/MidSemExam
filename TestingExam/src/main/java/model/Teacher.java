package model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "tbl_teacher")
public class Teacher {
	
	@Id
	@Column(name = "teacher_code")
	private String code;
	
	@Column(name = "name")
	private String name;
	
	@Enumerated(EnumType.STRING)
	private TeacherEnum qualification;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "tbl_teachers_courses",
		joinColumns = @JoinColumn(name = "teacher_code"),
		inverseJoinColumns = @JoinColumn(name = "course_code")
			)
	private List<Course> courses = new ArrayList<>();

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TeacherEnum getQualification() {
		return qualification;
	}

	public void setQualification(TeacherEnum qualification) {
		this.qualification = qualification;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
}
