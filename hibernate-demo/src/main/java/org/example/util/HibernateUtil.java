package org.example.util;

import org.example.model.Zoid;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class HibernateUtil {
    static Session session;
    private static SessionFactory sessionFactory;
    Transaction transaction;

    private static SessionFactory getSessionFactory() {
        // https://stackoverflow.com/questions/23908606/how-to-use-hibernate-properties-file-instead-of-hibernate-cfg-xml
        try {
            Configuration configuration = new Configuration();
            ServiceRegistry serviceRegistry
                    = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
            configuration.addAnnotatedClass(Zoid.class);
            return configuration
                    .buildSessionFactory(serviceRegistry);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("There is issue in hibernate util");
        }
    }

    public Session getSession() {
        return session;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void beginTransaction() throws IOException {
        // using our session factory, open up a session:
        session = getSessionFactory().openSession();
        // using our session, begin a transaction:
        transaction = session.beginTransaction();
    }


    public void closeTransaction() {
        // commit transaction and close the session:
        transaction.commit();
        session.close();

    }
}
