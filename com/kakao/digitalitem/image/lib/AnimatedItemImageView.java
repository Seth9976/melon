package com.kakao.digitalitem.image.lib;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.ImageView.ScaleType;
import android.widget.ImageView;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AnimatedItemImageView extends ImageView implements AnimatedItemImageContainer {
    static abstract class AnimationRunnable implements Runnable {
        private final int frameIndex;

        public AnimationRunnable(int v) {
            this.frameIndex = v;
        }

        public static int access$700(AnimationRunnable animatedItemImageView$AnimationRunnable0) {
            return animatedItemImageView$AnimationRunnable0.frameIndex;
        }
    }

    public interface OnAnimationListener {
        void onAnimationEnd();

        void onAnimationStart();
    }

    public interface OnBitmapDownloadedListener {
        Bitmap onBitmapDownloaded(Bitmap arg1);
    }

    public interface OnIndexChangeListener {
        void onIndexChange(AnimatedItemImageContainer arg1, int arg2);
    }

    private static final int IMAGE_DISPOSE_BACKGROUND = 1;
    private static final int MIN_LOOP_COUNT = 4;
    private static final int WEBP_MUX_NO_BLEND = 1;
    private AnimationRunnable animAction;
    private volatile AnimatedItemImage animatedImage;
    private Object asyncTaskTagObject;
    private Canvas canvas;
    private Paint clearPaint;
    @SuppressLint({"UseSparseArrays"})
    private static final Map currentTask;
    private static final ExecutorService decodingExecutorService;
    private int disposeFrameHeight;
    private int disposeFrameOffsetX;
    private int disposeFrameOffsetY;
    private int disposeFrameWidth;
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
    private Paint paint;
    private PlayMethod playMethod;
    private String soundPath;
    private boolean startAnimationWhenImageLoaded;
    private int viewHeight;
    private int viewWidth;

    static {
        AnimatedItemImageView.decodingExecutorService = Executors.newFixedThreadPool(3);
        AnimatedItemImageView.handler = new Handler(Looper.getMainLooper());
        AnimatedItemImageView.currentTask = new HashMap();
    }

    public AnimatedItemImageView(Context context0) {
        super(context0);
        this.minLoopCount = 4;
        this.lastIndex = true;
        this.startAnimationWhenImageLoaded = true;
    }

    public AnimatedItemImageView(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.minLoopCount = 4;
        this.lastIndex = true;
        this.startAnimationWhenImageLoaded = true;
    }

    public AnimatedItemImageView(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.minLoopCount = 4;
        this.lastIndex = true;
        this.startAnimationWhenImageLoaded = true;
    }

    public void cancelAnimation() {
        AnimationRunnable animatedItemImageView$AnimationRunnable0 = this.animAction;
        if(animatedItemImageView$AnimationRunnable0 != null) {
            AnimatedItemImageView.handler.removeCallbacks(animatedItemImageView$AnimationRunnable0);
            this.animAction = null;
        }
        Future future0 = (Future)AnimatedItemImageView.currentTask.remove(this.hashCode());
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
        return this.asyncTaskTagObject;
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

    public boolean isAnimating() {
        return this.isAnimated;
    }

    @Override  // android.widget.ImageView
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.clearView();
    }

    @Override  // com.kakao.digitalitem.image.lib.AnimatedItemImageContainer
    public void playSoundIfSoundEmoticon() {
        if(this.playMethod != null && this.playMethod.canPlay()) {
            this.playMethod.play(this.soundPath);
        }
    }

    public void restoreImageIfNeed() {
        if(this.animatedImage != null && !this.isAnimated) {
            this.setAnimatedImage(this.animatedImage);
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
        if(animatedItemImage0.hasAnimation()) {
            if(this.startAnimationWhenImageLoaded) {
                this.startAnimation();
                return;
            }
            this.clearFrames();
            this.setImageBitmapForAsynchronous(0);
            return;
        }
        this.setImageBitmapForAsynchronous(0);
    }

    public void setAnimatedImageSize(int v, int v1) {
        this.viewWidth = v;
        this.viewHeight = v1;
    }

    @Override  // com.kakao.digitalitem.image.lib.AnimatedItemImageContainer
    public void setAsyncTaskTagObject(Object object0) {
        this.asyncTaskTagObject = object0;
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

    private void setImageBitmapForAsynchronous(int v) {
        com.kakao.digitalitem.image.lib.AnimatedItemImageView.2 animatedItemImageView$20 = new Runnable() {
            @Override
            public void run() {
                ImageFrame imageFrame0;
                if(AnimatedItemImageView.this.animatedImage != null) {
                    try {
                        imageFrame0 = AnimatedItemImageView.this.animatedImage.getFrame(v);
                    }
                    catch(FrameDecodeException unused_ex) {
                        AnimatedItemImageView.handler.post(new Runnable() {
                            @Override
                            public void run() {
                                AnimatedItemImageView.this.animatedImage = null;
                                AnimatedItemImageView.this.cancelAnimation();
                            }
                        });
                        imageFrame0 = null;
                    }
                    if(!Thread.interrupted() && imageFrame0 != null) {
                        AnimatedItemImageView.handler.post(new Runnable() {
                            @Override
                            public void run() {
                                Bitmap bitmap0 = AnimatedItemImageView.this.getBitmap(imageFrame0);
                                if(AnimatedItemImageView.this.onBitmapDownloadedListener != null && bitmap0 != null) {
                                    bitmap0 = AnimatedItemImageView.this.onBitmapDownloadedListener.onBitmapDownloaded(bitmap0);
                                }
                                if(bitmap0 != null) {
                                    AnimatedItemImageView.this.setImageBitmap(bitmap0);
                                }
                                if(AnimatedItemImageView.this.isAnimated && AnimatedItemImageView.this.animAction != null && AnimationRunnable.access$700(AnimatedItemImageView.this.animAction) == com.kakao.digitalitem.image.lib.AnimatedItemImageView.2.this.val$frameIndex) {
                                    int v = imageFrame0.getDuration() - ((int)(System.currentTimeMillis() - com.kakao.digitalitem.image.lib.AnimatedItemImageView.2.this.val$timeMillis));
                                    if(v <= 10) {
                                        v = 0;
                                    }
                                    AnimatedItemImageView.handler.postDelayed(AnimatedItemImageView.this.animAction, ((long)v));
                                }
                            }
                        });
                    }
                }
            }
        };
        Future future0 = AnimatedItemImageView.decodingExecutorService.submit(animatedItemImageView$20);
        Future future1 = (Future)AnimatedItemImageView.currentTask.put(this.hashCode(), future0);
        if(future1 != null) {
            future1.cancel(true);
        }
    }

    @Override  // android.widget.ImageView, com.kakao.digitalitem.image.lib.AnimatedItemImageContainer
    public void setImageDrawable(Drawable drawable0) {
        this.stopLoadingDrawable();
        super.setImageDrawable(drawable0);
        this.startLoadingDrawable();
    }

    private void setImageFrame(int v, int v1, int v2, int v3) {
        int v5;
        int v4 = 0;
        if(this.animatedImage != null) {
            if(v >= v1) {
                ++v2;
                v5 = 0;
            }
            else {
                v5 = v;
            }
            if(v2 < v3) {
                goto label_16;
            }
            this.isAnimated = false;
            if(this.lastIndex) {
                v4 = v1 - 1;
            }
            this.setImageBitmapForAsynchronous(v4);
            OnAnimationListener animatedItemImageView$OnAnimationListener0 = this.onAnimationListener;
            if(animatedItemImageView$OnAnimationListener0 != null) {
                animatedItemImageView$OnAnimationListener0.onAnimationEnd();
                return;
            label_16:
                this.animAction = new AnimationRunnable(v5) {
                    @Override
                    public void run() {
                        AnimatedItemImageView.this.setImageFrame(v5 + 1, v1, v2, v3);
                    }
                };
                if(v5 == 0 && v2 == 0) {
                    this.setFirstFrameForCaptureOnUIThread();
                }
                this.setImageBitmapForAsynchronous(v5);
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

    @Override  // android.widget.ImageView
    public void setVisibility(int v) {
        super.setVisibility(v);
        if(v != 0) {
            this.stopLoadingDrawable();
            this.cancelAnimation();
        }
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
            this.setScaleType(ImageView.ScaleType.CENTER);
            ((AnimationDrawable)drawable0).start();
        }
    }

    @Override  // com.kakao.digitalitem.image.lib.AnimatedItemImageContainer
    public void stopAnimation() {
        this.cancelAnimation();
        this.setImageBitmapForAsynchronous(0);
    }

    public void stopLoadingDrawable() {
        Drawable drawable0 = this.getDrawable();
        if(drawable0 instanceof AnimationDrawable) {
            this.setScaleType(ImageView.ScaleType.FIT_CENTER);
            ((AnimationDrawable)drawable0).stop();
            super.setImageDrawable(null);
        }
    }

    public void stopSoundEmoticon() {
        PlayMethod playMethod0 = this.playMethod;
        if(playMethod0 != null) {
            playMethod0.stop();
        }
    }
}

