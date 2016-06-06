/**
 * @Author Group Ella
*/ 

//declaring buzzer
const int buzzer = A3;

void setup() {
  pinMode(buzzer, OUTPUT);
  // put your setup code here, to run once:

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
  // put your main code here, to run repeatedly:

}
