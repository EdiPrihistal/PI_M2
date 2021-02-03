package hr.algebra.pi.model;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private double earningPercentage;
    private List<Transportable> vehiclesTransported = new ArrayList<>();

    public Employee(double earningPercentage) {
        this.earningPercentage = earningPercentage;
    }

    public double getEarningPercentage() {
        return earningPercentage;
    }

    public void setEarningPercentage(double earningPercentage) {
        this.earningPercentage = earningPercentage;
    }

    public List<Transportable> getVehiclesTransported() {
        return vehiclesTransported;
    }

    public void setVehiclesTransported(List<Transportable> vehiclesTransported) {
        this.vehiclesTransported = vehiclesTransported;
    }

    public boolean addTransportedVehicle(Transportable transportable) {
        return vehiclesTransported.add(transportable);
    }

    public double calculateEarnings() {
        return vehiclesTransported.stream().mapToDouble(Transportable::transportationFee).sum();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "earningPercentage=" + earningPercentage +
                ", vehiclesTransported=" + vehiclesTransported +
                '}';
    }
}
