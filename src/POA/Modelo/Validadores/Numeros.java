/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Modelo.Validadores;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

import javax.swing.JSpinner;

/**
 *
 * @author MIGUEL
 */
public class Numeros {
    public static void solo_numeros(JTextField t) {
        t.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() < 45 || e.getKeyChar() > 57||e.getKeyChar()==47||e.getKeyChar()==45) {
                    e.consume();
                }
            }
        }
        );
    }
    public static void solo_numerosspiner(JSpinner t) {
        t.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() < 48 || e.getKeyChar() > 57) {
                    e.consume();
                }
            }
        }
        );
    }
}
