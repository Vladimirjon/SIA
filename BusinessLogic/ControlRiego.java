package BusinessLogic;

import BusinessLogic.ArduinoControlDEF;
import com.fazecast.jSerialComm.SerialPort;
public class ControlRiego {
    SerialPort port;
    ArduinoControlDEF controlDef = new ArduinoControlDEF();
    private int humedad;

    public void regarAutomatico(){
        port = controlDef.conectionArduino("COM3"); //Puerto serie de la placa
        if(port != null){
            while (true) {
                humedad = controlDef.readArduino(port);
                System.out.println("Humedad: " + humedad);
            }
        }
    }

    public static void main(String[] args) {
        ControlRiego ctrl = new ControlRiego();
        ctrl.regarAutomatico();
    }

}
