package routehazardservice;

public class RouteHazardService {

    private final HazardNotifier notifier;

    public RouteHazardService(HazardNotifier notifier) {
        this.notifier = notifier;
    }

    public void reportHazard(String hazardName, boolean alertRiders) {
        if (alertRiders) {
            notifier.sendWarning("Hazard ahead: " + hazardName);
        }
    }
}
