package com.vladbudan.app.service.impl;

import com.vladbudan.app.config.HibernateUtil;
import com.vladbudan.app.model.Pet;
import com.vladbudan.app.service.PetService;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PetServiceImpl implements PetService {

    @Override
    public void addPet(Pet pet) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.save(pet);

            transaction.commit();
        }
        catch(Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void updatePet(Pet pet) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.saveOrUpdate(pet);

            transaction.commit();
        }
        catch(Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public Pet getPetById(Integer id) {
        Transaction transaction = null;
        Pet pet = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            pet = session.get(Pet.class, id);

            transaction.commit();
        }
        catch(Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
        }
        return pet;
    }

    @Override
    public void deletePet(Integer id) {
        Transaction transaction = null;
        Pet pet = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            pet = session.get(Pet.class, id);

            session.delete(pet);

            transaction.commit();
        }
        catch(Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public List<Pet> getAllPets() {
        Transaction transaction = null;
        List<Pet> pets = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            pets = (List<Pet>) session.createQuery("from Pet").list();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return pets;
    }
}
