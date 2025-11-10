import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PatientService {

    private static ArrayList<Patient> patients = new ArrayList<>();

    // ----- Core CRUD -----
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
            if (p.getPatientId() != null && p.getPatientId().equals(patientId)) {
                patients.set(i, updatedPatient);
                System.out.println("Patient updated successfully!");
                return;
            }
        }
        System.out.println("Patient not found.");
    }

    public static void removePatient(String patientId) {
        for (int i = 0; i < patients.size(); i++) {
            Patient p = patients.get(i);
            if (p.getPatientId() != null && p.getPatientId().equals(patientId)) {
                patients.remove(i);
                System.out.println("Patient removed successfully!");
                return;
            }
        }
        System.out.println("Patient not found.");
    }

    public static Patient getPatientById(String patientId) {
        for (Patient p : patients) {
            if (p.getPatientId() != null && p.getPatientId().equals(patientId)) {
                return p;
            }
        }
        return null;
    }

    public static void displayAllPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients found.");
            return;
        }
        System.out.println("=== All Patients ===");
        for (Patient p : patients) {
            p.displayInfo();
            System.out.println("----------------------------");
        }
    }

    public static void searchPatientsByName(String name) {
        boolean found = false;
        for (Patient p : patients) {
            if ((p.getFirstName() != null && p.getFirstName().equalsIgnoreCase(name)) ||
                    (p.getLastName()  != null && p.getLastName().equalsIgnoreCase(name))) {
                p.displayInfo();
                System.out.println("----------------------------");
                found = true;
            }
        }
        if (!found) System.out.println("No patient found with the name: " + name);
    }

    // ----- Overloads -----
    public static void addPatient(String firstName, String lastName, String phone) {
        Patient p = buildMinimalPatient(firstName, lastName, phone, null, null);
        patients.add(p);
        System.out.println("Patient added (minimal): " + p.getPatientId());
    }

    public static void addPatient(String firstName, String lastName, String phone, String bloodGroup, String email) {
        Patient p = buildMinimalPatient(firstName, lastName, phone, bloodGroup, email);
        patients.add(p);
        System.out.println("Patient added (with blood group): " + p.getPatientId());
    }

    public static ArrayList<Patient> searchPatients(String keyword) {
        ArrayList<Patient> result = new ArrayList<>();
        if (keyword == null) return result;
        String q = keyword.trim().toLowerCase();
        if (q.isEmpty()) return result;

        for (Patient p : patients) {
            if (matchesKeyword(p, q)) result.add(p);
        }
        return result;
    }

    public static ArrayList<Patient> searchPatients(String firstName, String lastName) {
        ArrayList<Patient> result = new ArrayList<>();
        String f = firstName == null ? "" : firstName.trim().toLowerCase();
        String l = lastName  == null ? "" : lastName.trim().toLowerCase();

        for (Patient p : patients) {
            boolean fn = p.getFirstName() != null && p.getFirstName().toLowerCase().equals(f);
            boolean ln = p.getLastName()  != null && p.getLastName().toLowerCase().equals(l);

            if (!f.isEmpty() && !l.isEmpty()) {
                if (fn && ln) result.add(p);
            } else if (!f.isEmpty()) {
                if (fn) result.add(p);
            } else if (!l.isEmpty()) {
                if (ln) result.add(p);
            }
        }
        return result;
    }

    public static void displayPatients() {
        displayAllPatients();
    }

    public static void displayPatients(String filter) {
        List<Patient> list = searchPatients(filter);
        if (list.isEmpty()) {
            System.out.println("No patients matched filter: " + filter);
            return;
        }
        System.out.println("=== Patients (filtered: " + filter + ") ===");
        for (Patient p : list) {
            p.displayInfo();
            System.out.println("----------------------------");
        }
    }

    public static void displayPatients(int limit) {
        if (patients.isEmpty()) {
            System.out.println("No patients found.");
            return;
        }
        int end = Math.min(Math.max(limit, 0), patients.size());
        System.out.println("=== First " + end + " Patients ===");
        for (int i = 0; i < end; i++) {
            patients.get(i).displayInfo();
            System.out.println("----------------------------");
        }
    }

    // ----- Helpers -----
    private static Patient buildMinimalPatient(String firstName, String lastName, String phone,
                                               String bloodGroup, String email) {
        String personId  = "ID-" + (patients.size() + 1);
        String patientId = "P"  + String.format("%03d", patients.size() + 1);

        List<String> allergies      = new ArrayList<>();
        List<String> medicalRecords = new ArrayList<>();
        List<String> appointments   = new ArrayList<>();

        return new Patient(personId, firstName, lastName, null, null,
                phone, email, null, patientId, bloodGroup, allergies, null, LocalDate.now(), null, medicalRecords, appointments);
    }

    private static boolean matchesKeyword(Patient p, String q) {
        if (p == null) return false;
        if (contains(p.getFirstName(), q)) return true;
        if (contains(p.getLastName(), q)) return true;
        if (contains(p.getPhoneNumber(), q)) return true;
        if (contains(p.getEmail(), q)) return true;
        if (contains(p.getAddress(), q)) return true;
        if (contains(p.getPatientId(), q)) return true;
        if (contains(p.getBloodGroup(), q)) return true;
        if (contains(p.getEmergencyContact(), q)) return true;

        List<String> allergies = p.getAllergies();
        if (allergies != null) {
            for (String a : allergies) if (contains(a, q)) return true;
        }
        List<String> recs = p.getMedicalRecords();
        if (recs != null) {
            for (String r : recs) if (contains(r, q)) return true;
        }
        List<String> apps = p.getAppointments();
        if (apps != null) {
            for (String a : apps) if (contains(a, q)) return true;
        }
        return false;
    }

    private static boolean contains(String value, String q) {
        return value != null && q != null && value.toLowerCase().contains(q);
    }
}
