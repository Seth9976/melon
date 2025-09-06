package com.bumptech.glide.load.model;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher.DataCallback;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.resource.drawable.DrawableDecoderCompat;
import com.bumptech.glide.load.resource.drawable.ResourceDrawableDecoder;
import com.bumptech.glide.signature.ObjectKey;
import java.io.IOException;
import java.io.InputStream;

public final class DirectResourceLoader implements ModelLoader {
    static final class AssetFileDescriptorFactory implements ResourceOpener, ModelLoaderFactory {
        private final Context context;

        public AssetFileDescriptorFactory(Context context0) {
            this.context = context0;
        }

        @Override  // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader build(MultiModelLoaderFactory multiModelLoaderFactory0) {
            return new DirectResourceLoader(this.context, this);
        }

        public void close(AssetFileDescriptor assetFileDescriptor0) {
            assetFileDescriptor0.close();
        }

        @Override  // com.bumptech.glide.load.model.DirectResourceLoader$ResourceOpener
        public void close(Object object0) {
            this.close(((AssetFileDescriptor)object0));
        }

        @Override  // com.bumptech.glide.load.model.DirectResourceLoader$ResourceOpener
        public Class getDataClass() {
            return AssetFileDescriptor.class;
        }

        public AssetFileDescriptor open(Resources.Theme resources$Theme0, Resources resources0, int v) {
            return resources0.openRawResourceFd(v);
        }

        @Override  // com.bumptech.glide.load.model.DirectResourceLoader$ResourceOpener
        public Object open(Resources.Theme resources$Theme0, Resources resources0, int v) {
            return this.open(resources$Theme0, resources0, v);
        }

        @Override  // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    static final class DrawableFactory implements ResourceOpener, ModelLoaderFactory {
        private final Context context;

        public DrawableFactory(Context context0) {
            this.context = context0;
        }

        @Override  // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader build(MultiModelLoaderFactory multiModelLoaderFactory0) {
            return new DirectResourceLoader(this.context, this);
        }

        public void close(Drawable drawable0) {
        }

        @Override  // com.bumptech.glide.load.model.DirectResourceLoader$ResourceOpener
        public void close(Object object0) {
        }

        @Override  // com.bumptech.glide.load.model.DirectResourceLoader$ResourceOpener
        public Class getDataClass() {
            return Drawable.class;
        }

        public Drawable open(Resources.Theme resources$Theme0, Resources resources0, int v) {
            return DrawableDecoderCompat.getDrawable(this.context, v, resources$Theme0);
        }

        @Override  // com.bumptech.glide.load.model.DirectResourceLoader$ResourceOpener
        public Object open(Resources.Theme resources$Theme0, Resources resources0, int v) {
            return this.open(resources$Theme0, resources0, v);
        }

        @Override  // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    static final class InputStreamFactory implements ResourceOpener, ModelLoaderFactory {
        private final Context context;

        public InputStreamFactory(Context context0) {
            this.context = context0;
        }

        @Override  // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader build(MultiModelLoaderFactory multiModelLoaderFactory0) {
            return new DirectResourceLoader(this.context, this);
        }

        public void close(InputStream inputStream0) {
            inputStream0.close();
        }

        @Override  // com.bumptech.glide.load.model.DirectResourceLoader$ResourceOpener
        public void close(Object object0) {
            this.close(((InputStream)object0));
        }

        @Override  // com.bumptech.glide.load.model.DirectResourceLoader$ResourceOpener
        public Class getDataClass() {
            return InputStream.class;
        }

        public InputStream open(Resources.Theme resources$Theme0, Resources resources0, int v) {
            return resources0.openRawResource(v);
        }

        @Override  // com.bumptech.glide.load.model.DirectResourceLoader$ResourceOpener
        public Object open(Resources.Theme resources$Theme0, Resources resources0, int v) {
            return this.open(resources$Theme0, resources0, v);
        }

        @Override  // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    static final class ResourceDataFetcher implements DataFetcher {
        private Object data;
        private final int resourceId;
        private final ResourceOpener resourceOpener;
        private final Resources resources;
        private final Resources.Theme theme;

        public ResourceDataFetcher(Resources.Theme resources$Theme0, Resources resources0, ResourceOpener directResourceLoader$ResourceOpener0, int v) {
            this.theme = resources$Theme0;
            this.resources = resources0;
            this.resourceOpener = directResourceLoader$ResourceOpener0;
            this.resourceId = v;
        }

        @Override  // com.bumptech.glide.load.data.DataFetcher
        public void cancel() {
        }

        @Override  // com.bumptech.glide.load.data.DataFetcher
        public void cleanup() {
            Object object0 = this.data;
            if(object0 != null) {
                try {
                    this.resourceOpener.close(object0);
                }
                catch(IOException unused_ex) {
                }
            }
        }

        @Override  // com.bumptech.glide.load.data.DataFetcher
        public Class getDataClass() {
            return this.resourceOpener.getDataClass();
        }

        @Override  // com.bumptech.glide.load.data.DataFetcher
        public DataSource getDataSource() {
            return DataSource.LOCAL;
        }

        @Override  // com.bumptech.glide.load.data.DataFetcher
        public void loadData(Priority priority0, DataCallback dataFetcher$DataCallback0) {
            try {
                Object object0 = this.resourceOpener.open(this.theme, this.resources, this.resourceId);
                this.data = object0;
                dataFetcher$DataCallback0.onDataReady(object0);
            }
            catch(Resources.NotFoundException resources$NotFoundException0) {
                dataFetcher$DataCallback0.onLoadFailed(resources$NotFoundException0);
            }
        }
    }

    interface ResourceOpener {
        void close(Object arg1);

        Class getDataClass();

        Object open(Resources.Theme arg1, Resources arg2, int arg3);
    }

    private final Context context;
    private final ResourceOpener resourceOpener;

    public DirectResourceLoader(Context context0, ResourceOpener directResourceLoader$ResourceOpener0) {
        this.context = context0.getApplicationContext();
        this.resourceOpener = directResourceLoader$ResourceOpener0;
    }

    public static ModelLoaderFactory assetFileDescriptorFactory(Context context0) {
        return new AssetFileDescriptorFactory(context0);
    }

    public LoadData buildLoadData(Integer integer0, int v, int v1, Options options0) {
        Resources resources0;
        Resources.Theme resources$Theme0 = (Resources.Theme)options0.get(ResourceDrawableDecoder.THEME);
        if(resources$Theme0 != null) {
            resources0 = resources$Theme0.getResources();
            return new LoadData(new ObjectKey(integer0), new ResourceDataFetcher(resources$Theme0, resources0, this.resourceOpener, ((int)integer0)));
        }
        resources0 = this.context.getResources();
        return new LoadData(new ObjectKey(integer0), new ResourceDataFetcher(null, resources0, this.resourceOpener, ((int)integer0)));
    }

    @Override  // com.bumptech.glide.load.model.ModelLoader
    public LoadData buildLoadData(Object object0, int v, int v1, Options options0) {
        return this.buildLoadData(((Integer)object0), v, v1, options0);
    }

    public static ModelLoaderFactory drawableFactory(Context context0) {
        return new DrawableFactory(context0);
    }

    public boolean handles(Integer integer0) {
        return true;
    }

    @Override  // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(Object object0) {
        return this.handles(((Integer)object0));
    }

    public static ModelLoaderFactory inputStreamFactory(Context context0) {
        return new InputStreamFactory(context0);
    }
}

