package UserInterface.Form;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.fazecast.jSerialComm.SerialPort;

import BusinessLogic.ArduinoControlDEF;
import BusinessLogic.ControlRiego;
import UserInterface.IAStyle;

public class MainForm extends JFrame{
    MenuPanel  pnlMenu = new MenuPanel();
    JPanel     pnlMain = new MainPanel();
    SerialPort Port;
 
    public MainForm(String tilteApp, SerialPort port) {
        customizeComponent(tilteApp);
        Port = port;
        pnlMenu.btnHome.addActionListener(      e -> setPanel(new MainPanel())); 
        // pnlMenu.btnLogin.addActionListener(     e -> setPanel(new LoginPanel())); 
        pnlMenu.btnBase.addActionListener(      e -> setPanel(new BasePanel()));  
        pnlMenu.btnRegar.addActionListener(      e -> regadoAutomatico(Port));  
        // pnlMenu.btnLocalidad.addActionListener( e -> setPanel(new MainPanel())); 
        //agregar
        // pnlMenu.btnTest.addActionListener( e -> { IAStyle.showMsgError("mensaje de error");}); 
    }

    private void regadoAutomatico(SerialPort port) {
        ArduinoControlDEF controlDef = new ArduinoControlDEF();
        ControlRiego reg = new ControlRiego();
        reg.regarManual(port);
    }

    private void setPanel(JPanel formularioPanel) {
        Container container = getContentPane();
        container.remove(pnlMain);
        pnlMain = formularioPanel;
        container.add(pnlMain, BorderLayout.CENTER);
        revalidate();
        repaint();
    }
     
    //JOptionPane.showMessageDialog(this, "Seleccionaste Opción 3");

    private void customizeComponent(String tilteApp) {
        setTitle(tilteApp);
        setSize(820, 520);
        setResizable(false);
        setLocationRelativeTo(null); // Centrar en la pantalla
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear un contenedor para los dos paneles usando BorderLayout
        Container container = getContentPane();
        container.setLayout(new BorderLayout());

        // Agregar los paneles al contenedor
        container.add(pnlMenu, BorderLayout.WEST);
        container.add(pnlMain, BorderLayout.CENTER);
        setVisible(true);
    }   
}