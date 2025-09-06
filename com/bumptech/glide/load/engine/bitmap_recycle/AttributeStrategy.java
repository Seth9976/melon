package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap.Config;
import android.graphics.Bitmap;
import androidx.appcompat.app.o;
import com.bumptech.glide.util.Util;

class AttributeStrategy implements LruPoolStrategy {
    static class Key implements Poolable {
        private Bitmap.Config config;
        private int height;
        private final KeyPool pool;
        private int width;

        public Key(KeyPool attributeStrategy$KeyPool0) {
            this.pool = attributeStrategy$KeyPool0;
        }

        @Override
        public boolean equals(Object object0) {
            return object0 instanceof Key && this.width == ((Key)object0).width && this.height == ((Key)object0).height && this.config == ((Key)object0).config;
        }

        @Override
        public int hashCode() {
            int v = (this.width * 0x1F + this.height) * 0x1F;
            return this.config == null ? v : v + this.config.hashCode();
        }

        public void init(int v, int v1, Bitmap.Config bitmap$Config0) {
            this.width = v;
            this.height = v1;
            this.config = bitmap$Config0;
        }

        @Override  // com.bumptech.glide.load.engine.bitmap_recycle.Poolable
        public void offer() {
            this.pool.offer(this);
        }

        @Override
        public String toString() {
            return AttributeStrategy.getBitmapString(this.width, this.height, this.config);
        }
    }

    static class KeyPool extends BaseKeyPool {
        public Key create() {
            return new Key(this);
        }

        @Override  // com.bumptech.glide.load.engine.bitmap_recycle.BaseKeyPool
        public Poolable create() {
            return this.create();
        }

        public Key get(int v, int v1, Bitmap.Config bitmap$Config0) {
            Key attributeStrategy$Key0 = (Key)this.get();
            attributeStrategy$Key0.init(v, v1, bitmap$Config0);
            return attributeStrategy$Key0;
        }
    }

    private final GroupedLinkedMap groupedMap;
    private final KeyPool keyPool;

    public AttributeStrategy() {
        this.keyPool = new KeyPool();
        this.groupedMap = new GroupedLinkedMap();
    }

    @Override  // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public Bitmap get(int v, int v1, Bitmap.Config bitmap$Config0) {
        Key attributeStrategy$Key0 = this.keyPool.get(v, v1, bitmap$Config0);
        return (Bitmap)this.groupedMap.get(attributeStrategy$Key0);
    }

    public static String getBitmapString(int v, int v1, Bitmap.Config bitmap$Config0) {
        StringBuilder stringBuilder0 = o.t(v, v1, "[", "x", "], ");
        stringBuilder0.append(bitmap$Config0);
        return stringBuilder0.toString();
    }

    private static String getBitmapString(Bitmap bitmap0) {
        return AttributeStrategy.getBitmapString(bitmap0.getWidth(), bitmap0.getHeight(), bitmap0.getConfig());
    }

    @Override  // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public int getSize(Bitmap bitmap0) {
        return Util.getBitmapByteSize(bitmap0);
    }

    @Override  // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public String logBitmap(int v, int v1, Bitmap.Config bitmap$Config0) {
        return AttributeStrategy.getBitmapString(v, v1, bitmap$Config0);
    }

    @Override  // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public String logBitmap(Bitmap bitmap0) {
        return AttributeStrategy.getBitmapString(bitmap0);
    }

    @Override  // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public void put(Bitmap bitmap0) {
        int v = bitmap0.getWidth();
        int v1 = bitmap0.getHeight();
        Bitmap.Config bitmap$Config0 = bitmap0.getConfig();
        Key attributeStrategy$Key0 = this.keyPool.get(v, v1, bitmap$Config0);
        this.groupedMap.put(attributeStrategy$Key0, bitmap0);
    }

    @Override  // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public Bitmap removeLast() {
        return (Bitmap)this.groupedMap.removeLast();
    }

    @Override
    public String toString() {
        return "AttributeStrategy:\n  " + this.groupedMap;
    }
}

