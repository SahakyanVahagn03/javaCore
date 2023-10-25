package homework.medicalCenter;

import homework.medicalCenter.command.Command;
import homework.medicalCenter.model.Doctor;
import homework.medicalCenter.model.Patient;
import homework.medicalCenter.model.Person;
import homework.medicalCenter.storage.Storage;
import homework.medicalCenter.util.DateUtil;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main implements Command {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Storage patientStorage = new Storage();
    private static final Storage doctorStorage = new Storage();


    private static void addDoctor() {
        System.out.println("please input Doctor's name");
        String name = scanner.nextLine();
        System.out.println("please input Doctor's surname");
        String surname = scanner.nextLine();
        System.out.println("please input Doctor's phone number, phone number must start with (0) and is must be Armenian phone number");
        String phone = scanner.nextLine();
        System.out.println("please input Doctor's profession");
        String profession = scanner.nextLine();
        System.out.println("please input Doctor's working time with any patients");
        String minute = scanner.nextLine();
        if (!DateUtil.isMinute(minute) || isPhoneNumberValid(phone)) {
            addDoctor();
        }
        Doctor doctor = new Doctor(name, surname, phone, profession, Integer.parseInt(minute));
        doctorStorage.add(doctor);
        System.out.println("Doctor already added");
    }

    private static boolean isPhoneNumberValid(String PhoneNumber) {
        Pattern pattern = Pattern.compile("^\\d{9}$");
        Matcher matcher = pattern.matcher(PhoneNumber);
        if (!matcher.matches()) System.err.println("invalid phone number, phone number must be 9 digits and only number");
        return !matcher.matches();
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
        if (isPhoneNumberValid(phone)){addPatient();}
        System.out.println("what are you time would you like to visit, write date like this MM/dd/yyyy | hh:mm");
        String date = scanner.nextLine();
        Date dateForVisit = null;
        try {
            dateForVisit = DateUtil.StringToDate(date);
        } catch (ParseException e) {
            System.out.println("invalid date");
            addPatient();
        }
        Patient patient = new Patient(name, surname, phone, dateForVisit, doctor);
        if (patientStorage.isValidDate(doctor, dateForVisit)) {
            patientStorage.add(patient);
        } else {
            System.err.println(dateForVisit.before(new Date()) ? "error: current time is earlier then time at this moment " : "error:that time already exist");
        }
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
        String phone = scanner.nextLine();
        if (!isPhoneNumberValid(phone)){changePersonById(person);}
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
            Command.printCommand();
            String command = scanner.nextLine();
            switch (command) {
                case EXIT:
                    isRun = false;
                    break;
                case FOR_ADD_DOCTOR:
                    addDoctor();
                    break;
                case SEARCH_DOCTOR_BY_PROFESSION:
                    searchDoctorByProfession();
                    break;
                case DELETE_DOCTOR_BY_ID:
                    deleteDoctorById();
                    break;
                case CHANGE_DOCTOR_BY_ID:
                    changeDoctorById();
                    break;
                case FOR_ADD_PATIENT:
                    addPatient();
                    break;
                case PRINT_ALL_PATIENT_OF_DOCTOR:
                    printAllPatientsOfDoctor();
                    break;
                case FOR_PRINT_ALL_PATIENTS:
                    patientStorage.print();
                    break;
                case FOR_PRINT_ALL_DOCTORS:
                    doctorStorage.print();
                    break;
                case CHANGE_PATENT_BY_ID:
                    changePatientById();
                    break;
                case DELETE_PATIENT_BY_ID:
                    deletePatientById();
                    break;
                default:
                    System.out.println("command is invalid.please try again");
            }
        }
    }
}
