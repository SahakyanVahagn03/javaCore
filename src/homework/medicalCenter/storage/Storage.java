package homework.medicalCenter.storage;

import homework.medicalCenter.model.Doctor;
import homework.medicalCenter.model.Patient;
import homework.medicalCenter.model.Person;

import java.util.Date;

public class Storage {
    private Person[] array = new Person[10];
    private int size;

    private void extend() {
        Person[] tamp = new Person[array.length + 10];
        if (size >= 0) System.arraycopy(array, 0, tamp, 0, size);
        array = tamp;
    }

    public Storage() {
        size = -1;
    }

    public void add(Person val) {
        if (size == array.length) {
            extend();
        }
        array[++size] = val;
    }

    public void print() {
        for (int i = 0; i <= size; i++) {
            System.out.println(array[i]);
        }
    }

    public void searchDoctorByProfession(String profession) {
        if (array[0] instanceof Doctor) {
            for (int i = 0; i <= size; i++) {
                Doctor doctor = (Doctor) array[i];
                if (doctor.getProfession().equals(profession)) {
                    System.out.println(doctor);
                }
            }
        }
    }


    public void delete(String id) {
        for (int i = 0; i < size; i++) {
            if (array[i].getId().equals(id)) {
                for (int j = i; j < size; j++) {
                    array[j] = array[j + 1];
                }
                break;
            }
        }
        array[size] = null;
        size--;
    }

    public Person getObjectById(String id) {
        for (int i = 0; i <= size; i++) {
            if (array[i].getId().equals(id)) {
                return array[i];
            }
        }
        return null;
    }

    public void printAllPatientsByDoctor(Doctor doctor) {
        if (array[0] instanceof Patient) {
            for (int i = 0; i <= size; i++) {
                Patient patient = (Patient) array[i];
                if (patient.getDoctor() == doctor) {
                    System.out.println(array[i]);
                }
            }
        }
    }

    public Date patientSVisit(Doctor doctor, Date dateOfTheRegister) {
        if (array[0] instanceof Patient) {
            for (int i = 0; i <= size; i++) {
                Patient patient = (Patient) array[i];
                if (checkForVisit(doctor, dateOfTheRegister, patient)) {
                    System.out.println("that time, patient is already exist");
                    return null;
                }
            }
        }
        return dateOfTheRegister;
    }


    private boolean checkForVisit(Doctor doctor, Date dateOfTheRegister, Patient patient) {
        return patient.getDoctor() == doctor && patient.getDateOfVisit().getTime() > dateOfTheRegister.getTime()
                - patient.getDoctor().getDoctorSTimeOfTheCheck();
    }
}
