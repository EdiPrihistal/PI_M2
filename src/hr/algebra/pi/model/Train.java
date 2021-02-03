package hr.algebra.pi.model;

import java.util.ArrayList;
import java.util.List;

public class Train extends Vehicle implements VehicleTransporter {

    private final List<Transportable> transportingVehicles = new ArrayList<>();

    public Train(VehicleSize vehicleSize) {
        super(vehicleSize);
    }

    @Override
    public List<VehicleSize> getTransportSlots() {
        List<VehicleSize> transportSpaces = new ArrayList<>();
        switch (getVehicleSize()) {
            case SMALL:
                for (int i = 0; i < 8; i++) {
                    transportSpaces.add(VehicleSize.SMALL);
                }
                return transportSpaces;
            case BIG:
                for (int i = 0; i < 6; i++) {
                    transportSpaces.add(VehicleSize.BIG);
                }
                return transportSpaces;
            default:
                throw new IllegalStateException("Unexpected value: " + getVehicleSize());
        }
    }

    @Override
    public boolean addVehicleForTransport(Transportable vehicle) {
        long maxSlots = getTransportSlots().stream()
                .filter(vehicleSize ->
                        vehicleSize == vehicle.getVehicleSize())
                .count();
        long takenSlots = transportingVehicles.stream()
                .filter(transportable ->
                        transportable.getVehicleSize() == vehicle.getVehicleSize())
                .count();

        if (maxSlots > takenSlots) {
            transportingVehicles.add(vehicle);
            return true;
        }
        return false;
    }
}
