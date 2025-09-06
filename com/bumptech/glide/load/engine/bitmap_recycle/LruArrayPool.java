package com.bumptech.glide.load.engine.bitmap_recycle;

import android.util.Log;
import com.bumptech.glide.util.Preconditions;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public final class LruArrayPool implements ArrayPool {
    static final class Key implements Poolable {
        private Class arrayClass;
        private final KeyPool pool;
        int size;

        public Key(KeyPool lruArrayPool$KeyPool0) {
            this.pool = lruArrayPool$KeyPool0;
        }

        @Override
        public boolean equals(Object object0) {
            return object0 instanceof Key && this.size == ((Key)object0).size && this.arrayClass == ((Key)object0).arrayClass;
        }

        @Override
        public int hashCode() {
            int v = this.size * 0x1F;
            return this.arrayClass == null ? v : v + this.arrayClass.hashCode();
        }

        public void init(int v, Class class0) {
            this.size = v;
            this.arrayClass = class0;
        }

        @Override  // com.bumptech.glide.load.engine.bitmap_recycle.Poolable
        public void offer() {
            this.pool.offer(this);
        }

        @Override
        public String toString() {
            return "Key{size=" + this.size + "array=" + this.arrayClass + '}';
        }
    }

    static final class KeyPool extends BaseKeyPool {
        public Key create() {
            return new Key(this);
        }

        @Override  // com.bumptech.glide.load.engine.bitmap_recycle.BaseKeyPool
        public Poolable create() {
            return this.create();
        }

        public Key get(int v, Class class0) {
            Key lruArrayPool$Key0 = (Key)this.get();
            lruArrayPool$Key0.init(v, class0);
            return lruArrayPool$Key0;
        }
    }

    private static final int DEFAULT_SIZE = 0x400000;
    static final int MAX_OVER_SIZE_MULTIPLE = 8;
    private static final int SINGLE_ARRAY_MAX_SIZE_DIVISOR = 2;
    private final Map adapters;
    private int currentSize;
    private final GroupedLinkedMap groupedMap;
    private final KeyPool keyPool;
    private final int maxSize;
    private final Map sortedSizes;

    public LruArrayPool() {
        this.groupedMap = new GroupedLinkedMap();
        this.keyPool = new KeyPool();
        this.sortedSizes = new HashMap();
        this.adapters = new HashMap();
        this.maxSize = 0x400000;
    }

    public LruArrayPool(int v) {
        this.groupedMap = new GroupedLinkedMap();
        this.keyPool = new KeyPool();
        this.sortedSizes = new HashMap();
        this.adapters = new HashMap();
        this.maxSize = v;
    }

    @Override  // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public void clearMemory() {
        synchronized(this) {
            this.evictToSize(0);
        }
    }

    private void decrementArrayOfSize(int v, Class class0) {
        NavigableMap navigableMap0 = this.getSizesForAdapter(class0);
        Integer integer0 = (Integer)navigableMap0.get(v);
        if(integer0 == null) {
            throw new NullPointerException("Tried to decrement empty size, size: " + v + ", this: " + this);
        }
        if(((int)integer0) == 1) {
            navigableMap0.remove(v);
            return;
        }
        navigableMap0.put(v, ((int)(((int)integer0) - 1)));
    }

    private void evict() {
        this.evictToSize(this.maxSize);
    }

    private void evictToSize(int v) {
        while(this.currentSize > v) {
            Object object0 = this.groupedMap.removeLast();
            Preconditions.checkNotNull(object0);
            ArrayAdapterInterface arrayAdapterInterface0 = this.getAdapterFromObject(object0);
            this.currentSize -= arrayAdapterInterface0.getArrayLength(object0) * arrayAdapterInterface0.getElementSizeInBytes();
            this.decrementArrayOfSize(arrayAdapterInterface0.getArrayLength(object0), object0.getClass());
            if(Log.isLoggable(arrayAdapterInterface0.getTag(), 2)) {
                Log.v(arrayAdapterInterface0.getTag(), "evicted: " + arrayAdapterInterface0.getArrayLength(object0));
            }
        }
    }

    @Override  // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public Object get(int v, Class class0) {
        synchronized(this) {
            Integer integer0 = (Integer)this.getSizesForAdapter(class0).ceilingKey(v);
            return this.getForKey((this.mayFillRequest(v, integer0) ? this.keyPool.get(((int)integer0), class0) : this.keyPool.get(v, class0)), class0);
        }
    }

    private ArrayAdapterInterface getAdapterFromObject(Object object0) {
        return this.getAdapterFromType(object0.getClass());
    }

    private ArrayAdapterInterface getAdapterFromType(Class class0) {
        ArrayAdapterInterface arrayAdapterInterface1;
        ArrayAdapterInterface arrayAdapterInterface0 = (ArrayAdapterInterface)this.adapters.get(class0);
        if(arrayAdapterInterface0 == null) {
            if(class0.equals(int[].class)) {
                arrayAdapterInterface1 = new IntegerArrayAdapter();
            }
            else if(class0.equals(byte[].class)) {
                arrayAdapterInterface1 = new ByteArrayAdapter();
            }
            else {
                throw new IllegalArgumentException("No array pool found for: " + class0.getSimpleName());
            }
            this.adapters.put(class0, arrayAdapterInterface1);
            return arrayAdapterInterface1;
        }
        return arrayAdapterInterface0;
    }

    private Object getArrayForKey(Key lruArrayPool$Key0) {
        return this.groupedMap.get(lruArrayPool$Key0);
    }

    public int getCurrentSize() {
        int v = 0;
        for(Object object0: this.sortedSizes.keySet()) {
            Class class0 = (Class)object0;
            for(Object object1: ((NavigableMap)this.sortedSizes.get(class0)).keySet()) {
                ArrayAdapterInterface arrayAdapterInterface0 = this.getAdapterFromType(class0);
                v += ((int)(((Integer)((NavigableMap)this.sortedSizes.get(class0)).get(((Integer)object1))))) * ((int)(((Integer)object1))) * arrayAdapterInterface0.getElementSizeInBytes();
            }
        }
        return v;
    }

    @Override  // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public Object getExact(int v, Class class0) {
        synchronized(this) {
            return this.getForKey(this.keyPool.get(v, class0), class0);
        }
    }

    private Object getForKey(Key lruArrayPool$Key0, Class class0) {
        ArrayAdapterInterface arrayAdapterInterface0 = this.getAdapterFromType(class0);
        Object object0 = this.getArrayForKey(lruArrayPool$Key0);
        if(object0 != null) {
            this.currentSize -= arrayAdapterInterface0.getArrayLength(object0) * arrayAdapterInterface0.getElementSizeInBytes();
            this.decrementArrayOfSize(arrayAdapterInterface0.getArrayLength(object0), class0);
        }
        if(object0 == null) {
            if(Log.isLoggable(arrayAdapterInterface0.getTag(), 2)) {
                Log.v(arrayAdapterInterface0.getTag(), "Allocated " + lruArrayPool$Key0.size + " bytes");
            }
            return arrayAdapterInterface0.newArray(lruArrayPool$Key0.size);
        }
        return object0;
    }

    private NavigableMap getSizesForAdapter(Class class0) {
        NavigableMap navigableMap0 = (NavigableMap)this.sortedSizes.get(class0);
        if(navigableMap0 == null) {
            navigableMap0 = new TreeMap();
            this.sortedSizes.put(class0, navigableMap0);
        }
        return navigableMap0;
    }

    private boolean isNoMoreThanHalfFull() {
        return this.currentSize == 0 || this.maxSize / this.currentSize >= 2;
    }

    private boolean isSmallEnoughForReuse(int v) {
        return v <= this.maxSize / 2;
    }

    private boolean mayFillRequest(int v, Integer integer0) {
        return integer0 != null && (this.isNoMoreThanHalfFull() || ((int)integer0) <= v * 8);
    }

    @Override  // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public void put(Object object0) {
        synchronized(this) {
            Class class0 = object0.getClass();
            ArrayAdapterInterface arrayAdapterInterface0 = this.getAdapterFromType(class0);
            int v1 = arrayAdapterInterface0.getArrayLength(object0);
            int v2 = arrayAdapterInterface0.getElementSizeInBytes() * v1;
            if(!this.isSmallEnoughForReuse(v2)) {
                return;
            }
            Key lruArrayPool$Key0 = this.keyPool.get(v1, class0);
            this.groupedMap.put(lruArrayPool$Key0, object0);
            NavigableMap navigableMap0 = this.getSizesForAdapter(class0);
            Integer integer0 = (Integer)navigableMap0.get(lruArrayPool$Key0.size);
            navigableMap0.put(lruArrayPool$Key0.size, ((int)(integer0 == null ? 1 : ((int)integer0) + 1)));
            this.currentSize += v2;
            this.evict();
        }
    }

    @Override  // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    @Deprecated
    public void put(Object object0, Class class0) {
        this.put(object0);
    }

    @Override  // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public void trimMemory(int v) {
        synchronized(this) {
            if(v >= 40) {
                this.clearMemory();
            }
            else if(v >= 20 || v == 15) {
                this.evictToSize(this.maxSize / 2);
            }
        }
    }
}

