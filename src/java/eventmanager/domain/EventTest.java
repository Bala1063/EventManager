/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventmanager.domain;

import eventmanager.Util.HibernateUtil;
import static java.lang.System.out;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author bala
 */
public class EventTest {

    public static void saveEvents() {
        Event event = new Event();
        event.setName("Java Days");
        event.setStartDate(new java.util.Date(108, Calendar.JULY, 1));

        Session session = HibernateUtil.openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from Location where name=:name");
        query.setParameter("name", "Kasetsart University");
        List list = query.list();
        event.setLocation((Location) list.get(0));
        out.printf("Saving event: %s\nLocation: %s\n", event, event.getLocation());
        session.save(event);
        tx.commit();
        out.println("Event saved");
    }

    public static void testUpdate(String name, Location newLoc) {
        Session session = HibernateUtil.openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from Event where name=:name");
        query.setParameter("name", name);
        List list = query.list();
        if (list.size() == 0) {
            out.println("Event not found");
        } else {
            Event event = (Event) list.get(0);
            event.setLocation(newLoc);
        }
        tx.commit();
        session.close();

    }

    public static void testRetrieve() {
        Session session = HibernateUtil.openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from Event");
        List list = query.list();
         tx.commit();
            session.close();
        if (list.size() == 0) {
            System.out.println("Not found");
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                System.out.println((Event) it.next());
            }

           
        }
    }

    public static void updateEvent(String name, Location newLoc) {
        Session session = HibernateUtil.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from Event where name=:name");
        query.setParameter("name", name);
        List list = query.list();
        if (list.size() == 0) {
            out.println("Event not found");
        } else {
            Event event = (Event) list.get(0);
            event.setLocation(newLoc);
        }
        transaction.commit();
        session.close();

    }

    public static void addSpeakers(String eventName, Speaker speaker) {
        Session session = HibernateUtil.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from Event where name=:name");
        query.setParameter("name", eventName);
        List list = query.list();
        if (list.size() == 0) {
            System.out.println("not found");
        } else {
            Event event = (Event) list.get(0);
            event.addSpeaker(speaker);
        }
        transaction.commit();
        session.close();
    }

    public static void main(String[] args) {
//LocationTest.saveLocations();
//saving Events 
        // saveEvents();
 //retrieving Events 
        testRetrieve();

        /* // Updating Event's location
        Session session = HibernateUtil.openSession();
        Transaction t = session.beginTransaction();
        Query query = session.createQuery("From Location where name=:name");
        query.setParameter("name", "Mahidol University");
        List list = query.list();
        if (list.size() == 0) {
            System.out.println("Not found");
        } else {
            Location location = (Location) list.get(0);
            testUpdate("Java Days", location);
         */
    /*  // Adding Speakers to Event.
        Speaker speaker = new Speaker("Balaji", "9865522087");
         addSpeakers("Java Days", speaker); */
    
        
        
    }

}
