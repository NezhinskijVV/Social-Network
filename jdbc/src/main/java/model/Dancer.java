package model;

import java.time.LocalDate;

/**
 * Created by Nezhinskij VV on 17.11.2016.
 */
public class Dancer {
    private final long id;
    private final String firstName;
    private final String lastName;
    private final LocalDate dob;
    private final String nickname;
    private final String email;
    private final String password;
    private final String telephone;
    private final String style;


    public Dancer(long id, String firstName, String lastName, LocalDate dob, String nickname,
                  String email, String password, String telephone, String style) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.telephone = telephone;
        this.style = style;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public String getNickname() {
        return nickname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getStyle() {
        return style;
    }
}
