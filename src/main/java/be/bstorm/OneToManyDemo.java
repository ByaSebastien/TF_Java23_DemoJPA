package be.bstorm;

import be.bstorm.models.Mayor;
import be.bstorm.models.Municipality;
import be.bstorm.models.Province;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class OneToManyDemo {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("DemoJPA");
    private static final EntityManager em = emf.createEntityManager();

    public static void add(){

        Municipality municipality = new Municipality("Fexhe le haut Clocher");
        Mayor mayor = new Mayor("Henri Christophe");
        Province province = new Province("Liège");

        municipality.setMayor(mayor);
        municipality.setProvince(province);

        em.getTransaction().begin();

        em.persist(province);

        em.getTransaction().commit();

        System.out.println("Ajout de : " + province);
    }

    public static void get(){

        Province province = em.find(Province.class,1L);
        System.out.println("Recup de : " + province);
    }
}
