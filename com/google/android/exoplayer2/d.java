package com.google.android.exoplayer2;

import java.util.concurrent.CopyOnWriteArrayList;

public final class d implements Runnable {
    public final int a;
    public final Object b;
    public final Object c;

    public d(int v, Object object0, Object object1) {
        this.a = v;
        this.b = object0;
        this.c = object1;
        super();
    }

    @Override
    public final void run() {
        if(this.a != 0) {
            ((ExoPlayerImplInternal)this.b).lambda$sendMessageToTargetThread$0(((PlayerMessage)this.c));
            return;
        }
        ExoPlayerImpl.invokeAll(((CopyOnWriteArrayList)this.b), ((ListenerInvocation)this.c));
    }
}

