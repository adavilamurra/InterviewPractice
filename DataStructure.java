/************************************************************************************
 **                                                                                **
 **    Code by: Alejandro Davila Murra                                             **
 **                                                                                **
 **    CS 2365: Object Oriented Programming                                        **
 **    Instructor: Elham Hojati                                                    **
 **    TA: Judas Tadeo                                                             **
 **    Project #4                                                                  **
 **    Description: Program to practice basic and important subjects               **
 **                 to prepare for a programming technical interview               **
 **    How to use: Click on the tabs to go to specific subjects, then              **
 **                click on the buttons to learn more.                             **
 **    Due Date: Tuesday, May 10                                                   **
 **    Last modification: 5/08/2017                                                **
 **                                                                                **
 ************************************************************************************/

//Data Structure class
public class DataStructure extends Interview {
    //instance variables
    public String description;
    public String code;
    public String bigO;
    public String Methods;

    //constructors
    public DataStructure(){
    }

    public DataStructure(String name, String bigO){
        super.name = name;
        this.bigO = bigO;
    }
}
