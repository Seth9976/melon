package org.greenrobot.eventbus;

public final class SubscriberExceptionEvent {
    public final Object causingEvent;
    public final Object causingSubscriber;
    public final EventBus eventBus;
    public final Throwable throwable;

    public SubscriberExceptionEvent(EventBus eventBus0, Throwable throwable0, Object object0, Object object1) {
        this.eventBus = eventBus0;
        this.throwable = throwable0;
        this.causingEvent = object0;
        this.causingSubscriber = object1;
    }
}

