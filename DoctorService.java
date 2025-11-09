package Service;

import java.util.ArrayList;

public class DoctorService {


    private static ArrayList<Doctor> doctors = new ArrayList<>();


    public static void addDoctor(Doctor doctor) {
        if (doctor != null) {
            doctors.add(doctor);
            System.out.println("Doctor added successfully!");
        } else {
            System.out.println("Invalid doctor data.");
        }
    }


    public static void editDoctor(String doctorId, Doctor updatedDoctor) {
        for (int i = 0; i < doctors.size(); i++) {
            Doctor d = doctors.get(i);
            if (d.getDoctorId().equals(doctorId)) {
                doctors.set(i, updatedDoctor);
                System.out.println("Doctor updated successfully!");
                return;
            }
        }
        System.out.println("Doctor not found.");
    }


    public static void removeDoctor(String doctorId) {
        for (int i = 0; i < doctors.size(); i++) {
            if (doctors.get(i).getDoctorId().equals(doctorId)) {
                doctors.remove(i);
                System.out.println("Doctor removed successfully!");
                return;
            }
        }
        System.out.println("Doctor not found.");
    }


    public static Doctor getDoctorById(String doctorId) {
        for (Doctor d : doctors) {
            if (d.getDoctorId().equals(doctorId)) {
                return d;
            }
        }
        return null;
    }


    public static void displayAllDoctors() {
        if (doctors.isEmpty()) {
            System.out.println("No doctors found.");
        } else {
            System.out.println("=== All Doctors ===");
            for (Doctor d : doctors) {
                d.displayInfo();
                System.out.println("----------------------------");
            }
        }
    }


    public static void getDoctorsBySpecialization(String specialization) {
        boolean found = false;
        for (Doctor d : doctors) {
            if (d.getSpecialization().equalsIgnoreCase(specialization)) {
                d.displayInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No doctors found with specialization: " + specialization);
        }
    }

    public static void getAvailableDoctors() {
        boolean found = false;
        for (Doctor d : doctors) {
            if (d.getAvailableSlots() != null && !d.getAvailableSlots().isEmpty()) {
                System.out.println("Doctor " + d.getFirstName() + " " + d.getLastName() +
                        " is available. Slots: " + d.getAvailableSlots());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No available doctors found.");
        }
    }
}
