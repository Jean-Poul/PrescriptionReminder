package cph.databases.assignment.entity.prescription;

import javax.persistence.*;

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

    public void setDrug(Drug drug) {
        this.drug = drug;
        if(!drug.getDoseList().contains(this)){
            drug.addDose(this);
        }
    }

    public int getId() {
        return id;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }
}
