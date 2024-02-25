package BusinessLogic;

import com.fazecast.jSerialComm.SerialPort;
import java.util.Scanner;

public class ArduinoControlDEF {

    public SerialPort conectionArduino(String puerto){
        SerialPort port = SerialPort.getCommPort(puerto);
        port.setBaudRate(9600);
        if (!port.openPort()) {
            System.out.println("No se pudo abrir el puerto COM3.");
            return null;
        }else{
            System.out.println("Conexion exitosa");
            return port;
        }
    }

    public int readArduino (SerialPort port){
        int value;
        Scanner sc = new Scanner(port.getInputStream());
        try {
            while (true) {
                if(sc.hasNextLine()){
                    String line = sc.nextLine();
                    value = Integer.parseInt(line);
                    return value;
                }
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            sc.close();
            port.closePort();
            System.out.println("Puerto Cerrado.");
        }

    }
}