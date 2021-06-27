void setup() {
  // put your setup code here, to run once:
  pinMode(5, OUTPUT);
  pinMode(6, OUTPUT);
  pinMode(7, OUTPUT);
  pinMode(8, OUTPUT);
  pinMode(9, OUTPUT);
  pinMode(10, OUTPUT);
  pinMode(A0, INPUT);
  pinMode(A1, INPUT);
  pinMode(A2, INPUT);
  pinMode(A3, INPUT);
  pinMode(A4, INPUT);
}
void loop() {
  analogWrite(5, 200);
  analogWrite(10, 200);
  //pravo
  /*if (digitalRead(A3) == 0) {
    digitalWrite(6, 1);
    digitalWrite(7, 0);
    digitalWrite(8, 1);
    digitalWrite(9, 0);
  }

  //}
  //vpered
  if (digitalRead(A2) == 0) {
    digitalWrite(6, 0);
    digitalWrite(7, 1);
    digitalWrite(8, 1);
    digitalWrite(9, 0);
  }

  //levo
  if (digitalRead(A3) == 0) {
    digitalWrite(6, 0);
    digitalWrite(7, 1);
    digitalWrite(8, 0);
    digitalWrite(9, 1);

  }

  //nazad
  if (digitalRead(A3) == 0) {
    digitalWrite(6, 0);
    digitalWrite(7, 1);
    digitalWrite(8, 1);
    digitalWrite(9, 0);



  }

*/
  if ((digitalRead(A2) == 0) || (digitalRead(A1) == 0 and digitalRead(A2) == 0 and
                                 digitalRead(A0) == 0 and digitalRead(A3) == 0 and digitalRead(A4) == 0))
  {
    //vpered
    digitalWrite(6, 0);
    digitalWrite(7, 1);
    digitalWrite(8, 1);
    digitalWrite(9, 0);
  }
  else
  {
    if(  digitalRead(A3) == 0 or   digitalRead(A4) == 0 or (  digitalRead(A3) == 0 and   digitalRead(A4)== 0))
  {

    digitalWrite(6, 0);
    digitalWrite(7, 1);
    digitalWrite(8, 0);
    digitalWrite(9, 1);
  }
  else
  {
        if(  digitalRead(A0) == 0 or   digitalRead(A1) == 0 or (  digitalRead(A0) == 0 and   digitalRead(A1)== 0))
        { 
          digitalWrite(6, 1);

        
    digitalWrite(7, 0);
    digitalWrite(8, 1);
    digitalWrite(9, 0);
  }
  
}
}}
