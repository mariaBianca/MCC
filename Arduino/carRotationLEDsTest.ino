/**
 *@Author Group Ella
*/ 

//declaring the LEDs veriables
const int pinFrontLeft = A1;
const int pinFrontRight = A0;
const int pinBackRight= A8;
const int pinBackLeft = A7;

/**
 *This method implements the connections and starting up for LEDs
*/ 
void setup() {
  //initialising the LEDs
  pinMode(pinFrontRight, OUTPUT);
  pinMode(pinFrontLeft, OUTPUT);
  pinMode(pinBackRight, OUTPUT);
  pinMode(pinBackLeft, OUTPUT);
}

/**
 * This method implements the looping of functions of LEDs
*/ 

void loop() {
  
  digitalWrite(pinFrontRight, HIGH);
  digitalWrite(pinBackRight, HIGH);
  digitalWrite(pinBackLeft, HIGH);
  digitalWrite(pinFrontLeft, HIGH);
}
