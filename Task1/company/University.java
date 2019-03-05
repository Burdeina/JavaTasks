package com.company;

public class University extends BaseEducation{
    int accreditationLevel;
    int countOfFaculties;

    University(){}

    University(String n, String a, int y, int acc, int c){
        super(n, a, y);
        this.accreditationLevel = acc;
        this.countOfFaculties = c;
    }
}
