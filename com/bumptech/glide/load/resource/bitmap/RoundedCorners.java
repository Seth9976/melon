package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

public final class RoundedCorners extends BitmapTransformation {
    private static final String ID = "com.bumptech.glide.load.resource.bitmap.RoundedCorners";
    private static final byte[] ID_BYTES;
    private final int roundingRadius;

    static {
        RoundedCorners.ID_BYTES = new byte[]{99, 0x6F, 109, 46, 98, 0x75, 109, 0x70, 0x74, 101, 99, 104, 46, 103, 108, 105, 100, 101, 46, 108, 0x6F, 97, 100, 46, 0x72, 101, 0x73, 0x6F, 0x75, 0x72, 99, 101, 46, 98, 105, 0x74, 109, 97, 0x70, 46, 82, 0x6F, 0x75, 110, 100, 101, 100, 67, 0x6F, 0x72, 110, 101, 0x72, 0x73};
    }

    public RoundedCorners(int v) {
        Preconditions.checkArgument(v > 0, "roundingRadius must be greater than 0.");
        this.roundingRadius = v;
    }

    @Override  // com.bumptech.glide.load.Key
    public boolean equals(Object object0) {
        return object0 instanceof RoundedCorners && this.roundingRadius == ((RoundedCorners)object0).roundingRadius;
    }

    @Override  // com.bumptech.glide.load.Key
    public int hashCode() {
        return Util.hashCode(this.roundingRadius) * 0x1F - 0x21F3CAA6;
    }

    @Override  // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    public Bitmap transform(BitmapPool bitmapPool0, Bitmap bitmap0, int v, int v1) {
        return TransformationUtils.roundedCorners(bitmapPool0, bitmap0, this.roundingRadius);
    }

    @Override  // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest0) {
        messageDigest0.update(RoundedCorners.ID_BYTES);
        messageDigest0.update(ByteBuffer.allocate(4).putInt(this.roundingRadius).array());
    }
}

