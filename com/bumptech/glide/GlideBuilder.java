package com.bumptech.glide;

import android.content.Context;
import android.os.Build.VERSION;
import androidx.collection.f;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPoolAdapter;
import com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.load.engine.cache.DiskCache.Factory;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.DefaultConnectivityMonitorFactory;
import com.bumptech.glide.manager.RequestManagerRetriever.RequestManagerFactory;
import com.bumptech.glide.manager.RequestManagerRetriever;
import com.bumptech.glide.module.AppGlideModule;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class GlideBuilder {
    static final class EnableImageDecoderForBitmaps implements Experiment {
    }

    public static final class LogRequestOrigins implements Experiment {
    }

    static final class ManualOverrideHardwareBitmapMaxFdCount implements Experiment {
        final int fdCount;

        public ManualOverrideHardwareBitmapMaxFdCount(int v) {
            this.fdCount = v;
        }
    }

    private GlideExecutor animationExecutor;
    private ArrayPool arrayPool;
    private BitmapPool bitmapPool;
    private ConnectivityMonitorFactory connectivityMonitorFactory;
    private List defaultRequestListeners;
    private RequestOptionsFactory defaultRequestOptionsFactory;
    private final Map defaultTransitionOptions;
    private GlideExecutor diskCacheExecutor;
    private Factory diskCacheFactory;
    private Engine engine;
    private final Builder glideExperimentsBuilder;
    private boolean isActiveResourceRetentionAllowed;
    private int logLevel;
    private MemoryCache memoryCache;
    private MemorySizeCalculator memorySizeCalculator;
    private RequestManagerFactory requestManagerFactory;
    private GlideExecutor sourceExecutor;

    public GlideBuilder() {
        this.defaultTransitionOptions = new f(0);  // 初始化器: Landroidx/collection/V;-><init>(I)V
        this.glideExperimentsBuilder = new Builder();
        this.logLevel = 4;
        this.defaultRequestOptionsFactory = new RequestOptionsFactory() {
            @Override  // com.bumptech.glide.Glide$RequestOptionsFactory
            public RequestOptions build() {
                return new RequestOptions();
            }
        };
    }

    public GlideBuilder addGlobalRequestListener(RequestListener requestListener0) {
        if(this.defaultRequestListeners == null) {
            this.defaultRequestListeners = new ArrayList();
        }
        this.defaultRequestListeners.add(requestListener0);
        return this;
    }

    public Glide build(Context context0, List list0, AppGlideModule appGlideModule0) {
        if(this.sourceExecutor == null) {
            this.sourceExecutor = GlideExecutor.newSourceExecutor();
        }
        if(this.diskCacheExecutor == null) {
            this.diskCacheExecutor = GlideExecutor.newDiskCacheExecutor();
        }
        if(this.animationExecutor == null) {
            this.animationExecutor = GlideExecutor.newAnimationExecutor();
        }
        if(this.memorySizeCalculator == null) {
            this.memorySizeCalculator = new com.bumptech.glide.load.engine.cache.MemorySizeCalculator.Builder(context0).build();
        }
        if(this.connectivityMonitorFactory == null) {
            this.connectivityMonitorFactory = new DefaultConnectivityMonitorFactory();
        }
        if(this.bitmapPool == null) {
            int v = this.memorySizeCalculator.getBitmapPoolSize();
            this.bitmapPool = v > 0 ? new LruBitmapPool(((long)v)) : new BitmapPoolAdapter();
        }
        if(this.arrayPool == null) {
            this.arrayPool = new LruArrayPool(this.memorySizeCalculator.getArrayPoolSizeInBytes());
        }
        if(this.memoryCache == null) {
            this.memoryCache = new LruResourceCache(((long)this.memorySizeCalculator.getMemoryCacheSize()));
        }
        if(this.diskCacheFactory == null) {
            this.diskCacheFactory = new InternalCacheDiskCacheFactory(context0);
        }
        if(this.engine == null) {
            this.engine = new Engine(this.memoryCache, this.diskCacheFactory, this.diskCacheExecutor, this.sourceExecutor, GlideExecutor.newUnlimitedSourceExecutor(), this.animationExecutor, this.isActiveResourceRetentionAllowed);
        }
        List list1 = this.defaultRequestListeners;
        this.defaultRequestListeners = list1 == null ? Collections.EMPTY_LIST : Collections.unmodifiableList(list1);
        GlideExperiments glideExperiments0 = this.glideExperimentsBuilder.build();
        RequestManagerRetriever requestManagerRetriever0 = new RequestManagerRetriever(this.requestManagerFactory);
        return new Glide(context0, this.engine, this.memoryCache, this.bitmapPool, this.arrayPool, requestManagerRetriever0, this.connectivityMonitorFactory, this.logLevel, this.defaultRequestOptionsFactory, this.defaultTransitionOptions, this.defaultRequestListeners, list0, appGlideModule0, glideExperiments0);
    }

    public GlideBuilder setAnimationExecutor(GlideExecutor glideExecutor0) {
        this.animationExecutor = glideExecutor0;
        return this;
    }

    public GlideBuilder setArrayPool(ArrayPool arrayPool0) {
        this.arrayPool = arrayPool0;
        return this;
    }

    public GlideBuilder setBitmapPool(BitmapPool bitmapPool0) {
        this.bitmapPool = bitmapPool0;
        return this;
    }

    public GlideBuilder setConnectivityMonitorFactory(ConnectivityMonitorFactory connectivityMonitorFactory0) {
        this.connectivityMonitorFactory = connectivityMonitorFactory0;
        return this;
    }

    public GlideBuilder setDefaultRequestOptions(RequestOptionsFactory glide$RequestOptionsFactory0) {
        this.defaultRequestOptionsFactory = (RequestOptionsFactory)Preconditions.checkNotNull(glide$RequestOptionsFactory0);
        return this;
    }

    public GlideBuilder setDefaultRequestOptions(RequestOptions requestOptions0) {
        return this.setDefaultRequestOptions(new RequestOptionsFactory() {
            @Override  // com.bumptech.glide.Glide$RequestOptionsFactory
            public RequestOptions build() {
                return requestOptions0 == null ? new RequestOptions() : requestOptions0;
            }
        });
    }

    public GlideBuilder setDefaultTransitionOptions(Class class0, TransitionOptions transitionOptions0) {
        this.defaultTransitionOptions.put(class0, transitionOptions0);
        return this;
    }

    @Deprecated
    public GlideBuilder setDisableHardwareBitmapsOnO(boolean z) {
        return this;
    }

    public GlideBuilder setDiskCache(Factory diskCache$Factory0) {
        this.diskCacheFactory = diskCache$Factory0;
        return this;
    }

    public GlideBuilder setDiskCacheExecutor(GlideExecutor glideExecutor0) {
        this.diskCacheExecutor = glideExecutor0;
        return this;
    }

    public GlideBuilder setEngine(Engine engine0) {
        this.engine = engine0;
        return this;
    }

    public GlideBuilder setImageDecoderEnabledForBitmaps(boolean z) {
        EnableImageDecoderForBitmaps glideBuilder$EnableImageDecoderForBitmaps0 = new EnableImageDecoderForBitmaps();
        this.glideExperimentsBuilder.update(glideBuilder$EnableImageDecoderForBitmaps0, z && Build.VERSION.SDK_INT >= 29);
        return this;
    }

    public GlideBuilder setIsActiveResourceRetentionAllowed(boolean z) {
        this.isActiveResourceRetentionAllowed = z;
        return this;
    }

    public GlideBuilder setLogLevel(int v) {
        if(v < 2 || v > 6) {
            throw new IllegalArgumentException("Log level must be one of Log.VERBOSE, Log.DEBUG, Log.INFO, Log.WARN, or Log.ERROR");
        }
        this.logLevel = v;
        return this;
    }

    public GlideBuilder setLogRequestOrigins(boolean z) {
        LogRequestOrigins glideBuilder$LogRequestOrigins0 = new LogRequestOrigins();
        this.glideExperimentsBuilder.update(glideBuilder$LogRequestOrigins0, z);
        return this;
    }

    public GlideBuilder setMemoryCache(MemoryCache memoryCache0) {
        this.memoryCache = memoryCache0;
        return this;
    }

    public GlideBuilder setMemorySizeCalculator(com.bumptech.glide.load.engine.cache.MemorySizeCalculator.Builder memorySizeCalculator$Builder0) {
        return this.setMemorySizeCalculator(memorySizeCalculator$Builder0.build());
    }

    public GlideBuilder setMemorySizeCalculator(MemorySizeCalculator memorySizeCalculator0) {
        this.memorySizeCalculator = memorySizeCalculator0;
        return this;
    }

    public void setRequestManagerFactory(RequestManagerFactory requestManagerRetriever$RequestManagerFactory0) {
        this.requestManagerFactory = requestManagerRetriever$RequestManagerFactory0;
    }

    @Deprecated
    public GlideBuilder setResizeExecutor(GlideExecutor glideExecutor0) {
        return this.setSourceExecutor(glideExecutor0);
    }

    public GlideBuilder setSourceExecutor(GlideExecutor glideExecutor0) {
        this.sourceExecutor = glideExecutor0;
        return this;
    }
}

