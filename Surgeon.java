import java.time.LocalDate;
import java.util.List;

public class Surgeon extends Doctor {

    private int surgeriesPerformed;
    private List<String> surgeryTypes;
    private boolean operationTheatreAccess;

    public Surgeon(String id, String firstName, String lastName, LocalDate dateOfBirth, String gender,
                   String phoneNumber, String email, String address, String doctorId, String specialization,
                   String qualification, int experienceYears, String departmentId, double consultationFee,
                   List<String> availableSlots, List<String> assignedPatients,
                   int surgeriesPerformed, List<String> surgeryTypes, boolean operationTheatreAccess) {

        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address,
                doctorId, specialization, qualification, experienceYears, departmentId,
                consultationFee, availableSlots, assignedPatients);
        this.surgeriesPerformed = surgeriesPerformed;
        this.surgeryTypes = surgeryTypes;
        this.operationTheatreAccess = operationTheatreAccess;
    }

    public int getSurgeriesPerformed() {
        return surgeriesPerformed;
    }

    public void setSurgeriesPerformed(int surgeriesPerformed) {
        this.surgeriesPerformed = surgeriesPerformed;
    }

    public List<String> getSurgeryTypes() {
        return surgeryTypes;
    }

    public void setSurgeryTypes(List<String> surgeryTypes) {
        this.surgeryTypes = surgeryTypes;
    }

    public boolean isOperationTheatreAccess() {
        return operationTheatreAccess;
    }

    public void setOperationTheatreAccess(boolean operationTheatreAccess) {
        this.operationTheatreAccess = operationTheatreAccess;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Surgeries Performed: " + surgeriesPerformed);
        System.out.println("Surgery Types: " + surgeryTypes);
        System.out.println("Operation Theatre Access: " + operationTheatreAccess);
    }

    public void performSurgery(String surgeryType) {
        if (operationTheatreAccess) {
            System.out.println("Performing surgery: " + surgeryType);
            surgeriesPerformed++;
            if (!surgeryTypes.contains(surgeryType)) {
                surgeryTypes.add(surgeryType);
            }
        } else {
            System.out.println("Access denied. Surgeon does not have operation theatre access.");
        }
    }

    public void updateSurgeryCount(int additionalSurgeries) {
        if (additionalSurgeries > 0) {
            surgeriesPerformed += additionalSurgeries;
            System.out.println("Updated surgery count: " + surgeriesPerformed);
        } else {
            System.out.println("Invalid number of surgeries.");
        }
    }
}
