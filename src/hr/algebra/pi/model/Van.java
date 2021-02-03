package hr.algebra.pi.model;

public class Van extends Vehicle implements Transportable{
    public Van() {
        super(VehicleSize.SMALL);
    }

    @Override
    public double transportationFee() {
        return 80;
    }
}
