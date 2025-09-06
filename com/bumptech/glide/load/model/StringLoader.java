package com.bumptech.glide.load.model;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import com.bumptech.glide.load.Options;
import java.io.File;
import java.io.InputStream;

public class StringLoader implements ModelLoader {
    public static final class AssetFileDescriptorFactory implements ModelLoaderFactory {
        @Override  // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader build(MultiModelLoaderFactory multiModelLoaderFactory0) {
            return new StringLoader(multiModelLoaderFactory0.build(Uri.class, AssetFileDescriptor.class));
        }

        @Override  // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    public static class FileDescriptorFactory implements ModelLoaderFactory {
        @Override  // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader build(MultiModelLoaderFactory multiModelLoaderFactory0) {
            return new StringLoader(multiModelLoaderFactory0.build(Uri.class, ParcelFileDescriptor.class));
        }

        @Override  // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    public static class StreamFactory implements ModelLoaderFactory {
        @Override  // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader build(MultiModelLoaderFactory multiModelLoaderFactory0) {
            return new StringLoader(multiModelLoaderFactory0.build(Uri.class, InputStream.class));
        }

        @Override  // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    private final ModelLoader uriLoader;

    public StringLoader(ModelLoader modelLoader0) {
        this.uriLoader = modelLoader0;
    }

    @Override  // com.bumptech.glide.load.model.ModelLoader
    public LoadData buildLoadData(Object object0, int v, int v1, Options options0) {
        return this.buildLoadData(((String)object0), v, v1, options0);
    }

    public LoadData buildLoadData(String s, int v, int v1, Options options0) {
        Uri uri0 = StringLoader.parseUri(s);
        return uri0 == null || !this.uriLoader.handles(uri0) ? null : this.uriLoader.buildLoadData(uri0, v, v1, options0);
    }

    @Override  // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(Object object0) {
        return this.handles(((String)object0));
    }

    public boolean handles(String s) {
        return true;
    }

    private static Uri parseUri(String s) {
        if(TextUtils.isEmpty(s)) {
            return null;
        }
        if(s.charAt(0) == 0x2F) {
            return StringLoader.toFileUri(s);
        }
        Uri uri0 = Uri.parse(s);
        return uri0.getScheme() == null ? StringLoader.toFileUri(s) : uri0;
    }

    private static Uri toFileUri(String s) {
        return Uri.fromFile(new File(s));
    }
}

