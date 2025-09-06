package com.bumptech.glide.integration.webp.decoder;

import com.bumptech.glide.integration.webp.WebpHeaderParser;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class StreamWebpDecoder implements ResourceDecoder {
    public static final Option DISABLE_ANIMATION;
    private final ArrayPool byteArrayPool;
    private final ResourceDecoder byteBufferDecoder;

    static {
        StreamWebpDecoder.DISABLE_ANIMATION = Option.memory("com.bumptech.glide.integration.webp.decoder.StreamWebpDecoder.DisableAnimation", Boolean.FALSE);
    }

    public StreamWebpDecoder(ResourceDecoder resourceDecoder0, ArrayPool arrayPool0) {
        this.byteBufferDecoder = resourceDecoder0;
        this.byteArrayPool = arrayPool0;
    }

    public Resource decode(InputStream inputStream0, int v, int v1, Options options0) {
        byte[] arr_b = Utils.inputStreamToBytes(inputStream0);
        if(arr_b == null) {
            return null;
        }
        ByteBuffer byteBuffer0 = ByteBuffer.wrap(arr_b);
        return this.byteBufferDecoder.decode(byteBuffer0, v, v1, options0);
    }

    @Override  // com.bumptech.glide.load.ResourceDecoder
    public Resource decode(Object object0, int v, int v1, Options options0) {
        return this.decode(((InputStream)object0), v, v1, options0);
    }

    // 去混淆评级： 低(20)
    public boolean handles(InputStream inputStream0, Options options0) {
        return ((Boolean)options0.get(StreamWebpDecoder.DISABLE_ANIMATION)).booleanValue() ? false : WebpHeaderParser.isAnimatedWebpType(WebpHeaderParser.getType(inputStream0, this.byteArrayPool));
    }

    @Override  // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(Object object0, Options options0) {
        return this.handles(((InputStream)object0), options0);
    }
}

