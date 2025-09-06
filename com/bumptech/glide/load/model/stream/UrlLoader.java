package com.bumptech.glide.load.model.stream;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelLoader.LoadData;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import java.io.InputStream;
import java.net.URL;

public class UrlLoader implements ModelLoader {
    public static class StreamFactory implements ModelLoaderFactory {
        @Override  // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader build(MultiModelLoaderFactory multiModelLoaderFactory0) {
            return new UrlLoader(multiModelLoaderFactory0.build(GlideUrl.class, InputStream.class));
        }

        @Override  // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    private final ModelLoader glideUrlLoader;

    public UrlLoader(ModelLoader modelLoader0) {
        this.glideUrlLoader = modelLoader0;
    }

    @Override  // com.bumptech.glide.load.model.ModelLoader
    public LoadData buildLoadData(Object object0, int v, int v1, Options options0) {
        return this.buildLoadData(((URL)object0), v, v1, options0);
    }

    public LoadData buildLoadData(URL uRL0, int v, int v1, Options options0) {
        GlideUrl glideUrl0 = new GlideUrl(uRL0);
        return this.glideUrlLoader.buildLoadData(glideUrl0, v, v1, options0);
    }

    @Override  // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(Object object0) {
        return this.handles(((URL)object0));
    }

    public boolean handles(URL uRL0) {
        return true;
    }
}

