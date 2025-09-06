package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.manager.ConnectivityMonitor.ConnectivityListener;
import com.bumptech.glide.manager.ConnectivityMonitor;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.LifecycleListener;
import com.bumptech.glide.manager.RequestManagerTreeNode;
import com.bumptech.glide.manager.RequestTracker;
import com.bumptech.glide.manager.TargetTracker;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomViewTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Util;
import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class RequestManager implements ComponentCallbacks2, ModelTypes, LifecycleListener {
    static class ClearTarget extends CustomViewTarget {
        public ClearTarget(View view0) {
            super(view0);
        }

        @Override  // com.bumptech.glide.request.target.Target
        public void onLoadFailed(Drawable drawable0) {
        }

        @Override  // com.bumptech.glide.request.target.CustomViewTarget
        public void onResourceCleared(Drawable drawable0) {
        }

        @Override  // com.bumptech.glide.request.target.Target
        public void onResourceReady(Object object0, Transition transition0) {
        }
    }

    class RequestManagerConnectivityListener implements ConnectivityListener {
        private final RequestTracker requestTracker;

        public RequestManagerConnectivityListener(RequestTracker requestTracker0) {
            this.requestTracker = requestTracker0;
        }

        @Override  // com.bumptech.glide.manager.ConnectivityMonitor$ConnectivityListener
        public void onConnectivityChanged(boolean z) {
            if(z) {
                synchronized(RequestManager.this) {
                    this.requestTracker.restartRequests();
                }
            }
        }
    }

    private static final RequestOptions DECODE_TYPE_BITMAP;
    private static final RequestOptions DECODE_TYPE_GIF;
    private static final RequestOptions DOWNLOAD_ONLY_OPTIONS;
    private final Runnable addSelfToLifecycle;
    private boolean clearOnStop;
    private final ConnectivityMonitor connectivityMonitor;
    protected final Context context;
    private final CopyOnWriteArrayList defaultRequestListeners;
    protected final Glide glide;
    final Lifecycle lifecycle;
    private boolean pauseAllRequestsOnTrimMemoryModerate;
    private RequestOptions requestOptions;
    private final RequestTracker requestTracker;
    private final TargetTracker targetTracker;
    private final RequestManagerTreeNode treeNode;

    static {
        RequestManager.DECODE_TYPE_BITMAP = (RequestOptions)RequestOptions.decodeTypeOf(Bitmap.class).lock();
        RequestManager.DECODE_TYPE_GIF = (RequestOptions)RequestOptions.decodeTypeOf(GifDrawable.class).lock();
        RequestManager.DOWNLOAD_ONLY_OPTIONS = (RequestOptions)((RequestOptions)RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.DATA).priority(Priority.LOW)).skipMemoryCache(true);
    }

    public RequestManager(Glide glide0, Lifecycle lifecycle0, RequestManagerTreeNode requestManagerTreeNode0, Context context0) {
        this(glide0, lifecycle0, requestManagerTreeNode0, new RequestTracker(), glide0.getConnectivityMonitorFactory(), context0);
    }

    public RequestManager(Glide glide0, Lifecycle lifecycle0, RequestManagerTreeNode requestManagerTreeNode0, RequestTracker requestTracker0, ConnectivityMonitorFactory connectivityMonitorFactory0, Context context0) {
        this.targetTracker = new TargetTracker();
        com.bumptech.glide.RequestManager.1 requestManager$10 = new Runnable() {
            @Override
            public void run() {
                RequestManager.this.lifecycle.addListener(RequestManager.this);
            }
        };
        this.addSelfToLifecycle = requestManager$10;
        this.glide = glide0;
        this.lifecycle = lifecycle0;
        this.treeNode = requestManagerTreeNode0;
        this.requestTracker = requestTracker0;
        this.context = context0;
        ConnectivityMonitor connectivityMonitor0 = connectivityMonitorFactory0.build(context0.getApplicationContext(), new RequestManagerConnectivityListener(this, requestTracker0));
        this.connectivityMonitor = connectivityMonitor0;
        glide0.registerRequestManager(this);
        if(Util.isOnBackgroundThread()) {
            Util.postOnUiThread(requestManager$10);
        }
        else {
            lifecycle0.addListener(this);
        }
        lifecycle0.addListener(connectivityMonitor0);
        this.defaultRequestListeners = new CopyOnWriteArrayList(glide0.getGlideContext().getDefaultRequestListeners());
        this.setRequestOptions(glide0.getGlideContext().getDefaultRequestOptions());
    }

    public RequestManager addDefaultRequestListener(RequestListener requestListener0) {
        this.defaultRequestListeners.add(requestListener0);
        return this;
    }

    public RequestManager applyDefaultRequestOptions(RequestOptions requestOptions0) {
        synchronized(this) {
            this.updateRequestOptions(requestOptions0);
            return this;
        }
    }

    public RequestBuilder as(Class class0) {
        return new RequestBuilder(this.glide, this, class0, this.context);
    }

    public RequestBuilder asBitmap() {
        return this.as(Bitmap.class).apply(RequestManager.DECODE_TYPE_BITMAP);
    }

    public RequestBuilder asDrawable() {
        return this.as(Drawable.class);
    }

    public RequestBuilder asFile() {
        return this.as(File.class).apply(RequestOptions.skipMemoryCacheOf(true));
    }

    public RequestBuilder asGif() {
        return this.as(GifDrawable.class).apply(RequestManager.DECODE_TYPE_GIF);
    }

    public void clear(View view0) {
        this.clear(new ClearTarget(view0));
    }

    public void clear(Target target0) {
        if(target0 == null) {
            return;
        }
        this.untrackOrDelegate(target0);
    }

    public RequestManager clearOnStop() {
        synchronized(this) {
            this.clearOnStop = true;
        }
        return this;
    }

    private void clearRequests() {
        synchronized(this) {
            for(Object object0: this.targetTracker.getAll()) {
                this.clear(((Target)object0));
            }
            this.targetTracker.clear();
        }
    }

    public RequestBuilder download(Object object0) {
        return this.downloadOnly().load(object0);
    }

    public RequestBuilder downloadOnly() {
        return this.as(File.class).apply(RequestManager.DOWNLOAD_ONLY_OPTIONS);
    }

    public List getDefaultRequestListeners() {
        return this.defaultRequestListeners;
    }

    public RequestOptions getDefaultRequestOptions() {
        synchronized(this) {
        }
        return this.requestOptions;
    }

    public TransitionOptions getDefaultTransitionOptions(Class class0) {
        return this.glide.getGlideContext().getDefaultTransitionOptions(class0);
    }

    public boolean isPaused() {
        synchronized(this) {
        }
        return this.requestTracker.isPaused();
    }

    public RequestBuilder load(Bitmap bitmap0) {
        return this.asDrawable().load(bitmap0);
    }

    public RequestBuilder load(Drawable drawable0) {
        return this.asDrawable().load(drawable0);
    }

    public RequestBuilder load(Uri uri0) {
        return this.asDrawable().load(uri0);
    }

    public RequestBuilder load(File file0) {
        return this.asDrawable().load(file0);
    }

    public RequestBuilder load(Integer integer0) {
        return this.asDrawable().load(integer0);
    }

    public RequestBuilder load(Object object0) {
        return this.asDrawable().load(object0);
    }

    public RequestBuilder load(String s) {
        return this.asDrawable().load(s);
    }

    @Deprecated
    public RequestBuilder load(URL uRL0) {
        return this.asDrawable().load(uRL0);
    }

    public RequestBuilder load(byte[] arr_b) {
        return this.asDrawable().load(arr_b);
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

    @Override  // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration0) {
    }

    @Override  // com.bumptech.glide.manager.LifecycleListener
    public void onDestroy() {
        synchronized(this) {
            this.targetTracker.onDestroy();
            this.clearRequests();
            this.requestTracker.clearRequests();
            this.lifecycle.removeListener(this);
            this.lifecycle.removeListener(this.connectivityMonitor);
            Util.removeCallbacksOnUiThread(this.addSelfToLifecycle);
            this.glide.unregisterRequestManager(this);
        }
    }

    @Override  // android.content.ComponentCallbacks
    public void onLowMemory() {
    }

    @Override  // com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
        synchronized(this) {
            this.resumeRequests();
            this.targetTracker.onStart();
        }
    }

    @Override  // com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
        synchronized(this) {
            this.targetTracker.onStop();
            if(this.clearOnStop) {
                this.clearRequests();
            }
            else {
                this.pauseRequests();
            }
        }
    }

    @Override  // android.content.ComponentCallbacks2
    public void onTrimMemory(int v) {
        if(v == 60 && this.pauseAllRequestsOnTrimMemoryModerate) {
            this.pauseAllRequestsRecursive();
        }
    }

    public void pauseAllRequests() {
        synchronized(this) {
            this.requestTracker.pauseAllRequests();
        }
    }

    public void pauseAllRequestsRecursive() {
        synchronized(this) {
            this.pauseAllRequests();
            for(Object object0: this.treeNode.getDescendants()) {
                ((RequestManager)object0).pauseAllRequests();
            }
        }
    }

    public void pauseRequests() {
        synchronized(this) {
            this.requestTracker.pauseRequests();
        }
    }

    public void pauseRequestsRecursive() {
        synchronized(this) {
            this.pauseRequests();
            for(Object object0: this.treeNode.getDescendants()) {
                ((RequestManager)object0).pauseRequests();
            }
        }
    }

    public void resumeRequests() {
        synchronized(this) {
            this.requestTracker.resumeRequests();
        }
    }

    public void resumeRequestsRecursive() {
        synchronized(this) {
            Util.assertMainThread();
            this.resumeRequests();
            for(Object object0: this.treeNode.getDescendants()) {
                ((RequestManager)object0).resumeRequests();
            }
        }
    }

    public RequestManager setDefaultRequestOptions(RequestOptions requestOptions0) {
        synchronized(this) {
            this.setRequestOptions(requestOptions0);
            return this;
        }
    }

    public void setPauseAllRequestsOnTrimMemoryModerate(boolean z) {
        this.pauseAllRequestsOnTrimMemoryModerate = z;
    }

    public void setRequestOptions(RequestOptions requestOptions0) {
        synchronized(this) {
            this.requestOptions = (RequestOptions)((RequestOptions)requestOptions0.clone()).autoClone();
        }
    }

    @Override
    public String toString() {
        synchronized(this) {
        }
        return super.toString() + "{tracker=" + this.requestTracker + ", treeNode=" + this.treeNode + "}";
    }

    public void track(Target target0, Request request0) {
        synchronized(this) {
            this.targetTracker.track(target0);
            this.requestTracker.runRequest(request0);
        }
    }

    public boolean untrack(Target target0) {
        synchronized(this) {
            Request request0 = target0.getRequest();
            if(request0 == null) {
                return true;
            }
            if(this.requestTracker.clearAndRemove(request0)) {
                this.targetTracker.untrack(target0);
                target0.setRequest(null);
                return true;
            }
            return false;
        }
    }

    private void untrackOrDelegate(Target target0) {
        boolean z = this.untrack(target0);
        Request request0 = target0.getRequest();
        if(!z && !this.glide.removeFromManagers(target0) && request0 != null) {
            target0.setRequest(null);
            request0.clear();
        }
    }

    private void updateRequestOptions(RequestOptions requestOptions0) {
        synchronized(this) {
            this.requestOptions = (RequestOptions)this.requestOptions.apply(requestOptions0);
        }
    }
}

