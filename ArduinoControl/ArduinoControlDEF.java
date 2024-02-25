package ArduinoControl;

import com.fazecast.jSerialComm.SerialPort;
import java.util.Scanner;

public class ArduinoControlDEF {
    public static void main(String[] args) throws Exception {
        // Obtain COM3 port
        SerialPort port = SerialPort.getCommPort("COM3");
        port.setBaudRate(9600);

        // Try to open the port
        if (!port.openPort()) {
            System.out.println("No se pudo abrir el puerto COM3.");
            return;
        }

        // User input
        Scanner sc = new Scanner(port.getInputStream());

        try {
            while (true) {
                if(sc.hasNextLine()){
                    String line = sc.nextLine();
                    float value = Float.parseFloat(line);
                    System.out.println("Received value: " + value);
                }
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sc.close();
            port.closePort();  // Close the port on exit
            System.out.println("Puerto Cerrado.");
        }
    }
}