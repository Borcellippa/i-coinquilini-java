/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package borcellippa.coinquilini.users.inquilino;

import javax.ejb.Local;

/**
 *
 * @author Bortignon Gianluca
 */
@Local
public interface GestoreInquilinoLocal {

    Inquilino getInquilinoByEmail(String email);
    
}
