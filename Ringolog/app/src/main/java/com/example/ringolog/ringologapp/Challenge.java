package com.example.ringolog.ringologapp;

/**
 * Created by Chou on 2016-02-13.
 */
public class Challenge {
    private String challengeTitle;
    private String objective;
    private int time;

    public Challenge(){
    }

    public Challenge(String title, String objective){
        this.challengeTitle = title;
        this.objective = objective;
    }
    public Challenge(String title, String objective,int time){
        this.challengeTitle = title;
        this.objective = objective;
        this.time = time;
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

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
