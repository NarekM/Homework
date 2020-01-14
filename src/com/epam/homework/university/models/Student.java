package com.epam.homework.university.models;

import com.epam.homework.helpers.Helper;

import java.text.DecimalFormat;
import java.util.Arrays;

public class Student extends Person{
    private Course[] courses;

    private Student(Builder builder){
        setFirstName(builder.firstName);
        setLastName(builder.lastName);
        setEmail(builder.email);
        if (builder.courses == null || builder.courses.length == 0){
            throw new RuntimeException("Student "+getFirstName()+" "+getLastName()+ " does not have any subjects");
        }
        this.courses = builder.courses;
    }

    public static class Builder{
        private String firstName;
        private String lastName;
        private String email;
        private Course[] courses;

        public Builder(){}

        public Builder withFirstName(String firstName){
            this.firstName = firstName;
            return this;
        }
        public Builder withLastName(String lastName){
            this.lastName = lastName;
            return this;
        }
        public Builder withEmail(String email){
            this.email = email;
            return this;
        }
        public Builder withCourses(Course[] courses){
            this.courses = courses;
            return this;
        }

        public Student build(){
            Student student = new Student(this);
            return student;
        }
    }

    public Course[] addCourse(Course course){
        if (courses == null){
            courses = new Course[1];
            courses[0] = course;
        } else {
            Course oldCourse = getCourse(course.getSubject());
            if (oldCourse != null){
                oldCourse = course;
            }
            courses = (Course[]) Helper.extendArray(courses,course);
        }
        return courses;
    }

    public Course getCourse(String subject){
        if (courses == null || courses.length == 0){
            throw new RuntimeException("Student "+getFirstName()+" "+getLastName()+ " does not have any subjects");
        }
        for (Course course: courses) {
            if (course.getSubject().equals(subject)){
                return course;
            }
        }
        return null;
    }

    public double getAverageScore(){
        int score = 0;
        for (int i = 0; i < courses.length; i++) {
            if (courses[i] == null){
                continue;
            }
           score += courses[i].getScore();
        }
        return Double.parseDouble(new DecimalFormat("#.##").format(((double) score)/ courses.length));
    }

    public Double getScoreBySubject(String subject){
        for (Course course : courses) {
            if (course.getSubject().equals(subject)){
                return (double) (course.getScore());
            }
        }
        return 0d;
    }

    @Override
    public String toString() {
        return "Student: " +
                "firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", courses= " + Arrays.toString(courses);
    }
}
