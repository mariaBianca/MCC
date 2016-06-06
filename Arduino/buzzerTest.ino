/**
 * @Author Group Ella
 * This class represents the implementation of the buzzer test that has been done.
*/ 

//declaring buzzer
const int buzzer = A3;

void setup() {
  pinMode(buzzer, OUTPUT);
}

/**
 * This method implements the looping of triggering the buzzer
*/ 
void loop() {

  digitalWrite(buzzer, HIGH);
  delay(500);
  digitalWrite(buzzer, LOW);
  delay(100);
  digitalWrite(buzzer, HIGH);
}
