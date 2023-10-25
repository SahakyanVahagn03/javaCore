package homework.medicalCenter.model;

import java.util.Objects;

public class Doctor extends Person{
    private String profession;
    private int doctorSTimeOfTheCheck;


    public Doctor(String name, String surName, String phone, String profession, int doctorSTimeOfTheCheck) {
        setId(String.valueOf(System.nanoTime()));
        setName(name);
        setSurName(surName);
        setPhone(phone);
        this.profession = profession;
        this.doctorSTimeOfTheCheck = doctorSTimeOfTheCheck;
    }

    public String getProfession() {
        return profession;
    }

    public int getDoctorSTimeOfTheCheck() {
        return doctorSTimeOfTheCheck;
    }

    public void setDoctorSTimeOfTheCheck(int doctorSTimeOfTheCheck) {
        this.doctorSTimeOfTheCheck = doctorSTimeOfTheCheck;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }


    @Override
    public String toString() {
        return "Doctor {" +
                " id ='" + getId() + '\'' +
                " name ='" + getName() + '\'' +
                " surName ='" + getSurName() + '\'' +
                " phone ='" + getPhone() + '\'' +
                " profession ='" + profession + '\'' +
                "  working time with any patients ='" + getDoctorSTimeOfTheCheck() + '\'' + "minute" +
                " } " ;
    }
}
