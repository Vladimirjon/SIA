package ArduinoControl;
import com.fazecast.jSerialComm.SerialPort;
import java.util.Scanner;

public class ArduinoControlIvonne {
    public static void main(String[] args) throws Exception {
        // Obtener el puerto COM6
        SerialPort port = SerialPort.getCommPort("COM6");
        port.setBaudRate(9600);

        // Intentar abrir el puerto
        if (!port.openPort()) {
            System.out.println("No se pudo abrir el puerto COM6.");
            return;
        }

        // Entrada de usuario
        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {
                System.out.print("Ingrese 0 para apagar, 1 para encender, o cualquier otro número para salir: ");
                int input = scanner.nextInt();

                if (input == 0 || input == 1) {
                    System.out.println("Enviando dato: " + input);
                    port.getOutputStream().write(Integer.toString(input).getBytes());
                    Thread.sleep(1000);  // Esperar antes de aceptar más entradas
                } else {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
            port.closePort();  // Cerrar el puerto al salir
            System.out.println("Puerto cerrado.");
        }
    }
}