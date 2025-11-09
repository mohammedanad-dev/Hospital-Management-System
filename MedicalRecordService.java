package Service;

import java.util.ArrayList;

public class MedicalRecordService {

    private static ArrayList<MedicalRecord> records = new ArrayList<>();

    public static void addMedicalRecord(MedicalRecord record) {
        if (record != null) {
            records.add(record);
            System.out.println("Medical record added successfully!");
        } else {
            System.out.println("Invalid record data.");
        }
    }

    public static void editMedicalRecord(String recordId, MedicalRecord updatedRecord) {
        for (int i = 0; i < records.size(); i++) {
            MedicalRecord r = records.get(i);
            if (r.getRecordId().equals(recordId)) {
                records.set(i, updatedRecord);
                System.out.println("Medical record updated successfully!");
                return;
            }
        }
        System.out.println("Medical record not found.");
    }

    public static void removeMedicalRecord(String recordId) {
        for (int i = 0; i < records.size(); i++) {
            if (records.get(i).getRecordId().equals(recordId)) {
                records.remove(i);
                System.out.println("Medical record removed successfully!");
                return;
            }
        }
        System.out.println("Medical record not found.");
    }

    public static MedicalRecord getMedicalRecordById(String recordId) {
        for (MedicalRecord r : records) {
            if (r.getRecordId().equals(recordId)) {
                return r;
            }
        }
        return null;
    }

    public static void displayAllRecords() {
        if (records.isEmpty()) {
            System.out.println("No medical records found.");
        } else {
            System.out.println("=== All Medical Records ===");
            for (MedicalRecord r : records) {
                r.displayInfo();
                System.out.println("----------------------------");
            }
        }
    }

    public static void getRecordsByPatientId(String patientId) {
        boolean found = false;
        for (MedicalRecord r : records) {
            if (r.getPatientId().equalsIgnoreCase(patientId)) {
                r.displayInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No records found for patient ID: " + patientId);
        }
    }

    public static void getRecordsByDoctorId(String doctorId) {
        boolean found = false;
        for (MedicalRecord r : records) {
            if (r.getDoctorId().equalsIgnoreCase(doctorId)) {
                r.displayInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No records found for doctor ID: " + doctorId);
        }
    }

    public static void displayPatientHistory(String patientId) {
        boolean found = false;
        System.out.println("=== Medical History for Patient ID: " + patientId + " ===");
        for (MedicalRecord r : records) {
            if (r.getPatientId().equalsIgnoreCase(patientId)) {
                System.out.println("Visit Date: " + r.getVisitDate());
                System.out.println("Doctor ID: " + r.getDoctorId());
                System.out.println("Diagnosis: " + r.getDiagnosis());
                System.out.println("Prescription: " + r.getPrescription());
                System.out.println("Notes: " + r.getNotes());
                System.out.println("----------------------------");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No history found for this patient.");
        }
    }
}
