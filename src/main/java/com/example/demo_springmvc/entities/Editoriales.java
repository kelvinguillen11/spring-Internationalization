package com.example.demo_springmvc.entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Editoriales {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "codigo_editorial", nullable = false, length = 6)
    private String codigoEditorial;
    @Basic
    @Column(name = "nombre_editorial", nullable = false, length = 30)
    private String nombreEditorial;
    @Basic
    @Column(name = "contacto", nullable = false, length = 30)
    private String contacto;
    @Basic
    @Column(name = "telefono", nullable = false, length = 9)
    private String telefono;
    @OneToMany(mappedBy = "editorialesByCodigoEditorial")
    private Collection<Libros> librosByCodigoEditorial;

    public String getCodigoEditorial() {
        return codigoEditorial;
    }

    public void setCodigoEditorial(String codigoEditorial) {
        this.codigoEditorial = codigoEditorial;
    }

    public String getNombreEditorial() {
        return nombreEditorial;
    }

    public void setNombreEditorial(String nombreEditorial) {
        this.nombreEditorial = nombreEditorial;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Collection<Libros> getLibrosByCodigoEditorial() {
        return librosByCodigoEditorial;
    }

    public void setLibrosByCodigoEditorial(Collection<Libros> librosByCodigoEditorial) {
        this.librosByCodigoEditorial = librosByCodigoEditorial;
    }
}
