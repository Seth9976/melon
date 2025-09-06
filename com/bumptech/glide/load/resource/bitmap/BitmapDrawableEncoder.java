package com.bumptech.glide.load.resource.bitmap;

import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.io.File;

public class BitmapDrawableEncoder implements ResourceEncoder {
    private final BitmapPool bitmapPool;
    private final ResourceEncoder encoder;

    public BitmapDrawableEncoder(BitmapPool bitmapPool0, ResourceEncoder resourceEncoder0) {
        this.bitmapPool = bitmapPool0;
        this.encoder = resourceEncoder0;
    }

    public boolean encode(Resource resource0, File file0, Options options0) {
        BitmapResource bitmapResource0 = new BitmapResource(((BitmapDrawable)resource0.get()).getBitmap(), this.bitmapPool);
        return this.encoder.encode(bitmapResource0, file0, options0);
    }

    @Override  // com.bumptech.glide.load.Encoder
    public boolean encode(Object object0, File file0, Options options0) {
        return this.encode(((Resource)object0), file0, options0);
    }

    @Override  // com.bumptech.glide.load.ResourceEncoder
    public EncodeStrategy getEncodeStrategy(Options options0) {
        return this.encoder.getEncodeStrategy(options0);
    }
}

