/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package src.Beans;

import src.Entities.Oferta;
import java.util.List;

/**
 *
 * @author diegoojedagarcia
 */
public class homeBean {
    private List<Oferta> ofertas;

    public List<Oferta> getOfertas() {
        return ofertas;
    }

    public void setOfertas(List<Oferta> ofertas) {
        this.ofertas = ofertas;
    }
    
}
