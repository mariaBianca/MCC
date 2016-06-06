/**
 *@Author Group Ella
*/ 

void setup() {
  Serial.begin(9600);
}

/**
 *This method implements looping of the controls of the joysticks
*/ 

void loop() {
  char buffer[] ={' ',' ',' ',' ',' ', ' ',' '};
  if (Serial.available()){
    String sPower = Serial.readStringUntil('A');
    int power = sPower.toInt();
    
    String sAngle =Serial.readStringUntil('D');
    int angle = sAngle.toInt();
    
    String sDir = Serial.readStringUntil('E');
    int dir = sDir.toInt();

    Serial.println(power);
    Serial.println(angle);
    Serial.println(dir);
    }
    
}
