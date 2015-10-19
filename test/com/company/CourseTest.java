package com.company;

import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class CourseTest {
    @Test
    public void courseEnrollmentisCorrect() {
        Professor drJones = new Professor("Dr. Sarah Jones");
        Course alegbra = new Course(drJones, "Alegbra 303", 5, true, 0, 10);
        Professor drWatson = new Professor("Dr Lulu Watson");
        Course botany = new Course(drWatson, "Botany 401", 5, true, 0, 11);

        Student penelope = new Student("Penelope Hill", 0);
        Student stephanie = new Student("Stephanie Martin", 0);


        alegbra.add(penelope);
        alegbra.add(stephanie);

        assertThat(alegbra.confirmedStudents, equalTo(2));
        assertThat(botany.confirmedStudents, equalTo(0));
    }

    @Test
    public void professorIsCorrect() {
        Professor drJones = new Professor("Dr. Sarah Jones");
        Course alegbra = new Course(drJones, "Alegbra 303", 5, true, 5, 10);

        assertThat(alegbra.name.name, equalTo("Dr. Sarah Jones"));
    }

    @Test
    public void courseRemoveStudentsisCorrect() {
        Professor drJones = new Professor("Dr. Sarah Jones");
        Course alegbra = new Course(drJones, "Alegbra 303", 5, true, 0, 10);
        Student penelope = new Student("Penelope Hill", 0);
        Student stephanie = new Student("Stephanie Martin", 0);

        alegbra.add(penelope);
        alegbra.add(stephanie);
        alegbra.remove(penelope);

        assertThat(alegbra.confirmedStudents, equalTo(1));
        assertFalse(alegbra.studentRegistered("Penelope Hill"));
        assertTrue(alegbra.studentRegistered("Stephanie Martin"));
    }

    @Test
    public void addingCourseToStudent() {
        Student penelope = new Student("Penelope Hill", 0);
        Professor drJones = new Professor("Dr. Sarah Jones");
        Course alegbra = new Course(drJones, "Alegbra 303", 5, true, 0, 10);

        penelope.add(alegbra);
        alegbra.add(penelope);

        assertThat(penelope.confirmedClasses, equalTo(1));
        assertTrue(alegbra.studentRegistered("Penelope Hill"));
    }

    @Test
    public void deletingCourseFromStudent() {
        Student penelope = new Student("Penelope Hill", 0);
        Professor drJones = new Professor("Dr. Sarah Jones");
        Course alegbra = new Course(drJones, "Alegbra 303", 5, true, 0, 10);

        penelope.add(alegbra);
        alegbra.add(penelope);

        penelope.drop(alegbra);
        alegbra.remove(penelope);

        assertThat(penelope.confirmedClasses, equalTo(0));
        assertFalse(alegbra.studentRegistered("Penelope Hill"));
    }

    @Test
    public void studentAvailableAtThatHour() {
        Student penelope = new Student("Penelope Hill", 0);
        Professor drJones = new Professor("Dr. Sarah Jones");
        Course alegbra = new Course(drJones, "Alegbra 303", 5, true, 0, 10);
        Professor drWatson = new Professor("Dr Lulu Watson");
        Course botany = new Course(drWatson, "Botany 401", 5, true, 0, 11);
        Professor drKahn = new Professor("Dr. Ashe Kahn");
        Course compSci202 = new Course(drKahn, "Computer Science 202", 5, true, 0, 11);

        penelope.add(botany);
        assertTrue(penelope.scheduleOpenAtThatHour(alegbra));
        assertFalse(penelope.scheduleOpenAtThatHour(compSci202));
    }

}
