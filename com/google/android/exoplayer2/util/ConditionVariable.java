package com.google.android.exoplayer2.util;

public final class ConditionVariable {
    private final Clock clock;
    private boolean isOpen;

    public ConditionVariable() {
        this(Clock.DEFAULT);
    }

    public ConditionVariable(Clock clock0) {
        this.clock = clock0;
    }

    public void block() {
        synchronized(this) {
            while(!this.isOpen) {
                this.wait();
            }
        }
    }

    public boolean block(long v) {
        synchronized(this) {
            if(v <= 0L) {
                return this.isOpen;
            }
            long v2 = this.clock.elapsedRealtime();
            long v3 = v + v2;
            if(v3 < v2) {
                this.block();
            }
            else {
                while(!this.isOpen && v2 < v3) {
                    this.wait(v3 - v2);
                    v2 = this.clock.elapsedRealtime();
                }
            }
            return this.isOpen;
        }
    }

    public boolean close() {
        boolean z;
        synchronized(this) {
            z = this.isOpen;
            this.isOpen = false;
        }
        return z;
    }

    public boolean isOpen() {
        synchronized(this) {
        }
        return this.isOpen;
    }

    public boolean open() {
        synchronized(this) {
            if(this.isOpen) {
                return false;
            }
            this.isOpen = true;
            this.notifyAll();
            return true;
        }
    }
}

