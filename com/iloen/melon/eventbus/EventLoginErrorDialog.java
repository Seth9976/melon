package com.iloen.melon.eventbus;

public class EventLoginErrorDialog {
    public static class PwdErrorExceed extends EventLoginErrorDialog {
        public PwdErrorExceed(String s) {
            super(s);
        }
    }

    public final String message;
    public boolean showDialog;
    public final String title;

    public EventLoginErrorDialog(String s) {
        this.title = "안내";
        this.message = s;
    }
}

