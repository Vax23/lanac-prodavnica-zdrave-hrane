package entities;
import javax.persistence.*;

@Entity
@Table(name="kupovina")
public class Kupovina {
	
	@Id
	@Column(name="id")
	private int id;
	@Column(name="idkupac")
	private int idKupca;
	@Column(name="idproizvod")
	private int idProizvoda;
	@Column(name="kolicina")
	private int kolicina;
	@Column(name="status")
	private String status;
	
	
	public Kupovina() {
		
	}
	
	public Kupovina(int id, int idKupca, int idProizvoda, int kolicina) {
		this.id=id;
		this.idKupca=idKupca;
		this.idProizvoda=idProizvoda;
		this.kolicina=kolicina;
	}
	

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	
	public int getIdKupca() {
		return idKupca;
	}
	
	public void setIdKupca(int idKupca) {
		this.idKupca=idKupca;
	}
	
	public int getIdProizvoda() {
		return idProizvoda;
	}
	
	public void setIdProizvoda(int idProizvoda) {
		this.idProizvoda=idProizvoda;
	}
	
	public int getKolicina() {
		return kolicina;
	}
	
	public void setKolicina(int kolicina) {
		this.kolicina=kolicina;
	}
	
	public void setStatus(String status)
	{
		this.status=status;
	}
	public String getStatus()
	{
		return this.status;
	}
}