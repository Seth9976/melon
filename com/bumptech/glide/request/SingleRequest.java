package com.bumptech.glide.request;

import U4.x;
import android.content.Context;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.bumptech.glide.GlideBuilder.LogRequestOrigins;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.Engine.LoadStatus;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.drawable.DrawableDecoderCompat;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.request.transition.TransitionFactory;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Util;
import com.bumptech.glide.util.pool.StateVerifier;
import java.util.List;
import java.util.concurrent.Executor;

public final class SingleRequest implements Request, ResourceCallback, SizeReadyCallback {
    static enum Status {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CLEARED;

        private static Status[] $values() [...] // Inlined contents
    }

    private static final String GLIDE_TAG = "Glide";
    private static final boolean IS_VERBOSE_LOGGABLE = false;
    private static final String TAG = "GlideRequest";
    private final TransitionFactory animationFactory;
    private final Executor callbackExecutor;
    private final Context context;
    private int cookie;
    private volatile Engine engine;
    private Drawable errorDrawable;
    private Drawable fallbackDrawable;
    private final GlideContext glideContext;
    private int height;
    private boolean isCallingCallbacks;
    private LoadStatus loadStatus;
    private final Object model;
    private final int overrideHeight;
    private final int overrideWidth;
    private Drawable placeholderDrawable;
    private final Priority priority;
    private final RequestCoordinator requestCoordinator;
    private final List requestListeners;
    private final Object requestLock;
    private final BaseRequestOptions requestOptions;
    private RuntimeException requestOrigin;
    private Resource resource;
    private long startTime;
    private final StateVerifier stateVerifier;
    private Status status;
    private final String tag;
    private final Target target;
    private final RequestListener targetListener;
    private final Class transcodeClass;
    private int width;

    static {
        SingleRequest.IS_VERBOSE_LOGGABLE = Log.isLoggable("GlideRequest", 2);
    }

    private SingleRequest(Context context0, GlideContext glideContext0, Object object0, Object object1, Class class0, BaseRequestOptions baseRequestOptions0, int v, int v1, Priority priority0, Target target0, RequestListener requestListener0, List list0, RequestCoordinator requestCoordinator0, Engine engine0, TransitionFactory transitionFactory0, Executor executor0) {
        this.tag = SingleRequest.IS_VERBOSE_LOGGABLE ? String.valueOf(this.hashCode()) : null;
        this.stateVerifier = StateVerifier.newInstance();
        this.requestLock = object0;
        this.context = context0;
        this.glideContext = glideContext0;
        this.model = object1;
        this.transcodeClass = class0;
        this.requestOptions = baseRequestOptions0;
        this.overrideWidth = v;
        this.overrideHeight = v1;
        this.priority = priority0;
        this.target = target0;
        this.targetListener = requestListener0;
        this.requestListeners = list0;
        this.requestCoordinator = requestCoordinator0;
        this.engine = engine0;
        this.animationFactory = transitionFactory0;
        this.callbackExecutor = executor0;
        this.status = Status.PENDING;
        if(this.requestOrigin == null && glideContext0.getExperiments().isEnabled(LogRequestOrigins.class)) {
            this.requestOrigin = new RuntimeException("Glide request origin trace");
        }
    }

