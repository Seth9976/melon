package com.bumptech.glide.load.model;

import b2.d;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher.DataCallback;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MultiModelLoader implements ModelLoader {
    static class MultiFetcher implements DataCallback, DataFetcher {
        private DataCallback callback;
        private int currentIndex;
        private List exceptions;
        private final List fetchers;
        private boolean isCancelled;
        private Priority priority;
        private final d throwableListPool;

        public MultiFetcher(List list0, d d0) {
            this.throwableListPool = d0;
            Preconditions.checkNotEmpty(list0);
            this.fetchers = list0;
            this.currentIndex = 0;
        }

        @Override  // com.bumptech.glide.load.data.DataFetcher
        public void cancel() {
            this.isCancelled = true;
            for(Object object0: this.fetchers) {
                ((DataFetcher)object0).cancel();
            }
        }

        @Override  // com.bumptech.glide.load.data.DataFetcher
        public void cleanup() {
            List list0 = this.exceptions;
            if(list0 != null) {
                this.throwableListPool.release(list0);
            }
            this.exceptions = null;
            for(Object object0: this.fetchers) {
                ((DataFetcher)object0).cleanup();
            }
        }

        @Override  // com.bumptech.glide.load.data.DataFetcher
        public Class getDataClass() {
            return ((DataFetcher)this.fetchers.get(0)).getDataClass();
        }

        @Override  // com.bumptech.glide.load.data.DataFetcher
        public DataSource getDataSource() {
            return ((DataFetcher)this.fetchers.get(0)).getDataSource();
        }

        @Override  // com.bumptech.glide.load.data.DataFetcher
        public void loadData(Priority priority0, DataCallback dataFetcher$DataCallback0) {
            this.priority = priority0;
            this.callback = dataFetcher$DataCallback0;
            this.exceptions = (List)this.throwableListPool.acquire();
            ((DataFetcher)this.fetchers.get(this.currentIndex)).loadData(priority0, this);
            if(this.isCancelled) {
                this.cancel();
            }
        }

        @Override  // com.bumptech.glide.load.data.DataFetcher$DataCallback
        public void onDataReady(Object object0) {
            if(object0 != null) {
                this.callback.onDataReady(object0);
                return;
            }
            this.startNextOrFail();
        }

        @Override  // com.bumptech.glide.load.data.DataFetcher$DataCallback
        public void onLoadFailed(Exception exception0) {
            ((List)Preconditions.checkNotNull(this.exceptions)).add(exception0);
            this.startNextOrFail();
        }

        private void startNextOrFail() {
            if(this.isCancelled) {
                return;
            }
            if(this.currentIndex < this.fetchers.size() - 1) {
                ++this.currentIndex;
                this.loadData(this.priority, this.callback);
                return;
            }
            Preconditions.checkNotNull(this.exceptions);
            this.callback.onLoadFailed(new GlideException("Fetch failed", new ArrayList(this.exceptions)));
        }
    }

    private final d exceptionListPool;
    private final List modelLoaders;

    public MultiModelLoader(List list0, d d0) {
        this.modelLoaders = list0;
        this.exceptionListPool = d0;
    }

    @Override  // com.bumptech.glide.load.model.ModelLoader
    public LoadData buildLoadData(Object object0, int v, int v1, Options options0) {
        int v2 = this.modelLoaders.size();
        ArrayList arrayList0 = new ArrayList(v2);
        Key key0 = null;
        for(int v3 = 0; v3 < v2; ++v3) {
            ModelLoader modelLoader0 = (ModelLoader)this.modelLoaders.get(v3);
            if(modelLoader0.handles(object0)) {
                LoadData modelLoader$LoadData0 = modelLoader0.buildLoadData(object0, v, v1, options0);
                if(modelLoader$LoadData0 != null) {
                    key0 = modelLoader$LoadData0.sourceKey;
                    arrayList0.add(modelLoader$LoadData0.fetcher);
                }
            }
        }
        return arrayList0.isEmpty() || key0 == null ? null : new LoadData(key0, new MultiFetcher(arrayList0, this.exceptionListPool));
    }

    @Override  // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(Object object0) {
        for(Object object1: this.modelLoaders) {
            if(((ModelLoader)object1).handles(object0)) {
                return true;
            }
            if(false) {
                break;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "MultiModelLoader{modelLoaders=" + Arrays.toString(this.modelLoaders.toArray()) + '}';
    }
}

