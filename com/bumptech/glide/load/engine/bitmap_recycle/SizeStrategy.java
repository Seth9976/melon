package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap.Config;
import android.graphics.Bitmap;
import com.bumptech.glide.util.Util;
import java.util.NavigableMap;

final class SizeStrategy implements LruPoolStrategy {
    static final class Key implements Poolable {
        private final KeyPool pool;
        int size;

        public Key(KeyPool sizeStrategy$KeyPool0) {
            this.pool = sizeStrategy$KeyPool0;
        }

        @Override
        public boolean equals(Object object0) {
            return object0 instanceof Key && this.size == ((Key)object0).size;
        }

        @Override
        public int hashCode() {
            return this.size;
        }

        public void init(int v) {
            this.size = v;
        }

        @Override  // com.bumptech.glide.load.engine.bitmap_recycle.Poolable
        public void offer() {
            this.pool.offer(this);
        }

        @Override
        public String toString() {
            return SizeStrategy.getBitmapString(this.size);
        }
    }

    static class KeyPool extends BaseKeyPool {
        @Override  // com.bumptech.glide.load.engine.bitmap_recycle.BaseKeyPool
        public Poolable create() {
            return this.create();
        }

        public Key create() {
            return new Key(this);
        }

        public Key get(int v) {
            Key sizeStrategy$Key0 = (Key)super.get();
            sizeStrategy$Key0.init(v);
            return sizeStrategy$Key0;
        }
    }

    private static final int MAX_SIZE_MULTIPLE = 8;
    private final GroupedLinkedMap groupedMap;
    private final KeyPool keyPool;
    private final NavigableMap sortedSizes;

    public SizeStrategy() {
        this.keyPool = new KeyPool();
        this.groupedMap = new GroupedLinkedMap();
        this.sortedSizes = new PrettyPrintTreeMap();
    }

    private void decrementBitmapOfSize(Integer integer0) {
        Integer integer1 = (Integer)this.sortedSizes.get(integer0);
        if(((int)integer1) == 1) {
            this.sortedSizes.remove(integer0);
            return;
        }
        this.sortedSizes.put(integer0, ((int)(((int)integer1) - 1)));
    }

    @Override  // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public Bitmap get(int v, int v1, Bitmap.Config bitmap$Config0) {
        int v2 = Util.getBitmapByteSize(v, v1, bitmap$Config0);
        Key sizeStrategy$Key0 = this.keyPool.get(v2);
        Integer integer0 = (Integer)this.sortedSizes.ceilingKey(v2);
        if(integer0 != null && ((int)integer0) != v2 && ((int)integer0) <= v2 * 8) {
            this.keyPool.offer(sizeStrategy$Key0);
            sizeStrategy$Key0 = this.keyPool.get(((int)integer0));
        }
        Bitmap bitmap0 = (Bitmap)this.groupedMap.get(sizeStrategy$Key0);
        if(bitmap0 != null) {
            bitmap0.reconfigure(v, v1, bitmap$Config0);
            this.decrementBitmapOfSize(integer0);
        }
        return bitmap0;
    }

    public static String getBitmapString(int v) {
        return "[" + v + "]";
    }

    private static String getBitmapString(Bitmap bitmap0) {
        return SizeStrategy.getBitmapString(Util.getBitmapByteSize(bitmap0));
    }

    @Override  // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public int getSize(Bitmap bitmap0) {
        return Util.getBitmapByteSize(bitmap0);
    }

    @Override  // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public String logBitmap(int v, int v1, Bitmap.Config bitmap$Config0) {
        return SizeStrategy.getBitmapString(Util.getBitmapByteSize(v, v1, bitmap$Config0));
    }

    @Override  // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public String logBitmap(Bitmap bitmap0) {
        return SizeStrategy.getBitmapString(bitmap0);
    }

    @Override  // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public void put(Bitmap bitmap0) {
        int v = Util.getBitmapByteSize(bitmap0);
        Key sizeStrategy$Key0 = this.keyPool.get(v);
        this.groupedMap.put(sizeStrategy$Key0, bitmap0);
        Integer integer0 = (Integer)this.sortedSizes.get(sizeStrategy$Key0.size);
        this.sortedSizes.put(sizeStrategy$Key0.size, ((int)(integer0 == null ? 1 : ((int)integer0) + 1)));
    }

    @Override  // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public Bitmap removeLast() {
        Bitmap bitmap0 = (Bitmap)this.groupedMap.removeLast();
        if(bitmap0 != null) {
            this.decrementBitmapOfSize(Util.getBitmapByteSize(bitmap0));
        }
        return bitmap0;
    }

    @Override
    public String toString() {
        return "SizeStrategy:\n  " + this.groupedMap + "\n  SortedSizes" + this.sortedSizes;
    }
}

