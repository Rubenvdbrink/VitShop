package Rubenvdbrink.app.listeners;

import Rubenvdbrink.app.persistance.PersistanceManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Data aan het ophalen uit azure!");
        try {
            PersistanceManager.loadDataFromAzure();
            System.out.println("Data opgehaald!");
        } catch (Exception e) {
            System.out.println("Kan data niet ophalen!");
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Data aan het wegschrijven naar azure!");
        try {
            PersistanceManager.saveDataToAzure();
            System.out.println("Data is opgeslagen!");
        } catch (Exception e) {
            System.out.println("Kan data niet opslaan!");
            e.printStackTrace();
        }
    }
}
