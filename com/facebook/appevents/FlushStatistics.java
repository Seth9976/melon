package com.facebook.appevents;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001A\u0010\u0003\u001A\u00020\u0004X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001A\u0010\t\u001A\u00020\nX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\f\"\u0004\b\r\u0010\u000E¨\u0006\u000F"}, d2 = {"Lcom/facebook/appevents/FlushStatistics;", "", "()V", "numEvents", "", "getNumEvents", "()I", "setNumEvents", "(I)V", "result", "Lcom/facebook/appevents/FlushResult;", "getResult", "()Lcom/facebook/appevents/FlushResult;", "setResult", "(Lcom/facebook/appevents/FlushResult;)V", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class FlushStatistics {
    private int numEvents;
    @NotNull
    private FlushResult result;

    public FlushStatistics() {
        this.result = FlushResult.SUCCESS;
    }

    public final int getNumEvents() {
        return this.numEvents;
    }

    @NotNull
    public final FlushResult getResult() {
        return this.result;
    }

    public final void setNumEvents(int v) {
        this.numEvents = v;
    }

    public final void setResult(@NotNull FlushResult flushResult0) {
        q.g(flushResult0, "<set-?>");
        this.result = flushResult0;
    }
}

