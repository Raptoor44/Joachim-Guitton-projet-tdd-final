package org.example.models;

import org.example.exceptions.FinishReservationException;
import org.example.exceptions.NotFoundReservationException;
import org.example.exceptions.Over3ReservationsInMemberException;

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

    public boolean addReservation(Reservation reservationParam) throws Over3ReservationsInMemberException, NotFoundReservationException {
        if (reservations.size() < 3) {
            return this.reservations.add(reservationParam);
        } else {
            throw new Over3ReservationsInMemberException();
        }
    }

    public void finishReservation(Reservation reservation) {
        int index = this.reservations.indexOf(reservation);
        this.reservations.get(index).setReservationIsValid(false);
    }

    public Reservation getReservation(Reservation reservation) throws FinishReservationException {
        int index = this.reservations.indexOf(reservation);

        if (index == -1) {
            throw new NotFoundReservationException();
        }

        Reservation reservationGet = this.reservations.get(index);

        if(!reservationGet.isReservationIsValid()){
            throw new FinishReservationException();
        }

        return reservationGet;
    }


    public List<Reservation> getValidReservations() {

        List<Reservation> reservationsToReturn = new LinkedList<Reservation>();

        for (Reservation reservation : reservations) {
            if (reservation.isReservationIsValid()) {
                reservationsToReturn.add(reservation);
            }
        }
        return reservationsToReturn;
    }

    public List<Reservation> getHistoryOfReservations() {
        return this.reservations;
    }
}
