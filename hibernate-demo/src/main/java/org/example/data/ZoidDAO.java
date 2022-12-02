package org.example.data;

import org.example.model.Zoid;
import org.example.util.HibernateUtil;

public class ZoidDAO{

    private HibernateUtil hu;

    // CRUD operations using Save, Update, Delete
    public Zoid insert(Zoid zoid) {
        try {
            hu = new HibernateUtil();
            hu.beginTransaction();
            hu.getSession().save(zoid);
            hu.closeTransaction();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return zoid;
    }

    // Exercise, fill out the rest of the CRUD methods (update, getById, getAll, delete)
    // Also create a service and CommandLine/Servlet layer that lets us interact with the program and choose different operations

}
