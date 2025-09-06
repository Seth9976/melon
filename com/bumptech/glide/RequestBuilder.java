package com.bumptech.glide;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.ErrorRequestCoordinator;
import com.bumptech.glide.request.FutureTarget;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.RequestCoordinator;
import com.bumptech.glide.request.RequestFutureTarget;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.SingleRequest;
import com.bumptech.glide.request.ThumbnailRequestCoordinator;
import com.bumptech.glide.request.target.PreloadTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.target.ViewTarget;
import com.bumptech.glide.signature.AndroidResourceSignature;
import com.bumptech.glide.util.Executors;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;

public class RequestBuilder extends BaseRequestOptions implements ModelTypes, Cloneable {
    protected static final RequestOptions DOWNLOAD_ONLY_OPTIONS;
    private final Context context;
    private RequestBuilder errorBuilder;
    private final Glide glide;
    private final GlideContext glideContext;
    private boolean isDefaultTransitionOptionsSet;
    private boolean isModelSet;
    private boolean isThumbnailBuilt;
    private Object model;
    private List requestListeners;
    private final RequestManager requestManager;
    private Float thumbSizeMultiplier;
    private RequestBuilder thumbnailBuilder;
    private final Class transcodeClass;
    private TransitionOptions transitionOptions;

    static {
        RequestBuilder.DOWNLOAD_ONLY_OPTIONS = (RequestOptions)((RequestOptions)((RequestOptions)new RequestOptions().diskCacheStrategy(DiskCacheStrategy.DATA)).priority(Priority.LOW)).skipMemoryCache(true);
    }

    @SuppressLint({"CheckResult"})
    public RequestBuilder(Glide glide0, RequestManager requestManager0, Class class0, Context context0) {
        this.isDefaultTransitionOptionsSet = true;
        this.glide = glide0;
        this.requestManager = requestManager0;
        this.transcodeClass = class0;
        this.context = context0;
        this.transitionOptions = requestManager0.getDefaultTransitionOptions(class0);
        this.glideContext = glide0.getGlideContext();
        this.initRequestListeners(requestManager0.getDefaultRequestListeners());
        this.apply(requestManager0.getDefaultRequestOptions());
    }

    @SuppressLint({"CheckResult"})
    public RequestBuilder(Class class0, RequestBuilder requestBuilder0) {
        this(requestBuilder0.glide, requestBuilder0.requestManager, class0, requestBuilder0.context);
        this.model = requestBuilder0.model;
        this.isModelSet = requestBuilder0.isModelSet;
        this.apply(requestBuilder0);
    }

    public RequestBuilder addListener(RequestListener requestListener0) {
        if(this.isAutoCloneEnabled()) {
            return this.clone().addListener(requestListener0);
        }
        if(requestListener0 != null) {
            if(this.requestListeners == null) {
                this.requestListeners = new ArrayList();
            }
            this.requestListeners.add(requestListener0);
        }
        return (RequestBuilder)this.selfOrThrowIfLocked();
    }

