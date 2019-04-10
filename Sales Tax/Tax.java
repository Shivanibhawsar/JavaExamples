/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.util.Scanner;

/**
 *
 * @author ShivaniBhawsar
 */

enum category{
    Chocolate,
    Chocolates,
    chocolates,
    bar,
    book,
    headache,
    pills
    
    
    
}
public class Tax {
    public static double salestax=0;
    public static double total = 0;
    public static boolean partOfCategory(String s){
       String s1[] = s.split(" ");
       for(int i=0;i<s1.length;i++){
        for (category c : category.values()) {
        if (c.name().equals(s1[i])) {
            return true;
            
            
        }}
    }
    return false;
    }
    public static boolean isImported(String s){
       String s1[] = s.split(" ");
       for(int i=0;i<s1.length;i++){
           if(s1[i].equals("imported") || s1[i].equals("Imported")){
              return true; 
           }
       }
    return false;
    }
    
    public static double taxCalculation(double tax, double price){
       double  t = (price*tax)/100.0;
             t  = Math.ceil(t * 20.0) / 20.0;
            double final_amount = price + t;
            salestax += t;
            total += final_amount;
     
    return final_amount;
    }
    
    
    
    
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        String s="";
        double final_amount = 0;
        while(!((s = in.nextLine()).equals(""))){
            
                    
            String s1[] = s.split(" ");
            Float price = new Float(s1[s1.length-1]);
            if(!partOfCategory(s) && isImported(s)){
                final_amount = taxCalculation(15.0, price);
             }
            else if(partOfCategory(s) && isImported(s)){
                final_amount = taxCalculation(5.0, price);
                
            }
            else if(!partOfCategory(s) && !isImported(s)){
                final_amount = taxCalculation(10.0, price);
            }
            else{
                final_amount = taxCalculation(0, price);
            }
            for(int i=0;i<s1.length;i++){
                if(s1[i].equals("at")){
                    System.out.print(": ");
                }
                else if(i==s1.length-1){
                    final_amount = Math.round(final_amount * 100.0) / 100.0;
                   System.out.println(final_amount); 
                }
                else{
                   System.out.print(s1[i] +" "); 
                }
            }
         }
        salestax = Math.round(salestax * 100.0) / 100.0;
        total = Math.round(total * 100.0) / 100.0;
        System.out.println("Sales Taxes:"+salestax);
        System.out.println("Total:"+total);
        
        
        
        
        
    }
}
