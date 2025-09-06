package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Preconditions;

class EngineResource implements Resource {
    interface ResourceListener {
        void onResourceReleased(Key arg1, EngineResource arg2);
    }

    private int acquired;
    private final boolean isMemoryCacheable;
    private final boolean isRecyclable;
    private boolean isRecycled;
    private final Key key;
    private final ResourceListener listener;
    private final Resource resource;

    public EngineResource(Resource resource0, boolean z, boolean z1, Key key0, ResourceListener engineResource$ResourceListener0) {
        this.resource = (Resource)Preconditions.checkNotNull(resource0);
        this.isMemoryCacheable = z;
        this.isRecyclable = z1;
        this.key = key0;
        this.listener = (ResourceListener)Preconditions.checkNotNull(engineResource$ResourceListener0);
    }

    public void acquire() {
        synchronized(this) {
            if(!this.isRecycled) {
                ++this.acquired;
                return;
            }
        }
        throw new IllegalStateException("Cannot acquire a recycled resource");
    }

    @Override  // com.bumptech.glide.load.engine.Resource
    public Object get() {
        return this.resource.get();
    }

    public Resource getResource() {
        return this.resource;
    }

    @Override  // com.bumptech.glide.load.engine.Resource
    public Class getResourceClass() {
        return this.resource.getResourceClass();
    }

    @Override  // com.bumptech.glide.load.engine.Resource
    public int getSize() {
        return this.resource.getSize();
    }

    public boolean isMemoryCacheable() {
        return this.isMemoryCacheable;
    }

    @Override  // com.bumptech.glide.load.engine.Resource
    public void recycle() {
        synchronized(this) {
            if(this.acquired <= 0) {
                if(this.isRecycled) {
                    throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
                }
                this.isRecycled = true;
                if(this.isRecyclable) {
                    this.resource.recycle();
                }
                return;
            }
        }
        throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
    }

    public void release() {
        synchronized(this) {
            int v1 = this.acquired;
            if(v1 > 0) {
                boolean z = true;
                this.acquired = v1 - 1;
                if(v1 - 1 != 0) {
                    z = false;
                }
                if(z) {
                    this.listener.onResourceReleased(this.key, this);
                }
                return;
            }
        }
        throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
    }

    @Override
    public String toString() {
        synchronized(this) {
        }
        return "EngineResource{isMemoryCacheable=" + this.isMemoryCacheable + ", listener=" + this.listener + ", key=" + this.key + ", acquired=" + this.acquired + ", isRecycled=" + this.isRecycled + ", resource=" + this.resource + '}';
    }
}

