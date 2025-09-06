package com.bumptech.glide.request;

import android.content.res.Resources.Theme;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.model.stream.HttpGlideUrlLoader;
import com.bumptech.glide.load.resource.bitmap.BitmapEncoder;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.CenterInside;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.load.resource.bitmap.DrawableTransformation;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import com.bumptech.glide.load.resource.drawable.ResourceDrawableDecoder;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawableTransformation;
import com.bumptech.glide.load.resource.gif.GifOptions;
import com.bumptech.glide.signature.EmptySignature;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.util.Map;

public abstract class BaseRequestOptions implements Cloneable {
    private static final int DISK_CACHE_STRATEGY = 4;
    private static final int ERROR_ID = 0x20;
    private static final int ERROR_PLACEHOLDER = 16;
    private static final int FALLBACK = 0x2000;
    private static final int FALLBACK_ID = 0x4000;
    private static final int IS_CACHEABLE = 0x100;
    private static final int ONLY_RETRIEVE_FROM_CACHE = 0x80000;
    private static final int OVERRIDE = 0x200;
    private static final int PLACEHOLDER = 0x40;
    private static final int PLACEHOLDER_ID = 0x80;
    private static final int PRIORITY = 8;
    private static final int RESOURCE_CLASS = 0x1000;
    private static final int SIGNATURE = 0x400;
    private static final int SIZE_MULTIPLIER = 2;
    private static final int THEME = 0x8000;
    private static final int TRANSFORMATION = 0x800;
    private static final int TRANSFORMATION_ALLOWED = 0x10000;
    private static final int TRANSFORMATION_REQUIRED = 0x20000;
    private static final int UNSET = -1;
    private static final int USE_ANIMATION_POOL = 0x100000;
    private static final int USE_UNLIMITED_SOURCE_GENERATORS_POOL = 0x40000;
    private DiskCacheStrategy diskCacheStrategy;
    private int errorId;
    private Drawable errorPlaceholder;
    private Drawable fallbackDrawable;
    private int fallbackId;
    private int fields;
    private boolean isAutoCloneEnabled;
    private boolean isCacheable;
    private boolean isLocked;
    private boolean isScaleOnlyOrNoTransform;
    private boolean isTransformationAllowed;
    private boolean isTransformationRequired;
    private boolean onlyRetrieveFromCache;
    private Options options;
    private int overrideHeight;
    private int overrideWidth;
    private Drawable placeholderDrawable;
    private int placeholderId;
    private Priority priority;
    private Class resourceClass;
    private Key signature;
    private float sizeMultiplier;
    private Resources.Theme theme;
    private Map transformations;
    private boolean useAnimationPool;
    private boolean useUnlimitedSourceGeneratorsPool;

    public BaseRequestOptions() {
        this.sizeMultiplier = 1.0f;
        this.diskCacheStrategy = DiskCacheStrategy.AUTOMATIC;
        this.priority = Priority.NORMAL;
        this.isCacheable = true;
        this.overrideHeight = -1;
        this.overrideWidth = -1;
        this.signature = EmptySignature.obtain();
        this.isTransformationAllowed = true;
        this.options = new Options();
        this.transformations = new CachedHashCodeArrayMap();
        this.resourceClass = Object.class;
        this.isScaleOnlyOrNoTransform = true;
    }

