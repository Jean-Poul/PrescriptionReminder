package cph.databases.assignment.entity;

import javax.persistence.*;

@Entity
@Table(name = "interactivetype")
public class InteractiveType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    // Constructors
    public InteractiveType() {
    }

    // Getters and setters

}
