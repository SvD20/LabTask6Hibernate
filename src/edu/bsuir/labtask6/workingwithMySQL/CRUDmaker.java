package edu.bsuir.labtask6.workingwithMySQL;


import edu.bsuir.labtask6.entities.Medication;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class CRUDmaker {

    private SessionFactory factory = null;
    private Session session = null;

    public CRUDmaker() {
                 factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Medication.class)
                .buildSessionFactory();
    }

    public void create(String title, String manufacturer, String country, String purpose, int price){
        try{
            session = factory.getCurrentSession();
            session.beginTransaction();
            Medication newmedication = new Medication(title,manufacturer,country,purpose,price);
            session.save(newmedication);
            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            session.close();
        }
    }

    public List <Medication> read(String purpose){
        try{
            session = factory.getCurrentSession();
            session.beginTransaction();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append('\'');
            stringBuilder.append(purpose);
            stringBuilder.append('\'');
            String half_of_query = stringBuilder.toString();
            String query ="from Medication " + "where purpose = " + half_of_query;
            List<Medication> medications = session.createQuery(query).getResultList();
            session.getTransaction().commit();
            System.out.println("Done!");
            return medications;
        }
        finally {
            session.close();
        }
    }


    public void update(String title, int newprice){
        try{
            session = factory.getCurrentSession();
            session.beginTransaction();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append('\'');
            stringBuilder.append(title);
            stringBuilder.append('\'');
            String half_of_query = stringBuilder.toString();
            String query = "update Medication set price = " + newprice + " where title = " + half_of_query;
            session.createQuery(query).executeUpdate();
            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            session.close();
        }
    }

    public void delete(String title, String manufacturer){
        try{
            session = factory.getCurrentSession();
            session.beginTransaction();
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append('\'');
            stringBuilder1.append(title);
            stringBuilder1.append('\'');
            String half_of_query1 = stringBuilder1.toString();
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append('\'');
            stringBuilder2.append(manufacturer);
            stringBuilder2.append('\'');
            String half_of_query2 = stringBuilder2.toString();
            String query = "delete Medication " + "where title = " + half_of_query1 + " AND manufacturer = " + half_of_query2;
            session.createQuery(query).executeUpdate();
            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            session.close();
        }
    }

    public void factoryClose(){
        factory.close();
        System.out.println("Disconnect...");
    }

}
