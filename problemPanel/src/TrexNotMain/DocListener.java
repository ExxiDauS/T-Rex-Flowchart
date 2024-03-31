/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TrexNotMain;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
/**
 *
 * @author User
 */
public class DocListener implements DocumentListener{
      public void insertUpdate(DocumentEvent e) {
        updateLog(e, "inserted into");
    }
    public void removeUpdate(DocumentEvent e) {
        updateLog(e, "removed from");
    }
    public void changedUpdate(DocumentEvent e) {
        //Plain text components do not fire these events
    }

    public void updateLog(DocumentEvent e, String action) {

    }
}
