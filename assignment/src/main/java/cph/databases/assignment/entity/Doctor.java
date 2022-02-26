package cph.databases.assignment.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Table(name = "doctor")
@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY)
    private Collection<Lookup> lookupList = new ArrayList<>();
    private final String role = "doctor";
    @OneToMany(mappedBy = "doctor", fetch = FetchType.EAGER)
    private Collection<Prescription> prescriptionList = new ArrayList<>();

    public Doctor() {
    }
}
 /*
  @NotNull
    @OneToMany
    @JoinColumn(name = "person_id")
    private Person person;



    public Doctor(Integer id, Person person) {
        this.id = id;
        this.person = person;
    }

    // Getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
*/