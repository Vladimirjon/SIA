int sensor_pin = A0;
int relay_pin = 7;
bool shouldOverride = false;

void setup() {
  Serial.begin(9600);
  pinMode(sensor_pin, INPUT);
  pinMode(relay_pin, OUTPUT);
}

void regar() {
  Serial.println("Riego no activo ");
  Serial.println("");
  digitalWrite(relay_pin, HIGH);
}

void noRegar() {
  Serial.println("Riego Activo");
  Serial.println("");
  digitalWrite(relay_pin, LOW);
}

void processCommand(String command) {
  if (command.equals("1")) {
    shouldOverride = true; 
  } else if (command.equals("0")) {
    shouldOverride = false; 
  }
}

void loop() {
  if (Serial.available() > 0) {
    String receivedCommand = Serial.readStringUntil('\n');
    processCommand(receivedCommand);
  }

  if (shouldOverride) {
    if (Serial.available() > 0) {
      String receivedCommand = Serial.readStringUntil('\n');
      processCommand(receivedCommand);
    }

    if (shouldOverride) {
      noRegar(); 
      shouldOverride = false;
    }
  } else {
    int sensor_data = analogRead(sensor_pin);
    Serial.print("Sensor_data:");
    Serial.print(sensor_data);
    Serial.print("\t | ");

    if (sensor_data > 950) {
      Serial.println("La planta necesita riego");
      noRegar();
    } else if (sensor_data >= 400 && sensor_data <= 950) {
      Serial.println("La planta tiene agua, existe humedad");
      regar();
    } else if (sensor_data < 400) {
      Serial.println("Tierra húmeda");
      regar();
    }
  }

  delay(3000);
}
