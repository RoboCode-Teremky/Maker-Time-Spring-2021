void setup() {
  // put your setup code here, to run once:
  pinMode(5, OUTPUT);
  pinMode(6, OUTPUT);
  pinMode(7, OUTPUT);
  pinMode(A0, INPUT);

  pinMode(8, OUTPUT);
  pinMode(9, OUTPUT);
  pinMode(10, OUTPUT);
  pinMode(A1, INPUT);
  pinMode(A2, INPUT);
  pinMode(A3, INPUT);
  pinMode(A4, INPUT);
analogWrite(5, 145);
  analogWrite(10, 145);
}

void loop() {
  
 

  // if (digitalRead(A0) == 0) {} //0 - чорне,1 - біле
  // if (digitalRead(A0) == 0) {} //0 - чорне,1 - біле

  //назад
  /* digitalWrite(6, 0);
    digitalWrite(7, 1);
    digitalWrite(9, 1);
    digitalWrite(8, 0);
    delay(1000);*/

  //вперед
   if (digitalRead(A2) == 0 or (digitalRead(A1)==0 and digitalRead(A3)==0) or (digitalRead(A0)==0 and digitalRead(A4)==0) or(analogRead(A0)==0 and analogRead(A3)==0) or (analogRead(A1)==0 and analogRead(A4)==0))  {
    digitalWrite(6, 0);
    digitalWrite(7, 1);
    digitalWrite(8, 1);
    digitalWrite(9, 0);
    //speed
    analogWrite(5, 255);
  analogWrite(10, 255);
    //delay(1000);
  }

  //ліво
  else if (digitalRead(A0) == 0 or digitalRead(A1) == 0) {
    digitalWrite(6, 1);
    digitalWrite(7, 0);
    digitalWrite(8, 1);
    digitalWrite(9, 0);
    //speed
    analogWrite(5, 105);
  analogWrite(10, 105);
    //delay(1000);
  }
  //вправо
  else if (digitalRead(A3) == 0 or digitalRead(A4) == 0) {
    digitalWrite(6, 0);
    digitalWrite(7, 1);
    digitalWrite(8, 0);
    digitalWrite(9, 1);
    analogWrite(5, 105);
  analogWrite(10, 105);
   // delay(1000);
  }
   /*if(1==1) {
    digitalWrite(6, 0);
    digitalWrite(7, 0);
    digitalWrite(9, 0);
    digitalWrite(8, 0);
  }*/

}
