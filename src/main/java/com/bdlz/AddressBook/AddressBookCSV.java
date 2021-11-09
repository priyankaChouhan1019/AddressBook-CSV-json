package com.bdlz.AddressBook;
import com.opencsv.CSVReader;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;


public class AddressBookCSV {
    private static final String CSV_FILE_PATH = "Contacts.CSV";

    /*
    Declaring Main Method Here
    Printing The Contacts Details
     */
    public static void main(String[] args) throws IOException {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH));
            CSVReader csvReader = new CSVReader(reader);
            String[] nextRecord;
            System.out.println("Contact Details Are");
            while (((nextRecord = csvReader.readNext())) != null) {
                System.out.println("firstName : " + nextRecord[0]);
                System.out.println("lastName : " + nextRecord[1]);
                System.out.println("address : " + nextRecord[2]);
                System.out.println("city : " + nextRecord[3]);
                System.out.println("state : " + nextRecord[4]);
                System.out.println("zip : " + nextRecord[5]);
                System.out.println("phoneNumber : " + nextRecord[6]);
                System.out.println("email : " + nextRecord[7]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
