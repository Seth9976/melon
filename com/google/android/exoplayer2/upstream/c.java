package com.google.android.exoplayer2.upstream;

public final class c implements Factory {
    @Override  // com.google.android.exoplayer2.upstream.DataSource$Factory
    public final DataSource createDataSource() {
        return DummyDataSource.b();
    }
}

