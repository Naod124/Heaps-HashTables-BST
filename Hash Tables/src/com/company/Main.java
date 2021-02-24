package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Time time = new Time();


        Scanner scan = new Scanner(System.in);
        System.out.println("1. Chaining HashTable");
        System.out.println("2. Linear Probing");
        System.out.println("3. Quadratic Probing HashTable");
        System.out.println("4. Rehash");
        int choice = scan.nextInt();
        chainedHashTable chainedHashTable = new chainedHashTable(11);


       if (choice == 1) {
           time.startTimer();
           chainedHashTable.insert(4371, 4371);
           chainedHashTable.insert(1323, 1323);
           chainedHashTable.insert(6173, 6173);
           chainedHashTable.insert(4199, 4199);
           chainedHashTable.insert(4344, 4344);
           chainedHashTable.insert(9679, 9679);
           chainedHashTable.insert(1989, 1989);
           time.stopTimer();
           long elapsedTime = time.getTime();
           chainedHashTable.printHashTable();
           System.out.println();
           System.out.println("Total time for inserting with separate chained hashtable is : " + time.toString(elapsedTime));

       }

       if (choice==2){
           HashEntry hashEntry = new HashEntry(4371, 4371);
           HashEntry hashEntry1 = new HashEntry(1323, 1323);
           HashEntry hashEntry2 = new HashEntry(6173, 6173);
           HashEntry hashEntry3 = new HashEntry(4199, 4199);
           HashEntry hashEntry4 = new HashEntry(4344, 4344);
           HashEntry hashEntry5 = new HashEntry(9679, 9679);
           HashEntry hashEntry6 = new HashEntry(1989, 1989);

           linearProbing linearProbing = new linearProbing(11);
           time.startTimer();
           linearProbing.insert(hashEntry);
           linearProbing.insert(hashEntry1);
           linearProbing.insert(hashEntry2);
           linearProbing.insert(hashEntry3);
           linearProbing.insert(hashEntry4);
           linearProbing.insert(hashEntry5);
           linearProbing.insert(hashEntry6);
           time.stopTimer();
           long elapsedTime = time.getTime();
           linearProbing.printHashTable();
           System.out.println();
           System.out.println("Total time for inserting with linear probing is : " + time.toString(elapsedTime));


       }

       if (choice==3){
           quadraticProbing quadraticProbing = new quadraticProbing(11);
           time.startTimer();
           quadraticProbing.insert(4371, 4371);
           quadraticProbing.insert(1323, 1323);
           quadraticProbing.insert(6173, 6173);
           quadraticProbing.insert(4199, 4199);
           quadraticProbing.insert(4344, 4344);
           quadraticProbing.insert(9679, 9679);
           quadraticProbing.insert(1989, 1989);
           time.stopTimer();
           long elapsedTime = time.getTime();
           quadraticProbing.printHashTable();
           System.out.println();
           System.out.println("Total time for inserting with quadratic probing is : " + time.toString(elapsedTime));
       }

       if (choice==4){
           ReHash reHash1 = new ReHash(15);
           reHash1.insert(4371, 4371);
           reHash1.insert(1323, 1323);
           reHash1.insert(6173, 6173);
           reHash1.insert(4199, 4199);
           reHash1.insert(4344, 4344);
           reHash1.insert(9679, 9679);
           reHash1.insert(1989, 1989);
           reHash1.printHashTable();
       }


    }
}