package org.example.lesson;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

@Data
@AllArgsConstructor
public class AccountUser extends ArrayList implements Comparable<AccountUser> {
    private int id;
    private String name;
    private double balance;
    private LocalDate dataBirthday;



    @Override
    public int compareTo(AccountUser o) {
        return this.dataBirthday.getYear()-o.dataBirthday.getYear();
    }

}
