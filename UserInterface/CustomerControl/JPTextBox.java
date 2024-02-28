package UserInterface.CustomerControl;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import UserInterface.IAStyle;

public class JPTextBox extends JTextField {

    public JPTextBox() {
        customizeComponent();
    }

    private void customizeComponent() {
        setBorderRect();
        setFont(IAStyle.FONT);  
        setForeground(IAStyle.COLOR_FONT_LIGHT);  
        setCaretColor(IAStyle.COLOR_CURSOR);    // Color del cursor
        setMargin(new Insets(5, 5, 5, 5));      // Ajusta los márgenes
        setOpaque(false);                       // Fondo transparente
    }

    public void setBorderRect() {
        Border lineBorder = BorderFactory.createLineBorder(IAStyle.COLOR_BORDER);
        Border emptyBorder = new EmptyBorder(5, 5, 5, 5);  // Márgenes internos
        setBorder( new CompoundBorder(lineBorder, emptyBorder));
    }

    public void setBorderLine(){

        Border lineBorder = BorderFactory.createLineBorder(IAStyle.COLOR_BORDER);
        Border emptyBorder = new EmptyBorder(5, 5, 5, 5);  // Márgenes internos
        setBorder(new CompoundBorder(lineBorder, emptyBorder));

        setBackground(new Color(20, 20, 20)); // Casi negro
    }
}


