package com.bumptech.glide.integration.webp.decoder;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.ByteBufferUtil;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class ByteBufferBitmapWebpDecoder implements ResourceDecoder {
    private final WebpDownsampler downsampler;

    public ByteBufferBitmapWebpDecoder(WebpDownsampler webpDownsampler0) {
        this.downsampler = webpDownsampler0;
    }

    @Override  // com.bumptech.glide.load.ResourceDecoder
    public Resource decode(Object object0, int v, int v1, Options options0) {
        return this.decode(((ByteBuffer)object0), v, v1, options0);
    }

    public Resource decode(ByteBuffer byteBuffer0, int v, int v1, Options options0) {
        InputStream inputStream0 = ByteBufferUtil.toStream(byteBuffer0);
        return this.downsampler.decode(inputStream0, v, v1, options0);
    }

    @Override  // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(Object object0, Options options0) {
        return this.handles(((ByteBuffer)object0), options0);
    }

    public boolean handles(ByteBuffer byteBuffer0, Options options0) {
        return this.downsampler.handles(byteBuffer0, options0);
    }
}

