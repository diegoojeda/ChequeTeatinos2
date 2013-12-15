/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package src.Beans;

import java.util.List;
import src.Entities.Empresa;

/**
 *
 * @author escabia
 */
public class empresasBean {
    private List<Empresa> empresas;

    public List<Empresa> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(List<Empresa> empresas) {
        this.empresas = empresas;
    }    
}
