package cph.databases.assignment.entity;

import javax.persistence.*;

@Table(name = "dosage_type")
@Entity
public class DosageType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_id", nullable = false)
    private Integer type_id;
}
