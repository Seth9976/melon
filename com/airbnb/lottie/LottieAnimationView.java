package com.airbnb.lottie;

import android.animation.Animator.AnimatorListener;
import android.animation.Animator.AnimatorPauseListener;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View.BaseSavedState;
import androidx.appcompat.widget.AppCompatImageView;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.LottieValueCallback;
import com.airbnb.lottie.value.SimpleLottieValueCallback;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipInputStream;

public class LottieAnimationView extends AppCompatImageView {
    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator CREATOR;
        String animationName;
        int animationResId;
        String imageAssetsFolder;
        boolean isAnimating;
        float progress;
        int repeatCount;
        int repeatMode;

        static {
            SavedState.CREATOR = new Parcelable.Creator() {
                public SavedState createFromParcel(Parcel parcel0) {
                    return new SavedState(parcel0, null);
                }

                @Override  // android.os.Parcelable$Creator
                public Object createFromParcel(Parcel parcel0) {
                    return this.createFromParcel(parcel0);
                }

                public SavedState[] newArray(int v) {
                    return new SavedState[v];
                }

                @Override  // android.os.Parcelable$Creator
                public Object[] newArray(int v) {
                    return this.newArray(v);
                }
            };
        }

        private SavedState(Parcel parcel0) {
            super(parcel0);
            this.animationName = parcel0.readString();
            this.progress = parcel0.readFloat();
            this.isAnimating = parcel0.readInt() == 1;
            this.imageAssetsFolder = parcel0.readString();
            this.repeatMode = parcel0.readInt();
            this.repeatCount = parcel0.readInt();
        }

        public SavedState(Parcel parcel0, com.airbnb.lottie.LottieAnimationView.1 lottieAnimationView$10) {
            this(parcel0);
        }

        public SavedState(Parcelable parcelable0) {
            super(parcelable0);
        }

