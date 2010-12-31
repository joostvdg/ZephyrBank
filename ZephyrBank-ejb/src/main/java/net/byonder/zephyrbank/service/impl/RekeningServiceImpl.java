package net.byonder.zephyrbank.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import net.byonder.zephyrbank.dao.GebruikerDao;
import net.byonder.zephyrbank.dao.RekeningDao;
import net.byonder.zephyrbank.exceptions.OnvoldoendeSaldoExceptie;
import net.byonder.zephyrbank.model.Gebruiker;
import net.byonder.zephyrbank.model.Rekening;
import net.byonder.zephyrbank.model.Transactie;
import net.byonder.zephyrbank.service.RekeningService;
import net.byonder.zephyrbank.value.GebruikerNaam;

/**
 * @author jvdgriendt
 *
 */
@Stateless(name="rekeningService", mappedName="rekeningService")
public class RekeningServiceImpl implements RekeningService{
	
	@EJB 
	RekeningDao rekeningDao;
	
	@EJB 
	GebruikerDao gebruikerDao;
		
	
	@Override
	public void nieuweRekening(Rekening rekening, GebruikerNaam gebruikerNaam) {
		Gebruiker eigenaar = gebruikerDao.vindGebruikerViaNaam(gebruikerNaam);
		if(eigenaar == null){
			eigenaar = new Gebruiker();
			eigenaar.setVoorNaam(gebruikerNaam.getVoorNaam());
			eigenaar.setTussenVoegsel(gebruikerNaam.getTussenVoegsel());
			eigenaar.setAchterNaam(gebruikerNaam.getAchterNaam());
		}
		rekening.setEigenaar(eigenaar);
		rekeningDao.bewaar(rekening);
	}

	@Override
	public List<Rekening> geefAlleRekening() {
		return rekeningDao.vindAlle();
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void overboeking(float mutatie, Rekening vanRekening, Rekening naarRekening) throws OnvoldoendeSaldoExceptie {
		naarRekening.muteerSaldo(mutatie);
		float negatiefMutatie = (mutatie * (-1));
		vanRekening.muteerSaldo(negatiefMutatie);
		Transactie transactie = new Transactie(vanRekening, naarRekening, mutatie);
		vanRekening.voegMutatieToe(transactie);
		naarRekening.voegMutatieToe(transactie);
	}

	@Override
	public Rekening haalRegekeningOpViaId(long id) {
		return rekeningDao.haalOp(id);
	}

}
