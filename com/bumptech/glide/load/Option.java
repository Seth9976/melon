package com.bumptech.glide.load;

import U4.x;
import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;

public final class Option {
    public interface CacheKeyUpdater {
        void update(byte[] arg1, Object arg2, MessageDigest arg3);
    }

    private static final CacheKeyUpdater EMPTY_UPDATER;
    private final CacheKeyUpdater cacheKeyUpdater;
    private final Object defaultValue;
    private final String key;
    private volatile byte[] keyBytes;

    static {
        Option.EMPTY_UPDATER = new CacheKeyUpdater() {
            @Override  // com.bumptech.glide.load.Option$CacheKeyUpdater
            public void update(byte[] arr_b, Object object0, MessageDigest messageDigest0) {
            }
        };
    }

    private Option(String s, Object object0, CacheKeyUpdater option$CacheKeyUpdater0) {
        this.key = Preconditions.checkNotEmpty(s);
        this.defaultValue = object0;
        this.cacheKeyUpdater = (CacheKeyUpdater)Preconditions.checkNotNull(option$CacheKeyUpdater0);
    }

    public static Option disk(String s, CacheKeyUpdater option$CacheKeyUpdater0) {
        return new Option(s, null, option$CacheKeyUpdater0);
    }

    public static Option disk(String s, Object object0, CacheKeyUpdater option$CacheKeyUpdater0) {
        return new Option(s, object0, option$CacheKeyUpdater0);
    }

    private static CacheKeyUpdater emptyUpdater() {
        return Option.EMPTY_UPDATER;
    }

    // 去混淆评级： 低(20)
    @Override
    public boolean equals(Object object0) {
        return object0 instanceof Option ? this.key.equals(((Option)object0).key) : false;
    }

    public Object getDefaultValue() {
        return this.defaultValue;
    }

    private byte[] getKeyBytes() {
        if(this.keyBytes == null) {
            this.keyBytes = this.key.getBytes(Key.CHARSET);
        }
        return this.keyBytes;
    }

    @Override
    public int hashCode() {
        return this.key.hashCode();
    }

    public static Option memory(String s) {
        return new Option(s, null, Option.emptyUpdater());
    }

    public static Option memory(String s, Object object0) {
        return new Option(s, object0, Option.emptyUpdater());
    }

    @Override
    public String toString() {
        return x.m(new StringBuilder("Option{key=\'"), this.key, "\'}");
    }

    public void update(Object object0, MessageDigest messageDigest0) {
        byte[] arr_b = this.getKeyBytes();
        this.cacheKeyUpdater.update(arr_b, object0, messageDigest0);
    }
}

