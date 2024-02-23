package ArduinoControl;

import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.UnsupportedCommOperationException;

import java.io.IOException;
import java.io.OutputStream;

public class ArduinoController {

    private static SerialPort serialPort;
    private static OutputStream outputStream;

    public static void main(String[] args) {
        // Cambia el nombre del puerto según tu configuración
        String portName = "/dev/ttyUSB0"; // Puerto en sistemas Linux
        // String portName = "COM3"; // Puerto en sistemas Windows

        initializeSerial(portName);

        try {
            // Enviar comando para regar
            sendCommand("1");

            // Esperar un tiempo (simulando el tiempo de riego)
            Thread.sleep(5000);

            // Enviar comando para detener el riego
            sendCommand("0");

            // Cerrar la conexión serial
            closeSerial();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void initializeSerial(String portName) {
        try {
            CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(portName);
            serialPort = (SerialPort) portIdentifier.open("ArduinoController", 2000);
            serialPort.setSerialPortParams(9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
            outputStream = serialPort.getOutputStream();
        } catch (NoSuchPortException | PortInUseException | IOException | UnsupportedCommOperationException e) {
            e.printStackTrace();
        }
    }

    private static void sendCommand(String command) {
        try {
            outputStream.write(command.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void closeSerial() {
        if (serialPort != null) {
            serialPort.close();
        }
    }
}
