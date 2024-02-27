// package UserInterface.Form;

// import java.awt.Dimension;
// import java.awt.Image;
// import java.io.IOException;

// import javax.imageio.ImageIO;
// import javax.swing.BoxLayout;
// import javax.swing.ImageIcon;
// import javax.swing.JLabel;
// import javax.swing.JPanel;

// import UserInterface.IAStyle;
// import UserInterface.CustomerControl.JPButton;

// public class MenuPanel extends JPanel {
//     public  JPButton   
//             btnHome     = new JPButton("HOME"),
//             // btnLogin    = new PatButton("Login"),
//             btnBase     = new JPButton("CONSULTAR DATOS DE RIEGO"),
//             btnRegar     = new JPButton("REGAR");
//             // btnLocalidad= new PatButton("Localidad"),
//             // btnTest     = new PatButton("btnTest");

//     public MenuPanel(){
//         customizeComponent();
//     }

//     private void customizeComponent() {
//         setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
//         setPreferredSize(new Dimension(250, getHeight())); 

//         // add-logo
//         try {
//             Image logo = ImageIO.read(IAStyle.URL_LOGO);
//             logo = logo.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
//             add(new JLabel(new ImageIcon(logo)));
//         } catch (IOException e) {
//             e.printStackTrace();
//         }

//         // add-botones
//         add(btnHome);
//         // add(btnLogin);
//         add(btnBase);
//         // add(btnLocalidad);
//         // add(btnTest);
//         add(btnRegar);

//         // add-copyright
//         add(new JLabel("\u00A9 SIA "));
//     }
// }


package UserInterface.Form;

import java.awt.Dimension;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Component;
import javax.swing.border.EmptyBorder;

import UserInterface.IAStyle;
import UserInterface.CustomerControl.JPButton;

public class MenuPanel extends JPanel {
    public JPButton
            btnHome = new JPButton("HOME"),
            // btnLogin = new PatButton("Login"),
            btnBase = new JPButton("CONSULTAR DATOS DE RIEGO"),
            btnRegar = new JPButton("REGAR");
    // btnLocalidad= new PatButton("Localidad"),
    // btnTest     = new PatButton("btnTest");

    private JLabel lblCopyright = new JLabel("\u00A9 SIA ");

    public MenuPanel() {
        customizeComponent();
    }

    private void customizeComponent() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(300, getHeight()));
        setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12)); // Añadir un borde al panel

        // Añadir logo
        try {
            Image logo = ImageIO.read(IAStyle.URL_LOGO);
            logo = logo.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
            JLabel logoLabel = new JLabel(new ImageIcon(logo));
            logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            add(logoLabel);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Añadir botones con borde
        add(createCenteredPanel(btnHome));
        // add(createCenteredPanel(btnLogin));
        add(createCenteredPanel(btnBase));
        // add(createCenteredPanel(btnLocalidad));
        // add(createCenteredPanel(btnTest));
        add(createCenteredPanel(btnRegar));

        // Añadir copyright en la esquina inferior derecha
        JPanel copyrightPanel = new JPanel();
        copyrightPanel.setLayout(new BoxLayout(copyrightPanel, BoxLayout.X_AXIS));
        copyrightPanel.add(Box.createHorizontalGlue());
        copyrightPanel.add(lblCopyright);
        add(copyrightPanel);
    }

    private JPanel createCenteredPanel(JPButton button) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(Box.createHorizontalGlue());
        panel.add(button);
        panel.add(Box.createHorizontalGlue());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0)); // Añadir un borde al panel de botones
        return panel;
    }
}