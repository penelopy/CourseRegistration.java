package com.company;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StudentTest {

    @Test
    public void studentAvailableAtThatHour() {
        Student penelope = new Student("Penelope Hill");
        Professor drJones = new Professor("Dr. Sarah Jones");
        Course alegbra = new Course(drJones, "Alegbra 303", 5, 10);
        Professor drWatson = new Professor("Dr Lulu Watson");
        Course botany = new Course(drWatson, "Botany 401", 5, 11);
        Professor drKahn = new Professor("Dr. Ashe Kahn");
        Course compSci202 = new Course(drKahn, "Computer Science 202", 5, 11);

        penelope.add(botany);
        assertTrue(penelope.scheduleOpenAtThatHour(alegbra));
        assertFalse(penelope.scheduleOpenAtThatHour(compSci202));
    }

    @Test
    public void isStudentScheduleFull() {
        Student penelope = new Student("Penelope Hill");

        Professor drJones = new Professor("Dr. Sarah Jones");
        Course alegbra = new Course(drJones, "Alegbra 303", 5, 10);
        Professor drWatson = new Professor("Dr Lulu Watson");
        Course botany = new Course(drWatson, "Botany 401", 5, 11);
        Professor drKahn = new Professor("Dr. Ashe Kahn");
        Course compSci202 = new Course(drKahn, "Computer Science 202", 5, 12);
        Professor drMathis = new Professor("Dr. Ashley Mathis");
        Course compSci404 = new Course(drMathis, "Computer Science 404", 5, 3);
        Professor drNye = new Professor("Dr. Steve Nye");
        Course geology202 = new Course(drNye, "Geology 202", 5, 4);

        penelope.add(alegbra);
        penelope.add(botany);
        penelope.add(compSci202);
        penelope.add(compSci404);
        penelope.add(geology202);

        assertTrue(penelope.isScheduleFull());

    }

    @Test(expected = IllegalStateException.class)
    public void addingCourseWhenScheduleFullThrowsIllegalStateException() {
        Student penelope = new Student("Penelope Hill");

        Professor drJones = new Professor("Dr. Sarah Jones");
        Course alegbra = new Course(drJones, "Alegbra 303", 5, 10);
        Professor drWatson = new Professor("Dr Lulu Watson");
        Course botany = new Course(drWatson, "Botany 401", 5, 11);
        Professor drKahn = new Professor("Dr. Ashe Kahn");
        Course compSci202 = new Course(drKahn, "Computer Science 202", 5, 12);
        Professor drMathis = new Professor("Dr. Ashley Mathis");
        Course compSci404 = new Course(drMathis, "Computer Science 404", 5, 3);
        Professor drNye = new Professor("Dr. Steve Nye");
        Course geology202 = new Course(drNye, "Geology 202", 5, 4);
        Professor drHunt = new Professor("Dr. Gray Hunt");
        Course artHistory = new Course(drHunt, "Art History 202", 5, 9);

        penelope.add(alegbra);
        penelope.add(botany);
        penelope.add(compSci202);
        penelope.add(compSci404);
        penelope.add(geology202);
        penelope.add(artHistory);
    }

}
