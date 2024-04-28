package org.example.models;

import java.util.Calendar;
import java.util.Date;

public class Reservation {

    private Date dateLimit;

    private Date dateCreation;

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

    public boolean isValid(Date dateToday){
       if(dateToday.compareTo(this.dateLimit) <= 0){
           return true;
       }else{
           return false;
       }
    }
}
