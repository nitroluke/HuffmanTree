/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package huffmantree;

import static huffmantree.HuffmanTree.encoding;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 * @author nitroluke
 */
public class Driver {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        
        // TODO code application logic here
        PrintWriter writer = new PrintWriter("encodedBits.txt","UTF-8");
        int frequency[] = new int[256]; // just in case of unicode
        Scanner in = new Scanner(new FileReader("C://Users/nitroluke/Documents/NetBeansProjects/HuffmanTree/textFile.txt"));
        while(in.hasNext()){
            String string = in.next();
            //System.out.println(string);
            for(int i = 0;  i < string.length(); i++){
                // string.charAt(i) is the character in the current string
                //(int)string.charAt(i) is the ASCII Value
                // alphaberArr[string.charAt(i)] is the frequency of that char.
              //  System.out.println("the ASCII value of " + string.charAt(i) + "  = " + (int)string.charAt(i));
                frequency[string.charAt(i)]++; // increments the freqency of all char's except spaces
            //    System.out.println("the frequency of   " + string.charAt(i) + "  = " + frequency[string.charAt(i)]);
            }
            frequency[(int)' ']++; // catches frequency of spaces
            System.out.println("the frequency of ' '  = " + frequency[(int)' ']);

        }
        System.out.println("build Tree ========================");
        HuffmanTree.buildQueue(frequency);       
         Scanner in3 = new Scanner(new FileReader("C://Users/nitroluke/Documents/NetBeansProjects/HuffmanTree/textFile.txt"));
        String string = "";
        while(in3.hasNext()){
            string = in3.next();
            System.out.println(string);
            }
            for(int i =0; i < string.length(); i++){
           // if(encoding.containsKey(string.charAt(i))){
                //System.out.println("->"+encoding.get(string.charAt(i)));
               writer.print(encoding.get(string.charAt(i)));
           // }
           }
        
        writer.close();
          for(Map.Entry<Character, String> pair: encoding.entrySet()){  // this is where i think i am having problems.  I am not writing out the correct code
           System.out.println("(" + pair.getValue()+ "," + pair.getKey() + ")");
          // writer.print(pair.getValue());
           
       }
          Scanner in2 = new Scanner(new FileReader("C://Users/nitroluke/Documents/NetBeansProjects/HuffmanTree/encodedBits.txt"));
          
          while(in2.hasNext()){
              String code = in2.next();
              System.out.print("code = " + code);
              HuffmanTree.decode(code);
          }
          
    }
}
