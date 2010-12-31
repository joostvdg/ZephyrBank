package net.byonder.zephyrbank.value;

/**
 * Placeholder class zodat de values gebind kunnen worden in de facelet voordat er een valide gebruiker kan worden gemaakt.
 * 
 * @author jvdgriendt
 *
 */
public class GebruikerNaam{
	
	private String voorNaam;
	private String achterNaam;
	private String tussenVoegsel;
	/**
	 * @return the voorNaam
	 */
	public String getVoorNaam() {
		return voorNaam;
	}
	/**
	 * @param voorNaam the voorNaam to set
	 */
	public void setVoorNaam(String voorNaam) {
		this.voorNaam = voorNaam;
	}
	/**
	 * @return the achterNaam
	 */
	public String getAchterNaam() {
		return achterNaam;
	}
	/**
	 * @param achterNaam the achterNaam to set
	 */
	public void setAchterNaam(String achterNaam) {
		this.achterNaam = achterNaam;
	}
	/**
	 * @return the tussenVoegsel
	 */
	public String getTussenVoegsel() {
		return tussenVoegsel;
	}
	/**
	 * @param tussenVoegsel the tussenVoegsel to set
	 */
	public void setTussenVoegsel(String tussenVoegsel) {
		this.tussenVoegsel = tussenVoegsel;
	}
	
	
}