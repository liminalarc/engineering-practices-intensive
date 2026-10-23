package farecalculator;

public class FareCalculator {

    public static int totalRevenue = 0;

    public int calculate(String type, int baseFare, int discount, boolean weekend, int level) {
        double fare = 0;
        if (baseFare <= 0) {
            return 0;
        }
        if (discount < 0) {
            discount = 0;
        }
        if (discount > 75) {
            discount = 75;
        }
        if (type == null) {
            type = "STANDARD";
        }
        if (type.equals("EBIKE")) {
            fare = baseFare;
            if (discount < 10) {
                fare = fare * 1.1;
            }
            fare = fare - discount;
        } else if (type.equals("KIDS")) {
            fare = baseFare * 0.9;
            fare = fare - discount;
        } else if (type.equals("TANDEM")) {
            fare = baseFare - discount / 2;
        } else if (type.equals("CARGO")) {
            fare = baseFare;
            if (weekend) {
                fare = fare * 1.25;
            }
            fare = fare - discount;
        } else {
            fare = baseFare - discount;
        }
        if (weekend && !type.equals("CARGO")) {
            fare = fare * 0.85;
        }
        if (Math.random() < 0.2) {
            if (level < 10) {
                fare = fare * 1.5;
            } else {
                fare = fare * 2;
            }
            System.out.println("SURGE! " + type + " for " + (int) fare);
        }
        int result = (int) fare;
        if (result < 1) {
            result = 1;
        }
        totalRevenue = totalRevenue + result;
        return result;
    }
}
