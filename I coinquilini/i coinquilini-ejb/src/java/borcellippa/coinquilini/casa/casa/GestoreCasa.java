/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package borcellippa.coinquilini.casa.casa;

import borcellippa.coinquilini.casa.bacheca.bacheca.Bacheca;
import borcellippa.coinquilini.casa.bacheca.bacheca.BachecaFacadeLocal;
import borcellippa.coinquilini.casa.calendario.Calendario;
import borcellippa.coinquilini.casa.calendario.CalendarioFacadeLocal;
import borcellippa.coinquilini.casa.wishlist.Wishlist;
import borcellippa.coinquilini.casa.wishlist.WishlistFacadeLocal;
import borcellippa.coinquilini.token.GestoreTokenLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Fede
 */
@Stateless
public class GestoreCasa implements GestoreCasaLocal {
    @EJB
    private GestoreTokenLocal gestoreToken;

    @EJB
    private WishlistFacadeLocal wishlistFacade;

    @EJB
    private BachecaFacadeLocal bachecaFacade;

    @EJB
    private CalendarioFacadeLocal calendarioFacade;

    @EJB
    private CasaFacadeLocal casaFacade;

    /**
     * Questo metodo viene utilizzato per accedere ad una casa sulla base 
     * del suo codice univoco
     * @param codiceCasa Il codice della casa alla quale si vuole accedere
     * @return La casa associata al codice fornito
     */
    @Override
    public Casa getCasaByCodiceCasa(String codiceCasa) {
        Casa c = casaFacade.getCasaByCodiceCasa(codiceCasa);
        return c;
    }
    
    /**
     * Data una casa, questo metodo la persiste nel database dopo aver creato
     * tutti gli oggetti accessori necessari(calendario,bacheca,...)
     * @param c La casa da persistere
     * @return Il codice univoco generato necessario ad un nuovo utente per 
     * entrare in casa
     */
    @Override
    public String addCasa(Casa c) {

        Calendario calendario = new Calendario();
        calendarioFacade.create(calendario);
        c.setCalendario(calendario);

        Bacheca bacheca = new Bacheca();
        bachecaFacade.create(bacheca);
        c.setBacheca(bacheca);

        Wishlist wishlist = new Wishlist();
        wishlistFacade.create(wishlist);
        c.setWishlist(wishlist);
        String codiceCasa = gestoreToken.createToken();
        c.setCodiceCasa(codiceCasa);

        casaFacade.create(c);
        
        return codiceCasa;
    }

     /**
     * Restituisce una casa basandosi sull'id
     * @param idCasa ID della casa da cercare
     * @return La casa associata all'ID
     */
    @Override
    public Casa getCasaById(String idCasa) {
        return casaFacade.find(idCasa);
    }

    /**
     * Modifica l'oggetto casa salvato sul database
     * @param c La casa da modificare
     */
    @Override
    public void editCasa(Casa c) {
        casaFacade.edit(c);
    }

}
