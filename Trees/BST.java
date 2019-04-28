/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author ShivaniBhawsar
 */
class Node{
    int data;
    Node left;
    Node right;
    Node(int d){
        data = d;
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


public class BST {
    public static Node root;
    BST(){
        root = null;
    }
    Node insert(int d, Node root){
        if(root == null){
            root = new Node(d);
            return root;
        }
        else{
            if(root.data == d){
                return root;
            }
            else if(root.data> d){
                root.left  = insert(d,root.left);
            }
            else{
                root.right = insert(d,root.right);
            }    
        }
        return root;
    }
    
    void inorder(Node root){
        if(root == null){
            return;
        }else{
            inorder(root.left);
            System.out.println(root.data);
            inorder(root.right);
        }     
    }
    
    
    Node delete(Node root , int d){
        Node temp;
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
              root.left = delete(root.left , temp.data);
          } 
          else{
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
    
    
    public Node LCA_binarytree(Node root, int a, int b){
        Node left,right;
        if(root == null){
            return null;
        }
        if(root.data == a || root.data == b){
            return root;
        }
        else{
            left = LCA_binarytree(root.left,a,b);
            right = LCA_binarytree(root.right ,a,b);
            if(left!=null && right!=null){
                return root;
            }else if(left!=null){
                return left;
            }else{
                return right;
            }
        }
        
        
    }
    
    int Catalan(int nodes){
        
        if(nodes == 0 || nodes == 1){
            return 1;
        }else{
            int count = 0;
            for(int i=1;i<=nodes;i++){
            count += Catalan(i-1)*Catalan(nodes-i);
            }  
            
            return count;
        }
    }
    Boolean search(Node root,int data){
        if(root==null){
            return null;
        }
        if(root.data==data){
            return true;
        }
        else{
            if(root.data<data){
                return search(root.right,data);
            }
            else{
                return search(root.left,data);
            }
            
            
            
        }
        
        
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
    
    void levelorder(Node root){
        Queue<Node> q = new LinkedList<Node>();
        q.offer(root);
        while(!q.isEmpty()){
            Node temp =  q.remove();
            System.out.print(temp.data+" ");
            if(temp.left!=null){
            
                q.offer(temp.left);
            }if(temp.right!=null){
                q.offer(temp.right);
            }
        }
     }
    
    
    
    
    public static void main(String args[]){
        BST bs = new BST();
        Node root_LCA;
      root = bs.insert(12, root);
      root = bs.insert(5, root);
       root = bs.insert(15, root);
      
     
      root = bs.insert(3, root);
      root = bs.insert(7, root);
      root = bs.insert(13, root);
      root = bs.insert(17, root);
     
      root = bs.insert(1, root);
      root = bs.insert(9, root);
      bs.inorder(root);
      System.out.println("levelorder");
      System.out.println("search:"+bs.search(root,5));
      bs.levelorder(root);
        System.out.println(root.data);
        System.out.println("Catalan:"+bs.Catalan(3));
        root_LCA = bs.LCA_binarytree(root, 3,7);
        System.out.println("LCA:"+root_LCA.data);
        //System.out.println((bs.FindMax(root)).data);
        root = bs.delete(root , 15);
        System.out.println(root.right.data);
    }
}
