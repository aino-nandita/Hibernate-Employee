package dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil
{    
    private static Configuration config;
    private static  SessionFactory sessionfactory;
    
    static
    {
        config=new Configuration().configure("Hibernate.cfg.xml");
    }
    
    public static SessionFactory getSessionFactory(){
        sessionfactory=config.buildSessionFactory();
        return sessionfactory;
    }
    
}