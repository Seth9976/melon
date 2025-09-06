package com.airbnb.lottie.utils;

import android.view.Choreographer.FrameCallback;
import android.view.Choreographer;
import com.airbnb.lottie.LottieComposition;

public class LottieValueAnimator extends BaseLottieAnimator implements Choreographer.FrameCallback {
    private LottieComposition composition;
    private float frame;
    private float frameRaw;
    private long lastFrameTimeNs;
    private float maxFrame;
    private float minFrame;
    private int repeatCount;
    protected boolean running;
    private float speed;
    private boolean speedReversedForRepeatMode;
    private boolean useCompositionFrameRate;

    public LottieValueAnimator() {
        this.speed = 1.0f;
        this.speedReversedForRepeatMode = false;
        this.lastFrameTimeNs = 0L;
        this.frameRaw = 0.0f;
        this.frame = 0.0f;
        this.repeatCount = 0;
        this.minFrame = -2147483648.0f;
        this.maxFrame = 2147483648.0f;
        this.running = false;
        this.useCompositionFrameRate = false;
    }

    @Override  // android.animation.ValueAnimator
    public void cancel() {
        this.notifyCancel();
        this.removeFrameCallback();
    }

    private void checkNotifyUpdate(float f) {
        if(this.useCompositionFrameRate && this.frameRaw == f) {
            return;
        }
        this.notifyUpdate();
    }

    public void clearComposition() {
        this.composition = null;
        this.minFrame = -2147483648.0f;
        this.maxFrame = 2147483648.0f;
    }

    @Override  // android.view.Choreographer$FrameCallback
    public void doFrame(long v) {
        this.postFrameCallback();
        if(this.composition != null && this.isRunning()) {
            float f = ((float)(this.lastFrameTimeNs == 0L ? 0L : v - this.lastFrameTimeNs)) / this.getFrameDurationNs();
            float f1 = this.frameRaw;
            if(this.isReversed()) {
                f = -f;
            }
            float f2 = f1 + f;
            boolean z = MiscUtils.contains(f2, this.getMinFrame(), this.getMaxFrame());
            float f3 = this.frameRaw;
            float f4 = MiscUtils.clamp(f2, this.getMinFrame(), this.getMaxFrame());
            this.frameRaw = f4;
            if(this.useCompositionFrameRate) {
                f4 = (float)Math.floor(f4);
            }
            this.frame = f4;
            this.lastFrameTimeNs = v;
            if(z) {
                this.checkNotifyUpdate(f3);
            }
            else if(this.getRepeatCount() != -1 && this.repeatCount >= this.getRepeatCount()) {
                float f5 = this.speed < 0.0f ? this.getMinFrame() : this.getMaxFrame();
                this.frameRaw = f5;
                this.frame = f5;
                this.removeFrameCallback();
                this.checkNotifyUpdate(f3);
                this.notifyEnd(this.isReversed());
            }
            else {
                if(this.getRepeatMode() == 2) {
                    this.speedReversedForRepeatMode = !this.speedReversedForRepeatMode;
                    this.reverseAnimationSpeed();
                }
                else {
                    float f6 = this.isReversed() ? this.getMaxFrame() : this.getMinFrame();
                    this.frameRaw = f6;
                    this.frame = f6;
                }
                this.lastFrameTimeNs = v;
                this.checkNotifyUpdate(f3);
                this.notifyRepeat();
                ++this.repeatCount;
            }
            this.verifyFrame();
        }
    }

    public void endAnimation() {
        this.removeFrameCallback();
        this.notifyEnd(this.isReversed());
    }

    @Override  // android.animation.ValueAnimator
    public float getAnimatedFraction() {
        if(this.composition == null) {
            return 0.0f;
        }
        return this.isReversed() ? (this.getMaxFrame() - this.frame) / (this.getMaxFrame() - this.getMinFrame()) : (this.frame - this.getMinFrame()) / (this.getMaxFrame() - this.getMinFrame());
    }

