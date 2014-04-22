package com.test;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
 
public class AppTest extends TestCase {
    Serializable id;
    public AppTest(String testName) {
        super(testName);
    }
 
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }
 
    public void testHibernate() throws Exception {
        SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
 
        Session session = sessionFactory.getCurrentSession();
 
        Transaction tx = session.beginTransaction();
 
        Blog b = new Blog();
        id = session.save(b);
 
        tx.commit();

        session = sessionFactory.getCurrentSession();
        tx = session.beginTransaction();
        Blog blog = (Blog)session.get(Blog.class, id);

        Assert.assertNotNull(blog);
        tx.commit();
// the connection pool implementation in hibernate is bad.
// Either use 3cpo or dbcp or dont use it at all...
// in this example we set the connection pooling off.
// <property name="connection.pool_size">0</property>
    }
}