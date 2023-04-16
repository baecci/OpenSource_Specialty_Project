public class Car{
    String color;
    int speed;
    static int carCount = 0;
    final static int MAXSPEED = 200;
    final static int MINSPEED = 0;

    int getSpeed(){
        return speed;
    }

    static int currentCarCount(){
        return carCount;
    }

    void upSpeed(int value){
        if (speed + value >= 200)
            speed = 200;
        else
            speed += value;
    }

    void downSpeed(int value){
        if (speed - value <= 0)
            speed = 0;
        else
            speed -= value;
    }

    String getColor(){
        return color;
    }

    /* Method Overloading*/
    Car(String color, int speed){
        this.color = color;
        this.speed = speed;
        carCount++;
    }
    Car(int speed){
        this.speed = speed;
    }
    Car(){
    }
}
