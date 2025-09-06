package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher.DataCallback;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.model.ModelLoader.LoadData;
import com.bumptech.glide.util.LogTime;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

class SourceGenerator implements FetcherReadyCallback, DataFetcherGenerator {
    private static final String TAG = "SourceGenerator";
    private final FetcherReadyCallback cb;
    private volatile Object dataToCache;
    private final DecodeHelper helper;
    private volatile LoadData loadData;
    private volatile int loadDataListIndex;
    private volatile DataCacheKey originalKey;
    private volatile DataCacheGenerator sourceCacheGenerator;

    public SourceGenerator(DecodeHelper decodeHelper0, FetcherReadyCallback dataFetcherGenerator$FetcherReadyCallback0) {
        this.helper = decodeHelper0;
        this.cb = dataFetcherGenerator$FetcherReadyCallback0;
    }

    private boolean cacheData(Object object0) {
        Throwable throwable1;
        DataRewinder dataRewinder0;
        long v = LogTime.getLogTime();
        boolean z = false;
        try {
            dataRewinder0 = this.helper.getRewinder(object0);
            Object object1 = dataRewinder0.rewindAndGet();
            Encoder encoder0 = this.helper.getSourceEncoder(object1);
            DataCacheWriter dataCacheWriter0 = new DataCacheWriter(encoder0, object1, this.helper.getOptions());
            DataCacheKey dataCacheKey0 = new DataCacheKey(this.loadData.sourceKey, this.helper.getSignature());
            DiskCache diskCache0 = this.helper.getDiskCache();
            diskCache0.put(dataCacheKey0, dataCacheWriter0);
            if(Log.isLoggable("SourceGenerator", 2)) {
                Log.v("SourceGenerator", "Finished encoding source to cache, key: " + dataCacheKey0 + ", data: " + object0 + ", encoder: " + encoder0 + ", duration: " + LogTime.getElapsedMillis(v));
            }
            if(diskCache0.get(dataCacheKey0) != null) {
                this.originalKey = dataCacheKey0;
                this.sourceCacheGenerator = new DataCacheGenerator(Collections.singletonList(this.loadData.sourceKey), this.helper, this);
                goto label_14;
            }
            goto label_16;
        }
        catch(Throwable throwable0) {
            throwable1 = throwable0;
            goto label_31;
        }
    label_14:
        this.loadData.fetcher.cleanup();
        return true;
        try {
        label_16:
            if(Log.isLoggable("SourceGenerator", 3)) {
                Log.d("SourceGenerator", "Attempt to write: " + this.originalKey + ", data: " + object0 + " to the disk cache failed, maybe the disk cache is disabled? Trying to decode the data directly...");
            }
        }
        catch(Throwable throwable0) {
            throwable1 = throwable0;
            goto label_31;
        }
        try {
            Key key0 = this.loadData.sourceKey;
            Object object2 = dataRewinder0.rewindAndGet();
            DataFetcher dataFetcher0 = this.loadData.fetcher;
            DataSource dataSource0 = this.loadData.fetcher.getDataSource();
            this.cb.onDataFetcherReady(key0, object2, dataFetcher0, dataSource0, this.loadData.sourceKey);
            return false;
        }
        catch(Throwable throwable2) {
            throwable1 = throwable2;
            z = true;
        }
    label_31:
        if(!z) {
            this.loadData.fetcher.cleanup();
        }
        throw throwable1;
    }

    @Override  // com.bumptech.glide.load.engine.DataFetcherGenerator
    public void cancel() {
        LoadData modelLoader$LoadData0 = this.loadData;
        if(modelLoader$LoadData0 != null) {
            modelLoader$LoadData0.fetcher.cancel();
        }
    }

    private boolean hasNextModelLoader() {
        return this.loadDataListIndex < this.helper.getLoadData().size();
    }

    public boolean isCurrentRequest(LoadData modelLoader$LoadData0) {
        return this.loadData != null && this.loadData == modelLoader$LoadData0;
    }

    @Override  // com.bumptech.glide.load.engine.DataFetcherGenerator$FetcherReadyCallback
    public void onDataFetcherFailed(Key key0, Exception exception0, DataFetcher dataFetcher0, DataSource dataSource0) {
        DataSource dataSource1 = this.loadData.fetcher.getDataSource();
        this.cb.onDataFetcherFailed(key0, exception0, dataFetcher0, dataSource1);
    }