    @Override  // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        return this.getAnimatedValueAbsolute();
    }

    public float getAnimatedValueAbsolute() {
        return this.composition == null ? 0.0f : (this.frame - this.composition.getStartFrame()) / (this.composition.getEndFrame() - this.composition.getStartFrame());
    }

    @Override  // android.animation.ValueAnimator
    public long getDuration() {
        return this.composition == null ? 0L : ((long)this.composition.getDuration());
    }

    public float getFrame() {
        return this.frame;
    }

    private float getFrameDurationNs() {
        return this.composition == null ? 3.402823E+38f : 1000000000.0f / this.composition.getFrameRate() / Math.abs(this.speed);
    }

    public float getMaxFrame() {
        LottieComposition lottieComposition0 = this.composition;
        if(lottieComposition0 == null) {
            return 0.0f;
        }
        return this.maxFrame == 2147483648.0f ? lottieComposition0.getEndFrame() : this.maxFrame;
    }

    public float getMinFrame() {
        LottieComposition lottieComposition0 = this.composition;
        if(lottieComposition0 == null) {
            return 0.0f;
        }
        return this.minFrame == -2147483648.0f ? lottieComposition0.getStartFrame() : this.minFrame;
    }

    public float getSpeed() {
        return this.speed;
    }

    private boolean isReversed() {
        return this.getSpeed() < 0.0f;
    }

    @Override  // android.animation.ValueAnimator
    public boolean isRunning() {
        return this.running;
    }

    @Override  // com.airbnb.lottie.utils.BaseLottieAnimator
    public void notifyCancel() {
        super.notifyCancel();
        this.notifyEnd(this.isReversed());
    }

    public void pauseAnimation() {
        this.removeFrameCallback();
        this.notifyPause();
    }

    public void playAnimation() {
        this.running = true;
        this.notifyStart(this.isReversed());
        this.setFrame(((float)(((int)(this.isReversed() ? this.getMaxFrame() : this.getMinFrame())))));
        this.lastFrameTimeNs = 0L;
        this.repeatCount = 0;
        this.postFrameCallback();
    }

    public void postFrameCallback() {
        if(this.isRunning()) {
            this.removeFrameCallback(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    public void removeFrameCallback() {
        this.removeFrameCallback(true);
    }

    public void removeFrameCallback(boolean z) {
        Choreographer.getInstance().removeFrameCallback(this);
        if(z) {
            this.running = false;
        }
    }

    public void resumeAnimation() {
        this.running = true;
        this.postFrameCallback();
        this.lastFrameTimeNs = 0L;
        if(this.isReversed() && this.getFrame() == this.getMinFrame()) {
            this.setFrame(this.getMaxFrame());
        }
        else if(!this.isReversed() && this.getFrame() == this.getMaxFrame()) {
            this.setFrame(this.getMinFrame());
        }
        this.notifyResume();
    }

    public void reverseAnimationSpeed() {
        this.setSpeed(-this.getSpeed());
    }

    public void setComposition(LottieComposition lottieComposition0) {
        boolean z = this.composition == null;
        this.composition = lottieComposition0;
        if(z) {
            this.setMinAndMaxFrames(Math.max(this.minFrame, lottieComposition0.getStartFrame()), Math.min(this.maxFrame, lottieComposition0.getEndFrame()));
        }
        else {
            this.setMinAndMaxFrames(((float)(((int)lottieComposition0.getStartFrame()))), ((float)(((int)lottieComposition0.getEndFrame()))));
        }
        float f = this.frame;
        this.frame = 0.0f;
        this.frameRaw = 0.0f;
        this.setFrame(((float)(((int)f))));
        this.notifyUpdate();
    }

    public void setFrame(float f) {
        if(this.frameRaw == f) {
            return;
        }
        float f1 = MiscUtils.clamp(f, this.getMinFrame(), this.getMaxFrame());
        this.frameRaw = f1;
        if(this.useCompositionFrameRate) {
            f1 = (float)Math.floor(f1);
        }
        this.frame = f1;
        this.lastFrameTimeNs = 0L;
        this.notifyUpdate();
    }

    public void setMaxFrame(float f) {
        this.setMinAndMaxFrames(this.minFrame, f);
    }

    public void setMinAndMaxFrames(float f, float f1) {
        if(f > f1) {
            throw new IllegalArgumentException("minFrame (" + f + ") must be <= maxFrame (" + f1 + ")");
        }
        float f2 = this.composition == null ? -3.402823E+38f : this.composition.getStartFrame();
        float f3 = this.composition == null ? 3.402823E+38f : this.composition.getEndFrame();
        float f4 = MiscUtils.clamp(f, f2, f3);
        float f5 = MiscUtils.clamp(f1, f2, f3);
        if(f4 == this.minFrame && f5 == this.maxFrame) {
            return;
        }
        this.minFrame = f4;
        this.maxFrame = f5;
        this.setFrame(((float)(((int)MiscUtils.clamp(this.frame, f4, f5)))));
    }

    public void setMinFrame(int v) {
        this.setMinAndMaxFrames(((float)v), ((float)(((int)this.maxFrame))));
    }

    @Override  // android.animation.ValueAnimator
    public void setRepeatMode(int v) {
        super.setRepeatMode(v);
        if(v != 2 && this.speedReversedForRepeatMode) {
            this.speedReversedForRepeatMode = false;
            this.reverseAnimationSpeed();
        }
    }

    public void setSpeed(float f) {
        this.speed = f;
    }

    public void setUseCompositionFrameRate(boolean z) {
        this.useCompositionFrameRate = z;
    }

    private void verifyFrame() {
        if(this.composition != null && (this.frame < this.minFrame || this.frame > this.maxFrame)) {
            throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", this.minFrame, this.maxFrame, this.frame));
        }
    }
}

