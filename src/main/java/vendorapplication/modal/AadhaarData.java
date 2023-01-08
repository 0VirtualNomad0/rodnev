package vendorapplication.modal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)

public class AadhaarData {
    @JsonProperty("membername_in_aadhaar")
    private String name;

    @JsonProperty("dob_in_aadhaar")
    private String dob;

    private int age;

    private String firstName;

    private String lastName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        int idx = name.lastIndexOf(' ');
        if (idx == -1) {
            setFirstName(name);
        } else {
            setFirstName(name.substring(0, idx));
            setLastName( name.substring(idx + 1));
        }
    }

    public String getDob() {
        return dob;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDob(String dob) {
        this.dob = dob;
        try {
            int currentYear = Year.now().getValue();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            Date userBirthDate = dateFormat.parse(dob);
            SimpleDateFormat df = new SimpleDateFormat("yyyy");
            setAge(currentYear - Integer.parseInt(df.format(userBirthDate)));
        } catch (Exception ex) {
            this.age = 0;
        }
    }

    @Override
    public String toString() {
        return "AadhaarData{" +
                "name='" + name + '\'' +
                ", dob='" + dob + '\'' +
                ", age=" + age +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
