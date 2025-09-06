package com.bumptech.glide.integration.okhttp3;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelLoader.LoadData;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.bumptech.glide.signature.ObjectKey;

public class MelonOkHttpUrlLoader implements ModelLoader {
    public static class Factory implements ModelLoaderFactory {
        private okhttp3.Call.Factory client;

        public Factory(okhttp3.Call.Factory call$Factory0) {
            this.client = call$Factory0;
        }

        @Override  // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader build(MultiModelLoaderFactory multiModelLoaderFactory0) {
            return new MelonOkHttpUrlLoader(this.client);
        }

        @Override  // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    private final okhttp3.Call.Factory client;

    public MelonOkHttpUrlLoader(okhttp3.Call.Factory call$Factory0) {
        this.client = call$Factory0;
    }

    public LoadData buildLoadData(GlideUrl glideUrl0, int v, int v1, Options options0) {
        return new LoadData(new ObjectKey(glideUrl0), new MelonOkHttpStreamFetcher(this.client, glideUrl0));
    }

    @Override  // com.bumptech.glide.load.model.ModelLoader
    public LoadData buildLoadData(Object object0, int v, int v1, Options options0) {
        return this.buildLoadData(((GlideUrl)object0), v, v1, options0);
    }

    public boolean handles(GlideUrl glideUrl0) {
        return true;
    }

    @Override  // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(Object object0) {
        return this.handles(((GlideUrl)object0));
    }
}

