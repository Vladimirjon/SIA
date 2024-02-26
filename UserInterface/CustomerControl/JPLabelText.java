package UserInterface.CustomerControl;

import javax.swing.*;

import UserInterface.IAStyle;

import java.awt.*;

public class JPLabelText extends JPanel{
    private JPLabel    lblEtiqueta = new JPLabel();
    private JPTextBox  txtContenido= new JPTextBox();

    public JPLabelText(String etiqueta) {
        setLayout(new BorderLayout());

        lblEtiqueta.setCustomizeComponent(  etiqueta, 
                                            IAStyle.FONT_SMALL, 
                                            IAStyle.COLOR_FONT_LIGHT, 
                                            IAStyle.ALIGNMENT_LEFT); 
        //txtContenido.setBorder(txtContenido.createBorderLine());
        txtContenido.setBorderLine();
        add(lblEtiqueta, BorderLayout.NORTH);
        add(txtContenido, BorderLayout.CENTER);
    }
}
