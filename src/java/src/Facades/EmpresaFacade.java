/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package src.Facades;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import src.Entities.Empresa;

/**
 *
 * @author masterinftel11
 */
@Stateless
public class EmpresaFacade extends AbstractFacade<Empresa> {
    @PersistenceContext(unitName = "ChequeTeatinosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmpresaFacade() {
        super(Empresa.class);
    }
    public int getNextSeqVal (){
        List<Integer> seq = em.createQuery("select seq_empresa.nextval from dual;").getResultList();
        return seq.get(0);
    }
}
