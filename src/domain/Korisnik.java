package domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="KORISNIK")
public class Korisnik {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE,generator = "GEN_KORISNIK")
	@TableGenerator(name = "GEN_KORISNIK",table = "GEN_ID",
					pkColumnName = "PK_GEN",valueColumnName = "VALUE_GEN",
					initialValue = 0, allocationSize = 1)
	private long id;
	private String firstName;
	private String lastName;
	
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "PEPARTMENT_ID")
	private Department department;
	
	
	@Enumerated(EnumType.STRING)
	private KorisnickaUloga uloga;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public Department getDepartment() {
		return department;
	}


	public void setDepartment(Department department) {
		this.department = department;
	}


	public KorisnickaUloga getUloga() {
		return uloga;
	}


	public void setUloga(KorisnickaUloga uloga) {
		this.uloga = uloga;
	}


	public Korisnik(long id, String firstName, String lastName, Department department, KorisnickaUloga uloga) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.uloga = uloga;
	}


	public Korisnik() {
		
	}


	@Override
	public String toString() {
		return "Korisnik [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", department="
				+ department + ", uloga=" + uloga + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((department == null) ? 0 : department.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((uloga == null) ? 0 : uloga.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Korisnik other = (Korisnik) obj;
		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id != other.id)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (uloga != other.uloga)
			return false;
		return true;
	}
	
	

}
