package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import java.security.MessageDigest;

final class DataCacheKey implements Key {
    private final Key signature;
    private final Key sourceKey;

    public DataCacheKey(Key key0, Key key1) {
        this.sourceKey = key0;
        this.signature = key1;
    }

    // 去混淆评级： 低(30)
    @Override  // com.bumptech.glide.load.Key
    public boolean equals(Object object0) {
        return object0 instanceof DataCacheKey && this.sourceKey.equals(((DataCacheKey)object0).sourceKey) && this.signature.equals(((DataCacheKey)object0).signature);
    }

    public Key getSourceKey() {
        return this.sourceKey;
    }

    @Override  // com.bumptech.glide.load.Key
    public int hashCode() {
        return this.signature.hashCode() + this.sourceKey.hashCode() * 0x1F;
    }

    @Override
    public String toString() {
        return "DataCacheKey{sourceKey=" + this.sourceKey + ", signature=" + this.signature + '}';
    }

    @Override  // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest0) {
        this.sourceKey.updateDiskCacheKey(messageDigest0);
        this.signature.updateDiskCacheKey(messageDigest0);
    }
}

