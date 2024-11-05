package org.example.lesson;

import java.time.LocalDate;
import java.util.*;
import java.util.Comparator;

public class LessonCollection {
    public static void main(String[] args) {


        AccountUser accountUser1 =
                new AccountUser(1, "Ali", 1000.20, LocalDate.of(1991, 2, 1));

        AccountUser accountUser2 =
                new AccountUser(2, "Ali2", 3000.20, LocalDate.of(2020, 4, 1));


        AccountUser accountUser3 =
                new AccountUser(3, "Ali3", 2500.20, LocalDate.of(1985, 8, 6));


        AccountUser accountUser4 =
                new AccountUser(4, "Ali4", 1500.20, LocalDate.of(1997, 4, 1));


        AccountUser accountUser5 =
                new AccountUser(5, "Ali5", 4000.20, LocalDate.of(2004, 2, 1));

        AccountUser accountUser6 =
                new AccountUser(7, "Ali6", 3000.20, LocalDate.of(2009, 2, 1));

        AccountUser accountUser7 =
                new AccountUser(5, "Ali5", 1000.20, LocalDate.of(2004, 2, 1));

        AccountUser accountUser8 =
                new AccountUser(9, "Ali5", 2000.20, LocalDate.of(2010, 2, 1));


        List<AccountUser> accountUsers = new ArrayList<>();
        accountUsers.add(accountUser1);
        accountUsers.add(accountUser2);
        accountUsers.add(accountUser3);
        accountUsers.add(accountUser4);
        accountUsers.add(accountUser5);
        accountUsers.add(accountUser6);
        accountUsers.add(accountUser7);
        accountUsers.add(accountUser8);


        System.out.println("Баланс всех пользователей " + allBalanceUsers(accountUsers));
        System.out.println();
        System.out.println("Самые взрослые:");
        printAccountUsers(outBestOldUser(accountUsers));
        System.out.println();
        System.out.println("Самые молодые:");
        printAccountUsers(outBestYoungUsers(accountUsers));


//        for (AccountUser accountUser : accountUsers) {
//            //if(accountUser.getDataBirthday().getMonthValue() ==4){
//            System.out.println(accountUser);
//            // }
//        }
//        System.out.println();
//        Set<AccountUser> accountUserSet = new HashSet<>();
//        accountUserSet.addAll(accountUsers);
//
//        for (AccountUser accountUser : accountUserSet) {
//            System.out.println(accountUser);
//        }
//
//
//        for(AccountUser accountUser : accountUsers){
//            System.out.println(accountUser);
//        }
//
//
//
//        System.out.println("work");
//        Map<Integer, List<AccountUser>> map = new HashMap<>();
//        for (AccountUser accountUser : new HashSet<>(accountUsers)) {
//            int month = accountUser.getDataBirthday().getMonthValue();
//            if (!map.containsKey(month)) {
//                map.put(month, new ArrayList<>());
//            }
//
//            List<AccountUser> accountUsers1 = map.get(month);
//            accountUsers1.add(accountUser);
//
//        }
//
//
//        for (Map.Entry<Integer, List<AccountUser>> entry : map.entrySet()) {
//            System.out.println(" month :" + entry.getKey());
//            List<AccountUser> accountUsers1 = entry.getValue();
//            for (AccountUser accountUser9 : accountUsers1) {
//                System.out.println(accountUser9);
//            }
//            System.out.println();
//        }
//
//
//        //в методах
//
//
//
//
//
//
//
    }
    //вывод общего баланса всех юзеров
    public static int allBalanceUsers(List<AccountUser> a) {
        int sumBalance = 0;
        for (AccountUser accountUser : a) {
            sumBalance += accountUser.getBalance();
        }
        return sumBalance;
    }

    //вывод самого молодого юзера и вывод самого старшего юзера
    public static Map<Integer, List<AccountUser>> outBestOldUser(List<AccountUser> users) { //Выводи вроде корректный результат
        Map<Integer, List<AccountUser>> map = new HashMap<Integer, List<AccountUser>>();
        int yearsOld = Integer.MAX_VALUE;

        for (AccountUser accountUser : new TreeSet<>(users)) {
            int years = accountUser.getDataBirthday().getYear();

            if (years < yearsOld) {

                yearsOld = years;

                map.put(yearsOld, new ArrayList<>());
                List<AccountUser> list = map.get(yearsOld);
                list.add(accountUser);

            }



        }


        return map;
    }
    //вывод самого молодого юзера и вывод самого старшего юзера
    public static Map<Integer, List<AccountUser>> outBestYoungUsers(List<AccountUser> users) {
        Map<Integer, List<AccountUser>> map = new HashMap<>();
        TreeSet <AccountUser>  accountUsers2 = new TreeSet<>(users);
        List<AccountUser> accountUsers3= new ArrayList<>(accountUsers2);
        Collections.reverse(accountUsers3);

        int youngestYear = Integer.MIN_VALUE;
        for (AccountUser accountUser : accountUsers3) {
            int years = accountUser.getDataBirthday().getYear();


            if (years > youngestYear) {
                youngestYear = years;
                map.put(youngestYear, new ArrayList<>());
                List<AccountUser> list = map.get(youngestYear);
                list.add(accountUser);


            }



        }


        return map;
    }
    //вывод сгрупировар по дням рождения и по годам
    public static void printAccountUsers(Map<Integer, List<AccountUser>> map) {
        for (Map.Entry<Integer, List<AccountUser>> entry : map.entrySet()) {
            System.out.println("Ключи года: " + entry.getKey());
            System.out.println();
            List<AccountUser> accountUsers1 = entry.getValue();
            for (AccountUser accountUser : accountUsers1) {
                System.out.println("Год рождения: "+accountUser.getDataBirthday().getYear()+" День рождения: "+ accountUser.getDataBirthday().getDayOfMonth());
                System.out.println();
            }
        }

    }

}

