package com.bumptech.glide.load.engine;

import b2.d;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.request.ResourceCallback;
import com.bumptech.glide.util.Executors;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.pool.FactoryPools.Poolable;
import com.bumptech.glide.util.pool.StateVerifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

class EngineJob implements Callback, Poolable {
    class CallLoadFailed implements Runnable {
        private final ResourceCallback cb;

        public CallLoadFailed(ResourceCallback resourceCallback0) {
            this.cb = resourceCallback0;
        }

        @Override
        public void run() {
            synchronized(this.cb.getLock()) {
                synchronized(EngineJob.this) {
                    if(EngineJob.this.cbs.contains(this.cb)) {
                        EngineJob.this.callCallbackOnLoadFailed(this.cb);
                    }
                    EngineJob.this.decrementPendingCallbacks();
                }
            }
        }
    }

    class CallResourceReady implements Runnable {
        private final ResourceCallback cb;

        public CallResourceReady(ResourceCallback resourceCallback0) {
            this.cb = resourceCallback0;
        }

        @Override
        public void run() {
            synchronized(this.cb.getLock()) {
                synchronized(EngineJob.this) {
                    if(EngineJob.this.cbs.contains(this.cb)) {
                        EngineJob.this.engineResource.acquire();
                        EngineJob.this.callCallbackOnResourceReady(this.cb);
                        EngineJob.this.removeCallback(this.cb);
                    }
                    EngineJob.this.decrementPendingCallbacks();
                }
            }
        }
    }

    static class EngineResourceFactory {
        public EngineResource build(Resource resource0, boolean z, Key key0, ResourceListener engineResource$ResourceListener0) {
            return new EngineResource(resource0, z, true, key0, engineResource$ResourceListener0);
        }
    }

    static final class ResourceCallbackAndExecutor {
        final ResourceCallback cb;
        final Executor executor;

        public ResourceCallbackAndExecutor(ResourceCallback resourceCallback0, Executor executor0) {
            this.cb = resourceCallback0;
            this.executor = executor0;
        }

        // 去混淆评级： 低(20)
        @Override
        public boolean equals(Object object0) {
            return object0 instanceof ResourceCallbackAndExecutor ? this.cb.equals(((ResourceCallbackAndExecutor)object0).cb) : false;
        }

        @Override
        public int hashCode() {
            return this.cb.hashCode();
        }
    }

    static final class ResourceCallbacksAndExecutors implements Iterable {
        private final List callbacksAndExecutors;

        public ResourceCallbacksAndExecutors() {
            this(new ArrayList(2));
        }

        public ResourceCallbacksAndExecutors(List list0) {
            this.callbacksAndExecutors = list0;
        }

        public void add(ResourceCallback resourceCallback0, Executor executor0) {
            ResourceCallbackAndExecutor engineJob$ResourceCallbackAndExecutor0 = new ResourceCallbackAndExecutor(resourceCallback0, executor0);
            this.callbacksAndExecutors.add(engineJob$ResourceCallbackAndExecutor0);
        }

        public void clear() {
            this.callbacksAndExecutors.clear();
        }

        public boolean contains(ResourceCallback resourceCallback0) {
            ResourceCallbackAndExecutor engineJob$ResourceCallbackAndExecutor0 = ResourceCallbacksAndExecutors.defaultCallbackAndExecutor(resourceCallback0);
            return this.callbacksAndExecutors.contains(engineJob$ResourceCallbackAndExecutor0);
        }

        public ResourceCallbacksAndExecutors copy() {
            return new ResourceCallbacksAndExecutors(new ArrayList(this.callbacksAndExecutors));
        }

        private static ResourceCallbackAndExecutor defaultCallbackAndExecutor(ResourceCallback resourceCallback0) {
            return new ResourceCallbackAndExecutor(resourceCallback0, Executors.directExecutor());
        }

        public boolean isEmpty() {
            return this.callbacksAndExecutors.isEmpty();
        }

        @Override
        public Iterator iterator() {
            return this.callbacksAndExecutors.iterator();
        }

        public void remove(ResourceCallback resourceCallback0) {
            ResourceCallbackAndExecutor engineJob$ResourceCallbackAndExecutor0 = ResourceCallbacksAndExecutors.defaultCallbackAndExecutor(resourceCallback0);
            this.callbacksAndExecutors.remove(engineJob$ResourceCallbackAndExecutor0);
        }

        public int size() {
            return this.callbacksAndExecutors.size();
        }
    }

    private static final EngineResourceFactory DEFAULT_FACTORY;
    private final GlideExecutor animationExecutor;
    final ResourceCallbacksAndExecutors cbs;
    DataSource dataSource;
    private DecodeJob decodeJob;
    private final GlideExecutor diskCacheExecutor;
    private final EngineJobListener engineJobListener;
    EngineResource engineResource;
    private final EngineResourceFactory engineResourceFactory;
    GlideException exception;
    private boolean hasLoadFailed;
    private boolean hasResource;
    private boolean isCacheable;
    private volatile boolean isCancelled;
    private boolean isLoadedFromAlternateCacheKey;
    private Key key;
    private boolean onlyRetrieveFromCache;
    private final AtomicInteger pendingCallbacks;
    private final d pool;
    private Resource resource;
    private final ResourceListener resourceListener;
    private final GlideExecutor sourceExecutor;
    private final GlideExecutor sourceUnlimitedExecutor;
    private final StateVerifier stateVerifier;
    private boolean useAnimationPool;
    private boolean useUnlimitedSourceGeneratorPool;

