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
    private boolean isRegando;


    public boolean isRegando() {
        return isRegando;
    }

    public void setRegando(boolean isRegando) {
        this.isRegando = isRegando;
    }

    public ControlRiego() {
        this.controlDef = new ArduinoControlDEF();
        this.datoRiego = new DatoRiegoBL();
        this.isRegando = false;
    }

    public void regarAutomatico(SerialPort port) {
        
        int value;
        if (port != null) {
            Scanner sc = new Scanner(port.getInputStream());
            try {
                controlDef.sendData(0, port);
                    if (sc.hasNextLine()) {
                        String line = sc.nextLine();
                        value = Integer.parseInt(line);
                        if(value >= 950){
                            if(isRegando() == false){
                                setRegando(true);
                                controlDef.sendData(1, port);
                                dtDTO = new DatoRiegoDTO(1,value,1,"","");
                                datoBL.create(dtDTO);
                                System.out.println("Registrado");
                                Thread.sleep(2000);
                            }  
                        }else{
                            if(isRegando() == true){
                                setRegando(false);
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
                // System.out.println("Puerto Cerrado");
            }
        }else{
            System.out.println("No se ha establecido la conexion");
        }
    }

    public void regarManual (SerialPort port){
        int value;
        if (port != null) {
            Scanner sc = new Scanner(port.getInputStream());
            try {
                controlDef.sendData(1, port);
                Thread.sleep(2000);
                controlDef.sendData(0, port);
                    if (sc.hasNextLine()) {
                        String line = sc.nextLine();
                        value = Integer.parseInt(line);
                        dtDTO = new DatoRiegoDTO(1,value,2,"","");
                        System.out.println("Humedad: "+value);   
                    }
                    Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("No puedo leer");
            } finally {
                // sc.close();
                // port.closePort();
                // System.out.println("Puerto Cerrado");
            }
        }else{
            System.out.println("No se ha establecido la conexion");
        }
    }



}