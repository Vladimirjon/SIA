package ArduinoControl;

import com.fazecast.jSerialComm.SerialPort;
import java.util.Scanner;

public class ControlArduinoJP {
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
        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {
                System.out.print("0 para Regar, 1 para no Regar:  ");
                int input = scanner.nextInt();

                if (input == 0 || input == 1) {
                    System.out.println("Enviando data: " + input);
                    port.getOutputStream().write(Integer.toString(input).getBytes());
                    Thread.sleep(1000);  // Wait before accepting more inputs
                } else {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
            port.closePort();  // Close the port on exit
            System.out.println("Puerto Cerrado.");
        }
    }
}