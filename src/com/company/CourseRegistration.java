package com.company;


import java.util.ArrayList;
import java.util.List;

class CourseRegistration {

}

class Course {
    final Professor name;
    final String title;
    final int capacity;
    int confirmedStudents;
    boolean meetsDaily;
    final int startTime;
    private List<Student> students = new ArrayList<Student>();

    public Course(Professor name, String title, int capacity, boolean meetsDaily,
                  int confirmedStudents, int startTime) {
        this.name = name;
        this.title = title;
        this.capacity = capacity;
        this.meetsDaily = meetsDaily;
        this.confirmedStudents = confirmedStudents;
        this.startTime = startTime;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name=" + name +
                ", title='" + title + '\'' +
                ", capacity=" + capacity +
                ", spots scheduleOpenAtThatHour=" + confirmedStudents +
                ", meetsDaily=" + meetsDaily +
                '}';
    }

//    @Override
//    public String toString() {
//        return students.toString();
//    }

    public void add(Student name) {
        if (this.capacity > this.confirmedStudents) {
            students.add(name);
            this.confirmedStudents++;
        }
    }

    public void remove(Student name) {
        students.remove(name);
        this.confirmedStudents--;
    }

    public boolean studentRegistered(String name) {
        for (Student student: students) {
            if (student.name == name) {
                return true;
            }
        }
        return false;
    }

}

class Student {
    final String name;
    final int numberPossibleClasses = 5;
    int confirmedClasses;
    List<Course> schedule = new ArrayList<Course>();


    public Student(String name, int confirmedClasses) {
        this.name = name;
        this.confirmedClasses = confirmedClasses;
    }

    public void add(Course course) {
        if (schedule.isEmpty()) {
            schedule.add(course);
            confirmedClasses++;
        }
        else {
            if (scheduleOpenAtThatHour(course)) {
                if (confirmedClasses < numberPossibleClasses) {
                    schedule.add(course);
                    confirmedClasses++;
                }
            }
        }
    }

    public boolean scheduleOpenAtThatHour(Course course) {
        for (Course x: schedule) {
            if (x.startTime == course.startTime) {
                return false;
            }
        }
        return true;
    }

    public void drop(Course course) {
        schedule.remove(course);
        confirmedClasses--;
    }

    @Override
    public String toString() {
        return name;
    }
}

class Professor {
    final String name;

    public Professor(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "name='" + name + '\'' +
                '}';
    }
}



