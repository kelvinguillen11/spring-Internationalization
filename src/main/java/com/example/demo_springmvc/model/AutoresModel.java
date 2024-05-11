package com.example.demo_springmvc.model;

import com.example.demo_springmvc.entities.Autores;
import com.example.demo_springmvc.entities.Generos;
import  org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import com.example.demo_springmvc.util.HibernateUtil;
import java.util.List;
public class AutoresModel {
    SessionFactory factory = HibernateUtil.getSessionFactory();
    public List<Autores> listarAutores(){
        Session ses = factory.openSession();
        try {
            Query consulta = ses.createQuery("SELECT a FROM Autores a");
            List<Autores> lista = consulta.list();
            ses.close();
            return lista;
        } catch (Exception e) {
            ses.close();
            return null;
        }
    }
    public Autores obtenerAutor(String codigo){
        Session ses = factory.openSession();
        try{
            Autores autor = (Autores)ses.get(Autores.class, codigo);
            ses.close();
            return autor;
        }catch(Exception e){
            ses.close();
            return null;
        }
    }
}
