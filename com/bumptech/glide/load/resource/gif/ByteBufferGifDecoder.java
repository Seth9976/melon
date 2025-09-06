package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap.Config;
import android.graphics.Bitmap;
import android.util.Log;
import androidx.appcompat.app.o;
import com.bumptech.glide.Glide;
import com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.gifdecoder.GifHeader;
import com.bumptech.glide.gifdecoder.GifHeaderParser;
import com.bumptech.glide.gifdecoder.StandardGifDecoder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser.ImageType;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.UnitTransformation;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Queue;

public class ByteBufferGifDecoder implements ResourceDecoder {
    static class GifDecoderFactory {
        public GifDecoder build(BitmapProvider gifDecoder$BitmapProvider0, GifHeader gifHeader0, ByteBuffer byteBuffer0, int v) {
            return new StandardGifDecoder(gifDecoder$BitmapProvider0, gifHeader0, byteBuffer0, v);
        }
    }

    static class GifHeaderParserPool {
        private final Queue pool;

        public GifHeaderParserPool() {
            this.pool = Util.createQueue(0);
        }

        public GifHeaderParser obtain(ByteBuffer byteBuffer0) {
            synchronized(this) {
                GifHeaderParser gifHeaderParser0 = (GifHeaderParser)this.pool.poll();
                if(gifHeaderParser0 == null) {
                    gifHeaderParser0 = new GifHeaderParser();
                }
                return gifHeaderParser0.setData(byteBuffer0);
            }
        }

        public void release(GifHeaderParser gifHeaderParser0) {
            synchronized(this) {
                gifHeaderParser0.clear();
                this.pool.offer(gifHeaderParser0);
            }
        }
    }

    private static final GifDecoderFactory GIF_DECODER_FACTORY = null;
    private static final GifHeaderParserPool PARSER_POOL = null;
    private static final String TAG = "BufferGifDecoder";
    private final Context context;
    private final GifDecoderFactory gifDecoderFactory;
    private final GifHeaderParserPool parserPool;
    private final List parsers;
    private final GifBitmapProvider provider;

    static {
        ByteBufferGifDecoder.GIF_DECODER_FACTORY = new GifDecoderFactory();
        ByteBufferGifDecoder.PARSER_POOL = new GifHeaderParserPool();
    }

    public ByteBufferGifDecoder(Context context0) {
        this(context0, Glide.get(context0).getRegistry().getImageHeaderParsers(), Glide.get(context0).getBitmapPool(), Glide.get(context0).getArrayPool());
    }

    public ByteBufferGifDecoder(Context context0, List list0, BitmapPool bitmapPool0, ArrayPool arrayPool0) {
        this(context0, list0, bitmapPool0, arrayPool0, ByteBufferGifDecoder.PARSER_POOL, ByteBufferGifDecoder.GIF_DECODER_FACTORY);
    }

    public ByteBufferGifDecoder(Context context0, List list0, BitmapPool bitmapPool0, ArrayPool arrayPool0, GifHeaderParserPool byteBufferGifDecoder$GifHeaderParserPool0, GifDecoderFactory byteBufferGifDecoder$GifDecoderFactory0) {
        this.context = context0.getApplicationContext();
        this.parsers = list0;
        this.gifDecoderFactory = byteBufferGifDecoder$GifDecoderFactory0;
        this.provider = new GifBitmapProvider(bitmapPool0, arrayPool0);
        this.parserPool = byteBufferGifDecoder$GifHeaderParserPool0;
    }

