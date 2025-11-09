import java.time.LocalDate;
import java.util.List;

public class OutPatient extends Patient {

    private int visitCount;
    private LocalDate lastVisitDate;
    private String preferredDoctorId;

    public OutPatient(String id, String firstName, String lastName, LocalDate dateOfBirth, String gender,
                      String phoneNumber, String email, String address, String patientId, String bloodGroup,
                      List<String> allergies, String emergencyContact, LocalDate registrationDate, String insuranceId,
                      List<String> medicalRecords, List<String> appointments,
                      int visitCount, LocalDate lastVisitDate, String preferredDoctorId) {

        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address,
                patientId, bloodGroup, allergies, emergencyContact, registrationDate,
                insuranceId, medicalRecords, appointments);
        this.visitCount = visitCount;
        this.lastVisitDate = lastVisitDate;
        this.preferredDoctorId = preferredDoctorId;
    }

    public int getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(int visitCount) {
        this.visitCount = visitCount;
    }

    public LocalDate getLastVisitDate() {
        return lastVisitDate;
    }

    public void setLastVisitDate(LocalDate lastVisitDate) {
        this.lastVisitDate = lastVisitDate;
    }

    public String getPreferredDoctorId() {
        return preferredDoctorId;
    }

    public void setPreferredDoctorId(String preferredDoctorId) {
        this.preferredDoctorId = preferredDoctorId;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Visit Count: " + visitCount);
        System.out.println("Last Visit Date: " + lastVisitDate);
        System.out.println("Preferred Doctor ID: " + preferredDoctorId);
    }

    public void scheduleFollowUp(LocalDate nextVisitDate) {
        System.out.println("Follow-up appointment scheduled for " + nextVisitDate +
                " with Doctor ID: " + preferredDoctorId);
    }

    public void updateVisitCount() {
        visitCount++;
        lastVisitDate = LocalDate.now();
        System.out.println("Visit count updated to " + visitCount +
                ". Last visit date set to " + lastVisitDate + ".");
    }
}
