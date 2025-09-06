package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.Resource;

public interface MemoryCache {
    public interface ResourceRemovedListener {
        void onResourceRemoved(Resource arg1);
    }

    void clearMemory();

    long getCurrentSize();

    long getMaxSize();

    Resource put(Key arg1, Resource arg2);

    Resource remove(Key arg1);

    void setResourceRemovedListener(ResourceRemovedListener arg1);

    void setSizeMultiplier(float arg1);

    void trimMemory(int arg1);
}

