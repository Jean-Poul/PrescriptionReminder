package cph.databases.assignment.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "pharmacist")
public class Pharmacist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @OneToMany(mappedBy = "pharmacist", fetch = FetchType.LAZY)
    private Collection<Lookup> lookupList = new ArrayList<>();
    @OneToMany(mappedBy = "pharmacist", fetch = FetchType.EAGER)
    private Collection<Handout> handoutList = new ArrayList<>();
    private final String role = "pharmacist";


    public Pharmacist() {
    }
}
