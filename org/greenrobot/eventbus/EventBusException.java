package org.greenrobot.eventbus;

public class EventBusException extends RuntimeException {
    private static final long serialVersionUID = 0xD79482ABCAE9C669L;

    public EventBusException(String s) {
        super(s);
    }

    public EventBusException(String s, Throwable throwable0) {
        super(s, throwable0);
    }

    public EventBusException(Throwable throwable0) {
        super(throwable0);
    }
}

