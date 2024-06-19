package ch.bbw.jr.mitglied;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "member")
public class Mitglied implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private int memberId;

    @Column(name = "first_name")
    @Pattern(regexp = "^[^\\d]+$", message = "First name should not contain numbers")
    private String firstName;

    @Column(name = "last_name")
    @Pattern(regexp = "^[^\\d]+$", message = "Last name should not contain numbers")
    private String lastName;

    @Column(name = "address")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]+$", message = "Address should contain at least one letter and one number")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "title")
    private String title;

    @Column(name = "phone")
    @Pattern(regexp = "^(\\+41|0041)\\d{9}$", message = "Phone number should start with +41 or 0041 and contain 9 digits")
    private String phone;

    @Column(name = "entry_date")
    private LocalDate entryDate;


    // Getter und Setter

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }
}
