package com.example.demo_springmvc.model;

import com.example.demo_springmvc.entities.Generos;
import com.example.demo_springmvc.entities.Libros;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import com.example.demo_springmvc.util.HibernateUtil;
import java.util.List;
public class GenerosModel {
    SessionFactory factory = HibernateUtil.getSessionFactory();
    public List<Generos> listarGeneros(){
        Session ses = factory.openSession();
        try {
            Query consulta = ses.createQuery("SELECT g FROM Generos g");
            List<Generos> lista = consulta.list();
            ses.close();
            return lista;
        } catch (Exception e) {
            ses.close();
            return null;
        }
    }

    public Generos obtenerGenero(int idGenero){
        Session ses = factory.openSession();
        try{
            Generos genero = (Generos)ses.get(Generos.class, idGenero);
            ses.close();
            return genero;
        }catch(Exception e){
            ses.close();
            return null;
        }
    }
}
