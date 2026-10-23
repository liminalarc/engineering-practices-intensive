package groupridequeueservice;

public class GroupRideQueueService {

    private final RiderRepository repository;

    public GroupRideQueueService(RiderRepository repository) {
        this.repository = repository;
    }

    public boolean canJoinRide(String riderName) {
        return !repository.hasRideLockout(riderName);
    }
}
