package domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PREDMET")
public class Predmet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String naziv;
	private int espb;
	private Date termin;
	
	@ManyToOne
	@JoinColumn()
	private Profesor profesor;
	
	private Department department;
	

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public int getEspb() {
		return espb;
	}

	public void setEspb(int espb) {
		this.espb = espb;
	}

	public Date getTermin() {
		return termin;
	}

	public void setTermin(Date termin) {
		this.termin = termin;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	

	public Predmet(long id, String naziv, int espb, Date termin, Profesor profesor, Department department) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.espb = espb;
		this.termin = termin;
		this.profesor = profesor;
		this.department = department;
	}
	
	

	public Predmet() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((department == null) ? 0 : department.hashCode());
		result = prime * result + espb;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((naziv == null) ? 0 : naziv.hashCode());
		result = prime * result + ((profesor == null) ? 0 : profesor.hashCode());
		result = prime * result + ((termin == null) ? 0 : termin.hashCode());
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
		Predmet other = (Predmet) obj;
		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
			return false;
		if (espb != other.espb)
			return false;
		if (id != other.id)
			return false;
		if (naziv == null) {
			if (other.naziv != null)
				return false;
		} else if (!naziv.equals(other.naziv))
			return false;
		if (profesor == null) {
			if (other.profesor != null)
				return false;
		} else if (!profesor.equals(other.profesor))
			return false;
		if (termin == null) {
			if (other.termin != null)
				return false;
		} else if (!termin.equals(other.termin))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Predmet [id=" + id + ", naziv=" + naziv + ", espb=" + espb + ", termin=" + termin + ", profesor="
				+ profesor + ", department=" + department + "]";
	}

	
}
