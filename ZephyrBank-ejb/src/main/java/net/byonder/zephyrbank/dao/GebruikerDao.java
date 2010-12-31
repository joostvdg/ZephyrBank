package net.byonder.zephyrbank.dao;

import javax.ejb.Local;

import net.byonder.zephyrbank.model.Gebruiker;
import net.byonder.zephyrbank.value.GebruikerNaam;

/**
 * Dao Interface voor de DAO acties die te maken hebben met gebruikers en rollen.
 * 
 * @author jvdgriendt
 *
 */
@Local
public interface GebruikerDao extends BaseDao<Gebruiker> {

	/**
	 * @param gebruikerNaam
	 * @return
	 */
	Gebruiker vindGebruikerViaNaam(GebruikerNaam gebruikerNaam);
}
