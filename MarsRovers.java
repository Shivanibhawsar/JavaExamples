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
public class MarsRovers {
    
    
    
   
    
    
    public static void main(String args[]){
        HashMap<String,String> hm=new HashMap();
        HashMap<String,String> hm_output=new HashMap();
        hm.put("NL","W");
        hm.put("NR","E");
        hm.put("SL","E");
        hm.put("SR","W");
        hm.put("WL","S");
        hm.put("WR","N");
        hm.put("EL","N");
        hm.put("ER","S");
        Scanner in=new Scanner(System.in);
        String get = in.nextLine();
        String get1[] = get.split(" ");
        Integer max_x=new Integer(get1[0]);
        Integer max_y=new Integer(get1[1]);
        
       String getInput="";
            Integer x=null;
            Integer y=null;     
        
        int action=0;
        String direction="";
        while(!((getInput = in.nextLine()).equals(""))){
            
            action=action+1;
            String input="";
            
           
            
            if(action%2==0){
                  input=getInput;
            }
            else{
                
            String s1[]=getInput.split(" ");
            //System.out.println(s1[0]+"s1"+s1[1]);
             x=new Integer(s1[0]);
             y=new Integer(s1[1]);
             direction=s1[2];
            }
           
        boolean flag=false;
        for(int i=0;i<input.length();i++){
            Character ch=input.charAt(i);
            if(ch!='M'){
            String s=direction+ch;
            
            String c=hm.get(s);
            direction = c ;
            }else{
                if(direction.equals("W")){
                    //x = x.intValue();
                    x=x-1;
                    
                }
                else if(direction.equals("E")){
                    x=x+1;
                }
                else if(direction.equals("N")){
                    y=y+1;
                     
                }
                else if(direction.equals("S")){
                    y=y-1;
                }
                if(x<0 || x>max_x || y<0 || y>max_y){
                    flag=true;
                  break;  
                }
            }
                
        }
        if(flag==true){
            hm_output.put("Rover went beyond plateau region", "1");
           //System.out.println("Rover went beyond plateau region");
        }else if((action%2==0) && flag ==false){
            Integer X=new Integer(x);
            Integer Y=new Integer(y);
            
            String insert = X.toString() + Y.toString();
            hm_output.put(insert, direction);
                
        }}       
                
           for(Map.Entry<String,String> h: hm_output.entrySet()){
               String s = h.getKey();
               if((h.getKey()).length()>2){
                   System.out.println(h.getKey());      
               }
               else{
                System.out.println(s.charAt(0) + " " + s.charAt(1) + " " + h.getValue());
               }
               
           }     
                
             
                
                
            }
            
        }
        
        
        
        
        
     
