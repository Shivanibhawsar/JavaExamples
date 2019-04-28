/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.util.Scanner;

public class binary_trees_possible {
    static int count =0;
    
    static int countbst(int n){
        int T[]=new int[n+1];
        if(n==0){
            return 1;
        }
        T[0]=1;
        T[1]=1;
        
        
        for(int i=2;i<=n;i++){
            for(int j=1;j<=i;j++){
                
           T[i] += T[j-1]*T[i-j];
            
        }
        
        }
        
        
        
        
        return T[n];
    }
    
    
    
    
    public static void main(String args[]){
       Scanner in = new Scanner(System.in);
       int TC = in.nextInt();
       int output[]=new int[TC];
       for(int i=0;i<TC;i++){
           int nodes = in.nextInt();
           output[i]=countbst(nodes);
       }
       for(int k:output){
           System.out.println(k);
       }
        
        
    }
}
