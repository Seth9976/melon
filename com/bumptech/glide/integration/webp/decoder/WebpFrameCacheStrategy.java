package com.bumptech.glide.integration.webp.decoder;

public final class WebpFrameCacheStrategy {
    public static final class Builder {
        private CacheControl cacheControl;
        private int cacheSize;

        public static CacheControl access$000(Builder webpFrameCacheStrategy$Builder0) {
            return webpFrameCacheStrategy$Builder0.cacheControl;
        }

        public static int access$100(Builder webpFrameCacheStrategy$Builder0) {
            return webpFrameCacheStrategy$Builder0.cacheSize;
        }

        public WebpFrameCacheStrategy build() {
            return new WebpFrameCacheStrategy(this, null);
        }

        public Builder cacheAll() {
            this.cacheControl = CacheControl.CACHE_ALL;
            return this;
        }

        public Builder cacheAuto() {
            this.cacheControl = CacheControl.CACHE_AUTO;
            return this;
        }

        public Builder cacheControl(CacheControl webpFrameCacheStrategy$CacheControl0) {
            this.cacheControl = webpFrameCacheStrategy$CacheControl0;
            return this;
        }

        public Builder cacheLimited() {
            this.cacheControl = CacheControl.CACHE_LIMITED;
            return this;
        }

        public Builder cacheSize(int v) {
            this.cacheSize = v;
            if(v == 0) {
                this.cacheControl = CacheControl.CACHE_NONE;
                return this;
            }
            if(v == 0x7FFFFFFF) {
                this.cacheControl = CacheControl.CACHE_ALL;
                return this;
            }
            this.cacheControl = CacheControl.CACHE_LIMITED;
            return this;
        }

        public Builder noCache() {
            this.cacheControl = CacheControl.CACHE_NONE;
            return this;
        }
    }

    public static enum CacheControl {
        CACHE_NONE,
        CACHE_LIMITED,
        CACHE_AUTO,
        CACHE_ALL;

    }

    public static final WebpFrameCacheStrategy ALL;
    public static final WebpFrameCacheStrategy AUTO;
    public static final WebpFrameCacheStrategy NONE;
    private int mCacheSize;
    private CacheControl mCacheStrategy;

    static {
        WebpFrameCacheStrategy.NONE = new Builder().noCache().build();
        WebpFrameCacheStrategy.AUTO = new Builder().cacheAuto().build();
        WebpFrameCacheStrategy.ALL = new Builder().cacheAll().build();
    }

    private WebpFrameCacheStrategy(Builder webpFrameCacheStrategy$Builder0) {
        this.mCacheStrategy = Builder.access$000(webpFrameCacheStrategy$Builder0);
        this.mCacheSize = Builder.access$100(webpFrameCacheStrategy$Builder0);
    }

    public WebpFrameCacheStrategy(Builder webpFrameCacheStrategy$Builder0, com.bumptech.glide.integration.webp.decoder.WebpFrameCacheStrategy.1 webpFrameCacheStrategy$10) {
        this(webpFrameCacheStrategy$Builder0);
    }

    public boolean cacheAll() {
        return this.mCacheStrategy == CacheControl.CACHE_ALL;
    }

    public boolean cacheAuto() {
        return this.mCacheStrategy == CacheControl.CACHE_AUTO;
    }

    public CacheControl getCacheControl() {
        return this.mCacheStrategy;
    }

    public int getCacheSize() {
        return this.mCacheSize;
    }

    public boolean noCache() {
        return this.mCacheStrategy == CacheControl.CACHE_NONE;
    }

    class com.bumptech.glide.integration.webp.decoder.WebpFrameCacheStrategy.1 {
    }

}

