public class Automobile extends Car{
    int seatNum;

    int getSeaNum(){
        return seatNum;
    }

    void upSpeed(int value){
        if(speed + value >= 300)
            speed = 300;
        else
            speed += (int)value;
    }
}
