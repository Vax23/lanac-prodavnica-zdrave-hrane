
import javax.persistence.*;

@Entity
@Table(name="proizvodi")
public class Proizvodi {
	
	@Id
	@Column(name="id")
	private int id;
	@Column(name="naziv")
	private String naziv;
	@Column(name="cena")
	private int cena;
	@Column(name = "dostupno")
	private int dostupno;
	
	
	public Proizvodi() {
		
	}
	
	public Proizvodi(int id, String naziv, int cena, int dostupno) {
		this.id=id;
		this.naziv=naziv;
		this.cena=cena;
		this.dostupno=dostupno;
	}
	
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id=id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public int getCena() {
		return cena;
	}

	public void setCena(int cena) {
		this.cena = cena;
	}

	public int getDostupno() {
		return dostupno;
	}

	public void setDostupno(int dostupno) {
		this.dostupno = dostupno;
	}
	
	
}