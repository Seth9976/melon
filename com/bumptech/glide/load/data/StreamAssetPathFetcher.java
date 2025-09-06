package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import java.io.InputStream;

public class StreamAssetPathFetcher extends AssetPathFetcher {
    public StreamAssetPathFetcher(AssetManager assetManager0, String s) {
        super(assetManager0, s);
    }

    public void close(InputStream inputStream0) {
        inputStream0.close();
    }

    @Override  // com.bumptech.glide.load.data.AssetPathFetcher
    public void close(Object object0) {
        this.close(((InputStream)object0));
    }

    @Override  // com.bumptech.glide.load.data.DataFetcher
    public Class getDataClass() {
        return InputStream.class;
    }

    public InputStream loadResource(AssetManager assetManager0, String s) {
        return assetManager0.open(s);
    }

    @Override  // com.bumptech.glide.load.data.AssetPathFetcher
    public Object loadResource(AssetManager assetManager0, String s) {
        return this.loadResource(assetManager0, s);
    }
}

