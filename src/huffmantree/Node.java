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
public class Node implements Comparable<Node>{
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
        frequency = (left.frequency + right.frequency);
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

    @Override
    public int compareTo(Node other) {
      return (this.frequency - other.frequency); // this might be backwards... fuck with it(switch them)
      //  return(other.frequency - this.frequency);
    }   
}
