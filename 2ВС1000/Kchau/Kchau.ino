void setup() {
  pinMode(5, OUTPUT);
  pinMode(6, OUTPUT);
  pinMode(7, OUTPUT);
  //Зачитуемо чорну лінію
  pinMode(A0, INPUT);
  pinMode(10, OUTPUT);
  pinMode(8, OUTPUT);
  pinMode(9, OUTPUT);
  //Зачитуемо чорну лінію
  pinMode(A0, INPUT);
} 

void loop() {
  //Задаємо швидкість
  analogWrite(10,120);
  //Задаємо напрям

  //Задаємо швидкість
  analogWrite(5, 120);
  //Задаємо напрям
   if ((digitalRead(A2) == 0) or (digitalRead(A1) == 0 and digitalRead(A3) == 0)) { // -чорне
    digitalWrite(6, 0);
    digitalWrite(7, 1);
    digitalWrite(8, 1);
    digitalWrite(9, 0);
    digitalWrite(5,100);
    digitalWrite(10,100);
  }
  else if (digitalRead(A1) == 0) { // -чорне
    digitalWrite(6, 0);
    digitalWrite(7, 1);
    digitalWrite(8, 1);
    digitalWrite(9, 0);
    // Поворот на лево
  }else if (digitalRead(A0) == 0) { // -чорне
    digitalWrite(6, 1);
    digitalWrite(7, 0);
    digitalWrite(8, 1);
    digitalWrite(9, 0);
    digitalWrite(5,100);
    digitalWrite(10,100);
    }
    //Поворот на леvo
  else if (digitalRead(A3) == 0) { // -чорне
    digitalWrite(6, 0);
    digitalWrite(7, 1);
    digitalWrite(8, 1);
    digitalWrite(9, 0);
    digitalWrite(5,100);
    digitalWrite(10,100);
  }
  else if (digitalRead(A4) == 0) { // -чорне
    digitalWrite(6, 0);
    digitalWrite(7, 1);
    digitalWrite(8, 0);
    digitalWrite(9, 1);
  }
  //else  {
    //digitalWrite(6, 0);
    //digitalWrite(7, 0);
    //digitalWrite(8, 0);
    //digitalWrite(9, 0);
  }
