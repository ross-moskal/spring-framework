package com.cydeo.loosely_coupled;

public class App {
    public static void main(String[] args) {

        FullTimeMentor fullTime = new FullTimeMentor();
//        PartTimeMentor partTime = new PartTimeMentor();

        MentorAccount mentor = new MentorAccount(fullTime);

        mentor.manageAccount();
    }
}
