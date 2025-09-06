package com.bumptech.glide.load.engine;

import U4.x;
import android.util.Log;
import b2.d;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.DiskCacheAdapter;
import com.bumptech.glide.load.engine.cache.MemoryCache.ResourceRemovedListener;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.request.ResourceCallback;
import com.bumptech.glide.util.Executors;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.pool.FactoryPools.Factory;
import com.bumptech.glide.util.pool.FactoryPools;
import java.util.Map;
import java.util.concurrent.Executor;

public class Engine implements EngineJobListener, ResourceListener, ResourceRemovedListener {
    static class DecodeJobFactory {
        private int creationOrder;
        final DiskCacheProvider diskCacheProvider;
        final d pool;

        public DecodeJobFactory(DiskCacheProvider decodeJob$DiskCacheProvider0) {
            this.pool = FactoryPools.threadSafe(150, new Factory() {
                public DecodeJob create() {
                    return new DecodeJob(DecodeJobFactory.this.diskCacheProvider, DecodeJobFactory.this.pool);
                }

                @Override  // com.bumptech.glide.util.pool.FactoryPools$Factory
                public Object create() {
                    return this.create();
                }
            });
            this.diskCacheProvider = decodeJob$DiskCacheProvider0;
        }

        public DecodeJob build(GlideContext glideContext0, Object object0, EngineKey engineKey0, Key key0, int v, int v1, Class class0, Class class1, Priority priority0, DiskCacheStrategy diskCacheStrategy0, Map map0, boolean z, boolean z1, boolean z2, Options options0, Callback decodeJob$Callback0) {
            Object object1 = Preconditions.checkNotNull(((DecodeJob)this.pool.acquire()));
            int v2 = this.creationOrder;
            this.creationOrder = v2 + 1;
            return ((DecodeJob)object1).init(glideContext0, object0, engineKey0, key0, v, v1, class0, class1, priority0, diskCacheStrategy0, map0, z, z1, z2, options0, decodeJob$Callback0, v2);
        }
    }

    static class EngineJobFactory {
        final GlideExecutor animationExecutor;
        final GlideExecutor diskCacheExecutor;
        final EngineJobListener engineJobListener;
        final d pool;
        final ResourceListener resourceListener;
        final GlideExecutor sourceExecutor;
        final GlideExecutor sourceUnlimitedExecutor;

        public EngineJobFactory(GlideExecutor glideExecutor0, GlideExecutor glideExecutor1, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, EngineJobListener engineJobListener0, ResourceListener engineResource$ResourceListener0) {
            this.pool = FactoryPools.threadSafe(150, new Factory() {
                public EngineJob create() {
                    return new EngineJob(EngineJobFactory.this.diskCacheExecutor, EngineJobFactory.this.sourceExecutor, EngineJobFactory.this.sourceUnlimitedExecutor, EngineJobFactory.this.animationExecutor, EngineJobFactory.this.engineJobListener, EngineJobFactory.this.resourceListener, EngineJobFactory.this.pool);
                }

                @Override  // com.bumptech.glide.util.pool.FactoryPools$Factory
                public Object create() {
                    return this.create();
                }
            });
            this.diskCacheExecutor = glideExecutor0;
            this.sourceExecutor = glideExecutor1;
            this.sourceUnlimitedExecutor = glideExecutor2;
            this.animationExecutor = glideExecutor3;
            this.engineJobListener = engineJobListener0;
            this.resourceListener = engineResource$ResourceListener0;
        }

        public EngineJob build(Key key0, boolean z, boolean z1, boolean z2, boolean z3) {
            return ((EngineJob)Preconditions.checkNotNull(((EngineJob)this.pool.acquire()))).init(key0, z, z1, z2, z3);
        }

        public void shutdown() {
            Executors.shutdownAndAwaitTermination(this.diskCacheExecutor);
            Executors.shutdownAndAwaitTermination(this.sourceExecutor);
            Executors.shutdownAndAwaitTermination(this.sourceUnlimitedExecutor);
            Executors.shutdownAndAwaitTermination(this.animationExecutor);
        }
    }

    static class LazyDiskCacheProvider implements DiskCacheProvider {
        private volatile DiskCache diskCache;
        private final com.bumptech.glide.load.engine.cache.DiskCache.Factory factory;

        public LazyDiskCacheProvider(com.bumptech.glide.load.engine.cache.DiskCache.Factory diskCache$Factory0) {
            this.factory = diskCache$Factory0;
        }

        public void clearDiskCacheIfCreated() {
            synchronized(this) {
                if(this.diskCache == null) {
                    return;
                }
                this.diskCache.clear();
            }
        }

        @Override  // com.bumptech.glide.load.engine.DecodeJob$DiskCacheProvider
        public DiskCache getDiskCache() {
            if(this.diskCache == null) {
                synchronized(this) {
                    if(this.diskCache == null) {
                        this.diskCache = this.factory.build();
                    }
                    if(this.diskCache == null) {
                        this.diskCache = new DiskCacheAdapter();
                    }
                }
            }
            return this.diskCache;
        }
    }

