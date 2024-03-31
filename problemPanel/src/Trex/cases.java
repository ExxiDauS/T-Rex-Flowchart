/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Trex;

/**
 *
 * @author User
 */
public class cases {
    private String input;
    private String output;
    public cases(){}
    public cases(String input, String output){
        this.input = input;
        this.output = output;
    }
    
    public void setInput(String input){
        this.input = input;
    }
    
    public void setOutput(String output){
        this.output = output;
    }
    
    public String getInput(){
        return input;
    }
    
    public String getOutput(){
        return output;
    }
}
