package com.bumptech.glide.load.engine;

import android.os.Process;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Preconditions;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

final class ActiveResources {
    interface DequeuedResourceCallback {
        void onResourceDequeued();
    }

    static final class ResourceWeakReference extends WeakReference {
        final boolean isCacheable;
        final Key key;
        Resource resource;

        public ResourceWeakReference(Key key0, EngineResource engineResource0, ReferenceQueue referenceQueue0, boolean z) {
            super(engineResource0, referenceQueue0);
            this.key = (Key)Preconditions.checkNotNull(key0);
            this.resource = !engineResource0.isMemoryCacheable() || !z ? null : ((Resource)Preconditions.checkNotNull(engineResource0.getResource()));
            this.isCacheable = engineResource0.isMemoryCacheable();
        }

        public void reset() {
            this.resource = null;
            this.clear();
        }
    }

    final Map activeEngineResources;
    private volatile DequeuedResourceCallback cb;
    private final boolean isActiveResourceRetentionAllowed;
    private volatile boolean isShutdown;
    private ResourceListener listener;
    private final Executor monitorClearedResourcesExecutor;
    private final ReferenceQueue resourceReferenceQueue;

    public ActiveResources(boolean z) {
        this(z, Executors.newSingleThreadExecutor(new com.bumptech.glide.load.engine.ActiveResources.1()));

        class com.bumptech.glide.load.engine.ActiveResources.1 implements ThreadFactory {
            @Override
            public Thread newThread(Runnable runnable0) {
                return new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Process.setThreadPriority(10);
                        runnable0.run();
                    }
                }, "glide-active-resources");
            }
        }

    }

    public ActiveResources(boolean z, Executor executor0) {
        this.activeEngineResources = new HashMap();
        this.resourceReferenceQueue = new ReferenceQueue();
        this.isActiveResourceRetentionAllowed = z;
        this.monitorClearedResourcesExecutor = executor0;
        executor0.execute(() -> while(!ActiveResources.this.isShutdown) {
            try {
                ActiveResources.this.cleanupActiveReference(((ResourceWeakReference)ActiveResources.this.resourceReferenceQueue.remove()));
                DequeuedResourceCallback activeResources$DequeuedResourceCallback0 = ActiveResources.this.cb;
                if(activeResources$DequeuedResourceCallback0 == null) {
                    continue;
                }
                activeResources$DequeuedResourceCallback0.onResourceDequeued();
            }
            catch(InterruptedException unused_ex) {
                Thread.currentThread().interrupt();
            }
        });

        class com.bumptech.glide.load.engine.ActiveResources.2 implements Runnable {
            @Override
            public void run() {
                ActiveResources.this.cleanReferenceQueue();
            }
        }

    }

    public void activate(Key key0, EngineResource engineResource0) {
        synchronized(this) {
            ResourceWeakReference activeResources$ResourceWeakReference0 = new ResourceWeakReference(key0, engineResource0, this.resourceReferenceQueue, this.isActiveResourceRetentionAllowed);
            ResourceWeakReference activeResources$ResourceWeakReference1 = (ResourceWeakReference)this.activeEngineResources.put(key0, activeResources$ResourceWeakReference0);
            if(activeResources$ResourceWeakReference1 != null) {
                activeResources$ResourceWeakReference1.reset();
            }
        }
    }

    // 检测为 Lambda 实现
    public void cleanReferenceQueue() [...]

    public void cleanupActiveReference(ResourceWeakReference activeResources$ResourceWeakReference0) {
        Resource resource0;
        synchronized(this) {
            this.activeEngineResources.remove(activeResources$ResourceWeakReference0.key);
            if(activeResources$ResourceWeakReference0.isCacheable) {
                resource0 = activeResources$ResourceWeakReference0.resource;
                if(resource0 == null) {
                    return;
                }
                goto label_9;
            }
            return;
        }
    label_9:
        EngineResource engineResource0 = new EngineResource(resource0, true, false, activeResources$ResourceWeakReference0.key, this.listener);
        this.listener.onResourceReleased(activeResources$ResourceWeakReference0.key, engineResource0);
    }

    public void deactivate(Key key0) {
        synchronized(this) {
            ResourceWeakReference activeResources$ResourceWeakReference0 = (ResourceWeakReference)this.activeEngineResources.remove(key0);
            if(activeResources$ResourceWeakReference0 != null) {
                activeResources$ResourceWeakReference0.reset();
            }
        }
    }

    public EngineResource get(Key key0) {
        synchronized(this) {
            ResourceWeakReference activeResources$ResourceWeakReference0 = (ResourceWeakReference)this.activeEngineResources.get(key0);
            if(activeResources$ResourceWeakReference0 == null) {
                return null;
            }
            EngineResource engineResource0 = (EngineResource)activeResources$ResourceWeakReference0.get();
            if(engineResource0 == null) {
                this.cleanupActiveReference(activeResources$ResourceWeakReference0);
            }
            return engineResource0;
        }
    }

    public void setDequeuedResourceCallback(DequeuedResourceCallback activeResources$DequeuedResourceCallback0) {
        this.cb = activeResources$DequeuedResourceCallback0;
    }

    public void setListener(ResourceListener engineResource$ResourceListener0) {
        synchronized(engineResource$ResourceListener0) {
            synchronized(this) {
                this.listener = engineResource$ResourceListener0;
            }
        }
    }

    public void shutdown() {
        this.isShutdown = true;
        Executor executor0 = this.monitorClearedResourcesExecutor;
        if(executor0 instanceof ExecutorService) {
            com.bumptech.glide.util.Executors.shutdownAndAwaitTermination(((ExecutorService)executor0));
        }
    }
}

