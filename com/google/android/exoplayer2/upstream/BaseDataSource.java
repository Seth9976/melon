package com.google.android.exoplayer2.upstream;

import java.util.ArrayList;

public abstract class BaseDataSource implements DataSource {
    private DataSpec dataSpec;
    private final boolean isNetwork;
    private int listenerCount;
    private final ArrayList listeners;

    public BaseDataSource(boolean z) {
        this.isNetwork = z;
        this.listeners = new ArrayList(1);
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSource
    public final void addTransferListener(TransferListener transferListener0) {
        if(!this.listeners.contains(transferListener0)) {
            this.listeners.add(transferListener0);
            ++this.listenerCount;
        }
    }

    public final void bytesTransferred(int v) {
        DataSpec dataSpec0 = this.dataSpec;
        for(int v1 = 0; v1 < this.listenerCount; ++v1) {
            ((TransferListener)this.listeners.get(v1)).onBytesTransferred(this, dataSpec0, this.isNetwork, v);
        }
    }

    public final void transferEnded() {
        DataSpec dataSpec0 = this.dataSpec;
        for(int v = 0; v < this.listenerCount; ++v) {
            ((TransferListener)this.listeners.get(v)).onTransferEnd(this, dataSpec0, this.isNetwork);
        }
        this.dataSpec = null;
    }

    public final void transferInitializing(DataSpec dataSpec0) {
        for(int v = 0; v < this.listenerCount; ++v) {
            ((TransferListener)this.listeners.get(v)).onTransferInitializing(this, dataSpec0, this.isNetwork);
        }
    }

    public final void transferStarted(DataSpec dataSpec0) {
        this.dataSpec = dataSpec0;
        for(int v = 0; v < this.listenerCount; ++v) {
            ((TransferListener)this.listeners.get(v)).onTransferStart(this, dataSpec0, this.isNetwork);
        }
    }
}

