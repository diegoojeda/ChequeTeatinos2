/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package src.Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author diegoojedagarcia
 */
@Entity
@Table(name = "PEDIDO_OFERTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PedidoOferta.findAll", query = "SELECT p FROM PedidoOferta p"),
    @NamedQuery(name = "PedidoOferta.findById", query = "SELECT p FROM PedidoOferta p WHERE p.id = :id")})
public class PedidoOferta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @JoinColumn(name = "CODIGO_PEDIDO", referencedColumnName = "CODIGO_PEDIDO")
    @ManyToOne
    private Pedido codigoPedido;
    @JoinColumn(name = "CODIGO_OFERTA", referencedColumnName = "ID")
    @ManyToOne
    private Oferta codigoOferta;

    public PedidoOferta() {
    }

    public PedidoOferta(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pedido getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(Pedido codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public Oferta getCodigoOferta() {
        return codigoOferta;
    }

    public void setCodigoOferta(Oferta codigoOferta) {
        this.codigoOferta = codigoOferta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PedidoOferta)) {
            return false;
        }
        PedidoOferta other = (PedidoOferta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "src.Beans.PedidoOferta[ id=" + id + " ]";
    }
    
}
