package com.airbnb.lottie;

import android.animation.Animator.AnimatorListener;
import android.animation.Animator.AnimatorPauseListener;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap.Config;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.configurations.reducemotion.ReducedMotionMode;
import com.airbnb.lottie.manager.FontAssetManager;
import com.airbnb.lottie.manager.ImageAssetManager;
import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.Marker;
import com.airbnb.lottie.model.layer.CompositionLayer;
import com.airbnb.lottie.parser.LayerParser;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.LottieThreadFactory;
import com.airbnb.lottie.utils.LottieValueAnimator;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.LottieValueCallback;
import com.airbnb.lottie.value.SimpleLottieValueCallback;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class LottieDrawable extends Drawable implements Animatable, Drawable.Callback {
    interface LazyCompositionTask {
        void run(LottieComposition arg1);
    }

    static enum OnVisibleAction {
        NONE,
        PLAY,
        RESUME;

        private static OnVisibleAction[] $values() [...] // Inlined contents
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface RepeatMode {
    }

    private static final List ALLOWED_REDUCED_MOTION_MARKERS = null;
    public static final int INFINITE = -1;
    private static final float MAX_DELTA_MS_ASYNC_SET_PROGRESS = 50.0f;
    public static final int RESTART = 1;
    public static final int REVERSE = 2;
    private int alpha;
    private final LottieValueAnimator animator;
    private AsyncUpdates asyncUpdates;
    private Rect canvasClipBounds;
    private RectF canvasClipBoundsRectF;
    private boolean clipTextToBoundingBox;
    private boolean clipToCompositionBounds;
    private LottieComposition composition;
    private CompositionLayer compositionLayer;
    String defaultFontFileExtension;
    FontAssetDelegate fontAssetDelegate;
    private FontAssetManager fontAssetManager;
    private Map fontMap;
    private boolean ignoreSystemAnimationsDisabled;
    private ImageAssetDelegate imageAssetDelegate;
    private ImageAssetManager imageAssetManager;
    private String imageAssetsFolder;
    private static final boolean invalidateSelfOnMainThread;
    private Runnable invalidateSelfRunnable;
    private boolean isApplyingOpacityToLayersEnabled;
    private boolean isApplyingShadowToLayersEnabled;
    private boolean isDirty;
    private float lastDrawnProgress;
    private final ArrayList lazyCompositionTasks;
    private final LottieFeatureFlags lottieFeatureFlags;
    private Handler mainThreadHandler;
    private boolean maintainOriginalImageBounds;
    private OnVisibleAction onVisibleAction;
    private boolean outlineMasksAndMattes;
    private boolean performanceTrackingEnabled;
    private final ValueAnimator.AnimatorUpdateListener progressUpdateListener;
    private RenderMode renderMode;
    private final Matrix renderingMatrix;
    private boolean safeMode;
    private final Semaphore setProgressDrawLock;
    private static final Executor setProgressExecutor;
    private Bitmap softwareRenderingBitmap;
    private Canvas softwareRenderingCanvas;
    private Rect softwareRenderingDstBoundsRect;
    private RectF softwareRenderingDstBoundsRectF;
    private Matrix softwareRenderingOriginalCanvasMatrix;
    private float[] softwareRenderingOriginalCanvasMatrixElements;
    private Matrix softwareRenderingOriginalCanvasMatrixInverse;
    private Paint softwareRenderingPaint;
    private Rect softwareRenderingSrcBoundsRect;
    private RectF softwareRenderingTransformedBounds;
    private boolean systemAnimationsEnabled;
    TextDelegate textDelegate;
    private final Runnable updateProgressRunnable;
    private boolean useSoftwareRendering;

    static {
        LottieDrawable.invalidateSelfOnMainThread = false;
        LottieDrawable.ALLOWED_REDUCED_MOTION_MARKERS = Arrays.asList(new String[]{"reduced motion", "reduced_motion", "reduced-motion", "reducedmotion"});
        LottieDrawable.setProgressExecutor = new ThreadPoolExecutor(0, 2, 35L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new LottieThreadFactory());
    }

    public LottieDrawable() {
        LottieValueAnimator lottieValueAnimator0 = new LottieValueAnimator();
        this.animator = lottieValueAnimator0;
        this.systemAnimationsEnabled = true;
        this.ignoreSystemAnimationsDisabled = false;
        this.safeMode = false;
        this.onVisibleAction = OnVisibleAction.NONE;
        this.lazyCompositionTasks = new ArrayList();
        this.lottieFeatureFlags = new LottieFeatureFlags();
        this.maintainOriginalImageBounds = false;
        this.clipToCompositionBounds = true;
        this.alpha = 0xFF;
        this.clipTextToBoundingBox = false;
        this.renderMode = RenderMode.AUTOMATIC;
        this.useSoftwareRendering = false;
        this.renderingMatrix = new Matrix();
        this.softwareRenderingOriginalCanvasMatrixElements = new float[9];
        this.isDirty = false;
        u u0 = new u(this);
        this.progressUpdateListener = u0;
        this.setProgressDrawLock = new Semaphore(1);
        this.updateProgressRunnable = new r(this, 1);
        this.lastDrawnProgress = -3.402823E+38f;
        lottieValueAnimator0.addUpdateListener(u0);
    }

    public void addAnimatorListener(Animator.AnimatorListener animator$AnimatorListener0) {
        this.animator.addListener(animator$AnimatorListener0);
    }

    public void addAnimatorPauseListener(Animator.AnimatorPauseListener animator$AnimatorPauseListener0) {
        this.animator.addPauseListener(animator$AnimatorPauseListener0);
    }

    public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener valueAnimator$AnimatorUpdateListener0) {
        this.animator.addUpdateListener(valueAnimator$AnimatorUpdateListener0);
    }

    public void addValueCallback(KeyPath keyPath0, Object object0, LottieValueCallback lottieValueCallback0) {
        int v = 1;
        CompositionLayer compositionLayer0 = this.compositionLayer;
        if(compositionLayer0 == null) {
            p p0 = new p(this, keyPath0, object0, lottieValueCallback0);
            this.lazyCompositionTasks.add(p0);
            return;
        }
        if(keyPath0 == KeyPath.COMPOSITION) {
            compositionLayer0.addValueCallback(object0, lottieValueCallback0);
        }
        else if(keyPath0.getResolvedElement() == null) {
            List list0 = this.resolveKeyPath(keyPath0);
            for(int v1 = 0; v1 < list0.size(); ++v1) {
                ((KeyPath)list0.get(v1)).getResolvedElement().addValueCallback(object0, lottieValueCallback0);
            }
            v = true ^ list0.isEmpty();
        }
        else {
            keyPath0.getResolvedElement().addValueCallback(object0, lottieValueCallback0);
        }
        if(v != 0) {
            this.invalidateSelf();
            if(object0 == LottieProperty.TIME_REMAP) {
                this.setProgress(this.getProgress());
            }
        }
    }

    public void addValueCallback(KeyPath keyPath0, Object object0, SimpleLottieValueCallback simpleLottieValueCallback0) {
        this.addValueCallback(keyPath0, object0, new LottieValueCallback() {
            @Override  // com.airbnb.lottie.value.LottieValueCallback
            public Object getValue(LottieFrameInfo lottieFrameInfo0) {
                return simpleLottieValueCallback0.getValue(lottieFrameInfo0);
            }
        });
    }

    // 去混淆评级： 低(30)
    public boolean animationsEnabled(Context context0) {
        return this.ignoreSystemAnimationsDisabled ? true : this.systemAnimationsEnabled && L.getReducedMotionOption().getCurrentReducedMotionMode(context0) == ReducedMotionMode.STANDARD_MOTION;
    }

    private void buildCompositionLayer() {
        LottieComposition lottieComposition0 = this.composition;
        if(lottieComposition0 == null) {
            return;
        }
        CompositionLayer compositionLayer0 = new CompositionLayer(this, LayerParser.parse(lottieComposition0), lottieComposition0.getLayers(), lottieComposition0);
        this.compositionLayer = compositionLayer0;
        if(this.outlineMasksAndMattes) {
            compositionLayer0.setOutlineMasksAndMattes(true);
        }
        this.compositionLayer.setClipToCompositionBounds(this.clipToCompositionBounds);
    }

    public void cancelAnimation() {
        this.lazyCompositionTasks.clear();
        this.animator.cancel();
        if(!this.isVisible()) {
            this.onVisibleAction = OnVisibleAction.NONE;
        }
    }

    public void clearComposition() {
        if(this.animator.isRunning()) {
            this.animator.cancel();
            if(!this.isVisible()) {
                this.onVisibleAction = OnVisibleAction.NONE;
            }
        }
        this.composition = null;
        this.compositionLayer = null;
        this.imageAssetManager = null;
        this.lastDrawnProgress = -3.402823E+38f;
        this.animator.clearComposition();
        this.invalidateSelf();
    }

    private void computeRenderMode() {
        LottieComposition lottieComposition0 = this.composition;
        if(lottieComposition0 == null) {
            return;
        }
        this.useSoftwareRendering = this.renderMode.useSoftwareRendering(Build.VERSION.SDK_INT, lottieComposition0.hasDashPattern(), lottieComposition0.getMaskAndMatteCount());
    }

    private void convertRect(Rect rect0, RectF rectF0) {
        rectF0.set(((float)rect0.left), ((float)rect0.top), ((float)rect0.right), ((float)rect0.bottom));
    }

    private void convertRect(RectF rectF0, Rect rect0) {
        rect0.set(((int)Math.floor(rectF0.left)), ((int)Math.floor(rectF0.top)), ((int)Math.ceil(rectF0.right)), ((int)Math.ceil(rectF0.bottom)));
    }

    @Deprecated
    public void disableExtraScaleModeInFitXY() {
    }

    private void draw(Canvas canvas0, Matrix matrix0, CompositionLayer compositionLayer0, int v) {
        if(this.useSoftwareRendering) {
            canvas0.save();
            canvas0.concat(matrix0);
            this.renderAndDrawAsBitmap(canvas0, compositionLayer0);
            canvas0.restore();
            return;
        }
        compositionLayer0.draw(canvas0, matrix0, v, null);
    }

    @Override  // android.graphics.drawable.Drawable
    public void draw(Canvas canvas0) {
        CompositionLayer compositionLayer0 = this.compositionLayer;
        if(compositionLayer0 != null) {
            boolean z = this.getAsyncUpdatesEnabled();
            try {
                if(z) {
                    this.setProgressDrawLock.acquire();
                }
                if(z && this.shouldSetProgressBeforeDrawing()) {
                    this.setProgress(this.animator.getAnimatedValueAbsolute());
                }
                if(this.safeMode) {
                    goto label_13;
                }
                else if(this.useSoftwareRendering) {
                    this.renderAndDrawAsBitmap(canvas0, compositionLayer0);
                    goto label_32;
                }
                else {
                    this.drawDirectlyToCanvas(canvas0);
                    goto label_32;
                }
                return;
            }
            catch(InterruptedException unused_ex) {
                goto label_23;
            }
            catch(Throwable throwable0) {
                goto label_27;
            }
            try {
            label_13:
                if(this.useSoftwareRendering) {
                    this.renderAndDrawAsBitmap(canvas0, compositionLayer0);
                }
                else {
                    this.drawDirectlyToCanvas(canvas0);
                }
                goto label_32;
            }
            catch(Throwable throwable1) {
            }
            try {
                Logger.error("Lottie crashed in draw!", throwable1);
                goto label_32;
            }
            catch(InterruptedException unused_ex) {
            }
            catch(Throwable throwable0) {
                goto label_27;
            }
        label_23:
            if(z) {
                this.setProgressDrawLock.release();
                if(compositionLayer0.getProgress() != this.animator.getAnimatedValueAbsolute()) {
                    LottieDrawable.setProgressExecutor.execute(this.updateProgressRunnable);
                    return;
                }
                return;
            label_27:
                if(z) {
                    this.setProgressDrawLock.release();
                    if(compositionLayer0.getProgress() != this.animator.getAnimatedValueAbsolute()) {
                        LottieDrawable.setProgressExecutor.execute(this.updateProgressRunnable);
                    }
                }
                throw throwable0;
            label_32:
                this.isDirty = false;
                if(z) {
                    this.setProgressDrawLock.release();
                    if(compositionLayer0.getProgress() != this.animator.getAnimatedValueAbsolute()) {
                        LottieDrawable.setProgressExecutor.execute(this.updateProgressRunnable);
                    }
                }
            }
        }
    }

    public void draw(Canvas canvas0, Matrix matrix0) {
        CompositionLayer compositionLayer0 = this.compositionLayer;
        if(compositionLayer0 != null && this.composition != null) {
            boolean z = this.getAsyncUpdatesEnabled();
            if(z) {
                try {
                    this.setProgressDrawLock.acquire();
                    if(this.shouldSetProgressBeforeDrawing()) {
                        this.setProgress(this.animator.getAnimatedValueAbsolute());
                    }
                label_7:
                    if(!this.safeMode) {
                        this.draw(canvas0, matrix0, compositionLayer0, this.alpha);
                        goto label_26;
                    }
                    goto label_10;
                }
                catch(InterruptedException unused_ex) {
                    goto label_17;
                }
                catch(Throwable throwable0) {
                    goto label_21;
                }
            }
            goto label_7;
            try {
            label_10:
                this.draw(canvas0, matrix0, compositionLayer0, this.alpha);
                goto label_26;
            }
            catch(Throwable throwable1) {
                try {
                    Logger.error("Lottie crashed in draw!", throwable1);
                    goto label_26;
                }
                catch(InterruptedException unused_ex) {
                }
                catch(Throwable throwable0) {
                    goto label_21;
                }
            }
        label_17:
            if(z) {
                this.setProgressDrawLock.release();
                if(compositionLayer0.getProgress() != this.animator.getAnimatedValueAbsolute()) {
                    LottieDrawable.setProgressExecutor.execute(this.updateProgressRunnable);
                    return;
                }
                return;
            label_21:
                if(z) {
                    this.setProgressDrawLock.release();
                    if(compositionLayer0.getProgress() != this.animator.getAnimatedValueAbsolute()) {
                        LottieDrawable.setProgressExecutor.execute(this.updateProgressRunnable);
                    }
                }
                throw throwable0;
            label_26:
                this.isDirty = false;
                if(z) {
                    this.setProgressDrawLock.release();
                    if(compositionLayer0.getProgress() != this.animator.getAnimatedValueAbsolute()) {
                        LottieDrawable.setProgressExecutor.execute(this.updateProgressRunnable);
                    }
                }
            }
        }
    }

    private void drawDirectlyToCanvas(Canvas canvas0) {
        CompositionLayer compositionLayer0 = this.compositionLayer;
        LottieComposition lottieComposition0 = this.composition;
        if(compositionLayer0 != null && lottieComposition0 != null) {
            this.renderingMatrix.reset();
            Rect rect0 = this.getBounds();
            if(!rect0.isEmpty()) {
                float f = ((float)rect0.width()) / ((float)lottieComposition0.getBounds().width());
                float f1 = ((float)rect0.height()) / ((float)lottieComposition0.getBounds().height());
                this.renderingMatrix.preTranslate(((float)rect0.left), ((float)rect0.top));
                this.renderingMatrix.preScale(f, f1);
            }
            compositionLayer0.draw(canvas0, this.renderingMatrix, this.alpha, null);
        }
    }

    public void enableFeatureFlag(LottieFeatureFlag lottieFeatureFlag0, boolean z) {
        boolean z1 = this.lottieFeatureFlags.enableFlag(lottieFeatureFlag0, z);
        if(this.composition != null && z1) {
            this.buildCompositionLayer();
        }
    }

    @Deprecated
    public void enableMergePathsForKitKatAndAbove(boolean z) {
        boolean z1 = this.lottieFeatureFlags.enableFlag(LottieFeatureFlag.MergePathsApi19, z);
        if(this.composition != null && z1) {
            this.buildCompositionLayer();
        }
    }

    @Deprecated
    public boolean enableMergePathsForKitKatAndAbove() {
        return this.lottieFeatureFlags.isFlagEnabled(LottieFeatureFlag.MergePathsApi19);
    }

    public void endAnimation() {
        this.lazyCompositionTasks.clear();
        this.animator.endAnimation();
        if(!this.isVisible()) {
            this.onVisibleAction = OnVisibleAction.NONE;
        }
    }

    private void ensureSoftwareRenderingBitmap(int v, int v1) {
        if(this.softwareRenderingBitmap != null && this.softwareRenderingBitmap.getWidth() >= v && this.softwareRenderingBitmap.getHeight() >= v1) {
            if(this.softwareRenderingBitmap.getWidth() <= v && this.softwareRenderingBitmap.getHeight() <= v1) {
                return;
            }
            Bitmap bitmap0 = Bitmap.createBitmap(this.softwareRenderingBitmap, 0, 0, v, v1);
            this.softwareRenderingBitmap = bitmap0;
            this.softwareRenderingCanvas.setBitmap(bitmap0);
            this.isDirty = true;
            return;
        }
        Bitmap bitmap1 = Bitmap.createBitmap(v, v1, Bitmap.Config.ARGB_8888);
        this.softwareRenderingBitmap = bitmap1;
        this.softwareRenderingCanvas.setBitmap(bitmap1);
        this.isDirty = true;
    }

    private void ensureSoftwareRenderingObjectsInitialized() {
        if(this.softwareRenderingCanvas != null) {
            return;
        }
        this.softwareRenderingCanvas = new Canvas();
        this.softwareRenderingTransformedBounds = new RectF();
        this.softwareRenderingOriginalCanvasMatrix = new Matrix();
        this.softwareRenderingOriginalCanvasMatrixInverse = new Matrix();
        this.canvasClipBounds = new Rect();
        this.canvasClipBoundsRectF = new RectF();
        this.softwareRenderingPaint = new LPaint();
        this.softwareRenderingSrcBoundsRect = new Rect();
        this.softwareRenderingDstBoundsRect = new Rect();
        this.softwareRenderingDstBoundsRectF = new RectF();
    }

    @Override  // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.alpha;
    }

    public AsyncUpdates getAsyncUpdates() {
        return this.asyncUpdates == null ? L.getDefaultAsyncUpdates() : this.asyncUpdates;
    }

    public boolean getAsyncUpdatesEnabled() {
        return this.getAsyncUpdates() == AsyncUpdates.ENABLED;
    }

    public Bitmap getBitmapForId(String s) {
        ImageAssetManager imageAssetManager0 = this.getImageAssetManager();
        return imageAssetManager0 == null ? null : imageAssetManager0.bitmapForId(s);
    }

    public boolean getClipTextToBoundingBox() {
        return this.clipTextToBoundingBox;
    }

    public boolean getClipToCompositionBounds() {
        return this.clipToCompositionBounds;
    }

    public LottieComposition getComposition() {
        return this.composition;
    }

    private Context getContext() {
        Drawable.Callback drawable$Callback0 = this.getCallback();
        if(drawable$Callback0 == null) {
            return null;
        }
        return drawable$Callback0 instanceof View ? ((View)drawable$Callback0).getContext() : null;
    }

    private FontAssetManager getFontAssetManager() {
        if(this.getCallback() == null) {
            return null;
        }
        if(this.fontAssetManager == null) {
            FontAssetManager fontAssetManager0 = new FontAssetManager(this.getCallback(), this.fontAssetDelegate);
            this.fontAssetManager = fontAssetManager0;
            String s = this.defaultFontFileExtension;
            if(s != null) {
                fontAssetManager0.setDefaultFontFileExtension(s);
            }
        }
        return this.fontAssetManager;
    }

    public int getFrame() {
        return (int)this.animator.getFrame();
    }

    @Deprecated
    public Bitmap getImageAsset(String s) {
        ImageAssetManager imageAssetManager0 = this.getImageAssetManager();
        if(imageAssetManager0 != null) {
            return imageAssetManager0.bitmapForId(s);
        }
        LottieImageAsset lottieImageAsset0 = this.composition == null ? null : ((LottieImageAsset)this.composition.getImages().get(s));
        return lottieImageAsset0 == null ? null : lottieImageAsset0.getBitmap();
    }

    private ImageAssetManager getImageAssetManager() {
        if(this.imageAssetManager != null && !this.imageAssetManager.hasSameContext(this.getContext())) {
            this.imageAssetManager = null;
        }
        if(this.imageAssetManager == null) {
            this.imageAssetManager = new ImageAssetManager(this.getCallback(), this.imageAssetsFolder, this.imageAssetDelegate, this.composition.getImages());
        }
        return this.imageAssetManager;
    }

    public String getImageAssetsFolder() {
        return this.imageAssetsFolder;
    }

    @Override  // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.composition == null ? -1 : this.composition.getBounds().height();
    }

    @Override  // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.composition == null ? -1 : this.composition.getBounds().width();
    }

    public LottieImageAsset getLottieImageAssetForId(String s) {
        return this.composition == null ? null : ((LottieImageAsset)this.composition.getImages().get(s));
    }

    public boolean getMaintainOriginalImageBounds() {
        return this.maintainOriginalImageBounds;
    }

    public Marker getMarkerForAnimationsDisabled() {
        Marker marker0 = null;
        for(Object object0: LottieDrawable.ALLOWED_REDUCED_MOTION_MARKERS) {
            marker0 = this.composition.getMarker(((String)object0));
            if(marker0 != null) {
                break;
            }
        }
        return marker0;
    }

    public float getMaxFrame() {
        return this.animator.getMaxFrame();
    }

    public float getMinFrame() {
        return this.animator.getMinFrame();
    }

    @Override  // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public PerformanceTracker getPerformanceTracker() {
        return this.composition == null ? null : this.composition.getPerformanceTracker();
    }

    public float getProgress() {
        return this.animator.getAnimatedValueAbsolute();
    }

    // 去混淆评级： 低(20)
    public RenderMode getRenderMode() {
        return this.useSoftwareRendering ? RenderMode.SOFTWARE : RenderMode.HARDWARE;
    }

    public int getRepeatCount() {
        return this.animator.getRepeatCount();
    }

    @SuppressLint({"WrongConstant"})
    public int getRepeatMode() {
        return this.animator.getRepeatMode();
    }

    public float getSpeed() {
        return this.animator.getSpeed();
    }

    public TextDelegate getTextDelegate() {
        return this.textDelegate;
    }

    public Typeface getTypeface(Font font0) {
        Map map0 = this.fontMap;
        if(map0 != null) {
            String s = font0.getFamily();
            if(map0.containsKey(s)) {
                return (Typeface)map0.get(s);
            }
            String s1 = font0.getName();
            if(map0.containsKey(s1)) {
                return (Typeface)map0.get(s1);
            }
            String s2 = font0.getFamily() + "-" + font0.getStyle();
            if(map0.containsKey(s2)) {
                return (Typeface)map0.get(s2);
            }
        }
        FontAssetManager fontAssetManager0 = this.getFontAssetManager();
        return fontAssetManager0 == null ? null : fontAssetManager0.getTypeface(font0);
    }

    public boolean hasMasks() {
        return this.compositionLayer != null && this.compositionLayer.hasMasks();
    }

    public boolean hasMatte() {
        return this.compositionLayer != null && this.compositionLayer.hasMatte();
    }

    private boolean ignoreCanvasClipBounds() {
        Drawable.Callback drawable$Callback0 = this.getCallback();
        if(!(drawable$Callback0 instanceof View)) {
            return false;
        }
        ViewParent viewParent0 = ((View)drawable$Callback0).getParent();
        return viewParent0 instanceof ViewGroup ? !((ViewGroup)viewParent0).getClipChildren() : false;
    }

    @Override  // android.graphics.drawable.Drawable$Callback
    public void invalidateDrawable(Drawable drawable0) {
        Drawable.Callback drawable$Callback0 = this.getCallback();
        if(drawable$Callback0 == null) {
            return;
        }
        drawable$Callback0.invalidateDrawable(this);
    }

    @Override  // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if(!this.isDirty) {
            this.isDirty = true;
            if(!LottieDrawable.invalidateSelfOnMainThread || Looper.getMainLooper() == Looper.myLooper()) {
                Drawable.Callback drawable$Callback0 = this.getCallback();
                if(drawable$Callback0 != null) {
                    drawable$Callback0.invalidateDrawable(this);
                }
            }
        }
    }

    public boolean isAnimating() {
        return this.animator == null ? false : this.animator.isRunning();
    }

    // 去混淆评级： 低(20)
    public boolean isAnimatingOrWillAnimateOnVisible() {
        return this.isVisible() ? this.animator.isRunning() : this.onVisibleAction == OnVisibleAction.PLAY || this.onVisibleAction == OnVisibleAction.RESUME;
    }

    public boolean isApplyingOpacityToLayersEnabled() {
        return this.isApplyingOpacityToLayersEnabled;
    }

    public boolean isApplyingShadowToLayersEnabled() {
        return this.isApplyingShadowToLayersEnabled;
    }

    public boolean isFeatureFlagEnabled(LottieFeatureFlag lottieFeatureFlag0) {
        return this.lottieFeatureFlags.isFlagEnabled(lottieFeatureFlag0);
    }

    public boolean isLooping() {
        return this.animator.getRepeatCount() == -1;
    }

    @Deprecated
    public boolean isMergePathsEnabledForKitKatAndAbove() {
        return this.lottieFeatureFlags.isFlagEnabled(LottieFeatureFlag.MergePathsApi19);
    }

    @Override  // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.isAnimating();
    }

    private void lambda$addValueCallback$17(KeyPath keyPath0, Object object0, LottieValueCallback lottieValueCallback0, LottieComposition lottieComposition0) {
        this.addValueCallback(keyPath0, object0, lottieValueCallback0);
    }

    private void lambda$new$0(ValueAnimator valueAnimator0) {
        if(this.getAsyncUpdatesEnabled()) {
            this.invalidateSelf();
            return;
        }
        CompositionLayer compositionLayer0 = this.compositionLayer;
        if(compositionLayer0 != null) {
            compositionLayer0.setProgress(this.animator.getAnimatedValueAbsolute());
        }
    }

    private void lambda$new$1() {
        Drawable.Callback drawable$Callback0 = this.getCallback();
        if(drawable$Callback0 != null) {
            drawable$Callback0.invalidateDrawable(this);
        }
    }

    private void lambda$new$2() {
        CompositionLayer compositionLayer0 = this.compositionLayer;
        if(compositionLayer0 == null) {
            return;
        }
        try {
            this.setProgressDrawLock.acquire();
            compositionLayer0.setProgress(this.animator.getAnimatedValueAbsolute());
            if(LottieDrawable.invalidateSelfOnMainThread && this.isDirty) {
                if(this.mainThreadHandler == null) {
                    this.mainThreadHandler = new Handler(Looper.getMainLooper());
                    this.invalidateSelfRunnable = new r(this, 0);
                }
                this.mainThreadHandler.post(this.invalidateSelfRunnable);
            }
        }
        catch(InterruptedException unused_ex) {
        }
        finally {
            this.setProgressDrawLock.release();
        }
    }

    private void lambda$playAnimation$3(LottieComposition lottieComposition0) {
        this.playAnimation();
    }

    private void lambda$resumeAnimation$4(LottieComposition lottieComposition0) {
        this.resumeAnimation();
    }

    private void lambda$setFrame$15(int v, LottieComposition lottieComposition0) {
        this.setFrame(v);
    }

    private void lambda$setMaxFrame$10(String s, LottieComposition lottieComposition0) {
        this.setMaxFrame(s);
    }

    private void lambda$setMaxFrame$7(int v, LottieComposition lottieComposition0) {
        this.setMaxFrame(v);
    }

    private void lambda$setMaxProgress$8(float f, LottieComposition lottieComposition0) {
        this.setMaxProgress(f);
    }

    private void lambda$setMinAndMaxFrame$11(String s, LottieComposition lottieComposition0) {
        this.setMinAndMaxFrame(s);
    }

    private void lambda$setMinAndMaxFrame$12(String s, String s1, boolean z, LottieComposition lottieComposition0) {
        this.setMinAndMaxFrame(s, s1, z);
    }

    private void lambda$setMinAndMaxFrame$13(int v, int v1, LottieComposition lottieComposition0) {
        this.setMinAndMaxFrame(v, v1);
    }

    private void lambda$setMinAndMaxProgress$14(float f, float f1, LottieComposition lottieComposition0) {
        this.setMinAndMaxProgress(f, f1);
    }

    private void lambda$setMinFrame$5(int v, LottieComposition lottieComposition0) {
        this.setMinFrame(v);
    }

    private void lambda$setMinFrame$9(String s, LottieComposition lottieComposition0) {
        this.setMinFrame(s);
    }

    private void lambda$setMinProgress$6(float f, LottieComposition lottieComposition0) {
        this.setMinProgress(f);
    }

    private void lambda$setProgress$16(float f, LottieComposition lottieComposition0) {
        this.setProgress(f);
    }

    @Deprecated
    public void loop(boolean z) {
        this.animator.setRepeatCount((z ? -1 : 0));
    }

    public void pauseAnimation() {
        this.lazyCompositionTasks.clear();
        this.animator.pauseAnimation();
        if(!this.isVisible()) {
            this.onVisibleAction = OnVisibleAction.NONE;
        }
    }

    public void playAnimation() {
        if(this.compositionLayer == null) {
            s s0 = new s(this, 1);
            this.lazyCompositionTasks.add(s0);
            return;
        }
        this.computeRenderMode();
        if(this.animationsEnabled(this.getContext()) || this.getRepeatCount() == 0) {
            if(this.isVisible()) {
                this.animator.playAnimation();
                this.onVisibleAction = OnVisibleAction.NONE;
            }
            else {
                this.onVisibleAction = OnVisibleAction.PLAY;
            }
        }
        if(!this.animationsEnabled(this.getContext())) {
            Marker marker0 = this.getMarkerForAnimationsDisabled();
            if(marker0 == null) {
                this.setFrame(((int)(this.getSpeed() < 0.0f ? this.getMinFrame() : this.getMaxFrame())));
            }
            else {
                this.setFrame(((int)marker0.startFrame));
            }
            this.animator.endAnimation();
            if(!this.isVisible()) {
                this.onVisibleAction = OnVisibleAction.NONE;
            }
        }
    }

    public void removeAllAnimatorListeners() {
        this.animator.removeAllListeners();
    }

    public void removeAllUpdateListeners() {
        this.animator.removeAllUpdateListeners();
        this.animator.addUpdateListener(this.progressUpdateListener);
    }

    public void removeAnimatorListener(Animator.AnimatorListener animator$AnimatorListener0) {
        this.animator.removeListener(animator$AnimatorListener0);
    }

    public void removeAnimatorPauseListener(Animator.AnimatorPauseListener animator$AnimatorPauseListener0) {
        this.animator.removePauseListener(animator$AnimatorPauseListener0);
    }

    public void removeAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener valueAnimator$AnimatorUpdateListener0) {
        this.animator.removeUpdateListener(valueAnimator$AnimatorUpdateListener0);
    }

    private void renderAndDrawAsBitmap(Canvas canvas0, CompositionLayer compositionLayer0) {
        if(this.composition != null && compositionLayer0 != null) {
            this.ensureSoftwareRenderingObjectsInitialized();
            canvas0.getMatrix(this.softwareRenderingOriginalCanvasMatrix);
            canvas0.getClipBounds(this.canvasClipBounds);
            this.convertRect(this.canvasClipBounds, this.canvasClipBoundsRectF);
            this.softwareRenderingOriginalCanvasMatrix.mapRect(this.canvasClipBoundsRectF);
            this.convertRect(this.canvasClipBoundsRectF, this.canvasClipBounds);
            if(this.clipToCompositionBounds) {
                this.softwareRenderingTransformedBounds.set(0.0f, 0.0f, ((float)this.getIntrinsicWidth()), ((float)this.getIntrinsicHeight()));
            }
            else {
                compositionLayer0.getBounds(this.softwareRenderingTransformedBounds, null, false);
            }
            this.softwareRenderingOriginalCanvasMatrix.mapRect(this.softwareRenderingTransformedBounds);
            Rect rect0 = this.getBounds();
            float f = ((float)rect0.width()) / ((float)this.getIntrinsicWidth());
            float f1 = ((float)rect0.height()) / ((float)this.getIntrinsicHeight());
            this.scaleRect(this.softwareRenderingTransformedBounds, f, f1);
            if(!this.ignoreCanvasClipBounds()) {
                this.softwareRenderingTransformedBounds.intersect(((float)this.canvasClipBounds.left), ((float)this.canvasClipBounds.top), ((float)this.canvasClipBounds.right), ((float)this.canvasClipBounds.bottom));
            }
            int v = (int)Math.ceil(this.softwareRenderingTransformedBounds.width());
            int v1 = (int)Math.ceil(this.softwareRenderingTransformedBounds.height());
            if(v > 0 && v1 > 0) {
                this.ensureSoftwareRenderingBitmap(v, v1);
                if(this.isDirty) {
                    this.softwareRenderingOriginalCanvasMatrix.getValues(this.softwareRenderingOriginalCanvasMatrixElements);
                    float[] arr_f = this.softwareRenderingOriginalCanvasMatrixElements;
                    float f2 = arr_f[0];
                    float f3 = arr_f[4];
                    this.renderingMatrix.set(this.softwareRenderingOriginalCanvasMatrix);
                    this.renderingMatrix.preScale(f, f1);
                    this.renderingMatrix.postTranslate(-this.softwareRenderingTransformedBounds.left, -this.softwareRenderingTransformedBounds.top);
                    this.renderingMatrix.postScale(1.0f / f2, 1.0f / f3);
                    this.softwareRenderingBitmap.eraseColor(0);
                    this.softwareRenderingCanvas.setMatrix(Utils.IDENTITY_MATRIX);
                    this.softwareRenderingCanvas.scale(f2, f3);
                    compositionLayer0.draw(this.softwareRenderingCanvas, this.renderingMatrix, this.alpha, null);
                    this.softwareRenderingOriginalCanvasMatrix.invert(this.softwareRenderingOriginalCanvasMatrixInverse);
                    this.softwareRenderingOriginalCanvasMatrixInverse.mapRect(this.softwareRenderingDstBoundsRectF, this.softwareRenderingTransformedBounds);
                    this.convertRect(this.softwareRenderingDstBoundsRectF, this.softwareRenderingDstBoundsRect);
                }
                this.softwareRenderingSrcBoundsRect.set(0, 0, v, v1);
                canvas0.drawBitmap(this.softwareRenderingBitmap, this.softwareRenderingSrcBoundsRect, this.softwareRenderingDstBoundsRect, this.softwareRenderingPaint);
            }
        }
    }

    public List resolveKeyPath(KeyPath keyPath0) {
        if(this.compositionLayer == null) {
            Logger.warning("Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.EMPTY_LIST;
        }
        List list0 = new ArrayList();
        this.compositionLayer.resolveKeyPath(keyPath0, 0, list0, new KeyPath(new String[0]));
        return list0;
    }

    public void resumeAnimation() {
        if(this.compositionLayer == null) {
            s s0 = new s(this, 0);
            this.lazyCompositionTasks.add(s0);
            return;
        }
        this.computeRenderMode();
        if(this.animationsEnabled(this.getContext()) || this.getRepeatCount() == 0) {
            if(this.isVisible()) {
                this.animator.resumeAnimation();
                this.onVisibleAction = OnVisibleAction.NONE;
            }
            else {
                this.onVisibleAction = OnVisibleAction.RESUME;
            }
        }
        if(!this.animationsEnabled(this.getContext())) {
            this.setFrame(((int)(this.getSpeed() < 0.0f ? this.getMinFrame() : this.getMaxFrame())));
            this.animator.endAnimation();
            if(!this.isVisible()) {
                this.onVisibleAction = OnVisibleAction.NONE;
            }
        }
    }

    public void reverseAnimationSpeed() {
        this.animator.reverseAnimationSpeed();
    }

    private void scaleRect(RectF rectF0, float f, float f1) {
        rectF0.set(rectF0.left * f, rectF0.top * f1, rectF0.right * f, rectF0.bottom * f1);
    }

    @Override  // android.graphics.drawable.Drawable$Callback
    public void scheduleDrawable(Drawable drawable0, Runnable runnable0, long v) {
        Drawable.Callback drawable$Callback0 = this.getCallback();
        if(drawable$Callback0 == null) {
            return;
        }
        drawable$Callback0.scheduleDrawable(this, runnable0, v);
    }

    @Override  // android.graphics.drawable.Drawable
    public void setAlpha(int v) {
        this.alpha = v;
        this.invalidateSelf();
    }

    public void setApplyingOpacityToLayersEnabled(boolean z) {
        this.isApplyingOpacityToLayersEnabled = z;
    }

    public void setApplyingShadowToLayersEnabled(boolean z) {
        this.isApplyingShadowToLayersEnabled = z;
    }

    public void setAsyncUpdates(AsyncUpdates asyncUpdates0) {
        this.asyncUpdates = asyncUpdates0;
    }

    public void setClipTextToBoundingBox(boolean z) {
        if(z != this.clipTextToBoundingBox) {
            this.clipTextToBoundingBox = z;
            this.invalidateSelf();
        }
    }

    public void setClipToCompositionBounds(boolean z) {
        if(z != this.clipToCompositionBounds) {
            this.clipToCompositionBounds = z;
            CompositionLayer compositionLayer0 = this.compositionLayer;
            if(compositionLayer0 != null) {
                compositionLayer0.setClipToCompositionBounds(z);
            }
            this.invalidateSelf();
        }
    }

    @Override  // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter0) {
        Logger.warning("Use addColorFilter instead.");
    }

    public boolean setComposition(LottieComposition lottieComposition0) {
        if(this.composition == lottieComposition0) {
            return false;
        }
        this.isDirty = true;
        this.clearComposition();
        this.composition = lottieComposition0;
        this.buildCompositionLayer();
        this.animator.setComposition(lottieComposition0);
        this.setProgress(this.animator.getAnimatedFraction());
        Iterator iterator0 = new ArrayList(this.lazyCompositionTasks).iterator();
        while(iterator0.hasNext()) {
            Object object0 = iterator0.next();
            LazyCompositionTask lottieDrawable$LazyCompositionTask0 = (LazyCompositionTask)object0;
            if(lottieDrawable$LazyCompositionTask0 != null) {
                lottieDrawable$LazyCompositionTask0.run(lottieComposition0);
            }
            iterator0.remove();
        }
        this.lazyCompositionTasks.clear();
        lottieComposition0.setPerformanceTrackingEnabled(this.performanceTrackingEnabled);
        this.computeRenderMode();
        Drawable.Callback drawable$Callback0 = this.getCallback();
        if(drawable$Callback0 instanceof ImageView) {
            ((ImageView)drawable$Callback0).setImageDrawable(null);
            ((ImageView)drawable$Callback0).setImageDrawable(this);
        }
        return true;
    }

    public void setDefaultFontFileExtension(String s) {
        this.defaultFontFileExtension = s;
        FontAssetManager fontAssetManager0 = this.getFontAssetManager();
        if(fontAssetManager0 != null) {
            fontAssetManager0.setDefaultFontFileExtension(s);
        }
    }

    public void setFontAssetDelegate(FontAssetDelegate fontAssetDelegate0) {
        this.fontAssetDelegate = fontAssetDelegate0;
        FontAssetManager fontAssetManager0 = this.fontAssetManager;
        if(fontAssetManager0 != null) {
            fontAssetManager0.setDelegate(fontAssetDelegate0);
        }
    }

    public void setFontMap(Map map0) {
        if(map0 == this.fontMap) {
            return;
        }
        this.fontMap = map0;
        this.invalidateSelf();
    }

    public void setFrame(int v) {
        if(this.composition == null) {
            m m0 = new m(this, v, 0);
            this.lazyCompositionTasks.add(m0);
            return;
        }
        this.animator.setFrame(((float)v));
    }

    @Deprecated
    public void setIgnoreDisabledSystemAnimations(boolean z) {
        this.ignoreSystemAnimationsDisabled = z;
    }

    public void setImageAssetDelegate(ImageAssetDelegate imageAssetDelegate0) {
        this.imageAssetDelegate = imageAssetDelegate0;
        ImageAssetManager imageAssetManager0 = this.imageAssetManager;
        if(imageAssetManager0 != null) {
            imageAssetManager0.setDelegate(imageAssetDelegate0);
        }
    }

    public void setImagesAssetsFolder(String s) {
        this.imageAssetsFolder = s;
    }

    public void setMaintainOriginalImageBounds(boolean z) {
        this.maintainOriginalImageBounds = z;
    }

    public void setMaxFrame(int v) {
        if(this.composition == null) {
            m m0 = new m(this, v, 1);
            this.lazyCompositionTasks.add(m0);
            return;
        }
        this.animator.setMaxFrame(((float)v) + 0.99f);
    }

    public void setMaxFrame(String s) {
        LottieComposition lottieComposition0 = this.composition;
        if(lottieComposition0 == null) {
            l l0 = new l(this, s, 1);
            this.lazyCompositionTasks.add(l0);
            return;
        }
        Marker marker0 = lottieComposition0.getMarker(s);
        if(marker0 == null) {
            throw new IllegalArgumentException("Cannot find marker with name " + s + ".");
        }
        this.setMaxFrame(((int)(marker0.startFrame + marker0.durationFrames)));
    }

    public void setMaxProgress(float f) {
        LottieComposition lottieComposition0 = this.composition;
        if(lottieComposition0 == null) {
            q q0 = new q(this, f, 0);
            this.lazyCompositionTasks.add(q0);
            return;
        }
        this.animator.setMaxFrame(MiscUtils.lerp(lottieComposition0.getStartFrame(), this.composition.getEndFrame(), f));
    }

    public void setMinAndMaxFrame(int v, int v1) {
        if(this.composition == null) {
            o o0 = new o(this, v, v1);
            this.lazyCompositionTasks.add(o0);
            return;
        }
        this.animator.setMinAndMaxFrames(((float)v), ((float)v1) + 0.99f);
    }

    public void setMinAndMaxFrame(String s) {
        LottieComposition lottieComposition0 = this.composition;
        if(lottieComposition0 == null) {
            l l0 = new l(this, s, 0);
            this.lazyCompositionTasks.add(l0);
            return;
        }
        Marker marker0 = lottieComposition0.getMarker(s);
        if(marker0 == null) {
            throw new IllegalArgumentException("Cannot find marker with name " + s + ".");
        }
        this.setMinAndMaxFrame(((int)marker0.startFrame), ((int)marker0.durationFrames) + ((int)marker0.startFrame));
    }

    public void setMinAndMaxFrame(String s, String s1, boolean z) {
        LottieComposition lottieComposition0 = this.composition;
        if(lottieComposition0 == null) {
            t t0 = new t(this, s, s1, z);
            this.lazyCompositionTasks.add(t0);
            return;
        }
        Marker marker0 = lottieComposition0.getMarker(s);
        if(marker0 == null) {
            throw new IllegalArgumentException("Cannot find marker with name " + s + ".");
        }
        int v = (int)marker0.startFrame;
        Marker marker1 = this.composition.getMarker(s1);
        if(marker1 == null) {
            throw new IllegalArgumentException("Cannot find marker with name " + s1 + ".");
        }
        this.setMinAndMaxFrame(v, ((int)(marker1.startFrame + (z ? 1.0f : 0.0f))));
    }

    public void setMinAndMaxProgress(float f, float f1) {
        LottieComposition lottieComposition0 = this.composition;
        if(lottieComposition0 == null) {
            n n0 = new n(this, f, f1);
            this.lazyCompositionTasks.add(n0);
            return;
        }
        this.setMinAndMaxFrame(((int)MiscUtils.lerp(lottieComposition0.getStartFrame(), this.composition.getEndFrame(), f)), ((int)MiscUtils.lerp(this.composition.getStartFrame(), this.composition.getEndFrame(), f1)));
    }

    public void setMinFrame(int v) {
        if(this.composition == null) {
            m m0 = new m(this, v, 2);
            this.lazyCompositionTasks.add(m0);
            return;
        }
        this.animator.setMinFrame(v);
    }

    public void setMinFrame(String s) {
        LottieComposition lottieComposition0 = this.composition;
        if(lottieComposition0 == null) {
            l l0 = new l(this, s, 2);
            this.lazyCompositionTasks.add(l0);
            return;
        }
        Marker marker0 = lottieComposition0.getMarker(s);
        if(marker0 == null) {
            throw new IllegalArgumentException("Cannot find marker with name " + s + ".");
        }
        this.setMinFrame(((int)marker0.startFrame));
    }

    public void setMinProgress(float f) {
        LottieComposition lottieComposition0 = this.composition;
        if(lottieComposition0 == null) {
            q q0 = new q(this, f, 1);
            this.lazyCompositionTasks.add(q0);
            return;
        }
        this.setMinFrame(((int)MiscUtils.lerp(lottieComposition0.getStartFrame(), this.composition.getEndFrame(), f)));
    }

    public void setOutlineMasksAndMattes(boolean z) {
        if(this.outlineMasksAndMattes != z) {
            this.outlineMasksAndMattes = z;
            CompositionLayer compositionLayer0 = this.compositionLayer;
            if(compositionLayer0 != null) {
                compositionLayer0.setOutlineMasksAndMattes(z);
            }
        }
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.performanceTrackingEnabled = z;
        LottieComposition lottieComposition0 = this.composition;
        if(lottieComposition0 != null) {
            lottieComposition0.setPerformanceTrackingEnabled(z);
        }
    }

    public void setProgress(float f) {
        if(this.composition == null) {
            q q0 = new q(this, f, 2);
            this.lazyCompositionTasks.add(q0);
            return;
        }
        this.animator.setFrame(this.composition.getFrameForProgress(f));
    }

    public void setRenderMode(RenderMode renderMode0) {
        this.renderMode = renderMode0;
        this.computeRenderMode();
    }

    public void setRepeatCount(int v) {
        this.animator.setRepeatCount(v);
    }

    public void setRepeatMode(int v) {
        this.animator.setRepeatMode(v);
    }

    public void setSafeMode(boolean z) {
        this.safeMode = z;
    }

    public void setSpeed(float f) {
        this.animator.setSpeed(f);
    }

    @Deprecated
    public void setSystemAnimationsAreEnabled(Boolean boolean0) {
        this.systemAnimationsEnabled = boolean0.booleanValue();
    }

    public void setTextDelegate(TextDelegate textDelegate0) {
        this.textDelegate = textDelegate0;
    }

    public void setUseCompositionFrameRate(boolean z) {
        this.animator.setUseCompositionFrameRate(z);
    }

    @Override  // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z1) {
        boolean z2 = this.isVisible();
        boolean z3 = super.setVisible(z, z1);
        if(z) {
            OnVisibleAction lottieDrawable$OnVisibleAction0 = this.onVisibleAction;
            if(lottieDrawable$OnVisibleAction0 == OnVisibleAction.PLAY) {
                this.playAnimation();
                return z3;
            }
            if(lottieDrawable$OnVisibleAction0 == OnVisibleAction.RESUME) {
                this.resumeAnimation();
                return z3;
            }
        }
        else {
            if(this.animator.isRunning()) {
                this.pauseAnimation();
                this.onVisibleAction = OnVisibleAction.RESUME;
                return z3;
            }
            if(z2) {
                this.onVisibleAction = OnVisibleAction.NONE;
            }
        }
        return z3;
    }

    private boolean shouldSetProgressBeforeDrawing() {
        LottieComposition lottieComposition0 = this.composition;
        if(lottieComposition0 == null) {
            return false;
        }
        float f = this.lastDrawnProgress;
        float f1 = this.animator.getAnimatedValueAbsolute();
        this.lastDrawnProgress = f1;
        return Math.abs(f1 - f) * lottieComposition0.getDuration() >= 50.0f;
    }

    @Override  // android.graphics.drawable.Animatable
    public void start() {
        Drawable.Callback drawable$Callback0 = this.getCallback();
        if(drawable$Callback0 instanceof View && ((View)drawable$Callback0).isInEditMode()) {
            return;
        }
        this.playAnimation();
    }

    @Override  // android.graphics.drawable.Animatable
    public void stop() {
        this.endAnimation();
    }

    @Override  // android.graphics.drawable.Drawable$Callback
    public void unscheduleDrawable(Drawable drawable0, Runnable runnable0) {
        Drawable.Callback drawable$Callback0 = this.getCallback();
        if(drawable$Callback0 == null) {
            return;
        }
        drawable$Callback0.unscheduleDrawable(this, runnable0);
    }

    public Bitmap updateBitmap(String s, Bitmap bitmap0) {
        ImageAssetManager imageAssetManager0 = this.getImageAssetManager();
        if(imageAssetManager0 == null) {
            Logger.warning("Cannot update bitmap. Most likely the drawable is not added to a View which prevents Lottie from getting a Context.");
            return null;
        }
        Bitmap bitmap1 = imageAssetManager0.updateBitmap(s, bitmap0);
        this.invalidateSelf();
        return bitmap1;
    }

    public boolean useTextGlyphs() {
        return this.fontMap == null && this.textDelegate == null && this.composition.getCharacters().c > 0;
    }
}

