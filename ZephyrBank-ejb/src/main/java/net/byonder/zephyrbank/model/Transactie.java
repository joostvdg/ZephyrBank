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
import javax.persistence.ManyToOne;

/**
 *
 * @author jvdgriendt
 */
@Entity
public class Transactie implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Rekening rekeningVan;

    @ManyToOne
    private Rekening rekeningNaar;

    private float mutatie;

    /**
     * Default constructor voor persistence.
     */
    protected Transactie(){
      super();
    }

    /**
     *
     * @param rekeningVan
     * @param rekeningNaar
     */
    public Transactie(Rekening rekeningVan, Rekening rekeningNaar, float mutatie){
      this();
      this.rekeningNaar = rekeningNaar;
      this.rekeningVan = rekeningVan;
      this.mutatie = mutatie;
    }

    public float getMutatie(){
      return this.mutatie;
    }

    public Rekening getRekeningVan(){
      return rekeningVan;
    }

    public Rekening getRekeningNaar(){
      return rekeningNaar;
    }

    /**
     *
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     *
     * @param object
     * @return
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transactie)) {
            return false;
        }
        Transactie other = (Transactie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "net.byonder.zephyrbank.model.Transactie[id=" + id + "]";
    }

}
