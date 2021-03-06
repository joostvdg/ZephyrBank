/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.byonder.zephyrbank.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author jvdgriendt
 */
@Entity
public class SpaarRekening extends Rekening implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private float opgebouwdeRente;
    
    @OneToOne
    private Rekening gekoppeldeRekening;

    public SpaarRekening(){
        super();
    }

    SpaarRekening(float saldo){
        super(saldo);
    }

    /**
	 * @param gekoppeldeRekening the gekoppeldeRekening to set
	 */
	public void setGekoppeldeRekening(Rekening gekoppeldeRekening) {
		this.gekoppeldeRekening = gekoppeldeRekening;
	}

	/**
	 * @return the gekoppeldeRekening
	 */
	public Rekening getGekoppeldeRekening() {
		return gekoppeldeRekening;
	}

	public float getOpgebouwdeRente(){
        return opgebouwdeRente;
    }

    /**
     * Update de rente met de nieuwe opbouw.
     * 
     * @param rente de rente die is opgebouwd in de afgelope periode
     */
    public void updateRente(float rente){
        this.opgebouwdeRente += rente;
    }
    
    /**
     * keert het bedrag uit dat is opgebouwd aan rente.
     * En reset het opgebouwde bedrag naar 0.
     * 
     * @return de opgebouwde rente 
     */
    public float keerRenteUit(){
    	float rente = opgebouwdeRente;
    	opgebouwdeRente = 0.0f;
    	return rente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof SpaarRekening)) {
            return false;
        }
        SpaarRekening other = (SpaarRekening) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SpaarRekening[id=" + id + "]";
    }

}
