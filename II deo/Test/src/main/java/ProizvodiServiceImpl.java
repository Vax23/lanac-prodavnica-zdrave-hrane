

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


@Stateless
public class ProizvodiServiceImpl implements ProizvodiService{
	
private EntityManager em;
	
	public ProizvodiServiceImpl() {
		
		EntityManagerFactory emf = Persistence
	               .createEntityManagerFactory("ProizvodiPU");
	       em = emf.createEntityManager();
	}

	@Override
	public boolean addProizvod(String id,String naziv,String cena, String dostupno) {
	try{
		int pid=Integer.parseInt(id);
		int c=Integer.parseInt(cena);
	    int dos=Integer.parseInt(dostupno);
	    Proizvodi p1 = new Proizvodi(pid,naziv,c,dos);
	    em.persist(p1);	  
	    return true;
	    } catch(Exception ex) {
	    	System.out.println("Greska prilikom rada sa bazom: \n" + ex.getMessage());
	    	return false;
		}  
	  }
	        
	@Override
	public void deleteProizvod(String bid) {
	try{ 
	    int kid=Integer.parseInt(bid);
	    Proizvodi p1 =em.find(Proizvodi.class, kid);
	    em.remove(p1);	       
	        } catch(Exception ex) {		
		System.out.println("Greska prilikom rada sa bazom: \n" + ex.getMessage());		
		}  	    
	  }
	     
	@Override
	public void updateProizvod(String aid, String acena) {
	try{	 
	    int kid=Integer.parseInt(aid);
	    int cena=Integer.parseInt(acena);
	    Proizvodi p1=em.find(Proizvodi.class, kid);	    
	    p1.setCena(cena);	       
	        } catch(Exception ex) {		
		System.out.println("Greska prilikom rada sa bazom: \n" + ex.getMessage());
		}      
	  }

	@Override
	public List<Proizvodi> listProizvodi() {
		List<Proizvodi> sviProizvodi=em.createQuery("SELECT z FROM Proizvodi z", Proizvodi.class).getResultList();
		return sviProizvodi;
	}

	@Override
	public Proizvodi findProizvod(int fid) {
		Proizvodi p=em.find(Proizvodi.class, fid);
		return p;
	}
}