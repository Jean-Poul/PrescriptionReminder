package cph.databases.assignment.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @OneToOne
    @JoinColumn(name = "cpr")
    private Person cpr;
    private final String role = "patient";
    @Column(name = "pharmacy_id")
    private Long favoritePharmacyId;
    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY)
    private Collection<Lookup> lookupList = new ArrayList<>();
    @OneToMany(mappedBy = "patient", fetch = FetchType.EAGER)
    private Collection<Prescription> prescriptionList = new ArrayList<>();



    // Constructors
    public Patient() {
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public Collection<Lookup> getLookupList() {
        return lookupList;
    }

    public Collection<Prescription> getPrescriptionList() {
        return prescriptionList;
    }

    public Person getCpr() {
        return cpr;
    }

    public String getRole() {
        return role;
    }

    public Long getFavoritePharmacyId() {
        return favoritePharmacyId;
    }

    public void setFavoritePharmacyId(Long favoritePharmacyId) {
        this.favoritePharmacyId = favoritePharmacyId;
    }

    protected void addPrescription(Prescription prescription) {
        this.prescriptionList.add(prescription);
        if (prescription.getPatient() == null) {
            prescription.setPatient(this);
        }
    }
}
