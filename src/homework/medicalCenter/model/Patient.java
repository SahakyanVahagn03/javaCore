package homework.medicalCenter.model;


import java.util.Date;

public class Patient extends Person {
    private Doctor doctor;

    private Date dateOfVisit;

    public Patient(String name, String surName, String phone, Date dateOfVisit, Doctor doctor) {
        setName(name);
        setSurName(surName);
        setPhone(phone);
        this.doctor = doctor;
        this.dateOfVisit = dateOfVisit;
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



    public Date getDateOfVisit() {
        return dateOfVisit;
    }

    public void setDateOfVisit(Date dateOfVisit) {
        this.dateOfVisit = dateOfVisit;
    }

    public String toString() {
        return "Patient {" +
                " id ='" + getId() + '\'' +
                " name ='" + getName() + '\'' +
                " surName ='" + getSurName() + '\'' +
                " phone ='" + getPhone() + '\'' +
                " doctor ='" + doctor.getName() + " " + doctor.getSurName() + '\'' +
                " ||date of visit= '" + dateOfVisit + '\'' +
                " } ";
    }
}
