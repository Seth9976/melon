package com.bumptech.glide.load.resource.transcode;

import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.bytes.BytesResource;
import java.io.ByteArrayOutputStream;

public class BitmapBytesTranscoder implements ResourceTranscoder {
    private final Bitmap.CompressFormat compressFormat;
    private final int quality;

    public BitmapBytesTranscoder() {
        this(Bitmap.CompressFormat.JPEG, 100);
    }

    public BitmapBytesTranscoder(Bitmap.CompressFormat bitmap$CompressFormat0, int v) {
        this.compressFormat = bitmap$CompressFormat0;
        this.quality = v;
    }

    @Override  // com.bumptech.glide.load.resource.transcode.ResourceTranscoder
    public Resource transcode(Resource resource0, Options options0) {
        ByteArrayOutputStream byteArrayOutputStream0 = new ByteArrayOutputStream();
        ((Bitmap)resource0.get()).compress(this.compressFormat, this.quality, byteArrayOutputStream0);
        resource0.recycle();
        return new BytesResource(byteArrayOutputStream0.toByteArray());
    }
}

