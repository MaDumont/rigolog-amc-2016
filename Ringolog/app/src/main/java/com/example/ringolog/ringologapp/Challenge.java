package com.example.ringolog.ringologapp;

/**
 * Created by Chou on 2016-02-13.
 */
public class Challenge {
    private String challengeTitle;
    private String objective;

    private String time;
    private int id;

    public Challenge(){
    }

    public Challenge(String title, String objective){
        this.challengeTitle = title;
        this.objective = objective;
    }


    public Challenge(String title, String objective,String time, int id){
        this.challengeTitle = title;
        this.objective = objective;
        this.time = time;
        this.id = id;

    }

    public String getChallengeTitle() {
        return challengeTitle;
    }

    public void setChallengeTitle(String challengeTitle) {
        this.challengeTitle = challengeTitle;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getId() { return id; }

    public void setID(int id){ this.id = id; }
}
