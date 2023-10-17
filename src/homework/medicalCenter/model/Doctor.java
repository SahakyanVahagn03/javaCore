package homework.medicalCenter.model;

public class Doctor extends Person{
    private String profession;
    private long doctorSTimeOfTheCheck;


    public Doctor(String name, String surName, String phone, String profession, long doctorSTimeOfTheCheck) {
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

    public long getDoctorSTimeOfTheCheck() {
        return doctorSTimeOfTheCheck;
    }

    public void setDoctorSTimeOfTheCheck(long doctorSTimeOfTheCheck) {
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
                " } " ;
    }
}
