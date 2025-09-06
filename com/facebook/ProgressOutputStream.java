package com.facebook;

import android.os.Handler;
import b.l;
import java.io.FilterOutputStream;
import java.io.OutputStream;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0013\u0018\u00002\u00020\u00012\u00020\u0002B3\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0012\u0010\n\u001A\u000E\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\u0006\u0010\f\u001A\u00020\u000B\u00A2\u0006\u0004\b\r\u0010\u000EJ\u0017\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u000F\u001A\u00020\u000BH\u0002\u00A2\u0006\u0004\b\u0011\u0010\u0012J\u000F\u0010\u0013\u001A\u00020\u0010H\u0002\u00A2\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0016\u001A\u00020\u00102\b\u0010\u0015\u001A\u0004\u0018\u00010\bH\u0016\u00A2\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001A\u001A\u00020\u00102\u0006\u0010\u0019\u001A\u00020\u0018H\u0016\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\'\u0010\u001A\u001A\u00020\u00102\u0006\u0010\u0019\u001A\u00020\u00182\u0006\u0010\u001D\u001A\u00020\u001C2\u0006\u0010\u001E\u001A\u00020\u001CH\u0016\u00A2\u0006\u0004\b\u001A\u0010\u001FJ\u0017\u0010\u001A\u001A\u00020\u00102\u0006\u0010 \u001A\u00020\u001CH\u0016\u00A2\u0006\u0004\b\u001A\u0010!J\u000F\u0010\"\u001A\u00020\u0010H\u0016\u00A2\u0006\u0004\b\"\u0010\u0014R\u0014\u0010\u0006\u001A\u00020\u00058\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0006\u0010#R \u0010\n\u001A\u000E\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00078\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\n\u0010$R\u0017\u0010\f\u001A\u00020\u000B8\u0006\u00A2\u0006\f\n\u0004\b\f\u0010%\u001A\u0004\b&\u0010\'R\u0014\u0010(\u001A\u00020\u000B8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b(\u0010%R$\u0010*\u001A\u00020\u000B2\u0006\u0010)\u001A\u00020\u000B8\u0006@BX\u0086\u000E\u00A2\u0006\f\n\u0004\b*\u0010%\u001A\u0004\b+\u0010\'R\u0016\u0010,\u001A\u00020\u000B8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b,\u0010%R\u0018\u0010-\u001A\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b-\u0010.\u00A8\u0006/"}, d2 = {"Lcom/facebook/ProgressOutputStream;", "Ljava/io/FilterOutputStream;", "Lcom/facebook/RequestOutputStream;", "Ljava/io/OutputStream;", "out", "Lcom/facebook/GraphRequestBatch;", "requests", "", "Lcom/facebook/GraphRequest;", "Lcom/facebook/RequestProgress;", "progressMap", "", "maxProgress", "<init>", "(Ljava/io/OutputStream;Lcom/facebook/GraphRequestBatch;Ljava/util/Map;J)V", "size", "Lie/H;", "addProgress", "(J)V", "reportBatchProgress", "()V", "request", "setCurrentRequest", "(Lcom/facebook/GraphRequest;)V", "", "buffer", "write", "([B)V", "", "offset", "length", "([BII)V", "oneByte", "(I)V", "close", "Lcom/facebook/GraphRequestBatch;", "Ljava/util/Map;", "J", "getMaxProgress", "()J", "threshold", "<set-?>", "batchProgress", "getBatchProgress", "lastReportedProgress", "currentRequestProgress", "Lcom/facebook/RequestProgress;", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class ProgressOutputStream extends FilterOutputStream implements RequestOutputStream {
    private long batchProgress;
    @Nullable
    private RequestProgress currentRequestProgress;
    private long lastReportedProgress;
    private final long maxProgress;
    @NotNull
    private final Map progressMap;
    @NotNull
    private final GraphRequestBatch requests;
    private final long threshold;

    public ProgressOutputStream(@NotNull OutputStream outputStream0, @NotNull GraphRequestBatch graphRequestBatch0, @NotNull Map map0, long v) {
        q.g(outputStream0, "out");
        q.g(graphRequestBatch0, "requests");
        q.g(map0, "progressMap");
        super(outputStream0);
        this.requests = graphRequestBatch0;
        this.progressMap = map0;
        this.maxProgress = v;
        this.threshold = FacebookSdk.getOnProgressThreshold();
    }

    private final void addProgress(long v) {
        RequestProgress requestProgress0 = this.currentRequestProgress;
        if(requestProgress0 != null) {
            requestProgress0.addProgress(v);
        }
        long v1 = this.batchProgress + v;
        this.batchProgress = v1;
        if(v1 < this.lastReportedProgress + this.threshold && v1 < this.maxProgress) {
            return;
        }
        this.reportBatchProgress();
    }

    public static void c(Callback graphRequestBatch$Callback0, ProgressOutputStream progressOutputStream0) {
        ProgressOutputStream.reportBatchProgress$lambda$0(graphRequestBatch$Callback0, progressOutputStream0);
    }

    @Override
    public void close() {
        super.close();
        for(Object object0: this.progressMap.values()) {
            ((RequestProgress)object0).reportProgress();
        }
        this.reportBatchProgress();
    }

    public final long getBatchProgress() {
        return this.batchProgress;
    }

    public final long getMaxProgress() {
        return this.maxProgress;
    }

    private final void reportBatchProgress() {
        if(this.batchProgress > this.lastReportedProgress) {
            for(Object object0: this.requests.getCallbacks()) {
                Callback graphRequestBatch$Callback0 = (Callback)object0;
                if(graphRequestBatch$Callback0 instanceof OnProgressCallback) {
                    Handler handler0 = this.requests.getCallbackHandler();
                    if(handler0 == null) {
                        ((OnProgressCallback)graphRequestBatch$Callback0).onBatchProgress(this.requests, this.batchProgress, this.maxProgress);
                    }
                    else {
                        handler0.post(new l(5, ((OnProgressCallback)graphRequestBatch$Callback0), this));
                    }
                }
            }
            this.lastReportedProgress = this.batchProgress;
        }
    }

    private static final void reportBatchProgress$lambda$0(Callback graphRequestBatch$Callback0, ProgressOutputStream progressOutputStream0) {
        q.g(graphRequestBatch$Callback0, "$callback");
        q.g(progressOutputStream0, "this$0");
        ((OnProgressCallback)graphRequestBatch$Callback0).onBatchProgress(progressOutputStream0.requests, progressOutputStream0.batchProgress, progressOutputStream0.maxProgress);
    }

    @Override  // com.facebook.RequestOutputStream
    public void setCurrentRequest(@Nullable GraphRequest graphRequest0) {
        this.currentRequestProgress = graphRequest0 == null ? null : ((RequestProgress)this.progressMap.get(graphRequest0));
    }

    @Override
    public void write(int v) {
        this.out.write(v);
        this.addProgress(1L);
    }

    @Override
    public void write(@NotNull byte[] arr_b) {
        q.g(arr_b, "buffer");
        this.out.write(arr_b);
        this.addProgress(((long)arr_b.length));
    }

    @Override
    public void write(@NotNull byte[] arr_b, int v, int v1) {
        q.g(arr_b, "buffer");
        this.out.write(arr_b, v, v1);
        this.addProgress(((long)v1));
    }
}

