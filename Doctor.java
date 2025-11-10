import java.time.LocalDate;
import java.util.List;

public class Doctor extends Person {
    private String doctorId;
    private String specialization;
    private String qualification;
    private Integer experienceYears;
    private String departmentId;
    private Double consultationFee;
    private List<String> availableSlots;
    private List<String> assignedPatients;

    public Doctor(String id, String firstName, String lastName, LocalDate dateOfBirth, String gender,
                  String phoneNumber, String email, String address, String doctorId, String specialization,
                  String qualification, Integer experienceYears, String departmentId, Double consultationFee,
                  List<String> availableSlots, List<String> assignedPatients) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address);
        this.doctorId = doctorId;
        this.specialization = specialization;
        this.qualification = qualification;
        this.experienceYears = experienceYears;
        this.departmentId = departmentId;
        this.consultationFee = consultationFee;
        this.availableSlots = availableSlots;
        this.assignedPatients = assignedPatients;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public Integer getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(Integer experienceYears) {
        this.experienceYears = experienceYears;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public Double getConsultationFee() {
        return consultationFee;
    }

    public void setConsultationFee(Double consultationFee) {
        this.consultationFee = consultationFee;
    }

    public List<String> getAvailableSlots() {
        return availableSlots;
    }

    public void setAvailableSlots(List<String> availableSlots) {
        this.availableSlots = availableSlots;
    }

    public List<String> getAssignedPatients() {
        return assignedPatients;
    }

    public void setAssignedPatients(List<String> assignedPatients) {
        this.assignedPatients = assignedPatients;
    }

    public void assignPatient(String patientId) {
        if (!assignedPatients.contains(patientId)) {
            assignedPatients.add(patientId);
            System.out.println("Patient " + patientId + " assigned to Dr. " + getLastName());
        } else {
            System.out.println("Patient " + patientId + " is already assigned.");
        }
    }

    public void removePatient(String patientId) {
        if (assignedPatients.remove(patientId)) {
            System.out.println("Patient " + patientId + " removed from Dr. " + getLastName() + "'s list.");
        } else {
            System.out.println("Patient " + patientId + " not found in assigned list.");
        }
    }

    public void updateAvailability(List<String> newSlots) {
        this.availableSlots = newSlots;
        System.out.println("Availability updated for Dr. " + getLastName());
    }

    // ===== Overloaded Methods =====
    public void updateFee(double fee) {
        this.consultationFee = fee;
        System.out.println("Consultation fee updated to: " + fee + " OMR");
    }

    public void updateFee(double fee, String reason) {
        this.consultationFee = fee;
        System.out.println("Consultation fee updated to: " + fee + " OMR (Reason: " + reason + ")");
    }

    public void addAvailability(String slot) {
        if (!availableSlots.contains(slot)) {
            availableSlots.add(slot);
            System.out.println("Added available slot: " + slot);
        } else {
            System.out.println("Slot already exists: " + slot);
        }
    }

    public void addAvailability(List<String> slots) {
        int count = 0;
        for (String slot : slots) {
            if (!availableSlots.contains(slot)) {
                availableSlots.add(slot);
                count++;
            }
        }
        System.out.println(count + " new slot(s) added to availability.");
    }

    @Override
    public void displayInfo() {
        super.displayInfo(); // Display Person info
        System.out.println("Doctor ID: " + doctorId);
        System.out.println("Specialization: " + specialization);
        System.out.println("Qualification: " + qualification);
        System.out.println("Experience (Years): " + experienceYears);
        System.out.println("Department ID: " + departmentId);
        System.out.println("Consultation Fee: " + consultationFee + " OMR");
        System.out.println("Available Slots: " + (availableSlots.isEmpty() ? "No available slots" : availableSlots));
        System.out.println("Assigned Patients: " + (assignedPatients.isEmpty() ? "No patients assigned" : assignedPatients));
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctorId='" + doctorId + '\'' +
                ", specialization='" + specialization + '\'' +
                ", qualification='" + qualification + '\'' +
                ", experienceYears=" + experienceYears +
                ", departmentId='" + departmentId + '\'' +
                ", consultationFee=" + consultationFee +
                ", availableSlots=" + availableSlots +
                ", assignedPatients=" + assignedPatients +
                '}';
    }
}
