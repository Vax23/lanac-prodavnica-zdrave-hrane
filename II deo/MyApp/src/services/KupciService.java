package services;
import java.util.List;
import entities.Kupci;

public interface KupciService {
	
	public void addKupca(String id, String ime, String prezime,String adresa, String racun);
    public void deleteKupca(String bid);
    public void updateKupca(String aid, String aadresa);
    public List<Kupci> listKupci();

}
