package com.ptit.managecertificate.dao.Impl;

import com.ptit.managecertificate.dao.CourseDAO;
import com.ptit.managecertificate.entity.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("courseDAO")
@Transactional
public class CourseDAOImpl implements CourseDAO {

    private static final Logger logger = LoggerFactory.getLogger(CourseDAOImpl.class);

    @Autowired
    SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Course course) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(course);
    }

    @Override
    public void update(Course course) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(course);
    }

    @Override
    public void delete(Course course) {
        Session session = this.sessionFactory.getCurrentSession();
        session.delete(course);
    }

    @Override
    public Course findById(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        return session.get(Course.class, id);
    }

    @Override
    public List<Course> findAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Course> listCourse = session.createQuery("FROM Course ").list();
        for(Course s: listCourse){
            logger.info("Course:" + s);
        }
        return listCourse;
    }

    @Override
    public Course getCourseByName(String name) {
        Session session = this.sessionFactory.getCurrentSession();
        String sql = "select s.* from project.course s where name = :name";

        NativeQuery query = session.createSQLQuery(sql)
                .addEntity(Course.class)
                .setParameter("name", name);
        List list = query.list();

        if (list != null && list.size() > 0) {
            return (Course) query.list().get(0);
        } else {
            return null;
        }
    }

    @Override
    public boolean checkCourseInDB(Course course) {
        Session session = this.sessionFactory.getCurrentSession();
        String sql = "select s.* from project.course s where name = :name";
        NativeQuery querry = session.createSQLQuery(sql)
                .addEntity(Course.class)
                .setParameter("name", course.getName());
        List list = querry.list();
        if (list != null && list.size() > 0) {
            return true;
        } else {
            return false;
        }
    }
}
