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
    private final LocalDateTime myDateObj = LocalDateTime.now();
    String formattedDate = formattingDate(myDateObj);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY)
    private Collection<Lookup> lookupList = new ArrayList<>();
    @OneToMany(mappedBy = "patient", fetch = FetchType.EAGER)
    private Collection<Prescription> prescriptionList = new ArrayList<>();
    /*@NotNull
    private int remaining_handouts;
    @NotNull
    private String pickup_pharmacy;
    @NotNull
    private String treatment_start;
    @NotNull
    private String treatment_end;
    @NotNull
    private String expiration_date;
    @NotNull
    private String dosage;
    @NotNull
    private Boolean isSubstitution;
    @NotNull
    private String dosage_type;*/

    // Date formatter
    private String formattingDate (LocalDateTime myDateObj) {
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return myDateObj.format(myFormatObj);
    }

    // Constructors
    public Patient() {
    }

    // Getters and setters
    public LocalDateTime getMyDateObj() {
        return myDateObj;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Collection<Lookup> getLookupList() {
        return lookupList;
    }

    public void setLookupList(Collection<Lookup> lookupList) {
        this.lookupList = lookupList;
    }

    public Collection<Prescription> getPrescriptionList() {
        return prescriptionList;
    }

    public void setPrescriptionList(Collection<Prescription> prescriptionList) {
        this.prescriptionList = prescriptionList;
    }
/*
    public int getRemaining_handouts() {
        return remaining_handouts;
    }

    public void setRemaining_handouts(int remaining_handouts) {
        this.remaining_handouts = remaining_handouts;
    }

    public String getPickup_pharmacy() {
        return pickup_pharmacy;
    }

    public void setPickup_pharmacy(String pickup_pharmacy) {
        this.pickup_pharmacy = pickup_pharmacy;
    }

    public String getTreatment_start() {
        return treatment_start;
    }

    public void setTreatment_start(String treatment_start) {
        this.treatment_start = treatment_start;
    }

    public String getTreatment_end() {
        return treatment_end;
    }

    public void setTreatment_end(String treatment_end) {
        this.treatment_end = treatment_end;
    }

    public String getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(String expiration_date) {
        this.expiration_date = expiration_date;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public Boolean getSubstitution() {
        return isSubstitution;
    }

    public void setSubstitution(Boolean substitution) {
        isSubstitution = substitution;
    }

    public String getDosage_type() {
        return dosage_type;
    }

    public void setDosage_type(String dosage_type) {
        this.dosage_type = dosage_type;
    }*/
}
