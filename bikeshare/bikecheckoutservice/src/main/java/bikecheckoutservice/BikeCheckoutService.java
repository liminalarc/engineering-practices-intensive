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

    public int getAvailableBikes(){
        return 11;
    }


}
