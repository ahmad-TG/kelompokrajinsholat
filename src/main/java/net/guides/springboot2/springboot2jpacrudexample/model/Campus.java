package net.guides.springboot2.springboot2jpacrudexample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "campus")
public class Campus {

	private long id;
	private String campusName;
	private String rektorName;
	private String emailId;
        private int thnlahir;
	
	public Campus() {
		
	}
	
	public Campus(String campusName, String rektorName, String emailId, int tahunlahir) {
		this.campusName = campusName;
		this.rektorName = rektorName;
		this.emailId = emailId;
                this.thnlahir = tahunlahir;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name = "campus_name", nullable = false)
	public String getCampusName() {
		return campusName;
	}
	public void setCampusName(String campusName) {
		this.campusName = campusName;
	}
	
	@Column(name = "rektor_name", nullable = false)
	public String getRektorName() {
		return rektorName;
	}
	public void setRektorName(String rektorName) {
		this.rektorName = rektorName;
	}
	
	@Column(name = "email_address", nullable = false)
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
        @Column(name = "tahun_lahir", nullable = false)
	public int getTahunLahir() {
		return thnlahir;
	}
	public void setTahunLahir(int thnlahir) {
		this.thnlahir = thnlahir;
	}

	@Override
	public String toString() {
		return "Campus [id=" + id + ", CampusName=" + campusName + ", RektorName=" + rektorName + ", emailId=" + emailId
				+ ", TahunLahir=" + thnlahir + "]";
	}
	
}

