import java.time.LocalDate;
import java.util.List;

public class Consultant extends Doctor {

    private List<String> consultationTypes;
    private boolean onlineConsultationAvailable;
    private int consultationDuration;

    public Consultant(String id, String firstName, String lastName, LocalDate dateOfBirth, String gender,
                      String phoneNumber, String email, String address, String doctorId, String specialization,
                      String qualification, int experienceYears, String departmentId, double consultationFee,
                      List<String> availableSlots, List<String> assignedPatients,
                      List<String> consultationTypes, boolean onlineConsultationAvailable, int consultationDuration) {

        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address,
                doctorId, specialization, qualification, experienceYears, departmentId,
                consultationFee, availableSlots, assignedPatients);
        this.consultationTypes = consultationTypes;
        this.onlineConsultationAvailable = onlineConsultationAvailable;
        this.consultationDuration = consultationDuration;
    }

    public List<String> getConsultationTypes() {
        return consultationTypes;
    }

    public void setConsultationTypes(List<String> consultationTypes) {
        this.consultationTypes = consultationTypes;
    }

    public boolean isOnlineConsultationAvailable() {
        return onlineConsultationAvailable;
    }

    public void setOnlineConsultationAvailable(boolean onlineConsultationAvailable) {
        this.onlineConsultationAvailable = onlineConsultationAvailable;
    }

    public int getConsultationDuration() {
        return consultationDuration;
    }

    public void setConsultationDuration(int consultationDuration) {
        this.consultationDuration = consultationDuration;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Consultation Types: " + consultationTypes);
        System.out.println("Online Consultation Available: " + onlineConsultationAvailable);
        System.out.println("Consultation Duration: " + consultationDuration + " minutes");
    }

    public void scheduleConsultation(String consultationType) {
        if (consultationTypes.contains(consultationType)) {
            System.out.println("Consultation of type '" + consultationType + "' scheduled successfully for " +
                    consultationDuration + " minutes.");
        } else {
            System.out.println("Consultation type not available for this consultant.");
        }
    }

    public void provideSecondOpinion(String patientId, String diagnosis) {
        System.out.println("Providing second opinion for patient ID: " + patientId);
        System.out.println("Reviewed diagnosis: " + diagnosis);
        System.out.println("Second opinion: Further tests recommended for detailed evaluation.");
    }
}
