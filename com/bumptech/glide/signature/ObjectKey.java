package com.bumptech.glide.signature;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;

public final class ObjectKey implements Key {
    private final Object object;

    public ObjectKey(Object object0) {
        this.object = Preconditions.checkNotNull(object0);
    }

    // 去混淆评级： 低(20)
    @Override  // com.bumptech.glide.load.Key
    public boolean equals(Object object0) {
        return object0 instanceof ObjectKey ? this.object.equals(((ObjectKey)object0).object) : false;
    }

    @Override  // com.bumptech.glide.load.Key
    public int hashCode() {
        return this.object.hashCode();
    }

    @Override
    public String toString() {
        return "ObjectKey{object=" + this.object + '}';
    }

    @Override  // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest0) {
        messageDigest0.update(this.object.toString().getBytes(Key.CHARSET));
    }
}

