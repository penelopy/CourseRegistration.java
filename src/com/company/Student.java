package com.company;

import java.util.ArrayList;
import java.util.List;

public class Student {
    final String name;
    final int numberPossibleClasses = 5;
    private List<Course> schedule = new ArrayList<Course>();


    public Student(String name) {
        this.name = name;
    }

    public void add(Course course) {
        if (schedule.size() < numberPossibleClasses) {
            if (scheduleOpenAtThatHour(course)) {
                schedule.add(course);
            }
        }
        else {
            throw new IllegalStateException();
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

    public int numConfirmedClasses() {
        return schedule.size();
    }

    public boolean isScheduleFull() {
        if (numberPossibleClasses == schedule.size()) {
            return true;
        }
        return false;
    }

    public void drop(Course course) {
        schedule.remove(course);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;

        Student student = (Student) o;

        if (numberPossibleClasses != student.numberPossibleClasses) return false;
        if (name != null ? !name.equals(student.name) : student.name != null)
            return false;
        if (schedule != null ? !schedule.equals(student.schedule) : student.schedule != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + numberPossibleClasses;
        result = 31 * result + (schedule != null ? schedule.hashCode() : 0);
        return result;
    }
}
