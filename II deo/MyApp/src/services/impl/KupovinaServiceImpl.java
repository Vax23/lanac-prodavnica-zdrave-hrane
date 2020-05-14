package services.impl;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Kupci;
import entities.Kupovina;
import entities.Proizvodi;
import services.KupovinaService;

@Stateless
public class KupovinaServiceImpl implements KupovinaService{
	
	@PersistenceContext(name = "MyApp")
	private EntityManager em;
	
	private static final String USER_AGENT = "Mozilla/5.0";

	@Override
	public void addKupovina(String id, String idKupca, String idProizvoda, String kolicina) {
		try{
			int kid=Integer.parseInt(id);
			int idk=Integer.parseInt(idKupca);
		    int idp=Integer.parseInt(idProizvoda);
		    int kol=Integer.parseInt(kolicina);
		    
		    Kupci k=em.find(Kupci.class, idKupca);
		    Proizvodi p=em.find(Proizvodi.class, idProizvoda);
		    
		    if(k!=null && p!=null && p.getDostupno()>=kol) {
		    	
		    	if(k.getRacun()>=kol*p.getCena()) {
		    
		    
		    Kupovina k1 = new Kupovina(kid,idk,idp,kol);
		    em.persist(k1);	   
		    em.flush();
		    String status=sendGET(k1.getId());
			k1.setStatus(status);
		    	}}
		    } catch(Exception ex) {
		    	System.out.println("Greska prilikom rada sa bazom: \n" + ex.getMessage());
			}
	}

	@Override
	public List<Kupovina> listKupovina() {
		List<Kupovina> sveKupovine=em.createQuery("SELECT k FROM Kupovina k", Kupovina.class).getResultList();
		return sveKupovine;
	}
	
	@Override
	public String sendGET(int kid) throws Exception {
		
		try
		{
			URL obj = new URL("http://192.168.99.100/?kid="+kid);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("User-Agent", USER_AGENT);
			int responseCode = con.getResponseCode();

			if (responseCode == HttpURLConnection.HTTP_OK)
			{
				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();

				while ((inputLine = in.readLine()) != null)
				{
					response.append(inputLine);
				}
				in.close();

				return response.toString();
			} 
			else 
			{
				System.out.println("GET request not worked");
				return null;
			}
			 
		}
		catch(Exception ex)
		{
			System.out.println("Greska prilikom rada sa bazom "+ex.getMessage()+"\n");
		}
		return null;
		
	}
}