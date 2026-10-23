package ridecalendarservice;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class RideCalendarService {

    private final Ride[] rides = {
        new Ride("Summit Ave Hill Repeats", "Coach Elowen", 10),
        new Ride("Riverside Loop", "Thorne", 5),
        new Ride("Full Moon Night Ride", "Brask", 3),
        new Ride("Century Challenge", "Mira", 20),
        new Ride("Park Path Beginner Spin", "Pip", 1)
    };
    private final Queue<Ride> backlog = new ArrayDeque<>(Arrays.asList(rides));

    public int getRideCount() {
        return rides.length;
    }

    public Ride nextRide() {
        if (backlog.isEmpty()) {
            throw new IllegalStateException("no rides left in the backlog");
        }
        return backlog.remove();
    }
}
