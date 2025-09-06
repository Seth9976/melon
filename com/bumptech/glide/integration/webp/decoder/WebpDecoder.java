package com.bumptech.glide.integration.webp.decoder;

import U4.x;
import android.graphics.Bitmap.Config;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint.Style;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.LruCache;
import com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.gifdecoder.GifHeader;
import com.bumptech.glide.integration.webp.WebpFrame;
import com.bumptech.glide.integration.webp.WebpFrameInfo;
import com.bumptech.glide.integration.webp.WebpImage;
import java.io.InputStream;
import java.nio.ByteBuffer;
import va.e;

public class WebpDecoder implements GifDecoder {
    private static final int MAX_FRAME_BITMAP_CACHE_SIZE = 5;
    private static final String TAG = "WebpDecoder";
    private int downsampledHeight;
    private int downsampledWidth;
    private Bitmap.Config mBitmapConfig;
    private final BitmapProvider mBitmapProvider;
    private WebpFrameCacheStrategy mCacheStrategy;
    private final LruCache mFrameBitmapCache;
    private final int[] mFrameDurations;
    private final WebpFrameInfo[] mFrameInfos;
    private int mFramePointer;
    private final Paint mTransparentFillPaint;
    private WebpImage mWebPImage;
    private ByteBuffer rawData;
    private int sampleSize;

    public WebpDecoder(BitmapProvider gifDecoder$BitmapProvider0, WebpImage webpImage0, ByteBuffer byteBuffer0, int v) {
        this(gifDecoder$BitmapProvider0, webpImage0, byteBuffer0, v, WebpFrameCacheStrategy.NONE);
    }

    public WebpDecoder(BitmapProvider gifDecoder$BitmapProvider0, WebpImage webpImage0, ByteBuffer byteBuffer0, int v, WebpFrameCacheStrategy webpFrameCacheStrategy0) {
        this.mFramePointer = -1;
        this.mBitmapConfig = Bitmap.Config.ARGB_8888;
        this.mBitmapProvider = gifDecoder$BitmapProvider0;
        this.mWebPImage = webpImage0;
        this.mFrameDurations = webpImage0.getFrameDurations();
        this.mFrameInfos = new WebpFrameInfo[webpImage0.getFrameCount()];
        for(int v1 = 0; v1 < this.mWebPImage.getFrameCount(); ++v1) {
            this.mFrameInfos[v1] = this.mWebPImage.getFrameInfo(v1);
            if(Log.isLoggable("WebpDecoder", 3)) {
                Log.d("WebpDecoder", "mFrameInfos: " + this.mFrameInfos[v1].toString());
            }
        }
        this.mCacheStrategy = webpFrameCacheStrategy0;
        Paint paint0 = new Paint();
        this.mTransparentFillPaint = paint0;
        paint0.setColor(0);
        paint0.setStyle(Paint.Style.FILL);
        paint0.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        this.mFrameBitmapCache = new LruCache((this.mCacheStrategy.cacheAll() ? webpImage0.getFrameCount() : Math.max(5, this.mCacheStrategy.getCacheSize()))) {
            public void entryRemoved(boolean z, Integer integer0, Bitmap bitmap0, Bitmap bitmap1) {
                if(bitmap0 != null) {
                    WebpDecoder.this.mBitmapProvider.release(bitmap0);
                }
            }

            @Override  // android.util.LruCache
            public void entryRemoved(boolean z, Object object0, Object object1, Object object2) {
                this.entryRemoved(z, ((Integer)object0), ((Bitmap)object1), ((Bitmap)object2));
            }
        };
        this.setData(new GifHeader(), byteBuffer0, v);
    }

    @Override  // com.bumptech.glide.gifdecoder.GifDecoder
    public void advance() {
        this.mFramePointer = (this.mFramePointer + 1) % this.mWebPImage.getFrameCount();
    }

