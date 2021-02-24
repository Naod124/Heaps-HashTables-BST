package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileRead {
    String path = "RandomNumbers.txt";

    public int[] fileReader(int size) throws FileNotFoundException {


        File file = new File(path);
        Scanner input = new Scanner(file);

        int[] array;
        array = new int[size];
        int i = 0;
        if (!input.hasNextInt() || i >= size) {
            return array;
        }
        do {
            array[i++] = input.nextInt();

        } while (input.hasNextInt() && i < size);
        return array;
    }

    public List<Integer> readToList() throws FileNotFoundException {
        File file = new File(path);
        Scanner input = new Scanner(file);
        List<Integer> fileData =new ArrayList<>();
        int i=0;
        while (i<(1000000)){
            fileData.add(input.nextInt());
            i++;
        }
        input.close();
        return fileData;
    }

    public void write(String fileName, int size, String time, String sortingMethod, int initial ) throws IOException {

        FileWriter write = new FileWriter(fileName, true);
        FileWriter write1 = new FileWriter(fileName,true);
        PrintWriter print = new PrintWriter(write);
        PrintWriter print1 = new PrintWriter(write1);

        if (size==initial) {
            print1.printf("                   " + sortingMethod + "               %n\n");
            print1.print("  INPUT      Time \n");
            print1.close();
        }
        print.printf("%7d      %s%n", size, time );
        if (size == 1000000 ){
            print.print("\n*****************************************************************\n");
        }
        print.close();

    }
}
