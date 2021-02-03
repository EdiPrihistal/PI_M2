package hr.algebra.pi;

import hr.algebra.pi.model.*;

import java.util.*;
import java.util.stream.Stream;

public class Solid {
    // kreiranje zaposlenika i vlakova i vozila
    private static List<Employee> employees = Arrays.asList(new Employee(10), new Employee(11));
    private static List<VehicleTransporter> trains = Arrays.asList(new Train(VehicleSize.SMALL), new Train(VehicleSize.BIG));
    private static List<Transportable> transportables = new ArrayList<Transportable>( Arrays.asList(new Bus(), new Car(), new Truck(), new Van(), new Car(), new Van(), new Truck(), new Bus(), new Car(), new Car(), new Car(), new Truck(), new Bus(), new Bus(), new Car(), new Van()));


    public static void main(String[] args) {

        // popunjavanje vlakova
        trains.forEach(Solid::fillTransporter);

        employees.forEach(employee -> System.out.println(employee.toString() + "\n\tZarada: " + employee.calculateEarnings()));

    }

    private static void fillTransporter(VehicleTransporter transporter) {
        transporter.getTransportSlots().forEach(vehicleSize -> {
                    Employee selectedEmployee = employees.stream().min(Comparator.comparing(employee -> employee.getVehiclesTransported().stream().count())).get();
                    Optional<Transportable> selectedVehicle = transportables.stream().filter(transportable -> transportable.getVehicleSize() == vehicleSize).findFirst().map(transportable -> {
                        transportables.remove(transportable);
                        return transportable;
                    });
                    if (selectedVehicle.isPresent()) {
                        if (!selectedEmployee.addTransportedVehicle(selectedVehicle.get())) {
                            transportables.add(selectedVehicle.get());
                        }
                    }
                }
        );
    }
}
