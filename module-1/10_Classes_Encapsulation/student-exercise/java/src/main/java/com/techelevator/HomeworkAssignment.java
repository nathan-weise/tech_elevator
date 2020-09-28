package com.techelevator;

public class HomeworkAssignment {

    private int earnedMarks;
    private int possibleMarks;
    private String submitterName;

    public int getEarnedMarks() {
        return earnedMarks;
    }

    public void setEarnedMarks(int earnedMarks) {
        this.earnedMarks = earnedMarks;
    }

    public int getPossibleMarks() {
        return possibleMarks;
    }

    public String getSubmitterName() {
        return submitterName;
    }

    public HomeworkAssignment(int possibleMarks, String submitterName) {
        this.possibleMarks = possibleMarks;
        this.submitterName = submitterName;
    }

    public String getLetterGrade() {
        double letterGradeMath = (double) getEarnedMarks() / getPossibleMarks();


        if (letterGradeMath >= .90) {
            return "A";
        }
        else if (letterGradeMath < .90 && letterGradeMath >= .80) {
            return "B";
        }
        else if (letterGradeMath < .80 && letterGradeMath >= .70) {
            return "C";
        }
        else if (letterGradeMath < .70 && letterGradeMath >= .60) {
            return "D";
        } else {
            return "F";
        }
    }
}




