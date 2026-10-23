package bikecheckoutservice;


public interface RentalAudit {

    void returned(String rider, Bike bike);
}
