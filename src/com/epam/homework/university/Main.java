package com.epam.homework.university;

import com.epam.homework.university.models.*;

public class Main {
    public static void main(String[] args) {
        Student abgar = new Student.Builder().withFirstName("Abgar").withLastName("Abgaryan").withEmail("aabgaryan@example.com")
                .withCourses(new Course[]{new Course(Subject.COMPUTER_SCIENCE, 9), new Course(Subject.MATH, 8)}).build();
        Student armen = new Student.Builder().withFirstName("Armen").withLastName("Harutyunyan").withEmail("aharutyunyan@example.com")
                .withCourses(new Course[]{new Course(Subject.ACCOUNTING, 5), new Course(Subject.FINANCE, 7), new Course(Subject.MATH, 7)}).build();
        Student grigor = new Student.Builder().withFirstName("Grigor").withLastName("Grigoryan").withEmail("ggrigoryan@example.com")
                .withCourses(new Course[]{new Course(Subject.ECONOMETRICS, 8), new Course(Subject.FINANCE, 4)}).build();
        Student eduard = new Student.Builder().withFirstName("Eduard").withLastName("Khachatryan").withEmail("ekhachatryan@example.com")
                .withCourses(new Course[]{new Course(Subject.ECONOMETRICS, 5), new Course(Subject.ECONOMICS, 3),new Course(Subject.FINANCE, 5)}).build();
        Student alexandr = new Student.Builder().withFirstName("Alexandr").withLastName("Gevorgyan").withEmail("agevorgyan@example.com")
                .withCourses(new Course[]{new Course(Subject.DATA_SCIENCE, 7), new Course(Subject.MATH, 5)}).build();
        Student ani = new Student.Builder().withFirstName("Ani").withLastName("Sargsyan").withEmail("asargsyan@example.com")
                .withCourses(new Course[]{new Course(Subject.COMPUTER_SCIENCE, 9), new Course(Subject.MATH, 8)}).build();
        Student lilit = new Student.Builder().withFirstName("Lilit").withLastName("Petrosyan").withEmail("lpetrosyan@example.com")
                .withCourses(new Course[]{new Course(Subject.COMPUTER_SCIENCE, 4),new Course(Subject.ELECTRICAL_AND_ELECTRONIC_ENGINEERING, 7), new Course(Subject.MATH, 7)}).build();
        Student lusine = new Student.Builder().withFirstName("Lusine").withLastName("Martirosyan").withEmail("lmartirosyan@example.com")
                .withCourses(new Course[]{new Course(Subject.PHYSICS, 8), new Course(Subject.MATH, 10), new Course(Subject.ELECTRICAL_AND_ELECTRONIC_ENGINEERING, 8)}).build();
        Student anna = new Student.Builder().withFirstName("Anna").withLastName("Aramyan").withEmail("aaramyan@example.com")
                .withCourses(new Course[]{new Course(Subject.INFORMATION_TECHNOLOGY, 4),new Course(Subject.DATA_SCIENCE, 5), new Course(Subject.MATH, 7)}).build();

//        Should throw invalid score exception
//        Student artur = new Student.Builder().withFirstName("Arthur").withLastName("Mamikonyan").withEmail("amamikonyan@example.com")
//                .withCourses(new Course[]{new Course(Subject.INFORMATION_TECHNOLOGY, 14),new Course(Subject.DATA_SCIENCE, -1), new Course(Subject.MATH, 7)}).build();

//        Should throw no subjects exception
//        Student mariam = new Student.Builder().withFirstName("Mariam").withLastName("Hakobyan").withEmail("mhakobyan@example.com")
//                .withCourses(new Course[]{}).build();

        Group group1 = new Group("0807", new Student[]{armen, grigor, eduard});
        Group group2 = new Group("0808", new Student[]{abgar, ani, lusine});
        Group group3 = new Group("0809", new Student[]{lilit, anna,alexandr});

//        Should throw no students exception
//        Group group4 = new Group("0809", new Student[]{});

        Faculty economics = new Faculty("Economics", new Group[]{group1});
        Faculty computerScience = new Faculty("Computer Science", new Group[]{group2,group3});

//        Should throw no groups exception
//        Faculty linguistic = new Faculty("Linguistics", new Group[]{});

        University ysu = new University("Yerevan State University", new Faculty[]{economics});
        ysu.addFaculty(computerScience);

        //Should throw no faculty exception
//        University aua = new University("American University of Armenia", new Faculty[]{});


        //Student scores by subject
        System.out.println("----------------------------");
        System.out.println(abgar.getScoreBySubject(Subject.MATH));
        System.out.println(armen.getScoreBySubject(Subject.ACCOUNTING));
        System.out.println(lilit.getScoreBySubject(Subject.ELECTRICAL_AND_ELECTRONIC_ENGINEERING));
        System.out.println(lusine.getScoreBySubject(Subject.PHYSICS));

        //Student average scores
        System.out.println("----------------------------");
        System.out.println(grigor.getAverageScore());
        System.out.println(eduard.getAverageScore());
        System.out.println(ani.getAverageScore());
        System.out.println(anna.getAverageScore());

        // Groups average scores by subject
        System.out.println("---------group1-------------");
        System.out.println(group1.getAverageScoreBySubject(Subject.MATH));
        System.out.println(group1.getAverageScoreBySubject(Subject.ACCOUNTING));
        System.out.println(group1.getAverageScoreBySubject(Subject.ECONOMETRICS));
        System.out.println("---------group2-------------");
        System.out.println(group2.getAverageScoreBySubject(Subject.COMPUTER_SCIENCE));
        System.out.println(group2.getAverageScoreBySubject(Subject.MATH));
        System.out.println(group2.getAverageScoreBySubject(Subject.ELECTRICAL_AND_ELECTRONIC_ENGINEERING));
        System.out.println("---------group3-------------");
        System.out.println(group3.getAverageScoreBySubject(Subject.COMPUTER_SCIENCE));
        System.out.println(group3.getAverageScoreBySubject(Subject.MATH));
        System.out.println(group3.getAverageScoreBySubject(Subject.DATA_SCIENCE));

        // Faculty scores
        System.out.println("---------economics faculty-------------");
        System.out.println(economics.getAverageScoreBySubject(Subject.FINANCE));
        System.out.println(economics.getAverageScoreBySubject(Subject.MATH));
        System.out.println(economics.getAverageScoreBySubject(Subject.ECONOMETRICS));
        System.out.println("---------computerScience faculty-------------");
        System.out.println(computerScience.getAverageScoreBySubject(Subject.COMPUTER_SCIENCE));
        System.out.println(computerScience.getAverageScoreBySubject(Subject.MATH));
        System.out.println(computerScience.getAverageScoreBySubject(Subject.DATA_SCIENCE));

        // University scores
        System.out.println("---------university-------------");
        System.out.println(ysu.getAverageScoreBySubject(Subject.ECONOMETRICS));
        System.out.println(ysu.getAverageScoreBySubject(Subject.MATH));
        System.out.println(ysu.getAverageScoreBySubject(Subject.COMPUTER_SCIENCE));
    }

}
