package Service;

import java.util.ArrayList;

public class NurseService {


    private static ArrayList<Nurse> nurses = new ArrayList<>();


    public static void addNurse(Nurse nurse) {
        if (nurse != null) {
            nurses.add(nurse);
            System.out.println("Nurse added successfully!");
        } else {
            System.out.println("Invalid nurse data.");
        }
    }


    public static void editNurse(String nurseId, Nurse updatedNurse) {
        for (int i = 0; i < nurses.size(); i++) {
            Nurse n = nurses.get(i);
            if (n.getNurseId().equals(nurseId)) {
                nurses.set(i, updatedNurse);
                System.out.println("Nurse updated successfully!");
                return;
            }
        }
        System.out.println("Nurse not found.");
    }


    public static void removeNurse(String nurseId) {
        for (int i = 0; i < nurses.size(); i++) {
            if (nurses.get(i).getNurseId().equals(nurseId)) {
                nurses.remove(i);
                System.out.println("Nurse removed successfully!");
                return;
            }
        }
        System.out.println("Nurse not found.");
    }


    public static Nurse getNurseById(String nurseId) {
        for (Nurse n : nurses) {
            if (n.getNurseId().equals(nurseId)) {
                return n;
            }
        }
        return null;
    }


    public static void displayAllNurses() {
        if (nurses.isEmpty()) {
            System.out.println("No nurses found.");
        } else {
            System.out.println("=== All Nurses ===");
            for (Nurse n : nurses) {
                n.displayInfo();
                System.out.println("----------------------------");
            }
        }
    }


    public static void getNursesByDepartment(String departmentId) {
        boolean found = false;
        for (Nurse n : nurses) {
            if (n.getDepartmentId().equalsIgnoreCase(departmentId)) {
                n.displayInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No nurses found in department: " + departmentId);
        }
    }

    public static void getNursesByShift(String shift) {
        boolean found = false;
        for (Nurse n : nurses) {
            if (n.getShift().equalsIgnoreCase(shift)) {
                n.displayInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No nurses found in shift: " + shift);
        }
    }
}
