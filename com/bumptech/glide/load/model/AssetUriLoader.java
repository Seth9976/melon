package com.bumptech.glide.load.model;

import android.content.res.AssetManager;
import android.net.Uri;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.FileDescriptorAssetPathFetcher;
import com.bumptech.glide.load.data.StreamAssetPathFetcher;
import com.bumptech.glide.signature.ObjectKey;

public class AssetUriLoader implements ModelLoader {
    public interface AssetFetcherFactory {
        DataFetcher buildFetcher(AssetManager arg1, String arg2);
    }

    public static class FileDescriptorFactory implements AssetFetcherFactory, ModelLoaderFactory {
        private final AssetManager assetManager;

        public FileDescriptorFactory(AssetManager assetManager0) {
            this.assetManager = assetManager0;
        }

        @Override  // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader build(MultiModelLoaderFactory multiModelLoaderFactory0) {
            return new AssetUriLoader(this.assetManager, this);
        }

        @Override  // com.bumptech.glide.load.model.AssetUriLoader$AssetFetcherFactory
        public DataFetcher buildFetcher(AssetManager assetManager0, String s) {
            return new FileDescriptorAssetPathFetcher(assetManager0, s);
        }

        @Override  // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    public static class StreamFactory implements AssetFetcherFactory, ModelLoaderFactory {
        private final AssetManager assetManager;

        public StreamFactory(AssetManager assetManager0) {
            this.assetManager = assetManager0;
        }

        @Override  // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader build(MultiModelLoaderFactory multiModelLoaderFactory0) {
            return new AssetUriLoader(this.assetManager, this);
        }

        @Override  // com.bumptech.glide.load.model.AssetUriLoader$AssetFetcherFactory
        public DataFetcher buildFetcher(AssetManager assetManager0, String s) {
            return new StreamAssetPathFetcher(assetManager0, s);
        }

        @Override  // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    private static final String ASSET_PATH_SEGMENT = "android_asset";
    private static final String ASSET_PREFIX = "file:///android_asset/";
    private static final int ASSET_PREFIX_LENGTH = 22;
    private final AssetManager assetManager;
    private final AssetFetcherFactory factory;

    public AssetUriLoader(AssetManager assetManager0, AssetFetcherFactory assetUriLoader$AssetFetcherFactory0) {
        this.assetManager = assetManager0;
        this.factory = assetUriLoader$AssetFetcherFactory0;
    }

    public LoadData buildLoadData(Uri uri0, int v, int v1, Options options0) {
        return new LoadData(new ObjectKey(uri0), this.factory.buildFetcher(this.assetManager, uri0.toString().substring(AssetUriLoader.ASSET_PREFIX_LENGTH)));
    }

    @Override  // com.bumptech.glide.load.model.ModelLoader
    public LoadData buildLoadData(Object object0, int v, int v1, Options options0) {
        return this.buildLoadData(((Uri)object0), v, v1, options0);
    }

    // 去混淆评级： 低(30)
    public boolean handles(Uri uri0) {
        return "file".equals(uri0.getScheme()) && !uri0.getPathSegments().isEmpty() && "android_asset".equals(uri0.getPathSegments().get(0));
    }

    @Override  // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(Object object0) {
        return this.handles(((Uri)object0));
    }
}

