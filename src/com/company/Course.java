package com.company;

import java.util.ArrayList;
import java.util.List;

public class Course {
    final Professor name;
    final String title;
    final int capacity;
    //make all these private
    final int startTime;
    private List<Student> students = new ArrayList<Student>();
    public Course(Professor name, String title, int capacity,
                  int startTime) {
        this.name = name;
        this.title = title;
        this.capacity = capacity;
        this.startTime = startTime;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name=" + name +
                ", title='" + title + '\'' +
                ", capacity=" + capacity +
                '}';
    }

//    @Override
//    public String toString() {
//        return students.toString();
//    }

    public int numConfirmedStudents() {
        return this.students.size();
    }

    public boolean isFull() {
        if (this.capacity == students.size()) {
            return true;
        }
        return false;
    }

    public void add(Student name) {
//        students.add(name);
        System.out.println(students.toString());

        if (!isFull()) {
            students.add(name);
        }
        else  {
            throw new IllegalStateException();
        }
    }

    public void remove(Student name) {
        students.remove(name);
    }

    public boolean isStudentRegistered(String name) {
        for (Student student: students) {
            if (student.name == name) {
                return true;
            }
        }
        return false;
    }

}
