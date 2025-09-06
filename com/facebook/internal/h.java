package com.facebook.internal;

public final class h implements Runnable {
    public final int a;
    public final Object b;
    public final Object c;

    public h(int v, Object object0, Object object1) {
        this.a = v;
        this.b = object0;
        this.c = object1;
        super();
    }

    @Override
    public final void run() {
        if(this.a != 0) {
            FetchedAppSettingsManager.pollCallbacks$lambda$2(((FetchedAppSettingsCallback)this.b), ((FetchedAppSettings)this.c));
            return;
        }
        WorkQueue.execute$lambda$2(((WorkNode)this.b), ((WorkQueue)this.c));
    }
}

