package com.bumptech.glide.integration.okhttp3;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestListener;
import java.io.File;
import java.net.URL;
import java.util.List;

public class GlideRequest extends RequestBuilder implements Cloneable {
    public GlideRequest(Glide glide0, RequestManager requestManager0, Class class0, Context context0) {
        super(glide0, requestManager0, class0, context0);
    }

    public GlideRequest(Class class0, RequestBuilder requestBuilder0) {
        super(class0, requestBuilder0);
    }

    @Override  // com.bumptech.glide.RequestBuilder
    public RequestBuilder addListener(RequestListener requestListener0) {
        return this.addListener(requestListener0);
    }

    public GlideRequest addListener(RequestListener requestListener0) {
        return (GlideRequest)super.addListener(requestListener0);
    }

    @Override  // com.bumptech.glide.RequestBuilder
    public RequestBuilder apply(BaseRequestOptions baseRequestOptions0) {
        return this.apply(baseRequestOptions0);
    }

    public GlideRequest apply(BaseRequestOptions baseRequestOptions0) {
        return (GlideRequest)super.apply(baseRequestOptions0);
    }

    @Override  // com.bumptech.glide.RequestBuilder
    public BaseRequestOptions apply(BaseRequestOptions baseRequestOptions0) {
        return this.apply(baseRequestOptions0);
    }

