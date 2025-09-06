package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher.DataCallback;
import com.bumptech.glide.load.model.ModelLoader.LoadData;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.File;
import java.util.List;

class DataCacheGenerator implements DataCallback, DataFetcherGenerator {
    private File cacheFile;
    private final List cacheKeys;
    private final FetcherReadyCallback cb;
    private final DecodeHelper helper;
    private volatile LoadData loadData;
    private int modelLoaderIndex;
    private List modelLoaders;
    private int sourceIdIndex;
    private Key sourceKey;

    public DataCacheGenerator(DecodeHelper decodeHelper0, FetcherReadyCallback dataFetcherGenerator$FetcherReadyCallback0) {
        this(decodeHelper0.getCacheKeys(), decodeHelper0, dataFetcherGenerator$FetcherReadyCallback0);
    }

    public DataCacheGenerator(List list0, DecodeHelper decodeHelper0, FetcherReadyCallback dataFetcherGenerator$FetcherReadyCallback0) {
        this.sourceIdIndex = -1;
        this.cacheKeys = list0;
        this.helper = decodeHelper0;
        this.cb = dataFetcherGenerator$FetcherReadyCallback0;
    }

    @Override  // com.bumptech.glide.load.engine.DataFetcherGenerator
    public void cancel() {
        LoadData modelLoader$LoadData0 = this.loadData;
        if(modelLoader$LoadData0 != null) {
            modelLoader$LoadData0.fetcher.cancel();
        }
    }

    private boolean hasNextModelLoader() {
        return this.modelLoaderIndex < this.modelLoaders.size();
    }

    @Override  // com.bumptech.glide.load.data.DataFetcher$DataCallback
    public void onDataReady(Object object0) {
        this.cb.onDataFetcherReady(this.sourceKey, object0, this.loadData.fetcher, DataSource.DATA_DISK_CACHE, this.sourceKey);
    }

    @Override  // com.bumptech.glide.load.data.DataFetcher$DataCallback
    public void onLoadFailed(Exception exception0) {
        this.cb.onDataFetcherFailed(this.sourceKey, exception0, this.loadData.fetcher, DataSource.DATA_DISK_CACHE);
    }

    @Override  // com.bumptech.glide.load.engine.DataFetcherGenerator
    public boolean startNext() {
        while(true) {
            boolean z = false;
            if(this.modelLoaders != null && this.hasNextModelLoader()) {
                this.loadData = null;
                while(!z && this.hasNextModelLoader()) {
                    int v = this.modelLoaderIndex;
                    this.modelLoaderIndex = v + 1;
                    this.loadData = ((ModelLoader)this.modelLoaders.get(v)).buildLoadData(this.cacheFile, this.helper.getWidth(), this.helper.getHeight(), this.helper.getOptions());
                    if(this.loadData != null) {
                        Class class0 = this.loadData.fetcher.getDataClass();
                        if(this.helper.hasLoadPath(class0)) {
                            this.loadData.fetcher.loadData(this.helper.getPriority(), this);
                            z = true;
                        }
                    }
                }
                return z;
            }
            int v1 = this.sourceIdIndex + 1;
            this.sourceIdIndex = v1;
            if(v1 >= this.cacheKeys.size()) {
                return false;
            }
            Key key0 = (Key)this.cacheKeys.get(this.sourceIdIndex);
            DataCacheKey dataCacheKey0 = new DataCacheKey(key0, this.helper.getSignature());
            File file0 = this.helper.getDiskCache().get(dataCacheKey0);
            this.cacheFile = file0;
            if(file0 != null) {
                this.sourceKey = key0;
                this.modelLoaders = this.helper.getModelLoaders(file0);
                this.modelLoaderIndex = 0;
            }
        }
    }
}