    private void cacheFrameBitmap(int v, Bitmap bitmap0) {
        this.mFrameBitmapCache.remove(v);
        int v1 = bitmap0.getWidth();
        int v2 = bitmap0.getHeight();
        Bitmap.Config bitmap$Config0 = bitmap0.getConfig();
        Bitmap bitmap1 = this.mBitmapProvider.obtain(v1, v2, bitmap$Config0);
        bitmap1.eraseColor(0);
        bitmap1.setDensity(bitmap0.getDensity());
        Canvas canvas0 = new Canvas(bitmap1);
        canvas0.drawColor(0, PorterDuff.Mode.SRC);
        canvas0.drawBitmap(bitmap0, 0.0f, 0.0f, null);
        this.mFrameBitmapCache.put(v, bitmap1);
    }

    @Override  // com.bumptech.glide.gifdecoder.GifDecoder
    public void clear() {
        this.mWebPImage.dispose();
        this.mWebPImage = null;
        this.mFrameBitmapCache.evictAll();
        this.rawData = null;
    }

    private void disposeToBackground(Canvas canvas0, WebpFrameInfo webpFrameInfo0) {
        canvas0.drawRect(((float)(webpFrameInfo0.xOffset / this.sampleSize)), ((float)(webpFrameInfo0.yOffset / this.sampleSize)), ((float)((webpFrameInfo0.xOffset + webpFrameInfo0.width) / this.sampleSize)), ((float)((webpFrameInfo0.yOffset + webpFrameInfo0.height) / this.sampleSize)), this.mTransparentFillPaint);
    }

    @Override  // com.bumptech.glide.gifdecoder.GifDecoder
    public int getByteSize() {
        return this.mWebPImage.getSizeInBytes();
    }

    public WebpFrameCacheStrategy getCacheStrategy() {
        return this.mCacheStrategy;
    }

    @Override  // com.bumptech.glide.gifdecoder.GifDecoder
    public int getCurrentFrameIndex() {
        return this.mFramePointer;
    }

    @Override  // com.bumptech.glide.gifdecoder.GifDecoder
    public ByteBuffer getData() {
        return this.rawData;
    }

    @Override  // com.bumptech.glide.gifdecoder.GifDecoder
    public int getDelay(int v) {
        if(v >= 0) {
            return v >= this.mFrameDurations.length ? -1 : this.mFrameDurations[v];
        }
        return -1;
    }

    @Override  // com.bumptech.glide.gifdecoder.GifDecoder
    public int getFrameCount() {
        return this.mWebPImage.getFrameCount();
    }

    @Override  // com.bumptech.glide.gifdecoder.GifDecoder
    public int getHeight() {
        return this.mWebPImage.getHeight();
    }

    @Override  // com.bumptech.glide.gifdecoder.GifDecoder
    @Deprecated
    public int getLoopCount() {
        return this.mWebPImage.getLoopCount();
    }

    @Override  // com.bumptech.glide.gifdecoder.GifDecoder
    public int getNetscapeLoopCount() {
        return this.mWebPImage.getLoopCount();
    }

    @Override  // com.bumptech.glide.gifdecoder.GifDecoder
    public int getNextDelay() {
        if(this.mFrameDurations.length != 0) {
            return this.mFramePointer < 0 ? 0 : this.getDelay(this.mFramePointer);
        }
        return 0;
    }

