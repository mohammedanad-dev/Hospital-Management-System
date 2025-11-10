import java.time.LocalDate;
import java.time.LocalDateTime;

public class Appointment {
    private String appointmentId;
    private String patientId;
    private String doctorId;
    private LocalDate appointmentDate;
    private String appointmentTime;
    private String status;
    private String reason;
    private String notes;

    public Appointment(String appointmentId, String patientId, String doctorId,
                       LocalDate appointmentDate, String appointmentTime,
                       String status, String reason, String notes) {
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.status = status;
        this.reason = reason;
        this.notes = notes;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    // ===== Overloaded Methods =====
    public void addNotes(String notes) {
        if (this.notes == null || this.notes.isEmpty()) {
            this.notes = notes;
        } else {
            this.notes += " | " + notes;
        }
        System.out.println("Note added: " + notes);
    }

    public void addNotes(String notes, String addedBy) {
        String entry = notes + " (added by " + addedBy + ")";
        if (this.notes == null || this.notes.isEmpty()) {
            this.notes = entry;
        } else {
            this.notes += " | " + entry;
        }
        System.out.println("Note added by " + addedBy + ": " + notes);
    }

    public void addNotes(String notes, String addedBy, LocalDateTime timestamp) {
        String entry = notes + " (added by " + addedBy + " at " + timestamp + ")";
        if (this.notes == null || this.notes.isEmpty()) {
            this.notes = entry;
        } else {
            this.notes += " | " + entry;
        }
        System.out.println("Note added by " + addedBy + " on " + timestamp + ": " + notes);
    }

    // ===== Existing Behavior =====
    public void reschedule(LocalDate newDate, String newTime) {
        this.appointmentDate = newDate;
        this.appointmentTime = newTime;
        this.status = "Rescheduled";
        System.out.println("Appointment " + appointmentId + " has been rescheduled to " +
                newDate + " at " + newTime + ".");
    }

    public void cancel(String cancellationNote) {
        this.status = "Cancelled";
        this.notes = cancellationNote;
        System.out.println("Appointment " + appointmentId + " has been cancelled.");
    }

    public void complete(String completionNote) {
        this.status = "Completed";
        this.notes = completionNote;
        System.out.println("Appointment " + appointmentId + " has been marked as completed.");
    }

    public void displayInfo() {
        System.out.println("---- Appointment Details ----");
        System.out.println("Appointment ID: " + appointmentId);
        System.out.println("Patient ID: " + patientId);
        System.out.println("Doctor ID: " + doctorId);
        System.out.println("Date: " + appointmentDate);
        System.out.println("Time: " + appointmentTime);
        System.out.println("Status: " + status);
        System.out.println("Reason: " + reason);
        System.out.println("Notes: " + notes);
        System.out.println("------------------------------");
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentId='" + appointmentId + '\'' +
                ", patientId='" + patientId + '\'' +
                ", doctorId='" + doctorId + '\'' +
                ", appointmentDate=" + appointmentDate +
                ", appointmentTime='" + appointmentTime + '\'' +
                ", status='" + status + '\'' +
                ", reason='" + reason + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}
