package com.example.project.Student;
import java.util.ArrayList;
import java.util.Arrays;

public class Utility {

    public static ArrayList<Student> sortStudents(ArrayList<Student> list)
    {
        for (int j = 0; j < Math.pow(list.size(), 2); j++)
        {
            for (int i = 0; i < list.size() - 1; i++)
            {
                if (list.get(i + 1).getLastName().compareTo(list.get(i).getLastName()) < 0)
                {
                    Student temp = list.get(i);
                    Student temp2 = list.get(i + 1);
                    list.set(i, temp2);
                    list.set(i + 1, temp);
                    break;
                }

                else if (list.get(i + 1).getLastName().compareTo(list.get(i).getLastName()) == 0)
                {

                    if (list.get(i + 1).getFirstName().compareTo(list.get(i).getFirstName()) < 0)
                    {
                        Student temp = list.get(i);
                        Student temp2 = list.get(i + 1);
                        list.set(i, temp2);
                        list.set(i + 1, temp);
                        break;
                    }
                    else if (list.get(i + 1).getFirstName().compareTo(list.get(i).getFirstName()) == 0)
                    {
                        if (list.get(i + 1).getGpa() > list.get(i).getGpa())
                        {
                            Student temp = list.get(i);
                            Student temp2 = list.get(i + 1);
                            list.set(i, temp2);
                            list.set(i + 1, temp);
                            break;
                        }
                    }
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Student s1 = new Student("Abby", "Smith", 96.7);
        Student s2 = new Student("Michelle", "Jones", 98.1);
        Student s3 = new Student("Chase", "Bean", 95.2);
        Student s4 = new Student("Jack", "Clancy", 97.3);
        Student s5 = new Student("Brittany", "Jones", 95.5);
        Student s6 = new Student("Lisa", "Frank", 92.4);
        Student s7 = new Student("Marie", "Angelina", 96.5);
        Student s8 = new Student("Peter", "Frank", 97.9);
        Student s9 = new Student("Lisa", "Frank", 99.5);
        Student s10 = new Student("Dean", "Jones", 93.2);

        ArrayList<Student> students = new ArrayList<Student>(Arrays.asList(s1, s2, s3, s4, s5, s6, s7, s8, s9, s10));
        System.out.println(students);
        Utility.sortStudents(students);
        System.out.println(students);
    }
}
