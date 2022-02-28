package cph.databases.assignment.entity;

import javax.persistence.*;

//readonly
@Entity
@Table(name = "drug_dose")
public class Dose {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "drug_id")
    private Drug drug;
    private String form;
    private String unit;
    private int strength;

    public Dose() {
    }

    public Drug getDrug() {
        return drug;
    }

    public int getId() {
        return id;
    }

    public String getForm() {
        return form;
    }

    public String getUnit() {
        return unit;
    }

    public int getStrength() {
        return strength;
    }

}
