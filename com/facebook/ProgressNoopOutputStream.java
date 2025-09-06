package com.facebook;

import android.os.Handler;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u000B\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001A\u00020\t2\b\u0010\b\u001A\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000BJ\u0019\u0010\u000E\u001A\u000E\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u000E\u0010\u000FJ\u0015\u0010\u0012\u001A\u00020\t2\u0006\u0010\u0011\u001A\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001A\u00020\t2\u0006\u0010\u0015\u001A\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\'\u0010\u0016\u001A\u00020\t2\u0006\u0010\u0015\u001A\u00020\u00142\u0006\u0010\u0019\u001A\u00020\u00182\u0006\u0010\u001A\u001A\u00020\u0018H\u0016¢\u0006\u0004\b\u0016\u0010\u001BJ\u0017\u0010\u0016\u001A\u00020\t2\u0006\u0010\u001C\u001A\u00020\u0018H\u0016¢\u0006\u0004\b\u0016\u0010\u001DR\u0016\u0010\u0004\u001A\u0004\u0018\u00010\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u001ER \u0010 \u001A\u000E\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\r0\u001F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010\b\u001A\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\b\u0010\"R\u0018\u0010#\u001A\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b#\u0010$R$\u0010&\u001A\u00020\u00182\u0006\u0010%\u001A\u00020\u00188\u0006@BX\u0086\u000E¢\u0006\f\n\u0004\b&\u0010\'\u001A\u0004\b(\u0010)¨\u0006*"}, d2 = {"Lcom/facebook/ProgressNoopOutputStream;", "Ljava/io/OutputStream;", "Lcom/facebook/RequestOutputStream;", "Landroid/os/Handler;", "callbackHandler", "<init>", "(Landroid/os/Handler;)V", "Lcom/facebook/GraphRequest;", "currentRequest", "Lie/H;", "setCurrentRequest", "(Lcom/facebook/GraphRequest;)V", "", "Lcom/facebook/RequestProgress;", "getProgressMap", "()Ljava/util/Map;", "", "size", "addProgress", "(J)V", "", "buffer", "write", "([B)V", "", "offset", "length", "([BII)V", "oneByte", "(I)V", "Landroid/os/Handler;", "", "progressMap", "Ljava/util/Map;", "Lcom/facebook/GraphRequest;", "currentRequestProgress", "Lcom/facebook/RequestProgress;", "<set-?>", "maxProgress", "I", "getMaxProgress", "()I", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class ProgressNoopOutputStream extends OutputStream implements RequestOutputStream {
    @Nullable
    private final Handler callbackHandler;
    @Nullable
    private GraphRequest currentRequest;
    @Nullable
    private RequestProgress currentRequestProgress;
    private int maxProgress;
    @NotNull
    private final Map progressMap;

    public ProgressNoopOutputStream(@Nullable Handler handler0) {
        this.callbackHandler = handler0;
        this.progressMap = new HashMap();
    }

    public final void addProgress(long v) {
        GraphRequest graphRequest0 = this.currentRequest;
        if(graphRequest0 == null) {
            return;
        }
        if(this.currentRequestProgress == null) {
            RequestProgress requestProgress0 = new RequestProgress(this.callbackHandler, graphRequest0);
            this.currentRequestProgress = requestProgress0;
            this.progressMap.put(graphRequest0, requestProgress0);
        }
        RequestProgress requestProgress1 = this.currentRequestProgress;
        if(requestProgress1 != null) {
            requestProgress1.addToMax(v);
        }
        this.maxProgress += (int)v;
    }

    public final int getMaxProgress() {
        return this.maxProgress;
    }

    @NotNull
    public final Map getProgressMap() {
        return this.progressMap;
    }

    @Override  // com.facebook.RequestOutputStream
    public void setCurrentRequest(@Nullable GraphRequest graphRequest0) {
        this.currentRequest = graphRequest0;
        this.currentRequestProgress = graphRequest0 == null ? null : ((RequestProgress)this.progressMap.get(graphRequest0));
    }

    @Override
    public void write(int v) {
        this.addProgress(1L);
    }

    @Override
    public void write(@NotNull byte[] arr_b) {
        q.g(arr_b, "buffer");
        this.addProgress(((long)arr_b.length));
    }

    @Override
    public void write(@NotNull byte[] arr_b, int v, int v1) {
        q.g(arr_b, "buffer");
        this.addProgress(((long)v1));
    }
}

