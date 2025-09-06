package com.kakao.tiara.data;

public enum IdType {
    UUID("uuid"),
    ACCOUNT_ID("account_id"),
    APP_USER_ID("app_user_id"),
    INTERNAL_USER_ID("internal_user_id");

    final String name;

    private IdType(String s1) {
        this.name = s1;
    }
}

