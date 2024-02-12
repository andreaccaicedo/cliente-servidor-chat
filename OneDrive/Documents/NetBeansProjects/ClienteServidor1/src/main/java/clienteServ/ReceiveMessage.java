/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clienteServ;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author andre
 */
public class ReceiveMessage extends Thread {

    String msg = " ";
    DataInputStream dis = null;
    JTextArea txt_area = null;

    public ReceiveMessage(DataInputStream d, JTextArea a) {
        this.dis = d;
        this.txt_area = a;
    }

    public void run() {
        while (true) {
            try {
                msg = dis.readUTF();
                txt_area.append("\n" + this.getName() + ": " + msg);
            } catch (IOException ex) {
                Logger.getLogger(ReceiveMessage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
