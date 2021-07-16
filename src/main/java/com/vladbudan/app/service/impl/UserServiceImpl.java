package com.vladbudan.app.service.impl;

import com.vladbudan.app.config.HibernateUtil;
import com.vladbudan.app.model.User;
import com.vladbudan.app.service.UserService;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Override
    public void addUser(User user) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.save(user);

            transaction.commit();
        }
        catch(Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void updateUser(User user) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.saveOrUpdate(user);

            transaction.commit();
        }
        catch(Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public User getUserById(Integer id) {
        Transaction transaction = null;
        User user = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            user = session.get(User.class, id);

            transaction.commit();
        }
        catch(Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
        }
        return user;
    }

    @Override
    public void deleteUser(Integer id) {
        Transaction transaction = null;
        User user = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            user = session.get(User.class, id);

            session.delete(user);

            transaction.commit();
        }
        catch(Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
        }
    }

    public List<User> getAllUsers() {
        Transaction transaction = null;
        List<User> users = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            users = (List<User>) session.createQuery("from User").list();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return users;
    }

}
