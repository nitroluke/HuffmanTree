/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package huffmantree;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        int frequency[] = new int[256]; // just in case of unicode
        Scanner in = new Scanner(new FileReader("C://Users/nitroluke/Documents/NetBeansProjects/HuffmanTree/textFile.txt"));
        while(in.hasNext()){
            String string = in.next();
            //System.out.println(string);
            for(int i = 0;  i < string.length(); i++){
                // string.charAt(i) is the character in the current string
                //(int)string.charAt(i) is the ASCII Value
                // alphaberArr[string.charAt(i)] is the frequency of that char.
                System.out.println("the ASCII value of " + string.charAt(i) + "  = " + (int)string.charAt(i));
                frequency[string.charAt(i)]++; // increments the freqency of all char's except spaces
                System.out.println("the frequency of   " + string.charAt(i) + "  = " + frequency[string.charAt(i)]);
            }
            frequency[(int)' ']++; // catches frequency of spaces
            System.out.println("the frequency of ' '  = " + frequency[(int)' ']);

        }
        HuffmanTree.buildQueue(frequency);
    }
}
