/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hiring;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Hiring {

    private static final String COMMA_DELIMITER = ",";
    private static final int STAYDATE_IDX = 0;
    private static final int ROOMTYPE_IDX = 1;
    private static final int AVAILABILITY_IDX = 2;
    private static final int SELL_AMOUNT_IDX = 3; 
    private static final int TAX_IDX = 4;
        
    static class Compact{
       private String StartDate;
       private String EndDate;
        private String roomType;
        private int rooms;
        private int amount;
         static FileWriter fileWriter = null;
         private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String FILE_HEADER = "StartDate, Enddate, Roomtype, Available Rooms, Amount, Tax";
        private int tax;
        public Compact(String startdate,String enddate,String roomType, int rooms, int amount,int tax) {
            this.StartDate=startdate;
            this.EndDate=enddate;
            this.roomType = roomType;
            this.rooms = rooms;
            this.amount = amount;
            this.tax=tax;
        }
        public static void writecsv(ArrayList<Compact> a){
             try {
            fileWriter = new FileWriter("C:\\Users\\ShivaniBhawsar\\Documents\\work\\Hiring\\Compact.csv");
 
            //Write the CSV file header
            fileWriter.append(FILE_HEADER.toString());
             
            //Add a new line separator after the header
            fileWriter.append(NEW_LINE_SEPARATOR);
             
            //Write a new student object list to the CSV file
            for (Compact detail : a) {
                fileWriter.append(String.valueOf(detail.StartDate));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(detail.EndDate);
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(detail.roomType);
                fileWriter.append(COMMA_DELIMITER);
                Integer room=new Integer(detail.rooms);
                fileWriter.append(room.toString());
                fileWriter.append(COMMA_DELIMITER);
                Integer amount=new Integer(detail.amount);
                fileWriter.append(amount.toString());
                fileWriter.append(COMMA_DELIMITER);
                Integer tax=new Integer(detail.tax);
                fileWriter.append(tax.toString());
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
 
             
             
            System.out.println("CSV file was created successfully !!!");
             
        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {
             
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
             
        }
        }
       }
    
    
    static class RateCalendarItem {

        private String date;
        private String roomType;
        private int rooms;
        private int amount;
        
        private int tax;
        
        

        public RateCalendarItem(String date,String roomType, int rooms, int amount,int tax) {
            this.date=date;
            this.roomType = roomType;
            this.rooms = rooms;
            this.amount = amount;
            this.tax=tax;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            RateCalendarItem simpson = (RateCalendarItem) o;
            return tax == simpson.tax &&
                    rooms == simpson.rooms &&
                    amount == simpson.amount &&
                    roomType.equals(simpson.roomType);
        }
    }
    
    
    public static void main(String... equalsExplanation) {
        BufferedReader fileReader = null;
        RateCalendarItem customer=null;
        String startdate=null;
        
         try {
             
            //Create a new list of customers to be filled by CSV file data 
            ArrayList<Compact> customers = new ArrayList<Compact>();
             
            String line = "";
            
            //Create the file reader
            fileReader = new BufferedReader(new FileReader("C:\\Users\\ShivaniBhawsar\\Documents\\work\\Hiring\\Hiring_1.csv"));
             
            //Read the CSV file header to skip it
            fileReader.readLine();
            
            if((line = fileReader.readLine()) != null){
            String[] tokens = line.split(COMMA_DELIMITER);
            customer = new RateCalendarItem(tokens[STAYDATE_IDX], tokens[ROOMTYPE_IDX], Integer.parseInt(tokens[AVAILABILITY_IDX]), Integer.parseInt(tokens[SELL_AMOUNT_IDX]), Integer.parseInt(tokens[TAX_IDX]));
              startdate = customer.date;         
            }
             
            //Read the file line by line 
            while ((line = fileReader.readLine()) != null) {
                //Get all tokens available in line
                String[] tokens = line.split(COMMA_DELIMITER);
                   
                if (tokens.length > 0) {
                    //Create a new student object and fill his  data
                   RateCalendarItem customer1 = new RateCalendarItem(tokens[STAYDATE_IDX], tokens[ROOMTYPE_IDX], Integer.parseInt(tokens[AVAILABILITY_IDX]), Integer.parseInt(tokens[SELL_AMOUNT_IDX]), Integer.parseInt(tokens[TAX_IDX]));
                 
                    if(!customer.equals(customer1)) {
                        
                        customers.add(new Compact(startdate,customer.date,customer.roomType,customer.rooms,customer.amount,customer.tax));
                        startdate= customer1.date;
                    }
                   
                }
               customer = new RateCalendarItem(tokens[STAYDATE_IDX], tokens[ROOMTYPE_IDX], Integer.parseInt(tokens[AVAILABILITY_IDX]), Integer.parseInt(tokens[SELL_AMOUNT_IDX]), Integer.parseInt(tokens[TAX_IDX]));
           
                
            }
           if(customer.equals(customers.get(customers.size()-2))){
                customers.get(customers.size()-1).EndDate=customer.date;
               
            }
           else{
                
               customers.add(new Compact(customer.date,customer.date,customer.roomType,customer.rooms,customer.amount,customer.tax));
           }
           
            // Saving data in Compact file
            Compact.writecsv(customers);
          
        } 
        catch (Exception e) {
            System.out.println("Error in CsvFileReader");
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                System.out.println("Error while closing fileReader");
                e.printStackTrace();
            }
        }
  }

}
