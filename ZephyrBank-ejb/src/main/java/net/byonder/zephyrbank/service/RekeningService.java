package net.byonder.zephyrbank.service;

import java.util.List;

import javax.ejb.Local;

import net.byonder.zephyrbank.exceptions.OnvoldoendeSaldoExceptie;
import net.byonder.zephyrbank.model.Rekening;
import net.byonder.zephyrbank.value.GebruikerNaam;

/**
 * @author jvdgriendt
 *
 */
@Local
public interface RekeningService {

	/**
	 * @param rekening
	 */
	void nieuweRekening(Rekening rekening, GebruikerNaam gebruikerPlaceHolder);
	
	/**
	 * @return
	 */
	List<Rekening> geefAlleRekening();
	
	/**
	 * @param mutatie
	 * @param vanRekening
	 * @param naarRekening
	 */
	void overboeking(float mutatie, Rekening vanRekening, Rekening naarRekening) throws OnvoldoendeSaldoExceptie ;
	
	/**
	 * @param id
	 * @return
	 */
	Rekening haalRegekeningOpViaId(long id);
}
