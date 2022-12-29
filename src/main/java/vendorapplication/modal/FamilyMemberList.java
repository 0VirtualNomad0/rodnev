package vendorapplication.modal;

import java.io.Serializable;

public class FamilyMemberList implements Serializable {

    private String gender;
    private String name;
    private String age;
    private String qualification;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    @Override
    public String toString() {
        return "FamilyMemberList{" +
                "gender='" + gender + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", qualification='" + qualification + '\'' +
                '}';
    }
}
