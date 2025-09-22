import java.util.*;

class Main {
    public static void main(String[] args) {
        Hospital cityHospital = new Hospital("City Hospital", "City Hospital, Mathura (UP)");
        
        InPatient inPatient = new InPatient("01", "Manmohan Singh", 30, 1000, 10, 5000, 3);
        OutPatient outPatient = new OutPatient("02", "Bimar Aadmi", 25, 5, 2000);

        cityHospital.addRecord(inPatient);
        cityHospital.addRecord(outPatient);

        cityHospital.viewRecord("02");
    }
    static abstract class Patient {
        String patientID;
        String name;
        int age;

        Patient(String patientID, String name, int age) {
            this.patientID = patientID;
            this.name = name;
            this.age = age;
        }

        abstract int calculateBill();

        void getPatientDetails() {
            System.out.println("ID : " + patientID);
            System.out.println("Name : " + name);
            System.out.println("Age: " + age);
        }
    }

    static class InPatient extends Patient {
        int rent;
        int tax;
        int fee;
        int days;

        InPatient(String patientID, String name, int age, int rent, int tax, int fee, int days) {
            super(patientID, name, age);
            this.rent = rent;
            this.tax = tax;
            this.fee = fee;
            this.days = days;
        }

        int calculateBill() {
            int roomBill = days * rent;
            int finalTax = fee * tax / 100;
            int bill = fee + finalTax + roomBill;
            return bill;
        }
    }

    static class OutPatient extends Patient {
        int tax;
        int fee;

        OutPatient(String patientID, String name, int age, int tax, int fee) {
            super(patientID, name, age);
            this.tax = tax;
            this.fee = fee;
        }

        int calculateBill() {
            int finalTax = fee * tax / 100;
            int bill = fee + finalTax;
            return bill;
        }
    }

    static public interface MedicalRecord {
        public HashMap<String, ArrayList<Patient>> patientList = new HashMap<String, ArrayList<Patient>>();

        void addRecord(Patient id);

        void viewRecord(String id);
    }

    static class Hospital implements MedicalRecord {
        String Name;
        String Address;
        private ArrayList<Patient> MedicalHistory;

        Hospital(String name, String add) {
            this.Name = name;
            this.Address = add;
        }

        public void addRecord(Patient patient) {
            if (patientList.containsKey(patient.patientID)) {
                MedicalHistory = patientList.get(patient.patientID);
                MedicalHistory.add(patient);
            } else {
                MedicalHistory = new ArrayList<Patient>();
                patientList.put(patient.patientID, MedicalHistory);
            }
        }

        public void viewRecord(String id) {
            ArrayList<Patient> allPs = patientList.get(id);
            for (Patient i: allPs) {
                i.getPatientDetails();
                System.out.println("Total Bill : Rs. " + i.calculateBill());
            }
        }
    }
}