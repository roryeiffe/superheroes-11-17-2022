package org.example;

import org.example.data.ZoidDAO;
import org.example.model.Zoid;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Zoid zoid = new Zoid("Lion", "Rex", "Silver", 10.5, 9);
        ZoidDAO zoidDAO = new ZoidDAO();
        zoidDAO.insert(zoid);
        // check if the id was generated
        System.out.println(zoid);
    }
}
