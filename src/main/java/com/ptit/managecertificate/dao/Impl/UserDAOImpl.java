package com.ptit.managecertificate.dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ptit.managecertificate.dao.UserDAO;
import com.ptit.managecertificate.entity.User;
import com.ptit.managecertificate.model.UserModel;

@Repository("userDao")
@Transactional
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(user);
    }

    public void update(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(user);
    }

    public User findById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        return session.get(User.class, id);
    }

    public void delete(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.delete(user);
    }

    @SuppressWarnings("unchecked")
    public List<User> findAll() {
        Session session = this.sessionFactory.getCurrentSession();
        return session.createQuery("FROM User").list();
    }

    public User getUserByUserName(String userName) {
        Session session = this.sessionFactory.getCurrentSession();
        String sql = "select user.* from user where UserName = :userName ";
        SQLQuery query = session.createSQLQuery(sql)
                .addEntity(User.class)
                .setParameter("userName", userName);
        List list = query.list();
        if (list != null && list.size() > 0) {
            return (User) query.list().get(0);
        } else {
            return null;
        }
    }

    public UserModel findUserInfo(String userName) {
        String sql = "Select new " + UserModel.class.getName() + "(u.username,u.password) "//
                + " from " + User.class.getName() + " u where u.username = :username ";

        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery(sql);
        query.setParameter("username", userName);

        return (UserModel) query.uniqueResult();
    }

    public boolean checkUserInDatabase(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        String sql = "select user.* from user where UserName = :userName";
        SQLQuery query = (SQLQuery) session.createSQLQuery(sql)
                .addEntity(User.class)
                .setParameter("userName", user.getUsername());
        List list = query.list();
        if (list != null && list.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

}