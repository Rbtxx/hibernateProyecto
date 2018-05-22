/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iespuerto.pro.mavenproject3;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Roberto Luis Garcia
 */
public class ConectarDB {

    public static EntityManagerFactory emf;

    public static void guardarPropietario(Propietarios p) {
        EntityManager em;
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("unidadPersistencia");
        }
        em = emf.createEntityManager();

        EntityTransaction trx = em.getTransaction();
        trx.begin();
        try {
            em.persist(p);
            trx.commit();
        } catch (Exception ex) {
            System.out.println(ex);
            trx.rollback();
        } finally {
            em.close();
        }
    }

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("unidadPersistencia");
        EntityManager em = emf.createEntityManager();
//tenemos que tener en cuenta
//que casa no va a tener id hasta que se guarde en la base de datos
//y las relaciones no tienen lugar mientras no haya id en la tabla propietarioscasas
//también considerar que como la relación directa está en Casas es al persistir Casas
//o merge Casas cuando se hacen las relaciones en la tabla propietarioscasas
        Casas c = new Casas();
        c.setDireccion("direcc2");
        c.setMetros(60);
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(c);
        et.commit();
        Propietarios p = new Propietarios();
        p.setDni("31111111A");
        p.setNombre("pico");
//para agregar al arraylist tenemos que ver que esté creado
//de otra forma lo agregamos
        if (c.getPropietariosCollection() == null) {
            c.setPropietariosCollection(new ArrayList<Propietarios>());
        }
        c.getPropietariosCollection().add(p);
        et = em.getTransaction();
        et.begin();
        em.persist(p);
        et.commit();
        em.close();
        emf.close();
    }
}
