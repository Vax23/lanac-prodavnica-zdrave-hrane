
import javax.persistence.*;

@Entity
@Table(name="kupci")
public class Kupci {
	
	@Id
	@Column(name = "id")
	private int id;
	@Column(name="ime")
	private String ime;
	@Column(name="prezime")
	private String prezime;
	@Column(name="adresa")
	private String adresa;
	@Column(name="racun")
	private int racun;
	
	
	public Kupci() {
		
	}
	
	public Kupci(int id, String ime, String prezime, String adresa, int racun) {
		this.id=id;
		this.ime=ime;
		this.prezime=prezime;
		this.adresa=adresa;
		this.racun=racun;
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
	
	public String getAdresa() {
		return adresa;
	}
	
	public void setAdresa(String adresa) {
		this.adresa=adresa;
	}
	
	public int getRacun() {
		return racun;
	}
	
	public void setRacun(int racun) {
		this.racun=racun;
	}
}