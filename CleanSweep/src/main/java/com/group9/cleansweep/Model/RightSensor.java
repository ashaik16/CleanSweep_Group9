package java.com.group9.cleansweep.Model;

public class RightSensor {

    public ObstacleDetection.ObstacleType run() {
        ObstacleDetection obstacle = new ObstacleDetection();
        return obstacle.isObstacleDetected;
    }
}
