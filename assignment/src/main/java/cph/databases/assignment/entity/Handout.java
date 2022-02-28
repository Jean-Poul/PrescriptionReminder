package cph.databases.assignment.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "handout")
public class Handout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "prescription_id")
    private Prescription prescription;
    @ManyToOne
    @JoinColumn(name = "pharmacist_id")
    private Pharmacist pharmacist;
    @ManyToOne
    @JoinColumn(name = "pharmacy_id")
    private Pharmacy pharmacy;
    @Temporal(TemporalType.DATE)
    @Column(name = "date")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private final Date date = new Date();

    public Handout() {
    }

    protected Handout(Pharmacist pharmacist, Pharmacy pharmacy, Prescription prescription) {
        this.pharmacist = pharmacist;
        this.pharmacy = pharmacy;
        this.prescription = prescription;
    }

    public Long getId() {
        return id;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public Pharmacist getPharmacist() {
        return pharmacist;
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public Date getDate() {
        return date;
    }

    protected void setPharmacist(Pharmacist pharmacist) {
        this.pharmacist = pharmacist;
    }
}
