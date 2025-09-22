package JavaEncapsulation;
import java.util.*;

// Abstract class Patient
abstract class Patient {
    private String patientId;
    private String name;
    private int age;
    private String diagnosis;
    private String medicalHistory;
    
    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }
    
    // Getters and Setters
    public String getPatientId() { return patientId; }
    public void setPatientId(String patientId) { this.patientId = patientId; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public int getAge() { return age; }
    public void setAge(int age) { 
        if (age > 0) this.age = age; 
    }
    
    // Encapsulated sensitive data
    protected String getDiagnosis() { return diagnosis; }
    protected void setDiagnosis(String diagnosis) { this.diagnosis = diagnosis; }
    
    protected String getMedicalHistory() { return medicalHistory; }
    protected void setMedicalHistory(String medicalHistory) { this.medicalHistory = medicalHistory; }
    
    // Abstract method
    public abstract double calculateBill();
    
    // Concrete method
    public String getPatientDetails() {
        return "Patient ID: " + patientId + ", Name: " + name + 
               ", Age: " + age + ", Bill: $" + calculateBill();
    }
}

// Interface MedicalRecord
interface MedicalRecord {
    void addRecord(String record);
    List<String> viewRecords();
}

// InPatient class
class InPatient extends Patient implements MedicalRecord {
    private int daysAdmitted;
    private double dailyRate;
    private List<String> medicalRecords;
    
    public InPatient(String patientId, String name, int age, int daysAdmitted, double dailyRate) {
        super(patientId, name, age);
        this.daysAdmitted = daysAdmitted;
        this.dailyRate = dailyRate;
        this.medicalRecords = new ArrayList<>();
    }
    
    @Override
    public double calculateBill() {
        return daysAdmitted * dailyRate + 500; // Base facility charge
    }
    
    @Override
    public void addRecord(String record) {
        medicalRecords.add(new Date() + ": " + record);
    }
    
    @Override
    public List<String> viewRecords() {
        return new ArrayList<>(medicalRecords);
    }
    
    public int getDaysAdmitted() { return daysAdmitted; }
    public void setDaysAdmitted(int daysAdmitted) { this.daysAdmitted = daysAdmitted; }
    
    public double getDailyRate() { return dailyRate; }
    public void setDailyRate(double dailyRate) { this.dailyRate = dailyRate; }
}

// OutPatient class
class OutPatient extends Patient implements MedicalRecord {
    private int consultationCount;
    private double consultationFee;
    private List<String> medicalRecords;
    
    public OutPatient(String patientId, String name, int age, int consultationCount, double consultationFee) {
        super(patientId, name, age);
        this.consultationCount = consultationCount;
        this.consultationFee = consultationFee;
        this.medicalRecords = new ArrayList<>();
    }
    
    @Override
    public double calculateBill() {
        return consultationCount * consultationFee;
    }
    
    @Override
    public void addRecord(String record) {
        medicalRecords.add(new Date() + ": " + record);
    }
    
    @Override
    public List<String> viewRecords() {
        return new ArrayList<>(medicalRecords);
    }
    
    public int getConsultationCount() { return consultationCount; }
    public void setConsultationCount(int consultationCount) { this.consultationCount = consultationCount; }
    
    public double getConsultationFee() { return consultationFee; }
    public void setConsultationFee(double consultationFee) { this.consultationFee = consultationFee; }
}

public class HospitalPatientManagement {
    public static void displayPatientBilling(List<Patient> patients) {
        for (Patient patient : patients) {
            System.out.println(patient.getPatientDetails());
            
            if (patient instanceof MedicalRecord) {
                MedicalRecord record = (MedicalRecord) patient;
                record.addRecord("Initial consultation completed");
                System.out.println("Medical Records: " + record.viewRecords().size() + " entries");
            }
            System.out.println("---");
        }
    }
    
    public static void main(String[] args) {
        List<Patient> patients = new ArrayList<>();
        patients.add(new InPatient("IP001", "John Doe", 45, 5, 200));
        patients.add(new OutPatient("OP001", "Jane Smith", 30, 3, 100));
        
        displayPatientBilling(patients);
    }
}
