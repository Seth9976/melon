package com.kakao.tiara.data;

public enum ExcludeType {
    ALL("all"),
    IDENTIFIED("identified"),
    NON_IDENTIFIED("non_identified");

    private String name;

    private ExcludeType(String s1) {
        this.name = s1;
    }

    public String getName() {
        return this.name;
    }
}

