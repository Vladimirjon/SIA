package ArduinoControl;

import com.fazecast.jSerialComm.*;

import java.io.OutputStream;
import java.util.Scanner;

public class ArduinoControl {

    private static final String PORT_NAME = "COM3"; // Cambia esto al puerto que esté utilizando tu Arduino
    private static final int BAUD_RATE = 9600;

    public static void main(String[] args) {
        SerialPort serialPort = SerialPort.getCommPort(PORT_NAME);

        try {
            serialPort.setBaudRate(BAUD_RATE);
            serialPort.openPort();

            OutputStream outputStream = serialPort.getOutputStream();
            Scanner scanner = new Scanner(System.in);

            String userCommand;

            do {
                System.out.print("Ingrese el comando (0 para regar, 1 para no regar): ");
                userCommand = scanner.nextLine();

                try {
                    sendCommand(outputStream, userCommand);
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    System.out.println("Error: Ingresa solo 0 o 1.");
                }
            } while (!userCommand.equals("0") && !userCommand.equals("1"));
        } finally {
            serialPort.closePort();
        }
    }

    private static void sendCommand(OutputStream outputStream, String command) {
        try {
            String commandWithNewline = command + "\n";
            outputStream.write(commandWithNewline.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
