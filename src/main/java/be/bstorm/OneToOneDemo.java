package be.bstorm;

import be.bstorm.models.Mayor;
import be.bstorm.models.Municipality;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class OneToOneDemo {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("DemoJPA");
    private static final EntityManager em = emf.createEntityManager();


    public static void add(){

        Municipality municipality = new Municipality("Fexhe le Haut Clocher");
        Mayor mayor = new Mayor("Henry Christophe");
        municipality.setMayor(mayor);
        mayor.setMunicipality(municipality);


        em.getTransaction().begin();

        em.persist(municipality);

        em.getTransaction().commit();

        System.out.println("Commune ajoutée : " + municipality);
    }

    public static void get(){

        Municipality municipality = em.find(Municipality.class,1);

        System.out.println(municipality);
        System.out.println(municipality.getMayor());
    }
}
