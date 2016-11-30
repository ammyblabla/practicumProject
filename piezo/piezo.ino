void setup()
{
  pinMode(PIN_PC3, INPUT);
  pinMode(PIN_PC4, INPUT);
  Serial.begin(9600*2);
}
void loop()
{
  printf("accelero: ");
  Serial.println(accel());
  printf("piezo: ");
  Serial.println(piezo());
}
int accel() {
   return analogRead(PIN_PC3);
}
float piezo() {
  int piezoADC = analogRead(PIN_PC4);
  return piezoADC * 5 / 1023.0 ;
}
int findMax(int input) {
  static max;
  if(input>0)
  {
    if(input>max)
    {
      
    }
  }
}

