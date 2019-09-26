package net.guides.springboot2.springboot2jpacrudexample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course {

	private int id_course;
	private String nm_course;
	private int jml_sks;
	private int id_dosen;
	private int semester;
	
	public Course() {
		
	}
	
	public Course(int id_course, String nm_course, int jml_sks, int id_dosen,int semester) {
		this.id_course = id_course;
		this.nm_course = nm_course;
		this.jml_sks = jml_sks;
		this.id_dosen = id_dosen;
		this.semester = semester;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id_course;
	}
	public void setId(int id_course) {
		this.id_course = id_course;
	}
	
	@Column(name = "nm_course", nullable = false)
	public String getNmCourse() {
		return nm_course;
	}
	public void setNmCourse(String nm_course) {
		this.nm_course = nm_course;
	}
	
	@Column(name = "jml_sks", nullable = false)
	public int getjmlSks() {
		return jml_sks;
	}
	public void setjmlSks(int jml_sks) {
		this.jml_sks = jml_sks;
	}
	
	@Column(name = "id_dosen", nullable = false)
	public int getIdDosen() {
		return id_dosen;
	}
	public void setIdDosen(int id_dosen) {
		this.id_dosen = id_dosen;
	}
	@Column(name = "semester", nullable = false)
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}

	@Override
	public String toString() {
		return "Course [id=" + id_course + ", namaCourse=" + nm_course + ", jmlsks=" + jml_sks + ", id_dosen=" + id_dosen + ", semester=" + semester
				+ "]";
	}
	
}
