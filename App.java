import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import BusinessLogic.DatoRiegoBL;
import DataAccess.DTO.DatoRiegoDTO;

// import com.formdev.flatlaf.FlatLightLaf;
// import com.formdev.flatlaf.intellijthemes.FlatArcOrangeIJTheme;
// import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatArcDarkIJTheme;
// import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneDarkIJTheme;

// import UserInterface.Form.MainForm;
// import UserInterface.Form.SplashScreenForm;

public class App {
    
    public static void main(String[] args) throws Exception {
        DatoRiegoBL bl = new DatoRiegoBL();
        DatoRiegoDTO dro = new DatoRiegoDTO(0, 12, 1, "", "");
        bl.create(dro);
    }
}
