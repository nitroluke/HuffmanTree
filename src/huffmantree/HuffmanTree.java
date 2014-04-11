/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffmantree;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author nitroluke
 */
public class HuffmanTree {

    public static Node superParent;
    static HashMap<Character, String> encoding = new HashMap();

    static void buildQueue(int frequency[]) throws FileNotFoundException {
        PriorityQueue<Node> queue = new PriorityQueue<>();

        Node node;
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] != 0) { // adds all frequencies to the queue that have values in the frequency array
                node = new Node(frequency[i], (char) i);
                System.out.println("Frequency = " + node.GetFrequency() + ", Character = " + node.GetCharacter());
                queue.add(node);
            }
        }
        superParent = buildTree(queue);  // builds a tree given a queue
        encode(superParent, ""); //encodes the values to the hashmap given a tree

    }

    private static Node buildTree(PriorityQueue<Node> queue) {
        while (queue.size() > 1) {
            Node left = queue.poll();
            Node right = queue.poll();
            Node parent = new Node(left, right);
            queue.add(parent);
            //       System.out.println(parent.frequency);
        }
        return queue.poll();
    }

    private static void encode(Node parent, String key) {
        if (parent == null) {
            return;
        }
        //   System.out.println(parent.character);
        encode(parent.left, key + "0");
        encode(parent.right, key + "1");
        if (parent.left == null) {
            encoding.put(parent.character, key);
        }
    }

    static void decode(String code) throws FileNotFoundException, UnsupportedEncodingException {
        try (PrintWriter writer = new PrintWriter("decodedMessage.txt", "UTF-8")) {
            Node cur = superParent;
            //System.out.print(cur.character);
            System.out.println(code);
            for (int i = 0; i < code.length(); i++) {
                char c = code.charAt(i);
                System.out.println("charAt(" + i + ") = " + code.charAt(i));
                
                /*
                Cases
                1: we are at a leaf in the HuffmanTree
                2: we are at a parent and the char we are at i is a 0
                3: we are at a parent and the char we are at is a 1
                
                */
                if (cur.left == null || cur.right == null) { // we are at a leaf node
                    writer.print(cur.character);
                    System.out.println("cur.char = " + cur.character);
                    cur = superParent; 
                } else {
                    if (c == '0') {
                        cur = cur.left;
                    } else{ // c == '1'
                        cur = cur.right;
                    }
                }
                
            }
        }
    }

}
