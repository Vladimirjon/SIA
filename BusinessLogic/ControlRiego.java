package BusinessLogic;

import java.util.Scanner;

import com.fazecast.jSerialComm.SerialPort;

public class ControlRiego {
    SerialPort port;
    
    ArduinoControlDEF controlDef;
    private int humedad;

    public ControlRiego() {
        this.controlDef = new ArduinoControlDEF();
    }

    public void regarAutomatico() {
        port = controlDef.conectionArduino("COM3");
        
        int value;
        if (port != null) {
            Scanner sc = new Scanner(port.getInputStream());
            try {
                while (true) {
                    if (sc.hasNextLine()) {
                        String line = sc.nextLine();
                        value = Integer.parseInt(line);
                        if(value >= 950){
                            controlDef.sendData(1, port);
                        }
                    }
                    Thread.sleep(1000);
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("No se puedo leer");
                ;
            } finally {
                sc.close();
                port.closePort();
                System.out.println("Puerto Cerrado.");
            }
        }else{
            System.out.println("No se ha establecido la conexion");
        }

    }

    public static void main(String[] args) {
        ControlRiego ctrl = new ControlRiego();
        ctrl.regarAutomatico();
    }

}
