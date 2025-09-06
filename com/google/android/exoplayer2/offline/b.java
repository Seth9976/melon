package com.google.android.exoplayer2.offline;

import android.os.Handler.Callback;
import android.os.Message;

public final class b implements Handler.Callback {
    public final int a;
    public final Object b;

    public b(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // android.os.Handler$Callback
    public final boolean handleMessage(Message message0) {
        return this.a == 0 ? ((MediaPreparer)this.b).handleDownloadHelperCallbackMessage(message0) : ((DownloadManager)this.b).handleMainMessage(message0);
    }
}