    private GifDrawableResource decode(ByteBuffer byteBuffer0, int v, int v1, GifHeaderParser gifHeaderParser0, Options options0) {
        GifDrawableResource gifDrawableResource0;
        long v2 = LogTime.getLogTime();
        try {
            GifHeader gifHeader0 = gifHeaderParser0.parseHeader();
            if(gifHeader0.getNumFrames() > 0 && gifHeader0.getStatus() == 0) {
                Bitmap.Config bitmap$Config0 = options0.get(GifOptions.DECODE_FORMAT) == DecodeFormat.PREFER_RGB_565 ? Bitmap.Config.RGB_565 : Bitmap.Config.ARGB_8888;
                int v3 = ByteBufferGifDecoder.getSampleSize(gifHeader0, v, v1);
                GifDecoder gifDecoder0 = this.gifDecoderFactory.build(this.provider, gifHeader0, byteBuffer0, v3);
                gifDecoder0.setDefaultBitmapConfig(bitmap$Config0);
                gifDecoder0.advance();
                Bitmap bitmap0 = gifDecoder0.getNextFrame();
                if(bitmap0 != null) {
                    UnitTransformation unitTransformation0 = UnitTransformation.get();
                    gifDrawableResource0 = new GifDrawableResource(new GifDrawable(this.context, gifDecoder0, unitTransformation0, v, v1, bitmap0));
                    goto label_17;
                }
                goto label_20;
            }
            goto label_23;
        }
        catch(Throwable throwable0) {
        }
        if(Log.isLoggable("BufferGifDecoder", 2)) {
            Log.v("BufferGifDecoder", "Decoded GIF from stream in " + LogTime.getElapsedMillis(v2));
        }
        throw throwable0;
    label_17:
        if(Log.isLoggable("BufferGifDecoder", 2)) {
            Log.v("BufferGifDecoder", "Decoded GIF from stream in " + LogTime.getElapsedMillis(v2));
        }
        return gifDrawableResource0;
    label_20:
        if(!Log.isLoggable("BufferGifDecoder", 2)) {
            return null;
        }
        Log.v("BufferGifDecoder", "Decoded GIF from stream in " + LogTime.getElapsedMillis(v2));
        return null;
    label_23:
        if(Log.isLoggable("BufferGifDecoder", 2)) {
            Log.v("BufferGifDecoder", "Decoded GIF from stream in " + LogTime.getElapsedMillis(v2));
            return null;
        }
        return null;
    }

    @Override  // com.bumptech.glide.load.ResourceDecoder
    public Resource decode(Object object0, int v, int v1, Options options0) {
        return this.decode(((ByteBuffer)object0), v, v1, options0);
    }

    public GifDrawableResource decode(ByteBuffer byteBuffer0, int v, int v1, Options options0) {
        GifHeaderParser gifHeaderParser0 = this.parserPool.obtain(byteBuffer0);
        try {
            return this.decode(byteBuffer0, v, v1, gifHeaderParser0, options0);
        }
        finally {
            this.parserPool.release(gifHeaderParser0);
        }
    }

    private static int getSampleSize(GifHeader gifHeader0, int v, int v1) {
        int v2 = Math.min(gifHeader0.getHeight() / v1, gifHeader0.getWidth() / v);
        int v3 = Math.max(1, (v2 == 0 ? 0 : Integer.highestOneBit(v2)));
        if(Log.isLoggable("BufferGifDecoder", 2) && v3 > 1) {
            StringBuilder stringBuilder0 = o.t(v3, v, "Downsampling GIF, sampleSize: ", ", target dimens: [", "x");
            stringBuilder0.append(v1);
            stringBuilder0.append("], actual dimens: [");
            stringBuilder0.append(gifHeader0.getWidth());
            stringBuilder0.append("x");
            stringBuilder0.append(gifHeader0.getHeight());
            stringBuilder0.append("]");
            Log.v("BufferGifDecoder", stringBuilder0.toString());
        }
        return v3;
    }

    @Override  // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(Object object0, Options options0) {
        return this.handles(((ByteBuffer)object0), options0);
    }

    public boolean handles(ByteBuffer byteBuffer0, Options options0) {
        return !((Boolean)options0.get(GifOptions.DISABLE_ANIMATION)).booleanValue() && ImageHeaderParserUtils.getType(this.parsers, byteBuffer0) == ImageType.GIF;
    }
}