    @Override  // com.bumptech.glide.gifdecoder.GifDecoder
    public Bitmap getNextFrame() {
        int v = this.getCurrentFrameIndex();
        Bitmap bitmap0 = this.mBitmapProvider.obtain(this.downsampledWidth, this.downsampledHeight, Bitmap.Config.ARGB_8888);
        bitmap0.eraseColor(0);
        bitmap0.setDensity(DisplayMetrics.DENSITY_DEVICE_STABLE);
        Canvas canvas0 = new Canvas(bitmap0);
        canvas0.drawColor(0, PorterDuff.Mode.SRC);
        if(!this.mCacheStrategy.noCache()) {
            Bitmap bitmap1 = (Bitmap)this.mFrameBitmapCache.get(v);
            if(bitmap1 != null) {
                if(Log.isLoggable("WebpDecoder", 3)) {
                    e.f(v, "hit frame bitmap from memory cache, frameNumber=", "WebpDecoder");
                }
                bitmap1.setDensity(canvas0.getDensity());
                canvas0.drawBitmap(bitmap1, 0.0f, 0.0f, null);
                return bitmap0;
            }
        }
        int v1 = this.isKeyFrame(v) ? v : this.prepareCanvasWithBlending(v - 1, canvas0);
        if(Log.isLoggable("WebpDecoder", 3)) {
            Log.d("WebpDecoder", "frameNumber=" + v + ", nextIndex=" + v1);
        }
        while(v1 < v) {
            WebpFrameInfo webpFrameInfo0 = this.mFrameInfos[v1];
            if(!webpFrameInfo0.blendPreviousFrame) {
                this.disposeToBackground(canvas0, webpFrameInfo0);
            }
            this.renderFrame(v1, canvas0);
            if(Log.isLoggable("WebpDecoder", 3)) {
                StringBuilder stringBuilder0 = x.n(v1, "renderFrame, index=", ", blend=");
                stringBuilder0.append(webpFrameInfo0.blendPreviousFrame);
                stringBuilder0.append(", dispose=");
                stringBuilder0.append(webpFrameInfo0.disposeBackgroundColor);
                Log.d("WebpDecoder", stringBuilder0.toString());
            }
            if(webpFrameInfo0.disposeBackgroundColor) {
                this.disposeToBackground(canvas0, webpFrameInfo0);
            }
            ++v1;
        }
        WebpFrameInfo webpFrameInfo1 = this.mFrameInfos[v];
        if(!webpFrameInfo1.blendPreviousFrame) {
            this.disposeToBackground(canvas0, webpFrameInfo1);
        }
        this.renderFrame(v, canvas0);
        if(Log.isLoggable("WebpDecoder", 3)) {
            StringBuilder stringBuilder1 = x.n(v, "renderFrame, index=", ", blend=");
            stringBuilder1.append(webpFrameInfo1.blendPreviousFrame);
            stringBuilder1.append(", dispose=");
            stringBuilder1.append(webpFrameInfo1.disposeBackgroundColor);
            Log.d("WebpDecoder", stringBuilder1.toString());
        }
        this.cacheFrameBitmap(v, bitmap0);
        return bitmap0;
    }

    @Override  // com.bumptech.glide.gifdecoder.GifDecoder
    public int getStatus() {
        return 0;
    }

    @Override  // com.bumptech.glide.gifdecoder.GifDecoder
    public int getTotalIterationCount() {
        return this.mWebPImage.getLoopCount() == 0 ? 0 : this.mWebPImage.getLoopCount();
    }

    @Override  // com.bumptech.glide.gifdecoder.GifDecoder
    public int getWidth() {
        return this.mWebPImage.getWidth();
    }

    private boolean isFullFrame(WebpFrameInfo webpFrameInfo0) {
        return webpFrameInfo0.xOffset == 0 && webpFrameInfo0.yOffset == 0 && webpFrameInfo0.width == this.mWebPImage.getWidth() && webpFrameInfo0.height == this.mWebPImage.getHeight();
    }

    private boolean isKeyFrame(int v) {
        if(v == 0) {
            return true;
        }
        WebpFrameInfo webpFrameInfo0 = this.mFrameInfos[v];
        WebpFrameInfo webpFrameInfo1 = this.mFrameInfos[v - 1];
        return webpFrameInfo0.blendPreviousFrame || !this.isFullFrame(webpFrameInfo0) ? webpFrameInfo1.disposeBackgroundColor && this.isFullFrame(webpFrameInfo1) : true;
    }

