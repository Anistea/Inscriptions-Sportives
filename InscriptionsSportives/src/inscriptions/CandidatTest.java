package inscriptions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CandidatTest {
	Inscriptions inscriptions = Inscriptions.getInscriptions();
	Personne Tatum = inscriptions.createPersonne("Tatum", "Jayson", "test"), 
	Irving = inscriptions.createPersonne("Irving", "Kyrie", "test");
	Equipe Boston = inscriptions.createEquipe("CELTICS");
	Competition basket = inscriptions.createCompetition("NBA", null, false);



	
	@Test
	public void testGetNom(){

		String nom = Tatum.getNom();
		assertEquals("Nom :" + nom, Tatum.getNom());

	}
	
	@Test
	public void testSetNom() {
		String nom = "Tatum";
		assertEquals("Nom :" + nom, Tatum.getNom());
	}
	
		
		
		@Test
		public void testGetPrenom() {

			String prenom = Tatum.getPrenom();
			assertEquals("Nom :" + prenom, Tatum.getNom());

			
		}
	
		
		@Test
		public void testSetPrenom() {

			String prenom = "Jayson";
			assertEquals("Nom :" + prenom, Tatum.getNom());

			
		}
		
		 @Test
		    public void testGetMail() {
		        String mail = Tatum.getMail();

		        assertEquals("GetMail : " + mail + " , " + Tatum.getMail(), mail, "test");
		    }
		 
		 @Test
		    public void testSetMail() {
		        String mail = Tatum.getMail();

		        assertEquals("GetMail : " + mail + " , " + Tatum.getMail(), mail, "test");
		    }
		
	@Test
	public void testAdd() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testRemove() {

	
	}
	
	@Test
	public void testDelete() {
		fail("Not removed");}
		
	@Test
	public void testCompareTo() {
		
		Personne a = inscriptions.createPersonne("personne_A", "test_a", "a");
		Personne b = inscriptions.createPersonne("personne_B", "test_b", "b");
		assertEquals(-1, a.compareTo(b));
	}
	}
	

