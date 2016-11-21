package model;

import java.time.LocalDate;

/**
 *
 * Created by Nezhinskij VV on 17.11.2016.
 */
public class Person {
    private final long id;
    private final String firstName;
    private final String lastName;
    private final String style;
    private final LocalDate dob;
    private final String email;
    private final String password;
    private final String address;
    private final String telephone;


    public Person(long id, String firstName, String lastName, String style, LocalDate dob, String email, String password, String address, String telephone) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.style = style;
        this.dob = dob;
        this.email = email;
        this.password = password;
        this.address = address;
        this.telephone = telephone;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String style() {
        return style;
    }

    public LocalDate getDob() {
        return dob;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public String getTelephone() {
        return telephone;
    }


}
