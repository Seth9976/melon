package com.bumptech.glide.load.model.stream;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.mediastore.MediaStoreUtil;
import com.bumptech.glide.load.data.mediastore.ThumbFetcher;
import com.bumptech.glide.load.model.ModelLoader.LoadData;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import com.bumptech.glide.signature.ObjectKey;

public class MediaStoreVideoThumbLoader implements ModelLoader {
    public static class Factory implements ModelLoaderFactory {
        private final Context context;

        public Factory(Context context0) {
            this.context = context0;
        }

        @Override  // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader build(MultiModelLoaderFactory multiModelLoaderFactory0) {
            return new MediaStoreVideoThumbLoader(this.context);
        }

        @Override  // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    private final Context context;

    public MediaStoreVideoThumbLoader(Context context0) {
        this.context = context0.getApplicationContext();
    }

    // 去混淆评级： 低(20)
    public LoadData buildLoadData(Uri uri0, int v, int v1, Options options0) {
        return !MediaStoreUtil.isThumbnailSize(v, v1) || !this.isRequestingDefaultFrame(options0) ? null : new LoadData(new ObjectKey(uri0), ThumbFetcher.buildVideoFetcher(this.context, uri0));
    }

    @Override  // com.bumptech.glide.load.model.ModelLoader
    public LoadData buildLoadData(Object object0, int v, int v1, Options options0) {
        return this.buildLoadData(((Uri)object0), v, v1, options0);
    }

    public boolean handles(Uri uri0) {
        return MediaStoreUtil.isMediaStoreVideoUri(uri0);
    }

    @Override  // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(Object object0) {
        return this.handles(((Uri)object0));
    }

    private boolean isRequestingDefaultFrame(Options options0) {
        Long long0 = (Long)options0.get(VideoDecoder.TARGET_FRAME);
        return long0 != null && ((long)long0) == -1L;
    }
}

