package inscriptions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import inscriptions.Competition;
import inscriptions.Equipe;
import inscriptions.Inscriptions;
import inscriptions.Personne;

//class PersonneTest {
//
//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}
//
//}


public class PersonneTest {

    final String input = "11-01-2019";
    final LocalDate localDate = LocalDate.now();

    Inscriptions inscriptions = Inscriptions.getInscriptions();
    Competition foot = inscriptions.createCompetition("Mondial de foot", localDate, false);

    Personne tony = inscriptions.createPersonne("Tony", "Dent de plomb", "azerty");
    Equipe lesmanouches = inscriptions.createEquipe("Les Manouches");

    @Test
    public void testPersonne() {
        String nom = tony.getNom();
        String prenom = tony.getPrenom();
        String mail = tony.getMail();

        assertEquals("Personne : " + nom, nom, "Tony");
        assertEquals(prenom, prenom, "Dent de plomb");
        assertEquals(mail, mail, "azerty");
    }

    @Test
    public void testGetPrenom() {
        String prenom = tony.getPrenom();

        assertEquals("Get : " + prenom + " , Dent de plomb", prenom, "Dent de plomb");
    }
@Test
    public void testSetPrenom() {
        String prenom = "Dent de cuivre";

        Personne tony = inscriptions.createPersonne("tony", prenom, "azerty");

        assertEquals("Set : " + prenom + " , " + tony.getPrenom(), tony.getPrenom(), prenom);
    }

    @Test
    public void testGetMail() {
        String mail = tony.getMail();

        assertEquals("GetMail : " + mail + " , " + tony.getMail(), mail, "azerty");
    }

    @Test
    public void testSetMail() {
        String mail = "1234";

        Personne tony = inscriptions.createPersonne("tony", "Dent de cuivre", mail);

        assertEquals("SetMail : " + mail + " , " + tony.getMail(), tony.getMail(), mail);
    }

    @Test
    public void testGetEquipes() {
    	Equipe lesmanouches = inscriptions.createEquipe("Les Manouches");
    	Personne tony = inscriptions.createPersonne("Tony", "Dent de plomb", "azerty");
    	lesmanouches.add(tony);
    	
    	assertEquals("getEquipes : " + lesmanouches + " ont pour membres : " + tony, lesmanouches);
    }

    @Test
    public void testAdd() {
        fail("Not yet implemented");
    }

    @Test
    public void testRemove() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testDelete() {
        fail("Not yet implemented");
    }

}
