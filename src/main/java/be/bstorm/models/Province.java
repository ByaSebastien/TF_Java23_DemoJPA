package be.bstorm.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Province {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OrderBy("name")
    @OneToMany(mappedBy = "province", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<Municipality> municipalities;

    public Province(){
        municipalities = new ArrayList<>();
    }

    public Province(String name) {
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

    public List<Municipality> getMunicipalities() {
        return List.copyOf(municipalities);
    }

    public void addMunicipality(Municipality municipality){
        municipalities.add(municipality);
    }

    @Override
    public String toString() {
        return "Province{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", municipalities=" + municipalities +
                '}';
    }
}