    public BaseRequestOptions apply(BaseRequestOptions baseRequestOptions0) {
        if(this.isAutoCloneEnabled) {
            return this.clone().apply(baseRequestOptions0);
        }
        if(BaseRequestOptions.isSet(baseRequestOptions0.fields, 2)) {
            this.sizeMultiplier = baseRequestOptions0.sizeMultiplier;
        }
        if(BaseRequestOptions.isSet(baseRequestOptions0.fields, 0x40000)) {
            this.useUnlimitedSourceGeneratorsPool = baseRequestOptions0.useUnlimitedSourceGeneratorsPool;
        }
        if(BaseRequestOptions.isSet(baseRequestOptions0.fields, 0x100000)) {
            this.useAnimationPool = baseRequestOptions0.useAnimationPool;
        }
        if(BaseRequestOptions.isSet(baseRequestOptions0.fields, 4)) {
            this.diskCacheStrategy = baseRequestOptions0.diskCacheStrategy;
        }
        if(BaseRequestOptions.isSet(baseRequestOptions0.fields, 8)) {
            this.priority = baseRequestOptions0.priority;
        }
        if(BaseRequestOptions.isSet(baseRequestOptions0.fields, 16)) {
            this.errorPlaceholder = baseRequestOptions0.errorPlaceholder;
            this.errorId = 0;
            this.fields &= -33;
        }
        if(BaseRequestOptions.isSet(baseRequestOptions0.fields, 0x20)) {
            this.errorId = baseRequestOptions0.errorId;
            this.errorPlaceholder = null;
            this.fields &= -17;
        }
        if(BaseRequestOptions.isSet(baseRequestOptions0.fields, 0x40)) {
            this.placeholderDrawable = baseRequestOptions0.placeholderDrawable;
            this.placeholderId = 0;
            this.fields &= 0xFFFFFF7F;
        }
        if(BaseRequestOptions.isSet(baseRequestOptions0.fields, 0x80)) {
            this.placeholderId = baseRequestOptions0.placeholderId;
            this.placeholderDrawable = null;
            this.fields &= -65;
        }
        if(BaseRequestOptions.isSet(baseRequestOptions0.fields, 0x100)) {
            this.isCacheable = baseRequestOptions0.isCacheable;
        }
        if(BaseRequestOptions.isSet(baseRequestOptions0.fields, 0x200)) {
            this.overrideWidth = baseRequestOptions0.overrideWidth;
            this.overrideHeight = baseRequestOptions0.overrideHeight;
        }
        if(BaseRequestOptions.isSet(baseRequestOptions0.fields, 0x400)) {
            this.signature = baseRequestOptions0.signature;
        }
        if(BaseRequestOptions.isSet(baseRequestOptions0.fields, 0x1000)) {
            this.resourceClass = baseRequestOptions0.resourceClass;
        }
        if(BaseRequestOptions.isSet(baseRequestOptions0.fields, 0x2000)) {
            this.fallbackDrawable = baseRequestOptions0.fallbackDrawable;
            this.fallbackId = 0;
            this.fields &= 0xFFFFBFFF;
        }
        if(BaseRequestOptions.isSet(baseRequestOptions0.fields, 0x4000)) {
            this.fallbackId = baseRequestOptions0.fallbackId;
            this.fallbackDrawable = null;
            this.fields &= 0xFFFFDFFF;
        }
        if(BaseRequestOptions.isSet(baseRequestOptions0.fields, 0x8000)) {
            this.theme = baseRequestOptions0.theme;
        }
        if(BaseRequestOptions.isSet(baseRequestOptions0.fields, 0x10000)) {
            this.isTransformationAllowed = baseRequestOptions0.isTransformationAllowed;
        }
        if(BaseRequestOptions.isSet(baseRequestOptions0.fields, 0x20000)) {
            this.isTransformationRequired = baseRequestOptions0.isTransformationRequired;
        }
        if(BaseRequestOptions.isSet(baseRequestOptions0.fields, 0x800)) {
            this.transformations.putAll(baseRequestOptions0.transformations);
            this.isScaleOnlyOrNoTransform = baseRequestOptions0.isScaleOnlyOrNoTransform;
        }
        if(BaseRequestOptions.isSet(baseRequestOptions0.fields, 0x80000)) {
            this.onlyRetrieveFromCache = baseRequestOptions0.onlyRetrieveFromCache;
        }
        if(!this.isTransformationAllowed) {
            this.transformations.clear();
            this.isTransformationRequired = false;
            this.fields &= 0xFFFDF7FF;
            this.isScaleOnlyOrNoTransform = true;
        }
        this.fields |= baseRequestOptions0.fields;
        this.options.putAll(baseRequestOptions0.options);
        return this.selfOrThrowIfLocked();
    }

    public BaseRequestOptions autoClone() {
        if(this.isLocked && !this.isAutoCloneEnabled) {
            throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
        }
        this.isAutoCloneEnabled = true;
        return this.lock();
    }

    public BaseRequestOptions centerCrop() {
        CenterCrop centerCrop0 = new CenterCrop();
        return this.transform(DownsampleStrategy.CENTER_OUTSIDE, centerCrop0);
    }

