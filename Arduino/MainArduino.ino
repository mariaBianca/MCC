/**
*@author Group Ella.
* This class represents the implementation of the main Arduino board in the system.
* It is responsible for the collision check, movement, system stabilization, turning lights etc.
*/

//including the neccessary libraries
#include <Smartcar.h>
#include <OneWire.h>
#include <DallasTemperature.h>

//declaring the ultrasonic sensors and the used pins on the board
SR04 ultrasonicSensorFront;
SR04 ultrasonicSensorBack;
const int TRIGGER_PIN = 5; 
const int ECHO_PIN = 6; 
const int TRIGGER_PINb = A5;
const int ECHO_PINb = A4;

//declaring the pin for the buzzer
int buzzer = A3;

//defining the data wire that is plugged into the Arduino board on port A2
#define ONE_WIRE_BUS A2
//setting up a oneWire instance to communicate with any OneWire device
OneWire oneWire(ONE_WIRE_BUS);
//passing the oneWire reference to the temperature sensor
DallasTemperature tempSens(&oneWire);

//declaring the components
Car car;
Odometer encoderLeft, encoderRight;
Gyroscope gyro;

//declaring the initial speeds and movements of the car
int frontSpeed = 60; //70% of the full speed forward
int backSpeed = -60; //70% of the full speed backward
int lDegrees = -75; //degrees to turn left
int rDegrees = 75; //degrees to turn right
char side = 'n';
int actualSpeed = frontSpeed;

//declaring the LEDs
const int pinFrontLeft = A1;
const int pinFrontRight = A9;
const int pinBackRight= A8;
const int pinBackLeft = A7;

//declaring the integers used to calculate the distance for the 2 ultrasonic sensors
int distanceFront;
int distanceBack;

/**
 * This method's main responsibility is to start up, attach and begin the components. 
*/
void setup() {
  
  //beginning the bluetooth 
  Serial3.begin(9600);
  //Serial.begin(9600);
  
  //initializing the car using the encoders and the gyro
  //attaching the components
  gyro.attach();
  encoderLeft.attach(2);
  encoderRight.attach(3);
  ultrasonicSensorFront.attach(TRIGGER_PIN, ECHO_PIN);
  ultrasonicSensorBack.attach(TRIGGER_PINb, ECHO_PINb);

  //starting the components
  gyro.begin();
  car.begin(encoderLeft, encoderRight, gyro);
  tempSens.begin();

  //initialising the distances used to 0
  distanceFront = 0;
  distanceBack = 0;

  //initialising buzzer;
  pinMode(buzzer, OUTPUT);
  pinMode(pinBackLeft, OUTPUT);
  pinMode(pinBackRight, OUTPUT);
  pinMode(pinFrontLeft, OUTPUT);
  pinMode(pinFrontRight, OUTPUT);
}


/**
*This method is in charge of looping through the movement, system stabilizer and collision check implementation.
*/
void loop() {

 distanceFront = ultrasonicSensorFront.getDistance();
 distanceBack = ultrasonicSensorBack.getDistance();
 handleInput();
 
 int speed2 = car.getSpeed();                                       //VALUE MUST GO TO ANDROID
  if (speed2 == 0){
  side = 'n';
  }
 //Serial.print(speed2);
 if ( IsClear(distanceFront) == false  && side !='b' && side != 'n'){  
   if (distanceFront > 20 && distanceFront == 0){
     car.setSpeed(frontSpeed);      
   }
   else{
    if (speed2 != 0){
     digitalWrite(buzzer, HIGH);
     delay(300);
     car.setSpeed(0);
     digitalWrite(buzzer, LOW);
     delay(100);
     digitalWrite(buzzer, HIGH);
     delay(300);
     digitalWrite(buzzer, LOW);
   }
   }
 }
 
 speed2 = car.getSpeed();                                        //VALUE MUST GO TO ANDROID
 if ( IsClear(distanceBack) == false && side =='b'){
   if (distanceBack > 20 && distanceBack == 0){
     car.setSpeed(backSpeed);
    }
    else{     
      if (speed2 != 0){
      digitalWrite(buzzer, HIGH);
      delay(300);
      car.setSpeed(0);
      digitalWrite(buzzer, LOW);
      delay(100);
      digitalWrite(buzzer, HIGH);
      delay(300);
      digitalWrite(buzzer, LOW);
    }
    else{
      car.setSpeed(0); }
    }
  }   
   //tempSens.requestTemperatures();                                                    
 //Serial3.println(tempSens.getTempCByIndex(0));                                         //VALUE MUST GO TO ANDROID
}

/**
*This method is in charge of handling the input in regards to the car's movement.
*/
void handleInput() { 

  if (Serial3.available()) {    
    char input = Serial3.read(); 
    //turn off the turning lights
    digitalWrite(pinBackRight, LOW);
    digitalWrite(pinBackLeft, LOW);
    digitalWrite(pinFrontLeft, LOW);
    digitalWrite(pinFrontRight, LOW);
    
    //the following cases represent scenarios in which the car will move at a specific speed, and a specific direction. The lights
    //on the car will turn in regards to that.
    switch (input) {     
      case 'l':
        car.setSpeed(actualSpeed);
        car.setAngle(lDegrees);       
        side = 'l';
        digitalWrite(pinBackRight, LOW);
        digitalWrite(pinBackLeft, HIGH);
        digitalWrite(pinFrontLeft, HIGH);
        digitalWrite(pinFrontRight, LOW);
        break;
      case 'r': //turn clock-wise
         car.setSpeed(actualSpeed);
         car.setAngle(rDegrees);
         side = 'r';
        digitalWrite(pinBackRight, HIGH);
        digitalWrite(pinBackLeft, LOW);
        digitalWrite(pinFrontLeft, LOW);
        digitalWrite(pinFrontRight, HIGH);
         break;
      case 'f': //go ahead
        side = 'f';
        car.setAngle(0); 
        actualSpeed = frontSpeed;
        car.setSpeed(frontSpeed);
        break;
      case 'b': //go back
        side = 'b';
        actualSpeed = backSpeed;
        car.setSpeed(backSpeed);
        car.setAngle(0);
        break;
      case 's': 
        car.setSpeed(0);
        car.setAngle(0);
        break;
      case 't':
        car.setSpeed(backSpeed);
        actualSpeed = backSpeed;
        car.setAngle(rDegrees);
        break;
      case 'w':
        car.setSpeed(backSpeed);
        actualSpeed = backSpeed;
        car.setAngle(lDegrees);  
        break;
      case 'h':
        car.setSpeed(frontSpeed);
        car.setAngle(lDegrees);
        break;
      case 'i':
        car.setSpeed(frontSpeed);
        car.setAngle(rDegrees);
        break;
        }
  }
}

/**
*This method is in charge of calculating the distance taken from the ultrasonic sensors and detecting if an eminent accident
* could or could not occure.
*/
boolean IsClear(int distance){
    if (distance > 20){
     //Serial.print(distance); 
     return true;
    }
    if (distance == 0){
        return true;
       }
     else{
        return false;
     }
 }
