package hr.algebra.pi.model;

import java.util.List;

public interface VehicleTransporter {
    List<VehicleSize> getTransportSlots(); // VehicleSize se odnosi na veličinu vozila i na veličinu transportnog mjesta
    boolean addVehicleForTransport(Transportable vehicle);
}
