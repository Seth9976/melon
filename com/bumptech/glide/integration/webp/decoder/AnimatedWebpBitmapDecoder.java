package com.bumptech.glide.integration.webp.decoder;

import com.bumptech.glide.integration.webp.WebpHeaderParser;
import com.bumptech.glide.integration.webp.WebpImage;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.load.resource.gif.GifBitmapProvider;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class AnimatedWebpBitmapDecoder {
    public static final Option DISABLE_BITMAP;
    private final ArrayPool mArrayPool;
    private final BitmapPool mBitmapPool;
    private final GifBitmapProvider mProvider;

    static {
        AnimatedWebpBitmapDecoder.DISABLE_BITMAP = Option.memory("com.bumptech.glide.integration.webp.decoder.AnimatedWebpBitmapDecoder.DisableBitmap", Boolean.FALSE);
    }

    public AnimatedWebpBitmapDecoder(ArrayPool arrayPool0, BitmapPool bitmapPool0) {
        this.mArrayPool = arrayPool0;
        this.mBitmapPool = bitmapPool0;
        this.mProvider = new GifBitmapProvider(bitmapPool0, arrayPool0);
    }

    public Resource decode(InputStream inputStream0, int v, int v1, Options options0) {
        byte[] arr_b = Utils.inputStreamToBytes(inputStream0);
        return arr_b == null ? null : this.decode(ByteBuffer.wrap(arr_b), v, v1, options0);
    }

    public Resource decode(ByteBuffer byteBuffer0, int v, int v1, Options options0) {
        int v2 = byteBuffer0.remaining();
        byte[] arr_b = new byte[v2];
        byteBuffer0.get(arr_b, 0, v2);
        WebpImage webpImage0 = WebpImage.create(arr_b);
        int v3 = Utils.getSampleSize(webpImage0.getWidth(), webpImage0.getHeight(), v, v1);
        WebpDecoder webpDecoder0 = new WebpDecoder(this.mProvider, webpImage0, byteBuffer0, v3);
        try {
            webpDecoder0.advance();
            return BitmapResource.obtain(webpDecoder0.getNextFrame(), this.mBitmapPool);
        }
        finally {
            webpDecoder0.clear();
        }
    }

    // 去混淆评级： 低(20)
    public boolean handles(InputStream inputStream0, Options options0) {
        return ((Boolean)options0.get(AnimatedWebpBitmapDecoder.DISABLE_BITMAP)).booleanValue() ? false : WebpHeaderParser.isAnimatedWebpType(WebpHeaderParser.getType(inputStream0, this.mArrayPool));
    }

    // 去混淆评级： 低(20)
    public boolean handles(ByteBuffer byteBuffer0, Options options0) {
        return ((Boolean)options0.get(AnimatedWebpBitmapDecoder.DISABLE_BITMAP)).booleanValue() ? false : WebpHeaderParser.isAnimatedWebpType(WebpHeaderParser.getType(byteBuffer0));
    }
}

