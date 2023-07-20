package be.bstorm;

import be.bstorm.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class MiniCRUD {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("DemoJPA");
    private static final EntityManager em = emf.createEntityManager();

    public static void add(User u) {

        em.getTransaction().begin();

        em.persist(u);

        em.getTransaction().commit();

        System.out.println("Ajout de : " + u);
    }

    public static Optional<User> getOne(Long id) {

        User user = em.find(User.class, id);

        System.out.println("Récuperation de : " + user);

        return Optional.ofNullable(user);
    }

    public static List<User> getAll() {

        TypedQuery<User> query = em.createQuery("select u from User u", User.class);
        List<User> users = query.getResultList();
        System.out.println("Resultat(s) reçu : ");
        users.forEach(System.out::println);
        em.clear();
        return users;
    }

    public static void update(User u) {

        em.getTransaction().begin();

        em.merge(u);

        em.getTransaction().commit();

        System.out.println("Modification de : " + u);
    }

    public static void update(Long id) {

        em.getTransaction().begin();

        User previous = em.find(User.class, id);
        previous.setFirstname("Alphonse");

        em.getTransaction().commit();

        System.out.println("Modification de : " + previous);
    }

    public static void delete(Long id) {

        em.getTransaction().begin();

        Optional<User> user = getOne(id);

        if (user.isPresent()) {
            em.remove(user.get());
            System.out.println("Suppression de : " + user.get());
        }
        em.getTransaction().commit();

    }

}