    public class LoadStatus {
        private final ResourceCallback cb;
        private final EngineJob engineJob;

        public LoadStatus(ResourceCallback resourceCallback0, EngineJob engineJob0) {
            this.cb = resourceCallback0;
            this.engineJob = engineJob0;
        }

        public void cancel() {
            synchronized(Engine.this) {
                this.engineJob.removeCallback(this.cb);
            }
        }
    }

    private static final int JOB_POOL_SIZE = 150;
    private static final String TAG = "Engine";
    private static final boolean VERBOSE_IS_LOGGABLE;
    private final ActiveResources activeResources;
    private final MemoryCache cache;
    private final DecodeJobFactory decodeJobFactory;
    private final LazyDiskCacheProvider diskCacheProvider;
    private final EngineJobFactory engineJobFactory;
    private final Jobs jobs;
    private final EngineKeyFactory keyFactory;
    private final ResourceRecycler resourceRecycler;

    static {
        Engine.VERBOSE_IS_LOGGABLE = Log.isLoggable("Engine", 2);
    }

    public Engine(MemoryCache memoryCache0, com.bumptech.glide.load.engine.cache.DiskCache.Factory diskCache$Factory0, GlideExecutor glideExecutor0, GlideExecutor glideExecutor1, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, Jobs jobs0, EngineKeyFactory engineKeyFactory0, ActiveResources activeResources0, EngineJobFactory engine$EngineJobFactory0, DecodeJobFactory engine$DecodeJobFactory0, ResourceRecycler resourceRecycler0, boolean z) {
        this.cache = memoryCache0;
        LazyDiskCacheProvider engine$LazyDiskCacheProvider0 = new LazyDiskCacheProvider(diskCache$Factory0);
        this.diskCacheProvider = engine$LazyDiskCacheProvider0;
        ActiveResources activeResources1 = activeResources0 == null ? new ActiveResources(z) : activeResources0;
        this.activeResources = activeResources1;
        activeResources1.setListener(this);
        this.keyFactory = engineKeyFactory0 == null ? new EngineKeyFactory() : engineKeyFactory0;
        if(jobs0 == null) {
            jobs0 = new Jobs();
        }
        this.jobs = jobs0;
        this.engineJobFactory = engine$EngineJobFactory0 == null ? new EngineJobFactory(glideExecutor0, glideExecutor1, glideExecutor2, glideExecutor3, this, this) : engine$EngineJobFactory0;
        this.decodeJobFactory = engine$DecodeJobFactory0 == null ? new DecodeJobFactory(engine$LazyDiskCacheProvider0) : engine$DecodeJobFactory0;
        this.resourceRecycler = resourceRecycler0 == null ? new ResourceRecycler() : resourceRecycler0;
        memoryCache0.setResourceRemovedListener(this);
    }

    public Engine(MemoryCache memoryCache0, com.bumptech.glide.load.engine.cache.DiskCache.Factory diskCache$Factory0, GlideExecutor glideExecutor0, GlideExecutor glideExecutor1, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, boolean z) {
        this(memoryCache0, diskCache$Factory0, glideExecutor0, glideExecutor1, glideExecutor2, glideExecutor3, null, null, null, null, null, null, z);
    }

    public void clearDiskCache() {
        this.diskCacheProvider.getDiskCache().clear();
    }

    private EngineResource getEngineResourceFromCache(Key key0) {
        Resource resource0 = this.cache.remove(key0);
        if(resource0 == null) {
            return null;
        }
        return resource0 instanceof EngineResource ? ((EngineResource)resource0) : new EngineResource(resource0, true, true, key0, this);
    }

    public LoadStatus load(GlideContext glideContext0, Object object0, Key key0, int v, int v1, Class class0, Class class1, Priority priority0, DiskCacheStrategy diskCacheStrategy0, Map map0, boolean z, boolean z1, Options options0, boolean z2, boolean z3, boolean z4, boolean z5, ResourceCallback resourceCallback0, Executor executor0) {
        EngineResource engineResource0;
        long v2 = Engine.VERBOSE_IS_LOGGABLE ? LogTime.getLogTime() : 0L;
        EngineKey engineKey0 = this.keyFactory.buildKey(object0, key0, v, v1, map0, class0, class1, options0);
        synchronized(this) {
            engineResource0 = this.loadFromMemory(engineKey0, z2, v2);
            if(engineResource0 == null) {
                return this.waitForExistingOrStartNewJob(glideContext0, object0, key0, v, v1, class0, class1, priority0, diskCacheStrategy0, map0, z, z1, options0, z2, z3, z4, z5, resourceCallback0, executor0, engineKey0, v2);
            }
        }
        resourceCallback0.onResourceReady(engineResource0, DataSource.MEMORY_CACHE, false);
        return null;
    }

