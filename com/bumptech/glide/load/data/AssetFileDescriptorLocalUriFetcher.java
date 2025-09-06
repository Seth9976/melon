package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import java.io.FileNotFoundException;

public final class AssetFileDescriptorLocalUriFetcher extends LocalUriFetcher {
    public AssetFileDescriptorLocalUriFetcher(ContentResolver contentResolver0, Uri uri0) {
        super(contentResolver0, uri0);
    }

    public void close(AssetFileDescriptor assetFileDescriptor0) {
        assetFileDescriptor0.close();
    }

    @Override  // com.bumptech.glide.load.data.LocalUriFetcher
    public void close(Object object0) {
        this.close(((AssetFileDescriptor)object0));
    }

    @Override  // com.bumptech.glide.load.data.DataFetcher
    public Class getDataClass() {
        return AssetFileDescriptor.class;
    }

    public AssetFileDescriptor loadResource(Uri uri0, ContentResolver contentResolver0) {
        AssetFileDescriptor assetFileDescriptor0 = contentResolver0.openAssetFileDescriptor(uri0, "r");
        if(assetFileDescriptor0 == null) {
            throw new FileNotFoundException("FileDescriptor is null for: " + uri0);
        }
        return assetFileDescriptor0;
    }

    @Override  // com.bumptech.glide.load.data.LocalUriFetcher
    public Object loadResource(Uri uri0, ContentResolver contentResolver0) {
        return this.loadResource(uri0, contentResolver0);
    }
}

