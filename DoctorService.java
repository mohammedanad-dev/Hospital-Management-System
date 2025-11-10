import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class DoctorService {

    private static final ArrayList<Doctor> doctors = new ArrayList<>();

    // ===== Original methods (kept) =====
    public static void addDoctor(Doctor doctor) {
        if (doctor != null) {
            if (doctor.getAssignedPatients() == null) doctor.setAssignedPatients(new ArrayList<String>());
            if (doctor.getAvailableSlots() == null) doctor.setAvailableSlots(new ArrayList<String>());
            if (doctor.getDoctorId() == null || doctor.getDoctorId().trim().isEmpty()) {
                doctor.setDoctorId(generateDoctorId());
            }
            doctors.add(doctor);
            System.out.println("Doctor added successfully!");
        } else {
            System.out.println("Invalid doctor data.");
        }
    }

    public static void editDoctor(String doctorId, Doctor updatedDoctor) {
        for (int i = 0; i < doctors.size(); i++) {
            Doctor d = doctors.get(i);
            if (d.getDoctorId().equals(doctorId)) {
                doctors.set(i, updatedDoctor);
                System.out.println("Doctor updated successfully!");
                return;
            }
        }
        System.out.println("Doctor not found.");
    }

    public static void removeDoctor(String doctorId) {
        for (int i = 0; i < doctors.size(); i++) {
            if (doctors.get(i).getDoctorId().equals(doctorId)) {
                doctors.remove(i);
                System.out.println("Doctor removed successfully!");
                return;
            }
        }
        System.out.println("Doctor not found.");
    }

    public static Doctor getDoctorById(String doctorId) {
        for (Doctor d : doctors) {
            if (d.getDoctorId().equals(doctorId)) {
                return d;
            }
        }
        return null;
    }

    public static void displayAllDoctors() {
        if (doctors.isEmpty()) {
            System.out.println("No doctors found.");
        } else {
            System.out.println("=== All Doctors ===");
            for (Doctor d : doctors) {
                d.displayInfo();
                System.out.println("----------------------------");
            }
        }
    }

    public static void getDoctorsBySpecialization(String specialization) {
        boolean found = false;
        for (Doctor d : doctors) {
            if (d.getSpecialization() != null &&
                    d.getSpecialization().equalsIgnoreCase(specialization)) {
                d.displayInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No doctors found with specialization: " + specialization);
        }
    }

    public static void getAvailableDoctors() {
        boolean found = false;
        for (Doctor d : doctors) {
            if (d.getAvailableSlots() != null && !d.getAvailableSlots().isEmpty()) {
                System.out.println("Doctor " + d.getFirstName() + " " + d.getLastName() +
                        " is available. Slots: " + d.getAvailableSlots());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No available doctors found.");
        }
    }

    // ===== New overloads you asked for =====

    // addDoctor overloads
    public static void addDoctor(String name, String specialization, String phone) {
        Doctor d = buildMinimalDoctor(name, specialization, phone, 0.0);
        doctors.add(d);
        System.out.println("Doctor added (minimal): " + d.getDoctorId());
    }

    public static void addDoctor(String name, String specialization, String phone, double consultationFee) {
        Doctor d = buildMinimalDoctor(name, specialization, phone, consultationFee);
        doctors.add(d);
        System.out.println("Doctor added (with fee): " + d.getDoctorId());
    }

    // assignPatient overloads
    public static void assignPatient(String doctorId, String patientId) {
        Doctor d = getDoctorById(doctorId);
        if (d == null) {
            System.out.println("Doctor not found: " + doctorId);
            return;
        }
        ensureAssignedPatients(d);
        if (!d.getAssignedPatients().contains(patientId)) {
            d.getAssignedPatients().add(patientId);
            System.out.println("Assigned patient " + patientId + " to doctor " + doctorId);
        } else {
            System.out.println("Patient already assigned.");
        }
    }

    public static void assignPatient(Doctor doctor, Patient patient) {
        if (doctor == null || patient == null) {
            System.out.println("Invalid doctor or patient.");
            return;
        }
        ensureAssignedPatients(doctor);
        String pid = patient.getPatientId();
        if (!doctor.getAssignedPatients().contains(pid)) {
            doctor.getAssignedPatients().add(pid);
            System.out.println("Assigned patient " + pid + " to doctor " + doctor.getDoctorId());
        } else {
            System.out.println("Patient already assigned.");
        }
    }

    public static void assignPatient(String doctorId, List<String> patientIds) {
        Doctor d = getDoctorById(doctorId);
        if (d == null) {
            System.out.println("Doctor not found: " + doctorId);
            return;
        }
        ensureAssignedPatients(d);
        int added = 0;
        for (String pid : patientIds) {
            if (pid != null && !d.getAssignedPatients().contains(pid)) {
                d.getAssignedPatients().add(pid);
                added++;
            }
        }
        System.out.println("Bulk assigned " + added + " patient(s) to doctor " + doctorId);
    }

    // displayDoctors overloads
    public static void displayDoctors() {
        displayAllDoctors();
    }

    public static void displayDoctors(String specialization) {
        boolean found = false;
        System.out.println("=== Doctors (Specialization: " + specialization + ") ===");
        for (Doctor d : doctors) {
            if (d.getSpecialization() != null &&
                    d.getSpecialization().equalsIgnoreCase(specialization)) {
                d.displayInfo();
                System.out.println("----------------------------");
                found = true;
            }
        }
        if (!found) System.out.println("No doctors for specialization: " + specialization);
    }

    public static void displayDoctors(String departmentId, boolean showAvailableOnly) {
        boolean found = false;
        System.out.println("=== Doctors (Department: " + departmentId +
                ", AvailableOnly=" + showAvailableOnly + ") ===");
        for (Doctor d : doctors) {
            boolean deptOk = d.getDepartmentId() != null &&
                    d.getDepartmentId().equalsIgnoreCase(departmentId);
            boolean availOk = !showAvailableOnly ||
                    (d.getAvailableSlots() != null && !d.getAvailableSlots().isEmpty());
            if (deptOk && availOk) {
                d.displayInfo();
                System.out.println("Available slots: " +
                        (d.getAvailableSlots() == null ? "[]" : d.getAvailableSlots()));
                System.out.println("----------------------------");
                found = true;
            }
        }
        if (!found) System.out.println("No matching doctors found.");
    }

    // ===== Helpers =====
    private static Doctor buildMinimalDoctor(String name, String specialization, String phone, double fee) {
        String first = "";
        String last  = "";
        if (name != null) {
            String t = name.trim();
            int space = t.indexOf(' ');
            if (space >= 0) {
                first = t.substring(0, space);
                last  = t.substring(space + 1);
            } else {
                first = t;
            }
        }

        String id = "ID-" + (doctors.size() + 1); // Person.id
        String doctorId = generateDoctorId();
        LocalDate dob = null;
        String gender = null;
        String email = null;
        String address = null;
        String qualification = null;
        Integer experienceYears = 0;
        String departmentId = null;
        Double feeObj = fee;
        List<String> slots = new ArrayList<String>();
        List<String> assigned = new ArrayList<String>();

        return new Doctor(
                id, first, last, dob, gender,
                phone, email, address,
                doctorId, specialization, qualification,
                experienceYears, departmentId, feeObj,
                slots, assigned
        );
    }

    private static void ensureAssignedPatients(Doctor d) {
        if (d.getAssignedPatients() == null) d.setAssignedPatients(new ArrayList<String>());
    }

    private static String generateDoctorId() {
        int num = doctors.size() + 1;
        if (num < 10)  return "D00" + num;
        if (num < 100) return "D0"  + num;
        return "D" + num;
    }
}
