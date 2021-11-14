package com.group9.sensor_simulator;

import java.util.Random;


public class ObstacleSimulator {
    private static ObstacleSimulator obstacleSimulator_instance = null;
    private final Random random;
    private ObstacleSimulator(){random = new Random();
    }

    public static ObstacleSimulator getInstance(){
        if(obstacleSimulator_instance == null){
            obstacleSimulator_instance = new ObstacleSimulator();
        }
        return  obstacleSimulator_instance;
    }

    public Boolean getRandomObstacle(){

        return random.nextBoolean();
    }


}
