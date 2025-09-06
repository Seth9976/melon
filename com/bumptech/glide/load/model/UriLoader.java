package com.bumptech.glide.load.model;

import android.content.ContentResolver;
import android.net.Uri;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.AssetFileDescriptorLocalUriFetcher;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.FileDescriptorLocalUriFetcher;
import com.bumptech.glide.load.data.StreamLocalUriFetcher;
import com.bumptech.glide.signature.ObjectKey;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class UriLoader implements ModelLoader {
    public static final class AssetFileDescriptorFactory implements ModelLoaderFactory, LocalUriFetcherFactory {
        private final ContentResolver contentResolver;

        public AssetFileDescriptorFactory(ContentResolver contentResolver0) {
            this.contentResolver = contentResolver0;
        }

        @Override  // com.bumptech.glide.load.model.UriLoader$LocalUriFetcherFactory
        public DataFetcher build(Uri uri0) {
            return new AssetFileDescriptorLocalUriFetcher(this.contentResolver, uri0);
        }

        @Override  // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader build(MultiModelLoaderFactory multiModelLoaderFactory0) {
            return new UriLoader(this);
        }

        @Override  // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    public static class FileDescriptorFactory implements ModelLoaderFactory, LocalUriFetcherFactory {
        private final ContentResolver contentResolver;

        public FileDescriptorFactory(ContentResolver contentResolver0) {
            this.contentResolver = contentResolver0;
        }

        @Override  // com.bumptech.glide.load.model.UriLoader$LocalUriFetcherFactory
        public DataFetcher build(Uri uri0) {
            return new FileDescriptorLocalUriFetcher(this.contentResolver, uri0);
        }

        @Override  // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader build(MultiModelLoaderFactory multiModelLoaderFactory0) {
            return new UriLoader(this);
        }

        @Override  // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    public interface LocalUriFetcherFactory {
        DataFetcher build(Uri arg1);
    }

    public static class StreamFactory implements ModelLoaderFactory, LocalUriFetcherFactory {
        private final ContentResolver contentResolver;

        public StreamFactory(ContentResolver contentResolver0) {
            this.contentResolver = contentResolver0;
        }

        @Override  // com.bumptech.glide.load.model.UriLoader$LocalUriFetcherFactory
        public DataFetcher build(Uri uri0) {
            return new StreamLocalUriFetcher(this.contentResolver, uri0);
        }

        @Override  // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader build(MultiModelLoaderFactory multiModelLoaderFactory0) {
            return new UriLoader(this);
        }

        @Override  // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    private static final Set SCHEMES;
    private final LocalUriFetcherFactory factory;

    static {
        UriLoader.SCHEMES = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"file", "content", "android.resource"})));
    }

    public UriLoader(LocalUriFetcherFactory uriLoader$LocalUriFetcherFactory0) {
        this.factory = uriLoader$LocalUriFetcherFactory0;
    }

    public LoadData buildLoadData(Uri uri0, int v, int v1, Options options0) {
        return new LoadData(new ObjectKey(uri0), this.factory.build(uri0));
    }

    @Override  // com.bumptech.glide.load.model.ModelLoader
    public LoadData buildLoadData(Object object0, int v, int v1, Options options0) {
        return this.buildLoadData(((Uri)object0), v, v1, options0);
    }

    public boolean handles(Uri uri0) {
        String s = uri0.getScheme();
        return UriLoader.SCHEMES.contains(s);
    }

    @Override  // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(Object object0) {
        return this.handles(((Uri)object0));
    }
}

