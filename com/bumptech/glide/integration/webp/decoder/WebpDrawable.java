package com.bumptech.glide.integration.webp.decoder;

import O4.c;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Preconditions;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class WebpDrawable extends Drawable implements Animatable, FrameCallback {
    static class WebpState extends Drawable.ConstantState {
        final BitmapPool bitmapPool;
        final WebpFrameLoader frameLoader;

        public WebpState(BitmapPool bitmapPool0, WebpFrameLoader webpFrameLoader0) {
            this.bitmapPool = bitmapPool0;
            this.frameLoader = webpFrameLoader0;
        }

        @Override  // android.graphics.drawable.Drawable$ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override  // android.graphics.drawable.Drawable$ConstantState
        public Drawable newDrawable() {
            return new WebpDrawable(this);
        }

        @Override  // android.graphics.drawable.Drawable$ConstantState
        public Drawable newDrawable(Resources resources0) {
            return this.newDrawable();
        }
    }

    private static final int GRAVITY = 0x77;
    public static final int LOOP_FOREVER = -1;
    public static final int LOOP_INTRINSIC;
    private List animationCallbacks;
    private boolean applyGravity;
    private Rect destRect;
    private boolean isRecycled;
    private boolean isRunning;
    private boolean isStarted;
    private boolean isVisible;
    private int loopCount;
    private int maxLoopCount;
    private Paint paint;
    private final WebpState state;

    public WebpDrawable(Context context0, WebpDecoder webpDecoder0, BitmapPool bitmapPool0, Transformation transformation0, int v, int v1, Bitmap bitmap0) {
        this(new WebpState(bitmapPool0, new WebpFrameLoader(Glide.get(context0), webpDecoder0, v, v1, transformation0, bitmap0)));
    }

    public WebpDrawable(WebpState webpDrawable$WebpState0) {
        this.maxLoopCount = -1;
        this.isVisible = true;
        this.state = (WebpState)Preconditions.checkNotNull(webpDrawable$WebpState0);
        this.setLoopCount(0);
    }

    public WebpDrawable(WebpFrameLoader webpFrameLoader0, BitmapPool bitmapPool0, Paint paint0) {
        this(new WebpState(bitmapPool0, webpFrameLoader0));
        this.paint = paint0;
    }

    public void clearAnimationCallbacks() {
        List list0 = this.animationCallbacks;
        if(list0 != null) {
            list0.clear();
        }
    }

    @Override  // android.graphics.drawable.Drawable
    public void draw(Canvas canvas0) {
        if(this.isRecycled()) {
            return;
        }
        if(this.applyGravity) {
            Gravity.apply(0x77, this.getIntrinsicWidth(), this.getIntrinsicHeight(), this.getBounds(), this.getDestRect());
            this.applyGravity = false;
        }
        canvas0.drawBitmap(this.state.frameLoader.getCurrentFrame(), null, this.getDestRect(), this.getPaint());
    }

    private Drawable.Callback findCallback() {
        Drawable.Callback drawable$Callback0;
        for(drawable$Callback0 = this.getCallback(); drawable$Callback0 instanceof Drawable; drawable$Callback0 = ((Drawable)drawable$Callback0).getCallback()) {
        }
        return drawable$Callback0;
    }

    public ByteBuffer getBuffer() {
        return this.state.frameLoader.getBuffer();
    }

    @Override  // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.state;
    }

    private Rect getDestRect() {
        if(this.destRect == null) {
            this.destRect = new Rect();
        }
        return this.destRect;
    }

    public Bitmap getFirstFrame() {
        return this.state.frameLoader.getFirstFrame();
    }

    public int getFrameCount() {
        return this.state.frameLoader.getFrameCount();
    }

    public int getFrameIndex() {
        return this.state.frameLoader.getCurrentIndex();
    }

    public Transformation getFrameTransformation() {
        return this.state.frameLoader.getFrameTransformation();
    }

    @Override  // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.state.frameLoader.getHeight();
    }

    public int getIntrinsicLoopCount() {
        return this.state.frameLoader.getLoopCount();
    }

    @Override  // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.state.frameLoader.getWidth();
    }

    public int getLoopCount() {
        return this.maxLoopCount;
    }

    @Override  // android.graphics.drawable.Drawable
    @Deprecated
    public int getOpacity() {
        return -2;
    }

    private Paint getPaint() {
        if(this.paint == null) {
            this.paint = new Paint(2);
        }
        return this.paint;
    }

    public int getSize() {
        return this.state.frameLoader.getSize();
    }

    public boolean isRecycled() {
        return this.isRecycled;
    }

    @Override  // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.isRunning;
    }

    private void notifyAnimationEndToListeners() {
        List list0 = this.animationCallbacks;
        if(list0 != null) {
            int v = list0.size();
            for(int v1 = 0; v1 < v; ++v1) {
                ((c)this.animationCallbacks.get(v1)).a(this);
            }
        }
    }

    @Override  // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect0) {
        super.onBoundsChange(rect0);
        this.applyGravity = true;
    }

    @Override  // com.bumptech.glide.integration.webp.decoder.WebpFrameLoader$FrameCallback
    public void onFrameReady() {
        if(this.findCallback() == null) {
            this.stop();
            this.invalidateSelf();
            return;
        }
        this.invalidateSelf();
        if(this.getFrameIndex() == this.getFrameCount() - 1) {
            ++this.loopCount;
        }
        if(this.maxLoopCount != -1 && this.loopCount >= this.maxLoopCount) {
            this.stop();
            this.notifyAnimationEndToListeners();
        }
    }

    public void recycle() {
        this.isRecycled = true;
        this.state.frameLoader.clear();
    }

    public void registerAnimationCallback(c c0) {
        if(c0 == null) {
            return;
        }
        if(this.animationCallbacks == null) {
            this.animationCallbacks = new ArrayList();
        }
        this.animationCallbacks.add(c0);
    }

    private void resetLoopCount() {
        this.loopCount = 0;
    }

    @Override  // android.graphics.drawable.Drawable
    public void setAlpha(int v) {
        this.getPaint().setAlpha(v);
    }

    @Override  // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter0) {
        this.getPaint().setColorFilter(colorFilter0);
    }

    public void setFrameTransformation(Transformation transformation0, Bitmap bitmap0) {
        this.state.frameLoader.setFrameTransformation(transformation0, bitmap0);
    }

    public void setIsRunning(boolean z) {
    }

    public void setLoopCount(int v) {
        int v1 = -1;
        if(v <= 0 && (v != -1 && v != 0)) {
            throw new IllegalArgumentException("Loop count must be greater than 0, or equal to LOOP_FOREVER, or equal to LOOP_INTRINSIC");
        }
        if(v == 0) {
            int v2 = this.state.frameLoader.getLoopCount();
            if(v2 != 0) {
                v1 = v2;
            }
            this.maxLoopCount = v1;
            return;
        }
        this.maxLoopCount = v;
    }

    @Override  // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z1) {
        Preconditions.checkArgument(!this.isRecycled, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View\'s visibility.");
        this.isVisible = z;
        if(!z) {
            this.stopRunning();
            return super.setVisible(false, z1);
        }
        if(this.isStarted) {
            this.startRunning();
        }
        return super.setVisible(true, z1);
    }

    @Override  // android.graphics.drawable.Animatable
    public void start() {
        this.isStarted = true;
        this.resetLoopCount();
        if(this.isVisible) {
            this.startRunning();
        }
    }

    public void startFromFirstFrame() {
        Preconditions.checkArgument(!this.isRunning, "You cannot restart a currently running animation.");
        this.state.frameLoader.setNextStartFromFirstFrame();
        this.start();
    }

    private void startRunning() {
        Preconditions.checkArgument(!this.isRecycled, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        if(this.state.frameLoader.getFrameCount() == 1) {
            this.invalidateSelf();
            return;
        }
        if(!this.isRunning) {
            this.isRunning = true;
            this.state.frameLoader.subscribe(this);
            this.invalidateSelf();
        }
    }

    @Override  // android.graphics.drawable.Animatable
    public void stop() {
        this.isStarted = false;
        this.stopRunning();
    }

    private void stopRunning() {
        this.isRunning = false;
        this.state.frameLoader.unsubscribe(this);
    }

    public boolean unregisterAnimationCallback(c c0) {
        return this.animationCallbacks == null || c0 == null ? false : this.animationCallbacks.remove(c0);
    }
}