    public RequestBuilder apply(BaseRequestOptions baseRequestOptions0) {
        Preconditions.checkNotNull(baseRequestOptions0);
        return (RequestBuilder)super.apply(baseRequestOptions0);
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions apply(BaseRequestOptions baseRequestOptions0) {
        return this.apply(baseRequestOptions0);
    }

    private RequestBuilder applyResourceThemeAndSignature(RequestBuilder requestBuilder0) {
        return (RequestBuilder)((RequestBuilder)requestBuilder0.theme(this.context.getTheme())).signature(AndroidResourceSignature.obtain(this.context));
    }

    private Request buildRequest(Target target0, RequestListener requestListener0, BaseRequestOptions baseRequestOptions0, Executor executor0) {
        return this.buildRequestRecursive(new Object(), target0, requestListener0, null, this.transitionOptions, baseRequestOptions0.getPriority(), baseRequestOptions0.getOverrideWidth(), baseRequestOptions0.getOverrideHeight(), baseRequestOptions0, executor0);
    }

    private Request buildRequestRecursive(Object object0, Target target0, RequestListener requestListener0, RequestCoordinator requestCoordinator0, TransitionOptions transitionOptions0, Priority priority0, int v, int v1, BaseRequestOptions baseRequestOptions0, Executor executor0) {
        RequestCoordinator requestCoordinator1;
        ErrorRequestCoordinator errorRequestCoordinator0;
        if(this.errorBuilder == null) {
            errorRequestCoordinator0 = null;
            requestCoordinator1 = requestCoordinator0;
        }
        else {
            errorRequestCoordinator0 = new ErrorRequestCoordinator(object0, requestCoordinator0);
            requestCoordinator1 = errorRequestCoordinator0;
        }
        Request request0 = this.buildThumbnailRequestRecursive(object0, target0, requestListener0, requestCoordinator1, transitionOptions0, priority0, v, v1, baseRequestOptions0, executor0);
        if(errorRequestCoordinator0 == null) {
            return request0;
        }
        int v2 = this.errorBuilder.getOverrideWidth();
        int v3 = this.errorBuilder.getOverrideHeight();
        if(Util.isValidDimensions(v, v1) && !this.errorBuilder.isValidOverride()) {
            v2 = baseRequestOptions0.getOverrideWidth();
            v3 = baseRequestOptions0.getOverrideHeight();
        }
        errorRequestCoordinator0.setRequests(request0, this.errorBuilder.buildRequestRecursive(object0, target0, requestListener0, errorRequestCoordinator0, this.errorBuilder.transitionOptions, this.errorBuilder.getPriority(), v2, v3, this.errorBuilder, executor0));
        return errorRequestCoordinator0;
    }

    private Request buildThumbnailRequestRecursive(Object object0, Target target0, RequestListener requestListener0, RequestCoordinator requestCoordinator0, TransitionOptions transitionOptions0, Priority priority0, int v, int v1, BaseRequestOptions baseRequestOptions0, Executor executor0) {
        RequestBuilder requestBuilder0 = this.thumbnailBuilder;
        if(requestBuilder0 != null) {
            if(this.isThumbnailBuilt) {
                throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
            }
            TransitionOptions transitionOptions1 = requestBuilder0.isDefaultTransitionOptionsSet ? transitionOptions0 : requestBuilder0.transitionOptions;
            Priority priority1 = requestBuilder0.isPrioritySet() ? this.thumbnailBuilder.getPriority() : this.getThumbnailPriority(priority0);
            int v2 = this.thumbnailBuilder.getOverrideWidth();
            int v3 = this.thumbnailBuilder.getOverrideHeight();
            if(Util.isValidDimensions(v, v1) && !this.thumbnailBuilder.isValidOverride()) {
                v2 = baseRequestOptions0.getOverrideWidth();
                v3 = baseRequestOptions0.getOverrideHeight();
            }
            ThumbnailRequestCoordinator thumbnailRequestCoordinator0 = new ThumbnailRequestCoordinator(object0, requestCoordinator0);
            Request request0 = this.obtainRequest(object0, target0, requestListener0, baseRequestOptions0, thumbnailRequestCoordinator0, transitionOptions0, priority0, v, v1, executor0);
            this.isThumbnailBuilt = true;
            Request request1 = this.thumbnailBuilder.buildRequestRecursive(object0, target0, requestListener0, thumbnailRequestCoordinator0, transitionOptions1, priority1, v2, v3, this.thumbnailBuilder, executor0);
            this.isThumbnailBuilt = false;
            thumbnailRequestCoordinator0.setRequests(request0, request1);
            return thumbnailRequestCoordinator0;
        }
        if(this.thumbSizeMultiplier != null) {
            ThumbnailRequestCoordinator thumbnailRequestCoordinator1 = new ThumbnailRequestCoordinator(object0, requestCoordinator0);
            thumbnailRequestCoordinator1.setRequests(this.obtainRequest(object0, target0, requestListener0, baseRequestOptions0, thumbnailRequestCoordinator1, transitionOptions0, priority0, v, v1, executor0), this.obtainRequest(object0, target0, requestListener0, baseRequestOptions0.clone().sizeMultiplier(((float)this.thumbSizeMultiplier)), thumbnailRequestCoordinator1, transitionOptions0, this.getThumbnailPriority(priority0), v, v1, executor0));
            return thumbnailRequestCoordinator1;
        }
        return this.obtainRequest(object0, target0, requestListener0, baseRequestOptions0, requestCoordinator0, transitionOptions0, priority0, v, v1, executor0);
    }

    public RequestBuilder clone() {
        RequestBuilder requestBuilder0 = (RequestBuilder)super.clone();
        requestBuilder0.transitionOptions = requestBuilder0.transitionOptions.clone();
        if(requestBuilder0.requestListeners != null) {
            requestBuilder0.requestListeners = new ArrayList(requestBuilder0.requestListeners);
        }
        RequestBuilder requestBuilder1 = requestBuilder0.thumbnailBuilder;
        if(requestBuilder1 != null) {
            requestBuilder0.thumbnailBuilder = requestBuilder1.clone();
        }
        RequestBuilder requestBuilder2 = requestBuilder0.errorBuilder;
        if(requestBuilder2 != null) {
            requestBuilder0.errorBuilder = requestBuilder2.clone();
        }
        return requestBuilder0;
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public BaseRequestOptions clone() {
        return this.clone();
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public Object clone() {
        return this.clone();
    }

    private RequestBuilder cloneWithNullErrorAndThumbnail() {
        return this.clone().error(null).thumbnail(null);
    }

    @Deprecated
    public FutureTarget downloadOnly(int v, int v1) {
        return this.getDownloadOnlyRequest().submit(v, v1);
    }

    @Deprecated
    public Target downloadOnly(Target target0) {
        return this.getDownloadOnlyRequest().into(target0);
    }

    // 去混淆评级： 中等(90)
    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public boolean equals(Object object0) {
        return object0 instanceof RequestBuilder && super.equals(((RequestBuilder)object0)) && Objects.equals(this.transcodeClass, ((RequestBuilder)object0).transcodeClass) && this.transitionOptions.equals(((RequestBuilder)object0).transitionOptions) && Objects.equals(this.model, ((RequestBuilder)object0).model) && Objects.equals(this.requestListeners, ((RequestBuilder)object0).requestListeners) && Objects.equals(this.thumbnailBuilder, ((RequestBuilder)object0).thumbnailBuilder) && Objects.equals(this.errorBuilder, ((RequestBuilder)object0).errorBuilder) && Objects.equals(this.thumbSizeMultiplier, ((RequestBuilder)object0).thumbSizeMultiplier) && this.isDefaultTransitionOptionsSet == ((RequestBuilder)object0).isDefaultTransitionOptionsSet && this.isModelSet == ((RequestBuilder)object0).isModelSet;
    }

    public RequestBuilder error(RequestBuilder requestBuilder0) {
        if(this.isAutoCloneEnabled()) {
            return this.clone().error(requestBuilder0);
        }
        this.errorBuilder = requestBuilder0;
        return (RequestBuilder)this.selfOrThrowIfLocked();
    }

    public RequestBuilder error(Object object0) {
        return object0 == null ? this.error(null) : this.error(this.cloneWithNullErrorAndThumbnail().load(object0));
    }

    public RequestBuilder getDownloadOnlyRequest() {
        return new RequestBuilder(File.class, this).apply(RequestBuilder.DOWNLOAD_ONLY_OPTIONS);
    }

    public Object getModel() {
        return this.model;
    }

    public RequestManager getRequestManager() {
        return this.requestManager;
    }

    private Priority getThumbnailPriority(Priority priority0) {
        switch(com.bumptech.glide.RequestBuilder.1.$SwitchMap$com$bumptech$glide$Priority[priority0.ordinal()]) {
            case 1: {
                return Priority.NORMAL;
            }
            case 2: {
                return Priority.HIGH;
            }
            case 3: 
            case 4: {
                return Priority.IMMEDIATE;
            }
            default: {
                throw new IllegalArgumentException("unknown priority: " + this.getPriority());
            }
        }
    }

    @Override  // com.bumptech.glide.request.BaseRequestOptions
    public int hashCode() {
        return Util.hashCode(this.isModelSet, Util.hashCode(this.isDefaultTransitionOptionsSet, Util.hashCode(this.thumbSizeMultiplier, Util.hashCode(this.errorBuilder, Util.hashCode(this.thumbnailBuilder, Util.hashCode(this.requestListeners, Util.hashCode(this.model, Util.hashCode(this.transitionOptions, Util.hashCode(this.transcodeClass, super.hashCode())))))))));
    }

    @SuppressLint({"CheckResult"})
    private void initRequestListeners(List list0) {
        for(Object object0: list0) {
            this.addListener(((RequestListener)object0));
        }
    }

    private Target into(Target target0, RequestListener requestListener0, BaseRequestOptions baseRequestOptions0, Executor executor0) {
        Preconditions.checkNotNull(target0);
        if(!this.isModelSet) {
            throw new IllegalArgumentException("You must call #load() before calling #into()");
        }
        Request request0 = this.buildRequest(target0, requestListener0, baseRequestOptions0, executor0);
        Request request1 = target0.getRequest();
        if(request0.isEquivalentTo(request1) && !this.isSkipMemoryCacheWithCompletePreviousRequest(baseRequestOptions0, request1)) {
            if(!((Request)Preconditions.checkNotNull(request1)).isRunning()) {
                request1.begin();
            }
            return target0;
        }
        this.requestManager.clear(target0);
        target0.setRequest(request0);
        this.requestManager.track(target0, request0);
        return target0;
    }

    @Deprecated
    public FutureTarget into(int v, int v1) {
        return this.submit(v, v1);
    }

    public Target into(Target target0) {
        return this.into(target0, null, Executors.mainThreadExecutor());
    }

    public Target into(Target target0, RequestListener requestListener0, Executor executor0) {
        return this.into(target0, requestListener0, this, executor0);
    }

    public ViewTarget into(ImageView imageView0) {
        BaseRequestOptions baseRequestOptions0;
        Util.assertMainThread();
        Preconditions.checkNotNull(imageView0);
        if(!this.isTransformationSet() && this.isTransformationAllowed() && imageView0.getScaleType() != null) {
            switch(com.bumptech.glide.RequestBuilder.1.$SwitchMap$android$widget$ImageView$ScaleType[imageView0.getScaleType().ordinal()]) {
                case 1: {
                    baseRequestOptions0 = this.clone().optionalCenterCrop();
                    return (ViewTarget)this.into(this.glideContext.buildImageViewTarget(imageView0, this.transcodeClass), null, baseRequestOptions0, Executors.mainThreadExecutor());
                }
                case 2: {
                    baseRequestOptions0 = this.clone().optionalCenterInside();
                    return (ViewTarget)this.into(this.glideContext.buildImageViewTarget(imageView0, this.transcodeClass), null, baseRequestOptions0, Executors.mainThreadExecutor());
                }
                case 3: 
                case 4: 
                case 5: {
                    baseRequestOptions0 = this.clone().optionalFitCenter();
                    return (ViewTarget)this.into(this.glideContext.buildImageViewTarget(imageView0, this.transcodeClass), null, baseRequestOptions0, Executors.mainThreadExecutor());
                }
                case 6: {
                    baseRequestOptions0 = this.clone().optionalCenterInside();
                    return (ViewTarget)this.into(this.glideContext.buildImageViewTarget(imageView0, this.transcodeClass), null, baseRequestOptions0, Executors.mainThreadExecutor());
                }
                default: {
                    return (ViewTarget)this.into(this.glideContext.buildImageViewTarget(imageView0, this.transcodeClass), null, this, Executors.mainThreadExecutor());
                }
            }
        }
        return (ViewTarget)this.into(this.glideContext.buildImageViewTarget(imageView0, this.transcodeClass), null, this, Executors.mainThreadExecutor());
    }

    // 去混淆评级： 低(20)
    private boolean isSkipMemoryCacheWithCompletePreviousRequest(BaseRequestOptions baseRequestOptions0, Request request0) {
        return !baseRequestOptions0.isMemoryCacheable() && request0.isComplete();
    }

    public RequestBuilder listener(RequestListener requestListener0) {
        if(this.isAutoCloneEnabled()) {
            return this.clone().listener(requestListener0);
        }
        this.requestListeners = null;
        return this.addListener(requestListener0);
    }

    public RequestBuilder load(Bitmap bitmap0) {
        return this.loadGeneric(bitmap0).apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE));
    }

    public RequestBuilder load(Drawable drawable0) {
        return this.loadGeneric(drawable0).apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE));
    }

    public RequestBuilder load(Uri uri0) {
        return this.maybeApplyOptionsResourceUri(uri0, this.loadGeneric(uri0));
    }

    public RequestBuilder load(File file0) {
        return this.loadGeneric(file0);
    }

    public RequestBuilder load(Integer integer0) {
        return this.applyResourceThemeAndSignature(this.loadGeneric(integer0));
    }

    public RequestBuilder load(Object object0) {
        return this.loadGeneric(object0);
    }

    public RequestBuilder load(String s) {
        return this.loadGeneric(s);
    }

    @Deprecated
    public RequestBuilder load(URL uRL0) {
        return this.loadGeneric(uRL0);
    }

    public RequestBuilder load(byte[] arr_b) {
        RequestBuilder requestBuilder0 = this.loadGeneric(arr_b);
        if(!requestBuilder0.isDiskCacheStrategySet()) {
            requestBuilder0 = requestBuilder0.apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE));
        }
        return requestBuilder0.isSkipMemoryCacheSet() ? requestBuilder0 : requestBuilder0.apply(RequestOptions.skipMemoryCacheOf(true));
    }

    @Override  // com.bumptech.glide.ModelTypes
    public Object load(Bitmap bitmap0) {
        return this.load(bitmap0);
    }

    @Override  // com.bumptech.glide.ModelTypes
    public Object load(Drawable drawable0) {
        return this.load(drawable0);
    }

    @Override  // com.bumptech.glide.ModelTypes
    public Object load(Uri uri0) {
        return this.load(uri0);
    }

    @Override  // com.bumptech.glide.ModelTypes
    public Object load(File file0) {
        return this.load(file0);
    }

    @Override  // com.bumptech.glide.ModelTypes
    public Object load(Integer integer0) {
        return this.load(integer0);
    }

    @Override  // com.bumptech.glide.ModelTypes
    public Object load(Object object0) {
        return this.load(object0);
    }

    @Override  // com.bumptech.glide.ModelTypes
    public Object load(String s) {
        return this.load(s);
    }

    @Override  // com.bumptech.glide.ModelTypes
    @Deprecated
    public Object load(URL uRL0) {
        return this.load(uRL0);
    }

    @Override  // com.bumptech.glide.ModelTypes
    public Object load(byte[] arr_b) {
        return this.load(arr_b);
    }

    private RequestBuilder loadGeneric(Object object0) {
        if(this.isAutoCloneEnabled()) {
            return this.clone().loadGeneric(object0);
        }
        this.model = object0;
        this.isModelSet = true;
        return (RequestBuilder)this.selfOrThrowIfLocked();
    }

    private RequestBuilder maybeApplyOptionsResourceUri(Uri uri0, RequestBuilder requestBuilder0) {
        return uri0 == null || !"android.resource".equals(uri0.getScheme()) ? requestBuilder0 : this.applyResourceThemeAndSignature(requestBuilder0);
    }

    private Request obtainRequest(Object object0, Target target0, RequestListener requestListener0, BaseRequestOptions baseRequestOptions0, RequestCoordinator requestCoordinator0, TransitionOptions transitionOptions0, Priority priority0, int v, int v1, Executor executor0) {
        return SingleRequest.obtain(this.context, this.glideContext, object0, this.model, this.transcodeClass, baseRequestOptions0, v, v1, priority0, target0, requestListener0, this.requestListeners, requestCoordinator0, this.glideContext.getEngine(), transitionOptions0.getTransitionFactory(), executor0);
    }

    public Target preload() {
        return this.preload(0x80000000, 0x80000000);
    }

    public Target preload(int v, int v1) {
        return this.into(PreloadTarget.obtain(this.requestManager, v, v1));
    }

    public FutureTarget submit() {
        return this.submit(0x80000000, 0x80000000);
    }

    public FutureTarget submit(int v, int v1) {
        RequestFutureTarget requestFutureTarget0 = new RequestFutureTarget(v, v1);
        return (FutureTarget)this.into(requestFutureTarget0, requestFutureTarget0, Executors.directExecutor());
    }

    @Deprecated
    public RequestBuilder thumbnail(float f) {
        if(this.isAutoCloneEnabled()) {
            return this.clone().thumbnail(f);
        }
        if(f < 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        this.thumbSizeMultiplier = f;
        return (RequestBuilder)this.selfOrThrowIfLocked();
    }

    public RequestBuilder thumbnail(RequestBuilder requestBuilder0) {
        if(this.isAutoCloneEnabled()) {
            return this.clone().thumbnail(requestBuilder0);
        }
        this.thumbnailBuilder = requestBuilder0;
        return (RequestBuilder)this.selfOrThrowIfLocked();
    }

    public RequestBuilder thumbnail(List list0) {
        RequestBuilder requestBuilder0 = null;
        if(list0 != null && !list0.isEmpty()) {
            for(int v = list0.size() - 1; v >= 0; --v) {
                RequestBuilder requestBuilder1 = (RequestBuilder)list0.get(v);
                if(requestBuilder1 != null) {
                    requestBuilder0 = requestBuilder0 == null ? requestBuilder1 : requestBuilder1.thumbnail(requestBuilder0);
                }
            }
            return this.thumbnail(requestBuilder0);
        }
        return this.thumbnail(null);
    }

    public RequestBuilder thumbnail(RequestBuilder[] arr_requestBuilder) {
        return arr_requestBuilder == null || arr_requestBuilder.length == 0 ? this.thumbnail(null) : this.thumbnail(Arrays.asList(arr_requestBuilder));
    }

    public RequestBuilder transition(TransitionOptions transitionOptions0) {
        if(this.isAutoCloneEnabled()) {
            return this.clone().transition(transitionOptions0);
        }
        this.transitionOptions = (TransitionOptions)Preconditions.checkNotNull(transitionOptions0);
        this.isDefaultTransitionOptionsSet = false;
        return (RequestBuilder)this.selfOrThrowIfLocked();
    }
}

