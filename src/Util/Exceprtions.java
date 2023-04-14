package Util;

import javax.swing.JOptionPane;

/**
 *
 * @author Aymen Souelmi
 */
public class Exceprtions extends Exception{

    public Exceprtions(String message) {
        super(message);
        JOptionPane.showMessageDialog(null, message, "Informations", JOptionPane.PLAIN_MESSAGE);
    }
    
    public Exceprtions(Throwable cause) {
        super(cause);
    }
    
    public Exceprtions(String message, Throwable cause) {
        super(message, cause);
    }
    
    
}
