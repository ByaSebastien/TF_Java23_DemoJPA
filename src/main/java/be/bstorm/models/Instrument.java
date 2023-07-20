package be.bstorm.models;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.hibernate.annotations.ManyToAny;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Instrument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "instruments", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Set<Musician> musicians;

    public Instrument(){
        musicians = new HashSet<>();
    }

    public Instrument(String name) {
        this();
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Musician> getMusicians() {
        return Set.copyOf(musicians);
    }

    public void addMusician(Musician musician){
        musicians.add(musician);
    }

    @Override
    public String toString() {
        return "Instrument{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
