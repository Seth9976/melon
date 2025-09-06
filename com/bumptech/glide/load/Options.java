package com.bumptech.glide.load;

import androidx.collection.f;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import java.security.MessageDigest;

public final class Options implements Key {
    private final f values;

    public Options() {
        this.values = new CachedHashCodeArrayMap();
    }

    // 去混淆评级： 低(20)
    @Override  // com.bumptech.glide.load.Key
    public boolean equals(Object object0) {
        return object0 instanceof Options ? this.values.equals(((Options)object0).values) : false;
    }

    // 去混淆评级： 低(20)
    public Object get(Option option0) {
        return this.values.containsKey(option0) ? this.values.get(option0) : option0.getDefaultValue();
    }

    @Override  // com.bumptech.glide.load.Key
    public int hashCode() {
        return this.values.hashCode();
    }

    public void putAll(Options options0) {
        this.values.putAll(options0.values);
    }

    public Options remove(Option option0) {
        this.values.remove(option0);
        return this;
    }

    public Options set(Option option0, Object object0) {
        this.values.put(option0, object0);
        return this;
    }

    @Override
    public String toString() {
        return "Options{values=" + this.values + '}';
    }

    private static void updateDiskCacheKey(Option option0, Object object0, MessageDigest messageDigest0) {
        option0.update(object0, messageDigest0);
    }

    @Override  // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest0) {
        for(int v = 0; v < this.values.size(); ++v) {
            Options.updateDiskCacheKey(((Option)this.values.keyAt(v)), this.values.valueAt(v), messageDigest0);
        }
    }
}

