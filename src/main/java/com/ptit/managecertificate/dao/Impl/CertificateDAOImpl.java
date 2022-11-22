package com.ptit.managecertificate.dao.Impl;

import com.ptit.managecertificate.dao.CertificateDAO;
import com.ptit.managecertificate.entity.Certificate;
import com.ptit.managecertificate.entity.Profile;
import com.ptit.managecertificate.entity.User;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("certificateDao")
@Transactional
public class CertificateDAOImpl implements CertificateDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Certificate certificate) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(certificate);
    }

    @Override
    public void update(Certificate certificate) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(certificate);
    }

    @Override
    public Certificate findById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        return session.get(Certificate.class, id);
    }

    @Override
    public void delete(Certificate certificate) {
        Session session = this.sessionFactory.getCurrentSession();
        session.delete(certificate);
    }

    @Override
    public List<Certificate> findAll() {
        Session session = this.sessionFactory.getCurrentSession();
        return session.createQuery("FROM Certificate ").list();
    }

    @Override
    public Certificate getCertificateByCertificateName(String certificateName) {
        Session session = this.sessionFactory.getCurrentSession();
        String sql = "select certificate.* from certificate where title = :certificateName ";
        SQLQuery query = session.createSQLQuery(sql)
                .addEntity(Profile.class)
                .setParameter("certificateName", certificateName);
        List list = query.list();
        if (list != null && list.size() > 0) {
            return (Certificate) query.list().get(0);
        } else {
            return null;
        }
    }

    @Override
    public boolean checkCertificateInDatabase(Certificate certificate) {
        Session session = this.sessionFactory.getCurrentSession();
        String sql = "select certificate.* from certificate where Title = :title";
        SQLQuery query = (SQLQuery) session.createSQLQuery(sql)
                .addEntity(User.class)
                .setParameter("title", certificate.getName());
        List list = query.list();
        if (list != null && list.size() > 0) {
            return true;
        } else {
            return false;
        }
    }
}
