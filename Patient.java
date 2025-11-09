import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.List;

public class Patient extends Person {
    private String patientId;
    private String bloodGroup;
    private List<String> allergies;
    private String emergencyContact;
    private LocalDate registrationDate;
    private String insuranceId;
    private List<String> medicalRecords;
    private List<String> appointments;

    public Patient(String id, String firstName, String lastName, LocalDate dateOfBirth, String gender, String phoneNumber, String email, String address, String patientId, String bloodGroup, List<String> allergies, String emergencyContact, LocalDate registrationDate, String insuranceId, List<String> medicalRecords, List<String> appointments) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address);
        this.patientId = patientId;
        this.bloodGroup = bloodGroup;
        this.allergies = allergies;
        this.emergencyContact = emergencyContact;
        this.registrationDate = registrationDate;
        this.insuranceId = insuranceId;
        this.medicalRecords = medicalRecords;
        this.appointments = appointments;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public List<String> getAllergies() {
        return allergies;
    }

    public void setAllergies(List<String> allergies) {
        this.allergies = allergies;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(String insuranceId) {
        this.insuranceId = insuranceId;
    }

    public List<String> getMedicalRecords() {
        return medicalRecords;
    }

    public void setMedicalRecords(List<String> medicalRecords) {
        this.medicalRecords = medicalRecords;
    }

    public List<String> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<String> appointments) {
        this.appointments = appointments;
    }

    public void addMedicalRecord(String record) {
        medicalRecords.add(record);
    }

    public void addAppointment(String appointment) {
        appointments.add(appointment);
    }

    public void updateInsurance(String newInsuranceId) {
        this.insuranceId = newInsuranceId;
    }

    @Override
    public void displayInfo() {
        super.displayInfo(); // Call parent details
        System.out.println("Patient ID: " + patientId);
        System.out.println("Blood Group: " + bloodGroup);
        System.out.println("Allergies: " + (allergies.isEmpty() ? "None" : allergies));
        System.out.println("Emergency Contact: " + emergencyContact);
        System.out.println("Registration Date: " + registrationDate);
        System.out.println("Insurance ID: " + insuranceId);
        System.out.println("Medical Records: " + (medicalRecords.isEmpty() ? "No records" : medicalRecords));
        System.out.println("Appointments: " + (appointments.isEmpty() ? "No appointments" : appointments));
    }

    @Override
    public String toString() {
        return super.toString() + "Patient{" +
                "patientId='" + patientId + '\'' +
                ", bloodGroup='" + bloodGroup + '\'' +
                ", allergies=" + allergies +
                ", emergencyContact='" + emergencyContact + '\'' +
                ", registrationDate=" + registrationDate +
                ", insuranceId='" + insuranceId + '\'' +
                ", medicalRecords=" + medicalRecords +
                ", appointments=" + appointments +
                '}';
    }
}
