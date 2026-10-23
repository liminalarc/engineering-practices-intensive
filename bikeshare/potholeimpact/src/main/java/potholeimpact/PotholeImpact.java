package potholeimpact;

public class PotholeImpact {

    public int wear(int force, int tireRating, boolean suspension) {
        int damage = force - tireRating;
        if (suspension) {
            damage = damage / 2;
        }
        if (Math.random() < 0.2) {
            damage = damage * 2;
        }
        return Math.max(damage, 1);
    }
}
