package inscriptions;

import java.io.Serializable;
import java.util.Collections;
import java.time.LocalDate;
import java.util.Set;
import java.util.TreeSet;

/**
 * Repr�sente une comp�tition, c'est-�-dire un ensemble de candidats 
 * inscrits � un �v�nement, les inscriptions sont closes � la date dateCloture.
 *
 */

public class Competition implements Comparable<Competition>, Serializable
{
	private static final long serialVersionUID = -2882150118573759729L;
	private Inscriptions inscriptions;
	private String nom;
	private Set<Candidat> candidats;
	private LocalDate dateCloture;
	private boolean enEquipe = false;

	Competition(Inscriptions inscriptions, String nom, LocalDate dateCloture, boolean enEquipe)
	{
		this.enEquipe = enEquipe;
		this.inscriptions = inscriptions;
		this.nom = nom;
		this.dateCloture = dateCloture;
		candidats = new TreeSet<>();
	}
	
	/**
	 * Retourne le nom de la comp�tition.
	 * @return
	 */
	
	public String getNom()
	{
		return nom;
	}
	
	/**
	 * Modifie le nom de la comp�tition.
	 */
	
	public void setNom(String nom)
	{
		this.nom = nom ;
	}
	
	/**
	 * Retourne vrai si les inscriptions sont encore ouvertes, 
	 * faux si les inscriptions sont closes.
	 * @return
	 */
	
	public boolean inscriptionsOuvertes()
	{
		
		
		return (this.dateCloture.isAfter(LocalDate.now()));
			
				 
		
	}
	
	/**
	 * Retourne la date de cloture des inscriptions.
	 * @return
	 **/
	
	public LocalDate getDateCloture()
	{
		return dateCloture;
	}
	
	/**
	 * Est vrai si et seulement si les inscriptions sont r�serv�es aux �quipes.
	 * @return
	 */
	
	public boolean estEnEquipe()
	{
		return enEquipe;
	}
	
	/**
	 * Modifie la date de cloture des inscriptions. Il est possible de la reculer 
	 * mais pas de l'avancer.
	 * @param dateCloture
	 */
	
	public void setDateCloture(LocalDate dateCloture)
	{

		
	// TODO v�rifier que l'on avance pas la date.		
		
		if(getDateCloture().isBefore(this.dateCloture)) 
		{
			this.dateCloture = dateCloture;

		} 	
		else {
						throw new RuntimeException("Vous ne pouvez pas avancer la date de cloture");

		}
	}
	
	/**
	 * Retourne l'ensemble des candidats inscrits.
	 * @return
	 */
	
	public Set<Candidat> getCandidats()
	{
		return Collections.unmodifiableSet(candidats);
	}
	
	/**
	 * Inscrit un candidat de type Personne � la comp�tition. Provoque une
	 * exception si la comp�tition est r�serv�e aux �quipes ou que les 
	 * inscriptions sont closes.
	 * @param personne
	 * @return
	 */
	
	public boolean add(Personne personne)
	{
		// TODO v�rifier que la date de cloture n'est pas pass�e
		
		if(getDateCloture().isAfter(LocalDate.now()))
			
			if (enEquipe) 
			
				throw new RuntimeException();
				personne.add(this);
				return candidats.add(personne);
				
	
		
	}
	
	/**
	 * Inscrit un candidat de type Equipe � la comp�tition. Provoque une
	 * exception si la comp�tition est r�serv�e aux personnes ou que 
	 * les inscriptions sont closes.
	 * @param personne
	 * @return
	 */

	public boolean add(Equipe equipe)
	{
		// TODO v�rifier que la date de cl�ture n'est pas pass�e
		if(getDateCloture().isAfter(LocalDate.now()))
		
			if (!enEquipe)
				throw new RuntimeException();
			equipe.add(this);
			return candidats.add(equipe);
		
	
	}
	
	/**
	 * Retourne les Candidats que l'on peut inscrire � cette competition.
	 * @return les Candidats que l'on peut inscrire � cette comp�tition.
	 */
	
	public Set<Personne> getPersonnesAInscrire()
	{
		// TODO retourner les personnes que l'on peut inscrire � cette comp�tition.
		return null;
	}

	/**
	 * D�sinscrit un candidat.
	 * @param candidat
	 * @return
	 */
	
	public boolean remove(Candidat candidat)
	{
		candidat.remove(this);
		return candidats.remove(candidat);
	}
	
	/**
	 * Supprime la comp�tition de l'application.
	 */
	
	public void delete()
	{
		for (Candidat candidat : candidats)
			remove(candidat);
		inscriptions.delete(this);
	}
	
	@Override
	public int compareTo(Competition o)
	{
		return getNom().compareTo(o.getNom());
	}
	
	@Override
	public String toString()
	{
		return getNom();
	}
}
