package com.example.app;

public class UserHelper {
    String governor,gov_votes,gov_constituency,gov_ward,gov_ps;

    public UserHelper() {
    }



    public UserHelper(String governor, String gov_votes, String gov_constituency, String gov_ward, String gov_ps) {
        this.governor = governor;
        this.gov_votes = gov_votes;
        this.gov_constituency = gov_constituency;
        this.gov_ward = gov_ward;
        this.gov_ps = gov_ps;


    }

    public String getGovernor() {
        return governor;
    }

    public String getGov_votes() {
        return gov_votes;
    }

    public String getGov_constituency() {
        return gov_constituency;
    }

    public String getGov_ward() {
        return gov_ward;
    }

    public String getGov_ps() {
        return gov_ps;
    }

}
