package com.company;

public class Main {

    public static void main(String[] args) {
        Professor drJones = new Professor("Dr. Sarah Jones");
        Course alegbra = new Course(drJones, "Alegbra 303", 5, 10);

        Student penelope = new Student("Penelope Hill");
        Student stephanie = new Student("Stephanie Martin");
        Student alyssa = new Student("Alyssa Hauk");
        Student wendy = new Student("Wendy Dherin");
        Student carly = new Student("Carly Simon");
        Student hope = new Student("Hope Degeneres");


        alegbra.add(penelope);
        alegbra.add(stephanie);
        alegbra.add(alyssa);
        alegbra.add(wendy);
        alegbra.add(carly);
        alegbra.add(hope);

        Professor drWatson = new Professor("Dr Lulu Watson");
        Course botany = new Course(drWatson, "Botany 401", 5, 11);
        Professor drKahn = new Professor("Dr. Ashe Kahn");
        Course compSci202 = new Course(drKahn, "Computer Science 202", 5, 11);

        System.out.println(alegbra);
        penelope.add(alegbra);
        penelope.add(botany);

        penelope.add(compSci202);
       }
}
