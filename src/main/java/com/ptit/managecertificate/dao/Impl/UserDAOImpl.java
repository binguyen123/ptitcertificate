package com.ptit.managecertificate.dao.Impl;

import com.ptit.managecertificate.dao.UserDAO;
import com.ptit.managecertificate.entity.User;
import com.ptit.managecertificate.model.UserModel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {
	private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);

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

    public User findById(Long id) {
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
        List<User> listU = session.createQuery("FROM User").list();
        for(User p : listU){
			logger.info("User List::"+p);
		}
		return listU;
    }

    public User getUserByUserName(String userName) {
        Session session = this.sessionFactory.getCurrentSession();
        String sql = "select u.* from project.user u where UserName = :userName ";
        NativeQuery query = session.createSQLQuery(sql)
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

        org.hibernate.query.Query query = session.createQuery(sql);
        query.setParameter("username", userName);

        return (UserModel) query.uniqueResult();
    }

    public boolean checkUserInDatabase(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        String sql = "select u.* from project.user u where UserName = :userName";
        NativeQuery query = session.createSQLQuery(sql)
                .addEntity(User.class)
                .setParameter("userName", user.getUsername());
        List list = query.list();
        if (list != null && list.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public long getTotalUser() {
        Session session = this.sessionFactory.getCurrentSession();
        String sql = "select count(*) from project.user u";
        Query<?> query = session.createSQLQuery(sql);
        Long count = ((BigInteger)query.uniqueResult()).longValue();
        return count;
    }

    @Override
    public List<User> findByPageable(Pageable pageable) {
        Session session = this.sessionFactory.getCurrentSession();
        String sql = "select * from project.user";
        NativeQuery query = session.createSQLQuery(sql).addEntity(User.class);
        query.setFirstResult(pageable.getPageNumber());
        query.setMaxResults(pageable.getPageSize());
        List<User> userList = query.list();
        return userList;
    }

}