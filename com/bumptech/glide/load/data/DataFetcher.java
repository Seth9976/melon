package com.bumptech.glide.load.data;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;

public interface DataFetcher {
    public interface DataCallback {
        void onDataReady(Object arg1);

        void onLoadFailed(Exception arg1);
    }

    void cancel();

    void cleanup();

    Class getDataClass();

    DataSource getDataSource();

    void loadData(Priority arg1, DataCallback arg2);
}

