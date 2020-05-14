package controllers;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import entities.Zaposleni;
import services.ZaposleniService;

@ManagedBean(name="zaposleniController")
public class ZaposleniController {
	
	private String idz="";
	private String imez="";
	private String prezimez="";
    private String plata="";

    private String bidz=""; 

    
   private String aplata=""; 
   private String aidz=""; 
   
	
	@EJB
	private ZaposleniService service;
	
	public String getIdz() {
		return idz;
	}
	
	public void setIdz(String idz) {
		this.idz=idz;
	}
	
	public String getImez() {
		return imez;
	}

	public void setImez(String imez) {
		this.imez = imez;
	}

	public String getPrezimez() {
		return prezimez;
	}

	public void setPrezimez(String prezimez) {
		this.prezimez = prezimez;
	}

	public String getPlata() {
		return plata;
	}

	public void setPlata(String plata) {
		this.plata = plata;
	}

	public String getBidz() {
		return bidz;
	}

	public void setBidz(String bidz) {
		this.bidz = bidz;
	}
	
	public String getAidz() {
		return aidz;
	}

	public void setAidz(String aidz) {
		this.aidz = aidz;
	}

	public String getAplata() {
		return aplata;
	}

	public void setAplata(String aplata) {
		this.aplata = aplata;
	}
	
	
	
	public void dodajZaposlenog(String idz, String imez, String prezimez, String plata) {
		service.addZaposlenog(idz, imez, prezimez, plata);
	}

	public void brisiZaposlenog(String bidz){
		service.deleteZaposlenog(bidz);
	}
	
	public void azurirajZaposlenog(String aidz, String aplata) {
		service.updateZaposlenog(aidz, aplata);
	}
	
	public List<Zaposleni> listZaposlenih(){
		//List<Zaposleni> sviZaposleni=service.listZaposleni();
		//return sviZaposleni;
		return service.listZaposleni();
	}
}
