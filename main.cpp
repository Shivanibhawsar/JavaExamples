/******************************************************************************

                              Online C++ Compiler.
               Code, Compile, Run and Debug C++ program online.
Write your code in this editor and press "Run" button to compile and execute it.

*******************************************************************************/

#include <iostream>
#include <vector>
#include <algorithm>
#include <iomanip>
#include <cmath>
#include <typeinfo>
#include <bits/stdc++.h> 
#include<string.h>

using namespace std;


//return false if Item is book or food or any medical product
bool isItemwithnotax(string str) 
{ 
   bool flag = true;
   string word = ""; 
   std::vector<string> v = {"chocolate","chocolates","headache","pills","bar","book"};
   istringstream ss(str); 
  
    do{ 
        // Read a word 
        string word; 
        ss >> word ; 
        if(std::find(v.begin(),v.end(),word)!=v.end()){
           flag=false;
        }
     } while (ss); 
       
    return flag;
}

//return true if Item is imported
bool isImported(string str) 
{ 
   bool flag = false;
   string word = ""; 
   std::vector<string> v = {"imported","Imported"};
   istringstream ss(str); 
  
    do { 
        // Read a word 
        string word; 
        ss >> word; 
  
        
    if(std::find(v.begin(),v.end(),word)!=v.end()){
           
           flag=true;
           
           
       }
    } while (ss); 
    
    return flag;
}


//Return Last Element which is Price here
string lastelement(string str) 
{ 
   string word = ""; 
  
       for (auto x : str) 
   { 
       if (x == ' ') 
       { 
           word = ""; 
       } 
       else
       { 
           word = word + x; 
       } 
   }  
   return word;
}


//main function
int main()
{
    float g;
    float total=0;
    float tax = 0;
    string str;
    float roundtax;
    
    //read input from console
    while (getline(std::cin, str) ) {
        
    //break when line is empty
    if (str.empty())
        break;
        
    bool flag = isItemwithnotax(str); //check if Item is food/medical product/book
    bool isimported = isImported(str);//check if item is imported
    string last = lastelement(str);//get last element i.e. price of item
    
    //if(Item is not food/medical product/book and also it is imported i.e. 15% tax)
    if(flag!=0 && isimported==1){
    
    float val = std::stof(last); 
    float r = (val * 15.0)/100.0; // convert last element to float
    g = round(r*20)/20; // round to nearest 0.05
    istringstream ss(str); 
    tax = tax + g ; 
    g = val + g; 
    total = total + g;
    
    //print output
    do { 
        string word; 
        string at = "at";
        ss >> word; 
        
       if(word == at){
            cout << ":"<< " ";
       }
       if(word !=last && word !=at){
           cout << word << " ";
       }
       if(word == last){
            cout << g<< endl;
       }
    } while (ss); 
    }
    
    //if item is not belongs to food/medical product/book i.e. 10% tax 
    else if(flag != 0){
    float val = std::stof(last); 
    float r = (val * 10.0)/100.0;
    g = round(r*20)/20;
    istringstream ss(str); 
    tax = tax + g ;
    g = val + g;
    total = total + g;
    
    //print output
    do { 
        string word; 
        string at = "at";
        ss >> word; 
        
        if(word == at){
            cout << ":"<< " ";
        }
       if(word !=last && word !=at){
           cout << word << " ";
       }
       if(word == last){
            cout << g << endl;
       }
    } while (ss); 
    }
    
    //if item is imported only i.e. 5% tax 
    else if(isimported){
    float val = std::stof(last); 
    float r = (val * 5.0)/100.0;
    g = round(r*20)/20;
    istringstream ss(str); 
    tax = tax + g ;
    g = val + g;
    total = total + g;
    
    //print output
    do { 
        string word; 
        string at = "at";
        ss >> word; 
        
        if(word == at){
            cout << ":"<< " ";
        }
       if(word !=last && word !=at){
           cout << word << " ";
       }
       if(word == last){
            cout << g << endl;
       }
    } while (ss); 
    }
    
    //if Item belongs to food/medical product/book and not imported i.e. no tax 
    else{
        istringstream ss(str); 
         float val = std::stof(last); 
         total = total + val;
         
     do{ 
        string word; 
        string at = "at";
        ss >> word; 
        
        if(word == at){
            cout << ":"<< " ";
        }
       if(word !=last && word !=at){
           cout << word << " ";
       }
       if(word == last){
            cout << val << endl;
       }
    } while (ss); 
    }
    
    }
    
    cout << "Sales Tax:" << tax << endl;
    cout << "Total:" << total;
    return 0;
}
