package cph.databases.assignment.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Table(name = "doctor")
@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private final String role = "doctor";
    @OneToOne
    @JoinColumn(name = "cpr")
    private Person cpr;
    @OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY)
    private Collection<Lookup> lookupList = new ArrayList<>();
    @OneToMany(mappedBy = "doctor", fetch = FetchType.EAGER)
    private Collection<Prescription> prescriptionList = new ArrayList<>();

    public Doctor() {
    }

    public Long getId() {
        return id;
    }

    public Collection<Lookup> getLookupList() {
        return lookupList;
    }

    public String getRole() {
        return role;
    }

    public Collection<Prescription> getPrescriptionList() {
        return prescriptionList;
    }

    public void addLookup(Lookup lookup) {
        this.lookupList.add(lookup);
        if (lookup.getDoctor() == null) {
            lookup.setDoctor(this);
        }
    }

    public Prescription newPrescription(Prescription prescription) {
        this.prescriptionList.add(prescription);
        if (prescription.getDoctor() == null) {
            prescription.setDoctor(this);
        }

        return prescription;
    }

    public Person getCpr() {
        return cpr;
    }
}
