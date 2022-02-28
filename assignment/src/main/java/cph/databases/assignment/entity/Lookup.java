package cph.databases.assignment.entity;

import cph.databases.assignment.entity.Doctor;
import cph.databases.assignment.entity.Patient;
import cph.databases.assignment.entity.Pharmacist;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "lookups")
public class Lookup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

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

    public Lookup() {
    }

    public Lookup(Patient patient, Doctor doctor) {
        this.patient = patient;
        this.doctor = doctor;
        this.pharmacist = null;
    }

    public Lookup(Patient patient, Pharmacist pharmacist) {
        this.patient = patient;
        this.doctor = null;
        this.pharmacist = pharmacist;
    }

    public Patient getPatient() {
        return patient;
    }

    public Date getDate() {
        return date;
    }

    public Long getId() {
        return id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    protected void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Pharmacist getPharmacist() {
        return pharmacist;
    }

    protected void setPharmacist(Pharmacist pharmacist) {
        this.pharmacist = pharmacist;
    }
}
