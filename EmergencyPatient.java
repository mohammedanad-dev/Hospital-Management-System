import java.time.LocalDate;
import java.util.List;

public class EmergencyPatient extends InPatient {

    private String emergencyType;
    private String arrivalMode; // Ambulance or Walk-in
    private int triageLevel; // 1 to 5
    private boolean admittedViaER;

    public EmergencyPatient(String id, String firstName, String lastName, LocalDate dateOfBirth, String gender,
                            String phoneNumber, String email, String address, String patientId, String bloodGroup,
                            List<String> allergies, String emergencyContact, LocalDate registrationDate,
                            String insuranceId, List<String> medicalRecords, List<String> appointments,
                            LocalDate admissionDate, LocalDate dischargeDate, String roomNumber, String bedNumber,
                            String admittingDoctorId, double dailyCharges,
                            String emergencyType, String arrivalMode, int triageLevel, boolean admittedViaER) {

        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address, patientId, bloodGroup,
                allergies, emergencyContact, registrationDate, insuranceId, medicalRecords, appointments,
                admissionDate, dischargeDate, roomNumber, bedNumber, admittingDoctorId, dailyCharges);

        this.emergencyType = emergencyType;
        this.arrivalMode = arrivalMode;
        this.triageLevel = triageLevel;
        this.admittedViaER = admittedViaER;
    }

    public String getEmergencyType() {
        return emergencyType;
    }

    public void setEmergencyType(String emergencyType) {
        this.emergencyType = emergencyType;
    }

    public String getArrivalMode() {
        return arrivalMode;
    }

    public void setArrivalMode(String arrivalMode) {
        this.arrivalMode = arrivalMode;
    }

    public int getTriageLevel() {
        return triageLevel;
    }

    public void setTriageLevel(int triageLevel) {
        this.triageLevel = triageLevel;
    }

    public boolean isAdmittedViaER() {
        return admittedViaER;
    }

    public void setAdmittedViaER(boolean admittedViaER) {
        this.admittedViaER = admittedViaER;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Emergency Type: " + emergencyType);
        System.out.println("Arrival Mode: " + arrivalMode);
        System.out.println("Triage Level: " + triageLevel);
        System.out.println("Admitted via ER: " + admittedViaER);
        System.out.println("Priority Level: " + getPriorityDescription());
    }

    public String getPriorityDescription() {
        switch (triageLevel) {
            case 1: return "Critical – Immediate life-saving intervention required.";
            case 2: return "High – Severe condition, needs quick attention.";
            case 3: return "Moderate – Stable but needs care soon.";
            case 4: return "Low – Minor issue, can wait.";
            case 5: return "Non-Urgent – Routine or very minor condition.";
            default: return "Unknown triage level.";
        }
    }

    @Override
    public double calculateTotalCharges() {
        double baseCharges = super.calculateTotalCharges();
        double emergencyFee = 50.0;
        if (admittedViaER) {
            baseCharges += emergencyFee;
        }
        return baseCharges;
    }

    @Override
    public long calculateStayDuration() {
        long duration = super.calculateStayDuration();
        if (duration == 0 && admittedViaER) {
            return 1;
        }
        return duration;
    }
}
