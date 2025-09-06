package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

final class ResourceCacheKey implements Key {
    private static final LruCache RESOURCE_CLASS_BYTES;
    private final ArrayPool arrayPool;
    private final Class decodedResourceClass;
    private final int height;
    private final Options options;
    private final Key signature;
    private final Key sourceKey;
    private final Transformation transformation;
    private final int width;

    static {
        ResourceCacheKey.RESOURCE_CLASS_BYTES = new LruCache(50L);
    }

    public ResourceCacheKey(ArrayPool arrayPool0, Key key0, Key key1, int v, int v1, Transformation transformation0, Class class0, Options options0) {
        this.arrayPool = arrayPool0;
        this.sourceKey = key0;
        this.signature = key1;
        this.width = v;
        this.height = v1;
        this.transformation = transformation0;
        this.decodedResourceClass = class0;
        this.options = options0;
    }

    // 去混淆评级： 中等(60)
    @Override  // com.bumptech.glide.load.Key
    public boolean equals(Object object0) {
        return object0 instanceof ResourceCacheKey && this.height == ((ResourceCacheKey)object0).height && this.width == ((ResourceCacheKey)object0).width && Util.bothNullOrEqual(this.transformation, ((ResourceCacheKey)object0).transformation) && this.decodedResourceClass.equals(((ResourceCacheKey)object0).decodedResourceClass) && this.sourceKey.equals(((ResourceCacheKey)object0).sourceKey) && this.signature.equals(((ResourceCacheKey)object0).signature) && this.options.equals(((ResourceCacheKey)object0).options);
    }

    private byte[] getResourceClassBytes() {
        LruCache lruCache0 = ResourceCacheKey.RESOURCE_CLASS_BYTES;
        byte[] arr_b = (byte[])lruCache0.get(this.decodedResourceClass);
        if(arr_b == null) {
            arr_b = this.decodedResourceClass.getName().getBytes(Key.CHARSET);
            lruCache0.put(this.decodedResourceClass, arr_b);
        }
        return arr_b;
    }

    @Override  // com.bumptech.glide.load.Key
    public int hashCode() {
        int v = ((this.signature.hashCode() + this.sourceKey.hashCode() * 0x1F) * 0x1F + this.width) * 0x1F + this.height;
        Transformation transformation0 = this.transformation;
        if(transformation0 != null) {
            v = v * 0x1F + transformation0.hashCode();
        }
        return this.options.hashCode() + (this.decodedResourceClass.hashCode() + v * 0x1F) * 0x1F;
    }

    @Override
    public String toString() {
        return "ResourceCacheKey{sourceKey=" + this.sourceKey + ", signature=" + this.signature + ", width=" + this.width + ", height=" + this.height + ", decodedResourceClass=" + this.decodedResourceClass + ", transformation=\'" + this.transformation + "\', options=" + this.options + '}';
    }

    @Override  // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest0) {
        byte[] arr_b = (byte[])this.arrayPool.getExact(8, byte[].class);
        ByteBuffer.wrap(arr_b).putInt(this.width).putInt(this.height).array();
        this.signature.updateDiskCacheKey(messageDigest0);
        this.sourceKey.updateDiskCacheKey(messageDigest0);
        messageDigest0.update(arr_b);
        Transformation transformation0 = this.transformation;
        if(transformation0 != null) {
            transformation0.updateDiskCacheKey(messageDigest0);
        }
        this.options.updateDiskCacheKey(messageDigest0);
        messageDigest0.update(this.getResourceClassBytes());
        this.arrayPool.put(arr_b);
    }
}

