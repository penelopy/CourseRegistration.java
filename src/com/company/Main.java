package com.company;

public class Main {

    public static void main(String[] args) {
        Professor drJones = new Professor("Dr. Sarah Jones");
        Course alegbra = new Course(drJones, "Alegbra 303", 5, true, 0, 10);

        Student penelope = new Student("Penelope Hill", 0);
        Student stephanie = new Student("Stephanie Martin", 0);
        Student alyssa = new Student("Alyssa Hauk", 0);
        Student wendy = new Student("Wendy Dherin", 0);
        Student carly = new Student("Carly Simon", 0);
        Student hope = new Student("Hope Degeneres", 0);


        alegbra.add(penelope);
        alegbra.add(stephanie);
        alegbra.add(alyssa);
        alegbra.add(wendy);
        alegbra.add(carly);
        alegbra.add(hope);

        Professor drWatson = new Professor("Dr Lulu Watson");
        Course botany = new Course(drWatson, "Botany 401", 5, true, 0, 11);
        Professor drKahn = new Professor("Dr. Ashe Kahn");
        Course compSci202 = new Course(drKahn, "Computer Science 202", 5, true, 0, 11);

        System.out.println(alegbra);
        penelope.add(alegbra);
        penelope.add(botany);

        penelope.add(compSci202);
        System.out.println(penelope.confirmedClasses);    }
}
