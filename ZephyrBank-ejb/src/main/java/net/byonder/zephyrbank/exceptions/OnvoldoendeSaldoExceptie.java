package net.byonder.zephyrbank.exceptions;

import javax.ejb.ApplicationException;


/**
 *
 * @author jvdgriendt
 */
@ApplicationException
public class OnvoldoendeSaldoExceptie extends Exception{

    public OnvoldoendeSaldoExceptie(String message) {
        super(message);
    }


    
}
