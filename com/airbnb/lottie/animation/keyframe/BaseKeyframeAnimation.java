package com.airbnb.lottie.animation.keyframe;

import android.annotation.SuppressLint;
import b3.Z;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseKeyframeAnimation {
    public interface AnimationListener {
        void onValueChanged();
    }

    static final class EmptyKeyframeWrapper implements KeyframesWrapper {
        private EmptyKeyframeWrapper() {
        }

        public EmptyKeyframeWrapper(com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.1 baseKeyframeAnimation$10) {
        }

        @Override  // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation$KeyframesWrapper
        public Keyframe getCurrentKeyframe() {
            throw new IllegalStateException("not implemented");
        }

        @Override  // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation$KeyframesWrapper
        public float getEndProgress() {
            return 1.0f;
        }

        @Override  // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation$KeyframesWrapper
        public float getStartDelayProgress() {
            return 0.0f;
        }

        @Override  // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation$KeyframesWrapper
        public boolean isCachedValueEnabled(float f) {
            throw new IllegalStateException("not implemented");
        }

        @Override  // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation$KeyframesWrapper
        public boolean isEmpty() {
            return true;
        }

        @Override  // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation$KeyframesWrapper
        public boolean isValueChanged(float f) {
            return false;
        }
    }

    interface KeyframesWrapper {
        Keyframe getCurrentKeyframe();

        float getEndProgress();

        float getStartDelayProgress();

        boolean isCachedValueEnabled(float arg1);

        boolean isEmpty();

        boolean isValueChanged(float arg1);
    }

    static final class KeyframesWrapperImpl implements KeyframesWrapper {
        private Keyframe cachedCurrentKeyframe;
        private float cachedInterpolatedProgress;
        private Keyframe currentKeyframe;
        private final List keyframes;

        public KeyframesWrapperImpl(List list0) {
            this.cachedCurrentKeyframe = null;
            this.cachedInterpolatedProgress = -1.0f;
            this.keyframes = list0;
            this.currentKeyframe = this.findKeyframe(0.0f);
        }

        private Keyframe findKeyframe(float f) {
            Keyframe keyframe0 = (Keyframe)Z.h(1, this.keyframes);
            if(f >= keyframe0.getStartProgress()) {
                return keyframe0;
            }
            for(int v = this.keyframes.size() - 2; v >= 1; --v) {
                Keyframe keyframe1 = (Keyframe)this.keyframes.get(v);
                if(this.currentKeyframe != keyframe1 && keyframe1.containsProgress(f)) {
                    return keyframe1;
                }
            }
            return (Keyframe)this.keyframes.get(0);
        }

        @Override  // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation$KeyframesWrapper
        public Keyframe getCurrentKeyframe() {
            return this.currentKeyframe;
        }

        @Override  // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation$KeyframesWrapper
        public float getEndProgress() {
            return ((Keyframe)Z.h(1, this.keyframes)).getEndProgress();
        }

        @Override  // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation$KeyframesWrapper
        public float getStartDelayProgress() {
            return ((Keyframe)this.keyframes.get(0)).getStartProgress();
        }

        @Override  // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation$KeyframesWrapper
        public boolean isCachedValueEnabled(float f) {
            Keyframe keyframe0 = this.currentKeyframe;
            if(this.cachedCurrentKeyframe == keyframe0 && this.cachedInterpolatedProgress == f) {
                return true;
            }
            this.cachedCurrentKeyframe = keyframe0;
            this.cachedInterpolatedProgress = f;
            return false;
        }

        @Override  // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation$KeyframesWrapper
        public boolean isEmpty() {
            return false;
        }

        @Override  // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation$KeyframesWrapper
        public boolean isValueChanged(float f) {
            if(this.currentKeyframe.containsProgress(f)) {
                return !this.currentKeyframe.isStatic();
            }
            this.currentKeyframe = this.findKeyframe(f);
            return true;
        }
    }

    static final class SingleKeyframeWrapper implements KeyframesWrapper {
        private float cachedInterpolatedProgress;
        private final Keyframe keyframe;

        public SingleKeyframeWrapper(List list0) {
            this.cachedInterpolatedProgress = -1.0f;
            this.keyframe = (Keyframe)list0.get(0);
        }

        @Override  // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation$KeyframesWrapper
        public Keyframe getCurrentKeyframe() {
            return this.keyframe;
        }

        @Override  // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation$KeyframesWrapper
        public float getEndProgress() {
            return this.keyframe.getEndProgress();
        }

        @Override  // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation$KeyframesWrapper
        public float getStartDelayProgress() {
            return this.keyframe.getStartProgress();
        }

        @Override  // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation$KeyframesWrapper
        public boolean isCachedValueEnabled(float f) {
            if(this.cachedInterpolatedProgress == f) {
                return true;
            }
            this.cachedInterpolatedProgress = f;
            return false;
        }

        @Override  // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation$KeyframesWrapper
        public boolean isEmpty() {
            return false;
        }

        @Override  // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation$KeyframesWrapper
        public boolean isValueChanged(float f) {
            return !this.keyframe.isStatic();
        }
    }

    private float cachedEndProgress;
    private Object cachedGetValue;
    private float cachedStartDelayProgress;
    private boolean isDiscrete;
    private final KeyframesWrapper keyframesWrapper;
    final List listeners;
    protected float progress;
    protected LottieValueCallback valueCallback;

    public BaseKeyframeAnimation(List list0) {
        this.listeners = new ArrayList(1);
        this.isDiscrete = false;
        this.progress = 0.0f;
        this.cachedGetValue = null;
        this.cachedStartDelayProgress = -1.0f;
        this.cachedEndProgress = -1.0f;
        this.keyframesWrapper = BaseKeyframeAnimation.wrap(list0);
    }

    public void addUpdateListener(AnimationListener baseKeyframeAnimation$AnimationListener0) {
        this.listeners.add(baseKeyframeAnimation$AnimationListener0);
    }

    // 去混淆评级： 中等(60)
    public Keyframe getCurrentKeyframe() {
        return this.keyframesWrapper.getCurrentKeyframe();
    }

    @SuppressLint({"Range"})
    public float getEndProgress() {
        if(this.cachedEndProgress == -1.0f) {
            this.cachedEndProgress = this.keyframesWrapper.getEndProgress();
        }
        return this.cachedEndProgress;
    }

    public float getInterpolatedCurrentKeyframeProgress() {
        Keyframe keyframe0 = this.getCurrentKeyframe();
        if(keyframe0 != null && !keyframe0.isStatic()) {
            return keyframe0.interpolator == null ? 0.0f : keyframe0.interpolator.getInterpolation(this.getLinearCurrentKeyframeProgress());
        }
        return 0.0f;
    }

    public float getLinearCurrentKeyframeProgress() {
        if(this.isDiscrete) {
            return 0.0f;
        }
        Keyframe keyframe0 = this.getCurrentKeyframe();
        return keyframe0.isStatic() ? 0.0f : (this.progress - keyframe0.getStartProgress()) / (keyframe0.getEndProgress() - keyframe0.getStartProgress());
    }

    public float getProgress() {
        return this.progress;
    }

    @SuppressLint({"Range"})
    private float getStartDelayProgress() {
        if(this.cachedStartDelayProgress == -1.0f) {
            this.cachedStartDelayProgress = this.keyframesWrapper.getStartDelayProgress();
        }
        return this.cachedStartDelayProgress;
    }

    public Object getValue() {
        float f = this.getLinearCurrentKeyframeProgress();
        if(this.valueCallback == null && this.keyframesWrapper.isCachedValueEnabled(f) && !this.skipCache()) {
            return this.cachedGetValue;
        }
        Keyframe keyframe0 = this.getCurrentKeyframe();
        Object object0 = keyframe0.xInterpolator == null || keyframe0.yInterpolator == null ? this.getValue(keyframe0, this.getInterpolatedCurrentKeyframeProgress()) : this.getValue(keyframe0, f, keyframe0.xInterpolator.getInterpolation(f), keyframe0.yInterpolator.getInterpolation(f));
        this.cachedGetValue = object0;
        return object0;
    }

    public abstract Object getValue(Keyframe arg1, float arg2);

    public Object getValue(Keyframe keyframe0, float f, float f1, float f2) {
        throw new UnsupportedOperationException("This animation does not support split dimensions!");
    }

    public boolean hasValueCallback() {
        return this.valueCallback != null;
    }

    public void notifyListeners() {
        for(int v = 0; v < this.listeners.size(); ++v) {
            ((AnimationListener)this.listeners.get(v)).onValueChanged();
        }
    }

    public void setIsDiscrete() {
        this.isDiscrete = true;
    }

    public void setProgress(float f) {
        if(!this.keyframesWrapper.isEmpty()) {
            if(f < this.getStartDelayProgress()) {
                f = this.getStartDelayProgress();
            }
            else if(f > this.getEndProgress()) {
                f = this.getEndProgress();
            }
            if(f != this.progress) {
                this.progress = f;
                if(this.keyframesWrapper.isValueChanged(f)) {
                    this.notifyListeners();
                }
            }
        }
    }

    public void setValueCallback(LottieValueCallback lottieValueCallback0) {
        LottieValueCallback lottieValueCallback1 = this.valueCallback;
        if(lottieValueCallback1 != null) {
            lottieValueCallback1.setAnimation(null);
        }
        this.valueCallback = lottieValueCallback0;
        if(lottieValueCallback0 != null) {
            lottieValueCallback0.setAnimation(this);
        }
    }

    public boolean skipCache() {
        return false;
    }

    private static KeyframesWrapper wrap(List list0) {
        if(list0.isEmpty()) {
            return new EmptyKeyframeWrapper(null);
        }
        return list0.size() == 1 ? new SingleKeyframeWrapper(list0) : new KeyframesWrapperImpl(list0);
    }

    class com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.1 {
    }

}

