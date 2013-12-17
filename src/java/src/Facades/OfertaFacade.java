/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package src.Facades;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import src.Entities.Oferta;

/**
 *
 * @author masterinftel11
 */
@Stateless
public class OfertaFacade extends AbstractFacade<Oferta> {
    @PersistenceContext(unitName = "ChequeTeatinosPU")
    private EntityManager em;
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public OfertaFacade() {
        super(Oferta.class);
    }
     public int getNextSeqVal (){
        List<Integer> seq = em.createQuery("SELECT seq_oferta.nextval FROM dual").getResultList();
        return seq.get(0);
    }
    
    public List<Oferta> findOfertasbyTipo (String tipo){
        List<Oferta> ofertas = em.createQuery("SELECT o FROM Oferta o WHERE o.tipo LIKE :tipo")
        .setParameter("tipo", tipo).getResultList();
        return ofertas;
    }
}
