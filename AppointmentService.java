package Service;

import java.time.LocalDate;
import java.util.ArrayList;

public class AppointmentService {

    private static ArrayList<Appointment> appointments = new ArrayList<>();

    public static void addAppointment(Appointment appointment) {
        if (appointment != null) {
            appointments.add(appointment);
            System.out.println("Appointment added successfully!");
        } else {
            System.out.println("Invalid appointment data.");
        }
    }

    public static void editAppointment(String appointmentId, Appointment updatedAppointment) {
        for (int i = 0; i < appointments.size(); i++) {
            Appointment a = appointments.get(i);
            if (a.getAppointmentId().equals(appointmentId)) {
                appointments.set(i, updatedAppointment);
                System.out.println("Appointment updated successfully!");
                return;
            }
        }
        System.out.println("Appointment not found.");
    }

    public static void removeAppointment(String appointmentId) {
        for (int i = 0; i < appointments.size(); i++) {
            if (appointments.get(i).getAppointmentId().equals(appointmentId)) {
                appointments.remove(i);
                System.out.println("Appointment removed successfully!");
                return;
            }
        }
        System.out.println("Appointment not found.");
    }

    public static Appointment getAppointmentById(String appointmentId) {
        for (Appointment a : appointments) {
            if (a.getAppointmentId().equals(appointmentId)) {
                return a;
            }
        }
        return null;
    }

    public static void displayAllAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments found.");
        } else {
            System.out.println("=== All Appointments ===");
            for (Appointment a : appointments) {
                a.displayInfo();
                System.out.println("----------------------------");
            }
        }
    }

    public static void getAppointmentsByPatient(String patientId) {
        boolean found = false;
        for (Appointment a : appointments) {
            if (a.getPatientId().equalsIgnoreCase(patientId)) {
                a.displayInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No appointments found for patient ID: " + patientId);
        }
    }

    public static void getAppointmentsByDoctor(String doctorId) {
        boolean found = false;
        for (Appointment a : appointments) {
            if (a.getDoctorId().equalsIgnoreCase(doctorId)) {
                a.displayInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No appointments found for doctor ID: " + doctorId);
        }
    }

    public static void getAppointmentsByDate(LocalDate date) {
        boolean found = false;
        for (Appointment a : appointments) {
            if (a.getAppointmentDate().equals(date)) {
                a.displayInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No appointments found on date: " + date);
        }
    }

    public static void rescheduleAppointment(String appointmentId, LocalDate newDate, String newTime) {
        for (Appointment a : appointments) {
            if (a.getAppointmentId().equals(appointmentId)) {
                a.setAppointmentDate(newDate);
                a.setAppointmentTime(newTime);
                a.setStatus("Rescheduled");
                System.out.println("Appointment rescheduled successfully!");
                return;
            }
        }
        System.out.println("Appointment not found.");
    }

    public static void cancelAppointment(String appointmentId) {
        for (Appointment a : appointments) {
            if (a.getAppointmentId().equals(appointmentId)) {
                a.setStatus("Cancelled");
                System.out.println("Appointment cancelled successfully!");
                return;
            }
        }
        System.out.println("Appointment not found.");
    }
}
