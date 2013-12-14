/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package src.Facades;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import src.Entities.Cliente;

/**
 *
 * @author diegoojedagarcia
 */
@Stateless
public class ClienteFacade extends AbstractFacade<Cliente> {
    @PersistenceContext(unitName = "ChequeTeatinosPU")
    private EntityManager em;
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public ClienteFacade() {
        super(Cliente.class);
    }
    
    
    public Cliente findClienteEmailPass (String email, String password) throws Exception{
        List<Cliente> clientes = em.createQuery("SELECT c FROM Cliente c WHERE c.email LIKE :email AND c.pass LIKE :password")
                .setParameter("email", email)
                .setParameter("password", password)
                .getResultList();
        if (clientes.isEmpty()){
            System.out.println("Cliente no existe");
            //Cliente no encontrado.
            return null;
        }
        else if (clientes.size() == 1){
            System.out.println("Cliente SI existe "+clientes.get(0).getNombre());
            return clientes.get(0);
        }
        else{
            //Se supone que no puede haber dos clientes con mismo login y password
            throw new Exception("Hubo un error durante el login\n");
        }
    }
}
