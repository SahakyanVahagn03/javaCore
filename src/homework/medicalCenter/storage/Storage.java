package homework.medicalCenter.storage;

import homework.medicalCenter.model.Doctor;
import homework.medicalCenter.model.Patient;
import homework.medicalCenter.model.Person;

public class Storage {
    private Person[] array = new Person[10];
    private int size;

    public Storage() {
        size = -1;
    }

    public void add(Person val) {
        if (size == array.length) {

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
                if (patient.getDoctor() == doctor){
                    System.out.println(array[i]);
                }
            }
        }
    }

}