    private int prepareCanvasWithBlending(int v, Canvas canvas0) {
        while(v >= 0) {
            WebpFrameInfo webpFrameInfo0 = this.mFrameInfos[v];
            if(webpFrameInfo0.disposeBackgroundColor && this.isFullFrame(webpFrameInfo0)) {
                return v + 1;
            }
            Bitmap bitmap0 = (Bitmap)this.mFrameBitmapCache.get(v);
            if(bitmap0 != null && !bitmap0.isRecycled()) {
                bitmap0.setDensity(canvas0.getDensity());
                canvas0.drawBitmap(bitmap0, 0.0f, 0.0f, null);
                if(webpFrameInfo0.disposeBackgroundColor) {
                    this.disposeToBackground(canvas0, webpFrameInfo0);
                }
                return v + 1;
            }
            if(this.isKeyFrame(v)) {
                return v;
            }
            --v;
        }
        return 0;
    }

    @Override  // com.bumptech.glide.gifdecoder.GifDecoder
    public int read(InputStream inputStream0, int v) {
        return 0;
    }

    @Override  // com.bumptech.glide.gifdecoder.GifDecoder
    public int read(byte[] arr_b) {
        return 0;
    }

    private void renderFrame(int v, Canvas canvas0) {
        WebpFrameInfo webpFrameInfo0 = this.mFrameInfos[v];
        int v1 = this.sampleSize;
        int v2 = webpFrameInfo0.width / v1;
        int v3 = webpFrameInfo0.height / v1;
        int v4 = webpFrameInfo0.xOffset / v1;
        int v5 = webpFrameInfo0.yOffset / v1;
        if(v2 != 0 && v3 != 0) {
            WebpFrame webpFrame0 = this.mWebPImage.getFrame(v);
            try {
                Bitmap bitmap0 = this.mBitmapProvider.obtain(v2, v3, this.mBitmapConfig);
                bitmap0.eraseColor(0);
                bitmap0.setDensity(canvas0.getDensity());
                webpFrame0.renderFrame(v2, v3, bitmap0);
                canvas0.drawBitmap(bitmap0, ((float)v4), ((float)v5), null);
                this.mBitmapProvider.release(bitmap0);
            }
            catch(IllegalStateException | IllegalArgumentException unused_ex) {
                Log.e("WebpDecoder", "Rendering of frame failed. Frame number: " + v);
            }
            finally {
                webpFrame0.dispose();
            }
        }
    }

    @Override  // com.bumptech.glide.gifdecoder.GifDecoder
    public void resetFrameIndex() {
        this.mFramePointer = -1;
    }

    @Override  // com.bumptech.glide.gifdecoder.GifDecoder
    public void setData(GifHeader gifHeader0, ByteBuffer byteBuffer0) {
        this.setData(gifHeader0, byteBuffer0, 1);
    }

    @Override  // com.bumptech.glide.gifdecoder.GifDecoder
    public void setData(GifHeader gifHeader0, ByteBuffer byteBuffer0, int v) {
        if(v <= 0) {
            throw new IllegalArgumentException("Sample size must be >=0, not: " + v);
        }
        int v1 = Integer.highestOneBit(v);
        ByteBuffer byteBuffer1 = byteBuffer0.asReadOnlyBuffer();
        this.rawData = byteBuffer1;
        byteBuffer1.position(0);
        this.sampleSize = v1;
        this.downsampledWidth = this.mWebPImage.getWidth() / v1;
        this.downsampledHeight = this.mWebPImage.getHeight() / v1;
    }

    @Override  // com.bumptech.glide.gifdecoder.GifDecoder
    public void setData(GifHeader gifHeader0, byte[] arr_b) {
        this.setData(gifHeader0, ByteBuffer.wrap(arr_b));
    }

    @Override  // com.bumptech.glide.gifdecoder.GifDecoder
    public void setDefaultBitmapConfig(Bitmap.Config bitmap$Config0) {
        Bitmap.Config bitmap$Config1 = Bitmap.Config.ARGB_8888;
        if(bitmap$Config0 != bitmap$Config1) {
            throw new IllegalArgumentException("Unsupported format: " + bitmap$Config0 + ", must be one of " + bitmap$Config1);
        }
        this.mBitmapConfig = bitmap$Config0;
    }
}

