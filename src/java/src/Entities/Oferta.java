/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package src.Entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author diegoojedagarcia
 */
@Entity
@Table(name = "OFERTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Oferta.findAll", query = "SELECT o FROM Oferta o"),
    @NamedQuery(name = "Oferta.findById", query = "SELECT o FROM Oferta o WHERE o.id = :id"),
    @NamedQuery(name = "Oferta.findByFechaValidez", query = "SELECT o FROM Oferta o WHERE o.fechaValidez = :fechaValidez"),
    @NamedQuery(name = "Oferta.findByExistencias", query = "SELECT o FROM Oferta o WHERE o.existencias = :existencias"),
    @NamedQuery(name = "Oferta.findByNombreOferta", query = "SELECT o FROM Oferta o WHERE o.nombreOferta = :nombreOferta"),
    @NamedQuery(name = "Oferta.findByDescripcion", query = "SELECT o FROM Oferta o WHERE o.descripcion = :descripcion"),
    @NamedQuery(name = "Oferta.findByPrecioOriginal", query = "SELECT o FROM Oferta o WHERE o.precioOriginal = :precioOriginal"),
    @NamedQuery(name = "Oferta.findByPrecioConOferta", query = "SELECT o FROM Oferta o WHERE o.precioConOferta = :precioConOferta")})
public class Oferta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Column(name = "FECHA_VALIDEZ")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaValidez;
    @Column(name = "EXISTENCIAS")
    private Short existencias;
    @Size(max = 30)
    @Column(name = "NOMBRE_OFERTA")
    private String nombreOferta;
    @Size(max = 200)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRECIO_ORIGINAL")
    private BigDecimal precioOriginal;
    @Column(name = "PRECIO_CON_OFERTA")
    private BigDecimal precioConOferta;
    @OneToMany(mappedBy = "codigoOferta")
    private Collection<PedidoOferta> pedidoOfertaCollection;
    @JoinColumn(name = "EMPRESA", referencedColumnName = "ID")
    @ManyToOne
    private Empresa empresa;

    public Oferta() {
    }

    public Oferta(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaValidez() {
        return fechaValidez;
    }

    public void setFechaValidez(Date fechaValidez) {
        this.fechaValidez = fechaValidez;
    }

    public Short getExistencias() {
        return existencias;
    }

    public void setExistencias(Short existencias) {
        this.existencias = existencias;
    }

    public String getNombreOferta() {
        return nombreOferta;
    }

    public void setNombreOferta(String nombreOferta) {
        this.nombreOferta = nombreOferta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecioOriginal() {
        return precioOriginal;
    }

    public void setPrecioOriginal(BigDecimal precioOriginal) {
        this.precioOriginal = precioOriginal;
    }

    public BigDecimal getPrecioConOferta() {
        return precioConOferta;
    }

    public void setPrecioConOferta(BigDecimal precioConOferta) {
        this.precioConOferta = precioConOferta;
    }

    @XmlTransient
    public Collection<PedidoOferta> getPedidoOfertaCollection() {
        return pedidoOfertaCollection;
    }

    public void setPedidoOfertaCollection(Collection<PedidoOferta> pedidoOfertaCollection) {
        this.pedidoOfertaCollection = pedidoOfertaCollection;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
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
        if (!(object instanceof Oferta)) {
            return false;
        }
        Oferta other = (Oferta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "src.Beans.Oferta[ id=" + id + " ]";
    }
    
}
