package cph.databases.assignment.entity;

import javax.persistence.*;

@Table(name = "dosage_type")
@Entity
public class Dosage_type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_id", nullable = false)
    private Integer type_id;
}
