package com.epam.homework.university.models;

public class Course {
    private final int MIN = 0;
    private final int MAX = 10;
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
        if (score < MIN || score > MAX){
            throw new RuntimeException("Score must be in the range of 0-10");
        }
        this.score = score;
    }
}
