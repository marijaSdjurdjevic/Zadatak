package domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="PROFESOR")
public class Profesor extends Korisnik{
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name="PREDMET_ID", referencedColumnName = "ID")
	private List<Predmet> predmeti;
	
	private ProfesorUloga zvanje;
	
	@Temporal(TemporalType.DATE)
	private Date datumZasnivanjaRadnogOdnosa;

	public List<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(List<Predmet> predmeti) {
		this.predmeti = predmeti;
	}

	public ProfesorUloga getZvanje() {
		return zvanje;
	}

	public void setZvanje(ProfesorUloga zvanje) {
		this.zvanje = zvanje;
	}

	public Date getDatumZasnivanjaRadnogOdnosa() {
		return datumZasnivanjaRadnogOdnosa;
	}

	public void setDatumZasnivanjaRadnogOdnosa(Date datumZasnivanjaRadnogOdnosa) {
		this.datumZasnivanjaRadnogOdnosa = datumZasnivanjaRadnogOdnosa;
	}

	public Profesor(long id, String firstName, String lastName, Department department, KorisnickaUloga uloga,
			List<Predmet> predmeti, ProfesorUloga zvanje, Date datumZasnivanjaRadnogOdnosa) {
		super(id, firstName, lastName, department, uloga);
		this.predmeti = predmeti;
		this.zvanje = zvanje;
		this.datumZasnivanjaRadnogOdnosa = datumZasnivanjaRadnogOdnosa;
	}

	public Profesor() {
		
	}

	@Override
	public String toString() {
		return "Profesor [zvanje=" + zvanje + ", datumZasnivanjaRadnogOdnosa=" + datumZasnivanjaRadnogOdnosa + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((datumZasnivanjaRadnogOdnosa == null) ? 0 : datumZasnivanjaRadnogOdnosa.hashCode());
		result = prime * result + ((zvanje == null) ? 0 : zvanje.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profesor other = (Profesor) obj;
		if (datumZasnivanjaRadnogOdnosa == null) {
			if (other.datumZasnivanjaRadnogOdnosa != null)
				return false;
		} else if (!datumZasnivanjaRadnogOdnosa.equals(other.datumZasnivanjaRadnogOdnosa))
			return false;
		if (zvanje != other.zvanje)
			return false;
		return true;
	}

	
}
	