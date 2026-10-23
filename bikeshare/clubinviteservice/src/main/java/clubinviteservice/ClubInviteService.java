package clubinviteservice;

public class ClubInviteService {

    private final ClubNotifier notifier;

    public ClubInviteService(ClubNotifier notifier) {
        this.notifier = notifier;
    }

    public void inviteRider(String riderName) {
        if (riderName == null || riderName.isBlank()) {
            return;
        }

        notifier.sendInvite(riderName);
    }
}
