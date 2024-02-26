package BusinessLogic;

import java.util.Scanner;

import com.fazecast.jSerialComm.SerialPort;

import DataAccess.DTO.DatoRiegoDTO;

public class ControlRiego {
    DatoRiegoBL datoRiego;
    SerialPort port;
  
    
    ArduinoControlDEF controlDef;
    DatoRiegoBL datoBL = new DatoRiegoBL();
    DatoRiegoDTO dtDTO;

    public ControlRiego() {
        this.controlDef = new ArduinoControlDEF();
        this.datoRiego = new DatoRiegoBL();
    }

    public void regarAutomatico(SerialPort port) {
        
        int value;
        boolean isRegando = false;
        if (port != null) {
            Scanner sc = new Scanner(port.getInputStream());
            try {
                controlDef.sendData(0, port);
                    if (sc.hasNextLine()) {
                        String line = sc.nextLine();
                        value = Integer.parseInt(line);
                        if(value >= 950){
                            if(isRegando == false){
                                isRegando = true;
                                controlDef.sendData(1, port);
                                dtDTO = new DatoRiegoDTO(1,value,1,"","");
                                datoBL.create(dtDTO);
                                System.out.println("Registrado");
                            }  
                        }else{
                            if(isRegando == true){
                                isRegando = false;
                                controlDef.sendData(0, port);}
                        }
                        System.out.println("Humedad: "+value);   
                    }
                    Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("No puedo leer");
            } finally {
                // sc.close();
                // port.closePort();
                // //System.out.println("Puerto Cerrado");
            }
        }else{
            System.out.println("No se ha establecido la conexion");
        }

    }

    public static void main(String[] args) {
        ArduinoControlDEF controlDef = new ArduinoControlDEF();
        ControlRiego ctrl = new ControlRiego();
        SerialPort port;
        port = controlDef.conectionArduino("COM3");
        while (true) {
            ctrl.regarAutomatico(port);
        }
    }

}