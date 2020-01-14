package com.epam.homework.university.models;

import com.epam.homework.helpers.Helper;

public class University {
    private String name;
    private Faculty[] faculties;
    private String[] subjects;

    public University(String name, Faculty[] faculties) {
        this.name = name;
        Helper.validateArray(faculties, "University "+ name +" doesn't have faculties");
        this.faculties = faculties;
    }

    public Faculty[] addFaculty(Faculty faculty){
        if (getFaculty(faculty.getName()) != null){
            throw new RuntimeException("Faculty with name "+faculty.getName()+" already exists");
        }
        faculties = (Faculty[]) Helper.extendArray(faculties,faculty);
        return faculties;
    }

    public Faculty getFaculty(String name){
        Helper.validateArray(faculties, "University "+ name +" doesn't have faculties");
        for (Faculty faculty: faculties) {
            if (faculty.getName().equals(name)){
                return faculty;
            }
        }
        return null;
    }

    //todo
    public double getAverageScoreBySubject(String subject){
        double total = 0;
        for (Faculty faculty : faculties) {
            total += faculty.getAverageScoreBySubject(subject);
        }
        return total/faculties.length;
    }
}
