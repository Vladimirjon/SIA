import com.fazecast.jSerialComm.SerialPort;
import java.util.Scanner;

public class ControlArduinoJP {
    public static void main(String[] args) throws Exception {
        
        SerialPort port = SerialPort.getCommPort("COM3");
        port.setBaudRate(9600);

        
        if (!port.openPort()) {
            System.out.println("No se pudo abrir el puerto COM3.");
            return;
        }

        
        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {
                System.out.print("0 para Regar, 1 para no Regar:  ");
                int input = scanner.nextInt();

                if (input == 0 || input == 1) {
                    System.out.println("Enviando data: " + input);
                    String data = Integer.toString(input);
                    port.getOutputStream().write(data.getBytes());
                    Thread.sleep(1000);  
                } else {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
            port.closePort();  
            System.out.println("Puerto Cerrado.");
        }
    }
}
