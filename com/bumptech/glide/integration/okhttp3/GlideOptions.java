package com.bumptech.glide.integration.okhttp3;

import android.content.res.Resources.Theme;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;

public final class GlideOptions extends RequestOptions implements Cloneable {
    private static GlideOptions centerCropTransform2;
    private static GlideOptions centerInsideTransform1;
    private static GlideOptions circleCropTransform3;
    private static GlideOptions fitCenterTransform0;
    private static GlideOptions noAnimation5;
    private static GlideOptions noTransformation4;

    public GlideOptions apply(BaseRequestOptions baseRequestOptions0) {
        return (GlideOptions)super.apply(baseRequestOptions0);
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions apply(BaseRequestOptions baseRequestOptions0) {
        return this.apply(baseRequestOptions0);
    }

    public GlideOptions autoClone() {
        return (GlideOptions)super.autoClone();
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions autoClone() {
        return this.autoClone();
    }

    public static GlideOptions bitmapTransform(Transformation transformation0) {
        return new GlideOptions().transform(transformation0);
    }

    public GlideOptions centerCrop() {
        return (GlideOptions)super.centerCrop();
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions centerCrop() {
        return this.centerCrop();
    }

    public static GlideOptions centerCropTransform() {
        if(GlideOptions.centerCropTransform2 == null) {
            GlideOptions.centerCropTransform2 = new GlideOptions().centerCrop().autoClone();
        }
        return GlideOptions.centerCropTransform2;
    }

    public GlideOptions centerInside() {
        return (GlideOptions)super.centerInside();
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions centerInside() {
        return this.centerInside();
    }

    public static GlideOptions centerInsideTransform() {
        if(GlideOptions.centerInsideTransform1 == null) {
            GlideOptions.centerInsideTransform1 = new GlideOptions().centerInside().autoClone();
        }
        return GlideOptions.centerInsideTransform1;
    }

    public GlideOptions circleCrop() {
        return (GlideOptions)super.circleCrop();
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions circleCrop() {
        return this.circleCrop();
    }

    public static GlideOptions circleCropTransform() {
        if(GlideOptions.circleCropTransform3 == null) {
            GlideOptions.circleCropTransform3 = new GlideOptions().circleCrop().autoClone();
        }
        return GlideOptions.circleCropTransform3;
    }

    public GlideOptions clone() {
        return (GlideOptions)super.clone();
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions clone() {
        return this.clone();
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public Object clone() {
        return this.clone();
    }

    public GlideOptions decode(Class class0) {
        return (GlideOptions)super.decode(class0);
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions decode(Class class0) {
        return this.decode(class0);
    }

    public static GlideOptions decodeTypeOf(Class class0) {
        return new GlideOptions().decode(class0);
    }

    public GlideOptions disallowHardwareConfig() {
        return (GlideOptions)super.disallowHardwareConfig();
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions disallowHardwareConfig() {
        return this.disallowHardwareConfig();
    }

    public GlideOptions diskCacheStrategy(DiskCacheStrategy diskCacheStrategy0) {
        return (GlideOptions)super.diskCacheStrategy(diskCacheStrategy0);
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions diskCacheStrategy(DiskCacheStrategy diskCacheStrategy0) {
        return this.diskCacheStrategy(diskCacheStrategy0);
    }

    public static GlideOptions diskCacheStrategyOf(DiskCacheStrategy diskCacheStrategy0) {
        return new GlideOptions().diskCacheStrategy(diskCacheStrategy0);
    }

    public GlideOptions dontAnimate() {
        return (GlideOptions)super.dontAnimate();
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions dontAnimate() {
        return this.dontAnimate();
    }

    public GlideOptions dontTransform() {
        return (GlideOptions)super.dontTransform();
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions dontTransform() {
        return this.dontTransform();
    }

    public GlideOptions downsample(DownsampleStrategy downsampleStrategy0) {
        return (GlideOptions)super.downsample(downsampleStrategy0);
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions downsample(DownsampleStrategy downsampleStrategy0) {
        return this.downsample(downsampleStrategy0);
    }

    public static GlideOptions downsampleOf(DownsampleStrategy downsampleStrategy0) {
        return new GlideOptions().downsample(downsampleStrategy0);
    }

    public GlideOptions encodeFormat(Bitmap.CompressFormat bitmap$CompressFormat0) {
        return (GlideOptions)super.encodeFormat(bitmap$CompressFormat0);
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions encodeFormat(Bitmap.CompressFormat bitmap$CompressFormat0) {
        return this.encodeFormat(bitmap$CompressFormat0);
    }

    public static GlideOptions encodeFormatOf(Bitmap.CompressFormat bitmap$CompressFormat0) {
        return new GlideOptions().encodeFormat(bitmap$CompressFormat0);
    }

    public GlideOptions encodeQuality(int v) {
        return (GlideOptions)super.encodeQuality(v);
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions encodeQuality(int v) {
        return this.encodeQuality(v);
    }

    public static GlideOptions encodeQualityOf(int v) {
        return new GlideOptions().encodeQuality(v);
    }

    public GlideOptions error(int v) {
        return (GlideOptions)super.error(v);
    }

    public GlideOptions error(Drawable drawable0) {
        return (GlideOptions)super.error(drawable0);
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions error(int v) {
        return this.error(v);
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions error(Drawable drawable0) {
        return this.error(drawable0);
    }

    public static GlideOptions errorOf(int v) {
        return new GlideOptions().error(v);
    }

    public static GlideOptions errorOf(Drawable drawable0) {
        return new GlideOptions().error(drawable0);
    }

    public GlideOptions fallback(int v) {
        return (GlideOptions)super.fallback(v);
    }

    public GlideOptions fallback(Drawable drawable0) {
        return (GlideOptions)super.fallback(drawable0);
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions fallback(int v) {
        return this.fallback(v);
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions fallback(Drawable drawable0) {
        return this.fallback(drawable0);
    }

    public GlideOptions fitCenter() {
        return (GlideOptions)super.fitCenter();
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions fitCenter() {
        return this.fitCenter();
    }

    public static GlideOptions fitCenterTransform() {
        if(GlideOptions.fitCenterTransform0 == null) {
            GlideOptions.fitCenterTransform0 = new GlideOptions().fitCenter().autoClone();
        }
        return GlideOptions.fitCenterTransform0;
    }

    public GlideOptions format(DecodeFormat decodeFormat0) {
        return (GlideOptions)super.format(decodeFormat0);
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions format(DecodeFormat decodeFormat0) {
        return this.format(decodeFormat0);
    }

    public static GlideOptions formatOf(DecodeFormat decodeFormat0) {
        return new GlideOptions().format(decodeFormat0);
    }

    public GlideOptions frame(long v) {
        return (GlideOptions)super.frame(v);
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions frame(long v) {
        return this.frame(v);
    }

    public static GlideOptions frameOf(long v) {
        return new GlideOptions().frame(v);
    }

    public GlideOptions lock() {
        return (GlideOptions)super.lock();
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions lock() {
        return this.lock();
    }

    public static GlideOptions noAnimation() {
        if(GlideOptions.noAnimation5 == null) {
            GlideOptions.noAnimation5 = new GlideOptions().dontAnimate().autoClone();
        }
        return GlideOptions.noAnimation5;
    }

    public static GlideOptions noTransformation() {
        if(GlideOptions.noTransformation4 == null) {
            GlideOptions.noTransformation4 = new GlideOptions().dontTransform().autoClone();
        }
        return GlideOptions.noTransformation4;
    }

    public GlideOptions onlyRetrieveFromCache(boolean z) {
        return (GlideOptions)super.onlyRetrieveFromCache(z);
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions onlyRetrieveFromCache(boolean z) {
        return this.onlyRetrieveFromCache(z);
    }

    public static GlideOptions option(Option option0, Object object0) {
        return new GlideOptions().set(option0, object0);
    }

    public GlideOptions optionalCenterCrop() {
        return (GlideOptions)super.optionalCenterCrop();
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions optionalCenterCrop() {
        return this.optionalCenterCrop();
    }

    public GlideOptions optionalCenterInside() {
        return (GlideOptions)super.optionalCenterInside();
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions optionalCenterInside() {
        return this.optionalCenterInside();
    }

    public GlideOptions optionalCircleCrop() {
        return (GlideOptions)super.optionalCircleCrop();
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions optionalCircleCrop() {
        return this.optionalCircleCrop();
    }

    public GlideOptions optionalFitCenter() {
        return (GlideOptions)super.optionalFitCenter();
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions optionalFitCenter() {
        return this.optionalFitCenter();
    }

    public GlideOptions optionalTransform(Transformation transformation0) {
        return (GlideOptions)super.optionalTransform(transformation0);
    }

    public GlideOptions optionalTransform(Class class0, Transformation transformation0) {
        return (GlideOptions)super.optionalTransform(class0, transformation0);
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions optionalTransform(Transformation transformation0) {
        return this.optionalTransform(transformation0);
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions optionalTransform(Class class0, Transformation transformation0) {
        return this.optionalTransform(class0, transformation0);
    }

    public GlideOptions override(int v) {
        return (GlideOptions)super.override(v);
    }

    public GlideOptions override(int v, int v1) {
        return (GlideOptions)super.override(v, v1);
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions override(int v) {
        return this.override(v);
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions override(int v, int v1) {
        return this.override(v, v1);
    }

    public static GlideOptions overrideOf(int v) {
        return new GlideOptions().override(v);
    }

    public static GlideOptions overrideOf(int v, int v1) {
        return new GlideOptions().override(v, v1);
    }

    public GlideOptions placeholder(int v) {
        return (GlideOptions)super.placeholder(v);
    }

    public GlideOptions placeholder(Drawable drawable0) {
        return (GlideOptions)super.placeholder(drawable0);
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions placeholder(int v) {
        return this.placeholder(v);
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions placeholder(Drawable drawable0) {
        return this.placeholder(drawable0);
    }

    public static GlideOptions placeholderOf(int v) {
        return new GlideOptions().placeholder(v);
    }

    public static GlideOptions placeholderOf(Drawable drawable0) {
        return new GlideOptions().placeholder(drawable0);
    }

    public GlideOptions priority(Priority priority0) {
        return (GlideOptions)super.priority(priority0);
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions priority(Priority priority0) {
        return this.priority(priority0);
    }

    public static GlideOptions priorityOf(Priority priority0) {
        return new GlideOptions().priority(priority0);
    }

    public GlideOptions set(Option option0, Object object0) {
        return (GlideOptions)super.set(option0, object0);
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions set(Option option0, Object object0) {
        return this.set(option0, object0);
    }

    public GlideOptions signature(Key key0) {
        return (GlideOptions)super.signature(key0);
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions signature(Key key0) {
        return this.signature(key0);
    }

    public static GlideOptions signatureOf(Key key0) {
        return new GlideOptions().signature(key0);
    }

    public GlideOptions sizeMultiplier(float f) {
        return (GlideOptions)super.sizeMultiplier(f);
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions sizeMultiplier(float f) {
        return this.sizeMultiplier(f);
    }

    public static GlideOptions sizeMultiplierOf(float f) {
        return new GlideOptions().sizeMultiplier(f);
    }

    public GlideOptions skipMemoryCache(boolean z) {
        return (GlideOptions)super.skipMemoryCache(z);
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions skipMemoryCache(boolean z) {
        return this.skipMemoryCache(z);
    }

    public static GlideOptions skipMemoryCacheOf(boolean z) {
        return new GlideOptions().skipMemoryCache(z);
    }

    public GlideOptions theme(Resources.Theme resources$Theme0) {
        return (GlideOptions)super.theme(resources$Theme0);
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions theme(Resources.Theme resources$Theme0) {
        return this.theme(resources$Theme0);
    }

    public GlideOptions timeout(int v) {
        return (GlideOptions)super.timeout(v);
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions timeout(int v) {
        return this.timeout(v);
    }

    public static GlideOptions timeoutOf(int v) {
        return new GlideOptions().timeout(v);
    }

    public GlideOptions transform(Transformation transformation0) {
        return (GlideOptions)super.transform(transformation0);
    }

    public GlideOptions transform(Class class0, Transformation transformation0) {
        return (GlideOptions)super.transform(class0, transformation0);
    }

    @SafeVarargs
    public final GlideOptions transform(Transformation[] arr_transformation) {
        return (GlideOptions)super.transform(arr_transformation);
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions transform(Transformation transformation0) {
        return this.transform(transformation0);
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions transform(Class class0, Transformation transformation0) {
        return this.transform(class0, transformation0);
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    @SafeVarargs
    public BaseRequestOptions transform(Transformation[] arr_transformation) {
        return this.transform(arr_transformation);
    }

    @Deprecated
    @SafeVarargs
    public final GlideOptions transforms(Transformation[] arr_transformation) {
        return (GlideOptions)super.transforms(arr_transformation);
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    @Deprecated
    @SafeVarargs
    public BaseRequestOptions transforms(Transformation[] arr_transformation) {
        return this.transforms(arr_transformation);
    }

    public GlideOptions useAnimationPool(boolean z) {
        return (GlideOptions)super.useAnimationPool(z);
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions useAnimationPool(boolean z) {
        return this.useAnimationPool(z);
    }

    public GlideOptions useUnlimitedSourceGeneratorsPool(boolean z) {
        return (GlideOptions)super.useUnlimitedSourceGeneratorsPool(z);
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions useUnlimitedSourceGeneratorsPool(boolean z) {
        return this.useUnlimitedSourceGeneratorsPool(z);
    }
}

