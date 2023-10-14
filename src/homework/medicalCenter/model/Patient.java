package homework.medicalCenter.model;


public class Patient extends Person {
    private Doctor doctor;
    private String date;

    public Patient(String name, String surName, String phone, String date, Doctor doctor) {
        setName(name);
        setSurName(surName);
        setPhone(phone);
        this.doctor = doctor;
        this.date = date;
        setId(String.valueOf(System.nanoTime()));
    }

    public Patient() {
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }


    public String toString() {
        return "Patient {" +
                " id ='" + getId() + '\'' +
                " name ='" + getName() + '\'' +
                " surName ='" + getSurName() + '\'' +
                " phone ='" + getPhone() + '\'' +
                " doctor ='" + doctor.getName() + " " + doctor.getSurName() + '\'' +
                " ||date of register ='" + date + '\'' +
                " } ";
    }
}
