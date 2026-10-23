package riderservice;

public class RiderService {

    public Rider registerRider(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name is required");
        }
        int fitnessScore = 100 + (int) (Math.random() * 50);
        return new Rider(name, 1, fitnessScore, false);
    }
}
