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
    @NotNull
    @OneToMany
    @JoinColumn(name = "person_id")
    private Person person;


    public Doctor() {
    }
}
