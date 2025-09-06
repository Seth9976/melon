package com.bumptech.glide.load.resource.bitmap;

import android.graphics.ImageDecoder.Source;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.iloen.melon.utils.system.a;
import java.nio.ByteBuffer;

public final class ByteBufferBitmapImageDecoderResourceDecoder implements ResourceDecoder {
    private final BitmapImageDecoderResourceDecoder wrapped;

    public ByteBufferBitmapImageDecoderResourceDecoder() {
        this.wrapped = new BitmapImageDecoderResourceDecoder();
    }

    @Override  // com.bumptech.glide.load.ResourceDecoder
    public Resource decode(Object object0, int v, int v1, Options options0) {
        return this.decode(((ByteBuffer)object0), v, v1, options0);
    }

    public Resource decode(ByteBuffer byteBuffer0, int v, int v1, Options options0) {
        ImageDecoder.Source imageDecoder$Source0 = a.f(byteBuffer0);
        return this.wrapped.decode(imageDecoder$Source0, v, v1, options0);
    }

    @Override  // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(Object object0, Options options0) {
        return this.handles(((ByteBuffer)object0), options0);
    }

    public boolean handles(ByteBuffer byteBuffer0, Options options0) {
        return true;
    }
}

