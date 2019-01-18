package inscriptions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;



class EquipeTest {

	Inscriptions inscriptions = Inscriptions.getInscriptions();
	Equipe ogcnice = inscriptions.createEquipe("OGCNICE");
	Personne Balotelli = inscriptions.createPersonne("balotelli", "mario"," mario.balotelli@hotmail.fr");
	Personne Dante = inscriptions.createPersonne("Dante", "Dante", "dante@hotmail.fr");
	
//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testEquipe() {
		Equipe NGABI = inscriptions.createEquipe("NGABI TEAM");
		assertEquals("NGABI TEAM",NGABI.getNom());
	}
	

	
	
	@Test
	public void testGetMembres() {
		Equipe NGABI = inscriptions.createEquipe("NGABI TEAM");
		Personne Dante = inscriptions.createPersonne("Dante", "Dante", "dante@hotmail.fr");
		NGABI.add(Dante);
    	assertEquals("L'equipe : " + NGABI + " ont pour membres : " + Dante, NGABI);
	}
	
	@Test
    public void add() {
		
		fail("Not yet implemented");
		
	}

	
	
//	@Test
//    public void testSetMail() {
//        String mail = "mario.balotelli@hotmail.fr";
//
//        Personne Balotelli = inscriptions.createPersonne("BALOTELLI", "Mario", mail);
//
//        assertEquals("Le mail est : " + mail + " , " + Balotelli.getMail(), Balotelli.getMail(), mail);
//    }
	
	
	@Test
	public void testDelete() {
		
		assertEquals(true,inscriptions.getCandidats().contains(ogcnice));
		ogcnice.delete();
		assertEquals(false, inscriptions.getCandidats().contains(ogcnice));

		
	}
	
	@Test
	public void testRemove() {
	
		
		
		
	}
	
	@Test
	public void testToString() {
		
		assertEquals("L'equipe" + ogcnice.getNom() + "est inscrit a" + ogcnice.getCompetitions() , ogcnice.toString()  );
	
	}
}
