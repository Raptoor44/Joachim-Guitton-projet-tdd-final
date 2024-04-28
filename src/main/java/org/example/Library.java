package org.example;

import org.example.models.Member;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Library {

    private List<Member> members = new LinkedList<Member>();

    public void addMember(Member member) {
        members.add(member);
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public void sendMailDateNotValid(Date dateTimeToday) {
        for (Member member : members) {
            member.sendMailReminderOfReservationsWithDateIsNotValid(dateTimeToday);
        }
    }
}