    private EngineResource loadFromActiveResources(Key key0) {
        EngineResource engineResource0 = this.activeResources.get(key0);
        if(engineResource0 != null) {
            engineResource0.acquire();
        }
        return engineResource0;
    }

    private EngineResource loadFromCache(Key key0) {
        EngineResource engineResource0 = this.getEngineResourceFromCache(key0);
        if(engineResource0 != null) {
            engineResource0.acquire();
            this.activeResources.activate(key0, engineResource0);
        }
        return engineResource0;
    }

    private EngineResource loadFromMemory(EngineKey engineKey0, boolean z, long v) {
        if(!z) {
            return null;
        }
        EngineResource engineResource0 = this.loadFromActiveResources(engineKey0);
        if(engineResource0 != null) {
            if(Engine.VERBOSE_IS_LOGGABLE) {
                Engine.logWithTimeAndKey("Loaded resource from active resources", v, engineKey0);
            }
            return engineResource0;
        }
        EngineResource engineResource1 = this.loadFromCache(engineKey0);
        if(engineResource1 != null) {
            if(Engine.VERBOSE_IS_LOGGABLE) {
                Engine.logWithTimeAndKey("Loaded resource from cache", v, engineKey0);
            }
            return engineResource1;
        }
        return null;
    }

    private static void logWithTimeAndKey(String s, long v, Key key0) {
        StringBuilder stringBuilder0 = x.p(s, " in ");
        stringBuilder0.append(LogTime.getElapsedMillis(v));
        stringBuilder0.append("ms, key: ");
        stringBuilder0.append(key0);
        Log.v("Engine", stringBuilder0.toString());
    }

    @Override  // com.bumptech.glide.load.engine.EngineJobListener
    public void onEngineJobCancelled(EngineJob engineJob0, Key key0) {
        synchronized(this) {
            this.jobs.removeIfCurrent(key0, engineJob0);
        }
    }

    @Override  // com.bumptech.glide.load.engine.EngineJobListener
    public void onEngineJobComplete(EngineJob engineJob0, Key key0, EngineResource engineResource0) {
        synchronized(this) {
            if(engineResource0 != null && engineResource0.isMemoryCacheable()) {
                this.activeResources.activate(key0, engineResource0);
            }
            this.jobs.removeIfCurrent(key0, engineJob0);
        }
    }

    @Override  // com.bumptech.glide.load.engine.EngineResource$ResourceListener
    public void onResourceReleased(Key key0, EngineResource engineResource0) {
        this.activeResources.deactivate(key0);
        if(engineResource0.isMemoryCacheable()) {
            this.cache.put(key0, engineResource0);
            return;
        }
        this.resourceRecycler.recycle(engineResource0, false);
    }

    @Override  // com.bumptech.glide.load.engine.cache.MemoryCache$ResourceRemovedListener
    public void onResourceRemoved(Resource resource0) {
        this.resourceRecycler.recycle(resource0, true);
    }

    public void release(Resource resource0) {
        if(!(resource0 instanceof EngineResource)) {
            throw new IllegalArgumentException("Cannot release anything but an EngineResource");
        }
        ((EngineResource)resource0).release();
    }

    public void shutdown() {
        this.engineJobFactory.shutdown();
        this.diskCacheProvider.clearDiskCacheIfCreated();
        this.activeResources.shutdown();
    }

    private LoadStatus waitForExistingOrStartNewJob(GlideContext glideContext0, Object object0, Key key0, int v, int v1, Class class0, Class class1, Priority priority0, DiskCacheStrategy diskCacheStrategy0, Map map0, boolean z, boolean z1, Options options0, boolean z2, boolean z3, boolean z4, boolean z5, ResourceCallback resourceCallback0, Executor executor0, EngineKey engineKey0, long v2) {
        EngineJob engineJob0 = this.jobs.get(engineKey0, z5);
        if(engineJob0 != null) {
            engineJob0.addCallback(resourceCallback0, executor0);
            if(Engine.VERBOSE_IS_LOGGABLE) {
                Engine.logWithTimeAndKey("Added to existing load", v2, engineKey0);
            }
            return new LoadStatus(this, resourceCallback0, engineJob0);
        }
        EngineJob engineJob1 = this.engineJobFactory.build(engineKey0, z2, z3, z4, z5);
        DecodeJob decodeJob0 = this.decodeJobFactory.build(glideContext0, object0, engineKey0, key0, v, v1, class0, class1, priority0, diskCacheStrategy0, map0, z, z1, z5, options0, engineJob1);
        this.jobs.put(engineKey0, engineJob1);
        engineJob1.addCallback(resourceCallback0, executor0);
        engineJob1.start(decodeJob0);
        if(Engine.VERBOSE_IS_LOGGABLE) {
            Engine.logWithTimeAndKey("Started new load", v2, engineKey0);
        }
        return new LoadStatus(this, resourceCallback0, engineJob1);
    }
}

