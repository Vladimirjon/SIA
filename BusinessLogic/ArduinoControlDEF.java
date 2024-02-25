package BusinessLogic;

import com.fazecast.jSerialComm.SerialPort;

public class ArduinoControlDEF {

    public SerialPort conectionArduino(String puerto) {
        SerialPort port = SerialPort.getCommPort(puerto);
        port.setBaudRate(9600);
        if (!port.openPort()) {
            System.out.println("No se pudo abrir el puerto COM3.");
            return null;
        } else {
            System.out.println("Conexion exitosa");
            return port;
        }
    }

    public void sendData(int input, SerialPort port) {
        if (input == 0 || input == 1) {
            // System.out.println("Enviando data: " + input);
            try {
                port.getOutputStream().write(Integer.toString(input).getBytes());
            }catch (Exception e) {
                e.printStackTrace();
            } finally {
                
            }
        }
    }
}