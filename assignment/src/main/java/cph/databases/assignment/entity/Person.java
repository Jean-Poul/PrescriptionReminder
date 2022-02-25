package cph.databases.assignment.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cpr;
    @NotNull
    private String gender;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_id", referencedColumnName = "id")
    private ContactInformation ci;

    // Constructors
    public Person() {
    }

    public Person(int cpr, String gender, String firstName, String lastName, ContactInformation ci) {
        this.cpr = cpr;
        this.gender = gender;
        this.firstName = firstName;
        this.lastName = lastName;
        this.ci = ci;
    }

    // Getters and Setters
    public int getCpr() {
        return cpr;
    }

    public void setCpr(int cpr) {
        this.cpr = cpr;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ContactInformation getCi() {
        return ci;
    }

    public void setCi(ContactInformation ci) {
        this.ci = ci;
    }
}
