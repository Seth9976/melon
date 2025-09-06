package com.kakao.tiara;

public final class SessionIds {
    private final String isuid;
    private final String suid;
    private final String tsid;

    private SessionIds(String s, String s1, String s2) {
        this.tsid = s;
        this.suid = s1;
        this.isuid = s2;
    }

    // 去混淆评级： 中等(60)
    public static SessionIds generateNewIds() {
        return new SessionIds("HsAOQdsexBKZ_250906113404832", "K9phPW1zkfSL_250906549844391", "K9phPW1zkfSL_250906549844391");
    }

    public static SessionIds generateNullIds() {
        return new SessionIds(null, null, null);
    }

    public String getIsuid() {
        return this.isuid;
    }

    public String getSuid() {
        return this.suid;
    }

    public String getTsid() {
        return this.tsid;
    }
}

