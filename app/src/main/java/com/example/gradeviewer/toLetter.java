package com.example.gradeviewer;

public class toLetter {
    
    public static String gradeToLetter(int grade){
        
        String gradeInLetter = "";
        if (grade >= 90)
            gradeInLetter = "A";
        else if (grade >= 80)
            gradeInLetter = "B";
        else if (grade >= 70)
            gradeInLetter = "C";
        else if (grade >= 65)
            gradeInLetter = "D";
        else if (grade > 0)
            gradeInLetter = "F";
        else
            gradeInLetter = "~";

        return gradeInLetter;
    }
}
