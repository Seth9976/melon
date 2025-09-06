package com.bumptech.glide.integration.webp.decoder;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.InputStream;

public class StreamBitmapWebpDecoder implements ResourceDecoder {
    private final ArrayPool byteArrayPool;
    private final WebpDownsampler downsampler;

    public StreamBitmapWebpDecoder(WebpDownsampler webpDownsampler0, ArrayPool arrayPool0) {
        this.downsampler = webpDownsampler0;
        this.byteArrayPool = arrayPool0;
    }

    public Resource decode(InputStream inputStream0, int v, int v1, Options options0) {
        return this.downsampler.decode(inputStream0, v, v1, options0);
    }

    @Override  // com.bumptech.glide.load.ResourceDecoder
    public Resource decode(Object object0, int v, int v1, Options options0) {
        return this.decode(((InputStream)object0), v, v1, options0);
    }

    public boolean handles(InputStream inputStream0, Options options0) {
        return this.downsampler.handles(inputStream0, options0);
    }

    @Override  // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(Object object0, Options options0) {
        return this.handles(((InputStream)object0), options0);
    }
}

