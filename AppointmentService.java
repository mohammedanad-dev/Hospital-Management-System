import java.time.LocalDate;
import java.util.ArrayList;

public class AppointmentService {

    private static ArrayList<Appointment> appointments = new ArrayList<>();

    // ===== Original methods (kept) =====
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

    // ===== New overloaded methods =====

    // Create
    public static void createAppointment(String patientId, String doctorId, LocalDate date) {
        Appointment a = new Appointment(
                generateAppointmentId(), patientId, doctorId,
                date, null, "Scheduled", null, null
        );
        appointments.add(a);
        System.out.println("Appointment created: " + a.getAppointmentId());
    }

    public static void createAppointment(String patientId, String doctorId, LocalDate date, String time) {
        Appointment a = new Appointment(
                generateAppointmentId(), patientId, doctorId,
                date, time, "Scheduled", null, null
        );
        appointments.add(a);
        System.out.println("Appointment created: " + a.getAppointmentId());
    }

    public static void createAppointment(Appointment appointment) {
        if (appointment == null) {
            System.out.println("Invalid appointment.");
            return;
        }
        if (appointment.getAppointmentId() == null || appointment.getAppointmentId().trim().isEmpty()) {
            appointment.setAppointmentId(generateAppointmentId());
        }
        if (appointment.getStatus() == null || appointment.getStatus().trim().isEmpty()) {
            appointment.setStatus("Scheduled");
        }
        appointments.add(appointment);
        System.out.println("Appointment created: " + appointment.getAppointmentId());
    }

    // Reschedule
    public static void rescheduleAppointment(String appointmentId, LocalDate newDate) {
        Appointment a = getAppointmentById(appointmentId);
        if (a == null) {
            System.out.println("Appointment not found: " + appointmentId);
            return;
        }
        a.setAppointmentDate(newDate);
        a.setStatus("Rescheduled");
        System.out.println("Appointment rescheduled: " + appointmentId);
    }

    public static void rescheduleAppointment(Appointment appointment, LocalDate newDate, String newTime, String reason) {
        if (appointment == null) {
            System.out.println("Invalid appointment.");
            return;
        }
        appointment.setAppointmentDate(newDate);
        appointment.setAppointmentTime(newTime);
        appointment.setStatus("Rescheduled");
        if (reason != null && !reason.trim().isEmpty()) {
            String existing = appointment.getNotes();
            appointment.setNotes((existing == null || existing.isEmpty())
                    ? "Reschedule Reason: " + reason
                    : existing + " | Reschedule Reason: " + reason);
        }
        System.out.println("Appointment rescheduled: " + appointment.getAppointmentId());
    }

    // Display
    public static void displayAppointments(LocalDate date) {
        boolean found = false;
        System.out.println("=== Appointments on " + date + " ===");
        for (Appointment a : appointments) {
            if (a.getAppointmentDate() != null && a.getAppointmentDate().equals(date)) {
                a.displayInfo();
                System.out.println("----------------------------");
                found = true;
            }
        }
        if (!found) System.out.println("No appointments found on this date.");
    }

    public static void displayAppointments(String doctorId, LocalDate startDate, LocalDate endDate) {
        boolean found = false;
        System.out.println("=== Appointments for Doctor " + doctorId + " from " + startDate + " to " + endDate + " ===");
        for (Appointment a : appointments) {
            LocalDate d = a.getAppointmentDate();
            if (a.getDoctorId() != null &&
                    a.getDoctorId().equalsIgnoreCase(doctorId) &&
                    d != null && (!d.isBefore(startDate) && !d.isAfter(endDate))) {
                a.displayInfo();
                System.out.println("----------------------------");
                found = true;
            }
        }
        if (!found) System.out.println("No appointments found in this range.");
    }

    // ===== Helpers =====
    private static String generateAppointmentId() {
        int n = appointments.size() + 1;
        if (n < 10) return "A00" + n;
        if (n < 100) return "A0" + n;
        return "A" + n;
    }
}
