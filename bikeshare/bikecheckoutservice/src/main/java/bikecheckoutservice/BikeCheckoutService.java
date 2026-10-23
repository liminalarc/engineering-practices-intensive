package bikecheckoutservice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class BikeCheckoutService {

    private final RentalAudit audit;
    private final Map<Bike, String> checkedOut = new HashMap<>();

    public BikeCheckoutService(RentalAudit audit) {
        this.audit = audit;
    }

    public void checkOut(String rider, Bike bike) {
        Objects.requireNonNull(rider, "rider is required");
        Objects.requireNonNull(bike, "bike is required");
        checkedOut.put(bike, rider);
    }

    public List<Bike> bikesCheckedOutBy(String rider) {
        Objects.requireNonNull(rider, "rider is required");
        return checkedOut.entrySet().stream()
                .filter(e -> e.getValue().equals(rider))
                .map(Map.Entry::getKey)
                .toList();
    }

    public void returnBike(String rider, String bikeId) {
        Bike bike = bikesCheckedOutBy(rider).stream()
                .filter(b -> b.id().equals(bikeId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("no such bike: " + bikeId));
        checkedOut.remove(bike);
        audit.returned(rider, bike);
    }
}
