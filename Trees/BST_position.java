/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;
class Node{
    int data;
    Node left;
    Node right;
    int position ;
    Node(int d , int p){
        data = d;
        position = p;
        left = null;
        right = null;
    }
    int getData(){
        return data;
    }
   
    Node getLeft(){
        return left;
    }
    Node getRight(){
        return right;
    }
    void setLeft(Node n){
       left = n;
    }
    void setRight(Node n){
       right = n;
    }
    
}
/* Name of the class has to be "Main" only if the class is public. */
class BST_position
{
     public static Node root;
    BST_position(){
        root = null;
    }
    
    Node insert(int d, Node root , int p){
        if(root == null){
            root = new Node(d , p);
            System.out.println(p);
            return root;
        }
        else{
            if(root.data == d){
                return root;
            }
            else if(root.data> d){
                root.left  = insert(d,root.left , p*2);
            }
            else{
                root.right = insert(d,root.right , (p*2) + 1);
            }    
        }
        return root;
    }
    
    Node delete(Node root , int d){
        Node temp;
        boolean flag = false;
        if(root == null){
            return null;
        }
        else if(root.data < d){
            root.right = delete(root.right,d);
        }
        else if(root.data>d){
            root.left = delete(root.left,d);
        }
        else{
          if(root.left!=null && root.right!=null){
             
              temp  = FindMax(root.left);
              System.out.println("temp"+temp.data);
              root.data = temp.data;
              System.out.println(root.position);
              flag=true;
              root.left = delete(root.left , temp.data);
          } 
          else{
              if(flag==false){
                  System.out.println(root.position);
              }
              temp = root;
              if(root.left == null){
              root = root.right;
          }
              else if(root.right == null){
               root = root.left;
           }
          }
            
            
        }
        
        return root;
        
    }
    
    public Node FindMax(Node root){
        if(root == null){
            return null;
        }else if(root.right == null){
            return root;
        }
        else{
            root = FindMax(root.right);
            return root;
        }
        
        
    }
    
	public static void main (String[] args) throws java.lang.Exception
	{
	     
	    BST_position bs = new BST_position();
	    Scanner in =new Scanner(System.in);
	    int op = in.nextInt();
	    for(int i=0 ; i < op;i++){
	        String s = in.next();
	        int num = in.nextInt();
	        if(s.equals("i")){
	        root = bs.insert(num , root , 1);
                 
	        }else{
                    
	         root = bs.delete(root , num);
	        }
               
	    }
            
            
            
            
            
	
	}
}
