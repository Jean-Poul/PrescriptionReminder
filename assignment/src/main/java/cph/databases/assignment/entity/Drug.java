package cph.databases.assignment.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

//readonly
@Table(name = "drug")
@Entity
public class Drug {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(name = "generic_name")
    private String genericName;
    private String company;
    private String diagnosis;
    @Column(name = "diagnosis_code")
    private String diagnosisCode;
    @OneToMany(mappedBy = "drug", fetch = FetchType.EAGER)
    private Collection<Dose> doseList = new ArrayList<>();

    public Drug() {
    }

    public Collection<Dose> getDoseList() {
        return doseList;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGenericName() {
        return genericName;
    }

    public String getCompany() {
        return company;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public String getDiagnosisCode() {
        return diagnosisCode;
    }
}
