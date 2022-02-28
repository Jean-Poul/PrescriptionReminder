package cph.databases.assignment.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "pharmacy")
public class Pharmacy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @OneToMany(mappedBy = "pharmacy", fetch = FetchType.EAGER)
    private Collection<Handout> handoutList = new ArrayList<>();
    @NotNull
    private String address;
    @NotNull
    private int phone;
    @OneToMany(mappedBy = "pharmacy", fetch = FetchType.EAGER)
    private Collection<Pharmacist> employees = new ArrayList<>();


    // Constructors
    public Pharmacy() {
    }

    public Pharmacy(String address, int phone) {
        this.address = address;
        this.phone = phone;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public Collection<Handout> getHandoutList() {
        return handoutList;
    }

    public String getAddress() {
        return address;
    }

    public int getPhone() {
        return phone;
    }

    public Collection<Pharmacist> getEmployees() {
        return employees;
    }
}
