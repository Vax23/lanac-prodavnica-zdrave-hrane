
import java.util.List;

public interface KupciService {
	
	public boolean addKupca(String id, String ime, String prezime,String adresa, String racun);
    public void deleteKupca(String bid);
    public void updateKupca(String aid, String aadresa);
    public List<Kupci> listKupci();
    
    public Kupci findKupca(int fid);

}
