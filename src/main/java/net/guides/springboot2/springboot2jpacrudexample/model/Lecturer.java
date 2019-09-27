package net.guides.springboot2.springboot2jpacrudexample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lecturer")
public class Lecturer {
	
	private long id;
	private int idDosen;
	private String firstName;
	private String lastName;
	private String alamat;
	private int noTlp;
	
	public Lecturer() {
		
	}
	 public Lecturer(int idDosen, String firstName, String lastName, String alamat, int noTlp)
	 { this.idDosen = idDosen;
	   this.firstName = firstName;
	   this.lastName = lastName ;
	   this.alamat = alamat;
	   this.noTlp = noTlp;
	   
	 }
	 @Id
	 
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 public long getid() {
		 return id;
	 }
	 public void setid(long id) {
		 this.id = id;
	 }
	@Column(name = "idDosen", nullable = false)
     public int getIdDosen() {
		return idDosen;
	}
	public void setIdDosen(int idDosen) {
		this.idDosen = idDosen;
	}
	@Column(name = "first_name", nullable = false)
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName (String firstName) {
		this.firstName = firstName;
	}
	@Column(name = "last_name", nullable = false)
	public String getLastName() {
		return lastName;
	}
	public void setLastName (String lastName) {
		this.lastName = lastName;
	}
	@Column(name = "alamat", nullable = false)
	public String getAlamat() {
		return alamat;
	}
	public void setAlamat(String alamat) 
	{
		this.alamat = alamat;
	}
	@Column(name = "noTlp", nullable = false)
	public int getNoTlp() 
	{
		return noTlp;
	}
	public void setNoTlp(int noTlp)
	{
		this.noTlp = noTlp;
	}
	@Override
	public String toString() {
		return "Lecturer [id=" + id + ",idDosen" + idDosen + ", firstName=" + firstName + ", lastName=" + lastName + ", alamat=" + alamat + 
				"noTlp = " + noTlp + "]";
	}
}
