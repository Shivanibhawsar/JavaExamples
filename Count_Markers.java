/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author ShivaniBhawsar
 */
public class Count_Markers {
     public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int tc = in.nextInt();
        
        for(int i =0;i<tc;i++){
            HashMap<Integer,Integer> hm =new HashMap();
            int V = in.nextInt();
            for(int j =0;j<V;j++){
               int S = in.nextInt();
               int E = in.nextInt();
                
                for(int g = S;g<= E; g++){
                    if(hm.containsKey(g)){
                        hm.put(g, hm.get(g)+1);
                    }else{
                    hm.put(g, 1);
                    }
                     
                }
                  
            }
            
            System.out.println(hm.size());
            
            
            
        }
          
        
}}