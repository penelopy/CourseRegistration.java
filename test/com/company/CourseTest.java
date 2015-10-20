package com.company;

import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class CourseTest {
    @Test
    public void courseEnrollmentisCorrect() {
        Professor drJones = new Professor("Dr. Sarah Jones");
        Course alegbra = new Course(drJones, "Alegbra 303", 5, 10);
        Professor drWatson = new Professor("Dr Lulu Watson");
        Course botany = new Course(drWatson, "Botany 401", 5, 11);

        Student penelope = new Student("Penelope Hill");
        Student stephanie = new Student("Stephanie Martin");


        alegbra.add(penelope);
        alegbra.add(stephanie);

        assertThat(alegbra.numConfirmedStudents(), equalTo(2));
        assertThat(botany.numConfirmedStudents(), equalTo(0));
    }


    @Test
    public void courseRemoveStudentsisCorrect() {
        Professor drJones = new Professor("Dr. Sarah Jones");
        Course alegbra = new Course(drJones, "Alegbra 303", 5, 10);
        Student penelope = new Student("Penelope Hill");
        Student stephanie = new Student("Stephanie Martin");

        alegbra.add(penelope);
        alegbra.add(stephanie);
        alegbra.remove(penelope);

        assertThat(alegbra.numConfirmedStudents(), equalTo(1));
        assertFalse(alegbra.isStudentRegistered("Penelope Hill"));
        assertTrue(alegbra.isStudentRegistered("Stephanie Martin"));
    }

    @Test
    public void addingCourseToStudent() {
        Student penelope = new Student("Penelope Hill");
        Professor drJones = new Professor("Dr. Sarah Jones");
        Course alegbra = new Course(drJones, "Alegbra 303", 5, 10);

        penelope.add(alegbra);
        alegbra.add(penelope);

        assertThat(penelope.numConfirmedClasses(), equalTo(1));
        assertTrue(alegbra.isStudentRegistered("Penelope Hill"));
    }

    @Test
    public void deletingCourseFromStudent() {
        Student penelope = new Student("Penelope Hill");
        Professor drJones = new Professor("Dr. Sarah Jones");
        Course alegbra = new Course(drJones, "Alegbra 303", 5, 10);

        penelope.add(alegbra);
        alegbra.add(penelope);

        penelope.drop(alegbra);
        alegbra.remove(penelope);

        assertThat(penelope.numConfirmedClasses(), equalTo(0));
        assertFalse(alegbra.isStudentRegistered("Penelope Hill"));
    }

    @Test
    public void courseIsFull() {
        Professor drWatson = new Professor("Dr Lulu Watson");
        Course botany = new Course(drWatson, "Botany 401", 5, 11);

        Student penelope = new Student("Penelope Hill");
        Student suzanne = new Student("Suzanne Harper");
        Student melanie = new Student("Melanie Coleman");
        Student sacha = new Student("Sacha Gans");
        Student julie = new Student("Julie Statz");

        botany.add(penelope);
        botany.add(suzanne);
        botany.add(melanie);
        botany.add(sacha);
        botany.add(julie);

        assertTrue(botany.isFull());
    }

    @Test(expected = IllegalStateException.class)
    public void addingStudentToFullCourseThrowsIllegalStateException() {
        Professor drWatson = new Professor("Dr Lulu Watson");
        Course botany = new Course(drWatson, "Botany 401", 5, 11);

        Student penelope = new Student("Penelope Hill");
        Student suzanne = new Student("Suzanne Harper");
        Student melanie = new Student("Melanie Coleman");
        Student sacha = new Student("Sacha Gans");
        Student julie = new Student("Julie Statz");
        Student alyssa = new Student("Alyssa Hans");


        botany.add(penelope);
        botany.add(suzanne);
        botany.add(melanie);
        botany.add(sacha);
        botany.add(julie);
        botany.add(alyssa);

    }



}
