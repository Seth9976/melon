package com.bumptech.glide.integration.okhttp3;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.load.model.DataUrlLoader.StreamFactory;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.ResourceUriLoader;
import com.bumptech.glide.load.model.stream.QMediaStoreUriLoader.InputStreamFactory;
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.module.AppGlideModule;
import com.bumptech.glide.request.RequestOptions;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.log.LogU;
import java.io.InputStream;
import okhttp3.OkHttpClient;

@GlideModule
public class MelonOkHttpGlideModule extends AppGlideModule {
    private static final String TAG = "MelonOkHttpGlideModule";

    @Override  // com.bumptech.glide.module.AppGlideModule
    public void applyOptions(Context context0, GlideBuilder glideBuilder0) {
        int v = (int)(((float)Runtime.getRuntime().maxMemory()) * 0.13f);
        LogU.d("MelonOkHttpGlideModule", "applyOptions() cacheSize: " + v + " bytes");
        glideBuilder0.setMemoryCache(new LruResourceCache(((long)v)));
        RequestOptions requestOptions0 = (RequestOptions)new RequestOptions().diskCacheStrategy(DiskCacheStrategy.RESOURCE);
        if(MelonSettingInfo.isLowMemoryMode()) {
            requestOptions0 = (RequestOptions)((RequestOptions)requestOptions0.sizeMultiplier(0.7f)).optionalCenterInside();
        }
        glideBuilder0.setDefaultRequestOptions(requestOptions0);
        BitmapTransitionOptions bitmapTransitionOptions0 = BitmapTransitionOptions.withCrossFade();
        glideBuilder0.setDefaultTransitionOptions(Bitmap.class, bitmapTransitionOptions0);
        DrawableTransitionOptions drawableTransitionOptions0 = DrawableTransitionOptions.withCrossFade();
        glideBuilder0.setDefaultTransitionOptions(Drawable.class, drawableTransitionOptions0);
    }

    @Override  // com.bumptech.glide.module.AppGlideModule
    public boolean isManifestParsingEnabled() [...] // Inlined contents

    @Override  // com.bumptech.glide.module.LibraryGlideModule
    public void registerComponents(Context context0, Glide glide0, Registry registry0) {
        super.registerComponents(context0, glide0, registry0);
        OkHttpClient okHttpClient0 = new MelonImageClient().getClient();
        Class class0 = InputStream.class;
        if(okHttpClient0 != null) {
            Factory melonOkHttpUrlLoader$Factory0 = new Factory(okHttpClient0);
            registry0.replace(GlideUrl.class, class0, melonOkHttpUrlLoader$Factory0);
        }
        ContentResolver contentResolver0 = context0.getContentResolver();
        ModelLoaderFactory modelLoaderFactory0 = ResourceUriLoader.newStreamFactory(context0);
        registry0.replace(Uri.class, class0, modelLoaderFactory0);
        registry0.append(Uri.class, class0, new StreamFactory());
        registry0.append(Uri.class, class0, new com.bumptech.glide.load.model.AssetUriLoader.StreamFactory(context0.getAssets()));
        registry0.append(Uri.class, class0, new InputStreamFactory(context0));
        registry0.append(Uri.class, class0, new com.bumptech.glide.load.model.UriLoader.StreamFactory(contentResolver0));
        registry0.append(Uri.class, class0, new com.bumptech.glide.load.model.UrlUriLoader.StreamFactory());
        registry0.append(Uri.class, class0, new com.bumptech.glide.load.model.stream.MediaStoreImageThumbLoader.Factory(context0));
        registry0.append(Uri.class, class0, new com.bumptech.glide.load.model.stream.MediaStoreVideoThumbLoader.Factory(context0));
    }
}

