package com.ptit.managecertificate.dao.Impl;

import com.ptit.managecertificate.dao.PersonDAO;
import com.ptit.managecertificate.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("personDAO")
@Transactional
public class PersonDAOImpl implements PersonDAO {
    private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Person person) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(person);
    }

    @Override
    public void update(Person person) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(person);
    }

    @Override
    public void delete(Person person) {
        Session session = this.sessionFactory.getCurrentSession();
        session.delete(person);
    }

    @Override
    public Person findById(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        return session.get(Person.class, id);
    }

    @Override
    public List<Person> findAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Person> listP = session.createQuery("FROM Person ").list();
        for(Person p : listP){
            logger.info("Person: " + p.toString());
        }
        return listP;
    }

    @Override
    public List<Person> findSameCourse(Long courseId) {
        Session session = this.sessionFactory.getCurrentSession();
        String hql = "from Person p where p.course.id = :courseId";
        List<Person> result = session.createQuery(hql)
        .setParameter("courseId", courseId)
        .list();
        return result;
    }

    @Override
    public Person getPersonByFirstName(String firstName) {
        Session session = this.sessionFactory.getCurrentSession();
        String sql = "select p.* from project.person p where firstName = :firstName ";
        NativeQuery query = session.createSQLQuery(sql)
                .addEntity(Person.class)
                .setParameter("firstName", firstName);
        List list = query.list();
        if (list != null && list.size() > 0) {
            return (Person) query.list().get(0);
        } else {
            return null;
        }
    }

    @Override
    public Person getPersonByLastName(String lastName) {
        Session session = this.sessionFactory.getCurrentSession();
        String sql = "select p.* from project.person p where lastName = :lastName ";
        NativeQuery query = session.createSQLQuery(sql)
                .addEntity(Person.class)
                .setParameter("lastName", lastName);
        List list = query.list();
        if (list != null && list.size() > 0) {
            return (Person) query.list().get(0);
        } else {
            return null;
        }
    }

    @Override
    public boolean checkPersonInDB(Person person) {
        Session session = this.sessionFactory.getCurrentSession();
        String sql = "select p.* from project.person p where id = :id" ;
        NativeQuery query = session.createSQLQuery(sql)
                .addEntity(Person.class)
                .setParameter("id", person.getId());
        List list = query.list();
        if (list != null && list.size() > 0) {
            return true;
        } else {
            return false;
        }
    }
}
