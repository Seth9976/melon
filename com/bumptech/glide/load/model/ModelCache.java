package com.bumptech.glide.load.model;

import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Util;
import java.util.Queue;

public class ModelCache {
    static final class ModelKey {
        private static final Queue KEY_QUEUE;
        private int height;
        private Object model;
        private int width;

        static {
            ModelKey.KEY_QUEUE = Util.createQueue(0);
        }

        // 去混淆评级： 低(20)
        @Override
        public boolean equals(Object object0) {
            return object0 instanceof ModelKey && this.width == ((ModelKey)object0).width && this.height == ((ModelKey)object0).height && this.model.equals(((ModelKey)object0).model);
        }

        public static ModelKey get(Object object0, int v, int v1) {
            ModelKey modelCache$ModelKey0;
            synchronized(ModelKey.KEY_QUEUE) {
                modelCache$ModelKey0 = (ModelKey)ModelKey.KEY_QUEUE.poll();
            }
            if(modelCache$ModelKey0 == null) {
                modelCache$ModelKey0 = new ModelKey();
            }
            modelCache$ModelKey0.init(object0, v, v1);
            return modelCache$ModelKey0;
        }

        @Override
        public int hashCode() {
            return this.model.hashCode() + (this.height * 0x1F + this.width) * 0x1F;
        }

        private void init(Object object0, int v, int v1) {
            this.model = object0;
            this.width = v;
            this.height = v1;
        }

        public void release() {
            synchronized(ModelKey.KEY_QUEUE) {
                ModelKey.KEY_QUEUE.offer(this);
            }
        }
    }

    private static final int DEFAULT_SIZE = 0xFA;
    private final LruCache cache;

    public ModelCache() {
        this(0xFAL);
    }

    public ModelCache(long v) {
        this.cache = new LruCache(v) {
            public void onItemEvicted(ModelKey modelCache$ModelKey0, Object object0) {
                modelCache$ModelKey0.release();
            }

            @Override  // com.bumptech.glide.util.LruCache
            public void onItemEvicted(Object object0, Object object1) {
                this.onItemEvicted(((ModelKey)object0), object1);
            }
        };
    }

    public void clear() {
        this.cache.clearMemory();
    }

    public Object get(Object object0, int v, int v1) {
        ModelKey modelCache$ModelKey0 = ModelKey.get(object0, v, v1);
        Object object1 = this.cache.get(modelCache$ModelKey0);
        modelCache$ModelKey0.release();
        return object1;
    }

    public void put(Object object0, int v, int v1, Object object1) {
        ModelKey modelCache$ModelKey0 = ModelKey.get(object0, v, v1);
        this.cache.put(modelCache$ModelKey0, object1);
    }
}

