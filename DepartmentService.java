package Service;

import java.util.ArrayList;

public class DepartmentService {

    private static ArrayList<Department> departments = new ArrayList<>();

    public static void addDepartment(Department department) {
        if (department != null) {
            departments.add(department);
            System.out.println("Department added successfully!");
        } else {
            System.out.println("Invalid department data.");
        }
    }

    public static void editDepartment(String departmentId, Department updatedDepartment) {
        for (int i = 0; i < departments.size(); i++) {
            Department d = departments.get(i);
            if (d.getDepartmentId().equals(departmentId)) {
                departments.set(i, updatedDepartment);
                System.out.println("Department updated successfully!");
                return;
            }
        }
        System.out.println("Department not found.");
    }

    public static void removeDepartment(String departmentId) {
        for (int i = 0; i < departments.size(); i++) {
            if (departments.get(i).getDepartmentId().equals(departmentId)) {
                departments.remove(i);
                System.out.println("Department removed successfully!");
                return;
            }
        }
        System.out.println("Department not found.");
    }

    public static Department getDepartmentById(String departmentId) {
        for (Department d : departments) {
            if (d.getDepartmentId().equals(departmentId)) {
                return d;
            }
        }
        return null;
    }

    public static void displayAllDepartments() {
        if (departments.isEmpty()) {
            System.out.println("No departments found.");
        } else {
            System.out.println("=== All Departments ===");
            for (Department d : departments) {
                d.displayInfo();
                System.out.println("----------------------------");
            }
        }
    }

    public static void assignDoctorToDepartment(String doctorId, String departmentId) {
        Department department = getDepartmentById(departmentId);
        if (department != null) {
            if (department.getDoctors() == null) {
                department.setDoctors(new ArrayList<>());
            }
            department.getDoctors().add(doctorId);
            System.out.println("Doctor " + doctorId + " assigned to department " + departmentId + " successfully!");
        } else {
            System.out.println("Department not found.");
        }
    }
}
