package ArduinoControl;

import com.fazecast.jSerialComm.*;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class ArduinoControlJose {

    private static final String PORT_NAME = "COM3";
    private static final int BAUD_RATE = 9600;
    private static SerialPort serialPort;
    private static  InputStream inputStream;
    private static OutputStream outputStream;

    public static void main(String[] args) {
        serialPort = SerialPort.getCommPort(PORT_NAME);

        try {
            serialPort.setBaudRate(BAUD_RATE);
            serialPort.openPort();
            inputStream = serialPort.getInputStream();
            outputStream = serialPort.getOutputStream();

            Scanner scanner = new Scanner(System.in);
            
            
            Thread receivingThread = new Thread(() -> {
                try {
                    while (true) {
                        while (inputStream.available() == 0) {
                            Thread.sleep(100);
                        }

                        // Leer los datos disponibles del Arduino
                        byte[] buffer = new byte[inputStream.available()];
                        inputStream.read(buffer);

                        String humidityData = new String(buffer);
                        System.out.println("Humedad del suelo: " + humidityData.trim() + "%");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            receivingThread.start();

            String userCommand;

            do {
                System.out.print("Ingrese el comando (0 para regar, 1 para no regar): ");
                userCommand = scanner.nextLine();

                if (serialPort.isOpen() && outputStream != null) {
                    sendCommand(outputStream, userCommand);
                    Thread.sleep(2000);
                }
            } while (!userCommand.equals("0") && !userCommand.equals("1"));
        } catch (Exception e) {
            e.printStackTrace();
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