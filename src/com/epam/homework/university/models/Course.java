package com.epam.homework.university.models;

public class Course {
    private String subject;
    private int score;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Course(String subject, int score) {
        this.subject = subject;
        if (score < 0 || score > 10){
            throw new RuntimeException("Score must be in the range of 0-10");
        }
        this.score = score;
    }
}
