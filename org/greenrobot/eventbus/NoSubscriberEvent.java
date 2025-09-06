package org.greenrobot.eventbus;

public final class NoSubscriberEvent {
    public final EventBus eventBus;
    public final Object originalEvent;

    public NoSubscriberEvent(EventBus eventBus0, Object object0) {
        this.eventBus = eventBus0;
        this.originalEvent = object0;
    }
}

