package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import java.io.IOException;

public final class DummyDataSource implements DataSource {
    public static final Factory FACTORY;
    public static final DummyDataSource INSTANCE;

    static {
        DummyDataSource.INSTANCE = new DummyDataSource();
        DummyDataSource.FACTORY = new c();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSource
    public void addTransferListener(TransferListener transferListener0) {
    }

    public static DummyDataSource b() {
        return new DummyDataSource();
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSource
    public void close() {
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSource
    public Uri getUri() {
        return null;
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSource
    public long open(DataSpec dataSpec0) {
        throw new IOException("Dummy source");
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSource
    public int read(byte[] arr_b, int v, int v1) {
        throw new UnsupportedOperationException();
    }
}

