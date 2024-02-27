import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import BusinessLogic.DatoRiegoBL;
import DataAccess.DTO.DatoRiegoDTO;
import UserInterface.GUI.Principal;

// import com.formdev.flatlaf.FlatLightLaf;
// import com.formdev.flatlaf.intellijthemes.FlatArcOrangeIJTheme;
// import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatArcDarkIJTheme;
// import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneDarkIJTheme;

// import UserInterface.Form.MainForm;
// import UserInterface.Form.SplashScreenForm;

public class App {

    public static void main(String[] args) throws Exception {
        // DatoRiegoBL bl = new DatoRiegoBL();
        // DatoRiegoDTO dro = new DatoRiegoDTO(0, 12, 1, "", "");
        // bl.create(dro);
         JFrame frame = new JFrame("Mi Aplicación");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            Principal panel = new Principal();
            frame.add(panel);
        } catch (Exception e) {
            e.printStackTrace();
        }

        frame.pack(); // Ajusta el tamaño del frame automáticamente
        frame.setSize(600, 400);
        frame.setVisible(true); 

    }
}
