package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

public final class GranularRoundedCorners extends BitmapTransformation {
    private static final String ID = "com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners";
    private static final byte[] ID_BYTES;
    private final float bottomLeft;
    private final float bottomRight;
    private final float topLeft;
    private final float topRight;

    static {
        GranularRoundedCorners.ID_BYTES = new byte[]{99, 0x6F, 109, 46, 98, 0x75, 109, 0x70, 0x74, 101, 99, 104, 46, 103, 108, 105, 100, 101, 46, 108, 0x6F, 97, 100, 46, 0x72, 101, 0x73, 0x6F, 0x75, 0x72, 99, 101, 46, 98, 105, 0x74, 109, 97, 0x70, 46, 71, 0x72, 97, 110, 0x75, 108, 97, 0x72, 82, 0x6F, 0x75, 110, 100, 101, 100, 67, 0x6F, 0x72, 110, 101, 0x72, 0x73};
    }

    public GranularRoundedCorners(float f, float f1, float f2, float f3) {
        this.topLeft = f;
        this.topRight = f1;
        this.bottomRight = f2;
        this.bottomLeft = f3;
    }

    @Override  // com.bumptech.glide.load.Key
    public boolean equals(Object object0) {
        return object0 instanceof GranularRoundedCorners && this.topLeft == ((GranularRoundedCorners)object0).topLeft && this.topRight == ((GranularRoundedCorners)object0).topRight && this.bottomRight == ((GranularRoundedCorners)object0).bottomRight && this.bottomLeft == ((GranularRoundedCorners)object0).bottomLeft;
    }

    @Override  // com.bumptech.glide.load.Key
    public int hashCode() {
        return Util.hashCode(this.bottomLeft, Util.hashCode(this.bottomRight, Util.hashCode(this.topRight, Util.hashCode(this.topLeft) * 0x1F - 0x78051026)));
    }

    @Override  // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    public Bitmap transform(BitmapPool bitmapPool0, Bitmap bitmap0, int v, int v1) {
        return TransformationUtils.roundedCorners(bitmapPool0, bitmap0, this.topLeft, this.topRight, this.bottomRight, this.bottomLeft);
    }

    @Override  // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest0) {
        messageDigest0.update(GranularRoundedCorners.ID_BYTES);
        messageDigest0.update(ByteBuffer.allocate(16).putFloat(this.topLeft).putFloat(this.topRight).putFloat(this.bottomRight).putFloat(this.bottomLeft).array());
    }
}

