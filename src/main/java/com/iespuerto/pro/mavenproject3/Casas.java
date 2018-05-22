/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iespuerto.pro.mavenproject3;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Roberto Luis Garcia
 */
@Entity
@Table(name = "casas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Casas.findAll", query = "SELECT c FROM Casas c")
    , @NamedQuery(name = "Casas.findByIdcasas", query = "SELECT c FROM Casas c WHERE c.idcasas = :idcasas")
    , @NamedQuery(name = "Casas.findByDireccion", query = "SELECT c FROM Casas c WHERE c.direccion = :direccion")
    , @NamedQuery(name = "Casas.findByMetros", query = "SELECT c FROM Casas c WHERE c.metros = :metros")
    , @NamedQuery(name = "Casas.findByPrecio", query = "SELECT c FROM Casas c WHERE c.precio = :precio")
    , @NamedQuery(name = "Casas.findByGaraje", query = "SELECT c FROM Casas c WHERE c.garaje = :garaje")
    , @NamedQuery(name = "Casas.findByAscensor", query = "SELECT c FROM Casas c WHERE c.ascensor = :ascensor")})
public class Casas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcasas")
    private Integer idcasas;
    @Basic(optional = false)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @Column(name = "metros")
    private int metros;
    @Column(name = "precio")
    private Long precio;
    @Column(name = "garaje")
    private Boolean garaje;
    @Column(name = "ascensor")
    private Boolean ascensor;
    @JoinTable(name = "propietarioscasas", joinColumns = {
        @JoinColumn(name = "refCasa", referencedColumnName = "idcasas")}, inverseJoinColumns = {
        @JoinColumn(name = "refPropietarios", referencedColumnName = "dni")})
    @ManyToMany
    private Collection<Propietarios> propietariosCollection;

    public Casas() {
    }

    public Casas(Integer idcasas) {
        this.idcasas = idcasas;
    }

    public Casas(Integer idcasas, String direccion, int metros) {
        this.idcasas = idcasas;
        this.direccion = direccion;
        this.metros = metros;
    }

    public Integer getIdcasas() {
        return idcasas;
    }

    public void setIdcasas(Integer idcasas) {
        this.idcasas = idcasas;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getMetros() {
        return metros;
    }

    public void setMetros(int metros) {
        this.metros = metros;
    }

    public Long getPrecio() {
        return precio;
    }

    public void setPrecio(Long precio) {
        this.precio = precio;
    }

    public Boolean getGaraje() {
        return garaje;
    }

    public void setGaraje(Boolean garaje) {
        this.garaje = garaje;
    }

    public Boolean getAscensor() {
        return ascensor;
    }

    public void setAscensor(Boolean ascensor) {
        this.ascensor = ascensor;
    }

    @XmlTransient
    public Collection<Propietarios> getPropietariosCollection() {
        return propietariosCollection;
    }

    public void setPropietariosCollection(Collection<Propietarios> propietariosCollection) {
        this.propietariosCollection = propietariosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcasas != null ? idcasas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Casas)) {
            return false;
        }
        Casas other = (Casas) object;
        if ((this.idcasas == null && other.idcasas != null) || (this.idcasas != null && !this.idcasas.equals(other.idcasas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.iespuerto.pro.mavenproject3.Casas[ idcasas=" + idcasas + " ]";
    }
    
}
