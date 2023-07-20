package be.bstorm;

import be.bstorm.models.Instrument;
import be.bstorm.models.Musician;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ManyToManyDemo {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("DemoJPA");
    private static final EntityManager em = emf.createEntityManager();

    public static void add(){

        Musician musician = new Musician("Jimmy Hendricks");
        Instrument instrument = new Instrument("Guitare");

        musician.addInstrument(instrument);

        em.getTransaction().begin();

        em.persist(musician);

        em.getTransaction().commit();

        System.out.println("Ajout de : " + musician);
    }

    public static void get(){

        Musician musician = em.find(Musician.class,1L);
        System.out.println("Recup de : " + musician);
    }
}
