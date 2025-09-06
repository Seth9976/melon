package com.google.android.exoplayer2.upstream;

@Deprecated
public final class FileDataSourceFactory implements Factory {
    private final com.google.android.exoplayer2.upstream.FileDataSource.Factory wrappedFactory;

    public FileDataSourceFactory() {
        this(null);
    }

    public FileDataSourceFactory(TransferListener transferListener0) {
        this.wrappedFactory = new com.google.android.exoplayer2.upstream.FileDataSource.Factory().setListener(transferListener0);
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSource$Factory
    public DataSource createDataSource() {
        return this.createDataSource();
    }

    public FileDataSource createDataSource() {
        return this.wrappedFactory.createDataSource();
    }
}

