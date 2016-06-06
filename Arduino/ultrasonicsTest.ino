/**
 *@author Group Ella
*/
/**
 *This class represents the implementation of both forward and backward collision check
 * by using ultrasonic sensors
*/  

//importing Smartcar library
#include <Smartcar.h>
//defining of the trigger, echo pins for the 2 ultrasonic sensors
#define trigPin1 5
#define echoPin1 6
#define trigPin2 9
#define echoPin2 10

//declaring calculation of the distances for the 2 ultrasonic sensors
//implementing the collision check feature
long duration, distance,BackSensor,FrontSensor;

//declaring car components
Car car;
Odometer encoderLeft, encoderRight;
Gyroscope gyro;

//declaring variables for the car movement
int frontSpeed = 40;
int backSpeed = -40;
int lDegrees = -70;
int rDegrees = -70;

//declaring of the buzzer's pin
int buzzer = 0;

/**
 * This method implements the car components connections and starting up
*/
void setup()
{
Serial.begin (9600);
pinMode(trigPin1, OUTPUT);
pinMode(echoPin1, INPUT);
pinMode(trigPin2, OUTPUT);
pinMode(echoPin2, INPUT);
encoderLeft.attach(2);
encoderRight.attach(3);
gyro.begin();
car.begin(encoderLeft, encoderRight, gyro);
pinMode(buzzer, 0);
}
/**
 * This methods implements looping for distacne calculation for two ultrasonic sensors
*/ 
void loop() {
  
SonarSensor(trigPin1, echoPin1);
FrontSensor = distance;
Serial.print(FrontSensor);
delay(500);
Serial.print('-');

distance = 0;
duration = 0;
SonarSensor(trigPin2, echoPin2);
BackSensor = distance;
Serial.print(BackSensor);
delay(500);
Serial.println(' ');
distance = 0;
duration = 0;
}
/**
 * This method implements the distance calculation of two ultrasonic sensors
*/
void SonarSensor(int trigPin,int echoPin)
{
digitalWrite(trigPin, LOW);
delayMicroseconds(2);
digitalWrite(trigPin, HIGH);
delayMicroseconds(10);
digitalWrite(trigPin, LOW);
duration = pulseIn(echoPin, HIGH);
distance = (duration/2) / 29.1;
}
