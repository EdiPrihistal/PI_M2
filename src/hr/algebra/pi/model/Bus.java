package hr.algebra.pi.model;

public class Bus extends Vehicle implements Transportable{
    public Bus() {
        super(VehicleSize.BIG);
    }

    @Override
    public double transportationFee() {
        return 70;
    }
}
