package com.google.android.exoplayer2.util;

import android.os.Handler;
import java.util.concurrent.CopyOnWriteArrayList;

public final class EventDispatcher {
    public interface Event {
        void sendTo(Object arg1);
    }

    static final class HandlerAndListener {
        private final Handler handler;
        private final Object listener;
        private boolean released;

        public HandlerAndListener(Handler handler0, Object object0) {
            this.handler = handler0;
            this.listener = object0;
        }

        public static Object access$000(HandlerAndListener eventDispatcher$HandlerAndListener0) {
            return eventDispatcher$HandlerAndListener0.listener;
        }

        public void dispatch(Event eventDispatcher$Event0) {
            a a0 = new a(this, eventDispatcher$Event0);
            this.handler.post(a0);
        }

        private void lambda$dispatch$0(Event eventDispatcher$Event0) {
            if(!this.released) {
                eventDispatcher$Event0.sendTo(this.listener);
            }
        }

        public void release() {
            this.released = true;
        }
    }

    private final CopyOnWriteArrayList listeners;

    public EventDispatcher() {
        this.listeners = new CopyOnWriteArrayList();
    }

    public void addListener(Handler handler0, Object object0) {
        Assertions.checkArgument(handler0 != null && object0 != null);
        this.removeListener(object0);
        HandlerAndListener eventDispatcher$HandlerAndListener0 = new HandlerAndListener(handler0, object0);
        this.listeners.add(eventDispatcher$HandlerAndListener0);
    }

    public void dispatch(Event eventDispatcher$Event0) {
        for(Object object0: this.listeners) {
            ((HandlerAndListener)object0).dispatch(eventDispatcher$Event0);
        }
    }

    public void removeListener(Object object0) {
        for(Object object1: this.listeners) {
            HandlerAndListener eventDispatcher$HandlerAndListener0 = (HandlerAndListener)object1;
            if(HandlerAndListener.access$000(eventDispatcher$HandlerAndListener0) == object0) {
                eventDispatcher$HandlerAndListener0.release();
                this.listeners.remove(eventDispatcher$HandlerAndListener0);
            }
        }
    }
}

