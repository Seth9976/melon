package com.bumptech.glide.load.model;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.util.Log;
import com.bumptech.glide.load.Options;
import java.io.InputStream;
import java.util.List;

public final class ResourceUriLoader implements ModelLoader {
    static final class AssetFileDescriptorFactory implements ModelLoaderFactory {
        private final Context context;

        public AssetFileDescriptorFactory(Context context0) {
            this.context = context0;
        }

        @Override  // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader build(MultiModelLoaderFactory multiModelLoaderFactory0) {
            ModelLoader modelLoader0 = multiModelLoaderFactory0.build(Integer.class, AssetFileDescriptor.class);
            return new ResourceUriLoader(this.context, modelLoader0);
        }

        @Override  // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    static final class InputStreamFactory implements ModelLoaderFactory {
        private final Context context;

        public InputStreamFactory(Context context0) {
            this.context = context0;
        }

        @Override  // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader build(MultiModelLoaderFactory multiModelLoaderFactory0) {
            ModelLoader modelLoader0 = multiModelLoaderFactory0.build(Integer.class, InputStream.class);
            return new ResourceUriLoader(this.context, modelLoader0);
        }

        @Override  // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    private static final int INVALID_RESOURCE_ID = 0;
    private static final String TAG = "ResourceUriLoader";
    private final Context context;
    private final ModelLoader delegate;

    public ResourceUriLoader(Context context0, ModelLoader modelLoader0) {
        this.context = context0.getApplicationContext();
        this.delegate = modelLoader0;
    }

    public LoadData buildLoadData(Uri uri0, int v, int v1, Options options0) {
        List list0 = uri0.getPathSegments();
        if(list0.size() == 1) {
            return this.parseResourceIdUri(uri0, v, v1, options0);
        }
        if(list0.size() == 2) {
            return this.parseResourceNameUri(uri0, v, v1, options0);
        }
        if(Log.isLoggable("ResourceUriLoader", 5)) {
            Log.w("ResourceUriLoader", "Failed to parse resource uri: " + uri0);
        }
        return null;
    }

    @Override  // com.bumptech.glide.load.model.ModelLoader
    public LoadData buildLoadData(Object object0, int v, int v1, Options options0) {
        return this.buildLoadData(((Uri)object0), v, v1, options0);
    }

    // 去混淆评级： 低(20)
    public boolean handles(Uri uri0) {
        return "android.resource".equals(uri0.getScheme()) && "com.iloen.melon".equals(uri0.getAuthority());
    }

    @Override  // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(Object object0) {
        return this.handles(((Uri)object0));
    }

    public static ModelLoaderFactory newAssetFileDescriptorFactory(Context context0) {
        return new AssetFileDescriptorFactory(context0);
    }

    public static ModelLoaderFactory newStreamFactory(Context context0) {
        return new InputStreamFactory(context0);
    }

    private LoadData parseResourceIdUri(Uri uri0, int v, int v1, Options options0) {
        try {
            int v2 = Integer.parseInt(((String)uri0.getPathSegments().get(0)));
            if(v2 == 0) {
                if(Log.isLoggable("ResourceUriLoader", 5)) {
                    Log.w("ResourceUriLoader", "Failed to parse a valid non-0 resource id from: " + uri0);
                    return null;
                }
                return null;
            }
            return this.delegate.buildLoadData(v2, v, v1, options0);
        }
        catch(NumberFormatException numberFormatException0) {
        }
        if(Log.isLoggable("ResourceUriLoader", 5)) {
            Log.w("ResourceUriLoader", "Failed to parse resource id from: " + uri0, numberFormatException0);
        }
        return null;
    }

    private LoadData parseResourceNameUri(Uri uri0, int v, int v1, Options options0) {
        List list0 = uri0.getPathSegments();
        String s = (String)list0.get(0);
        String s1 = (String)list0.get(1);
        int v2 = this.context.getResources().getIdentifier(s1, s, "com.iloen.melon");
        if(v2 == 0) {
            if(Log.isLoggable("ResourceUriLoader", 5)) {
                Log.w("ResourceUriLoader", "Failed to find resource id for: " + uri0);
            }
            return null;
        }
        return this.delegate.buildLoadData(v2, v, v1, options0);
    }
}

