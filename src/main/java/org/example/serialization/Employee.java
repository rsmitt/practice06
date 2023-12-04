package org.example.serialization;

import java.io.*;

public class Employee implements Externalizable {

    @Serial
    private static final long serialVersionUID = 1403265388349958795L;
    //private static final String test = "test";

    private String name;
    private int age;
    private transient Department department;

    public Employee() {
    }

    public Employee(String name, int age, Department department) {
        this.name = name;
        this.age = age;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(name);
        out.writeInt(age);

        out.writeUTF(department.getPhone());
        out.writeUTF(department.getName());
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        String employeeName = in.readUTF();
        int age = in.readInt();

        String phone = in.readUTF();
        String name = in.readUTF();

        this.name = employeeName;
        this.age = age;
        department = new Department(name, phone);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", department=" + department +
                '}';
    }
}
