/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package borcellippa.coinquilini.token;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Bortignon Gianluca
 */
@Local
public interface UniqueTokenFacadeLocal {

    void create(UniqueToken uniqueToken);

    void edit(UniqueToken uniqueToken);

    void remove(UniqueToken uniqueToken);

    UniqueToken find(Object id);

    List<UniqueToken> findAll();

    List<UniqueToken> findRange(int[] range);

    int count();

    UniqueToken getToken();
    
}
