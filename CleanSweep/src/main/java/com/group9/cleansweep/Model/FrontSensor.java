package com.group9.cleansweep.Model;


public class FrontSensor {

    public ObstacleDetection.ObstacleType run() {
        ObstacleDetection obstacle = new ObstacleDetection();
        return obstacle.isObstacleDetected;
    }
}
