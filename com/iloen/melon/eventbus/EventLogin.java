package com.iloen.melon.eventbus;

public class EventLogin {
    public static class MelOn extends EventLogin {
        public MelOn(Boolean boolean0) {
            super(boolean0, 0);
        }
    }

    private String errorCode;
    private String errorMessage;
    public final Boolean isLogin;
    private String tmpCall;

    private EventLogin(Boolean boolean0) {
        this.isLogin = boolean0;
    }

    public EventLogin(Boolean boolean0, int v) {
        this(boolean0);
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public String getTmpCall() {
        return this.tmpCall;
    }

    public void setError(String s, String s1) {
        this.errorCode = s;
        this.errorMessage = s1;
    }

    public void setTmpCall(String s) {
        this.tmpCall = s;
    }
}

