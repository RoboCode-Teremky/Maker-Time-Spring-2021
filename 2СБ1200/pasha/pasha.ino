
void setup() {
  // put your setup code here, to run once:
  pinMode(5, OUTPUT);
  pinMode(6, OUTPUT);
  pinMode(7, OUTPUT);
  pinMode(8, OUTPUT);
  pinMode(9, OUTPUT);
  pinMode(10, OUTPUT);

}

void loop() {
  // put your main code here, to run repeatedly:
  if (digitalRead(A2) == 0)
  {
    analogWrite(5, 100);
    analogWrite(10, 100);
    digitalWrite(6, 0);
    digitalWrite(7, 1);
    digitalWrite(8, 1);
    digitalWrite(9, 0);
  }
  else if (digitalRead(A0) == 0 || digitalRead(A1) == 0 || digitalRead(A0) == 0 and digitalRead(A1) == 0) {
      digitalWrite(6, 0);
    digitalWrite(7, 1);
    digitalWrite(8, 0);
    digitalWrite(9, 1);
  }
}


\
