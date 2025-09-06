package com.bumptech.glide.request;

import android.graphics.Bitmap.CompressFormat;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;

public class RequestOptions extends BaseRequestOptions {
    private static RequestOptions centerCropOptions;
    private static RequestOptions centerInsideOptions;
    private static RequestOptions circleCropOptions;
    private static RequestOptions fitCenterOptions;
    private static RequestOptions noAnimationOptions;
    private static RequestOptions noTransformOptions;
    private static RequestOptions skipMemoryCacheFalseOptions;
    private static RequestOptions skipMemoryCacheTrueOptions;

    public static RequestOptions bitmapTransform(Transformation transformation0) {
        return (RequestOptions)new RequestOptions().transform(transformation0);
    }

    public static RequestOptions centerCropTransform() {
        if(RequestOptions.centerCropOptions == null) {
            RequestOptions.centerCropOptions = (RequestOptions)((RequestOptions)new RequestOptions().centerCrop()).autoClone();
        }
        return RequestOptions.centerCropOptions;
    }

    public static RequestOptions centerInsideTransform() {
        if(RequestOptions.centerInsideOptions == null) {
            RequestOptions.centerInsideOptions = (RequestOptions)((RequestOptions)new RequestOptions().centerInside()).autoClone();
        }
        return RequestOptions.centerInsideOptions;
    }

    public static RequestOptions circleCropTransform() {
        if(RequestOptions.circleCropOptions == null) {
            RequestOptions.circleCropOptions = (RequestOptions)((RequestOptions)new RequestOptions().circleCrop()).autoClone();
        }
        return RequestOptions.circleCropOptions;
    }

    public static RequestOptions decodeTypeOf(Class class0) {
        return (RequestOptions)new RequestOptions().decode(class0);
    }

    public static RequestOptions diskCacheStrategyOf(DiskCacheStrategy diskCacheStrategy0) {
        return (RequestOptions)new RequestOptions().diskCacheStrategy(diskCacheStrategy0);
    }

    public static RequestOptions downsampleOf(DownsampleStrategy downsampleStrategy0) {
        return (RequestOptions)new RequestOptions().downsample(downsampleStrategy0);
    }

    public static RequestOptions encodeFormatOf(Bitmap.CompressFormat bitmap$CompressFormat0) {
        return (RequestOptions)new RequestOptions().encodeFormat(bitmap$CompressFormat0);
    }

    public static RequestOptions encodeQualityOf(int v) {
        return (RequestOptions)new RequestOptions().encodeQuality(v);
    }

    // 去混淆评级： 低(20)
    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public boolean equals(Object object0) {
        return object0 instanceof RequestOptions && super.equals(object0);
    }

    public static RequestOptions errorOf(int v) {
        return (RequestOptions)new RequestOptions().error(v);
    }

    public static RequestOptions errorOf(Drawable drawable0) {
        return (RequestOptions)new RequestOptions().error(drawable0);
    }

    public static RequestOptions fitCenterTransform() {
        if(RequestOptions.fitCenterOptions == null) {
            RequestOptions.fitCenterOptions = (RequestOptions)((RequestOptions)new RequestOptions().fitCenter()).autoClone();
        }
        return RequestOptions.fitCenterOptions;
    }

    public static RequestOptions formatOf(DecodeFormat decodeFormat0) {
        return (RequestOptions)new RequestOptions().format(decodeFormat0);
    }

    public static RequestOptions frameOf(long v) {
        return (RequestOptions)new RequestOptions().frame(v);
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public int hashCode() {
        return super.hashCode();
    }

    public static RequestOptions noAnimation() {
        if(RequestOptions.noAnimationOptions == null) {
            RequestOptions.noAnimationOptions = (RequestOptions)((RequestOptions)new RequestOptions().dontAnimate()).autoClone();
        }
        return RequestOptions.noAnimationOptions;
    }

    public static RequestOptions noTransformation() {
        if(RequestOptions.noTransformOptions == null) {
            RequestOptions.noTransformOptions = (RequestOptions)((RequestOptions)new RequestOptions().dontTransform()).autoClone();
        }
        return RequestOptions.noTransformOptions;
    }

    public static RequestOptions option(Option option0, Object object0) {
        return (RequestOptions)new RequestOptions().set(option0, object0);
    }

    public static RequestOptions overrideOf(int v) {
        return RequestOptions.overrideOf(v, v);
    }

    public static RequestOptions overrideOf(int v, int v1) {
        return (RequestOptions)new RequestOptions().override(v, v1);
    }

    public static RequestOptions placeholderOf(int v) {
        return (RequestOptions)new RequestOptions().placeholder(v);
    }

    public static RequestOptions placeholderOf(Drawable drawable0) {
        return (RequestOptions)new RequestOptions().placeholder(drawable0);
    }

    public static RequestOptions priorityOf(Priority priority0) {
        return (RequestOptions)new RequestOptions().priority(priority0);
    }

    public static RequestOptions signatureOf(Key key0) {
        return (RequestOptions)new RequestOptions().signature(key0);
    }

    public static RequestOptions sizeMultiplierOf(float f) {
        return (RequestOptions)new RequestOptions().sizeMultiplier(f);
    }

    public static RequestOptions skipMemoryCacheOf(boolean z) {
        if(z) {
            if(RequestOptions.skipMemoryCacheTrueOptions == null) {
                RequestOptions.skipMemoryCacheTrueOptions = (RequestOptions)((RequestOptions)new RequestOptions().skipMemoryCache(true)).autoClone();
            }
            return RequestOptions.skipMemoryCacheTrueOptions;
        }
        if(RequestOptions.skipMemoryCacheFalseOptions == null) {
            RequestOptions.skipMemoryCacheFalseOptions = (RequestOptions)((RequestOptions)new RequestOptions().skipMemoryCache(false)).autoClone();
        }
        return RequestOptions.skipMemoryCacheFalseOptions;
    }

    public static RequestOptions timeoutOf(int v) {
        return (RequestOptions)new RequestOptions().timeout(v);
    }
}

