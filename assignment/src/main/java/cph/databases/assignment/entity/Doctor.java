package cph.databases.assignment.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Table(name = "doctor")
@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

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