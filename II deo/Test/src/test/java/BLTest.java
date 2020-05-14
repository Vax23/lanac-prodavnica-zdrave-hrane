

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;


public class BLTest {
	
	ZaposleniServiceImpl servicez=new ZaposleniServiceImpl();
	
	KupciServiceImpl servicekup= new KupciServiceImpl();
	
	ProizvodiServiceImpl servicep=new ProizvodiServiceImpl();
	
	KupovinaServiceImpl servicek=new KupovinaServiceImpl();
	
	//----------------------------------ZAPOSLENI------------------------------------------------------------
	//Da li funkcija vraca zaposlene?
	public void testListZaposleni() {
		
		List<Zaposleni> sviZaposleni=servicez.listZaposleni();
		assertNotNull(sviZaposleni);
	}
	
	//Da li funkcija za add radi?
		public void testAddZaposlenog() {
			boolean z=servicez.addZaposlenog("15", "Aca", "Jovic", "26000");
			assertTrue(z);
		}
		
	//Da li funkcija za update plate radi?
		public void testUpdateZaposlenog() {
			servicez.updateZaposlenog("3", "26000");
			Zaposleni z=servicez.findZaposleni(3);
			assertEquals(z.getPlata(),26000);
		}
		
	//Da li funkcija za delete radi?
		public void testDeleteZaposlenog() {
			servicez.deleteZaposlenog("4");
			Zaposleni z=servicez.findZaposleni(4);
			assertNull(z);
		}
		
		//----------------------------------KUPCI------------------------------------------------------------
		//Da li funkcija vraca zaposlene?
		public void testListKupci() {
			
			List<Kupci> sviKupci=servicekup.listKupci();
			assertNotNull(sviKupci);
		}
		
		//Da li funkcija za add radi?
			public void testAddKupca() {
				boolean kup=servicekup.addKupca("15", "Jovan", "Krstic", "Vozdova", "18000");
				assertTrue(kup);
			}
			
		//Da li funkcija za update adrese radi?
			public void testUpdateKupca() {
				servicekup.updateKupca("2", "Obrenoviceva 1");
				Kupci kup=servicekup.findKupca(2);
				assertEquals(kup.getAdresa(), "Obrenoviceva 1");
			}
		
		//Da li funkcija za delete radi?
			public void testDeleteKupca() {
				servicekup.deleteKupca("1");
				Kupci kup=servicekup.findKupca(1);
				assertNull(kup);
			}
			
		//----------------------------------PROIZVODI------------------------------------------------------------
		//Da li funkcija vraca proizvode?
			public void testListProizvodi() {
				
				List<Proizvodi> sviProizvodi=servicep.listProizvodi();
				assertNotNull(sviProizvodi);
			}
			
		//Da li funkcija za add radi?
				public void testAddProizvod() {
					boolean p=servicep.addProizvod("15", "Ovsene pahuljice", "150", "15");
					assertTrue(p);
				}
				
		//Da li funkcija za update cene radi?
				public void testUpdateProizvod() {
					servicep.updateProizvod("2", "500");
					Proizvodi p=servicep.findProizvod(2);
					assertEquals(p.getCena(),500);
				}
			
		//Da li funkcija za delete radi?
				public void testDeleteProizvod() {
					servicep.deleteProizvod("1");
					Proizvodi p=servicep.findProizvod(1);
					assertNull(p);
				}
				
		//----------------------------------KUPOVINA------------------------------------------------------------
		//Da li funkcija vraca zaposlene?
				public void testListKupovina() {
					
					List<Kupovina> sveKupovine=servicek.listKupovina();
					assertNotNull(sveKupovine);
				}
				
		
					
		//Da li docker radi
					public void testDocker() throws Exception {
						
							String doc=servicek.sendGET(2);
							assertNotNull(doc);
					}
		

   @Test
   public void testAssertions() throws Exception 
   {
	 //----------------------------------ZAPOSLENI------------------------------------------------------------
	   System.out.println("Test za listu zaposlenih");
	   testListZaposleni();
	   
	   System.out.println("Test za dodavanje zaposlenog");
	   testAddZaposlenog();
	   
	   System.out.println("Test za brisanje zaposlenog");
	   testDeleteZaposlenog();
	   
	   System.out.println("Test za azuriranje zaposlenog");
	   testUpdateZaposlenog();
	   
	 //----------------------------------KUPCI------------------------------------------------------------
	   System.out.println("Test za listu kupaca");
	   testListKupci();
	   
	   System.out.println("Test za dodavanje kupca");
	   testAddKupca();
	   
	   System.out.println("Test za azuriranje kupca");
	   testUpdateKupca();
	   
	   System.out.println("Test za brisanje kupca");
	   testDeleteKupca();
	   
	 //----------------------------------PROIZVODI------------------------------------------------------------
	   System.out.println("Test za listu proizvoda");
	   testListProizvodi();
	   
	   System.out.println("Test za dodavanje proizvoda");
	   testAddProizvod();
	   
	   System.out.println("Test za azuriranje proizvoda");
	   testUpdateProizvod();
	   
	   System.out.println("Test za brisanje proizvoda");
	   testDeleteProizvod();
	   
	 //----------------------------------KUPOVINA------------------------------------------------------------
	   System.out.println("Test za listu kupovina");
	   testListKupovina();
	   
	   System.out.println("Test za docker");
	   testDocker();
   }
}

