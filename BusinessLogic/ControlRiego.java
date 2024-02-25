package BusinessLogic;

import java.util.Scanner;

import com.fazecast.jSerialComm.SerialPort;

public class ControlRiego {
    DatoRiegoBL datoRiego;
    SerialPort port;
    
    
    ArduinoControlDEF controlDef;

    public ControlRiego() {
        this.controlDef = new ArduinoControlDEF();
        this.datoRiego = new DatoRiegoBL();
    }

    public void regarAutomatico() {
        port = controlDef.conectionArduino("COM3");
        int value;
        int data = 1; 
        if (port != null) {
            Scanner sc = new Scanner(port.getInputStream());
            try {
                while (true) {
                    if (sc.hasNextLine()) {
                        String line = sc.nextLine();
                        value = Integer.parseInt(line);
                        if(value >= 950){
                            if (data == 1) {
                                data = 0;
                                controlDef.sendData(data, port);
                            }
                        }else{
                            if(data == 0){
                                data = 1;
                                controlDef.sendData(data, port);
                            }
                        }
                    }
                    Thread.sleep(100);
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("No puedo leer");
                ;
            } finally {
                sc.close();
                port.closePort();
                System.out.println("Puerto Cerrado");
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
