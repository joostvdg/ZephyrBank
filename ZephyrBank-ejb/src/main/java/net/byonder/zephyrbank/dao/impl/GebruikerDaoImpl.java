/**
 * 
 */
package net.byonder.zephyrbank.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.Query;

import net.byonder.zephyrbank.dao.GebruikerDao;
import net.byonder.zephyrbank.model.Gebruiker;
import net.byonder.zephyrbank.value.GebruikerNaam;

/**
 * @author jvdgriendt
 *
 */
@Stateless(name="gebruikerDao", mappedName="gebruikerDao")
public class GebruikerDaoImpl extends AbstractBaseDao<Gebruiker> implements GebruikerDao {

	/**
	 * Default Constructor.
	 */
	public GebruikerDaoImpl() {
		super(Gebruiker.class);
	}

	@Override
	public Gebruiker vindGebruikerViaNaam(GebruikerNaam gebruikerNaam) {
		Gebruiker gebruiker = null;
		String queryString = String.format("SELECT gebruiker FROM Gebruiker gebruiker ");
		if((gebruikerNaam == null) || (gebruikerNaam.getVoorNaam() == null) || (gebruikerNaam.getVoorNaam().trim().equals(""))){
			throw new IllegalArgumentException("GebruikerNaam mag niet null of leeg zijn" );
		} else{
			queryString += String.format(" WHERE gebruiker.voorNaam = '%s' ", gebruikerNaam.getVoorNaam());
		}
		if((gebruikerNaam.getAchterNaam() == null) || (gebruikerNaam.getAchterNaam().trim().equals(""))){
			queryString += String.format(" AND gebruiker.achterNaam = '%s' ", gebruikerNaam.getAchterNaam());
		}
		if( (gebruikerNaam.getTussenVoegsel() == null) || (gebruikerNaam.getTussenVoegsel().trim().equals(""))){
			queryString += String.format(" AND gebruiker.tussenVoegsel = '%s' ", gebruikerNaam.getTussenVoegsel());
		}
		
		Query query = entityManager.createQuery(queryString, Gebruiker.class);
		gebruiker = (Gebruiker) query.getSingleResult();
			
		return gebruiker;
	}

}
