package controllers;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import entities.Proizvodi;
import services.ProizvodiService;

@ManagedBean
public class ProizvodiController {
	
	private String idp="";
    private String naziv="";
    private String cena="";
    private String dostupno="";
    
    private String bidp=""; 
    
    private String aidp="";
    private String acena=""; 

    
	@EJB
	private ProizvodiService service;
	
	public String getIdp() {
		return idp;
	}
	
	public void setIdp(String idp) {
		this.idp=idp;
	}
	
	public  String getNaziv() {
		return naziv;
	}
	
	public void setNaziv(String naziv) {
		this.naziv=naziv;
	}
	
	public String getCena() {
		return cena;
	}

	public void setCena(String cena) {
		this.cena = cena;
	}
	
	public  String getDostupno() {
		return dostupno;
	}
	
	public void setDostupno(String dostupno) {
		this.dostupno=dostupno;
	}
	
	public String getBidp() {
		return bidp;
	}

	public void setBidp(String bidp) {
		this.bidp = bidp;
	}
	
	public  String getAidp() {
		return aidp;
	}
	
	public void setAidp(String aidp) {
		this.aidp=aidp;
	}
	
	public  String getAcena() {
		return acena;
	}
	
	public void setAcena(String acena) {
		this.acena=acena;
	}
	
	
	public void dodajProizvod(String idp, String naziv, String cena, String dostupno) {
		service.addProizvod(idp, naziv,cena,dostupno);
	}
          
	public void brisiProizvod(String bidp){
		service.deleteProizvod(bidp);
	}
	
	public void azurirajProizvod(String aidp, String acena) {
		service.updateProizvod(aidp,acena);
	}
	
	public List<Proizvodi> listProizvoda(){
		List<Proizvodi> sviProizvodi=service.listProizvodi();
		return sviProizvodi;
	}
}