        @Override  // android.view.View$BaseSavedState
        public void writeToParcel(Parcel parcel0, int v) {
            super.writeToParcel(parcel0, v);
            parcel0.writeString(this.animationName);
            parcel0.writeFloat(this.progress);
            parcel0.writeInt(((int)this.isAnimating));
            parcel0.writeString(this.imageAssetsFolder);
            parcel0.writeInt(this.repeatMode);
            parcel0.writeInt(this.repeatCount);
        }
    }

    static enum UserActionTaken {
        SET_ANIMATION,
        SET_PROGRESS,
        SET_REPEAT_MODE,
        SET_REPEAT_COUNT,
        SET_IMAGE_ASSETS,
        PLAY_OPTION;

        private static UserActionTaken[] $values() [...] // Inlined contents
    }

    static class WeakFailureListener implements LottieListener {
        private final WeakReference targetReference;

        public WeakFailureListener(LottieAnimationView lottieAnimationView0) {
            this.targetReference = new WeakReference(lottieAnimationView0);
        }

        @Override  // com.airbnb.lottie.LottieListener
        public void onResult(Object object0) {
            this.onResult(((Throwable)object0));
        }

        public void onResult(Throwable throwable0) {
            LottieAnimationView lottieAnimationView0 = (LottieAnimationView)this.targetReference.get();
            if(lottieAnimationView0 == null) {
                return;
            }
            if(lottieAnimationView0.fallbackResource != 0) {
                lottieAnimationView0.setImageResource(lottieAnimationView0.fallbackResource);
            }
            (lottieAnimationView0.failureListener == null ? LottieAnimationView.DEFAULT_FAILURE_LISTENER : lottieAnimationView0.failureListener).onResult(throwable0);
        }
    }

    static class WeakSuccessListener implements LottieListener {
        private final WeakReference targetReference;

        public WeakSuccessListener(LottieAnimationView lottieAnimationView0) {
            this.targetReference = new WeakReference(lottieAnimationView0);
        }

        public void onResult(LottieComposition lottieComposition0) {
            LottieAnimationView lottieAnimationView0 = (LottieAnimationView)this.targetReference.get();
            if(lottieAnimationView0 == null) {
                return;
            }
            lottieAnimationView0.setComposition(lottieComposition0);
        }

        @Override  // com.airbnb.lottie.LottieListener
        public void onResult(Object object0) {
            this.onResult(((LottieComposition)object0));
        }
    }

    private static final LottieListener DEFAULT_FAILURE_LISTENER = null;
    private static final String TAG = "LottieAnimationView";
    private String animationName;
    private int animationResId;
    private boolean autoPlay;
    private boolean cacheComposition;
    private LottieTask compositionTask;
    private LottieListener failureListener;
    private int fallbackResource;
    private boolean ignoreUnschedule;
    private final LottieListener loadedListener;
    private final LottieDrawable lottieDrawable;
    private final Set lottieOnCompositionLoadedListeners;
    private final Set userActionsTaken;
    private final LottieListener wrappedFailureListener;

    static {
        LottieAnimationView.DEFAULT_FAILURE_LISTENER = new c();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public LottieAnimationView(Context context0) {
        super(context0);
        this.loadedListener = new WeakSuccessListener(this);
        this.wrappedFailureListener = new WeakFailureListener(this);
        this.fallbackResource = 0;
        this.lottieDrawable = new LottieDrawable();
        this.ignoreUnschedule = false;
        this.autoPlay = false;
        this.cacheComposition = true;
        this.userActionsTaken = new HashSet();
        this.lottieOnCompositionLoadedListeners = new HashSet();
        this.init(null, attr.lottieAnimationViewStyle);
    }

    public LottieAnimationView(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.loadedListener = new WeakSuccessListener(this);
        this.wrappedFailureListener = new WeakFailureListener(this);
        this.fallbackResource = 0;
        this.lottieDrawable = new LottieDrawable();
        this.ignoreUnschedule = false;
        this.autoPlay = false;
        this.cacheComposition = true;
        this.userActionsTaken = new HashSet();
        this.lottieOnCompositionLoadedListeners = new HashSet();
        this.init(attributeSet0, attr.lottieAnimationViewStyle);
    }

    public LottieAnimationView(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.loadedListener = new WeakSuccessListener(this);
        this.wrappedFailureListener = new WeakFailureListener(this);
        this.fallbackResource = 0;
        this.lottieDrawable = new LottieDrawable();
        this.ignoreUnschedule = false;
        this.autoPlay = false;
        this.cacheComposition = true;
        this.userActionsTaken = new HashSet();
        this.lottieOnCompositionLoadedListeners = new HashSet();
        this.init(attributeSet0, v);
    }

    public void addAnimatorListener(Animator.AnimatorListener animator$AnimatorListener0) {
        this.lottieDrawable.addAnimatorListener(animator$AnimatorListener0);
    }

    public void addAnimatorPauseListener(Animator.AnimatorPauseListener animator$AnimatorPauseListener0) {
        this.lottieDrawable.addAnimatorPauseListener(animator$AnimatorPauseListener0);
    }

    public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener valueAnimator$AnimatorUpdateListener0) {
        this.lottieDrawable.addAnimatorUpdateListener(valueAnimator$AnimatorUpdateListener0);
    }

    public boolean addLottieOnCompositionLoadedListener(LottieOnCompositionLoadedListener lottieOnCompositionLoadedListener0) {
        LottieComposition lottieComposition0 = this.getComposition();
        if(lottieComposition0 != null) {
            lottieOnCompositionLoadedListener0.onCompositionLoaded(lottieComposition0);
        }
        return this.lottieOnCompositionLoadedListeners.add(lottieOnCompositionLoadedListener0);
    }

    public void addValueCallback(KeyPath keyPath0, Object object0, LottieValueCallback lottieValueCallback0) {
        this.lottieDrawable.addValueCallback(keyPath0, object0, lottieValueCallback0);
    }

    public void addValueCallback(KeyPath keyPath0, Object object0, SimpleLottieValueCallback simpleLottieValueCallback0) {
        com.airbnb.lottie.LottieAnimationView.1 lottieAnimationView$10 = new LottieValueCallback() {
            @Override  // com.airbnb.lottie.value.LottieValueCallback
            public Object getValue(LottieFrameInfo lottieFrameInfo0) {
                return simpleLottieValueCallback0.getValue(lottieFrameInfo0);
            }
        };
        this.lottieDrawable.addValueCallback(keyPath0, object0, lottieAnimationView$10);
    }

    public void cancelAnimation() {
        this.autoPlay = false;
        this.userActionsTaken.add(UserActionTaken.PLAY_OPTION);
        this.lottieDrawable.cancelAnimation();
    }

    private void cancelLoaderTask() {
        LottieTask lottieTask0 = this.compositionTask;
        if(lottieTask0 != null) {
            lottieTask0.removeListener(this.loadedListener);
            this.compositionTask.removeFailureListener(this.wrappedFailureListener);
        }
    }

    private void clearComposition() {
        this.lottieDrawable.clearComposition();
    }

    public void clearValueCallback(KeyPath keyPath0, Object object0) {
        this.lottieDrawable.addValueCallback(keyPath0, object0, null);
    }

    @Deprecated
    public void disableExtraScaleModeInFitXY() {
    }

    public void enableFeatureFlag(LottieFeatureFlag lottieFeatureFlag0, boolean z) {
        this.lottieDrawable.enableFeatureFlag(lottieFeatureFlag0, z);
    }

    public void enableMergePathsForKitKatAndAbove(boolean z) {
        this.lottieDrawable.enableFeatureFlag(LottieFeatureFlag.MergePathsApi19, z);
    }

    private LottieTask fromAssets(String s) {
        if(this.isInEditMode()) {
            return new LottieTask(new b(0, this, s), true);
        }
        return this.cacheComposition ? LottieCompositionFactory.fromAsset(this.getContext(), s) : LottieCompositionFactory.fromAsset(this.getContext(), s, null);
    }

    private LottieTask fromRawRes(int v) {
        if(this.isInEditMode()) {
            return new LottieTask(new d(this, v), true);
        }
        return this.cacheComposition ? LottieCompositionFactory.fromRawRes(this.getContext(), v) : LottieCompositionFactory.fromRawRes(this.getContext(), v, null);
    }

    public AsyncUpdates getAsyncUpdates() {
        return this.lottieDrawable.getAsyncUpdates();
    }

    public boolean getAsyncUpdatesEnabled() {
        return this.lottieDrawable.getAsyncUpdatesEnabled();
    }

    public boolean getClipTextToBoundingBox() {
        return this.lottieDrawable.getClipTextToBoundingBox();
    }

    public boolean getClipToCompositionBounds() {
        return this.lottieDrawable.getClipToCompositionBounds();
    }

    public LottieComposition getComposition() {
        return this.getDrawable() == this.lottieDrawable ? this.lottieDrawable.getComposition() : null;
    }

    public long getDuration() {
        LottieComposition lottieComposition0 = this.getComposition();
        return lottieComposition0 == null ? 0L : ((long)lottieComposition0.getDuration());
    }

    public int getFrame() {
        return this.lottieDrawable.getFrame();
    }

    public String getImageAssetsFolder() {
        return this.lottieDrawable.getImageAssetsFolder();
    }

    public boolean getMaintainOriginalImageBounds() {
        return this.lottieDrawable.getMaintainOriginalImageBounds();
    }

    public float getMaxFrame() {
        return this.lottieDrawable.getMaxFrame();
    }

    public float getMinFrame() {
        return this.lottieDrawable.getMinFrame();
    }

    public PerformanceTracker getPerformanceTracker() {
        return this.lottieDrawable.getPerformanceTracker();
    }

    public float getProgress() {
        return this.lottieDrawable.getProgress();
    }

    public RenderMode getRenderMode() {
        return this.lottieDrawable.getRenderMode();
    }

    public int getRepeatCount() {
        return this.lottieDrawable.getRepeatCount();
    }

    public int getRepeatMode() {
        return this.lottieDrawable.getRepeatMode();
    }

    public float getSpeed() {
        return this.lottieDrawable.getSpeed();
    }

    public boolean hasMasks() {
        return this.lottieDrawable.hasMasks();
    }

    public boolean hasMatte() {
        return this.lottieDrawable.hasMatte();
    }

    private void init(AttributeSet attributeSet0, int v) {
        TypedArray typedArray0 = this.getContext().obtainStyledAttributes(attributeSet0, styleable.LottieAnimationView, v, 0);
        this.cacheComposition = typedArray0.getBoolean(styleable.LottieAnimationView_lottie_cacheComposition, true);
        boolean z = typedArray0.hasValue(styleable.LottieAnimationView_lottie_rawRes);
        boolean z1 = typedArray0.hasValue(styleable.LottieAnimationView_lottie_fileName);
        boolean z2 = typedArray0.hasValue(styleable.LottieAnimationView_lottie_url);
        if(z && z1) {
            throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use only one at once.");
        }
        if(z) {
            int v1 = typedArray0.getResourceId(16, 0);
            if(v1 != 0) {
                this.setAnimation(v1);
            }
        }
        else if(z1) {
            String s = typedArray0.getString(11);
            if(s != null) {
                this.setAnimation(s);
            }
        }
        else if(z2) {
            String s1 = typedArray0.getString(21);
            if(s1 != null) {
                this.setAnimationFromUrl(s1);
            }
        }
        this.setFallbackResource(typedArray0.getResourceId(styleable.LottieAnimationView_lottie_fallbackRes, 0));
        if(typedArray0.getBoolean(styleable.LottieAnimationView_lottie_autoPlay, false)) {
            this.autoPlay = true;
        }
        if(typedArray0.getBoolean(styleable.LottieAnimationView_lottie_loop, false)) {
            this.lottieDrawable.setRepeatCount(-1);
        }
        if(typedArray0.hasValue(styleable.LottieAnimationView_lottie_repeatMode)) {
            this.setRepeatMode(typedArray0.getInt(19, 1));
        }
        if(typedArray0.hasValue(styleable.LottieAnimationView_lottie_repeatCount)) {
            this.setRepeatCount(typedArray0.getInt(18, -1));
        }
        if(typedArray0.hasValue(styleable.LottieAnimationView_lottie_speed)) {
            this.setSpeed(typedArray0.getFloat(20, 1.0f));
        }
        if(typedArray0.hasValue(styleable.LottieAnimationView_lottie_clipToCompositionBounds)) {
            this.setClipToCompositionBounds(typedArray0.getBoolean(6, true));
        }
        if(typedArray0.hasValue(styleable.LottieAnimationView_lottie_clipTextToBoundingBox)) {
            this.setClipTextToBoundingBox(typedArray0.getBoolean(5, false));
        }
        if(typedArray0.hasValue(styleable.LottieAnimationView_lottie_defaultFontFileExtension)) {
            this.setDefaultFontFileExtension(typedArray0.getString(8));
        }
        this.setImageAssetsFolder(typedArray0.getString(styleable.LottieAnimationView_lottie_imageAssetsFolder));
        boolean z3 = typedArray0.hasValue(styleable.LottieAnimationView_lottie_progress);
        this.setProgressInternal(typedArray0.getFloat(styleable.LottieAnimationView_lottie_progress, 0.0f), z3);
        this.enableMergePathsForKitKatAndAbove(typedArray0.getBoolean(styleable.LottieAnimationView_lottie_enableMergePathsForKitKatAndAbove, false));
        this.setApplyingOpacityToLayersEnabled(typedArray0.getBoolean(styleable.LottieAnimationView_lottie_applyOpacityToLayers, false));
        this.setApplyingShadowToLayersEnabled(typedArray0.getBoolean(styleable.LottieAnimationView_lottie_applyShadowToLayers, true));
        if(typedArray0.hasValue(styleable.LottieAnimationView_lottie_colorFilter)) {
            int v2 = typedArray0.getResourceId(7, -1);
            SimpleColorFilter simpleColorFilter0 = new SimpleColorFilter(P1.c.getColorStateList(this.getContext(), v2).getDefaultColor());
            KeyPath keyPath0 = new KeyPath(new String[]{"**"});
            LottieValueCallback lottieValueCallback0 = new LottieValueCallback(simpleColorFilter0);
            this.addValueCallback(keyPath0, LottieProperty.COLOR_FILTER, lottieValueCallback0);
        }
        if(typedArray0.hasValue(styleable.LottieAnimationView_lottie_renderMode)) {
            RenderMode renderMode0 = RenderMode.AUTOMATIC;
            int v3 = typedArray0.getInt(17, renderMode0.ordinal());
            if(v3 >= RenderMode.values().length) {
                v3 = renderMode0.ordinal();
            }
            this.setRenderMode(RenderMode.values()[v3]);
        }
        if(typedArray0.hasValue(styleable.LottieAnimationView_lottie_asyncUpdates)) {
            AsyncUpdates asyncUpdates0 = AsyncUpdates.AUTOMATIC;
            int v4 = typedArray0.getInt(2, asyncUpdates0.ordinal());
            if(v4 >= RenderMode.values().length) {
                v4 = asyncUpdates0.ordinal();
            }
            this.setAsyncUpdates(AsyncUpdates.values()[v4]);
        }
        this.setIgnoreDisabledSystemAnimations(typedArray0.getBoolean(styleable.LottieAnimationView_lottie_ignoreDisabledSystemAnimations, false));
        if(typedArray0.hasValue(styleable.LottieAnimationView_lottie_useCompositionFrameRate)) {
            this.setUseCompositionFrameRate(typedArray0.getBoolean(22, false));
        }
        typedArray0.recycle();
    }

    @Override  // android.view.View
    public void invalidate() {
        super.invalidate();
        Drawable drawable0 = this.getDrawable();
        if(drawable0 instanceof LottieDrawable && ((LottieDrawable)drawable0).getRenderMode() == RenderMode.SOFTWARE) {
            this.lottieDrawable.invalidateSelf();
        }
    }

    @Override  // android.widget.ImageView
    public void invalidateDrawable(Drawable drawable0) {
        Drawable drawable1 = this.getDrawable();
        LottieDrawable lottieDrawable0 = this.lottieDrawable;
        if(drawable1 == lottieDrawable0) {
            super.invalidateDrawable(lottieDrawable0);
            return;
        }
        super.invalidateDrawable(drawable0);
    }

    public boolean isAnimating() {
        return this.lottieDrawable.isAnimating();
    }

    public boolean isFeatureFlagEnabled(LottieFeatureFlag lottieFeatureFlag0) {
        return this.lottieDrawable.isFeatureFlagEnabled(lottieFeatureFlag0);
    }

    public boolean isMergePathsEnabledForKitKatAndAbove() {
        return this.lottieDrawable.isFeatureFlagEnabled(LottieFeatureFlag.MergePathsApi19);
    }

    // 去混淆评级： 低(20)
    private LottieResult lambda$fromAssets$2(String s) {
        return this.cacheComposition ? LottieCompositionFactory.fromAssetSync(this.getContext(), s) : LottieCompositionFactory.fromAssetSync(this.getContext(), s, null);
    }

    // 去混淆评级： 低(20)
    private LottieResult lambda$fromRawRes$1(int v) {
        return this.cacheComposition ? LottieCompositionFactory.fromRawResSync(this.getContext(), v) : LottieCompositionFactory.fromRawResSync(this.getContext(), v, null);
    }

    private static void lambda$static$0(Throwable throwable0) {
        if(!Utils.isNetworkException(throwable0)) {
            throw new IllegalStateException("Unable to parse composition", throwable0);
        }
        Logger.warning("Unable to load composition.", throwable0);
    }

    @Deprecated
    public void loop(boolean z) {
        this.lottieDrawable.setRepeatCount((z ? -1 : 0));
    }

    @Override  // android.widget.ImageView
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if(!this.isInEditMode() && this.autoPlay) {
            this.lottieDrawable.playAnimation();
        }
    }

    @Override  // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable0) {
        if(!(parcelable0 instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable0);
            return;
        }
        super.onRestoreInstanceState(((SavedState)parcelable0).getSuperState());
        this.animationName = ((SavedState)parcelable0).animationName;
        UserActionTaken lottieAnimationView$UserActionTaken0 = UserActionTaken.SET_ANIMATION;
        if(!this.userActionsTaken.contains(lottieAnimationView$UserActionTaken0) && !TextUtils.isEmpty(this.animationName)) {
            this.setAnimation(this.animationName);
        }
        this.animationResId = ((SavedState)parcelable0).animationResId;
        if(!this.userActionsTaken.contains(lottieAnimationView$UserActionTaken0)) {
            int v = this.animationResId;
            if(v != 0) {
                this.setAnimation(v);
            }
        }
        if(!this.userActionsTaken.contains(UserActionTaken.SET_PROGRESS)) {
            this.setProgressInternal(((SavedState)parcelable0).progress, false);
        }
        if(!this.userActionsTaken.contains(UserActionTaken.PLAY_OPTION) && ((SavedState)parcelable0).isAnimating) {
            this.playAnimation();
        }
        if(!this.userActionsTaken.contains(UserActionTaken.SET_IMAGE_ASSETS)) {
            this.setImageAssetsFolder(((SavedState)parcelable0).imageAssetsFolder);
        }
        if(!this.userActionsTaken.contains(UserActionTaken.SET_REPEAT_MODE)) {
            this.setRepeatMode(((SavedState)parcelable0).repeatMode);
        }
        if(!this.userActionsTaken.contains(UserActionTaken.SET_REPEAT_COUNT)) {
            this.setRepeatCount(((SavedState)parcelable0).repeatCount);
        }
    }

    @Override  // android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable parcelable0 = new SavedState(super.onSaveInstanceState());
        parcelable0.animationName = this.animationName;
        parcelable0.animationResId = this.animationResId;
        parcelable0.progress = this.lottieDrawable.getProgress();
        parcelable0.isAnimating = this.lottieDrawable.isAnimatingOrWillAnimateOnVisible();
        parcelable0.imageAssetsFolder = this.lottieDrawable.getImageAssetsFolder();
        parcelable0.repeatMode = this.lottieDrawable.getRepeatMode();
        parcelable0.repeatCount = this.lottieDrawable.getRepeatCount();
        return parcelable0;
    }

    public void pauseAnimation() {
        this.autoPlay = false;
        this.lottieDrawable.pauseAnimation();
    }

    public void playAnimation() {
        this.userActionsTaken.add(UserActionTaken.PLAY_OPTION);
        this.lottieDrawable.playAnimation();
    }

    public void removeAllAnimatorListeners() {
        this.lottieDrawable.removeAllAnimatorListeners();
    }

    public void removeAllLottieOnCompositionLoadedListener() {
        this.lottieOnCompositionLoadedListeners.clear();
    }

    public void removeAllUpdateListeners() {
        this.lottieDrawable.removeAllUpdateListeners();
    }

    public void removeAnimatorListener(Animator.AnimatorListener animator$AnimatorListener0) {
        this.lottieDrawable.removeAnimatorListener(animator$AnimatorListener0);
    }

    public void removeAnimatorPauseListener(Animator.AnimatorPauseListener animator$AnimatorPauseListener0) {
        this.lottieDrawable.removeAnimatorPauseListener(animator$AnimatorPauseListener0);
    }

    public boolean removeLottieOnCompositionLoadedListener(LottieOnCompositionLoadedListener lottieOnCompositionLoadedListener0) {
        return this.lottieOnCompositionLoadedListeners.remove(lottieOnCompositionLoadedListener0);
    }

    public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener valueAnimator$AnimatorUpdateListener0) {
        this.lottieDrawable.removeAnimatorUpdateListener(valueAnimator$AnimatorUpdateListener0);
    }

    public List resolveKeyPath(KeyPath keyPath0) {
        return this.lottieDrawable.resolveKeyPath(keyPath0);
    }

    public void resumeAnimation() {
        this.userActionsTaken.add(UserActionTaken.PLAY_OPTION);
        this.lottieDrawable.resumeAnimation();
    }

    public void reverseAnimationSpeed() {
        this.lottieDrawable.reverseAnimationSpeed();
    }

    public void setAnimation(int v) {
        this.animationResId = v;
        this.animationName = null;
        this.setCompositionTask(this.fromRawRes(v));
    }

    public void setAnimation(InputStream inputStream0, String s) {
        this.setCompositionTask(LottieCompositionFactory.fromJsonInputStream(inputStream0, s));
    }

    public void setAnimation(String s) {
        this.animationName = s;
        this.animationResId = 0;
        this.setCompositionTask(this.fromAssets(s));
    }

    public void setAnimation(ZipInputStream zipInputStream0, String s) {
        this.setCompositionTask(LottieCompositionFactory.fromZipStream(zipInputStream0, s));
    }

    @Deprecated
    public void setAnimationFromJson(String s) {
        this.setAnimationFromJson(s, null);
    }

    public void setAnimationFromJson(String s, String s1) {
        this.setAnimation(new ByteArrayInputStream(s.getBytes()), s1);
    }

    public void setAnimationFromUrl(String s) {
        this.setCompositionTask((this.cacheComposition ? LottieCompositionFactory.fromUrl(this.getContext(), s) : LottieCompositionFactory.fromUrl(this.getContext(), s, null)));
    }

    public void setAnimationFromUrl(String s, String s1) {
        this.setCompositionTask(LottieCompositionFactory.fromUrl(this.getContext(), s, s1));
    }

    public void setApplyingOpacityToLayersEnabled(boolean z) {
        this.lottieDrawable.setApplyingOpacityToLayersEnabled(z);
    }

    public void setApplyingShadowToLayersEnabled(boolean z) {
        this.lottieDrawable.setApplyingShadowToLayersEnabled(z);
    }

    public void setAsyncUpdates(AsyncUpdates asyncUpdates0) {
        this.lottieDrawable.setAsyncUpdates(asyncUpdates0);
    }

    public void setCacheComposition(boolean z) {
        this.cacheComposition = z;
    }

    public void setClipTextToBoundingBox(boolean z) {
        this.lottieDrawable.setClipTextToBoundingBox(z);
    }

    public void setClipToCompositionBounds(boolean z) {
        this.lottieDrawable.setClipToCompositionBounds(z);
    }

    public void setComposition(LottieComposition lottieComposition0) {
        if(L.DBG) {
            Log.v("LottieAnimationView", "Set Composition \n" + lottieComposition0);
        }
        this.lottieDrawable.setCallback(this);
        this.ignoreUnschedule = true;
        boolean z = this.lottieDrawable.setComposition(lottieComposition0);
        if(this.autoPlay) {
            this.lottieDrawable.playAnimation();
        }
        this.ignoreUnschedule = false;
        if(this.getDrawable() != this.lottieDrawable || z) {
            if(!z) {
                this.setLottieDrawable();
            }
            this.onVisibilityChanged(this, this.getVisibility());
            this.requestLayout();
            for(Object object0: this.lottieOnCompositionLoadedListeners) {
                ((LottieOnCompositionLoadedListener)object0).onCompositionLoaded(lottieComposition0);
            }
        }
    }

    private void setCompositionTask(LottieTask lottieTask0) {
        LottieResult lottieResult0 = lottieTask0.getResult();
        if(lottieResult0 != null && this.lottieDrawable == this.getDrawable() && this.lottieDrawable.getComposition() == lottieResult0.getValue()) {
            return;
        }
        this.userActionsTaken.add(UserActionTaken.SET_ANIMATION);
        this.clearComposition();
        this.cancelLoaderTask();
        this.compositionTask = lottieTask0.addListener(this.loadedListener).addFailureListener(this.wrappedFailureListener);
    }

    public void setDefaultFontFileExtension(String s) {
        this.lottieDrawable.setDefaultFontFileExtension(s);
    }

    public void setFailureListener(LottieListener lottieListener0) {
        this.failureListener = lottieListener0;
    }

    public void setFallbackResource(int v) {
        this.fallbackResource = v;
    }

    public void setFontAssetDelegate(FontAssetDelegate fontAssetDelegate0) {
        this.lottieDrawable.setFontAssetDelegate(fontAssetDelegate0);
    }

    public void setFontMap(Map map0) {
        this.lottieDrawable.setFontMap(map0);
    }

    public void setFrame(int v) {
        this.lottieDrawable.setFrame(v);
    }

    @Deprecated
    public void setIgnoreDisabledSystemAnimations(boolean z) {
        this.lottieDrawable.setIgnoreDisabledSystemAnimations(z);
    }

    public void setImageAssetDelegate(ImageAssetDelegate imageAssetDelegate0) {
        this.lottieDrawable.setImageAssetDelegate(imageAssetDelegate0);
    }

    public void setImageAssetsFolder(String s) {
        this.lottieDrawable.setImagesAssetsFolder(s);
    }

    @Override  // androidx.appcompat.widget.AppCompatImageView
    public void setImageBitmap(Bitmap bitmap0) {
        this.animationResId = 0;
        this.animationName = null;
        this.cancelLoaderTask();
        super.setImageBitmap(bitmap0);
    }

    @Override  // androidx.appcompat.widget.AppCompatImageView
    public void setImageDrawable(Drawable drawable0) {
        this.animationResId = 0;
        this.animationName = null;
        this.cancelLoaderTask();
        super.setImageDrawable(drawable0);
    }

    @Override  // androidx.appcompat.widget.AppCompatImageView
    public void setImageResource(int v) {
        this.animationResId = 0;
        this.animationName = null;
        this.cancelLoaderTask();
        super.setImageResource(v);
    }

    private void setLottieDrawable() {
        boolean z = this.isAnimating();
        this.setImageDrawable(null);
        this.setImageDrawable(this.lottieDrawable);
        if(z) {
            this.lottieDrawable.resumeAnimation();
        }
    }

    public void setMaintainOriginalImageBounds(boolean z) {
        this.lottieDrawable.setMaintainOriginalImageBounds(z);
    }

    public void setMaxFrame(int v) {
        this.lottieDrawable.setMaxFrame(v);
    }

    public void setMaxFrame(String s) {
        this.lottieDrawable.setMaxFrame(s);
    }

    public void setMaxProgress(float f) {
        this.lottieDrawable.setMaxProgress(f);
    }

    public void setMinAndMaxFrame(int v, int v1) {
        this.lottieDrawable.setMinAndMaxFrame(v, v1);
    }

    public void setMinAndMaxFrame(String s) {
        this.lottieDrawable.setMinAndMaxFrame(s);
    }

    public void setMinAndMaxFrame(String s, String s1, boolean z) {
        this.lottieDrawable.setMinAndMaxFrame(s, s1, z);
    }

    public void setMinAndMaxProgress(float f, float f1) {
        this.lottieDrawable.setMinAndMaxProgress(f, f1);
    }

    public void setMinFrame(int v) {
        this.lottieDrawable.setMinFrame(v);
    }

    public void setMinFrame(String s) {
        this.lottieDrawable.setMinFrame(s);
    }

    public void setMinProgress(float f) {
        this.lottieDrawable.setMinProgress(f);
    }

    public void setOutlineMasksAndMattes(boolean z) {
        this.lottieDrawable.setOutlineMasksAndMattes(z);
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.lottieDrawable.setPerformanceTrackingEnabled(z);
    }

    public void setProgress(float f) {
        this.setProgressInternal(f, true);
    }

    private void setProgressInternal(float f, boolean z) {
        if(z) {
            this.userActionsTaken.add(UserActionTaken.SET_PROGRESS);
        }
        this.lottieDrawable.setProgress(f);
    }

    public void setRenderMode(RenderMode renderMode0) {
        this.lottieDrawable.setRenderMode(renderMode0);
    }

    public void setRepeatCount(int v) {
        this.userActionsTaken.add(UserActionTaken.SET_REPEAT_COUNT);
        this.lottieDrawable.setRepeatCount(v);
    }

    public void setRepeatMode(int v) {
        this.userActionsTaken.add(UserActionTaken.SET_REPEAT_MODE);
        this.lottieDrawable.setRepeatMode(v);
    }

    public void setSafeMode(boolean z) {
        this.lottieDrawable.setSafeMode(z);
    }

    public void setSpeed(float f) {
        this.lottieDrawable.setSpeed(f);
    }

    public void setTextDelegate(TextDelegate textDelegate0) {
        this.lottieDrawable.setTextDelegate(textDelegate0);
    }

    public void setUseCompositionFrameRate(boolean z) {
        this.lottieDrawable.setUseCompositionFrameRate(z);
    }

    @Override  // android.view.View
    public void unscheduleDrawable(Drawable drawable0) {
        if(!this.ignoreUnschedule && (drawable0 == this.lottieDrawable && this.lottieDrawable.isAnimating())) {
            this.pauseAnimation();
        }
        else if(!this.ignoreUnschedule && drawable0 instanceof LottieDrawable && ((LottieDrawable)drawable0).isAnimating()) {
            ((LottieDrawable)drawable0).pauseAnimation();
        }
        super.unscheduleDrawable(drawable0);
    }

    public Bitmap updateBitmap(String s, Bitmap bitmap0) {
        return this.lottieDrawable.updateBitmap(s, bitmap0);
    }
}

