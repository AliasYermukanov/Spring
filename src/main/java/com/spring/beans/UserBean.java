package com.spring.beans;

import com.spring.dao.History;
import com.spring.dao.Items;
import com.spring.dao.Roles;
import com.spring.dao.Users;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class UserBean {
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Users> userList(){
        List<Users> userList = null;
        try{
            Session session = sessionFactory.openSession();

            CriteriaBuilder bulder = session.getCriteriaBuilder();

            CriteriaQuery<Users> criteriaQuery = bulder.createQuery(Users.class);
            Root<Users> blogTabel = criteriaQuery.from(Users.class);
            criteriaQuery.select(blogTabel);
            Query query = session.createQuery(criteriaQuery);
            userList = query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return userList;
    }

    public List<Items> itemsList(){
        List<Items> itemsList = null;
        try{
            Session session = sessionFactory.openSession();

            CriteriaBuilder bulder = session.getCriteriaBuilder();

            CriteriaQuery<Items> criteriaQuery = bulder.createQuery(Items.class);
            Root<Items> blogTabel = criteriaQuery.from(Items.class);
            criteriaQuery.select(blogTabel);
            Query query = session.createQuery(criteriaQuery);
            itemsList = query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return itemsList;
    }
    public List<History> histories(){
        List<History> histories = null;
        try{
            Session session = sessionFactory.openSession();

            CriteriaBuilder bulder = session.getCriteriaBuilder();

            CriteriaQuery<History> criteriaQuery = bulder.createQuery(History.class);
            Root<History> blogTabel = criteriaQuery.from(History.class);
            criteriaQuery.select(blogTabel);
            Query query = session.createQuery(criteriaQuery);
            histories = query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return histories;
    }



    public Users getUser (String login, String password){

        Users currentUser = null;
        try{
            Session session = sessionFactory.openSession();

            Criteria crit = session.createCriteria(Users.class);
            crit.add(Restrictions.eq("login", login));
            crit.add(Restrictions.eq("password", password));
            currentUser = (Users)crit.uniqueResult();
            session.close();
            return currentUser;

        }catch (Exception e){
            System.out.println();
            e.printStackTrace();
        }
        return currentUser;
    }

    public void addUser(Users user){
        Transaction transaction= null;
        try{
            Session session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(user);
            transaction.commit();
            session.close();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
    }

    public Roles getRoleById(Long i) {
        Roles roles = null;
        try{
            Session session = sessionFactory.openSession();
            roles = session.get(Roles.class, i);
            session.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return roles;
    }

    public Users findUserById(Long userid) {
        Users users = null;
        try{
            Session session = sessionFactory.openSession();
            users = session.get(Users.class, userid);
            session.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return users;
    }

    public void deleteUser(Users userById) {
        Transaction transaction= null;
        try{
            Session session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.delete(userById);

            transaction.commit();
            session.close();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
    }

    public void addItem(Items items) {
        Transaction transaction= null;
        try{
            Session session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(items);
            transaction.commit();
            session.close();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
    }

    public Items findItemById(Long id) {
        Items items = null;
        try{
            Session session = sessionFactory.openSession();
            items = session.get(Items.class, id);
            session.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return items;
    }

    public void deleteItem(Items itemById) {
        Transaction transaction= null;
        try{
            Session session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.saveOrUpdate(itemById);

            transaction.commit();
            session.close();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
    }

    public void addHistory(History history) {
        Transaction transaction = null;
        try {
            Session session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(history);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    public Items findbyUTC(String product_code) {
        Items item = null;

        try {

            Session session = sessionFactory.openSession();
            Query query = session.createQuery("from Items where universal_product_code =:universal_product_code");
            query.setParameter("universal_product_code", product_code);
            if(query.getSingleResult() != null)
                item = (Items) query.getSingleResult();

        }
        catch (Exception e) { e.printStackTrace(); }

        return item;
    }

    public void addRole(Roles roles) {
        Transaction transaction = null;
        try {
            Session session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(roles);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }
}
