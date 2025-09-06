package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import java.util.Map;

public final class PriorityDataSource implements DataSource {
    private final int priority;
    private final PriorityTaskManager priorityTaskManager;
    private final DataSource upstream;

    public PriorityDataSource(DataSource dataSource0, PriorityTaskManager priorityTaskManager0, int v) {
        this.upstream = (DataSource)Assertions.checkNotNull(dataSource0);
        this.priorityTaskManager = (PriorityTaskManager)Assertions.checkNotNull(priorityTaskManager0);
        this.priority = v;
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSource
    public void addTransferListener(TransferListener transferListener0) {
        this.upstream.addTransferListener(transferListener0);
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSource
    public void close() {
        this.upstream.close();
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSource
    public Map getResponseHeaders() {
        return this.upstream.getResponseHeaders();
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSource
    public Uri getUri() {
        return this.upstream.getUri();
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSource
    public long open(DataSpec dataSpec0) {
        this.priorityTaskManager.proceedOrThrow(this.priority);
        return this.upstream.open(dataSpec0);
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSource
    public int read(byte[] arr_b, int v, int v1) {
        this.priorityTaskManager.proceedOrThrow(this.priority);
        return this.upstream.read(arr_b, v, v1);
    }
}

