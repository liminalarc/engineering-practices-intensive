package riderservice;

public class RiderService {

    public Rider registerRider(String name) {
        var logger = new Logger();

        if (name == null || name.isBlank()) {
            logger.log("Failed rider registration: invalid name");
            return null;
        }

        int fitnessScore = 100 + (int) (Math.random() * 50);
        var rider = new Rider(name, 1, fitnessScore, false);

        logger.log("Rider registered: " + name);

        return rider;
    }
}
