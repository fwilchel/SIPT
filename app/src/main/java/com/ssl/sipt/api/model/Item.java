/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ssl.sipt.api.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author d5a9p6s7
 */
@Entity
@Table(catalog = "sipt", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Item.findAll", query = "SELECT i FROM Item i")})
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(nullable = false, length = 100)
    private String nombre;
    @Size(max = 500)
    @Column(length = 500)
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private boolean estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoFormacion", fetch = FetchType.LAZY)
    private List<Formacion> formacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "macroProyecto", fetch = FetchType.LAZY)
    private List<Empleado> empleadoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cargo", fetch = FetchType.LAZY)
    private List<Empleado> empleadoList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "genero", fetch = FetchType.LAZY)
    private List<Empleado> empleadoList2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadoCivil", fetch = FetchType.LAZY)
    private List<Empleado> empleadoList3;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rh", fetch = FetchType.LAZY)
    private List<Empleado> empleadoList4;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoContrato", fetch = FetchType.LAZY)
    private List<Empleado> empleadoList5;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoIdentificacion", fetch = FetchType.LAZY)
    private List<Empleado> empleadoList6;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoDotacion", fetch = FetchType.LAZY)
    private List<Dotacion> dotacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parentesco", fetch = FetchType.LAZY)
    private List<Beneficiario> beneficiarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoIdentificacion", fetch = FetchType.LAZY)
    private List<Beneficiario> beneficiarioList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "genero", fetch = FetchType.LAZY)
    private List<Beneficiario> beneficiarioList2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoSoporte", fetch = FetchType.LAZY)
    private List<Contrato> contratoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoContacto", fetch = FetchType.LAZY)
    private List<Contacto> contactoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoEmpresa", fetch = FetchType.LAZY)
    private List<Experiencia> experienciaList;
    @JoinColumn(name = "lista", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Lista lista;

    public Item() {
    }

    public Item(Long id) {
        this.id = id;
    }

    public Item(Long id, String nombre, boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public List<Formacion> getFormacionList() {
        return formacionList;
    }

    public void setFormacionList(List<Formacion> formacionList) {
        this.formacionList = formacionList;
    }

    public List<Empleado> getEmpleadoList() {
        return empleadoList;
    }

    public void setEmpleadoList(List<Empleado> empleadoList) {
        this.empleadoList = empleadoList;
    }

    public List<Empleado> getEmpleadoList1() {
        return empleadoList1;
    }

    public void setEmpleadoList1(List<Empleado> empleadoList1) {
        this.empleadoList1 = empleadoList1;
    }

    public List<Empleado> getEmpleadoList2() {
        return empleadoList2;
    }

    public void setEmpleadoList2(List<Empleado> empleadoList2) {
        this.empleadoList2 = empleadoList2;
    }

    public List<Empleado> getEmpleadoList3() {
        return empleadoList3;
    }

    public void setEmpleadoList3(List<Empleado> empleadoList3) {
        this.empleadoList3 = empleadoList3;
    }

    public List<Empleado> getEmpleadoList4() {
        return empleadoList4;
    }

    public void setEmpleadoList4(List<Empleado> empleadoList4) {
        this.empleadoList4 = empleadoList4;
    }

    public List<Empleado> getEmpleadoList5() {
        return empleadoList5;
    }

    public void setEmpleadoList5(List<Empleado> empleadoList5) {
        this.empleadoList5 = empleadoList5;
    }

    public List<Empleado> getEmpleadoList6() {
        return empleadoList6;
    }

    public void setEmpleadoList6(List<Empleado> empleadoList6) {
        this.empleadoList6 = empleadoList6;
    }

    public List<Dotacion> getDotacionList() {
        return dotacionList;
    }

    public void setDotacionList(List<Dotacion> dotacionList) {
        this.dotacionList = dotacionList;
    }

    public List<Beneficiario> getBeneficiarioList() {
        return beneficiarioList;
    }

    public void setBeneficiarioList(List<Beneficiario> beneficiarioList) {
        this.beneficiarioList = beneficiarioList;
    }

    public List<Beneficiario> getBeneficiarioList1() {
        return beneficiarioList1;
    }

    public void setBeneficiarioList1(List<Beneficiario> beneficiarioList1) {
        this.beneficiarioList1 = beneficiarioList1;
    }

    public List<Beneficiario> getBeneficiarioList2() {
        return beneficiarioList2;
    }

    public void setBeneficiarioList2(List<Beneficiario> beneficiarioList2) {
        this.beneficiarioList2 = beneficiarioList2;
    }

    public List<Contrato> getContratoList() {
        return contratoList;
    }

    public void setContratoList(List<Contrato> contratoList) {
        this.contratoList = contratoList;
    }

    public List<Contacto> getContactoList() {
        return contactoList;
    }

    public void setContactoList(List<Contacto> contactoList) {
        this.contactoList = contactoList;
    }

    public List<Experiencia> getExperienciaList() {
        return experienciaList;
    }

    public void setExperienciaList(List<Experiencia> experienciaList) {
        this.experienciaList = experienciaList;
    }

    public Lista getLista() {
        return lista;
    }

    public void setLista(Lista lista) {
        this.lista = lista;
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
        if (!(object instanceof Item)) {
            return false;
        }
        Item other = (Item) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ssl.sipt.api.model.Item[ id=" + id + " ]";
    }

}
