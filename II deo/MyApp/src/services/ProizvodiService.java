package services;

import java.util.List;

import entities.Proizvodi;

public interface ProizvodiService {
	
	public void addProizvod(String id, String naziv,String cena, String dostupno);
    public void deleteProizvod(String bid);
    public void updateProizvod(String aid, String acena);
	public List<Proizvodi> listProizvodi();

}
