package controllers;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entities.Kupci;
import services.KupciService;

@ViewScoped
@ManagedBean
public class KupciController{

	private String idkup="";
	private String imekup="";
    private String prezimekup="";
	private String adresa="";
	private String racun="";
	
    private String bidkup="";
    
    private String aidkup="";  
    private String aadresa="";
    
    
	@EJB
	private KupciService service;
	
	public String getIdkup() {
		return idkup;
	}
	
	public void setIdkup(String idkup) {
		this.idkup=idkup;
	}

	public String getImekup() {
		return imekup;
	}

	public void setImekup(String imekup) {
		this.imekup = imekup;
	}

	public String getPrezimekup() {
		return prezimekup;
	}

	public void setPrezimekup(String prezimekup) {
		this.prezimekup = prezimekup;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getRacun() {
		return racun;
	}

	public void setRacun(String racun) {
		this.racun = racun;
	}
	
	public String getBidkup() {
		return bidkup;
	}

	public void setBidkup(String bidkup) {
		this.bidkup = bidkup;
	}

	public String getAidkup() {
		return aidkup;
	}

	public void setAidkup(String aidkup) {
		this.aidkup = aidkup;
	}

	public String getAadresa() {
		return aadresa;
	}

	public void setAadresa(String aadresa) {
		this.aadresa = aadresa;
	}
	
	
	
	
	public void dodajKupac(String idkup,String imekup, String prezimekup,String adresa, String racun) {
		service.addKupca(idkup, imekup, prezimekup, adresa, racun);
	}

	public void brisiKupac(String bidkup){
		service.deleteKupca(bidkup);
	}
	
	public void azurirajKupac(String aidkup, String aadresa) {
		service.updateKupca(aidkup, aadresa);
	}
	
	public List<Kupci> listKupca(){
    	//List<Kupci> kupci=service.listKupci();
    	//return kupci;
		return service.listKupci();
    }                   
}