    private void assertNotCallingCallbacks() {
        if(this.isCallingCallbacks) {
            throw new IllegalStateException("You can\'t start or clear loads in RequestListener or Target callbacks. If you\'re trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    @Override  // com.bumptech.glide.request.Request
    public void begin() {
        synchronized(this.requestLock) {
            this.assertNotCallingCallbacks();
            this.stateVerifier.throwIfRecycled();
            this.startTime = LogTime.getLogTime();
            Object object1 = this.model;
            if(object1 == null) {
                if(Util.isValidDimensions(this.overrideWidth, this.overrideHeight)) {
                    this.width = this.overrideWidth;
                    this.height = this.overrideHeight;
                }
                int v1 = this.getFallbackDrawable() == null ? 5 : 3;
                this.onLoadFailed(new GlideException("Received null model"), v1);
                return;
            }
            Status singleRequest$Status0 = this.status;
            Status singleRequest$Status1 = Status.RUNNING;
            if(singleRequest$Status0 != singleRequest$Status1) {
                if(singleRequest$Status0 == Status.COMPLETE) {
                    this.onResourceReady(this.resource, DataSource.MEMORY_CACHE, false);
                    return;
                }
                this.experimentalNotifyRequestStarted(object1);
                this.cookie = -1;
                Status singleRequest$Status2 = Status.WAITING_FOR_SIZE;
                this.status = singleRequest$Status2;
                if(Util.isValidDimensions(this.overrideWidth, this.overrideHeight)) {
                    this.onSizeReady(this.overrideWidth, this.overrideHeight);
                }
                else {
                    this.target.getSize(this);
                }
                if((this.status == singleRequest$Status1 || this.status == singleRequest$Status2) && this.canNotifyStatusChanged()) {
                    Drawable drawable0 = this.getPlaceholderDrawable();
                    this.target.onLoadStarted(drawable0);
                }
                if(SingleRequest.IS_VERBOSE_LOGGABLE) {
                    this.logV("finished run method in " + LogTime.getElapsedMillis(this.startTime));
                }
                return;
            }
        }
        throw new IllegalArgumentException("Cannot restart a running request");
    }

    private boolean canNotifyCleared() {
        return this.requestCoordinator == null || this.requestCoordinator.canNotifyCleared(this);
    }

    private boolean canNotifyStatusChanged() {
        return this.requestCoordinator == null || this.requestCoordinator.canNotifyStatusChanged(this);
    }

    private boolean canSetResource() {
        return this.requestCoordinator == null || this.requestCoordinator.canSetImage(this);
    }

    private void cancel() {
        this.assertNotCallingCallbacks();
        this.stateVerifier.throwIfRecycled();
        this.target.removeCallback(this);
        LoadStatus engine$LoadStatus0 = this.loadStatus;
        if(engine$LoadStatus0 != null) {
            engine$LoadStatus0.cancel();
            this.loadStatus = null;
        }
    }

    @Override  // com.bumptech.glide.request.Request
    public void clear() {
        Resource resource0;
        synchronized(this.requestLock) {
            this.assertNotCallingCallbacks();
            this.stateVerifier.throwIfRecycled();
            Status singleRequest$Status0 = Status.CLEARED;
            if(this.status == singleRequest$Status0) {
                return;
            }
            this.cancel();
            resource0 = this.resource;
            if(resource0 == null) {
                resource0 = null;
            }
            else {
                this.resource = null;
            }
            if(this.canNotifyCleared()) {
                Drawable drawable0 = this.getPlaceholderDrawable();
                this.target.onLoadCleared(drawable0);
            }
            this.status = singleRequest$Status0;
        }
        if(resource0 != null) {
            this.engine.release(resource0);
        }
    }

    private void experimentalNotifyRequestStarted(Object object0) {
        List list0 = this.requestListeners;
        if(list0 != null) {
            for(Object object1: list0) {
                if(((RequestListener)object1) instanceof ExperimentalRequestListener) {
                }
            }
        }
    }

    private Drawable getErrorDrawable() {
        if(this.errorDrawable == null) {
            Drawable drawable0 = this.requestOptions.getErrorPlaceholder();
            this.errorDrawable = drawable0;
            if(drawable0 == null && this.requestOptions.getErrorId() > 0) {
                this.errorDrawable = this.loadDrawable(this.requestOptions.getErrorId());
            }
        }
        return this.errorDrawable;
    }

    private Drawable getFallbackDrawable() {
        if(this.fallbackDrawable == null) {
            Drawable drawable0 = this.requestOptions.getFallbackDrawable();
            this.fallbackDrawable = drawable0;
            if(drawable0 == null && this.requestOptions.getFallbackId() > 0) {
                this.fallbackDrawable = this.loadDrawable(this.requestOptions.getFallbackId());
            }
        }
        return this.fallbackDrawable;
    }

    @Override  // com.bumptech.glide.request.ResourceCallback
    public Object getLock() {
        this.stateVerifier.throwIfRecycled();
        return this.requestLock;
    }

    private Drawable getPlaceholderDrawable() {
        if(this.placeholderDrawable == null) {
            Drawable drawable0 = this.requestOptions.getPlaceholderDrawable();
            this.placeholderDrawable = drawable0;
            if(drawable0 == null && this.requestOptions.getPlaceholderId() > 0) {
                this.placeholderDrawable = this.loadDrawable(this.requestOptions.getPlaceholderId());
            }
        }
        return this.placeholderDrawable;
    }

    @Override  // com.bumptech.glide.request.Request
    public boolean isAnyResourceSet() {
        synchronized(this.requestLock) {
        }
        return this.status == Status.COMPLETE;
    }

    @Override  // com.bumptech.glide.request.Request
    public boolean isCleared() {
        synchronized(this.requestLock) {
        }
        return this.status == Status.CLEARED;
    }

    @Override  // com.bumptech.glide.request.Request
    public boolean isComplete() {
        synchronized(this.requestLock) {
        }
        return this.status == Status.COMPLETE;
    }

    @Override  // com.bumptech.glide.request.Request
    public boolean isEquivalentTo(Request request0) {
        List list0;
        if(!(request0 instanceof SingleRequest)) {
            return false;
        }
        synchronized(this.requestLock) {
        }
        synchronized(((SingleRequest)request0).requestLock) {
            list0 = ((SingleRequest)request0).requestListeners;
        }
        return this.overrideWidth == ((SingleRequest)request0).overrideWidth && this.overrideHeight == ((SingleRequest)request0).overrideHeight && Util.bothModelsNullEquivalentOrEquals(this.model, ((SingleRequest)request0).model) && this.transcodeClass.equals(((SingleRequest)request0).transcodeClass) && Util.bothBaseRequestOptionsNullEquivalentOrEquals(this.requestOptions, ((SingleRequest)request0).requestOptions) && this.priority == ((SingleRequest)request0).priority && (this.requestListeners == null ? 0 : this.requestListeners.size()) == (list0 == null ? 0 : list0.size());
    }

    private boolean isFirstReadyResource() {
        return this.requestCoordinator == null || !this.requestCoordinator.getRoot().isAnyResourceSet();
    }

    @Override  // com.bumptech.glide.request.Request
    public boolean isRunning() {
        synchronized(this.requestLock) {
        }
        return this.status == Status.RUNNING || this.status == Status.WAITING_FOR_SIZE;
    }

    private Drawable loadDrawable(int v) {
        if(this.requestOptions.getTheme() != null) {
            return DrawableDecoderCompat.getDrawable(this.context, v, this.requestOptions.getTheme());
        }
        Resources.Theme resources$Theme0 = this.context.getTheme();
        return DrawableDecoderCompat.getDrawable(this.context, v, resources$Theme0);
    }

    private void logV(String s) {
        StringBuilder stringBuilder0 = x.p(s, " this: ");
        stringBuilder0.append(this.tag);
        Log.v("GlideRequest", stringBuilder0.toString());
    }

    private static int maybeApplySizeMultiplier(int v, float f) {
        return v == 0x80000000 ? 0x80000000 : Math.round(f * ((float)v));
    }

    private void notifyRequestCoordinatorLoadFailed() {
        RequestCoordinator requestCoordinator0 = this.requestCoordinator;
        if(requestCoordinator0 != null) {
            requestCoordinator0.onRequestFailed(this);
        }
    }

    private void notifyRequestCoordinatorLoadSucceeded() {
        RequestCoordinator requestCoordinator0 = this.requestCoordinator;
        if(requestCoordinator0 != null) {
            requestCoordinator0.onRequestSuccess(this);
        }
    }

    public static SingleRequest obtain(Context context0, GlideContext glideContext0, Object object0, Object object1, Class class0, BaseRequestOptions baseRequestOptions0, int v, int v1, Priority priority0, Target target0, RequestListener requestListener0, List list0, RequestCoordinator requestCoordinator0, Engine engine0, TransitionFactory transitionFactory0, Executor executor0) {
        return new SingleRequest(context0, glideContext0, object0, object1, class0, baseRequestOptions0, v, v1, priority0, target0, requestListener0, list0, requestCoordinator0, engine0, transitionFactory0, executor0);
    }

    private void onLoadFailed(GlideException glideException0, int v) {
        boolean z1;
        this.stateVerifier.throwIfRecycled();
        synchronized(this.requestLock) {
            glideException0.setOrigin(this.requestOrigin);
            int v2 = this.glideContext.getLogLevel();
            if(v2 <= v) {
                Log.w("Glide", "Load failed for [" + this.model + "] with dimensions [" + this.width + "x" + this.height + "]", glideException0);
                if(v2 <= 4) {
                    glideException0.logRootCauses("Glide");
                }
            }
            this.loadStatus = null;
            this.status = Status.FAILED;
            this.notifyRequestCoordinatorLoadFailed();
            boolean z = true;
            this.isCallingCallbacks = true;
            try {
                List list0 = this.requestListeners;
                if(list0 == null) {
                    z1 = false;
                }
                else {
                    z1 = false;
                    for(Object object1: list0) {
                        boolean z2 = this.isFirstReadyResource();
                        z1 |= ((RequestListener)object1).onLoadFailed(glideException0, this.model, this.target, z2);
                    }
                }
                RequestListener requestListener0 = this.targetListener;
                if(requestListener0 == null) {
                    z = false;
                }
                else {
                    boolean z3 = this.isFirstReadyResource();
                    if(!requestListener0.onLoadFailed(glideException0, this.model, this.target, z3)) {
                        z = false;
                    }
                }
                if(!z1 && !z) {
                    this.setErrorPlaceholder();
                }
            }
            catch(Throwable throwable0) {
                this.isCallingCallbacks = false;
                throw throwable0;
            }
            this.isCallingCallbacks = false;
        }
    }

    @Override  // com.bumptech.glide.request.ResourceCallback
    public void onLoadFailed(GlideException glideException0) {
        this.onLoadFailed(glideException0, 5);
    }

    private void onResourceReady(Resource resource0, Object object0, DataSource dataSource0, boolean z) {
        boolean z3;
        boolean z1 = this.isFirstReadyResource();
        this.status = Status.COMPLETE;
        this.resource = resource0;
        if(this.glideContext.getLogLevel() <= 3) {
            Log.d("Glide", "Finished loading " + object0.getClass().getSimpleName() + " from " + dataSource0 + " for " + this.model + " with size [" + this.width + "x" + this.height + "] in " + LogTime.getElapsedMillis(this.startTime) + " ms");
        }
        this.notifyRequestCoordinatorLoadSucceeded();
        boolean z2 = true;
        this.isCallingCallbacks = true;
        try {
            List list0 = this.requestListeners;
            if(list0 == null) {
                z3 = false;
            }
            else {
                z3 = false;
                for(Object object1: list0) {
                    RequestListener requestListener0 = (RequestListener)object1;
                    int v1 = requestListener0.onResourceReady(object0, this.model, this.target, dataSource0, z1) | z3;
                    if(requestListener0 instanceof ExperimentalRequestListener) {
                        v1 |= ((ExperimentalRequestListener)requestListener0).onResourceReady(object0, this.model, this.target, dataSource0, z1, z);
                    }
                    z3 = v1;
                }
            }
            if(this.targetListener == null || !this.targetListener.onResourceReady(object0, this.model, this.target, dataSource0, z1)) {
                z2 = false;
            }
            if(!z2 && !z3) {
                Transition transition0 = this.animationFactory.build(dataSource0, z1);
                this.target.onResourceReady(object0, transition0);
            }
        }
        finally {
            this.isCallingCallbacks = false;
        }
    }

    @Override  // com.bumptech.glide.request.ResourceCallback
    public void onResourceReady(Resource resource0, DataSource dataSource0, boolean z) {
        Object object1;
        Object object0;
        this.stateVerifier.throwIfRecycled();
        Resource resource1 = null;
        try {
            object0 = this.requestLock;
            __monitor_enter(object0);
        }
        catch(Throwable throwable0) {
            goto label_48;
        }
        try {
            this.loadStatus = null;
            if(resource0 == null) {
                this.onLoadFailed(new GlideException("Expected to receive a Resource<R> with an object of " + this.transcodeClass + " inside, but instead got null."));
                __monitor_exit(object0);
                return;
            }
            object1 = resource0.get();
            if(object1 == null) {
                goto label_21;
            }
            else {
                Class class0 = object1.getClass();
                if(this.transcodeClass.isAssignableFrom(class0)) {
                    if(this.canSetResource()) {
                        this.onResourceReady(resource0, object1, dataSource0, z);
                        __monitor_exit(object0);
                        return;
                    }
                    goto label_17;
                }
                else {
                    goto label_21;
                }
            }
            goto label_51;
        }
        catch(Throwable throwable1) {
            goto label_45;
        }
        try {
        label_17:
            this.resource = null;
            this.status = Status.COMPLETE;
            __monitor_exit(object0);
            goto label_51;
        label_21:
            this.resource = null;
            StringBuilder stringBuilder0 = new StringBuilder("Expected to receive an object of ");
            stringBuilder0.append(this.transcodeClass);
            stringBuilder0.append(" but instead got ");
            Class class1 = object1 == null ? "" : object1.getClass();
            stringBuilder0.append(class1);
            stringBuilder0.append("{");
            stringBuilder0.append(object1);
            stringBuilder0.append("} inside Resource{");
            stringBuilder0.append(resource0);
            stringBuilder0.append("}.");
            stringBuilder0.append((object1 == null ? " To indicate failure return a null Resource object, rather than a Resource object containing null data." : ""));
            this.onLoadFailed(new GlideException(stringBuilder0.toString()));
            __monitor_exit(object0);
            goto label_51;
        }
        catch(Throwable throwable2) {
            resource1 = resource0;
            throwable1 = throwable2;
            try {
                while(true) {
                    __monitor_exit(object0);
                    break;
                label_45:
                }
            }
            catch(Throwable throwable1) {
                goto label_45;
            }
        }
        try {
            throw throwable1;
        }
        catch(Throwable throwable0) {
        label_48:
            if(resource1 != null) {
                this.engine.release(resource1);
            }
            throw throwable0;
        }
    label_51:
        this.engine.release(resource0);
    }

    @Override  // com.bumptech.glide.request.target.SizeReadyCallback
    public void onSizeReady(int v, int v1) {
        this.stateVerifier.throwIfRecycled();
        synchronized(this.requestLock) {
            boolean z = SingleRequest.IS_VERBOSE_LOGGABLE;
            if(z) {
                this.logV("Got onSizeReady in " + LogTime.getElapsedMillis(this.startTime));
            }
            if(this.status != Status.WAITING_FOR_SIZE) {
                return;
            }
            Status singleRequest$Status0 = Status.RUNNING;
            this.status = singleRequest$Status0;
            float f = this.requestOptions.getSizeMultiplier();
            this.width = SingleRequest.maybeApplySizeMultiplier(v, f);
            this.height = SingleRequest.maybeApplySizeMultiplier(v1, f);
            if(z) {
                this.logV("finished setup for calling load in " + LogTime.getElapsedMillis(this.startTime));
            }
            this.loadStatus = this.engine.load(this.glideContext, this.model, this.requestOptions.getSignature(), this.width, this.height, this.requestOptions.getResourceClass(), this.transcodeClass, this.priority, this.requestOptions.getDiskCacheStrategy(), this.requestOptions.getTransformations(), this.requestOptions.isTransformationRequired(), this.requestOptions.isScaleOnlyOrNoTransform(), this.requestOptions.getOptions(), this.requestOptions.isMemoryCacheable(), this.requestOptions.getUseUnlimitedSourceGeneratorsPool(), this.requestOptions.getUseAnimationPool(), this.requestOptions.getOnlyRetrieveFromCache(), this, this.callbackExecutor);
            if(this.status != singleRequest$Status0) {
                this.loadStatus = null;
            }
            if(z) {
                this.logV("finished onSizeReady in " + LogTime.getElapsedMillis(this.startTime));
            }
        }
    }

    @Override  // com.bumptech.glide.request.Request
    public void pause() {
        synchronized(this.requestLock) {
            if(this.isRunning()) {
                this.clear();
            }
        }
    }

    private void setErrorPlaceholder() {
        if(!this.canNotifyStatusChanged()) {
            return;
        }
        Drawable drawable0 = this.model == null ? this.getFallbackDrawable() : null;
        if(drawable0 == null) {
            drawable0 = this.getErrorDrawable();
        }
        if(drawable0 == null) {
            drawable0 = this.getPlaceholderDrawable();
        }
        this.target.onLoadFailed(drawable0);
    }

    @Override
    public String toString() {
        synchronized(this.requestLock) {
        }
        return super.toString() + "[model=" + this.model + ", transcodeClass=" + this.transcodeClass + "]";
    }
}

