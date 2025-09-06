package org.greenrobot.eventbus;

class AsyncPoster implements Runnable, Poster {
    private final EventBus eventBus;
    private final PendingPostQueue queue;

    public AsyncPoster(EventBus eventBus0) {
        this.eventBus = eventBus0;
        this.queue = new PendingPostQueue();
    }

    @Override  // org.greenrobot.eventbus.Poster
    public void enqueue(Subscription subscription0, Object object0) {
        PendingPost pendingPost0 = PendingPost.obtainPendingPost(subscription0, object0);
        this.queue.enqueue(pendingPost0);
        this.eventBus.getExecutorService().execute(this);
    }

    @Override
    public void run() {
        PendingPost pendingPost0 = this.queue.poll();
        if(pendingPost0 == null) {
            throw new IllegalStateException("No pending post available");
        }
        this.eventBus.invokeSubscriber(pendingPost0);
    }
}

