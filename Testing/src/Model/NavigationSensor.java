package Model;


import static Model.ObstacleDetection.ObstacleType.OPEN;
import static Model.ObstacleDetection.ObstacleType.STAIRS;

public class NavigationSensor {

    private FrontSensor frontSensor;
    private LeftSensor leftSensor;
    private RightSensor rightSensor;
    private BackSensor backSensor;
    private UnderSensor underSensor;

    public void CheckSensors() {
        int sensorNum = CheckFrontSensor();
        if (sensorNum == 0)
            //proceed forward
            return;
        else if (sensorNum == 1)
            //proceed left
            return;
        else if (sensorNum == 2)
            //proceed right
            return;
        else if (sensorNum == 3)
            //proceed backwards
            return;
        else if (sensorNum == 4)
            //Not sure what we would do here honestly, lol
            return;
        else if (sensorNum >= 5)
            //Stop cleaning
            return;

    }

    public int CheckFrontSensor() {
        int sensorNum = 0;

        frontSensor.run();
        if(frontSensor.equals(OPEN))
            return sensorNum;
        else {
            sensorNum+=1;
            return CheckLeftSensor(sensorNum);
        }
    }
    public int CheckLeftSensor(int sensorNum){
        leftSensor.run();
        if(leftSensor.equals(OPEN))
            return sensorNum;
        else {
            sensorNum+=1;
            return CheckRightSensor(sensorNum);
        }
    }
    public int CheckRightSensor(int sensorNum) {
        rightSensor.run();
        if(rightSensor.equals(OPEN))
            return sensorNum;
        else {
            sensorNum+=1;
            return CheckBackSensor(sensorNum);
        }
    }
    public int CheckBackSensor(int sensorNum) {
        backSensor.run();
        if(rightSensor.equals(OPEN))
            return sensorNum;
        else {
            sensorNum+=1;
            return CheckUnderSensor(sensorNum);
        }
    }
    public int CheckUnderSensor(int sensorNum) {
        underSensor.run();
        if(underSensor.equals(OPEN))
            return sensorNum;
        else if(underSensor.equals(STAIRS)) {
            //STOP CLEANING***
            System.out.println("stairs detected. Stopping...");
            return 5;
        }
        else {
            System.out.println("Unknown obstacle detected.  Stopping...");
            return 6;
        }
    }

}