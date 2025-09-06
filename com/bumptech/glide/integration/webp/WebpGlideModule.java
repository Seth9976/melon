package com.bumptech.glide.integration.webp;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.Registry;
import com.bumptech.glide.integration.webp.decoder.AnimatedWebpBitmapDecoder;
import com.bumptech.glide.integration.webp.decoder.ByteBufferAnimatedBitmapDecoder;
import com.bumptech.glide.integration.webp.decoder.ByteBufferBitmapWebpDecoder;
import com.bumptech.glide.integration.webp.decoder.ByteBufferWebpDecoder;
import com.bumptech.glide.integration.webp.decoder.StreamAnimatedBitmapDecoder;
import com.bumptech.glide.integration.webp.decoder.StreamBitmapWebpDecoder;
import com.bumptech.glide.integration.webp.decoder.StreamWebpDecoder;
import com.bumptech.glide.integration.webp.decoder.WebpDownsampler;
import com.bumptech.glide.integration.webp.decoder.WebpDrawable;
import com.bumptech.glide.integration.webp.decoder.WebpDrawableEncoder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapDrawableDecoder;
import com.bumptech.glide.module.GlideModule;
import java.io.InputStream;
import java.nio.ByteBuffer;

@Deprecated
public class WebpGlideModule implements GlideModule {
    @Override  // com.bumptech.glide.module.GlideModule
    public void applyOptions(Context context0, GlideBuilder glideBuilder0) {
    }

    @Override  // com.bumptech.glide.module.GlideModule
    public void registerComponents(Context context0, Glide glide0, Registry registry0) {
        Resources resources0 = context0.getResources();
        BitmapPool bitmapPool0 = glide0.getBitmapPool();
        ArrayPool arrayPool0 = glide0.getArrayPool();
        WebpDownsampler webpDownsampler0 = new WebpDownsampler(registry0.getImageHeaderParsers(), resources0.getDisplayMetrics(), bitmapPool0, arrayPool0);
        AnimatedWebpBitmapDecoder animatedWebpBitmapDecoder0 = new AnimatedWebpBitmapDecoder(arrayPool0, bitmapPool0);
        ByteBufferBitmapWebpDecoder byteBufferBitmapWebpDecoder0 = new ByteBufferBitmapWebpDecoder(webpDownsampler0);
        StreamBitmapWebpDecoder streamBitmapWebpDecoder0 = new StreamBitmapWebpDecoder(webpDownsampler0, arrayPool0);
        ByteBufferWebpDecoder byteBufferWebpDecoder0 = new ByteBufferWebpDecoder(context0, arrayPool0, bitmapPool0);
        Registry registry1 = registry0.prepend("Bitmap", ByteBuffer.class, Bitmap.class, byteBufferBitmapWebpDecoder0).prepend("Bitmap", InputStream.class, Bitmap.class, streamBitmapWebpDecoder0);
        BitmapDrawableDecoder bitmapDrawableDecoder0 = new BitmapDrawableDecoder(resources0, byteBufferBitmapWebpDecoder0);
        Registry registry2 = registry1.prepend("BitmapDrawable", ByteBuffer.class, BitmapDrawable.class, bitmapDrawableDecoder0);
        BitmapDrawableDecoder bitmapDrawableDecoder1 = new BitmapDrawableDecoder(resources0, streamBitmapWebpDecoder0);
        Registry registry3 = registry2.prepend("BitmapDrawable", InputStream.class, BitmapDrawable.class, bitmapDrawableDecoder1);
        ByteBufferAnimatedBitmapDecoder byteBufferAnimatedBitmapDecoder0 = new ByteBufferAnimatedBitmapDecoder(animatedWebpBitmapDecoder0);
        Registry registry4 = registry3.prepend("Bitmap", ByteBuffer.class, Bitmap.class, byteBufferAnimatedBitmapDecoder0);
        StreamAnimatedBitmapDecoder streamAnimatedBitmapDecoder0 = new StreamAnimatedBitmapDecoder(animatedWebpBitmapDecoder0);
        Registry registry5 = registry4.prepend("Bitmap", InputStream.class, Bitmap.class, streamAnimatedBitmapDecoder0).prepend(ByteBuffer.class, WebpDrawable.class, byteBufferWebpDecoder0);
        StreamWebpDecoder streamWebpDecoder0 = new StreamWebpDecoder(byteBufferWebpDecoder0, arrayPool0);
        Registry registry6 = registry5.prepend(InputStream.class, WebpDrawable.class, streamWebpDecoder0);
        WebpDrawableEncoder webpDrawableEncoder0 = new WebpDrawableEncoder();
        registry6.prepend(WebpDrawable.class, webpDrawableEncoder0);
    }
}

