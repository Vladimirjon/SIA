import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.fazecast.jSerialComm.SerialPort;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneDarkIJTheme;

import BusinessLogic.ArduinoControlDEF;
import BusinessLogic.ControlRiego;
import BusinessLogic.DatoRiegoBL;
import DataAccess.DTO.DatoRiegoDTO;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.FlatArcOrangeIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatArcDarkIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneDarkIJTheme;

import UserInterface.Form.MainForm;
import UserInterface.Form.CodeRexScreen;

public class App {

    public static void main(String[] args) throws Exception {
        DatoRiegoBL bl = new DatoRiegoBL();

                FlatLightLaf.setup();
                FlatLightLaf.supportsNativeWindowDecorations();
                try {
                        UIManager.setLookAndFeel(new FlatAtomOneDarkIJTheme());
                    } catch (UnsupportedLookAndFeelException e) {
                    e.printStackTrace();
                } 
    
       CodeRexScreen.show();
       ArduinoControlDEF controlDef = new ArduinoControlDEF();

       SerialPort port;
        port = controlDef.conectionArduino("COM3");
       MainForm frmMain = new MainForm("SIA by CodeRex", port);
        ControlRiego reg = new ControlRiego();
        
        while (true) {
            reg.regarAutomatico(port);
        }

    }
}
