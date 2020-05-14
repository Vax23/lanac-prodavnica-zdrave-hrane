package services.impl;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entities.Kupci;
import services.KupciService;

@Stateless
public class KupciServiceImpl implements KupciService{
	
	@PersistenceContext(name = "MyApp")
	private EntityManager em;

	@Override
	public void addKupca(String id, String ime, String prezime,String adresa, String racun) {
		try{
			int kid=Integer.parseInt(id);
			int ra=Integer.parseInt(racun);
			Kupci k1 = new Kupci(kid,ime,prezime,adresa,ra);
			em.persist(k1);
			} catch(Exception ex) {
				System.out.println("Greska prilikom rada sa bazom: \n" + ex.getMessage());
				}  
		}
	
	@Override
	public void deleteKupca(String bid) {
		try{
			int kid=Integer.parseInt(bid);
			Kupci k1 =em.find(Kupci.class, kid);
			em.remove(k1);
			} catch(Exception ex) {
				System.out.println("Greska prilikom rada sa bazom: \n" + ex.getMessage());
				}  
		}
	
	@Override
	public void updateKupca(String aid, String aadresa) {
		try{	
			int kid=Integer.parseInt(aid);
			Kupci k1=em.find(Kupci.class, kid);	    
			k1.setAdresa(aadresa);	       
			} catch(Exception ex) {		
				System.out.println("Greska prilikom rada sa bazom: \n" + ex.getMessage());
				} 
		}
	
	@Override
	public List<Kupci> listKupci() {
		if(em==null)
			System.out.println("em problem");
		List<Kupci> sviKupci = em.createQuery("SELECT k FROM Kupci k", Kupci.class).getResultList();
		return sviKupci;
		}
}