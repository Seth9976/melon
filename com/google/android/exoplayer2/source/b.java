package com.google.android.exoplayer2.source;

import android.os.Handler.Callback;
import android.os.Message;

public final class b implements Handler.Callback {
    public final ConcatenatingMediaSource a;

    public b(ConcatenatingMediaSource concatenatingMediaSource0) {
        this.a = concatenatingMediaSource0;
    }

    @Override  // android.os.Handler$Callback
    public final boolean handleMessage(Message message0) {
        return this.a.handleMessage(message0);
    }
}

