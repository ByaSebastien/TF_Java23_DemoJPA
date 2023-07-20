package be.bstorm.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "CUSTOMER",
       uniqueConstraints = {@UniqueConstraint(name = "UK_CUSTOMER__FIRST_NAME__LAST_NAME",
                                              columnNames = {"FIRST_NAME","LAST_NAME"})})
@Access(AccessType.FIELD)
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "FIRST_NAME",length = 50,nullable = false)
    private String firstname;
    @Column(name = "LAST_NAME",length = 50,nullable = false)
    private String lastname;
    @Temporal(TemporalType.DATE)
    private LocalDate birthdate;
    @Enumerated(EnumType.STRING)
    private Gender gender;

    public User(){}

    public User(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