    public BaseRequestOptions centerInside() {
        CenterInside centerInside0 = new CenterInside();
        return this.scaleOnlyTransform(DownsampleStrategy.CENTER_INSIDE, centerInside0);
    }

    public BaseRequestOptions circleCrop() {
        CircleCrop circleCrop0 = new CircleCrop();
        return this.transform(DownsampleStrategy.CENTER_INSIDE, circleCrop0);
    }

    public BaseRequestOptions clone() {
        try {
            BaseRequestOptions baseRequestOptions0 = (BaseRequestOptions)super.clone();
            Options options0 = new Options();
            baseRequestOptions0.options = options0;
            options0.putAll(this.options);
            CachedHashCodeArrayMap cachedHashCodeArrayMap0 = new CachedHashCodeArrayMap();
            baseRequestOptions0.transformations = cachedHashCodeArrayMap0;
            cachedHashCodeArrayMap0.putAll(this.transformations);
            baseRequestOptions0.isLocked = false;
            baseRequestOptions0.isAutoCloneEnabled = false;
            return baseRequestOptions0;
        }
        catch(CloneNotSupportedException cloneNotSupportedException0) {
            throw new RuntimeException(cloneNotSupportedException0);
        }
    }

    @Override
    public Object clone() {
        return this.clone();
    }

    public BaseRequestOptions decode(Class class0) {
        if(this.isAutoCloneEnabled) {
            return this.clone().decode(class0);
        }
        this.resourceClass = (Class)Preconditions.checkNotNull(class0);
        this.fields |= 0x1000;
        return this.selfOrThrowIfLocked();
    }

    public BaseRequestOptions disallowHardwareConfig() {
        return this.set(Downsampler.ALLOW_HARDWARE_CONFIG, Boolean.FALSE);
    }

    public BaseRequestOptions diskCacheStrategy(DiskCacheStrategy diskCacheStrategy0) {
        if(this.isAutoCloneEnabled) {
            return this.clone().diskCacheStrategy(diskCacheStrategy0);
        }
        this.diskCacheStrategy = (DiskCacheStrategy)Preconditions.checkNotNull(diskCacheStrategy0);
        this.fields |= 4;
        return this.selfOrThrowIfLocked();
    }

    public BaseRequestOptions dontAnimate() {
        return this.set(GifOptions.DISABLE_ANIMATION, Boolean.TRUE);
    }

    public BaseRequestOptions dontTransform() {
        if(this.isAutoCloneEnabled) {
            return this.clone().dontTransform();
        }
        this.transformations.clear();
        this.isTransformationRequired = false;
        this.isTransformationAllowed = false;
        this.fields = this.fields & 0xFFFDF7FF | 0x10000;
        this.isScaleOnlyOrNoTransform = true;
        return this.selfOrThrowIfLocked();
    }

    public BaseRequestOptions downsample(DownsampleStrategy downsampleStrategy0) {
        Object object0 = Preconditions.checkNotNull(downsampleStrategy0);
        return this.set(DownsampleStrategy.OPTION, object0);
    }

    public BaseRequestOptions encodeFormat(Bitmap.CompressFormat bitmap$CompressFormat0) {
        Object object0 = Preconditions.checkNotNull(bitmap$CompressFormat0);
        return this.set(BitmapEncoder.COMPRESSION_FORMAT, object0);
    }

    public BaseRequestOptions encodeQuality(int v) {
        return this.set(BitmapEncoder.COMPRESSION_QUALITY, v);
    }

    // 去混淆评级： 低(20)
    @Override
    public boolean equals(Object object0) {
        return object0 instanceof BaseRequestOptions ? this.isEquivalentTo(((BaseRequestOptions)object0)) : false;
    }

    public BaseRequestOptions error(int v) {
        if(this.isAutoCloneEnabled) {
            return this.clone().error(v);
        }
        this.errorId = v;
        this.errorPlaceholder = null;
        this.fields = (this.fields | 0x20) & -17;
        return this.selfOrThrowIfLocked();
    }

