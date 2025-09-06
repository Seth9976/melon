package com.iloen.melon.eventbus;

public class EventLoginDialog {
    public static class AppUpdate extends EventLoginDialog {
    }

    public static class Event extends EventLoginDialog {
        public final String message;

        public Event(String s) {
            this.message = s;
        }
    }

}

