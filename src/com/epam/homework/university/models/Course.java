package com.epam.homework.university.models;

public class Course {
    private final int MIN_SCORE = 0;
    private final int MAX_SCORE = 10;
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
        if (score < MIN_SCORE || score > MAX_SCORE){
            throw new RuntimeException("Score must be in the range of 0-10");
        }
        this.score = score;
    }
}
