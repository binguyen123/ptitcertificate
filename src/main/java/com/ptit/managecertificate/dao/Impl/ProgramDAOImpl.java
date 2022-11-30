package com.ptit.managecertificate.dao.Impl;

import com.ptit.managecertificate.dao.ProgramDAO;
import com.ptit.managecertificate.entity.Certificate;
import com.ptit.managecertificate.entity.Program;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("programDAO")
@Transactional
public class ProgramDAOImpl implements ProgramDAO {
    private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void save(Program program) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(program);
    }

    @Override
    public void update(Program program) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(program);
    }

    @Override
    public void delete(Program program) {
        Session session = this.sessionFactory.getCurrentSession();
        session.delete(program);
    }

    @Override
    public Program findById(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        return session.get(Program.class, id);
    }

    @Override
    public List<Program> findAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Program> listP = session.createQuery("FROM Program ").list();
        for(Program p : listP){
            logger.info("Program: " + p.toString());
        }
        return listP;
    }

    @Override
    public Program getProgramByName(String name) {
        Session session = this.sessionFactory.getCurrentSession();
        String sql = "select p.* from project.program p where name = :name ";
        NativeQuery query = session.createSQLQuery(sql)
                .addEntity(Program.class)
                .setParameter("name", name);
        List list = query.list();
        if (list != null && list.size() > 0) {
            return (Program) query.list().get(0);
        } else {
            return null;
        }
    }

    @Override
    public boolean checkProgramInDB(Program program) {
        Session session = this.sessionFactory.getCurrentSession();
        String sql = "select c.* from project.program c where c.id = :id" ;
        NativeQuery query = session.createSQLQuery(sql)
                .addEntity(Program.class)
                .setParameter("id", program.getId());
        List list = query.list();
        if (list != null && list.size() > 0) {
            return true;
        } else {
            return false;
        }
    }
}
