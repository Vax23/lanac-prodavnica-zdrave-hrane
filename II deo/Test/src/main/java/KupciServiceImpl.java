
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


@Stateless
public class KupciServiceImpl implements KupciService{
	
	private EntityManager em;
	
	public KupciServiceImpl() {
		
		EntityManagerFactory emf = Persistence
	               .createEntityManagerFactory("KupciPU");
	       em = emf.createEntityManager();
	}

	@Override
	public boolean addKupca(String id, String ime, String prezime,String adresa, String racun) {
		try{
			int kid=Integer.parseInt(id);
			int ra=Integer.parseInt(racun);
			Kupci k1 = new Kupci(kid,ime,prezime,adresa,ra);
			em.persist(k1);
			return true;
			} catch(Exception ex) {
				System.out.println("Greska prilikom rada sa bazom: \n" + ex.getMessage());
				return false;
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

	@Override
	public Kupci findKupca(int fid) {
		Kupci k=em.find(Kupci.class, fid);
		return k;
	}
}