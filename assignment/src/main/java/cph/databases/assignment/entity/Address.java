package cph.databases.assignment.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
//@Table(name = "address")
public class Address implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String street;

    private int zipcode;

    @OneToMany(mappedBy = "addr", cascade = CascadeType.ALL)
    private List<ContactInformation> contactList = new ArrayList();

    // Constructors
    public Address() {
    }

    public Address(String street, int zipcode) {
        this.street = street;
        this.zipcode = zipcode;
    }

    public void addContact(ContactInformation ci) {
        this.contactList.add(ci);
        if(ci.getAddr() == null){
            ci.setAddr(this);
        }
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public List<ContactInformation> getCi() {
        return contactList;
    }

    public void setCi(List<ContactInformation> contactList) {
        this.contactList = contactList;
    }
}
