package homework.medicalCenter.model;

public class Doctor extends Person{
    private String profession;



    public Doctor(String name, String surName, String phone, String profession) {
        setId(String.valueOf(System.nanoTime()));
        setName(name);
        setSurName(surName);
        setPhone(phone);
        this.profession = profession;
    }

    public String getProfession() {
        return profession;
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
