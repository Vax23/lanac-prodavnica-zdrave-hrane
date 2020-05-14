package services.impl;
import javax.persistence.*;

import entities.Zaposleni;
import services.ZaposleniService;
import java.util.List;
import javax.ejb.*;

@Stateless
public class ZaposleniServiceImpl implements ZaposleniService {

	@PersistenceContext(name = "MyApp")
	private EntityManager em;
	
	@Override
	public void addZaposlenog(String id,String ime, String prezime, String plata)
	{
		try{
			int zid=Integer.parseInt(id);
			int p=Integer.parseInt(plata);
		    Zaposleni z1 = new Zaposleni(zid,ime, prezime, p);
		    em.persist(z1);	       
		    } catch(Exception ex) {
		    	System.out.println("Greska prilikom rada sa bazom: \n" + ex.getMessage());
			} 
	}
	
	@Override
	public void deleteZaposlenog(String bid)
	{
		try{ 
		    int id=Integer.parseInt(bid);
		    Zaposleni z1 =em.find(Zaposleni.class, id);
		    em.remove(z1);	       
		        } catch(Exception ex) {		
			System.out.println("Greska prilikom rada sa bazom: \n" + ex.getMessage());		
			} 
	}
	
	@Override
	public void updateZaposlenog(String aid, String aplata)
	{
		try{	 
		    int id=Integer.parseInt(aid);
		    int plata=Integer.parseInt(aplata);
		    Zaposleni z1=em.find(Zaposleni.class, id);	    
		    z1.setPlata(plata);	       
		        } catch(Exception ex) {		
			System.out.println("Greska prilikom rada sa bazom: \n" + ex.getMessage());
			}
	}
	
	@Override
	public List<Zaposleni> listZaposleni()
	{
		if(em==null)
			System.out.println("em problem");
		List<Zaposleni> sviZaposleni=em.createQuery("SELECT z FROM Zaposleni z", Zaposleni.class).getResultList();
				return sviZaposleni;
	}
}
