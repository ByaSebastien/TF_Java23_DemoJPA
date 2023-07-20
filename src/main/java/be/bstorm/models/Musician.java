package be.bstorm.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Musician {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(cascade = CascadeType.PERSIST,
                fetch = FetchType.EAGER)
    private Set<Instrument> instruments;

    public Musician(){
        instruments = new HashSet<>();
    }

    public Musician(String name) {
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

    public Set<Instrument> getInstruments() {
        return Set.copyOf(instruments);
    }

    public void addInstrument(Instrument instrument){
        instruments.add(instrument);
        instrument.addMusician(this);
    }

    @Override
    public String toString() {
        return "Musician{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", instruments=" + instruments +
                '}';
    }
}