    @Override  // com.bumptech.glide.load.engine.DataFetcherGenerator$FetcherReadyCallback
    public void onDataFetcherReady(Key key0, Object object0, DataFetcher dataFetcher0, DataSource dataSource0, Key key1) {
        DataSource dataSource1 = this.loadData.fetcher.getDataSource();
        this.cb.onDataFetcherReady(key0, object0, dataFetcher0, dataSource1, key0);
    }

    public void onDataReadyInternal(LoadData modelLoader$LoadData0, Object object0) {
        if(object0 != null && this.helper.getDiskCacheStrategy().isDataCacheable(modelLoader$LoadData0.fetcher.getDataSource())) {
            this.dataToCache = object0;
            this.cb.reschedule();
            return;
        }
        DataSource dataSource0 = modelLoader$LoadData0.fetcher.getDataSource();
        this.cb.onDataFetcherReady(modelLoader$LoadData0.sourceKey, object0, modelLoader$LoadData0.fetcher, dataSource0, this.originalKey);
    }

    public void onLoadFailedInternal(LoadData modelLoader$LoadData0, Exception exception0) {
        DataCacheKey dataCacheKey0 = this.originalKey;
        DataSource dataSource0 = modelLoader$LoadData0.fetcher.getDataSource();
        this.cb.onDataFetcherFailed(dataCacheKey0, exception0, modelLoader$LoadData0.fetcher, dataSource0);
    }

    @Override  // com.bumptech.glide.load.engine.DataFetcherGenerator$FetcherReadyCallback
    public void reschedule() {
        throw new UnsupportedOperationException();
    }

    @Override  // com.bumptech.glide.load.engine.DataFetcherGenerator
    public boolean startNext() {
        if(this.dataToCache != null) {
            try {
                Object object0 = this.dataToCache;
                this.dataToCache = null;
                if(!this.cacheData(object0)) {
                    return true;
                }
            }
            catch(IOException iOException0) {
                if(Log.isLoggable("SourceGenerator", 3)) {
                    Log.d("SourceGenerator", "Failed to properly rewind or write data to cache", iOException0);
                }
            }
        }
        if(this.sourceCacheGenerator != null && this.sourceCacheGenerator.startNext()) {
            return true;
        }
        this.sourceCacheGenerator = null;
        this.loadData = null;
        boolean z = false;
        while(!z && this.hasNextModelLoader()) {
            List list0 = this.helper.getLoadData();
            int v = this.loadDataListIndex;
            this.loadDataListIndex = v + 1;
            this.loadData = (LoadData)list0.get(v);
            if(this.loadData != null) {
                DataSource dataSource0 = this.loadData.fetcher.getDataSource();
                if(this.helper.getDiskCacheStrategy().isDataCacheable(dataSource0)) {
                    this.startNextLoad(this.loadData);
                    z = true;
                }
                else {
                    Class class0 = this.loadData.fetcher.getDataClass();
                    if(this.helper.hasLoadPath(class0)) {
                        this.startNextLoad(this.loadData);
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    private void startNextLoad(LoadData modelLoader$LoadData0) {
        DataFetcher dataFetcher0 = this.loadData.fetcher;
        com.bumptech.glide.load.engine.SourceGenerator.1 sourceGenerator$10 = new DataCallback() {
            @Override  // com.bumptech.glide.load.data.DataFetcher$DataCallback
            public void onDataReady(Object object0) {
                if(SourceGenerator.this.isCurrentRequest(modelLoader$LoadData0)) {
                    SourceGenerator.this.onDataReadyInternal(modelLoader$LoadData0, object0);
                }
            }

            @Override  // com.bumptech.glide.load.data.DataFetcher$DataCallback
            public void onLoadFailed(Exception exception0) {
                if(SourceGenerator.this.isCurrentRequest(modelLoader$LoadData0)) {
                    SourceGenerator.this.onLoadFailedInternal(modelLoader$LoadData0, exception0);
                }
            }
        };
        dataFetcher0.loadData(this.helper.getPriority(), sourceGenerator$10);
    }
}

