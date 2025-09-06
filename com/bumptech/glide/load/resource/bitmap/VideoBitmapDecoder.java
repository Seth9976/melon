package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;

@Deprecated
public class VideoBitmapDecoder extends VideoDecoder {
    public VideoBitmapDecoder(Context context0) {
        this(Glide.get(context0).getBitmapPool());
    }

    public VideoBitmapDecoder(BitmapPool bitmapPool0) {
        super(bitmapPool0, new ParcelFileDescriptorInitializer());
    }
}

