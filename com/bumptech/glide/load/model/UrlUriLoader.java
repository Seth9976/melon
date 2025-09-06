package com.bumptech.glide.load.model;

import android.net.Uri;
import com.bumptech.glide.load.Options;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class UrlUriLoader implements ModelLoader {
    public static class StreamFactory implements ModelLoaderFactory {
        @Override  // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader build(MultiModelLoaderFactory multiModelLoaderFactory0) {
            return new UrlUriLoader(multiModelLoaderFactory0.build(GlideUrl.class, InputStream.class));
        }

        @Override  // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    private static final Set SCHEMES;
    private final ModelLoader urlLoader;

    static {
        UrlUriLoader.SCHEMES = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"http", "https"})));
    }

    public UrlUriLoader(ModelLoader modelLoader0) {
        this.urlLoader = modelLoader0;
    }

    public LoadData buildLoadData(Uri uri0, int v, int v1, Options options0) {
        GlideUrl glideUrl0 = new GlideUrl(uri0.toString());
        return this.urlLoader.buildLoadData(glideUrl0, v, v1, options0);
    }

    @Override  // com.bumptech.glide.load.model.ModelLoader
    public LoadData buildLoadData(Object object0, int v, int v1, Options options0) {
        return this.buildLoadData(((Uri)object0), v, v1, options0);
    }

    public boolean handles(Uri uri0) {
        String s = uri0.getScheme();
        return UrlUriLoader.SCHEMES.contains(s);
    }

    @Override  // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(Object object0) {
        return this.handles(((Uri)object0));
    }
}

