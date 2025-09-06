package com.bumptech.glide.integration.webp.decoder;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler.Callback;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.signature.ObjectKey;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

public class WebpFrameLoader {
    static class DelayTarget extends CustomTarget {
        private final Handler handler;
        final int index;
        private Bitmap resource;
        private final long targetTime;

        public DelayTarget(Handler handler0, int v, long v1) {
            this.handler = handler0;
            this.index = v;
            this.targetTime = v1;
        }

        public Bitmap getResource() {
            return this.resource;
        }

        @Override  // com.bumptech.glide.request.target.Target
        public void onLoadCleared(Drawable drawable0) {
            this.resource = null;
        }

        public void onResourceReady(Bitmap bitmap0, Transition transition0) {
            this.resource = bitmap0;
            Message message0 = this.handler.obtainMessage(1, this);
            this.handler.sendMessageAtTime(message0, this.targetTime);
        }

        @Override  // com.bumptech.glide.request.target.Target
        public void onResourceReady(Object object0, Transition transition0) {
            this.onResourceReady(((Bitmap)object0), transition0);
        }
    }

    public interface FrameCallback {
        void onFrameReady();
    }

    class FrameLoaderCallback implements Handler.Callback {
        static final int MSG_CLEAR = 2;
        static final int MSG_DELAY = 1;

        @Override  // android.os.Handler$Callback
        public boolean handleMessage(Message message0) {
            int v = message0.what;
            if(v == 1) {
                WebpFrameLoader.this.onFrameReady(((DelayTarget)message0.obj));
                return true;
            }
            if(v == 2) {
                WebpFrameLoader.this.requestManager.clear(((DelayTarget)message0.obj));
            }
            return false;
        }
    }

    interface OnEveryFrameListener {
        void onFrameReady();
    }

    static class WebpFrameCacheKey implements Key {
        private final int frameIndex;
        private final Key sourceKey;

        public WebpFrameCacheKey(Key key0, int v) {
            this.sourceKey = key0;
            this.frameIndex = v;
        }

        // 去混淆评级： 低(20)
        @Override  // com.bumptech.glide.load.Key
        public boolean equals(Object object0) {
            return object0 instanceof WebpFrameCacheKey && this.sourceKey.equals(((WebpFrameCacheKey)object0).sourceKey) && this.frameIndex == ((WebpFrameCacheKey)object0).frameIndex;
        }

        @Override  // com.bumptech.glide.load.Key
        public int hashCode() {
            return this.sourceKey.hashCode() * 0x1F + this.frameIndex;
        }

        @Override  // com.bumptech.glide.load.Key
        public void updateDiskCacheKey(MessageDigest messageDigest0) {
            messageDigest0.update(ByteBuffer.allocate(12).putInt(this.frameIndex).array());
            this.sourceKey.updateDiskCacheKey(messageDigest0);
        }
    }

    public static final Option FRAME_CACHE_STRATEGY;
    private final BitmapPool bitmapPool;
    private final List callbacks;
    private DelayTarget current;
    private Bitmap firstFrame;
    private int firstFrameSize;
    private final Handler handler;
    private int height;
    private boolean isCleared;
    private boolean isLoadPending;
    private boolean isRunning;
    private DelayTarget next;
    private OnEveryFrameListener onEveryFrameListener;
    private DelayTarget pendingTarget;
    private RequestBuilder requestBuilder;
    final RequestManager requestManager;
    private boolean startFromFirstFrame;
    private Transformation transformation;
    private final WebpDecoder webpDecoder;
    private int width;

    static {
        WebpFrameLoader.FRAME_CACHE_STRATEGY = Option.memory("com.bumptech.glide.integration.webp.decoder.WebpFrameLoader.CacheStrategy", WebpFrameCacheStrategy.AUTO);
    }

    public WebpFrameLoader(Glide glide0, WebpDecoder webpDecoder0, int v, int v1, Transformation transformation0, Bitmap bitmap0) {
        this(glide0.getBitmapPool(), Glide.with(glide0.getContext()), webpDecoder0, null, WebpFrameLoader.getRequestBuilder(Glide.with(glide0.getContext()), v, v1), transformation0, bitmap0);
    }

