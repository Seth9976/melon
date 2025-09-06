package org.greenrobot.eventbus;

final class PendingPostQueue {
    private PendingPost head;
    private PendingPost tail;

    public void enqueue(PendingPost pendingPost0) {
        synchronized(this) {
            if(pendingPost0 != null) {
                PendingPost pendingPost1 = this.tail;
                if(pendingPost1 != null) {
                    pendingPost1.next = pendingPost0;
                    this.tail = pendingPost0;
                }
                else if(this.head == null) {
                    this.tail = pendingPost0;
                    this.head = pendingPost0;
                }
                else {
                    throw new IllegalStateException("Head present, but no tail");
                }
                this.notifyAll();
                return;
            }
        }
        throw new NullPointerException("null cannot be enqueued");
    }

    public PendingPost poll() {
        PendingPost pendingPost0;
        synchronized(this) {
            pendingPost0 = this.head;
            if(pendingPost0 != null) {
                this.head = pendingPost0.next;
                if(pendingPost0.next == null) {
                    this.tail = null;
                }
            }
        }
        return pendingPost0;
    }

    public PendingPost poll(int v) {
        synchronized(this) {
            if(this.head == null) {
                this.wait(((long)v));
            }
            return this.poll();
        }
    }
}

