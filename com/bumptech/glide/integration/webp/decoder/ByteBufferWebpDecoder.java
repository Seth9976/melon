package com.bumptech.glide.integration.webp.decoder;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.Glide;
import com.bumptech.glide.integration.webp.WebpHeaderParser;
import com.bumptech.glide.integration.webp.WebpImage;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.UnitTransformation;
import com.bumptech.glide.load.resource.gif.GifBitmapProvider;
import java.nio.ByteBuffer;

public class ByteBufferWebpDecoder implements ResourceDecoder {
    public static final Option DISABLE_ANIMATION;
    private final BitmapPool mBitmapPool;
    private final Context mContext;
    private final GifBitmapProvider mProvider;

    static {
        ByteBufferWebpDecoder.DISABLE_ANIMATION = Option.memory("com.bumptech.glide.integration.webp.decoder.ByteBufferWebpDecoder.DisableAnimation", Boolean.FALSE);
    }

    public ByteBufferWebpDecoder(Context context0) {
        this(context0, Glide.get(context0).getArrayPool(), Glide.get(context0).getBitmapPool());
    }

    public ByteBufferWebpDecoder(Context context0, ArrayPool arrayPool0, BitmapPool bitmapPool0) {
        this.mContext = context0.getApplicationContext();
        this.mBitmapPool = bitmapPool0;
        this.mProvider = new GifBitmapProvider(bitmapPool0, arrayPool0);
    }

    @Override  // com.bumptech.glide.load.ResourceDecoder
    public Resource decode(Object object0, int v, int v1, Options options0) {
        return this.decode(((ByteBuffer)object0), v, v1, options0);
    }

    public Resource decode(ByteBuffer byteBuffer0, int v, int v1, Options options0) {
        int v2 = byteBuffer0.remaining();
        byte[] arr_b = new byte[v2];
        byteBuffer0.get(arr_b, 0, v2);
        WebpImage webpImage0 = WebpImage.create(arr_b);
        int v3 = Utils.getSampleSize(webpImage0.getWidth(), webpImage0.getHeight(), v, v1);
        Object object0 = options0.get(WebpFrameLoader.FRAME_CACHE_STRATEGY);
        WebpDecoder webpDecoder0 = new WebpDecoder(this.mProvider, webpImage0, byteBuffer0, v3, ((WebpFrameCacheStrategy)object0));
        webpDecoder0.advance();
        Bitmap bitmap0 = webpDecoder0.getNextFrame();
        if(bitmap0 == null) {
            return null;
        }
        UnitTransformation unitTransformation0 = UnitTransformation.get();
        return new WebpDrawableResource(new WebpDrawable(this.mContext, webpDecoder0, this.mBitmapPool, unitTransformation0, v, v1, bitmap0));
    }

    @Override  // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(Object object0, Options options0) {
        return this.handles(((ByteBuffer)object0), options0);
    }

    // 去混淆评级： 低(20)
    public boolean handles(ByteBuffer byteBuffer0, Options options0) {
        return ((Boolean)options0.get(ByteBufferWebpDecoder.DISABLE_ANIMATION)).booleanValue() ? false : WebpHeaderParser.isAnimatedWebpType(WebpHeaderParser.getType(byteBuffer0));
    }
}