    public WebpFrameLoader(BitmapPool bitmapPool0, RequestManager requestManager0, WebpDecoder webpDecoder0, Handler handler0, RequestBuilder requestBuilder0, Transformation transformation0, Bitmap bitmap0) {
        this.callbacks = new ArrayList();
        this.isRunning = false;
        this.isLoadPending = false;
        this.startFromFirstFrame = false;
        this.requestManager = requestManager0;
        if(handler0 == null) {
            handler0 = new Handler(Looper.getMainLooper(), new FrameLoaderCallback(this));
        }
        this.bitmapPool = bitmapPool0;
        this.handler = handler0;
        this.requestBuilder = requestBuilder0;
        this.webpDecoder = webpDecoder0;
        this.setFrameTransformation(transformation0, bitmap0);
    }

    public void clear() {
        this.callbacks.clear();
        this.recycleFirstFrame();
        this.stop();
        DelayTarget webpFrameLoader$DelayTarget0 = this.current;
        if(webpFrameLoader$DelayTarget0 != null) {
            this.requestManager.clear(webpFrameLoader$DelayTarget0);
            this.current = null;
        }
        DelayTarget webpFrameLoader$DelayTarget1 = this.next;
        if(webpFrameLoader$DelayTarget1 != null) {
            this.requestManager.clear(webpFrameLoader$DelayTarget1);
            this.next = null;
        }
        DelayTarget webpFrameLoader$DelayTarget2 = this.pendingTarget;
        if(webpFrameLoader$DelayTarget2 != null) {
            this.requestManager.clear(webpFrameLoader$DelayTarget2);
            this.pendingTarget = null;
        }
        this.webpDecoder.clear();
        this.isCleared = true;
    }

    public ByteBuffer getBuffer() {
        return this.webpDecoder.getData().asReadOnlyBuffer();
    }

    public Bitmap getCurrentFrame() {
        return this.current == null ? this.firstFrame : this.current.getResource();
    }

    public int getCurrentIndex() {
        return this.current == null ? -1 : this.current.index;
    }

    public Bitmap getFirstFrame() {
        return this.firstFrame;
    }

    public int getFrameCount() {
        return this.webpDecoder.getFrameCount();
    }

    private Key getFrameSignature(int v) {
        return new WebpFrameCacheKey(new ObjectKey(this.webpDecoder), v);
    }

    public Transformation getFrameTransformation() {
        return this.transformation;
    }

    public int getHeight() {
        return this.height;
    }

    public int getLoopCount() {
        return this.webpDecoder.getTotalIterationCount();
    }

