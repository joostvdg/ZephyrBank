/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.byonder.zephyrbank.service;

import java.util.List;
import javax.ejb.Local;
import net.byonder.zephyrbank.model.Gebruiker;

/**
 *
 * @author jvdgriendt
 */
@Local
public interface GebruikerService {

 /**
  * 
  * @return
  */
 public List<Gebruiker> geefAlleGebruikers();
    
}
