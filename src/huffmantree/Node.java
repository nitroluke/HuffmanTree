/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package huffmantree;

/**
 *
 * @author nitroluke
 */
public class Node {
    public int frequency;
    public char character;
    public Node left;
    public Node right;
    
    
    public Node(int frequency, char character){
        this.frequency = frequency;
        this.character = character;
    }
    
    public Node(Node left, Node right){
        this.left = left;
        this.right = right;
    }
    
    public Node GetRight(){
        return right;
    }
    
    public int GetFrequency(){
        return frequency;
    }
    
    public char GetCharacter(){
        return character;
    }
}
