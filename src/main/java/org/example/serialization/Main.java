package org.example.serialization;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
/*        try (FileOutputStream fileInputStream = new FileOutputStream("name.txt");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileInputStream)){

            objectOutputStream.writeUTF("Anton");
            //objectOutputStream.writeInt(10);
        }

        try (FileInputStream fileInputStream = new FileInputStream("name.txt");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)){

            System.out.println(objectInputStream.readUTF());
        }*/

        try (FileOutputStream fileOutputStream = new FileOutputStream("employee.txt");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)){

            Department department = new Department("Sales", "+79898878");
            Employee employee = new Employee("Anton", 30, department);

            //objectOutputStream.writeObject(employee);
        }

        try (FileInputStream fileInputStream = new FileInputStream("employee.txt");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)){

            //Employee employee = (Employee) objectInputStream.readObject();
            //System.out.println(employee.getName());
            //System.out.println(employee.getAge());

            //System.out.println(employee.getDepartment().getName());
            //System.out.println(employee.getDepartment().getPhone());
        }



        Department department = new Department("Sales", "+79899887");
        Employee employee = new Employee("Anna", 35, department);

        serialize(employee);

        // deserialize
        Employee employee1 = deserialize();
        System.out.println("employee: " + employee1.getName());
        System.out.println("phone: " + employee1.getDepartment().getPhone());
        System.out.println("name: " + employee1.getDepartment().getName());


    }

    public static void serialize(Employee employee) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream("employee2.ser");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {

            objectOutputStream.writeObject(employee);
        }
    }

    public static Employee deserialize() throws IOException, ClassNotFoundException {
        try (FileInputStream fileInputStream = new FileInputStream("employee2.ser");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)){

            return (Employee) objectInputStream.readObject();
        }
    }
}
