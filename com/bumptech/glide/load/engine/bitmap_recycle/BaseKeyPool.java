package com.bumptech.glide.load.engine.bitmap_recycle;

import com.bumptech.glide.util.Util;
import java.util.Queue;

abstract class BaseKeyPool {
    private static final int MAX_SIZE = 20;
    private final Queue keyPool;

    public BaseKeyPool() {
        this.keyPool = Util.createQueue(20);
    }

    public abstract Poolable create();

    public Poolable get() {
        Poolable poolable0 = (Poolable)this.keyPool.poll();
        return poolable0 == null ? this.create() : poolable0;
    }

    public void offer(Poolable poolable0) {
        if(this.keyPool.size() < 20) {
            this.keyPool.offer(poolable0);
        }
    }
}

