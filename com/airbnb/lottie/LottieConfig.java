package com.airbnb.lottie;

import com.airbnb.lottie.configurations.reducemotion.ReducedMotionOption;
import com.airbnb.lottie.configurations.reducemotion.SystemReducedMotionOption;
import com.airbnb.lottie.network.LottieNetworkCacheProvider;
import com.airbnb.lottie.network.LottieNetworkFetcher;
import java.io.File;

public class LottieConfig {
    public static final class Builder {
        private LottieNetworkCacheProvider cacheProvider;
        private AsyncUpdates defaultAsyncUpdates;
        private boolean disablePathInterpolatorCache;
        private boolean enableNetworkCache;
        private boolean enableSystraceMarkers;
        private LottieNetworkFetcher networkFetcher;
        private ReducedMotionOption reducedMotionOption;

        public Builder() {
            this.enableSystraceMarkers = false;
            this.enableNetworkCache = true;
            this.disablePathInterpolatorCache = true;
            this.defaultAsyncUpdates = AsyncUpdates.AUTOMATIC;
            this.reducedMotionOption = new SystemReducedMotionOption();
        }

        public LottieConfig build() {
            return new LottieConfig(this.networkFetcher, this.cacheProvider, this.enableSystraceMarkers, this.enableNetworkCache, this.disablePathInterpolatorCache, this.defaultAsyncUpdates, this.reducedMotionOption, null);
        }

        public Builder setDefaultAsyncUpdates(AsyncUpdates asyncUpdates0) {
            this.defaultAsyncUpdates = asyncUpdates0;
            return this;
        }

        public Builder setDisablePathInterpolatorCache(boolean z) {
            this.disablePathInterpolatorCache = z;
            return this;
        }

        public Builder setEnableNetworkCache(boolean z) {
            this.enableNetworkCache = z;
            return this;
        }

        public Builder setEnableSystraceMarkers(boolean z) {
            this.enableSystraceMarkers = z;
            return this;
        }

        public Builder setNetworkCacheDir(File file0) {
            if(this.cacheProvider != null) {
                throw new IllegalStateException("There is already a cache provider!");
            }
            this.cacheProvider = new LottieNetworkCacheProvider() {
                @Override  // com.airbnb.lottie.network.LottieNetworkCacheProvider
                public File getCacheDir() {
                    if(!file0.isDirectory()) {
                        throw new IllegalArgumentException("cache file must be a directory");
                    }
                    return file0;
                }
            };
            return this;
        }

        public Builder setNetworkCacheProvider(LottieNetworkCacheProvider lottieNetworkCacheProvider0) {
            if(this.cacheProvider != null) {
                throw new IllegalStateException("There is already a cache provider!");
            }
            this.cacheProvider = new LottieNetworkCacheProvider() {
                @Override  // com.airbnb.lottie.network.LottieNetworkCacheProvider
                public File getCacheDir() {
                    File file0 = lottieNetworkCacheProvider0.getCacheDir();
                    if(!file0.isDirectory()) {
                        throw new IllegalArgumentException("cache file must be a directory");
                    }
                    return file0;
                }
            };
            return this;
        }

        public Builder setNetworkFetcher(LottieNetworkFetcher lottieNetworkFetcher0) {
            this.networkFetcher = lottieNetworkFetcher0;
            return this;
        }

        public Builder setReducedMotionOption(ReducedMotionOption reducedMotionOption0) {
            this.reducedMotionOption = reducedMotionOption0;
            return this;
        }
    }

    final LottieNetworkCacheProvider cacheProvider;
    final AsyncUpdates defaultAsyncUpdates;
    final boolean disablePathInterpolatorCache;
    final boolean enableNetworkCache;
    final boolean enableSystraceMarkers;
    final LottieNetworkFetcher networkFetcher;
    final ReducedMotionOption reducedMotionOption;

    private LottieConfig(LottieNetworkFetcher lottieNetworkFetcher0, LottieNetworkCacheProvider lottieNetworkCacheProvider0, boolean z, boolean z1, boolean z2, AsyncUpdates asyncUpdates0, ReducedMotionOption reducedMotionOption0) {
        this.networkFetcher = lottieNetworkFetcher0;
        this.cacheProvider = lottieNetworkCacheProvider0;
        this.enableSystraceMarkers = z;
        this.enableNetworkCache = z1;
        this.disablePathInterpolatorCache = z2;
        this.defaultAsyncUpdates = asyncUpdates0;
        this.reducedMotionOption = reducedMotionOption0;
    }

    public LottieConfig(LottieNetworkFetcher lottieNetworkFetcher0, LottieNetworkCacheProvider lottieNetworkCacheProvider0, boolean z, boolean z1, boolean z2, AsyncUpdates asyncUpdates0, ReducedMotionOption reducedMotionOption0, com.airbnb.lottie.LottieConfig.1 lottieConfig$10) {
        this(lottieNetworkFetcher0, lottieNetworkCacheProvider0, z, z1, z2, asyncUpdates0, reducedMotionOption0);
    }

    class com.airbnb.lottie.LottieConfig.1 {
    }

}

