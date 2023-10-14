package homework.medicalCenter;

import homework.medicalCenter.model.Doctor;
import homework.medicalCenter.model.Patient;
import homework.medicalCenter.model.Person;
import homework.medicalCenter.storage.Storage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Storage patientStorage = new Storage();
    private static final Storage doctorStorage = new Storage();
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy | HH:mm:ss");

    private static void printCommand() {
        System.out.println("Please input 0 for EXIT");
        System.out.println("Please input 1 for ADD DOCTOR");
        System.out.println("Please input 2 for SEARCH DOCTOR BY PROFESSION");
        System.out.println("Please input 3 for DELETE DOCTOR BY ID");
        System.out.println("Please input 4 for CHANGE DOCTOR BY ID");
        System.out.println("Please input 5 for ADD PATIENT");
        System.out.println("Please input 6 for PRINT DOCTOR'S PATIENTS");
        System.out.println("Please input 7 for PRINT ALL PATIENT");
        System.out.println("Please input 8 for PRINT ALL DOCTORS");
        System.out.println("Please input 9 for CHANGE PATENT BY ID");
        System.out.println("Please input 10 for DELETE PATIENT BY ID");
    }

    private static void addDoctor() {
        System.out.println("please input Doctor's name");
        String name = scanner.nextLine();
        System.out.println("please input Doctor's surname");
        String surname = scanner.nextLine();
        System.out.println("please input Doctor's phone number");
        String phone = scanner.nextLine();
        System.out.println("please input Doctor's profession");
        String profession = scanner.nextLine();
        Doctor doctor = new Doctor(name, surname, phone, profession);
        doctorStorage.add(doctor);
        System.out.println("Doctor already added");
    }

    private static void searchDoctorByProfession() {
        System.out.println("please input Doctor's profession");
        doctorStorage.searchDoctorByProfession(scanner.nextLine());
    }

    private static void deleteDoctorById() {
        System.out.println("please input Doctor's ID");
        doctorStorage.delete(scanner.nextLine());
    }

    private static void changeDoctorById() {
        System.out.println("please input Doctor's ID");
        String doctorId = scanner.nextLine();
        Doctor doctor = (Doctor) doctorStorage.getObjectById(doctorId);
        if (doctor == null) {
            System.out.println("Person with " + doctorId + " doesn't exists!!!");
            return;
        }
        changePersonById(doctor);
    }

    private static void addPatient() {
        doctorStorage.print();
        System.out.println("write a doctor's  id");
        String doctorId = scanner.nextLine();
        Doctor doctor = (Doctor) doctorStorage.getObjectById(doctorId);
        if (doctor == null) {
            System.out.println("Person with " + doctorId + " doesn't exists!!!");
            return;
        }
        System.out.println("please input Patient's name");
        String name = scanner.nextLine();
        System.out.println("please input Patient's surname");
        String surname = scanner.nextLine();
        System.out.println("please input Patient's phone number");
        String phone = scanner.nextLine();
        Patient patient = new Patient(name, surname, phone, dtf.format(LocalDateTime.now()), doctor);
        patientStorage.add(patient);
    }

    private static void printAllPatientsOfDoctor() {
        doctorStorage.print();
        System.out.println("write a doctor's  id");
        String doctorId = scanner.nextLine();
        Doctor doctor = (Doctor) doctorStorage.getObjectById(doctorId);
        if (doctor == null) {
            System.out.println("Person with " + doctorId + " doesn't exists!!!");
            return;
        }
        patientStorage.printAllPatientsByDoctor(doctor);
    }


    private static void changePatientById() {
        System.out.println("please input Patient's ID");
        String patientId = scanner.nextLine();
        Patient patient = (Patient) patientStorage.getObjectById(patientId);
        if (patient == null) {
            System.out.println("Person with " + patientId + " doesn't exists!!!");
            return;
        }
        changePersonById(patient);
    }


    private static void changePersonById(Person person) {
        System.out.println("please input person's name");
        person.setName(scanner.nextLine());
        System.out.println("please input person's surname");
        person.setSurName(scanner.nextLine());
        System.out.println("please input person's phone number");
        person.setPhone(scanner.nextLine());
        if (person instanceof Doctor doctor) {
            System.out.println("please input person's profession");
            doctor.setProfession(scanner.nextLine());
            System.out.println("Doctor already changed");
        } else {
            Patient patient = (Patient) person;
            doctorStorage.print();
            System.out.println("write a doctor's  id for the change");
            patient.setDoctor((Doctor) doctorStorage.getObjectById(scanner.nextLine()));
            System.out.println("Patient already changed");
        }

    }


    private static void deletePatientById() {
        System.out.println("please input patient's ID");
        patientStorage.delete(scanner.nextLine());
    }


    public static void main(String[] args) {
        boolean isRun = true;
        while (isRun) {
            printCommand();
            String command = scanner.nextLine();
            switch (command) {
                case "0":
                    isRun = false;
                    break;
                case "1":
                    addDoctor();
                    break;
                case "2":
                    searchDoctorByProfession();
                    break;
                case "3":
                    deleteDoctorById();
                    break;
                case "4":
                    changeDoctorById();
                    break;
                case "5":
                    addPatient();
                    break;
                case "6":
                    printAllPatientsOfDoctor();
                    break;
                case "7":
                    patientStorage.print();
                    break;
                case "8":
                    doctorStorage.print();
                    break;
                case "9":
                    changePatientById();
                    break;
                case "10":
                    deletePatientById();
                    break;
                default:
                    System.out.println("command is invalid.please try again");
            }
        }
    }
}
