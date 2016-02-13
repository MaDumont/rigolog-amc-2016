package com.example.ringolog.ringologapp;

/**
 * Created by Chou on 2016-02-13.
 */
public class Challenge {
    private String challengeTitle;
    private String objective;
    private String time;

    public Challenge(){
    }

    public Challenge(String title, String objective){
        this.challengeTitle = title;
        this.objective = objective;
    }
    public Challenge(String title, String objective,String time){
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
