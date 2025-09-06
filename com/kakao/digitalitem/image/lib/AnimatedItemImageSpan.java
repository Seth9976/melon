package com.kakao.digitalitem.image.lib;

import P1.c;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.style.DynamicDrawableSpan;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AnimatedItemImageSpan extends DynamicDrawableSpan implements AnimatedItemImageContainer {
    static abstract class AnimationRunnable implements Runnable {
        private final int frameIndex;

        public AnimationRunnable(int v) {
            this.frameIndex = v;
        }

        public static int access$700(AnimationRunnable animatedItemImageSpan$AnimationRunnable0) {
            return animatedItemImageSpan$AnimationRunnable0.frameIndex;
        }
    }

    private static final int IMAGE_DISPOSE_BACKGROUND = 1;
    private static final int MIN_LOOP_COUNT = 4;
    private static final int WEBP_MUX_NO_BLEND = 1;
    private AnimationRunnable animAction;
    private volatile AnimatedItemImage animatedImage;
    private Canvas canvas;
    private Paint clearPaint;
    protected Context context;
    @SuppressLint({"UseSparseArrays"})
    private static final Map currentTask;
    private static final ExecutorService decodingExecutorService;
    private int disposeFrameHeight;
    private int disposeFrameOffsetX;
    private int disposeFrameOffsetY;
    private int disposeFrameWidth;
    private Drawable drawable;
    private static final Handler handler;
    private boolean isAnimated;
    private boolean isNoAnimation;
    private boolean isPrevDispose;
    protected boolean lastIndex;
    protected int minLoopCount;
    private Bitmap mutableBitmap;
    private OnAnimationListener onAnimationListener;
    private OnBitmapDownloadedListener onBitmapDownloadedListener;
    private OnIndexChangeListener onIndexChangeListener;
    private boolean onPrepared;
    private Paint paint;
    private PlayMethod playMethod;
    private OnPreparedListener preparedListener;
    private String soundPath;
    private boolean startAnimationWhenImageLoaded;
    private int viewHeight;
    private int viewWidth;

    static {
        AnimatedItemImageSpan.decodingExecutorService = Executors.newFixedThreadPool(3);
        AnimatedItemImageSpan.handler = new Handler(Looper.getMainLooper());
        AnimatedItemImageSpan.currentTask = new HashMap();
    }

    public AnimatedItemImageSpan() {
        this.minLoopCount = 4;
        this.lastIndex = true;
        this.startAnimationWhenImageLoaded = true;
    }

    public void cancelAnimation() {
        AnimationRunnable animatedItemImageSpan$AnimationRunnable0 = this.animAction;
        if(animatedItemImageSpan$AnimationRunnable0 != null) {
            AnimatedItemImageSpan.handler.removeCallbacks(animatedItemImageSpan$AnimationRunnable0);
            this.animAction = null;
        }
        Future future0 = (Future)AnimatedItemImageSpan.currentTask.remove(this.hashCode());
        if(future0 != null) {
            future0.cancel(true);
        }
        this.isAnimated = false;
    }

    public void clearFrames() {
        if(this.animatedImage != null) {
            this.animatedImage.clearFrames();
        }
    }

    public void clearView() {
        this.stopLoadingDrawable();
        this.cancelAnimation();
        this.clearFrames();
        this.returnBitmap();
    }

    @Override  // android.text.style.DynamicDrawableSpan
    public void draw(Canvas canvas0, CharSequence charSequence0, int v, int v1, float f, int v2, int v3, int v4, Paint paint0) {
        Drawable drawable0 = this.getDrawable();
        if(drawable0 == null) {
            return;
        }
        canvas0.save();
        int v5 = v4 - drawable0.getBounds().bottom;
        if(this.mVerticalAlignment == 1) {
            v5 -= paint0.getFontMetricsInt().descent;
        }
        canvas0.translate(f, ((float)v5));
        drawable0.draw(canvas0);
        canvas0.restore();
    }

    private void drawBitmap(ImageFrame imageFrame0) {
        if(imageFrame0 != null) {
            Canvas canvas0 = this.canvas;
            if(canvas0 == null) {
                this.canvas = new Canvas(this.mutableBitmap);
            }
            else {
                canvas0.setBitmap(this.mutableBitmap);
            }
            if(this.paint == null) {
                this.paint = new Paint();
            }
            int[] arr_v = imageFrame0.getFrame();
            if(arr_v != null) {
                if(this.animatedImage.getType() == Type.WEBP) {
                    if(this.clearPaint == null) {
                        Paint paint0 = new Paint();
                        this.clearPaint = paint0;
                        paint0.setColor(this.animatedImage.getBackgroundColor());
                        this.clearPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
                    }
                    if(imageFrame0.getFrameIndex() == 0) {
                        PorterDuff.Mode porterDuff$Mode0 = PorterDuff.Mode.SRC;
                        this.canvas.drawColor(this.animatedImage.getBackgroundColor(), porterDuff$Mode0);
                        this.paint.setXfermode(new PorterDuffXfermode(porterDuff$Mode0));
                    }
                    else {
                        if(this.isPrevDispose) {
                            this.canvas.drawRect(((float)this.disposeFrameOffsetX), ((float)this.disposeFrameOffsetY), ((float)(this.disposeFrameOffsetX + this.disposeFrameWidth)), ((float)(this.disposeFrameOffsetY + this.disposeFrameHeight)), this.clearPaint);
                        }
                        if(imageFrame0.getBlend() == 1) {
                            this.canvas.drawRect(((float)imageFrame0.getX()), ((float)imageFrame0.getY()), ((float)(imageFrame0.getWidth() + imageFrame0.getX())), ((float)(imageFrame0.getHeight() + imageFrame0.getY())), this.clearPaint);
                            this.paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
                        }
                        else {
                            this.paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
                        }
                    }
                    if(imageFrame0.getDispose() == 1) {
                        this.disposeFrameOffsetX = imageFrame0.getX();
                        this.disposeFrameOffsetY = imageFrame0.getY();
                        this.disposeFrameWidth = imageFrame0.getWidth();
                        this.disposeFrameHeight = imageFrame0.getHeight();
                        this.isPrevDispose = true;
                    }
                    else {
                        this.isPrevDispose = false;
                    }
                }
                else {
                    this.canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                    this.paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
                }
                try {
                    this.canvas.drawBitmap(arr_v, 0, imageFrame0.getWidth(), imageFrame0.getX(), imageFrame0.getY(), imageFrame0.getWidth(), imageFrame0.getHeight(), this.animatedImage.hasAlpha(), this.paint);
                }
                catch(Exception unused_ex) {
                }
                OnIndexChangeListener animatedItemImageView$OnIndexChangeListener0 = this.onIndexChangeListener;
                if(animatedItemImageView$OnIndexChangeListener0 != null) {
                    animatedItemImageView$OnIndexChangeListener0.onIndexChange(this, imageFrame0.getFrameIndex());
                }
            }
        }
    }

    @Override  // com.kakao.digitalitem.image.lib.AnimatedItemImageContainer
    public AnimatedItemImage getAnimatedImage() {
        return this.animatedImage;
    }

    @Override  // com.kakao.digitalitem.image.lib.AnimatedItemImageContainer
    public int getAnimatedViewHeight() {
        return this.viewHeight;
    }

    @Override  // com.kakao.digitalitem.image.lib.AnimatedItemImageContainer
    public int getAnimatedViewWidth() {
        return this.viewWidth;
    }

    @Override  // com.kakao.digitalitem.image.lib.AnimatedItemImageContainer
    public Object getAsyncTaskTagObject() {
        return null;
    }

    private Bitmap getBitmap(ImageFrame imageFrame0) {
        if(this.animatedImage == null) {
            return null;
        }
        if(this.mutableBitmap != null && (this.mutableBitmap.getWidth() != this.animatedImage.getWidth() || this.mutableBitmap.getHeight() != this.animatedImage.getHeight())) {
            this.returnBitmap();
        }
        if(this.animatedImage.getWidth() != 0 && this.animatedImage.getHeight() != 0) {
            if(this.mutableBitmap == null || this.mutableBitmap.isRecycled()) {
                Bitmap bitmap0 = BitmapPool.getInstance().getBitmap(this.animatedImage.getWidth(), this.animatedImage.getHeight());
                this.mutableBitmap = bitmap0;
                if(bitmap0 == null) {
                    return null;
                }
                bitmap0.setDensity(this.animatedImage.getDensity());
            }
            this.drawBitmap(imageFrame0);
            return this.mutableBitmap;
        }
        return null;
    }

    @Override  // android.text.style.DynamicDrawableSpan
    public Drawable getDrawable() {
        if(this.drawable == null) {
            return null;
        }
        float f = this.getAnimatedViewHeight() <= 0 ? 1.0f : ((float)this.getAnimatedViewHeight()) / ((float)this.drawable.getIntrinsicHeight());
        int v = (int)(((float)this.drawable.getIntrinsicWidth()) * f);
        int v1 = (int)(((float)this.drawable.getIntrinsicHeight()) * f);
        this.drawable.setBounds(0, 0, v, v1);
        return this.drawable;
    }

    @Override  // android.text.style.DynamicDrawableSpan
    public int getSize(Paint paint0, CharSequence charSequence0, int v, int v1, Paint.FontMetricsInt paint$FontMetricsInt0) {
        Drawable drawable0 = this.getDrawable();
        if(drawable0 == null) {
            return 0;
        }
        Rect rect0 = drawable0.getBounds();
        if(paint$FontMetricsInt0 != null) {
            paint$FontMetricsInt0.ascent = -rect0.bottom;
            paint$FontMetricsInt0.descent = 0;
            paint$FontMetricsInt0.top = -rect0.bottom;
            paint$FontMetricsInt0.bottom = 0;
        }
        return rect0.right;
    }

    public boolean isAnimating() {
        return this.isAnimated;
    }

    @Override  // com.kakao.digitalitem.image.lib.AnimatedItemImageContainer
    public void playSoundIfSoundEmoticon() {
        if(this.playMethod != null && this.playMethod.canPlay()) {
            this.playMethod.play(this.soundPath);
        }
    }

    private void returnBitmap() {
        if(this.mutableBitmap != null) {
            BitmapPool.getInstance().returnBitmap(this.mutableBitmap);
            this.mutableBitmap = null;
            this.canvas = null;
            this.paint = null;
            this.clearPaint = null;
            this.isPrevDispose = false;
            this.disposeFrameHeight = 0;
            this.disposeFrameWidth = 0;
            this.disposeFrameOffsetX = 0;
            this.disposeFrameOffsetY = 0;
        }
    }

    @Override  // com.kakao.digitalitem.image.lib.AnimatedItemImageContainer
    public void setAnimatedImage(AnimatedItemImage animatedItemImage0) {
        this.stopLoadingDrawable();
        this.cancelAnimation();
        if(this.animatedImage != animatedItemImage0) {
            this.clearFrames();
            this.animatedImage = animatedItemImage0;
        }
        if(animatedItemImage0 == null) {
            this.setImageBitmap(null);
            return;
        }
        this.onPrepared = false;
        if(animatedItemImage0.hasAnimation()) {
            if(this.startAnimationWhenImageLoaded) {
                this.startAnimation();
                return;
            }
            this.clearFrames();
            this.setImageBitmapForAsynchronous(0, true);
            return;
        }
        this.setImageBitmapForAsynchronous(0, true);
    }

    public void setAnimatedImageSize(int v, int v1) {
        this.viewWidth = v;
        this.viewHeight = v1;
    }

    @Override  // com.kakao.digitalitem.image.lib.AnimatedItemImageContainer
    public void setAsyncTaskTagObject(Object object0) {
    }

    @Override  // com.kakao.digitalitem.image.lib.AnimatedItemImageContainer
    public void setBackgroundResource(int v) {
        try {
            this.drawable = c.getDrawable(this.context, v);
        }
        catch(Exception unused_ex) {
            this.drawable = new ColorDrawable(-1);
        }
    }

    private void setFirstFrameForCaptureOnUIThread() {
        try {
            if(this.animatedImage != null) {
                Bitmap bitmap0 = this.getBitmap(this.animatedImage.getFrame(0));
                if(bitmap0 != null) {
                    this.setImageBitmap(bitmap0);
                }
            }
        }
        catch(FrameDecodeException imageDecode$FrameDecodeException0) {
            imageDecode$FrameDecodeException0.printStackTrace();
        }
    }

    @Override  // com.kakao.digitalitem.image.lib.AnimatedItemImageContainer
    public void setImageBitmap(Bitmap bitmap0) {
        if(bitmap0 != null) {
            this.drawable = new BitmapDrawable(this.context.getResources(), bitmap0);
        }
        if(!this.onPrepared) {
            OnPreparedListener onPreparedListener0 = this.preparedListener;
            if(onPreparedListener0 != null) {
                this.onPrepared = true;
                onPreparedListener0.onPrepared();
            }
        }
    }

    private void setImageBitmapForAsynchronous(int v, boolean z) {
        com.kakao.digitalitem.image.lib.AnimatedItemImageSpan.2 animatedItemImageSpan$20 = new Runnable() {
            @Override
            public void run() {
                ImageFrame imageFrame0;
                if(AnimatedItemImageSpan.this.animatedImage != null) {
                    try {
                        imageFrame0 = AnimatedItemImageSpan.this.animatedImage.getFrame(v);
                    }
                    catch(FrameDecodeException unused_ex) {
                        AnimatedItemImageSpan.handler.post(new Runnable() {
                            @Override
                            public void run() {
                                AnimatedItemImageSpan.this.animatedImage = null;
                                AnimatedItemImageSpan.this.cancelAnimation();
                            }
                        });
                        imageFrame0 = null;
                    }
                    if(!Thread.interrupted() && imageFrame0 != null) {
                        AnimatedItemImageSpan.handler.post(new Runnable() {
                            @Override
                            public void run() {
                                Bitmap bitmap0 = AnimatedItemImageSpan.this.getBitmap(imageFrame0);
                                if(AnimatedItemImageSpan.this.onBitmapDownloadedListener != null && bitmap0 != null) {
                                    bitmap0 = AnimatedItemImageSpan.this.onBitmapDownloadedListener.onBitmapDownloaded(bitmap0);
                                }
                                if(bitmap0 != null) {
                                    AnimatedItemImageSpan.this.setImageBitmap(bitmap0);
                                }
                                if(AnimatedItemImageSpan.this.isAnimated && AnimatedItemImageSpan.this.animAction != null && AnimationRunnable.access$700(AnimatedItemImageSpan.this.animAction) == com.kakao.digitalitem.image.lib.AnimatedItemImageSpan.2.this.val$frameIndex) {
                                    int v = imageFrame0.getDuration() - ((int)(System.currentTimeMillis() - com.kakao.digitalitem.image.lib.AnimatedItemImageSpan.2.this.val$timeMillis));
                                    if(v <= 10) {
                                        v = 0;
                                    }
                                    AnimatedItemImageSpan.handler.postDelayed(AnimatedItemImageSpan.this.animAction, ((long)v));
                                }
                            }
                        });
                    }
                }
            }
        };
        Future future0 = AnimatedItemImageSpan.decodingExecutorService.submit(animatedItemImageSpan$20);
        Future future1 = (Future)AnimatedItemImageSpan.currentTask.put(this.hashCode(), future0);
        if(future1 != null) {
            future1.cancel(true);
        }
    }

    @Override  // com.kakao.digitalitem.image.lib.AnimatedItemImageContainer
    public void setImageDrawable(Drawable drawable0) {
        this.stopLoadingDrawable();
        this.drawable = drawable0;
        this.startLoadingDrawable();
    }

    private void setImageFrame(int v, int v1, int v2, int v3) {
        int v4;
        if(this.animatedImage != null) {
            if(v >= v1) {
                ++v2;
                v4 = 0;
            }
            else {
                v4 = v;
            }
            if(v2 < v3) {
                goto label_13;
            }
            this.isAnimated = false;
            this.setImageBitmapForAsynchronous((this.lastIndex ? v1 - 1 : 0), false);
            OnAnimationListener animatedItemImageView$OnAnimationListener0 = this.onAnimationListener;
            if(animatedItemImageView$OnAnimationListener0 != null) {
                animatedItemImageView$OnAnimationListener0.onAnimationEnd();
                return;
            label_13:
                this.animAction = new AnimationRunnable(v4) {
                    @Override
                    public void run() {
                        AnimatedItemImageSpan.this.setImageFrame(v4 + 1, v1, v2, v3);
                    }
                };
                if(v4 == 0 && v2 == 0) {
                    this.setFirstFrameForCaptureOnUIThread();
                }
                this.setImageBitmapForAsynchronous(v4, false);
            }
        }
    }

    public void setLastIndex(boolean z) {
        this.lastIndex = z;
    }

    public void setMinLoopCount(int v) {
        this.minLoopCount = v;
    }

    public void setNoAnimation(boolean z) {
        this.isNoAnimation = z;
    }

    public void setOnAnimationListener(OnAnimationListener animatedItemImageView$OnAnimationListener0) {
        this.onAnimationListener = animatedItemImageView$OnAnimationListener0;
    }

    public void setOnBitmapDownloadedListener(OnBitmapDownloadedListener animatedItemImageView$OnBitmapDownloadedListener0) {
        this.onBitmapDownloadedListener = animatedItemImageView$OnBitmapDownloadedListener0;
    }

    public void setOnIndexChangeListener(OnIndexChangeListener animatedItemImageView$OnIndexChangeListener0) {
        this.onIndexChangeListener = animatedItemImageView$OnIndexChangeListener0;
    }

    @Override  // com.kakao.digitalitem.image.lib.AnimatedItemImageContainer
    public void setOnPreparedListener(OnPreparedListener onPreparedListener0) {
        this.preparedListener = onPreparedListener0;
    }

    @Override  // com.kakao.digitalitem.image.lib.AnimatedItemImageContainer
    public void setPlayMethod(PlayMethod playMethod0) {
        this.playMethod = playMethod0;
    }

    @Override  // com.kakao.digitalitem.image.lib.AnimatedItemImageContainer
    public void setSoundPath(String s) {
        this.soundPath = s;
    }

    public void setStartAnimationWhenImageLoaded(boolean z) {
        this.startAnimationWhenImageLoaded = z;
    }

    @Override  // com.kakao.digitalitem.image.lib.AnimatedItemImageContainer
    public void startAnimation() {
        if(this.animatedImage != null && !this.isAnimated && this.animatedImage.hasAnimation()) {
            this.isAnimated = true;
            OnAnimationListener animatedItemImageView$OnAnimationListener0 = this.onAnimationListener;
            if(animatedItemImageView$OnAnimationListener0 != null) {
                animatedItemImageView$OnAnimationListener0.onAnimationStart();
            }
            int v = Math.max(this.minLoopCount, this.animatedImage.getLoopCount());
            int v1 = this.animatedImage.getFrameCount();
            if(this.isNoAnimation) {
                v = 0;
            }
            this.setImageFrame(0, v1, 0, v);
        }
    }

    private void startLoadingDrawable() {
        Drawable drawable0 = this.getDrawable();
        if(drawable0 instanceof AnimationDrawable) {
            ((AnimationDrawable)drawable0).start();
        }
    }

    @Override  // com.kakao.digitalitem.image.lib.AnimatedItemImageContainer
    public void stopAnimation() {
        this.cancelAnimation();
        this.setImageBitmapForAsynchronous(0, false);
    }

    public void stopLoadingDrawable() {
        Drawable drawable0 = this.getDrawable();
        if(drawable0 instanceof AnimationDrawable) {
            ((AnimationDrawable)drawable0).stop();
            this.setImageDrawable(null);
        }
    }

    public void stopSoundEmoticon() {
        PlayMethod playMethod0 = this.playMethod;
        if(playMethod0 != null) {
            playMethod0.stop();
        }
    }
}

