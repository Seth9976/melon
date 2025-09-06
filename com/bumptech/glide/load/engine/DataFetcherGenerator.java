package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;

interface DataFetcherGenerator {
    public interface FetcherReadyCallback {
        void onDataFetcherFailed(Key arg1, Exception arg2, DataFetcher arg3, DataSource arg4);

        void onDataFetcherReady(Key arg1, Object arg2, DataFetcher arg3, DataSource arg4, Key arg5);

        void reschedule();
    }

    void cancel();

    boolean startNext();
}