    private static RequestBuilder getRequestBuilder(RequestManager requestManager0, int v, int v1) {
        return requestManager0.asBitmap().apply(((RequestOptions)((RequestOptions)RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE).useAnimationPool(true)).skipMemoryCache(true)).override(v, v1));
    }

    public int getSize() {
        return this.webpDecoder.getByteSize() + this.firstFrameSize;
    }

    public int getWidth() {
        return this.width;
    }

    private void loadNextFrame() {
        if(this.isRunning && !this.isLoadPending) {
            if(this.startFromFirstFrame) {
                Preconditions.checkArgument(this.pendingTarget == null, "Pending target must be null when starting from the first frame");
                this.webpDecoder.resetFrameIndex();
                this.startFromFirstFrame = false;
            }
            DelayTarget webpFrameLoader$DelayTarget0 = this.pendingTarget;
            if(webpFrameLoader$DelayTarget0 != null) {
                this.pendingTarget = null;
                this.onFrameReady(webpFrameLoader$DelayTarget0);
                return;
            }
            this.isLoadPending = true;
            int v = this.webpDecoder.getNextDelay();
            long v1 = SystemClock.uptimeMillis();
            this.webpDecoder.advance();
            int v2 = this.webpDecoder.getCurrentFrameIndex();
            this.next = new DelayTarget(this.handler, v2, v1 + ((long)v));
            RequestOptions requestOptions0 = (RequestOptions)RequestOptions.signatureOf(this.getFrameSignature(v2)).skipMemoryCache(this.webpDecoder.getCacheStrategy().noCache());
            this.requestBuilder.apply(requestOptions0).load(this.webpDecoder).into(this.next);
        }
    }

    public void onFrameReady(DelayTarget webpFrameLoader$DelayTarget0) {
        OnEveryFrameListener webpFrameLoader$OnEveryFrameListener0 = this.onEveryFrameListener;
        if(webpFrameLoader$OnEveryFrameListener0 != null) {
            webpFrameLoader$OnEveryFrameListener0.onFrameReady();
        }
        this.isLoadPending = false;
        if(this.isCleared) {
            this.handler.obtainMessage(2, webpFrameLoader$DelayTarget0).sendToTarget();
            return;
        }
        if(!this.isRunning) {
            if(this.startFromFirstFrame) {
                this.handler.obtainMessage(2, webpFrameLoader$DelayTarget0).sendToTarget();
                return;
            }
            this.pendingTarget = webpFrameLoader$DelayTarget0;
            return;
        }
        if(webpFrameLoader$DelayTarget0.getResource() != null) {
            this.recycleFirstFrame();
            DelayTarget webpFrameLoader$DelayTarget1 = this.current;
            this.current = webpFrameLoader$DelayTarget0;
            for(int v = this.callbacks.size() - 1; v >= 0; --v) {
                try {
                    FrameCallback webpFrameLoader$FrameCallback0 = (FrameCallback)this.callbacks.get(v);
                    if(webpFrameLoader$FrameCallback0 != null) {
                        webpFrameLoader$FrameCallback0.onFrameReady();
                    }
                }
                catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
                    indexOutOfBoundsException0.printStackTrace();
                }
            }
            if(webpFrameLoader$DelayTarget1 != null) {
                this.handler.obtainMessage(2, webpFrameLoader$DelayTarget1).sendToTarget();
            }
        }
        this.loadNextFrame();
    }

    private void recycleFirstFrame() {
        Bitmap bitmap0 = this.firstFrame;
        if(bitmap0 != null) {
            this.bitmapPool.put(bitmap0);
            this.firstFrame = null;
        }
    }

    public void setFrameTransformation(Transformation transformation0, Bitmap bitmap0) {
        this.transformation = (Transformation)Preconditions.checkNotNull(transformation0);
        this.firstFrame = (Bitmap)Preconditions.checkNotNull(bitmap0);
        this.requestBuilder = this.requestBuilder.apply(new RequestOptions().transform(transformation0));
        this.firstFrameSize = Util.getBitmapByteSize(bitmap0);
        this.width = bitmap0.getWidth();
        this.height = bitmap0.getHeight();
    }

    public void setNextStartFromFirstFrame() {
        Preconditions.checkArgument(!this.isRunning, "Can\'t restart a running animation");
        this.startFromFirstFrame = true;
        DelayTarget webpFrameLoader$DelayTarget0 = this.pendingTarget;
        if(webpFrameLoader$DelayTarget0 != null) {
            this.requestManager.clear(webpFrameLoader$DelayTarget0);
            this.pendingTarget = null;
        }
    }

    public void setOnEveryFrameReadyListener(OnEveryFrameListener webpFrameLoader$OnEveryFrameListener0) {
        this.onEveryFrameListener = webpFrameLoader$OnEveryFrameListener0;
    }

    private void start() {
        if(this.isRunning) {
            return;
        }
        this.isRunning = true;
        this.isCleared = false;
        this.loadNextFrame();
    }

    private void stop() {
        this.isRunning = false;
    }

    public void subscribe(FrameCallback webpFrameLoader$FrameCallback0) {
        if(this.isCleared) {
            throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
        }
        if(this.callbacks.contains(webpFrameLoader$FrameCallback0)) {
            throw new IllegalStateException("Cannot subscribe twice in a row");
        }
        this.callbacks.add(webpFrameLoader$FrameCallback0);
        if(this.callbacks.isEmpty()) {
            this.start();
        }
    }

    public void unsubscribe(FrameCallback webpFrameLoader$FrameCallback0) {
        this.callbacks.remove(webpFrameLoader$FrameCallback0);
        if(this.callbacks.isEmpty()) {
            this.stop();
        }
    }
}

