package services;
import java.util.List;
import entities.Kupovina;

public interface KupovinaService {
	
	public void addKupovina(String id, String idKupca, String idProizvoda, String kolicina);
	public List<Kupovina> listKupovina();
	public String sendGET(int kid) throws Exception;
}
