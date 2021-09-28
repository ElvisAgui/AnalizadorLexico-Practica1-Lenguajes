
package com.proyectoLenguajes.principal;

import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

/**
 *
 * @author elvis_agui
 */
public class Busqueda {
    
    
     public void buscarpalabra(JTextArea areaTexto, String texto) {
        if (texto.length() >= 1) {
            DefaultHighlighter.DefaultHighlightPainter highlightPainter = new DefaultHighlighter.DefaultHighlightPainter(Color.GREEN);
            Highlighter h = areaTexto.getHighlighter();
            h.removeAllHighlights();
            String text = areaTexto.getText();
            String caracteres = texto;
            Pattern p = Pattern.compile("(?i)" + caracteres);
            Matcher m = p.matcher(text);
            while (m.find()) {
                try {
                    h.addHighlight(m.start(), m.end(), highlightPainter);
                } catch (BadLocationException ex) {
                    JOptionPane.showMessageDialog(null, "color inexistente");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "debe escribir primero");
        }
    }
}
