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
        boolean isRegando = false;

        if (port != null) {
            Scanner sc = new Scanner(port.getInputStream());
            try {
                controlDef.sendData(1, port);
                while (true) {
                    if (sc.hasNextLine()) {
                        String line = sc.nextLine();
                        value = Integer.parseInt(line);
                        if(value >= 950){
                            if(isRegando == false){
                                isRegando = true;
                                System.out.println("Regar");
                                controlDef.sendData(0, port);
                            }  
                        }else{
                            if(isRegando == true){
                                isRegando = false;
                                System.out.println("Regar");
                                controlDef.sendData(1, port);}
                        }
                        System.out.println("Humedad: "+value);   
                    }
                    Thread.sleep(500);
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("No puedo leer");
            } finally {
                sc.close();
                port.closePort();
                //System.out.println("Puerto Cerrado");
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
