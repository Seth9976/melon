package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

public class CircleCrop extends BitmapTransformation {
    private static final String ID = "com.bumptech.glide.load.resource.bitmap.CircleCrop.1";
    private static final byte[] ID_BYTES = null;
    private static final int VERSION = 1;

    static {
        CircleCrop.ID_BYTES = new byte[]{99, 0x6F, 109, 46, 98, 0x75, 109, 0x70, 0x74, 101, 99, 104, 46, 103, 108, 105, 100, 101, 46, 108, 0x6F, 97, 100, 46, 0x72, 101, 0x73, 0x6F, 0x75, 0x72, 99, 101, 46, 98, 105, 0x74, 109, 97, 0x70, 46, 67, 105, 0x72, 99, 108, 101, 67, 0x72, 0x6F, 0x70, 46, 49};
    }

    @Override  // com.bumptech.glide.load.Key
    public boolean equals(Object object0) {
        return object0 instanceof CircleCrop;
    }

    @Override  // com.bumptech.glide.load.Key
    public int hashCode() {
        return 1101716364;
    }

    @Override  // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    public Bitmap transform(BitmapPool bitmapPool0, Bitmap bitmap0, int v, int v1) {
        return TransformationUtils.circleCrop(bitmapPool0, bitmap0, v, v1);
    }

    @Override  // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest0) {
        messageDigest0.update(CircleCrop.ID_BYTES);
    }
}

