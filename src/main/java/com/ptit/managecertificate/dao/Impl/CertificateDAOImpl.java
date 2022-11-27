package com.ptit.managecertificate.dao.Impl;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ptit.managecertificate.dao.CertificateDAO;
import com.ptit.managecertificate.entity.Certificate;
import com.ptit.managecertificate.entity.User;

@Repository("certificateDao")
@Transactional
public class CertificateDAOImpl implements CertificateDAO {
    private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);

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
    public void delete(Certificate certificate) {
        Session session = this.sessionFactory.getCurrentSession();
        session.delete(certificate);
    }

    @Override
    public List<Certificate> findAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Certificate> listC = session.createQuery("FROM Certificate ").list();
        for(Certificate c : listC){
            logger.info("Certificate: " + c.toString());
        }
        return listC;
    }

    @Override
    public Certificate getCertificateByCode(String code) {
        Session session = this.sessionFactory.getCurrentSession();
        return session.get(Certificate.class, code);
    }

    @Override
    public Certificate getCertificateByCertificateName(String name) {
        Session session = this.sessionFactory.getCurrentSession();
        String sql = "select c.* from project.certificate c where name = :name ";
        NativeQuery query = session.createSQLQuery(sql)
                .addEntity(Certificate.class)
                .setParameter("name", name);
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
        String sql = "select c.* from project.certificate c where code = :code" ;
        NativeQuery query = session.createSQLQuery(sql)
                .addEntity(Certificate.class)
                .setParameter("code", certificate.getCode());
        List list = query.list();
        if (list != null && list.size() > 0) {
            return true;
        } else {
            return false;
        }
    }
}
