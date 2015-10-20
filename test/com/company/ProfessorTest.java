package com.company;

import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class ProfessorTest {

    @Test
    public void professorIsCorrect() {
        Professor drJones = new Professor("Dr. Sarah Jones");
        Course alegbra = new Course(drJones, "Alegbra 303", 5, 10);

        Professor drWatson = new Professor("Dr Lulu Watson");
        Course botany = new Course(drWatson, "Botany 401", 5, 11);

        Professor drKahn = new Professor("Dr. Ashe Kahn");
        Course compSci202 = new Course(drKahn, "Computer Science 202", 5, 12);

        assertThat(alegbra.name.name, equalTo("Dr. Sarah Jones"));
        assertThat(botany.name.name, equalTo("Dr Lulu Watson"));
        assertThat(compSci202.name.name, equalTo("Dr. Ashe Kahn"));
    }
}