    public BaseRequestOptions error(Drawable drawable0) {
        if(this.isAutoCloneEnabled) {
            return this.clone().error(drawable0);
        }
        this.errorPlaceholder = drawable0;
        this.errorId = 0;
        this.fields = (this.fields | 16) & -33;
        return this.selfOrThrowIfLocked();
    }

    public BaseRequestOptions fallback(int v) {
        if(this.isAutoCloneEnabled) {
            return this.clone().fallback(v);
        }
        this.fallbackId = v;
        this.fallbackDrawable = null;
        this.fields = (this.fields | 0x4000) & 0xFFFFDFFF;
        return this.selfOrThrowIfLocked();
    }

    public BaseRequestOptions fallback(Drawable drawable0) {
        if(this.isAutoCloneEnabled) {
            return this.clone().fallback(drawable0);
        }
        this.fallbackDrawable = drawable0;
        this.fallbackId = 0;
        this.fields = (this.fields | 0x2000) & 0xFFFFBFFF;
        return this.selfOrThrowIfLocked();
    }

    public BaseRequestOptions fitCenter() {
        FitCenter fitCenter0 = new FitCenter();
        return this.scaleOnlyTransform(DownsampleStrategy.FIT_CENTER, fitCenter0);
    }

    public BaseRequestOptions format(DecodeFormat decodeFormat0) {
        Preconditions.checkNotNull(decodeFormat0);
        return this.set(Downsampler.DECODE_FORMAT, decodeFormat0).set(GifOptions.DECODE_FORMAT, decodeFormat0);
    }

    public BaseRequestOptions frame(long v) {
        return this.set(VideoDecoder.TARGET_FRAME, v);
    }

    public final DiskCacheStrategy getDiskCacheStrategy() {
        return this.diskCacheStrategy;
    }

    public final int getErrorId() {
        return this.errorId;
    }

    public final Drawable getErrorPlaceholder() {
        return this.errorPlaceholder;
    }

    public final Drawable getFallbackDrawable() {
        return this.fallbackDrawable;
    }

    public final int getFallbackId() {
        return this.fallbackId;
    }

    public final boolean getOnlyRetrieveFromCache() {
        return this.onlyRetrieveFromCache;
    }

    public final Options getOptions() {
        return this.options;
    }

    public final int getOverrideHeight() {
        return this.overrideHeight;
    }

    public final int getOverrideWidth() {
        return this.overrideWidth;
    }

    public final Drawable getPlaceholderDrawable() {
        return this.placeholderDrawable;
    }

    public final int getPlaceholderId() {
        return this.placeholderId;
    }

    public final Priority getPriority() {
        return this.priority;
    }

    public final Class getResourceClass() {
        return this.resourceClass;
    }

    public final Key getSignature() {
        return this.signature;
    }

    public final float getSizeMultiplier() {
        return this.sizeMultiplier;
    }

    public final Resources.Theme getTheme() {
        return this.theme;
    }

    public final Map getTransformations() {
        return this.transformations;
    }

    public final boolean getUseAnimationPool() {
        return this.useAnimationPool;
    }

    public final boolean getUseUnlimitedSourceGeneratorsPool() {
        return this.useUnlimitedSourceGeneratorsPool;
    }

    @Override
    public int hashCode() {
        return Util.hashCode(this.theme, Util.hashCode(this.signature, Util.hashCode(this.resourceClass, Util.hashCode(this.transformations, Util.hashCode(this.options, Util.hashCode(this.priority, Util.hashCode(this.diskCacheStrategy, Util.hashCode(this.onlyRetrieveFromCache, Util.hashCode(this.useUnlimitedSourceGeneratorsPool, Util.hashCode(this.isTransformationAllowed, Util.hashCode(this.isTransformationRequired, (Util.hashCode(this.isCacheable, Util.hashCode(this.fallbackDrawable, Util.hashCode(this.placeholderDrawable, Util.hashCode(this.errorPlaceholder, Util.hashCode(this.sizeMultiplier) * 0x1F + this.errorId) * 0x1F + this.placeholderId) * 0x1F + this.fallbackId)) * 0x1F + this.overrideHeight) * 0x1F + this.overrideWidth)))))))))));
    }

    public final boolean isAutoCloneEnabled() {
        return this.isAutoCloneEnabled;
    }

