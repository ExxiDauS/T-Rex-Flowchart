/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Trex;

/**
 *
 * @author User
 */
public class problem{
    private String titleName;
    private String img;
    private String description;
    private cases[] testCase;
    public problem(String titleName, String img, String description){
        this.titleName = titleName;
        this.img = img;
        this.description = description;
    }
    
    public problem(String titleName, String img, String description, cases[] testCase){
        this.titleName = titleName;
        this.img = img;
        this.description = description;
        this.testCase = testCase;
    }
    
    public String getTitleName(){
        return titleName;
    }
    
    public String getImg(){
        return img;
    }
    
    public String getDescription(){
        return description;
    }
    
    public cases[] getTestCase(){
        return testCase;
    }
    
}
