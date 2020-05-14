
import java.util.List;

public interface KupovinaService {
	
	public boolean addKupovina(String id, String idKupca, String idProizvoda, String kolicina);
	public List<Kupovina> listKupovina();
	public String sendGET(int kid) throws Exception;
}
