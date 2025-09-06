package org.greenrobot.eventbus;

import java.util.logging.Level;

final class BackgroundPoster implements Runnable, Poster {
    private final EventBus eventBus;
    private volatile boolean executorRunning;
    private final PendingPostQueue queue;

    public BackgroundPoster(EventBus eventBus0) {
        this.eventBus = eventBus0;
        this.queue = new PendingPostQueue();
    }

    @Override  // org.greenrobot.eventbus.Poster
    public void enqueue(Subscription subscription0, Object object0) {
        PendingPost pendingPost0 = PendingPost.obtainPendingPost(subscription0, object0);
        synchronized(this) {
            this.queue.enqueue(pendingPost0);
            if(!this.executorRunning) {
                this.executorRunning = true;
                this.eventBus.getExecutorService().execute(this);
            }
        }
    }

    @Override
    public void run() {
        try {
            try {
                while(true) {
                    PendingPost pendingPost0 = this.queue.poll(1000);
                    if(pendingPost0 == null) {
                        synchronized(this) {
                            pendingPost0 = this.queue.poll();
                            if(pendingPost0 == null) {
                                this.executorRunning = false;
                                this.executorRunning = false;
                                return;
                            }
                        }
                    }
                    this.eventBus.invokeSubscriber(pendingPost0);
                }
                this.executorRunning = false;
                throw throwable0;
            }
            catch(InterruptedException interruptedException0) {
            }
            this.eventBus.getLogger().log(Level.WARNING, "jeb-dexdec-sb-st-2627 was interruppted", interruptedException0);
            this.executorRunning = false;
            return;
        }
        catch(Throwable throwable0) {
        }
        this.executorRunning = false;
        throw throwable0;
    }
}