    static {
        EngineJob.DEFAULT_FACTORY = new EngineResourceFactory();
    }

    public EngineJob(GlideExecutor glideExecutor0, GlideExecutor glideExecutor1, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, EngineJobListener engineJobListener0, ResourceListener engineResource$ResourceListener0, d d0) {
        this(glideExecutor0, glideExecutor1, glideExecutor2, glideExecutor3, engineJobListener0, engineResource$ResourceListener0, d0, EngineJob.DEFAULT_FACTORY);
    }

    public EngineJob(GlideExecutor glideExecutor0, GlideExecutor glideExecutor1, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, EngineJobListener engineJobListener0, ResourceListener engineResource$ResourceListener0, d d0, EngineResourceFactory engineJob$EngineResourceFactory0) {
        this.cbs = new ResourceCallbacksAndExecutors();
        this.stateVerifier = StateVerifier.newInstance();
        this.pendingCallbacks = new AtomicInteger();
        this.diskCacheExecutor = glideExecutor0;
        this.sourceExecutor = glideExecutor1;
        this.sourceUnlimitedExecutor = glideExecutor2;
        this.animationExecutor = glideExecutor3;
        this.engineJobListener = engineJobListener0;
        this.resourceListener = engineResource$ResourceListener0;
        this.pool = d0;
        this.engineResourceFactory = engineJob$EngineResourceFactory0;
    }

    public void addCallback(ResourceCallback resourceCallback0, Executor executor0) {
        synchronized(this) {
            this.stateVerifier.throwIfRecycled();
            this.cbs.add(resourceCallback0, executor0);
            if(this.hasResource) {
                this.incrementPendingCallbacks(1);
                executor0.execute(new CallResourceReady(this, resourceCallback0));
            }
            else if(this.hasLoadFailed) {
                this.incrementPendingCallbacks(1);
                executor0.execute(new CallLoadFailed(this, resourceCallback0));
            }
            else {
                Preconditions.checkArgument(!this.isCancelled, "Cannot add callbacks to a cancelled EngineJob");
            }
        }
    }

    public void callCallbackOnLoadFailed(ResourceCallback resourceCallback0) {
        try {
            resourceCallback0.onLoadFailed(this.exception);
        }
        catch(Throwable throwable0) {
            throw new CallbackException(throwable0);
        }
    }

    public void callCallbackOnResourceReady(ResourceCallback resourceCallback0) {
        try {
            resourceCallback0.onResourceReady(this.engineResource, this.dataSource, this.isLoadedFromAlternateCacheKey);
        }
        catch(Throwable throwable0) {
            throw new CallbackException(throwable0);
        }
    }

    public void cancel() {
        if(this.isDone()) {
            return;
        }
        this.isCancelled = true;
        this.decodeJob.cancel();
        this.engineJobListener.onEngineJobCancelled(this, this.key);
    }

    public void decrementPendingCallbacks() {
        EngineResource engineResource0;
        synchronized(this) {
            this.stateVerifier.throwIfRecycled();
            Preconditions.checkArgument(this.isDone(), "Not yet complete!");
            int v1 = this.pendingCallbacks.decrementAndGet();
            Preconditions.checkArgument(v1 >= 0, "Can\'t decrement below 0");
            if(v1 == 0) {
                engineResource0 = this.engineResource;
                this.release();
            }
            else {
                engineResource0 = null;
            }
        }
        if(engineResource0 != null) {
            engineResource0.release();
        }
    }

    private GlideExecutor getActiveSourceExecutor() {
        if(this.useUnlimitedSourceGeneratorPool) {
            return this.sourceUnlimitedExecutor;
        }
        return this.useAnimationPool ? this.animationExecutor : this.sourceExecutor;
    }

    @Override  // com.bumptech.glide.util.pool.FactoryPools$Poolable
    public StateVerifier getVerifier() {
        return this.stateVerifier;
    }

    public void incrementPendingCallbacks(int v) {
        synchronized(this) {
            Preconditions.checkArgument(this.isDone(), "Not yet complete!");
            if(this.pendingCallbacks.getAndAdd(v) == 0) {
                EngineResource engineResource0 = this.engineResource;
                if(engineResource0 != null) {
                    engineResource0.acquire();
                }
            }
        }
    }

    public EngineJob init(Key key0, boolean z, boolean z1, boolean z2, boolean z3) {
        synchronized(this) {
            this.key = key0;
            this.isCacheable = z;
            this.useUnlimitedSourceGeneratorPool = z1;
            this.useAnimationPool = z2;
            this.onlyRetrieveFromCache = z3;
        }
        return this;
    }

