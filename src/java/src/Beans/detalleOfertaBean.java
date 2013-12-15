package src.Beans;

import src.Entities.Empresa;
import src.Entities.Oferta;


public class detalleOfertaBean {
    private Oferta ofe;
    private Empresa emp;

    public Oferta getOfe() {
        return ofe;
    }

    public void setOfe(Oferta o) {
        this.ofe = o;
    }

    public Empresa getEmp() {
        return emp;
    }

    public void setEmp(Empresa e) {
        this.emp = e;
    }
}
