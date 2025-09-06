package com.bumptech.glide.load.engine;

import b2.d;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.pool.FactoryPools.Factory;
import com.bumptech.glide.util.pool.FactoryPools.Poolable;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.StateVerifier;

final class LockedResource implements Resource, Poolable {
    private static final d POOL;
    private boolean isLocked;
    private boolean isRecycled;
    private final StateVerifier stateVerifier;
    private Resource toWrap;

    static {
        LockedResource.POOL = FactoryPools.threadSafe(20, new Factory() {
            public LockedResource create() {
                return new LockedResource();
            }

            @Override  // com.bumptech.glide.util.pool.FactoryPools$Factory
            public Object create() {
                return this.create();
            }
        });
    }

    public LockedResource() {
        this.stateVerifier = StateVerifier.newInstance();
    }

    @Override  // com.bumptech.glide.load.engine.Resource
    public Object get() {
        return this.toWrap.get();
    }

    @Override  // com.bumptech.glide.load.engine.Resource
    public Class getResourceClass() {
        return this.toWrap.getResourceClass();
    }

    @Override  // com.bumptech.glide.load.engine.Resource
    public int getSize() {
        return this.toWrap.getSize();
    }

    @Override  // com.bumptech.glide.util.pool.FactoryPools$Poolable
    public StateVerifier getVerifier() {
        return this.stateVerifier;
    }

    private void init(Resource resource0) {
        this.isRecycled = false;
        this.isLocked = true;
        this.toWrap = resource0;
    }

    public static LockedResource obtain(Resource resource0) {
        LockedResource lockedResource0 = (LockedResource)Preconditions.checkNotNull(((LockedResource)LockedResource.POOL.acquire()));
        lockedResource0.init(resource0);
        return lockedResource0;
    }

    @Override  // com.bumptech.glide.load.engine.Resource
    public void recycle() {
        synchronized(this) {
            this.stateVerifier.throwIfRecycled();
            this.isRecycled = true;
            if(!this.isLocked) {
                this.toWrap.recycle();
                this.release();
            }
        }
    }

    private void release() {
        this.toWrap = null;
        LockedResource.POOL.release(this);
    }

    public void unlock() {
        synchronized(this) {
            this.stateVerifier.throwIfRecycled();
            if(this.isLocked) {
                this.isLocked = false;
                if(this.isRecycled) {
                    this.recycle();
                }
                return;
            }
        }
        throw new IllegalStateException("Already unlocked");
    }
}

