package com.example.app;

public class SenatorHelper {
    String senator,sen_votes,sen_constituency,sen_ward,sen_ps;
    public SenatorHelper() {
    }

    public SenatorHelper(String senator, String sen_votes, String sen_constituency, String sen_ward, String sen_ps) {
        this.senator = senator;
        this.sen_votes = sen_votes;
        this.sen_constituency = sen_constituency;
        this.sen_ward = sen_ward;
        this.sen_ps = sen_ps;
    }

    public String getSenator() {
        return senator;
    }

    public String getSen_votes() {
        return sen_votes;
    }

    public String getSen_constituency() {
        return sen_constituency;
    }

    public String getSen_ward() {
        return sen_ward;
    }

    public String getSen_ps() {
        return sen_ps;
    }
}