    public GlideRequest autoClone() {
        return (GlideRequest)super.autoClone();
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions autoClone() {
        return this.autoClone();
    }

    public GlideRequest centerCrop() {
        return (GlideRequest)super.centerCrop();
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions centerCrop() {
        return this.centerCrop();
    }

    public GlideRequest centerInside() {
        return (GlideRequest)super.centerInside();
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions centerInside() {
        return this.centerInside();
    }

    public GlideRequest circleCrop() {
        return (GlideRequest)super.circleCrop();
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions circleCrop() {
        return this.circleCrop();
    }

    @Override  // com.bumptech.glide.RequestBuilder
    public RequestBuilder clone() {
        return this.clone();
    }

    public GlideRequest clone() {
        return (GlideRequest)super.clone();
    }

    @Override  // com.bumptech.glide.RequestBuilder
    public BaseRequestOptions clone() {
        return this.clone();
    }

    @Override  // com.bumptech.glide.RequestBuilder
    public Object clone() {
        return this.clone();
    }

    public GlideRequest decode(Class class0) {
        return (GlideRequest)super.decode(class0);
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions decode(Class class0) {
        return this.decode(class0);
    }

    public GlideRequest disallowHardwareConfig() {
        return (GlideRequest)super.disallowHardwareConfig();
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions disallowHardwareConfig() {
        return this.disallowHardwareConfig();
    }

    public GlideRequest diskCacheStrategy(DiskCacheStrategy diskCacheStrategy0) {
        return (GlideRequest)super.diskCacheStrategy(diskCacheStrategy0);
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions diskCacheStrategy(DiskCacheStrategy diskCacheStrategy0) {
        return this.diskCacheStrategy(diskCacheStrategy0);
    }

    public GlideRequest dontAnimate() {
        return (GlideRequest)super.dontAnimate();
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions dontAnimate() {
        return this.dontAnimate();
    }

    public GlideRequest dontTransform() {
        return (GlideRequest)super.dontTransform();
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions dontTransform() {
        return this.dontTransform();
    }

    public GlideRequest downsample(DownsampleStrategy downsampleStrategy0) {
        return (GlideRequest)super.downsample(downsampleStrategy0);
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions downsample(DownsampleStrategy downsampleStrategy0) {
        return this.downsample(downsampleStrategy0);
    }

    public GlideRequest encodeFormat(Bitmap.CompressFormat bitmap$CompressFormat0) {
        return (GlideRequest)super.encodeFormat(bitmap$CompressFormat0);
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions encodeFormat(Bitmap.CompressFormat bitmap$CompressFormat0) {
        return this.encodeFormat(bitmap$CompressFormat0);
    }

    public GlideRequest encodeQuality(int v) {
        return (GlideRequest)super.encodeQuality(v);
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions encodeQuality(int v) {
        return this.encodeQuality(v);
    }

    @Override  // com.bumptech.glide.RequestBuilder
    public RequestBuilder error(RequestBuilder requestBuilder0) {
        return this.error(requestBuilder0);
    }

    @Override  // com.bumptech.glide.RequestBuilder
    public RequestBuilder error(Object object0) {
        return this.error(object0);
    }

    public GlideRequest error(int v) {
        return (GlideRequest)super.error(v);
    }

    public GlideRequest error(Drawable drawable0) {
        return (GlideRequest)super.error(drawable0);
    }

    public GlideRequest error(RequestBuilder requestBuilder0) {
        return (GlideRequest)super.error(requestBuilder0);
    }

    public GlideRequest error(Object object0) {
        return (GlideRequest)super.error(object0);
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions error(int v) {
        return this.error(v);
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions error(Drawable drawable0) {
        return this.error(drawable0);
    }

    public GlideRequest fallback(int v) {
        return (GlideRequest)super.fallback(v);
    }

    public GlideRequest fallback(Drawable drawable0) {
        return (GlideRequest)super.fallback(drawable0);
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions fallback(int v) {
        return this.fallback(v);
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions fallback(Drawable drawable0) {
        return this.fallback(drawable0);
    }

    public GlideRequest fitCenter() {
        return (GlideRequest)super.fitCenter();
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions fitCenter() {
        return this.fitCenter();
    }

    public GlideRequest format(DecodeFormat decodeFormat0) {
        return (GlideRequest)super.format(decodeFormat0);
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions format(DecodeFormat decodeFormat0) {
        return this.format(decodeFormat0);
    }

    public GlideRequest frame(long v) {
        return (GlideRequest)super.frame(v);
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions frame(long v) {
        return this.frame(v);
    }

    @Override  // com.bumptech.glide.RequestBuilder
    public RequestBuilder getDownloadOnlyRequest() {
        return this.getDownloadOnlyRequest();
    }

    public GlideRequest getDownloadOnlyRequest() {
        return new GlideRequest(File.class, this).apply(RequestBuilder.DOWNLOAD_ONLY_OPTIONS);
    }

    @Override  // com.bumptech.glide.RequestBuilder
    public RequestBuilder listener(RequestListener requestListener0) {
        return this.listener(requestListener0);
    }

    public GlideRequest listener(RequestListener requestListener0) {
        return (GlideRequest)super.listener(requestListener0);
    }

    @Override  // com.bumptech.glide.RequestBuilder
    public RequestBuilder load(Bitmap bitmap0) {
        return this.load(bitmap0);
    }

    @Override  // com.bumptech.glide.RequestBuilder
    public RequestBuilder load(Drawable drawable0) {
        return this.load(drawable0);
    }

    @Override  // com.bumptech.glide.RequestBuilder
    public RequestBuilder load(Uri uri0) {
        return this.load(uri0);
    }

    @Override  // com.bumptech.glide.RequestBuilder
    public RequestBuilder load(File file0) {
        return this.load(file0);
    }

    @Override  // com.bumptech.glide.RequestBuilder
    public RequestBuilder load(Integer integer0) {
        return this.load(integer0);
    }

    @Override  // com.bumptech.glide.RequestBuilder
    public RequestBuilder load(Object object0) {
        return this.load(object0);
    }

    @Override  // com.bumptech.glide.RequestBuilder
    public RequestBuilder load(String s) {
        return this.load(s);
    }

    @Override  // com.bumptech.glide.RequestBuilder
    @Deprecated
    public RequestBuilder load(URL uRL0) {
        return this.load(uRL0);
    }

    @Override  // com.bumptech.glide.RequestBuilder
    public RequestBuilder load(byte[] arr_b) {
        return this.load(arr_b);
    }

    public GlideRequest load(Bitmap bitmap0) {
        return (GlideRequest)super.load(bitmap0);
    }

    public GlideRequest load(Drawable drawable0) {
        return (GlideRequest)super.load(drawable0);
    }

    public GlideRequest load(Uri uri0) {
        return (GlideRequest)super.load(uri0);
    }

    public GlideRequest load(File file0) {
        return (GlideRequest)super.load(file0);
    }

    public GlideRequest load(Integer integer0) {
        return (GlideRequest)super.load(integer0);
    }

    public GlideRequest load(Object object0) {
        return (GlideRequest)super.load(object0);
    }

    public GlideRequest load(String s) {
        return (GlideRequest)super.load(s);
    }

    @Deprecated
    public GlideRequest load(URL uRL0) {
        return (GlideRequest)super.load(uRL0);
    }

    public GlideRequest load(byte[] arr_b) {
        return (GlideRequest)super.load(arr_b);
    }

    @Override  // com.bumptech.glide.RequestBuilder
    public Object load(Bitmap bitmap0) {
        return this.load(bitmap0);
    }

    @Override  // com.bumptech.glide.RequestBuilder
    public Object load(Drawable drawable0) {
        return this.load(drawable0);
    }

    @Override  // com.bumptech.glide.RequestBuilder
    public Object load(Uri uri0) {
        return this.load(uri0);
    }

    @Override  // com.bumptech.glide.RequestBuilder
    public Object load(File file0) {
        return this.load(file0);
    }

    @Override  // com.bumptech.glide.RequestBuilder
    public Object load(Integer integer0) {
        return this.load(integer0);
    }

    @Override  // com.bumptech.glide.RequestBuilder
    public Object load(Object object0) {
        return this.load(object0);
    }

    @Override  // com.bumptech.glide.RequestBuilder
    public Object load(String s) {
        return this.load(s);
    }

    @Override  // com.bumptech.glide.RequestBuilder
    @Deprecated
    public Object load(URL uRL0) {
        return this.load(uRL0);
    }

    @Override  // com.bumptech.glide.RequestBuilder
    public Object load(byte[] arr_b) {
        return this.load(arr_b);
    }

    public GlideRequest lock() {
        return (GlideRequest)super.lock();
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions lock() {
        return this.lock();
    }

    public GlideRequest onlyRetrieveFromCache(boolean z) {
        return (GlideRequest)super.onlyRetrieveFromCache(z);
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions onlyRetrieveFromCache(boolean z) {
        return this.onlyRetrieveFromCache(z);
    }

    public GlideRequest optionalCenterCrop() {
        return (GlideRequest)super.optionalCenterCrop();
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions optionalCenterCrop() {
        return this.optionalCenterCrop();
    }

    public GlideRequest optionalCenterInside() {
        return (GlideRequest)super.optionalCenterInside();
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions optionalCenterInside() {
        return this.optionalCenterInside();
    }

    public GlideRequest optionalCircleCrop() {
        return (GlideRequest)super.optionalCircleCrop();
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions optionalCircleCrop() {
        return this.optionalCircleCrop();
    }

    public GlideRequest optionalFitCenter() {
        return (GlideRequest)super.optionalFitCenter();
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions optionalFitCenter() {
        return this.optionalFitCenter();
    }

    public GlideRequest optionalTransform(Transformation transformation0) {
        return (GlideRequest)super.optionalTransform(transformation0);
    }

    public GlideRequest optionalTransform(Class class0, Transformation transformation0) {
        return (GlideRequest)super.optionalTransform(class0, transformation0);
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions optionalTransform(Transformation transformation0) {
        return this.optionalTransform(transformation0);
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions optionalTransform(Class class0, Transformation transformation0) {
        return this.optionalTransform(class0, transformation0);
    }

    public GlideRequest override(int v) {
        return (GlideRequest)super.override(v);
    }

    public GlideRequest override(int v, int v1) {
        return (GlideRequest)super.override(v, v1);
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions override(int v) {
        return this.override(v);
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions override(int v, int v1) {
        return this.override(v, v1);
    }

    public GlideRequest placeholder(int v) {
        return (GlideRequest)super.placeholder(v);
    }

    public GlideRequest placeholder(Drawable drawable0) {
        return (GlideRequest)super.placeholder(drawable0);
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions placeholder(int v) {
        return this.placeholder(v);
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions placeholder(Drawable drawable0) {
        return this.placeholder(drawable0);
    }

    public GlideRequest priority(Priority priority0) {
        return (GlideRequest)super.priority(priority0);
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions priority(Priority priority0) {
        return this.priority(priority0);
    }

    public GlideRequest set(Option option0, Object object0) {
        return (GlideRequest)super.set(option0, object0);
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions set(Option option0, Object object0) {
        return this.set(option0, object0);
    }

    public GlideRequest signature(Key key0) {
        return (GlideRequest)super.signature(key0);
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions signature(Key key0) {
        return this.signature(key0);
    }

    public GlideRequest sizeMultiplier(float f) {
        return (GlideRequest)super.sizeMultiplier(f);
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions sizeMultiplier(float f) {
        return this.sizeMultiplier(f);
    }

    public GlideRequest skipMemoryCache(boolean z) {
        return (GlideRequest)super.skipMemoryCache(z);
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions skipMemoryCache(boolean z) {
        return this.skipMemoryCache(z);
    }

    public GlideRequest theme(Resources.Theme resources$Theme0) {
        return (GlideRequest)super.theme(resources$Theme0);
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions theme(Resources.Theme resources$Theme0) {
        return this.theme(resources$Theme0);
    }

    @Override  // com.bumptech.glide.RequestBuilder
    @Deprecated
    public RequestBuilder thumbnail(float f) {
        return this.thumbnail(f);
    }

    @Override  // com.bumptech.glide.RequestBuilder
    public RequestBuilder thumbnail(RequestBuilder requestBuilder0) {
        return this.thumbnail(requestBuilder0);
    }

    @Override  // com.bumptech.glide.RequestBuilder
    public RequestBuilder thumbnail(List list0) {
        return this.thumbnail(list0);
    }

    @Override  // com.bumptech.glide.RequestBuilder
    @SafeVarargs
    public RequestBuilder thumbnail(RequestBuilder[] arr_requestBuilder) {
        return this.thumbnail(arr_requestBuilder);
    }

    @Deprecated
    public GlideRequest thumbnail(float f) {
        return (GlideRequest)super.thumbnail(f);
    }

    public GlideRequest thumbnail(RequestBuilder requestBuilder0) {
        return (GlideRequest)super.thumbnail(requestBuilder0);
    }

    public GlideRequest thumbnail(List list0) {
        return (GlideRequest)super.thumbnail(list0);
    }

    @SafeVarargs
    public final GlideRequest thumbnail(RequestBuilder[] arr_requestBuilder) {
        return (GlideRequest)super.thumbnail(arr_requestBuilder);
    }

    public GlideRequest timeout(int v) {
        return (GlideRequest)super.timeout(v);
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions timeout(int v) {
        return this.timeout(v);
    }

    public GlideRequest transform(Transformation transformation0) {
        return (GlideRequest)super.transform(transformation0);
    }

    public GlideRequest transform(Class class0, Transformation transformation0) {
        return (GlideRequest)super.transform(class0, transformation0);
    }

    public GlideRequest transform(Transformation[] arr_transformation) {
        return (GlideRequest)super.transform(arr_transformation);
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
    public BaseRequestOptions transform(Transformation[] arr_transformation) {
        return this.transform(arr_transformation);
    }

    @Deprecated
    public GlideRequest transforms(Transformation[] arr_transformation) {
        return (GlideRequest)super.transforms(arr_transformation);
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    @Deprecated
    public BaseRequestOptions transforms(Transformation[] arr_transformation) {
        return this.transforms(arr_transformation);
    }

    @Override  // com.bumptech.glide.RequestBuilder
    public RequestBuilder transition(TransitionOptions transitionOptions0) {
        return this.transition(transitionOptions0);
    }

    public GlideRequest transition(TransitionOptions transitionOptions0) {
        return (GlideRequest)super.transition(transitionOptions0);
    }

    public GlideRequest useAnimationPool(boolean z) {
        return (GlideRequest)super.useAnimationPool(z);
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions useAnimationPool(boolean z) {
        return this.useAnimationPool(z);
    }

    public GlideRequest useUnlimitedSourceGeneratorsPool(boolean z) {
        return (GlideRequest)super.useUnlimitedSourceGeneratorsPool(z);
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions useUnlimitedSourceGeneratorsPool(boolean z) {
        return this.useUnlimitedSourceGeneratorsPool(z);
    }
}

