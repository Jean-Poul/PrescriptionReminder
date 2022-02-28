package cph.databases.assignment.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "p_modification")
public class PrescriptionModification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "prescription_id")
    private Prescription prescription;

    private String type;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
    @ManyToOne
    @JoinColumn(name = "pharmacist_id")
    private Pharmacist pharmacist;

    @Temporal(TemporalType.DATE)
    @Column(name = "date")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private final Date date = new Date();

    public PrescriptionModification() {
    }

    public PrescriptionModification(Prescription prescription, Doctor doctor, String type) {
        this.prescription = prescription;
        this.doctor = doctor;
        this.pharmacist = null;
        this.type = type;
    }

    public PrescriptionModification(Prescription prescription, Pharmacist pharmacist, String type) {
        this.prescription = prescription;
        this.doctor = null;
        this.pharmacist = pharmacist;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public String getType() {
        return type;
    }

    public Pharmacist getPharmacist() {
        return this.pharmacist;
    }

    protected void setPharmacist(Pharmacist pharmacist) {
        this.pharmacist = pharmacist;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    protected void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Date getDate() {
        return date;
    }

}
