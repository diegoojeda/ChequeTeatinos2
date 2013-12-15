package src.Facades;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import src.Entities.Oferta;

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
        List<Integer> seq = em.createQuery("select seq_oferta.nextval from dual;").getResultList();
        return seq.get(0);
    }
    
    public int getOfertasbyTipo (String tipo){
        List<Oferta> ofertas = em.createQuery("SELECT o FROM oferta WHERE o.tipo LIKE :tipo")
        .setParameter("tipo", tipo).getResultList();
        return 0;
    }
    
}
