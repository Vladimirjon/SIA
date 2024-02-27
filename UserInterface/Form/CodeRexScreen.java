// package UserInterface.Form;

// import java.awt.BorderLayout;
// // import java.net.URL;

// import javax.swing.ImageIcon;
// import javax.swing.JFrame;
// import javax.swing.JLabel;
// import javax.swing.JProgressBar;

// import UserInterface.IAStyle;

// public abstract class CodeRexScreen   {
//     private static JFrame       frmSplash;
//     private static JProgressBar prbLoaging;
//     private static ImageIcon    icoImagen ;
//     private static JLabel       lblSplash ;

//     public static void show() {
//         icoImagen  = new ImageIcon(IAStyle.URL_SPLASH);
//         lblSplash  = new JLabel(icoImagen);
//         prbLoaging = new JProgressBar(0, 100);

//         prbLoaging.setStringPainted(true);
        
//         frmSplash = new JFrame();
//         frmSplash.setUndecorated(true);
//         frmSplash.getContentPane().add(lblSplash, BorderLayout.CENTER);
//         frmSplash.add(prbLoaging, BorderLayout.SOUTH);
//         frmSplash.setSize(icoImagen.getIconWidth(), icoImagen.getIconHeight());
//         frmSplash.setLocationRelativeTo(null); // Centrar en la pantalla
       
//         frmSplash.setVisible(true);
//         for (int i = 0; i <= 100; i++) {
//             try {
//                 Thread.sleep(50); // Espera por 50 milisegundos
//             } catch (InterruptedException e) {
//                 e.printStackTrace();
//             }
//             prbLoaging.setValue(i);
//         }
//         frmSplash.setVisible(false);
//     }
// }

package UserInterface.Form;

import java.awt.BorderLayout;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import UserInterface.IAStyle;

public abstract class CodeRexScreen {
    private static JFrame frmSplash;
    private static JProgressBar prbLoading;
    private static ImageIcon icoImage;
    private static JLabel lblSplash;

    public static void show() {
        icoImage = new ImageIcon(IAStyle.URL_SPLASH);
        lblSplash = new JLabel(icoImage);
        prbLoading = new JProgressBar(0, 100);

        // Configurar la apariencia de la barra de carga
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        prbLoading.setStringPainted(true);
        prbLoading.setForeground(new Color(255, 255, 255)); // Blanco
        prbLoading.setBackground(new Color(0, 0, 0)); // Negro // Configurar el color de la barra de carga

        frmSplash = new JFrame();
        frmSplash.setUndecorated(true);
        frmSplash.getContentPane().add(lblSplash, BorderLayout.CENTER);
        frmSplash.add(prbLoading, BorderLayout.SOUTH);
        frmSplash.setSize(icoImage.getIconWidth(), icoImage.getIconHeight());
        frmSplash.setLocationRelativeTo(null);

        frmSplash.setVisible(true);

        for (int i = 0; i <= 100; i++) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            prbLoading.setValue(i);
        }
        frmSplash.setVisible(false);
    }
}