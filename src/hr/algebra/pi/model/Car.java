package hr.algebra.pi.model;

public class Car extends Vehicle implements Transportable{
    public Car() {
        super(VehicleSize.SMALL);
    }

    @Override
    public double transportationFee() {
        return 50;
    }
}
