package org.example.models;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;


public class Member {


    private int codeMember;

    private String lastName;

    private String firstName;

    private Date birthDay;

    private String sexe;

    public List<Reservation> reservations = new LinkedList<Reservation>();

    public int getCodeMember() {
        return codeMember;
    }

    public void setCodeMember(int codeMember) {
        this.codeMember = codeMember;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public boolean addReservation(Reservation reservationParam) {
        return this.reservations.add(reservationParam);
    }
}
