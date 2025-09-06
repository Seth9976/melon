package org.greenrobot.eventbus;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

public class HandlerPoster extends Handler implements Poster {
    private final EventBus eventBus;
    private boolean handlerActive;
    private final int maxMillisInsideHandleMessage;
    private final PendingPostQueue queue;

    public HandlerPoster(EventBus eventBus0, Looper looper0, int v) {
        super(looper0);
        this.eventBus = eventBus0;
        this.maxMillisInsideHandleMessage = v;
        this.queue = new PendingPostQueue();
    }

    @Override  // org.greenrobot.eventbus.Poster
    public void enqueue(Subscription subscription0, Object object0) {
        PendingPost pendingPost0 = PendingPost.obtainPendingPost(subscription0, object0);
        synchronized(this) {
            this.queue.enqueue(pendingPost0);
            if(!this.handlerActive) {
                this.handlerActive = true;
                if(!this.sendMessage(this.obtainMessage())) {
                    throw new EventBusException("Could not send handler message");
                }
            }
        }
    }

    @Override  // android.os.Handler
    public void handleMessage(Message message0) {
        try {
            long v = SystemClock.uptimeMillis();
            do {
                PendingPost pendingPost0 = this.queue.poll();
                if(pendingPost0 == null) {
                    synchronized(this) {
                        pendingPost0 = this.queue.poll();
                        if(pendingPost0 == null) {
                            this.handlerActive = false;
                            return;
                        }
                    }
                }
                this.eventBus.invokeSubscriber(pendingPost0);
            }
            while(SystemClock.uptimeMillis() - v < ((long)this.maxMillisInsideHandleMessage));
            if(!this.sendMessage(this.obtainMessage())) {
                throw new EventBusException("Could not send handler message");
            }
            this.handlerActive = true;
            return;
        }
        catch(Throwable throwable0) {
        }
        this.handlerActive = false;
        throw throwable0;
    }
}

