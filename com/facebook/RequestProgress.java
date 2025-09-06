package com.facebook;

import android.os.Handler;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u000B\u001A\u00020\n2\u0006\u0010\t\u001A\u00020\b¢\u0006\u0004\b\u000B\u0010\fJ\u0015\u0010\r\u001A\u00020\n2\u0006\u0010\t\u001A\u00020\b¢\u0006\u0004\b\r\u0010\fJ\r\u0010\u000E\u001A\u00020\n¢\u0006\u0004\b\u000E\u0010\u000FR\u0016\u0010\u0003\u001A\u0004\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0010R\u0014\u0010\u0005\u001A\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0011R\u0014\u0010\u0012\u001A\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R$\u0010\u0015\u001A\u00020\b2\u0006\u0010\u0014\u001A\u00020\b8\u0006@BX\u0086\u000E¢\u0006\f\n\u0004\b\u0015\u0010\u0013\u001A\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001A\u00020\b8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0018\u0010\u0013R$\u0010\u0019\u001A\u00020\b2\u0006\u0010\u0014\u001A\u00020\b8\u0006@BX\u0086\u000E¢\u0006\f\n\u0004\b\u0019\u0010\u0013\u001A\u0004\b\u001A\u0010\u0017¨\u0006\u001B"}, d2 = {"Lcom/facebook/RequestProgress;", "", "Landroid/os/Handler;", "callbackHandler", "Lcom/facebook/GraphRequest;", "request", "<init>", "(Landroid/os/Handler;Lcom/facebook/GraphRequest;)V", "", "size", "Lie/H;", "addProgress", "(J)V", "addToMax", "reportProgress", "()V", "Landroid/os/Handler;", "Lcom/facebook/GraphRequest;", "threshold", "J", "<set-?>", "progress", "getProgress", "()J", "lastReportedProgress", "maxProgress", "getMaxProgress", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class RequestProgress {
    @Nullable
    private final Handler callbackHandler;
    private long lastReportedProgress;
    private long maxProgress;
    private long progress;
    @NotNull
    private final GraphRequest request;
    private final long threshold;

    public RequestProgress(@Nullable Handler handler0, @NotNull GraphRequest graphRequest0) {
        q.g(graphRequest0, "request");
        super();
        this.callbackHandler = handler0;
        this.request = graphRequest0;
        this.threshold = FacebookSdk.getOnProgressThreshold();
    }

    public final void addProgress(long v) {
        long v1 = this.progress + v;
        this.progress = v1;
        if(v1 < this.lastReportedProgress + this.threshold && v1 < this.maxProgress) {
            return;
        }
        this.reportProgress();
    }

    public final void addToMax(long v) {
        this.maxProgress += v;
    }

    public final long getMaxProgress() {
        return this.maxProgress;
    }

    public final long getProgress() {
        return this.progress;
    }

    public final void reportProgress() {
        if(this.progress > this.lastReportedProgress) {
            Callback graphRequest$Callback0 = this.request.getCallback();
            long v = this.maxProgress;
            if(v > 0L && graphRequest$Callback0 instanceof OnProgressCallback) {
                long v1 = this.progress;
                Handler handler0 = this.callbackHandler;
                if(handler0 == null) {
                    ((OnProgressCallback)graphRequest$Callback0).onProgress(v1, v);
                }
                else {
                    handler0.post(new h(((OnProgressCallback)graphRequest$Callback0), v1, v));
                }
                this.lastReportedProgress = this.progress;
            }
        }
    }

    private static final void reportProgress$lambda$0(Callback graphRequest$Callback0, long v, long v1) {
        ((OnProgressCallback)graphRequest$Callback0).onProgress(v, v1);
    }
}

