package com.bumptech.glide.integration.webp.decoder;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import java.io.InputStream;

public class StreamAnimatedBitmapDecoder implements ResourceDecoder {
    private final AnimatedWebpBitmapDecoder bitmapDecoder;

    public StreamAnimatedBitmapDecoder(AnimatedWebpBitmapDecoder animatedWebpBitmapDecoder0) {
        this.bitmapDecoder = animatedWebpBitmapDecoder0;
    }

    public Resource decode(InputStream inputStream0, int v, int v1, Options options0) {
        return this.bitmapDecoder.decode(inputStream0, v, v1, options0);
    }

    @Override  // com.bumptech.glide.load.ResourceDecoder
    public Resource decode(Object object0, int v, int v1, Options options0) {
        return this.decode(((InputStream)object0), v, v1, options0);
    }

    public boolean handles(InputStream inputStream0, Options options0) {
        return this.bitmapDecoder.handles(inputStream0, options0);
    }

    @Override  // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(Object object0, Options options0) {
        return this.handles(((InputStream)object0), options0);
    }
}

