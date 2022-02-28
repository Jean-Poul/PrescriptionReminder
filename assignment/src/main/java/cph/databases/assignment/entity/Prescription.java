package cph.databases.assignment.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "prescription")
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
    @ManyToOne //one directional - should not know on which prescription it is
    @JoinColumn(name = "dose_id")
    private Dose dose;
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
    @Column(name = "remaining_handouts")
    private int remainingHandouts = 1;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "treatment_start")
    private Date treatmentStart;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "treatment_end")
    private Date treatmentEnd;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "validUntil")
    private Date validUntil;
    private String dosage = "Use according to the leaflet";
    @Column(name = "substitution_allowed")
    private boolean substitutionAllowed;
    @OneToMany(mappedBy = "prescription", fetch = FetchType.EAGER)
    private Collection<Handout> handoutList = new ArrayList<>();


    public Prescription() {
    }


    public Prescription(Patient patient, Dose dose, Doctor doctor, int remainingHandouts, Date treatmentStart, Date treatmentEnd, Date validUntil, String dosage, boolean substitutionAllowed) {
        this.patient = patient;
        this.dose = dose;
        this.doctor = doctor;
        this.remainingHandouts = remainingHandouts;
        this.treatmentStart = treatmentStart;
        this.treatmentEnd = treatmentEnd;
        this.validUntil = validUntil;
        this.dosage = dosage;
        this.substitutionAllowed = substitutionAllowed;
    }

    public void handOut(Pharmacist pharmacist, Pharmacy pharmacy) throws Exception {
        if (this.remainingHandouts == 0) throw new Exception("There's no handouts left!");
        Handout handout = new Handout(pharmacist, pharmacy, this);
        handoutList.add(handout);
        this.remainingHandouts--;
    }

    //todo test this
    public void invalidate() {
        LocalDate yesterday = LocalDate.now().minusDays(1);
        Date yesterdayDate = java.sql.Timestamp.valueOf(String.valueOf(yesterday));
        this.validUntil = yesterdayDate;
    }

    public Long getId() {
        return id;
    }

    public Patient getPatient() {
        return patient;
    }

    public Dose getDose() {
        return dose;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public int getRemainingHandouts() {
        return remainingHandouts;
    }

    public Date getTreatmentStart() {
        return treatmentStart;
    }

    public Date getTreatmentEnd() {
        return treatmentEnd;
    }

    public Date getValidUntil() {
        return validUntil;
    }

    public String getDosage() {
        return dosage;
    }

    public boolean isSubstitutionAllowed() {
        return substitutionAllowed;
    }

    public Collection<Handout> getHandoutList() {
        return handoutList;
    }

    protected void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
