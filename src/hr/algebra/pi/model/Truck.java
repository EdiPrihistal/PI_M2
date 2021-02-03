package hr.algebra.pi.model;

public class Truck extends Vehicle implements Transportable{
    public Truck() {
        super(VehicleSize.BIG);
    }

    @Override
    public double transportationFee() {
        return 90;
    }
}