    public final boolean isDiskCacheStrategySet() {
        return this.isSet(4);
    }

    // 去混淆评级： 中等(90)
    public final boolean isEquivalentTo(BaseRequestOptions baseRequestOptions0) {
        return Float.compare(baseRequestOptions0.sizeMultiplier, this.sizeMultiplier) == 0 && this.errorId == baseRequestOptions0.errorId && Util.bothNullOrEqual(this.errorPlaceholder, baseRequestOptions0.errorPlaceholder) && this.placeholderId == baseRequestOptions0.placeholderId && Util.bothNullOrEqual(this.placeholderDrawable, baseRequestOptions0.placeholderDrawable) && this.fallbackId == baseRequestOptions0.fallbackId && Util.bothNullOrEqual(this.fallbackDrawable, baseRequestOptions0.fallbackDrawable) && this.isCacheable == baseRequestOptions0.isCacheable && this.overrideHeight == baseRequestOptions0.overrideHeight && this.overrideWidth == baseRequestOptions0.overrideWidth && this.isTransformationRequired == baseRequestOptions0.isTransformationRequired && this.isTransformationAllowed == baseRequestOptions0.isTransformationAllowed && this.useUnlimitedSourceGeneratorsPool == baseRequestOptions0.useUnlimitedSourceGeneratorsPool && this.onlyRetrieveFromCache == baseRequestOptions0.onlyRetrieveFromCache && this.diskCacheStrategy.equals(baseRequestOptions0.diskCacheStrategy) && this.priority == baseRequestOptions0.priority && this.options.equals(baseRequestOptions0.options) && this.transformations.equals(baseRequestOptions0.transformations) && this.resourceClass.equals(baseRequestOptions0.resourceClass) && Util.bothNullOrEqual(this.signature, baseRequestOptions0.signature) && Util.bothNullOrEqual(this.theme, baseRequestOptions0.theme);
    }

    public final boolean isLocked() {
        return this.isLocked;
    }

    public final boolean isMemoryCacheable() {
        return this.isCacheable;
    }

    public final boolean isPrioritySet() {
        return this.isSet(8);
    }

    public boolean isScaleOnlyOrNoTransform() {
        return this.isScaleOnlyOrNoTransform;
    }

    private boolean isSet(int v) {
        return BaseRequestOptions.isSet(this.fields, v);
    }

    private static boolean isSet(int v, int v1) {
        return (v & v1) != 0;
    }

    public final boolean isSkipMemoryCacheSet() {
        return this.isSet(0x100);
    }

    public final boolean isTransformationAllowed() {
        return this.isTransformationAllowed;
    }

    public final boolean isTransformationRequired() {
        return this.isTransformationRequired;
    }

    public final boolean isTransformationSet() {
        return this.isSet(0x800);
    }

    public final boolean isValidOverride() {
        return Util.isValidDimensions(this.overrideWidth, this.overrideHeight);
    }

    public BaseRequestOptions lock() {
        this.isLocked = true;
        return this;
    }

    public BaseRequestOptions onlyRetrieveFromCache(boolean z) {
        if(this.isAutoCloneEnabled) {
            return this.clone().onlyRetrieveFromCache(z);
        }
        this.onlyRetrieveFromCache = z;
        this.fields |= 0x80000;
        return this.selfOrThrowIfLocked();
    }

    public BaseRequestOptions optionalCenterCrop() {
        CenterCrop centerCrop0 = new CenterCrop();
        return this.optionalTransform(DownsampleStrategy.CENTER_OUTSIDE, centerCrop0);
    }

    public BaseRequestOptions optionalCenterInside() {
        CenterInside centerInside0 = new CenterInside();
        return this.optionalScaleOnlyTransform(DownsampleStrategy.CENTER_INSIDE, centerInside0);
    }

    public BaseRequestOptions optionalCircleCrop() {
        CircleCrop circleCrop0 = new CircleCrop();
        return this.optionalTransform(DownsampleStrategy.CENTER_OUTSIDE, circleCrop0);
    }

    public BaseRequestOptions optionalFitCenter() {
        FitCenter fitCenter0 = new FitCenter();
        return this.optionalScaleOnlyTransform(DownsampleStrategy.FIT_CENTER, fitCenter0);
    }

