/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author u05594757139
 */
public abstract class AbstractDAO {
    public Session session;
    protected Connection cnt;

    public AbstractDAO() {
       SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
       session = sessionFactory.openSession();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://10.7.0.51:33062/db_gabriel_amaral";
            String user = "gabriel_amaral";
            String pass = "gabriel_amaral";

            cnt = DriverManager.getConnection(url, user, pass);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public abstract void insert(Object object);
    public abstract void update(Object object);
    public abstract void delete(Object object);
    public abstract Object list(int codigo);
    public abstract Object listAll();
}




