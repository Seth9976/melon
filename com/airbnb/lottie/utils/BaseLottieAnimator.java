package com.airbnb.lottie.utils;

import android.animation.Animator.AnimatorListener;
import android.animation.Animator.AnimatorPauseListener;
import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.animation.ValueAnimator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public abstract class BaseLottieAnimator extends ValueAnimator {
    private final Set listeners;
    private final Set pauseListeners;
    private final Set updateListeners;

    public BaseLottieAnimator() {
        this.updateListeners = new CopyOnWriteArraySet();
        this.listeners = new CopyOnWriteArraySet();
        this.pauseListeners = new CopyOnWriteArraySet();
    }

    @Override  // android.animation.Animator
    public void addListener(Animator.AnimatorListener animator$AnimatorListener0) {
        this.listeners.add(animator$AnimatorListener0);
    }

    @Override  // android.animation.Animator
    public void addPauseListener(Animator.AnimatorPauseListener animator$AnimatorPauseListener0) {
        this.pauseListeners.add(animator$AnimatorPauseListener0);
    }

    @Override  // android.animation.ValueAnimator
    public void addUpdateListener(ValueAnimator.AnimatorUpdateListener valueAnimator$AnimatorUpdateListener0) {
        this.updateListeners.add(valueAnimator$AnimatorUpdateListener0);
    }

    @Override  // android.animation.ValueAnimator
    public long getStartDelay() {
        throw new UnsupportedOperationException("LottieAnimator does not support getStartDelay.");
    }

    public void notifyCancel() {
        for(Object object0: this.listeners) {
            ((Animator.AnimatorListener)object0).onAnimationCancel(this);
        }
    }

    public void notifyEnd(boolean z) {
        for(Object object0: this.listeners) {
            ((Animator.AnimatorListener)object0).onAnimationEnd(this, z);
        }
    }

    public void notifyPause() {
        for(Object object0: this.pauseListeners) {
            ((Animator.AnimatorPauseListener)object0).onAnimationPause(this);
        }
    }

    public void notifyRepeat() {
        for(Object object0: this.listeners) {
            ((Animator.AnimatorListener)object0).onAnimationRepeat(this);
        }
    }

    public void notifyResume() {
        for(Object object0: this.pauseListeners) {
            ((Animator.AnimatorPauseListener)object0).onAnimationResume(this);
        }
    }

    public void notifyStart(boolean z) {
        for(Object object0: this.listeners) {
            ((Animator.AnimatorListener)object0).onAnimationStart(this, z);
        }
    }

    public void notifyUpdate() {
        for(Object object0: this.updateListeners) {
            ((ValueAnimator.AnimatorUpdateListener)object0).onAnimationUpdate(this);
        }
    }

    @Override  // android.animation.Animator
    public void removeAllListeners() {
        this.listeners.clear();
    }

    @Override  // android.animation.ValueAnimator
    public void removeAllUpdateListeners() {
        this.updateListeners.clear();
    }

    @Override  // android.animation.Animator
    public void removeListener(Animator.AnimatorListener animator$AnimatorListener0) {
        this.listeners.remove(animator$AnimatorListener0);
    }

    @Override  // android.animation.Animator
    public void removePauseListener(Animator.AnimatorPauseListener animator$AnimatorPauseListener0) {
        this.pauseListeners.remove(animator$AnimatorPauseListener0);
    }

    @Override  // android.animation.ValueAnimator
    public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener valueAnimator$AnimatorUpdateListener0) {
        this.updateListeners.remove(valueAnimator$AnimatorUpdateListener0);
    }

    @Override  // android.animation.ValueAnimator
    public Animator setDuration(long v) {
        return this.setDuration(v);
    }

    @Override  // android.animation.ValueAnimator
    public ValueAnimator setDuration(long v) {
        throw new UnsupportedOperationException("LottieAnimator does not support setDuration.");
    }

    @Override  // android.animation.ValueAnimator
    public void setInterpolator(TimeInterpolator timeInterpolator0) {
        throw new UnsupportedOperationException("LottieAnimator does not support setInterpolator.");
    }

    @Override  // android.animation.ValueAnimator
    public void setStartDelay(long v) {
        throw new UnsupportedOperationException("LottieAnimator does not support setStartDelay.");
    }
}

