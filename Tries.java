/*
  In this Program i have implemented the insert and search function
  of tries.
*/
import java.util.*;
import java.io.*;
class GFG
 {
    static class Tries
    {
        boolean isEndOfWord;
        Tries child[];
        Tries()
        {
            isEndOfWord=false;
            child=new Tries[26];
        }
    }
    
    static void insertWord(Tries start,String word)
    {
        Tries X=start;
        for(int i=0;i<word.length();i++)
        {
            int index=word.charAt(i)-'a';
            if(X.child[index]==null)
            {
                X.child[index]=new Tries();
            }
            X=X.child[index];
        }
        X.isEndOfWord=true;
    }
    
    static boolean searchWord(Tries start,String word)
    {
        Tries X=start;
        for(int i=0;i<word.length();i++)
        {
            int index=word.charAt(i)-'a'; 
            if(X.child[index]==null)
            {
                return false;
            }
            X=X.child[index];
        }
        if(X!=null && X.isEndOfWord==true)
        {
            return true;
        }
        return false;
    }

	public static void main (String[] args)
	 {
	   Scanner in=new Scanner(System.in);
	     int n=in.nextInt(); //number of string that we want to insert in our trie.
	     Tries start=new Tries();
	     for(int i=0;i<n;i++)
	     {
	         String str=in.next();
	         insertWord(start,str);
	     }
       
	     String Word=in.next(); //enter the string you want search in trie.
	     if(searchWord(start,Word)==true)
	     {
	         System.out.println(1);
	     }
	     else
	     {
	         System.out.println(0);
	     }
    }
}
