/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TrexNotMain;
import Trex.problemInfo;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class problemFrameAlternate extends problemInfo implements ActionListener {
    private JFrame frame;
    private JTable table;
    DefaultTableModel tModel;
    private int page = 1;
    private JButton btn;
    public problemFrameAlternate(){
        frame = new JFrame();
        frame.setLayout(new GridLayout(2,1));
        table = new JTable();
        btn = new JButton(">");
        
        btn.addActionListener(this);
        
        tModel = (DefaultTableModel)table.getModel();
        tModel.addColumn("Number");
        tModel.addColumn("Name");
        buildTable(page);
        
        
//        add to Frame

        frame.add(table);
        frame.add(btn);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1024, 600);
        frame.setVisible(true);

    }
    public void buildTable(int page){
        tModel.setRowCount(0);
        for(int i = 0; i < problemLst[page - 1].length; i++){
            tModel.addRow(new Object[]{i, problemLst[page - 1][i]});
        }
        frame.add(table, 1, 0);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource().equals(btn)){
            page += 1;
            buildTable(page);
        }
    }
    
    
}
