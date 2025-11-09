import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Department {

    private String departmentId;
    private String departmentName;
    private String headDoctorId;
    private List<String> doctors;
    private List<String> nurses;
    private int bedCapacity;
    private int availableBeds;


    public Department(String departmentId, String departmentName, String headDoctorId,
                      int bedCapacity, int availableBeds) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.headDoctorId = headDoctorId;
        this.bedCapacity = bedCapacity;
        this.availableBeds = availableBeds;
        this.doctors = new ArrayList<>();
        this.nurses = new ArrayList<>();
    }


    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getHeadDoctorId() {
        return headDoctorId;
    }

    public void setHeadDoctorId(String headDoctorId) {
        this.headDoctorId = headDoctorId;
    }

    public List<String> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<String> doctors) {
        this.doctors = doctors;
    }

    public List<String> getNurses() {
        return nurses;
    }

    public void setNurses(List<String> nurses) {
        this.nurses = nurses;
    }

    public int getBedCapacity() {
        return bedCapacity;
    }

    public void setBedCapacity(int bedCapacity) {
        this.bedCapacity = bedCapacity;
    }

    public int getAvailableBeds() {
        return availableBeds;
    }

    public void setAvailableBeds(int availableBeds) {
        this.availableBeds = availableBeds;
    }




    public void assignDoctor(String doctorId) {
        if (!doctors.contains(doctorId)) {
            doctors.add(doctorId);
            System.out.println("Doctor " + doctorId + " assigned to Department: " + departmentName);
        } else {
            System.out.println("Doctor " + doctorId + " is already assigned to this department.");
        }
    }


    public void assignNurse(String nurseId) {
        if (!nurses.contains(nurseId)) {
            nurses.add(nurseId);
            System.out.println("Nurse " + nurseId + " assigned to Department: " + departmentName);
        } else {
            System.out.println("Nurse " + nurseId + " is already assigned to this department.");
        }
    }


    public void updateBedAvailability(int newAvailableBeds) {
        if (newAvailableBeds <= bedCapacity && newAvailableBeds >= 0) {
            this.availableBeds = newAvailableBeds;
            System.out.println("Updated bed availability: " + availableBeds + "/" + bedCapacity);
        } else {
            System.out.println("Invalid bed update! Must be between 0 and " + bedCapacity);
        }
    }


    public void displayInfo() {
        System.out.println("---- Department Details ----");
        System.out.println("Department ID: " + departmentId);
        System.out.println("Department Name: " + departmentName);
        System.out.println("Head Doctor ID: " + headDoctorId);
        System.out.println("Doctors Assigned: " + (doctors.isEmpty() ? "None" : doctors));
        System.out.println("Nurses Assigned: " + (nurses.isEmpty() ? "None" : nurses));
        System.out.println("Bed Capacity: " + bedCapacity);
        System.out.println("Available Beds: " + availableBeds);
        System.out.println("-----------------------------");
    }


    @Override
    public String toString() {
        return "Department{" +
                "departmentId='" + departmentId + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", headDoctorId='" + headDoctorId + '\'' +
                ", doctors=" + doctors +
                ", nurses=" + nurses +
                ", bedCapacity=" + bedCapacity +
                ", availableBeds=" + availableBeds +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(departmentId, that.departmentId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(departmentId);
    }
}