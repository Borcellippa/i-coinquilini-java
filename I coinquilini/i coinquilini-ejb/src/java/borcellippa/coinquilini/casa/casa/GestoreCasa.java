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
import borcellippa.coinquilini.token.UniqueToken;
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

    
    @Override
    public Casa getCasaByCodiceCasa(String codiceCasa) {
        System.out.println("###### getCasaByCodiceCasa ");
        Casa c = casaFacade.getCasaByCodiceCasa(codiceCasa);
        return c;
    }
    

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
        System.out.println("La Casa è stata Creata");
        
        return codiceCasa;
    }

    @Override
    public Casa getCasaById(String idCasa) {
        return casaFacade.find(idCasa);
    }

    @Override
    public void editCasa(Casa c) {
        casaFacade.edit(c);
    }

}
