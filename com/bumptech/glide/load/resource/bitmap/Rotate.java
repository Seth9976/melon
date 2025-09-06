package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

public class Rotate extends BitmapTransformation {
    private static final String ID = "com.bumptech.glide.load.resource.bitmap.Rotate";
    private static final byte[] ID_BYTES;
    private final int degreesToRotate;

    static {
        Rotate.ID_BYTES = new byte[]{99, 0x6F, 109, 46, 98, 0x75, 109, 0x70, 0x74, 101, 99, 104, 46, 103, 108, 105, 100, 101, 46, 108, 0x6F, 97, 100, 46, 0x72, 101, 0x73, 0x6F, 0x75, 0x72, 99, 101, 46, 98, 105, 0x74, 109, 97, 0x70, 46, 82, 0x6F, 0x74, 97, 0x74, 101};
    }

    public Rotate(int v) {
        this.degreesToRotate = v;
    }

    @Override  // com.bumptech.glide.load.Key
    public boolean equals(Object object0) {
        return object0 instanceof Rotate && this.degreesToRotate == ((Rotate)object0).degreesToRotate;
    }

    @Override  // com.bumptech.glide.load.Key
    public int hashCode() {
        return Util.hashCode(this.degreesToRotate) * 0x1F - 950519196;
    }

    @Override  // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    public Bitmap transform(BitmapPool bitmapPool0, Bitmap bitmap0, int v, int v1) {
        return TransformationUtils.rotateImage(bitmap0, this.degreesToRotate);
    }

    @Override  // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest0) {
        messageDigest0.update(Rotate.ID_BYTES);
        messageDigest0.update(ByteBuffer.allocate(4).putInt(this.degreesToRotate).array());
    }
}

