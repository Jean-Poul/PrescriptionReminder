package cph.databases.assignment.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Table(name = "person")
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id", nullable = false)
    private Integer person_id;
    @NotNull
    @Column(name = "cpr")
    private Integer cpr;
    @NotNull
    @Column(name = "gender")
    private String gender;
    @NotNull
    @Column(name = "firstname")
    private String firstName;
    @NotNull
    @Column(name = "lastname")
    private String lastName;
    @NotNull
    @Column(name = "address")
    private String address;
    @NotNull
    @Column(name = "phone")
    private Integer phone;
    @NotNull
    @Column(name = "email")
    private String email;
    @NotNull
    @OneToMany
    @JoinColumn(name = "role_id")
    private Role role;

    // Constructors
    public Person() {
    }

    public Person(Integer person_id, Integer cpr, String gender, String firstName, String lastName, String address, Integer phone, String email, Role role) {
        this.person_id = person_id;
        this.cpr = cpr;
        this.gender = gender;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.role = role;
    }

    // Getters and setters
    public Integer getPerson_id() {
        return person_id;
    }

    public void setPerson_id(Integer person_id) {
        this.person_id = person_id;
    }

    public Integer getCpr() {
        return cpr;
    }

    public void setCpr(Integer cpr) {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
