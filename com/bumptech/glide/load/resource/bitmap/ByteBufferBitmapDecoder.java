package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import java.nio.ByteBuffer;

public class ByteBufferBitmapDecoder implements ResourceDecoder {
    private final Downsampler downsampler;

    public ByteBufferBitmapDecoder(Downsampler downsampler0) {
        this.downsampler = downsampler0;
    }

    @Override  // com.bumptech.glide.load.ResourceDecoder
    public Resource decode(Object object0, int v, int v1, Options options0) {
        return this.decode(((ByteBuffer)object0), v, v1, options0);
    }

    public Resource decode(ByteBuffer byteBuffer0, int v, int v1, Options options0) {
        return this.downsampler.decode(byteBuffer0, v, v1, options0);
    }

    @Override  // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(Object object0, Options options0) {
        return this.handles(((ByteBuffer)object0), options0);
    }

    public boolean handles(ByteBuffer byteBuffer0, Options options0) {
        return true;
    }
}

