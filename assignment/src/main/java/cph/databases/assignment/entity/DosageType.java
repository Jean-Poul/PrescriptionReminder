package cph.databases.assignment.entity;

import javax.persistence.*;

@Entity
@Table(name = "dosagetype")
public class DosageType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    // Constructors
    public DosageType() {
    }

    // Getters and setters

}
