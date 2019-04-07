/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author ShivaniBhawsar
 */
public class TopStrings {
    public static ArrayList<String> getPopularity(ArrayList<String> a, int top){
      HashMap<String,Integer> hm=new HashMap<String,Integer>();
      ArrayList<String> fin = new ArrayList<String>();
      for(int i=0;i<a.size();i++){
          String ITEM = a.get(i);
        if(hm.containsKey(ITEM)){
                   hm.put(ITEM, hm.get(ITEM)+1);
               }else{
                  hm.put(ITEM,1);  
               }
      }
    List<Map.Entry<String, Integer> > list = 
               new LinkedList<Map.Entry<String, Integer> >(hm.entrySet()); 
  
        // Sort the list 
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() { 
            public int compare(Map.Entry<String, Integer> o1,  
                               Map.Entry<String, Integer> o2) 
            { 
                if(o2.getValue().compareTo(o1.getValue())==0){
                return (o1.getKey()).compareTo(o2.getKey()); 
            }else{
                return (o2.getValue()).compareTo(o1.getValue()); 
            } }
        }); 
          
        // put data from sorted list to hashmap  
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>(); 
        int k=0;
        for (Map.Entry<String, Integer> aa : list) { 
            temp.put(aa.getKey(), aa.getValue()); 
                    } 
        for(Map.Entry<String,Integer> m:temp.entrySet()){
            fin.add(m.getKey());
            //System.out.print(m.getKey()+ " ");
            k++;
            if(k == top){
                break;
            }

        }
    
    
    
    
    
    
    
    return fin;
    }
    
    
    
    
    
    
    public static void main(String args[]){
       Scanner in =new Scanner(System.in);
       int tc= in.nextInt();
       int c=in.nextInt();
       ArrayList<String> items=new ArrayList<String>();
       ArrayList<String> finalList=new ArrayList<String>();
      
       HashMap<String,Integer> hm=new HashMap<String,Integer>();
       for(int i=0;i<tc;i++){
           for(int j=0;j<c;j++){
              String s= in.next();
              if(s.equals("top")){
                  ArrayList<String> popular=new ArrayList<String>();
                  int topnum = in.nextInt();
                  popular = getPopularity(items,topnum);
                 
                   for(int l=0;l<popular.size();l++){
                       System.out.print(popular.get(l) + " ");
                   }
                   System.out.println();
              }else{
                  items.add(s);
              }
              
           }
           items.clear();
           c = in.nextInt();
       }
       
       
       
     
       
      
     
        
    }
}
