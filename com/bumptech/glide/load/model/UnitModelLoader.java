package com.bumptech.glide.load.model;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher.DataCallback;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.signature.ObjectKey;

public class UnitModelLoader implements ModelLoader {
    public static class Factory implements ModelLoaderFactory {
        private static final Factory FACTORY;

        static {
            Factory.FACTORY = new Factory();
        }

        @Override  // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader build(MultiModelLoaderFactory multiModelLoaderFactory0) {
            return UnitModelLoader.getInstance();
        }

        public static Factory getInstance() {
            return Factory.FACTORY;
        }

        @Override  // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    static class UnitFetcher implements DataFetcher {
        private final Object resource;

        public UnitFetcher(Object object0) {
            this.resource = object0;
        }

        @Override  // com.bumptech.glide.load.data.DataFetcher
        public void cancel() {
        }

        @Override  // com.bumptech.glide.load.data.DataFetcher
        public void cleanup() {
        }

        @Override  // com.bumptech.glide.load.data.DataFetcher
        public Class getDataClass() {
            return this.resource.getClass();
        }

        @Override  // com.bumptech.glide.load.data.DataFetcher
        public DataSource getDataSource() {
            return DataSource.LOCAL;
        }

        @Override  // com.bumptech.glide.load.data.DataFetcher
        public void loadData(Priority priority0, DataCallback dataFetcher$DataCallback0) {
            dataFetcher$DataCallback0.onDataReady(this.resource);
        }
    }

    private static final UnitModelLoader INSTANCE;

    static {
        UnitModelLoader.INSTANCE = new UnitModelLoader();
    }

    @Override  // com.bumptech.glide.load.model.ModelLoader
    public LoadData buildLoadData(Object object0, int v, int v1, Options options0) {
        return new LoadData(new ObjectKey(object0), new UnitFetcher(object0));
    }

    public static UnitModelLoader getInstance() {
        return UnitModelLoader.INSTANCE;
    }

    @Override  // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(Object object0) {
        return true;
    }
}

