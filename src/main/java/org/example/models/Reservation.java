package org.example.models;

import java.util.Calendar;
import java.util.Date;

public class Reservation {

    private int id;

    private Date dateLimit;

    private Date dateCreation;

    private boolean reservationIsValid = true;

    private Book book;

    public Reservation() {

        this.dateCreation = new Date();

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 4);

        this.dateLimit = calendar.getTime();
    }

    public Date getDateLimit() {
        return dateLimit;
    }

    public void setDateLimit(Date dateLimit) {
        this.dateLimit = dateLimit;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public boolean isReservationIsValid() {
        return reservationIsValid;
    }

    public void setReservationIsValid(boolean reservationIsValid) {
        this.reservationIsValid = reservationIsValid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isValid(Date dateToday){
       if(dateToday.compareTo(this.dateLimit) <= 0){
           return true;
       }else{
           this.reservationIsValid = false;
           return false;
       }
    }

    public boolean addBook(Book bookToTest) {
        this.book = bookToTest;
        return true;
    }
}