    public boolean isCancelled() {
        synchronized(this) {
        }
        return this.isCancelled;
    }

    // 去混淆评级： 低(30)
    private boolean isDone() {
        return this.hasLoadFailed || this.hasResource || this.isCancelled;
    }

    public void notifyCallbacksOfException() {
        synchronized(this) {
            this.stateVerifier.throwIfRecycled();
            if(this.isCancelled) {
                this.release();
                return;
            }
            if(!this.cbs.isEmpty()) {
                if(this.hasLoadFailed) {
                    throw new IllegalStateException("Already failed once");
                }
                this.hasLoadFailed = true;
                Key key0 = this.key;
                ResourceCallbacksAndExecutors engineJob$ResourceCallbacksAndExecutors0 = this.cbs.copy();
                this.incrementPendingCallbacks(engineJob$ResourceCallbacksAndExecutors0.size() + 1);
                this.engineJobListener.onEngineJobComplete(this, key0, null);
                for(Object object0: engineJob$ResourceCallbacksAndExecutors0) {
                    CallLoadFailed engineJob$CallLoadFailed0 = new CallLoadFailed(this, ((ResourceCallbackAndExecutor)object0).cb);
                    ((ResourceCallbackAndExecutor)object0).executor.execute(engineJob$CallLoadFailed0);
                }
                this.decrementPendingCallbacks();
                return;
            }
        }
        throw new IllegalStateException("Received an exception without any callbacks to notify");
    }

    public void notifyCallbacksOfResult() {
        synchronized(this) {
            this.stateVerifier.throwIfRecycled();
            if(this.isCancelled) {
                this.resource.recycle();
                this.release();
                return;
            }
            if(!this.cbs.isEmpty()) {
                if(this.hasResource) {
                    throw new IllegalStateException("Already have resource");
                }
                this.engineResource = this.engineResourceFactory.build(this.resource, this.isCacheable, this.key, this.resourceListener);
                this.hasResource = true;
                ResourceCallbacksAndExecutors engineJob$ResourceCallbacksAndExecutors0 = this.cbs.copy();
                this.incrementPendingCallbacks(engineJob$ResourceCallbacksAndExecutors0.size() + 1);
                this.engineJobListener.onEngineJobComplete(this, this.key, this.engineResource);
                for(Object object0: engineJob$ResourceCallbacksAndExecutors0) {
                    CallResourceReady engineJob$CallResourceReady0 = new CallResourceReady(this, ((ResourceCallbackAndExecutor)object0).cb);
                    ((ResourceCallbackAndExecutor)object0).executor.execute(engineJob$CallResourceReady0);
                }
                this.decrementPendingCallbacks();
                return;
            }
        }
        throw new IllegalStateException("Received a resource without any callbacks to notify");
    }

    @Override  // com.bumptech.glide.load.engine.DecodeJob$Callback
    public void onLoadFailed(GlideException glideException0) {
        synchronized(this) {
            this.exception = glideException0;
        }
        this.notifyCallbacksOfException();
    }

    @Override  // com.bumptech.glide.load.engine.DecodeJob$Callback
    public void onResourceReady(Resource resource0, DataSource dataSource0, boolean z) {
        synchronized(this) {
            this.resource = resource0;
            this.dataSource = dataSource0;
            this.isLoadedFromAlternateCacheKey = z;
        }
        this.notifyCallbacksOfResult();
    }

    public boolean onlyRetrieveFromCache() {
        return this.onlyRetrieveFromCache;
    }

    private void release() {
        synchronized(this) {
            if(this.key != null) {
                this.cbs.clear();
                this.key = null;
                this.engineResource = null;
                this.resource = null;
                this.hasLoadFailed = false;
                this.isCancelled = false;
                this.hasResource = false;
                this.isLoadedFromAlternateCacheKey = false;
                this.decodeJob.release(false);
                this.decodeJob = null;
                this.exception = null;
                this.dataSource = null;
                this.pool.release(this);
                return;
            }
        }
        throw new IllegalArgumentException();
    }

    public void removeCallback(ResourceCallback resourceCallback0) {
        synchronized(this) {
            this.stateVerifier.throwIfRecycled();
            this.cbs.remove(resourceCallback0);
            if(this.cbs.isEmpty()) {
                this.cancel();
                if((this.hasResource || this.hasLoadFailed) && this.pendingCallbacks.get() == 0) {
                    this.release();
                }
            }
        }
    }

    @Override  // com.bumptech.glide.load.engine.DecodeJob$Callback
    public void reschedule(DecodeJob decodeJob0) {
        this.getActiveSourceExecutor().execute(decodeJob0);
    }

    public void start(DecodeJob decodeJob0) {
        synchronized(this) {
            this.decodeJob = decodeJob0;
            (decodeJob0.willDecodeFromCache() ? this.diskCacheExecutor : this.getActiveSourceExecutor()).execute(decodeJob0);
        }
    }
}

