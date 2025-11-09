import java.util.ArrayList;

public class PatientService {


    private static ArrayList<Patient> patients = new ArrayList<>();


    public static void addPatient(Patient patient) {
        if (patient != null) {
            patients.add(patient);
            System.out.println("Patient added successfully!");
        } else {
            System.out.println("Invalid patient data.");
        }
    }


    public static void editPatient(String patientId, Patient updatedPatient) {
        for (int i = 0; i < patients.size(); i++) {
            Patient p = patients.get(i);
            if (p.getPatientId().equals(patientId)) {
                patients.set(i, updatedPatient);
                System.out.println("Patient updated successfully!");
                return;
            }
        }
        System.out.println("Patient not found.");
    }


    public static void removePatient(String patientId) {
        for (int i = 0; i < patients.size(); i++) {
            if (patients.get(i).getPatientId().equals(patientId)) {
                patients.remove(i);
                System.out.println("Patient removed successfully!");
                return;
            }
        }
        System.out.println("Patient not found.");
    }


    public static Patient getPatientById(String patientId) {
        for (Patient p : patients) {
            if (p.getPatientId().equals(patientId)) {
                return p;
            }
        }
        return null;
    }


    public static void displayAllPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients found.");
        } else {
            System.out.println("=== All Patients ===");
            for (Patient p : patients) {
                p.displayInfo();
                System.out.println("----------------------------");
            }
        }
    }


    public static void searchPatientsByName(String name) {
        boolean found = false;
        for (Patient p : patients) {
            if (p.getFirstName().equalsIgnoreCase(name) ||
                    p.getLastName().equalsIgnoreCase(name)) {
                p.displayInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No patient found with the name: " + name);
        }
    }
}
