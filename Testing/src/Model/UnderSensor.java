package Model;

public class UnderSensor {

    public ObstacleDetection.ObstacleType run() {
        ObstacleDetection obstacle = new ObstacleDetection();
        return obstacle.isObstacleDetected;
    }
}
