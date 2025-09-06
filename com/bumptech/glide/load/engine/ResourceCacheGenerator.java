package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.data.DataFetcher.DataCallback;
import com.bumptech.glide.load.model.ModelLoader.LoadData;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.File;
import java.util.List;

class ResourceCacheGenerator implements DataCallback, DataFetcherGenerator {
    private File cacheFile;
    private final FetcherReadyCallback cb;
    private ResourceCacheKey currentKey;
    private final DecodeHelper helper;
    private volatile LoadData loadData;
    private int modelLoaderIndex;
    private List modelLoaders;
    private int resourceClassIndex;
    private int sourceIdIndex;
    private Key sourceKey;

    public ResourceCacheGenerator(DecodeHelper decodeHelper0, FetcherReadyCallback dataFetcherGenerator$FetcherReadyCallback0) {
        this.resourceClassIndex = -1;
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
        this.cb.onDataFetcherReady(this.sourceKey, object0, this.loadData.fetcher, DataSource.RESOURCE_DISK_CACHE, this.currentKey);
    }

    @Override  // com.bumptech.glide.load.data.DataFetcher$DataCallback
    public void onLoadFailed(Exception exception0) {
        this.cb.onDataFetcherFailed(this.currentKey, exception0, this.loadData.fetcher, DataSource.RESOURCE_DISK_CACHE);
    }

    @Override  // com.bumptech.glide.load.engine.DataFetcherGenerator
    public boolean startNext() {
        try {
            boolean z = false;
            List list0 = this.helper.getCacheKeys();
            if(!list0.isEmpty()) {
                List list1 = this.helper.getRegisteredResourceClasses();
                if(!list1.isEmpty()) {
                    while(true) {
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
                        int v1 = this.resourceClassIndex + 1;
                        this.resourceClassIndex = v1;
                        if(v1 >= list1.size()) {
                            int v2 = this.sourceIdIndex + 1;
                            this.sourceIdIndex = v2;
                            if(v2 < list0.size()) {
                                this.resourceClassIndex = 0;
                                goto label_27;
                            }
                            return false;
                        }
                    label_27:
                        Key key0 = (Key)list0.get(this.sourceIdIndex);
                        Object object0 = list1.get(this.resourceClassIndex);
                        Transformation transformation0 = this.helper.getTransformation(((Class)object0));
                        this.currentKey = new ResourceCacheKey(this.helper.getArrayPool(), key0, this.helper.getSignature(), this.helper.getWidth(), this.helper.getHeight(), transformation0, ((Class)object0), this.helper.getOptions());
                        File file0 = this.helper.getDiskCache().get(this.currentKey);
                        this.cacheFile = file0;
                        if(file0 != null) {
                            this.sourceKey = key0;
                            this.modelLoaders = this.helper.getModelLoaders(file0);
                            this.modelLoaderIndex = 0;
                        }
                    }
                }
                if(!File.class.equals(this.helper.getTranscodeClass())) {
                    throw new IllegalStateException("Failed to find any load path from " + this.helper.getModelClass() + " to " + this.helper.getTranscodeClass());
                }
                return false;
            }
            return false;
        }
        catch(Throwable throwable0) {
        }
        throw throwable0;
    }
}

