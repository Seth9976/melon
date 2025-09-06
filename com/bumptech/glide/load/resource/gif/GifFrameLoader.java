package com.bumptech.glide.load.resource.gif;

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
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.Key;
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
import java.util.ArrayList;
import java.util.List;

class GifFrameLoader {
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
                GifFrameLoader.this.onFrameReady(((DelayTarget)message0.obj));
                return true;
            }
            if(v == 2) {
                GifFrameLoader.this.requestManager.clear(((DelayTarget)message0.obj));
            }
            return false;
        }
    }

    interface OnEveryFrameListener {
        void onFrameReady();
    }

    private final BitmapPool bitmapPool;
    private final List callbacks;
    private DelayTarget current;
    private Bitmap firstFrame;
    private int firstFrameSize;
    private final GifDecoder gifDecoder;
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
    private int width;

    public GifFrameLoader(Glide glide0, GifDecoder gifDecoder0, int v, int v1, Transformation transformation0, Bitmap bitmap0) {
        this(glide0.getBitmapPool(), Glide.with(glide0.getContext()), gifDecoder0, null, GifFrameLoader.getRequestBuilder(Glide.with(glide0.getContext()), v, v1), transformation0, bitmap0);
    }

    public GifFrameLoader(BitmapPool bitmapPool0, RequestManager requestManager0, GifDecoder gifDecoder0, Handler handler0, RequestBuilder requestBuilder0, Transformation transformation0, Bitmap bitmap0) {
        this.callbacks = new ArrayList();
        this.requestManager = requestManager0;
        if(handler0 == null) {
            handler0 = new Handler(Looper.getMainLooper(), new FrameLoaderCallback(this));
        }
        this.bitmapPool = bitmapPool0;
        this.handler = handler0;
        this.requestBuilder = requestBuilder0;
        this.gifDecoder = gifDecoder0;
        this.setFrameTransformation(transformation0, bitmap0);
    }

    public void clear() {
        this.callbacks.clear();
        this.recycleFirstFrame();
        this.stop();
        DelayTarget gifFrameLoader$DelayTarget0 = this.current;
        if(gifFrameLoader$DelayTarget0 != null) {
            this.requestManager.clear(gifFrameLoader$DelayTarget0);
            this.current = null;
        }
        DelayTarget gifFrameLoader$DelayTarget1 = this.next;
        if(gifFrameLoader$DelayTarget1 != null) {
            this.requestManager.clear(gifFrameLoader$DelayTarget1);
            this.next = null;
        }
        DelayTarget gifFrameLoader$DelayTarget2 = this.pendingTarget;
        if(gifFrameLoader$DelayTarget2 != null) {
            this.requestManager.clear(gifFrameLoader$DelayTarget2);
            this.pendingTarget = null;
        }
        this.gifDecoder.clear();
        this.isCleared = true;
    }

    public ByteBuffer getBuffer() {
        return this.gifDecoder.getData().asReadOnlyBuffer();
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
        return this.gifDecoder.getFrameCount();
    }

    private static Key getFrameSignature() {
        return new ObjectKey(Math.random());
    }

    public Transformation getFrameTransformation() {
        return this.transformation;
    }

    public int getHeight() {
        return this.height;
    }

    public int getLoopCount() {
        return this.gifDecoder.getTotalIterationCount();
    }

    private static RequestBuilder getRequestBuilder(RequestManager requestManager0, int v, int v1) {
        return requestManager0.asBitmap().apply(((RequestOptions)((RequestOptions)RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE).useAnimationPool(true)).skipMemoryCache(true)).override(v, v1));
    }

    public int getSize() {
        return this.gifDecoder.getByteSize() + this.firstFrameSize;
    }

    public int getWidth() {
        return this.width;
    }

    private void loadNextFrame() {
        if(this.isRunning && !this.isLoadPending) {
            if(this.startFromFirstFrame) {
                Preconditions.checkArgument(this.pendingTarget == null, "Pending target must be null when starting from the first frame");
                this.gifDecoder.resetFrameIndex();
                this.startFromFirstFrame = false;
            }
            DelayTarget gifFrameLoader$DelayTarget0 = this.pendingTarget;
            if(gifFrameLoader$DelayTarget0 != null) {
                this.pendingTarget = null;
                this.onFrameReady(gifFrameLoader$DelayTarget0);
                return;
            }
            this.isLoadPending = true;
            int v = this.gifDecoder.getNextDelay();
            long v1 = SystemClock.uptimeMillis();
            this.gifDecoder.advance();
            int v2 = this.gifDecoder.getCurrentFrameIndex();
            this.next = new DelayTarget(this.handler, v2, v1 + ((long)v));
            this.requestBuilder.apply(RequestOptions.signatureOf(GifFrameLoader.getFrameSignature())).load(this.gifDecoder).into(this.next);
        }
    }

    public void onFrameReady(DelayTarget gifFrameLoader$DelayTarget0) {
        OnEveryFrameListener gifFrameLoader$OnEveryFrameListener0 = this.onEveryFrameListener;
        if(gifFrameLoader$OnEveryFrameListener0 != null) {
            gifFrameLoader$OnEveryFrameListener0.onFrameReady();
        }
        this.isLoadPending = false;
        if(this.isCleared) {
            this.handler.obtainMessage(2, gifFrameLoader$DelayTarget0).sendToTarget();
            return;
        }
        if(!this.isRunning) {
            if(this.startFromFirstFrame) {
                this.handler.obtainMessage(2, gifFrameLoader$DelayTarget0).sendToTarget();
                return;
            }
            this.pendingTarget = gifFrameLoader$DelayTarget0;
            return;
        }
        if(gifFrameLoader$DelayTarget0.getResource() != null) {
            this.recycleFirstFrame();
            DelayTarget gifFrameLoader$DelayTarget1 = this.current;
            this.current = gifFrameLoader$DelayTarget0;
            for(int v = this.callbacks.size() - 1; v >= 0; --v) {
                ((FrameCallback)this.callbacks.get(v)).onFrameReady();
            }
            if(gifFrameLoader$DelayTarget1 != null) {
                this.handler.obtainMessage(2, gifFrameLoader$DelayTarget1).sendToTarget();
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
        DelayTarget gifFrameLoader$DelayTarget0 = this.pendingTarget;
        if(gifFrameLoader$DelayTarget0 != null) {
            this.requestManager.clear(gifFrameLoader$DelayTarget0);
            this.pendingTarget = null;
        }
    }

    public void setOnEveryFrameReadyListener(OnEveryFrameListener gifFrameLoader$OnEveryFrameListener0) {
        this.onEveryFrameListener = gifFrameLoader$OnEveryFrameListener0;
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

    public void subscribe(FrameCallback gifFrameLoader$FrameCallback0) {
        if(this.isCleared) {
            throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
        }
        if(this.callbacks.contains(gifFrameLoader$FrameCallback0)) {
            throw new IllegalStateException("Cannot subscribe twice in a row");
        }
        this.callbacks.add(gifFrameLoader$FrameCallback0);
        if(this.callbacks.isEmpty()) {
            this.start();
        }
    }

    public void unsubscribe(FrameCallback gifFrameLoader$FrameCallback0) {
        this.callbacks.remove(gifFrameLoader$FrameCallback0);
        if(this.callbacks.isEmpty()) {
            this.stop();
        }
    }
}

