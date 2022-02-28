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
    private final String role = "patient";

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
}
