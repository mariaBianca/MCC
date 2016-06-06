/**
 * @Author Group Ella
 * Implementation of the Light test
*/ 

//declaring the right side LEDs veriables
int ledGreenRight = 6;
int ledYellowRight = 1;
int ledBlueRight = 9;
//declaring the left side LEDs veriables
int ledGreenLeft = 7;
int ledYellowLeft = 10;
int ledBlueLeft = 8;

/**
 * This menthod implements the connections and starting up for two LEDs
*/

void setup() {
 pinMode(ledGreenRight, OUTPUT);
 pinMode(ledYellowRight, OUTPUT);
 pinMode(ledBlueRight, OUTPUT);
 pinMode(ledGreenLeft, OUTPUT);
 pinMode(ledYellowLeft, OUTPUT);
 pinMode(ledBlueLeft, OUTPUT);
}
/**
 * This method implements the looping of the functions of two LEDs
*/ 
void loop() {
  digitalWrite(ledGreenRight, HIGH);
  digitalWrite(ledGreenLeft, HIGH);
  digitalWrite(ledYellowLeft, HIGH);
  digitalWrite(ledYellowRight, HIGH);
  digitalWrite(ledBlueRight, HIGH);
  digitalWrite(ledBlueLeft, HIGH);

}
