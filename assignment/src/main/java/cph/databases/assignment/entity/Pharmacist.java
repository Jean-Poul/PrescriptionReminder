package cph.databases.assignment.entity;

import cph.databases.assignment.repository.ModificationRepo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "pharmacist")
public class Pharmacist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @OneToOne
    @JoinColumn(name = "cpr")
    private Person cpr;
    @ManyToOne
    @JoinColumn(name = "pharmacy_id")
    private Pharmacy pharmacy;
    @OneToMany(mappedBy = "pharmacist", fetch = FetchType.LAZY)
    private Collection<Lookup> lookupList = new ArrayList<>();
    @OneToMany(mappedBy = "pharmacist", fetch = FetchType.EAGER)
    private Collection<Handout> handoutList = new ArrayList<>();
    private final String role = "pharmacist";
    @OneToMany(mappedBy = "pharmacist", fetch = FetchType.EAGER)
    private Collection<PrescriptionModification> modificationList = new ArrayList<>();

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public Pharmacist() {
    }

    public Long getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    public Person getCpr() {
        return cpr;
    }

    public void addLookup(Lookup lookup) {
        this.lookupList.add(lookup);
        if (lookup.getPharmacist() == null) {
            lookup.setPharmacist(this);
        }
    }

    public void addHandout(Handout handout) {
        this.handoutList.add(handout);
        if (handout.getPharmacist() == null) {
            handout.setPharmacist(this);
        }
    }

    public void addModification(PrescriptionModification modification) {
        this.modificationList.add(modification);
        if (modification.getPharmacist() == null) {
            modification.setPharmacist(this);
        }
    }

    public Collection<PrescriptionModification> getModificationList() {
        return modificationList;
    }

    public Collection<Lookup> getLookupList() {
        return lookupList;
    }

    public Collection<Handout> getHandoutList() {
        return handoutList;
    }
}
