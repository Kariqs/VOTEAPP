package com.example.app;

public class WrepHelper {
    public WrepHelper() {
    }

    String Women_rep,W_votes,W_constituency,W_ward,W_ps;

    public WrepHelper(String women_rep, String w_votes, String w_constituency, String w_ward, String w_ps) {
        Women_rep = women_rep;
        W_votes = w_votes;
        W_constituency = w_constituency;
        W_ward = w_ward;
        W_ps = w_ps;
    }

    public String getWomen_rep() {
        return Women_rep;
    }

    public String getW_votes() {
        return W_votes;
    }

    public String getW_constituency() {
        return W_constituency;
    }

    public String getW_ward() {
        return W_ward;
    }

    public String getW_ps() {
        return W_ps;
    }
}