    private BaseRequestOptions optionalScaleOnlyTransform(DownsampleStrategy downsampleStrategy0, Transformation transformation0) {
        return this.scaleOnlyTransform(downsampleStrategy0, transformation0, false);
    }

    public BaseRequestOptions optionalTransform(Transformation transformation0) {
        return this.transform(transformation0, false);
    }

    public final BaseRequestOptions optionalTransform(DownsampleStrategy downsampleStrategy0, Transformation transformation0) {
        if(this.isAutoCloneEnabled) {
            return this.clone().optionalTransform(downsampleStrategy0, transformation0);
        }
        this.downsample(downsampleStrategy0);
        return this.transform(transformation0, false);
    }

    public BaseRequestOptions optionalTransform(Class class0, Transformation transformation0) {
        return this.transform(class0, transformation0, false);
    }

    public BaseRequestOptions override(int v) {
        return this.override(v, v);
    }

    public BaseRequestOptions override(int v, int v1) {
        if(this.isAutoCloneEnabled) {
            return this.clone().override(v, v1);
        }
        this.overrideWidth = v;
        this.overrideHeight = v1;
        this.fields |= 0x200;
        return this.selfOrThrowIfLocked();
    }

    public BaseRequestOptions placeholder(int v) {
        if(this.isAutoCloneEnabled) {
            return this.clone().placeholder(v);
        }
        this.placeholderId = v;
        this.placeholderDrawable = null;
        this.fields = (this.fields | 0x80) & -65;
        return this.selfOrThrowIfLocked();
    }

    public BaseRequestOptions placeholder(Drawable drawable0) {
        if(this.isAutoCloneEnabled) {
            return this.clone().placeholder(drawable0);
        }
        this.placeholderDrawable = drawable0;
        this.placeholderId = 0;
        this.fields = (this.fields | 0x40) & 0xFFFFFF7F;
        return this.selfOrThrowIfLocked();
    }

    public BaseRequestOptions priority(Priority priority0) {
        if(this.isAutoCloneEnabled) {
            return this.clone().priority(priority0);
        }
        this.priority = (Priority)Preconditions.checkNotNull(priority0);
        this.fields |= 8;
        return this.selfOrThrowIfLocked();
    }

    public BaseRequestOptions removeOption(Option option0) {
        if(this.isAutoCloneEnabled) {
            return this.clone().removeOption(option0);
        }
        this.options.remove(option0);
        return this.selfOrThrowIfLocked();
    }

    private BaseRequestOptions scaleOnlyTransform(DownsampleStrategy downsampleStrategy0, Transformation transformation0) {
        return this.scaleOnlyTransform(downsampleStrategy0, transformation0, true);
    }

    private BaseRequestOptions scaleOnlyTransform(DownsampleStrategy downsampleStrategy0, Transformation transformation0, boolean z) {
        BaseRequestOptions baseRequestOptions0 = z ? this.transform(downsampleStrategy0, transformation0) : this.optionalTransform(downsampleStrategy0, transformation0);
        baseRequestOptions0.isScaleOnlyOrNoTransform = true;
        return baseRequestOptions0;
    }

    private BaseRequestOptions self() [...] // Inlined contents

    public final BaseRequestOptions selfOrThrowIfLocked() {
        if(this.isLocked) {
            throw new IllegalStateException("You cannot modify locked T, consider clone()");
        }
        return this;
    }

    public BaseRequestOptions set(Option option0, Object object0) {
        if(this.isAutoCloneEnabled) {
            return this.clone().set(option0, object0);
        }
        Preconditions.checkNotNull(option0);
        Preconditions.checkNotNull(object0);
        this.options.set(option0, object0);
        return this.selfOrThrowIfLocked();
    }

    public BaseRequestOptions signature(Key key0) {
        if(this.isAutoCloneEnabled) {
            return this.clone().signature(key0);
        }
        this.signature = (Key)Preconditions.checkNotNull(key0);
        this.fields |= 0x400;
        return this.selfOrThrowIfLocked();
    }

