
import javax.persistence.*;

@Entity
@Table(name="zaposleni")
public class Zaposleni {
	
	@Id
	@Column(name="id")
	private int id;
	@Column(name="ime")
	private String ime;
	@Column(name="prezime")
	private String prezime;
	@Column(name = "plata")
	private int plata;
	
	
	public Zaposleni() {
		
	}
	
	public Zaposleni(int id,String ime, String prezime, int plata) {
		this.setId(id);
		this.setIme(ime);
		this.setPrezime(prezime);
		this.setPlata(plata);
	}
	
	
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id=id;
	}

	public String getIme() {
		return ime;
	}
	
	public void setIme(String ime) {
		this.ime=ime;
	}
	
	public String getPrezime() {
		return prezime;
	}
	
	public void setPrezime(String prezime) {
		this.prezime=prezime;
	}
	
	public int getPlata() {
		return plata;
	}
	
	public void setPlata(int plata) {
		this.plata=plata;
	}
}