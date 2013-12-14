/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package src.Facades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import src.Entities.PedidoOferta;

/**
 *
 * @author diegoojedagarcia
 */
@Stateless
public class PedidoOfertaFacade extends AbstractFacade<PedidoOferta> {
    @PersistenceContext(unitName = "ChequeTeatinosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PedidoOfertaFacade() {
        super(PedidoOferta.class);
    }
    
}
