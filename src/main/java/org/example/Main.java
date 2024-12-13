package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@SpringBootApplication  // Adnotacja wskazująca, że to aplikacja Spring Boot
public class Main {

    public static void main(String[] args) {
        // Uruchomienie aplikacji Spring Boot
        SpringApplication.run(Main.class, args);

        // Kod do pracy z Hibernate (można to przenieść do osobnej metody lub klasy serwisowej)
        runHibernate();
    }

    public static void runHibernate() {
        // Załaduj konfigurację i zbuduj SessionFactory
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        // Otwórz sesję
        Session session = sessionFactory.openSession();

        try {
            // Rozpocznij transakcję
            session.beginTransaction();

            // Utwórz nowego użytkownika
            User user = new User();
            user.setUsername("john_doe");
            user.setEmail("john.doe@example.com");

            // Zapisz użytkownika w bazie
            session.save(user);

            // Zatwierdź transakcję
            session.getTransaction().commit();

            System.out.println("User saved successfully!");
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            // nie używam tej części kodu, żeby móc otworzyć H2-console w przeglądarce
//            session.close();
//            sessionFactory.close();
        }
    }
}
