package com.google.android.exoplayer2.offline;

public final class f implements Runnable {
    public final int a;
    public final Object b;

    public f(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override
    public final void run() {
        if(this.a != 0) {
            ((DownloadHelper)this.b).lambda$onMediaPrepared$2();
            return;
        }
        ForegroundNotificationUpdater.a(((ForegroundNotificationUpdater)this.b));
    }
}

