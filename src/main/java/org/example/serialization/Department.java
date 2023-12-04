package org.example.serialization;

import java.io.Externalizable;
import java.io.Serial;
import java.io.Serializable;

public class Department {

    private String name;
    private String phone;


    public Department() {
        name = "Default department";
        phone = "777777";
    }

    public Department(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
