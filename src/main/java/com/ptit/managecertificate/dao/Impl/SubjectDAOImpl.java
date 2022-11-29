package com.ptit.managecertificate.dao.Impl;

import com.ptit.managecertificate.dao.SubjectDAO;
import com.ptit.managecertificate.entity.Subject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("subjectDAO")
@Transactional
public class SubjectDAOImpl implements SubjectDAO {
    private static final Logger logger = LoggerFactory.getLogger(SubjectDAOImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Subject subject) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(subject);
    }

    @Override
    public void update(Subject subject) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(subject);
    }

    @Override
    public void delete(Subject subject) {
        Session session = this.sessionFactory.getCurrentSession();
        session.delete(subject);
    }

    @Override
    public Subject findById(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        return session.get(Subject.class, id);
    }

    @Override
    public List<Subject> findAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Subject> listSubject = session.createQuery("FROM Subject ").list();
        for(Subject s: listSubject){
            logger.info("Subject:" + s);
        }
        return listSubject;
    }

    @Override
    public Subject getSubjectByName(String name) {
        Session session = this.sessionFactory.getCurrentSession();
        String sql = "select s.* from project.subject s where name = :name";

        NativeQuery query = session.createSQLQuery(sql)
                .addEntity(Subject.class)
                .setParameter("name", name);
        List list = query.list();

        if (list != null && list.size() > 0) {
            return (Subject) query.list().get(0);
        } else {
            return null;
        }
    }

    @Override
    public boolean checkSubjectInDatabase(Subject subject) {
        Session session = this.sessionFactory.getCurrentSession();
        String sql = "select s.* from project.subject s where name = :name";
        NativeQuery querry = session.createSQLQuery(sql)
                .addEntity(Subject.class)
                .setParameter("name", subject.getName());

        List list = querry.list();
        if (list != null && list.size() > 0) {
            return true;
        } else {
            return false;
        }
    }
}
