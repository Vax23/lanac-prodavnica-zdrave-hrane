

import java.util.List;


public interface ProizvodiService {
	
	public boolean addProizvod(String id, String naziv,String cena, String dostupno);
    public void deleteProizvod(String bid);
    public void updateProizvod(String aid, String acena);
	public List<Proizvodi> listProizvodi();
	
	public Proizvodi findProizvod(int fid);

}
