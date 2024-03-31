/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author GF65
 */
import java.io.*;
public class Output_test {
    public static void main(String[] args) {
        File f = new File("test.txt");
        Output out = new Output();
        out.convertToCode(f);
    }
}
