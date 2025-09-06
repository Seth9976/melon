package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.ImageHeaderParser.ImageType;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.util.ByteBufferUtil;
import java.io.InputStream;
import java.nio.ByteBuffer;
import y2.g;

public final class ExifInterfaceImageHeaderParser implements ImageHeaderParser {
    @Override  // com.bumptech.glide.load.ImageHeaderParser
    public int getOrientation(InputStream inputStream0, ArrayPool arrayPool0) {
        int v = new g(inputStream0).c();
        return v == 0 ? -1 : v;
    }

    @Override  // com.bumptech.glide.load.ImageHeaderParser
    public int getOrientation(ByteBuffer byteBuffer0, ArrayPool arrayPool0) {
        return this.getOrientation(ByteBufferUtil.toStream(byteBuffer0), arrayPool0);
    }

    @Override  // com.bumptech.glide.load.ImageHeaderParser
    public ImageType getType(InputStream inputStream0) {
        return ImageType.UNKNOWN;
    }

    @Override  // com.bumptech.glide.load.ImageHeaderParser
    public ImageType getType(ByteBuffer byteBuffer0) {
        return ImageType.UNKNOWN;
    }
}

