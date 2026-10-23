package groupridequeueservice;

public interface RiderRepository {

    boolean hasRideLockout(String riderName);
}
