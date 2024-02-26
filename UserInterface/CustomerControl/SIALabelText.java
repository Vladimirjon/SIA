package UserInterface.CustomerControl;

import javax.swing.*;

import UserInterface.SIAStyle;

import java.awt.*;

public class SIALabelText extends JPanel{
    private SIALabel    lblEtiqueta = new SIALabel();
    private SIATextBox  txtContenido= new SIATextBox();

    public SIALabelText(String etiqueta) {
        setLayout(new BorderLayout());

        lblEtiqueta.setCustomizeComponent(  etiqueta, 
                                            SIAStyle.FONT_SMALL, 
                                            SIAStyle.COLOR_FONT_LIGHT, 
                                            SIAStyle.ALIGNMENT_LEFT); 
        //txtContenido.setBorder(txtContenido.createBorderLine());
        txtContenido.setBorderLine();
        add(lblEtiqueta, BorderLayout.NORTH);
        add(txtContenido, BorderLayout.CENTER);
    }
}
