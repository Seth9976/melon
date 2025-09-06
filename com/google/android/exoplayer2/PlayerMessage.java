package com.google.android.exoplayer2;

import android.os.Handler;
import com.google.android.exoplayer2.util.Assertions;

public final class PlayerMessage {
    public interface Sender {
        void sendMessage(PlayerMessage arg1);
    }

    public interface Target {
        void handleMessage(int arg1, Object arg2);
    }

    private boolean deleteAfterDelivery;
    private Handler handler;
    private boolean isCanceled;
    private boolean isDelivered;
    private boolean isProcessed;
    private boolean isSent;
    private Object payload;
    private long positionMs;
    private final Sender sender;
    private final Target target;
    private final Timeline timeline;
    private int type;
    private int windowIndex;

    public PlayerMessage(Sender playerMessage$Sender0, Target playerMessage$Target0, Timeline timeline0, int v, Handler handler0) {
        this.sender = playerMessage$Sender0;
        this.target = playerMessage$Target0;
        this.timeline = timeline0;
        this.handler = handler0;
        this.windowIndex = v;
        this.positionMs = 0x8000000000000001L;
        this.deleteAfterDelivery = true;
    }

    public boolean blockUntilDelivered() {
        synchronized(this) {
            Assertions.checkState(this.isSent);
            Assertions.checkState(this.handler.getLooper().getThread() != Thread.currentThread());
            while(!this.isProcessed) {
                this.wait();
            }
            return this.isDelivered;
        }
    }

    public PlayerMessage cancel() {
        synchronized(this) {
            Assertions.checkState(this.isSent);
            this.isCanceled = true;
            this.markAsProcessed(false);
            return this;
        }
    }

    public boolean getDeleteAfterDelivery() {
        return this.deleteAfterDelivery;
    }

    public Handler getHandler() {
        return this.handler;
    }

    public Object getPayload() {
        return this.payload;
    }

    public long getPositionMs() {
        return this.positionMs;
    }

    public Target getTarget() {
        return this.target;
    }

    public Timeline getTimeline() {
        return this.timeline;
    }

    public int getType() {
        return this.type;
    }

    public int getWindowIndex() {
        return this.windowIndex;
    }

    public boolean isCanceled() {
        synchronized(this) {
        }
        return this.isCanceled;
    }

    public void markAsProcessed(boolean z) {
        synchronized(this) {
            this.isDelivered |= z;
            this.isProcessed = true;
            this.notifyAll();
        }
    }

    public PlayerMessage send() {
        Assertions.checkState(!this.isSent);
        if(this.positionMs == 0x8000000000000001L) {
            Assertions.checkArgument(this.deleteAfterDelivery);
        }
        this.isSent = true;
        this.sender.sendMessage(this);
        return this;
    }

    public PlayerMessage setDeleteAfterDelivery(boolean z) {
        Assertions.checkState(!this.isSent);
        this.deleteAfterDelivery = z;
        return this;
    }

    public PlayerMessage setHandler(Handler handler0) {
        Assertions.checkState(!this.isSent);
        this.handler = handler0;
        return this;
    }

    public PlayerMessage setPayload(Object object0) {
        Assertions.checkState(!this.isSent);
        this.payload = object0;
        return this;
    }

    public PlayerMessage setPosition(int v, long v1) {
        boolean z = true;
        Assertions.checkState(!this.isSent);
        if(v1 == 0x8000000000000001L) {
            z = false;
        }
        Assertions.checkArgument(z);
        if(v < 0 || !this.timeline.isEmpty() && v >= this.timeline.getWindowCount()) {
            throw new IllegalSeekPositionException(this.timeline, v, v1);
        }
        this.windowIndex = v;
        this.positionMs = v1;
        return this;
    }

    public PlayerMessage setPosition(long v) {
        Assertions.checkState(!this.isSent);
        this.positionMs = v;
        return this;
    }

    public PlayerMessage setType(int v) {
        Assertions.checkState(!this.isSent);
        this.type = v;
        return this;
    }
}

