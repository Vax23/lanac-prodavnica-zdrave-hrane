package controllers;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import entities.Kupovina;
import services.KupovinaService;


@ManagedBean
public class KupovinaController {
	
	private String idk="";
	private String idKupca="";
    private String idProizvoda="";
    private String kolicina="";
	
    
	@EJB
	private KupovinaService service;
	

	public String getIdk() {
		return idk;
	}
	
	public void setIdk(String idk) {
		this.idk=idk;
	}
	
	public String getIdKupca() {
		return idKupca;
	}

	public void setIdKupca(String idKupca) {
		this.idKupca = idKupca;
	}

	public String getIdProizvoda() {
		return idProizvoda;
	}

	public void setIdProizvoda(String idProizvoda) {
		this.idProizvoda = idProizvoda;
	}

	public String getKolicina() {
		return kolicina;
	}

	public void setKolicina(String kolicina) {
		this.kolicina = kolicina;
	}
	

	public void dodajKupovinu(String idk, String idKupca, String idProizvoda, String kolicina) {
		service.addKupovina(idk, idKupca, idProizvoda, kolicina);
	}
	
	public List<Kupovina> listKupovina(){
		List<Kupovina> sveKupovine=service.listKupovina();
		return sveKupovine;
	}

}
