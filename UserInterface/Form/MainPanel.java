// package UserInterface.Form;

// import java.net.URL;
// import java.awt.BorderLayout;
// import javax.swing.ImageIcon;
// import javax.swing.JLabel;
// import javax.swing.JPanel;

// import UserInterface.IAStyle;

// public class MainPanel extends JPanel{
//     public MainPanel(){
//         customizeComponent();
//     }

//     private void customizeComponent() {
//         try {
//             ImageIcon imageIcon = new ImageIcon(IAStyle.URL_MAIN);
//             add(new JLabel(imageIcon),BorderLayout.CENTER);
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }
// }

package UserInterface.Form;

import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import UserInterface.IAStyle;

public class MainPanel extends JPanel {
    public MainPanel() {
        customizeComponent();
    }

    private void customizeComponent() {
        try {
            // Cargar la imagen original
            ImageIcon originalIcon = new ImageIcon(IAStyle.URL_MAIN);
            
            // Obtener la imagen escalada a 300x300
            Image scaledImage = originalIcon.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
            
            // Crear un nuevo ImageIcon con la imagen escalada
            ImageIcon scaledIcon = new ImageIcon(scaledImage);

            // Agregar la imagen escalada al JLabel
            add(new JLabel(scaledIcon), BorderLayout.CENTER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}