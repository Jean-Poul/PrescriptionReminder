package cph.databases.assignment.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
//@Table(name = "contactinformation")
public class ContactInformation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "person_id", referencedColumnName = "cpr")
    private Person pcpr;

    private String mail;

    private int phone;

    @ManyToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address addr;

    // Constructors
    public ContactInformation() {
    }

    public ContactInformation(Person pcpr, String mail, int phone, Address addr) {
        this.pcpr = pcpr;
        this.mail = mail;
        this.phone = phone;
        this.addr = addr;
    }

    public void setAddress(Address addr){
        this.addr = addr;
        if(!addr.getCi().contains(this)) {
            addr.addContact(this);
        }
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person getPcpr() {
        return pcpr;
    }

    public void setPcpr(Person pcpr) {
        this.pcpr = pcpr;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public Address getAddr() {
        return addr;
    }

    public void setAddr(Address addr) {
        this.addr = addr;
    }
}
