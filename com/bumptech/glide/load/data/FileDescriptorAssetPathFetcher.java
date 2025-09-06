package com.bumptech.glide.load.data;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;

public class FileDescriptorAssetPathFetcher extends AssetPathFetcher {
    public FileDescriptorAssetPathFetcher(AssetManager assetManager0, String s) {
        super(assetManager0, s);
    }

    public void close(AssetFileDescriptor assetFileDescriptor0) {
        assetFileDescriptor0.close();
    }

    @Override  // com.bumptech.glide.load.data.AssetPathFetcher
    public void close(Object object0) {
        this.close(((AssetFileDescriptor)object0));
    }

    @Override  // com.bumptech.glide.load.data.DataFetcher
    public Class getDataClass() {
        return AssetFileDescriptor.class;
    }

    public AssetFileDescriptor loadResource(AssetManager assetManager0, String s) {
        return assetManager0.openFd(s);
    }

    @Override  // com.bumptech.glide.load.data.AssetPathFetcher
    public Object loadResource(AssetManager assetManager0, String s) {
        return this.loadResource(assetManager0, s);
    }
}

