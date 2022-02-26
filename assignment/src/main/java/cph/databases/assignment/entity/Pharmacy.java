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
    private String addresse;
    @NotNull
    private int phone;

    // Constructors
    public Pharmacy() {
    }

    public Pharmacy(String addresse, int phone) {
        this.addresse = addresse;
        this.phone = phone;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Collection<Handout> getHandoutList() {
        return handoutList;
    }

    public void setHandoutList(Collection<Handout> handoutList) {
        this.handoutList = handoutList;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
}
