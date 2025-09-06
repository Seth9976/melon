package com.bumptech.glide.load.model;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.load.Options;
import java.io.InputStream;

public class ResourceLoader implements ModelLoader {
    public static final class AssetFileDescriptorFactory implements ModelLoaderFactory {
        private final Resources resources;

        public AssetFileDescriptorFactory(Resources resources0) {
            this.resources = resources0;
        }

        @Override  // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader build(MultiModelLoaderFactory multiModelLoaderFactory0) {
            ModelLoader modelLoader0 = multiModelLoaderFactory0.build(Uri.class, AssetFileDescriptor.class);
            return new ResourceLoader(this.resources, modelLoader0);
        }

        @Override  // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    @Deprecated
    public static class FileDescriptorFactory implements ModelLoaderFactory {
        private final Resources resources;

        public FileDescriptorFactory(Resources resources0) {
            this.resources = resources0;
        }

        @Override  // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader build(MultiModelLoaderFactory multiModelLoaderFactory0) {
            ModelLoader modelLoader0 = multiModelLoaderFactory0.build(Uri.class, ParcelFileDescriptor.class);
            return new ResourceLoader(this.resources, modelLoader0);
        }

        @Override  // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    public static class StreamFactory implements ModelLoaderFactory {
        private final Resources resources;

        public StreamFactory(Resources resources0) {
            this.resources = resources0;
        }

        @Override  // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader build(MultiModelLoaderFactory multiModelLoaderFactory0) {
            ModelLoader modelLoader0 = multiModelLoaderFactory0.build(Uri.class, InputStream.class);
            return new ResourceLoader(this.resources, modelLoader0);
        }

        @Override  // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    public static class UriFactory implements ModelLoaderFactory {
        private final Resources resources;

        public UriFactory(Resources resources0) {
            this.resources = resources0;
        }

        @Override  // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader build(MultiModelLoaderFactory multiModelLoaderFactory0) {
            return new ResourceLoader(this.resources, UnitModelLoader.getInstance());
        }

        @Override  // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    private static final String TAG = "ResourceLoader";
    private final Resources resources;
    private final ModelLoader uriLoader;

    public ResourceLoader(Resources resources0, ModelLoader modelLoader0) {
        this.resources = resources0;
        this.uriLoader = modelLoader0;
    }

    public LoadData buildLoadData(Integer integer0, int v, int v1, Options options0) {
        Uri uri0 = this.getResourceUri(integer0);
        return uri0 == null ? null : this.uriLoader.buildLoadData(uri0, v, v1, options0);
    }

    @Override  // com.bumptech.glide.load.model.ModelLoader
    public LoadData buildLoadData(Object object0, int v, int v1, Options options0) {
        return this.buildLoadData(((Integer)object0), v, v1, options0);
    }

    private Uri getResourceUri(Integer integer0) {
        try {
            return Uri.parse(("android.resource://" + this.resources.getResourcePackageName(((int)integer0)) + '/' + this.resources.getResourceTypeName(((int)integer0)) + '/' + this.resources.getResourceEntryName(((int)integer0))));
        }
        catch(Resources.NotFoundException resources$NotFoundException0) {
            if(Log.isLoggable("ResourceLoader", 5)) {
                Log.w("ResourceLoader", "Received invalid resource id: " + integer0, resources$NotFoundException0);
            }
            return null;
        }
    }

    public boolean handles(Integer integer0) {
        return true;
    }

    @Override  // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(Object object0) {
        return this.handles(((Integer)object0));
    }
}

