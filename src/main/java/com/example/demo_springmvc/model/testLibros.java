package com.example.demo_springmvc.model;

import com.example.demo_springmvc.entities.Autores;
import com.example.demo_springmvc.entities.Editoriales;
import com.example.demo_springmvc.entities.Generos;
import com.example.demo_springmvc.entities.Libros;
import com.example.demo_springmvc.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.math.BigDecimal;

public class testLibros {
//public static void main(String[] args) {
//        EditorialesModel editorialesModel = new EditorialesModel();
//        GenerosModel generosModel = new GenerosModel();
//        AutoresModel autoresModel = new AutoresModel();
//        LibrosModel librosModel = new LibrosModel();
//
//        Libros libro = new Libros();
//        Autores autores = autoresModel.obtenerAutor("AUT001");
//        Generos genero = generosModel.obtenerGenero(1);
//        Editoriales editorial = editorialesModel.obtenerEditorial("EDI003");
//        libro.setCodigoLibro("LIB000022");
//        libro.setNombreLibro("Test de conexion de hibernate");
//        libro.setExistencias(10);
//        libro.setDescripcion("no creo que este sea el problema");
//        libro.setPrecio(BigDecimal.valueOf(3.50));
//        libro.setGenerosByIdGenero(genero);
//        libro.setAutoresByCodigoAutor(autores);
//        libro.setEditorialesByCodigoEditorial(editorial);
//        System.out.println("insertarLibro = " + librosModel.insertarLibro(libro));
//    }
}
