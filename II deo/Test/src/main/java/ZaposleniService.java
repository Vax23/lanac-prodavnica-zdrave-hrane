
import java.util.List;
//import entities.Zaposleni;

public interface ZaposleniService {
	
	public boolean addZaposlenog(String id,String ime, String prezime, String plata);
	public void deleteZaposlenog(String bid);
	public void updateZaposlenog(String aid, String aplata);
	public List<Zaposleni> listZaposleni();
	
	public Zaposleni findZaposleni(int fid);
}