    public BaseRequestOptions sizeMultiplier(float f) {
        if(this.isAutoCloneEnabled) {
            return this.clone().sizeMultiplier(f);
        }
        if(f < 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        this.sizeMultiplier = f;
        this.fields |= 2;
        return this.selfOrThrowIfLocked();
    }

    public BaseRequestOptions skipMemoryCache(boolean z) {
        if(this.isAutoCloneEnabled) {
            return this.clone().skipMemoryCache(true);
        }
        this.isCacheable = !z;
        this.fields |= 0x100;
        return this.selfOrThrowIfLocked();
    }

    public BaseRequestOptions theme(Resources.Theme resources$Theme0) {
        if(this.isAutoCloneEnabled) {
            return this.clone().theme(resources$Theme0);
        }
        this.theme = resources$Theme0;
        if(resources$Theme0 != null) {
            this.fields |= 0x8000;
            return this.set(ResourceDrawableDecoder.THEME, resources$Theme0);
        }
        this.fields &= 0xFFFF7FFF;
        return this.removeOption(ResourceDrawableDecoder.THEME);
    }

    public BaseRequestOptions timeout(int v) {
        return this.set(HttpGlideUrlLoader.TIMEOUT, v);
    }

    public BaseRequestOptions transform(Transformation transformation0) {
        return this.transform(transformation0, true);
    }

    public BaseRequestOptions transform(Transformation transformation0, boolean z) {
        if(this.isAutoCloneEnabled) {
            return this.clone().transform(transformation0, z);
        }
        DrawableTransformation drawableTransformation0 = new DrawableTransformation(transformation0, z);
        this.transform(Bitmap.class, transformation0, z);
        this.transform(Drawable.class, drawableTransformation0, z);
        this.transform(BitmapDrawable.class, drawableTransformation0, z);
        GifDrawableTransformation gifDrawableTransformation0 = new GifDrawableTransformation(transformation0);
        this.transform(GifDrawable.class, gifDrawableTransformation0, z);
        return this.selfOrThrowIfLocked();
    }

    public final BaseRequestOptions transform(DownsampleStrategy downsampleStrategy0, Transformation transformation0) {
        if(this.isAutoCloneEnabled) {
            return this.clone().transform(downsampleStrategy0, transformation0);
        }
        this.downsample(downsampleStrategy0);
        return this.transform(transformation0);
    }

    public BaseRequestOptions transform(Class class0, Transformation transformation0) {
        return this.transform(class0, transformation0, true);
    }

    public BaseRequestOptions transform(Class class0, Transformation transformation0, boolean z) {
        if(this.isAutoCloneEnabled) {
            return this.clone().transform(class0, transformation0, z);
        }
        Preconditions.checkNotNull(class0);
        Preconditions.checkNotNull(transformation0);
        this.transformations.put(class0, transformation0);
        int v = this.fields;
        this.isTransformationAllowed = true;
        this.fields = 0x10800 | v;
        this.isScaleOnlyOrNoTransform = false;
        if(z) {
            this.fields = v | 0x30800;
            this.isTransformationRequired = true;
        }
        return this.selfOrThrowIfLocked();
    }

    public BaseRequestOptions transform(Transformation[] arr_transformation) {
        if(arr_transformation.length > 1) {
            return this.transform(new MultiTransformation(arr_transformation), true);
        }
        return arr_transformation.length == 1 ? this.transform(arr_transformation[0]) : this.selfOrThrowIfLocked();
    }

    @Deprecated
    public BaseRequestOptions transforms(Transformation[] arr_transformation) {
        return this.transform(new MultiTransformation(arr_transformation), true);
    }

    public BaseRequestOptions useAnimationPool(boolean z) {
        if(this.isAutoCloneEnabled) {
            return this.clone().useAnimationPool(z);
        }
        this.useAnimationPool = z;
        this.fields |= 0x100000;
        return this.selfOrThrowIfLocked();
    }

    public BaseRequestOptions useUnlimitedSourceGeneratorsPool(boolean z) {
        if(this.isAutoCloneEnabled) {
            return this.clone().useUnlimitedSourceGeneratorsPool(z);
        }
        this.useUnlimitedSourceGeneratorsPool = z;
        this.fields |= 0x40000;
        return this.selfOrThrowIfLocked();
    }
}

