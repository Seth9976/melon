package com.kakao.tiara.data;

class Sdk {
    private static final String APP_ANDROID = "AA";
    private static final String APP_IOS = "IA";
    private static final String JAVA = "java";
    private static final String WEB = "web";
    private String type;
    private String version;

    public Sdk() {
        this.type = "AA";
        this.version = "1.1.3";
    }
}

