package com.google.android.exoplayer2.upstream;

import android.content.Context;

public final class DefaultDataSourceFactory implements Factory {
    private final Factory baseDataSourceFactory;
    private final Context context;
    private final TransferListener listener;

    public DefaultDataSourceFactory(Context context0, Factory dataSource$Factory0) {
        this(context0, null, dataSource$Factory0);
    }

    public DefaultDataSourceFactory(Context context0, TransferListener transferListener0, Factory dataSource$Factory0) {
        this.context = context0.getApplicationContext();
        this.listener = transferListener0;
        this.baseDataSourceFactory = dataSource$Factory0;
    }

    public DefaultDataSourceFactory(Context context0, String s) {
        this(context0, s, null);
    }

    public DefaultDataSourceFactory(Context context0, String s, TransferListener transferListener0) {
        this(context0, transferListener0, new DefaultHttpDataSourceFactory(s, transferListener0));
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSource$Factory
    public DataSource createDataSource() {
        return this.createDataSource();
    }

    public DefaultDataSource createDataSource() {
        DataSource dataSource0 = this.baseDataSourceFactory.createDataSource();
        DefaultDataSource defaultDataSource0 = new DefaultDataSource(this.context, dataSource0);
        TransferListener transferListener0 = this.listener;
        if(transferListener0 != null) {
            defaultDataSource0.addTransferListener(transferListener0);
        }
        return defaultDataSource0;
    }
}

