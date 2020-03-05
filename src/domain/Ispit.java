package domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="ISPIT")
public class Ispit implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE,generator = "GEN_KORISNIK")
	@TableGenerator(name = "GEN_KORISNIK",table = "GEN_ID",
					pkColumnName = "PK_GEN",valueColumnName = "VALUE_GEN",
					initialValue = 0, allocationSize = 1)
	private long id;
	
	private List<Student> studenti;
	
	private Predmet predmet;
	
	@Temporal(TemporalType.DATE)
	private Date terminPolaganja;
	
	
	private List<Profesor> profesori;
	private int ocena;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Predmet getPredmet() {
		return predmet;
	}
	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}
	public Date getTerminPolaganja() {
		return terminPolaganja;
	}
	public void setTerminPolaganja(Date terminPolaganja) {
		this.terminPolaganja = terminPolaganja;
	}
	
	public int getOcena() {
		return ocena;
	}
	public void setOcena(int ocena) {
		this.ocena = ocena;
	}

	public List<Student> getStudenti() {
		return studenti;
	}

	public void setStudenti(List<Student> studenti) {
		this.studenti = studenti;
	}

	public List<Profesor> getProfesori() {
		return profesori;
	}

	public void setProfesori(List<Profesor> profesori) {
		this.profesori = profesori;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Ispit(List<Student> studenti, Predmet predmet, Date terminPolaganja, List<Profesor> profesori, int ocena) {
		super();
		this.studenti = studenti;
		this.predmet = predmet;
		this.terminPolaganja = terminPolaganja;
		this.profesori = profesori;
		this.ocena = ocena;
	}

	public Ispit() {
		
	}
	
	

}
