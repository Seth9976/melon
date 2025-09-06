package com.kakao.tiara.data;

class Bucket {
    private String experiment_key;
    private String group;
    private String id_type;
    private String name;
    private String variation_key;

    public Bucket(String s, String s1) {
        this.name = s;
        this.group = s1;
    }

    public Bucket(String s, String s1, IdType idType0) {
        this.experiment_key = s;
        this.variation_key = s1;
        this.id_type = idType0.name;
    }

    public void setExperimentInfo(String s, String s1, IdType idType0) {
        this.experiment_key = s;
        this.variation_key = s1;
        this.id_type = idType0.name;
    }

    public void setNameAndGroup(String s, String s1) {
        this.name = s;
        this.group = s1;
    }
}

