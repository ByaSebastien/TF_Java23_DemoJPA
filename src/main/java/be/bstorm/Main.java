package be.bstorm;

import be.bstorm.models.Mayor;
import be.bstorm.models.Municipality;
import be.bstorm.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DemoJPA");
        EntityManager em = emf.createEntityManager();

        //region MiniCrud
//        User user = new User("Jacquie","Chan");
//        User user2 = new User("Bruce","Lee");
//        MiniCRUD.add(user);
//        MiniCRUD.add(user2);
//        Optional<User> recupUser = MiniCRUD.getOne(1L);
//        if(recupUser.isPresent()){
//            System.out.println(recupUser.get());
//            user = recupUser.get();
//            user.setFirstname("Toto");
//            MiniCRUD.update(user);
//        }
//        MiniCRUD.getAll();
//        MiniCRUD.update(2L);
//        MiniCRUD.delete(2L);
        //endregion

        //region One to one
//        Municipality municipality = new Municipality("Fexhe le Haut Clocher");
//        Mayor mayor = new Mayor("Henry Christophe");
//
//        municipality.setMayor(mayor);
//
//        em.getTransaction().begin();
//        em.persist(municipality);
//        em.getTransaction().commit();
//
//        em.clear();
//
//        Municipality result = em.find(Municipality.class,1);
//        Mayor mayor1 = result.getMayor();
//        System.out.println(mayor1.getName());

//        OneToOneDemo.add();
//        OneToOneDemo.get();

        //endregion

        //region One to many

//        OneToManyDemo.add();
//        OneToManyDemo.get();

        //endregion


        //region Many to many

        ManyToManyDemo.add();
        ManyToManyDemo.get();

        //endregion
    }
}