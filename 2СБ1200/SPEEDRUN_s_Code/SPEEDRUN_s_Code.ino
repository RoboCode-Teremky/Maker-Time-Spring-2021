void setup() {
  pinMode(A1, INPUT);
  pinMode(A2, INPUT);
  pinMode(A3, INPUT);
  pinMode(A4, INPUT);
  pinMode(A5, INPUT);
  pinMode(5, OUTPUT);
  pinMode(6, OUTPUT);
  pinMode(7, OUTPUT);
  pinMode(10, OUTPUT);
  pinMode(8, OUTPUT);
  pinMode(9, OUTPUT);
  analogWrite(5, 80);
  analogWrite(10, 80);
}


void loop() {
   //Forward(2)
  if (digitalRead(A2) > 0 && digitalRead(A0) > 0 && digitalRead(A1) > 0 && digitalRead(A3) > 0 && digitalRead(A4) > 0) {
    digitalWrite(6, 0);
    digitalWrite(7, 1);
    digitalWrite(8, 1);
    digitalWrite(9, 0);
  }
 
  //Forward
  else if ((digitalRead(A2) == 0) || (digitalRead(A0) == 0 && digitalRead(A1) == 0 && digitalRead(A2) == 0 && digitalRead(A3) == 0 && digitalRead(A4) == 0)) {
    digitalWrite(6, 0);
    digitalWrite(7, 1);
    digitalWrite(8, 1);
    digitalWrite(9, 0);
  }

  //Right
  else if ((digitalRead(A1) == 0) || (digitalRead(A0) == 0) || (digitalRead(A0) == 0 && digitalRead(A1) == 0)) {
    digitalWrite(6, 0);
    digitalWrite(7, 0);    
    digitalWrite(8, 1);
    digitalWrite(9, 0);
    
  }

  //Left(Help Pls)
  else if ((digitalRead(A4) == 0) || (digitalRead(A5) == 0) || (digitalRead(A4) == 0 && digitalRead(A5) == 0)) {
    digitalWrite(6, 0);
    digitalWrite(7, 1);
    digitalWrite(8, 0);
    digitalWrite(9, 0);

    
  }

}
